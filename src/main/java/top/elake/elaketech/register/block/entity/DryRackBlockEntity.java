package top.elake.elaketech.register.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.elake.elaketech.register.ElakeTechBlockEntities;

/**
 * @author Elake Studio
 */
public class DryRackBlockEntity extends BlockEntity {
    private static final String INVENTORY_TAG = "Inventory";
    /**
     * 定义物品槽位(4个)
     */
    private final ItemStackHandler inventory = new ItemStackHandler(4) {
        @Override
        public int getStackLimit(int slot, @NotNull ItemStack stack) {
            return 1;
        }
        
        @Override
        protected void onContentsChanged(int slot) {
            DryRackBlockEntity.this.setChanged();
        }
    };

    public DryRackBlockEntity(BlockPos pos, BlockState state) {
        super(ElakeTechBlockEntities.DRY_RACK.get(), pos, state);
    }

    /**
     * 重写loadAdditional方法
     *
     * @param tag
     * @param provider
     */
    @Override
    public void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(tag, provider);

        if (tag.contains(INVENTORY_TAG)) {
            this.inventory.deserializeNBT(provider, tag.getCompound(INVENTORY_TAG));
        } else {
            this.inventory.deserializeNBT(provider, tag);
        }
    }

    /**
     * 写入物品
     *
     * @param tag
     * @param provider
     * @return
     */
    public CompoundTag writeItems(CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(tag, provider);

        tag.put(INVENTORY_TAG, this.inventory.serializeNBT(provider));
        return tag;
    }

    /**
     * 重写saveAdditional方法, 用于保存
     *
     * @param tag
     * @param provider
     */
    @Override
    public void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(tag, provider);
        tag.put(INVENTORY_TAG, this.inventory.serializeNBT(provider));
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider provider) {
        return this.writeItems(new CompoundTag(), provider);
    }

    /**
     * 添加物品
     */
    public boolean addItem(ItemStack itemStack) {
        for (int i = 0; i < this.inventory.getSlots(); i++) {
            ItemStack stack = this.inventory.getStackInSlot(i);
            // 如果槽位是空的
            if (stack.isEmpty()) {
                // 放入Item
                this.inventory.setStackInSlot(i, itemStack.split(1));
                return true;
            }
        }
        return false;
    }

    /**
     * 取出物品
     * @return 取出的物品，如果没有物品则返回空ItemStack
     */
    public ItemStack removeItem() {
        for (int i = this.inventory.getSlots() - 1; i >= 0; i--) {
            ItemStack stack = this.inventory.getStackInSlot(i);
            if (!stack.isEmpty()) {
                ItemStack removed = stack.copy();
                this.inventory.setStackInSlot(i, ItemStack.EMPTY);
                return removed;
            }
        }
        return ItemStack.EMPTY;
    }

    /**
     * 检查是否有物品
     * @return 如果有物品返回true，否则返回false
     */
    public boolean hasItems() {
        for (int i = 0; i < this.inventory.getSlots(); i++) {
            if (!this.inventory.getStackInSlot(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public ItemStackHandler getInventory() {
        return this.inventory;
    }

    public Vec2 getItemOffset(int i) {
        float x = 0.2f;
        float y = 0.2f;

        Vec2[] offest = new Vec2[] {
                new Vec2(x, y), new Vec2(-x, y),
                new Vec2(x, -y), new Vec2(-x, -y)
        };
        return offest[i];
    }

    /**
     * 更新方块
     *
     * @return
     */
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(@NotNull Connection net, @NotNull ClientboundBlockEntityDataPacket packet, HolderLookup.@NotNull Provider provider) {
        CompoundTag tag = packet.getTag();
        if (tag != null) {
            this.loadAdditional(tag, provider);
        }
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(
                    this.getBlockPos(),
                    this.getBlockState(),
                    this.getBlockState(),
                    Block.UPDATE_CLIENTS
            );
        }
    }
}