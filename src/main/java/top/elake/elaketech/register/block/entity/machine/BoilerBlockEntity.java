package top.elake.elaketech.register.block.entity.machine;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.register.ElakeTechBlockEntities;
import top.elake.elaketech.register.capability.boiler.BoilerFluidHandler;
import top.elake.elaketech.register.capability.boiler.BoilerItemHandler;


/**
 * @author Elake Studio
 */
public class BoilerBlockEntity extends BlockEntity {
    private static final String ITEM_INVENTORY = "Inventory";
    private static final String FLUID_INVENTORY = "FluidInventory";
    private static final String PROGRESS = "progress";
    private int progress = 0;

    public BoilerBlockEntity(BlockPos pos, BlockState state) {
        super(ElakeTechBlockEntities.BOILER.get(), pos, state);
    }

    private final BoilerItemHandler itemInventory = new BoilerItemHandler();
    private final BoilerFluidHandler fluidInventory = new BoilerFluidHandler();

    public IItemHandler getInvCap(Direction side) {
        return itemInventory;
    }

    public IFluidHandler getFluidInvCap(Direction side) {
        return fluidInventory;
    }

    public void tick() {
        if (level.isClientSide()) {
            return;
        }

        // 获取燃料物品(槽0)
        ItemStack fuel = itemInventory.getStackInSlot(0);

        FluidStack inputWater = fluidInventory.getFluidInTank(0);
        FluidStack outputSteam = fluidInventory.getFluidInTank(1);

        final int REQUIRED_WATER = 100;
        final int PRODUCED_STEAM = 100;
        // 每 100 tick 出一次蒸汽
        final int BURN_TIME = 100;
        // 占位用蒸汽
        final Fluid STEAM_PLACEHOLDER = Fluids.LAVA;

        // 条件判断, 必须有燃料, 水足够, 输出槽可容纳蒸汽
        boolean hasFuel = !fuel.isEmpty();
        boolean hasEnoughWater = inputWater.getAmount() >= REQUIRED_WATER && inputWater.is(Fluids.WATER);
        boolean canOutputSteam = outputSteam.isEmpty()
                || (outputSteam.getFluid() == STEAM_PLACEHOLDER
                && outputSteam.getAmount() + PRODUCED_STEAM <= fluidInventory.getTankCapacity(1));

        if (hasFuel && hasEnoughWater && canOutputSteam) {
            // 满足开始加热
            progress++;

            if (progress >= BURN_TIME) {
                // 周期完成, 消耗资源, 输出蒸汽
                fuel.shrink(1);
                itemInventory.setStackInSlot(0, fuel);

                // 消耗水
                int currentWater = inputWater.getAmount();
                fluidInventory.setWaterAmount(currentWater - REQUIRED_WATER);

                // 生成熔岩
                int currentSteam = outputSteam.isEmpty() ? 0 : outputSteam.getAmount();
                int newSteamAmount = Math.min(currentSteam + PRODUCED_STEAM, fluidInventory.getTankCapacity(1));
                fluidInventory.setSteamAmount(STEAM_PLACEHOLDER, newSteamAmount);

                // 重置进度并标记为已更改
                progress = 0;
                this.setChanged();
            }
        } else {
            // 如果条件不满足但进度不为零, 则重置进度并标记为已更改
            if (progress != 0) {
                progress = 0;
                this.setChanged();
            }
        }
    }


    public static void ticker(Level level, BlockPos pos, BlockState state, BoilerBlockEntity entity) {
        if (level.isClientSide()) {
            return;
        }
        entity.tick();
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(tag, provider);

        tag.putInt(PROGRESS, progress);
        tag.put(ITEM_INVENTORY, itemInventory.serializeNBT(provider));
        tag.put(FLUID_INVENTORY, fluidInventory.serializeNBT(provider));
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(tag, provider);

        if (tag.contains(PROGRESS)) {
            progress = tag.getInt(PROGRESS);
        }
        if (tag.contains(ITEM_INVENTORY)) {
            itemInventory.deserializeNBT(provider, tag.getCompound(ITEM_INVENTORY));
        }
        if (tag.contains(FLUID_INVENTORY)) {
            fluidInventory.deserializeNBT(provider, tag.getCompound(FLUID_INVENTORY));
        }
    }
}