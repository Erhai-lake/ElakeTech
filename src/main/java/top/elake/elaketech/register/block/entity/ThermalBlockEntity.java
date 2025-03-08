package top.elake.elaketech.register.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

/**
 * @author Qi-Month
 */
public class ThermalBlockEntity extends BlockEntity implements BlockEntityTicker<ThermalBlockEntity> {
    private final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };


    private int burnTime = 0;
    private int totalBurnTime = 0;
    private boolean isBurning = false;

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public void handleUpdateTag(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        loadAdditional(tag, registries);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> burnTime;
                case 1 -> totalBurnTime;
                case 2 -> energyStorage.getEnergyStored();
                case 3 -> energyStorage.getMaxEnergyStored();
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> burnTime = value;
                case 1 -> totalBurnTime = value;
                default -> throw new IllegalStateException("Unexpected value: " + index);
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    /**
     * 创建一个自定义的能量存储类
     */
    private class CustomEnergyStorage extends EnergyStorage {
        public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract) {
            super(capacity, maxReceive, maxExtract);
        }

        protected void setStoredEnergy(int energy) {
            this.energy = Math.max(0, Math.min(capacity, energy));
            setChanged();
            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            }
        }

        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            int energyReceived = super.receiveEnergy(maxReceive, simulate);
            if (energyReceived > 0 && !simulate) {
                setChanged();
                if (level != null && !level.isClientSide) {
                    level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
                }
            }
            return energyReceived;
        }

        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            int energyExtracted = super.extractEnergy(maxExtract, simulate);
            if (energyExtracted > 0 && !simulate) {
                setChanged();
                if (level != null && !level.isClientSide) {
                    level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
                }
            }
            return energyExtracted;
        }
    }

    /**
     * 容量: 100,000 FE
     * 最大输入: 1,000 FE/t
     * 最大输出: 1,000 FE/t
     */
    private final CustomEnergyStorage energyStorage = new CustomEnergyStorage(100000, 1000, 1000);

    public ThermalBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public IEnergyStorage getEnergyStorage(Direction direction) {
        // 允许从任何方向访问能量存储
        return energyStorage;
    }

    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    public ContainerData getContainerData() {
        return data;
    }

    @Override
    public void tick(Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull ThermalBlockEntity blockEntity) {
        if (!level.isClientSide) {
            boolean wasActive = isBurning;
            boolean energyChanged = false;

            if (isBurning) {
                int energyBefore = energyStorage.getEnergyStored();
                energyStorage.receiveEnergy(getFuelPowerOutput(), false);
                energyChanged = energyBefore != energyStorage.getEnergyStored();

                burnTime--;
                if (burnTime <= 0) {
                    isBurning = false;
                }
            }

            if (!isBurning) {
                ItemStack fuel = itemHandler.getStackInSlot(0);
                if (!fuel.isEmpty()) {
                    int burnValue = getBurnTime(fuel);
                    if (burnValue > 0 && energyStorage.getEnergyStored() < energyStorage.getMaxEnergyStored()) {
                        itemHandler.extractItem(0, 1, false);
                        burnTime = burnValue;
                        totalBurnTime = burnValue;
                        isBurning = true;
                    }
                }
            }

            if (wasActive != isBurning || energyChanged) {
                setChanged();
                level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
            }

            outputEnergy();
        }
    }

    private void outputEnergy() {
        if (level == null || level.isClientSide) {
            return;
        }

        boolean didChange = false;
        for (Direction direction : Direction.values()) {
            BlockPos targetPos = getBlockPos().relative(direction);
            IEnergyStorage targetStorage = level.getCapability(Capabilities.EnergyStorage.BLOCK,
                    targetPos, direction.getOpposite());

            if (targetStorage != null && targetStorage.canReceive()) {
                int energyBefore = energyStorage.getEnergyStored();
                int maxExtract = energyStorage.extractEnergy(1000, true);
                if (maxExtract > 0) {
                    int energyTransferred = targetStorage.receiveEnergy(maxExtract, false);
                    if (energyTransferred > 0) {
                        energyStorage.extractEnergy(energyTransferred, false);
                        if (energyStorage.getEnergyStored() != energyBefore) {
                            didChange = true;
                        }
                    }
                }
            }
        }

        if (didChange) {
            setChanged();
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_ALL);
        }
    }

    private int getBurnTime(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        }

        if (stack.is(Blocks.COAL_BLOCK.asItem())) {
            return 16000;
        } else if (stack.is(Items.COAL)) {
            return 1600;
        } else if (stack.is(Items.CHARCOAL)) {
            return 1600;
        } else if (stack.is(ItemTags.PLANKS)) {
            return 300;
        } else if (stack.is(ItemTags.LOGS)) {
            return 300;
        } else if (stack.is(ItemTags.WOODEN_SLABS)) {
            return 150;
        } else if (stack.is(Items.STICK)) {
            return 100;
        }

        return 0;
    }

    private int getFuelPowerOutput() {
        // 根据不同燃料返回不同的发电量
        ItemStack fuelType = itemHandler.getStackInSlot(0);
        // 默认发电量
        if (fuelType.isEmpty()) {
            return 100;
        }

        int burnTime = getBurnTime(fuelType);
        // 根据燃烧时间返回相应的发电量
        // 煤炭等高级燃料
        if (burnTime > 1600) {
            return 200;
        } else if (burnTime > 800) {
            // 木炭等中级燃料
            return 150;
        }
        // 木棍等低级燃料
        return 100;
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("burn_time", burnTime);
        tag.putInt("total_burn_time", totalBurnTime);
        tag.putBoolean("is_burning", isBurning);
        tag.putInt("energy", energyStorage.getEnergyStored());
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        burnTime = tag.getInt("burn_time");
        totalBurnTime = tag.getInt("total_burn_time");
        isBurning = tag.getBoolean("is_burning");
        if (tag.contains("energy")) {
            energyStorage.setStoredEnergy(tag.getInt("energy"));
        }
    }
}