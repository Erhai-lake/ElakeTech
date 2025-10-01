package top.elake.elaketech.register.block.entity.machine;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
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
    private static final String BURN_TIME_REMAINING = "burnTimeRemaining";

    private int progress = 0;
    private int burnTimeRemaining = 0; // 存储当前燃料剩余燃烧时间

    private final BoilerItemHandler itemInventory = new BoilerItemHandler(this);
    private final BoilerFluidHandler fluidInventory = new BoilerFluidHandler();

    public BoilerBlockEntity(BlockPos pos, BlockState state) {
        super(ElakeTechBlockEntities.BOILER.get(), pos, state);
    }

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

        ItemStack fuel = itemInventory.getStackInSlot(0);
        FluidStack inputWater = fluidInventory.getFluidInTank(0);
        FluidStack outputSteam = fluidInventory.getFluidInTank(1);

        final int REQUIRED_WATER = 1; // 每tick需要1mb水
        final int PRODUCED_STEAM = 2; // 每tick产出2mb蒸汽
        final Fluid STEAM_PLACEHOLDER = Fluids.LAVA;

        if (burnTimeRemaining <= 0 && !fuel.isEmpty()) {
            int fuelBurnTime = fuel.getBurnTime(RecipeType.SMELTING);
            if (fuelBurnTime > 0) {
                burnTimeRemaining = fuelBurnTime;
                fuel.shrink(1);
                this.setChanged();
            }
        }

        if (burnTimeRemaining > 0) {
            boolean hasEnoughWater = inputWater.getAmount() >= REQUIRED_WATER && inputWater.is(Fluids.WATER);
            boolean canOutputSteam = outputSteam.isEmpty()
                    || (outputSteam.getFluid() == STEAM_PLACEHOLDER
                    && outputSteam.getAmount() + PRODUCED_STEAM <= fluidInventory.getTankCapacity(1));

            if (hasEnoughWater && canOutputSteam) {
                int currentWater = inputWater.getAmount();
                fluidInventory.setWaterAmount(currentWater - REQUIRED_WATER);

                int currentSteam = outputSteam.isEmpty() ? 0 : outputSteam.getAmount();
                int newSteamAmount = Math.min(currentSteam + PRODUCED_STEAM, fluidInventory.getTankCapacity(1));
                fluidInventory.setSteamAmount(STEAM_PLACEHOLDER, newSteamAmount);

                burnTimeRemaining--;
                this.setChanged();
            } else {
                burnTimeRemaining--;
                this.setChanged();
            }
        }
    }

    /**
     * 判断锅炉当前是否处于工作状态
     *
     * @return true 表示正在工作(有燃料在燃烧)
     */
    public boolean isWorking() {
        return burnTimeRemaining > 0;
    }

    public static void ticker(Level level, BlockPos pos, BlockState state, BoilerBlockEntity entity) {
        if (level.isClientSide) {
            return;
        }
        entity.tick();
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(tag, provider);
        tag.putInt(PROGRESS, progress);
        tag.putInt(BURN_TIME_REMAINING, burnTimeRemaining);
        tag.put(ITEM_INVENTORY, itemInventory.serializeNBT(provider));
        tag.put(FLUID_INVENTORY, fluidInventory.serializeNBT(provider));
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(tag, provider);
        if (tag.contains(PROGRESS)) {
            progress = tag.getInt(PROGRESS);
        }
        if (tag.contains(BURN_TIME_REMAINING)) {
            burnTimeRemaining = tag.getInt(BURN_TIME_REMAINING);
        }
        if (tag.contains(ITEM_INVENTORY)) {
            itemInventory.deserializeNBT(provider, tag.getCompound(ITEM_INVENTORY));
        }
        if (tag.contains(FLUID_INVENTORY)) {
            fluidInventory.deserializeNBT(provider, tag.getCompound(FLUID_INVENTORY));
        }
    }
}