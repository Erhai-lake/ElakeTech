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
    private BoilerBlockEntity entity;

    public BoilerBlockEntity(BlockPos pos, BlockState state) {
        super(ElakeTechBlockEntities.BOILER.get(), pos, state);
    }

    private final BoilerItemHandler itemInventory = new BoilerItemHandler(entity);
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

        ItemStack fuel = itemInventory.getStackInSlot(0);
        FluidStack inputWater = fluidInventory.getFluidInTank(0);
        FluidStack outputSteam = fluidInventory.getFluidInTank(1);

        final int REQUIRED_WATER = 100;
        final int PRODUCED_STEAM = 100;
        final int BURN_TIME = 100;
        final Fluid STEAM_PLACEHOLDER = Fluids.LAVA;

        boolean hasFuel = !fuel.isEmpty();
        boolean hasEnoughWater = inputWater.getAmount() >= REQUIRED_WATER && inputWater.is(Fluids.WATER);
        boolean canOutputSteam = outputSteam.isEmpty()
                || (outputSteam.getFluid() == STEAM_PLACEHOLDER
                && outputSteam.getAmount() + PRODUCED_STEAM <= fluidInventory.getTankCapacity(1));

        if (hasFuel && hasEnoughWater && canOutputSteam) {
            progress++;
            if (progress >= BURN_TIME) {
                fuel.shrink(1);
                itemInventory.setStackInSlot(0, fuel);

                int currentWater = inputWater.getAmount();
                fluidInventory.setWaterAmount(currentWater - REQUIRED_WATER);

                int currentSteam = outputSteam.isEmpty() ? 0 : outputSteam.getAmount();
                int newSteamAmount = Math.min(currentSteam + PRODUCED_STEAM, fluidInventory.getTankCapacity(1));
                fluidInventory.setSteamAmount(STEAM_PLACEHOLDER, newSteamAmount);

                progress = 0;
                this.setChanged();
            }
        } else {
            if (progress != 0) {
                progress = 0;
                this.setChanged();
            }
        }
    }

    /**
     * 判断锅炉当前是否处于工作状态
     *
     * @return true 表示正在工作(有燃料、水够、输出槽可容纳蒸汽)
     */
    public boolean isWorking() {
        ItemStack fuel = itemInventory.getStackInSlot(0);
        FluidStack inputWater = fluidInventory.getFluidInTank(0);
        FluidStack outputSteam = fluidInventory.getFluidInTank(1);

        final int REQUIRED_WATER = 100;
        final int PRODUCED_STEAM = 100;
        final Fluid STEAM_PLACEHOLDER = Fluids.LAVA;

        boolean hasFuel = !fuel.isEmpty();
        boolean hasEnoughWater = inputWater.getAmount() >= REQUIRED_WATER && inputWater.is(Fluids.WATER);
        boolean canOutputSteam = outputSteam.isEmpty()
                || (outputSteam.getFluid() == STEAM_PLACEHOLDER
                && outputSteam.getAmount() + PRODUCED_STEAM <= fluidInventory.getTankCapacity(1));

        return hasFuel && hasEnoughWater && canOutputSteam;
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