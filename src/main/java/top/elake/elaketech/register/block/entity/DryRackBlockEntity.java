package top.elake.elaketech.register.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.register.ElakeTechBlockEntities;

/**
 * @author Elake Studio
 */
public class DryRackBlockEntity extends BlockEntity {
    /**
     * 定义物品槽位(4个)
     */
    private final ItemStackHandler inventory = new ItemStackHandler(4) {
        // 重写getStackLimit方法, 一个格子只能放一样东西
        @Override
        protected int getStackLimit(int slot, @NotNull ItemStack stack) {
            return 1;
        }
    };

    public DryRackBlockEntity(BlockPos pos, BlockState state) {
        super(ElakeTechBlockEntities.DRY_RACK.get(), pos, state);
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);

        String inv = "Inventory";
        if (tag.contains(inv)) {
            this.inventory.deserializeNBT(tag.getCompound(inv));
        } else {
            this.inventory.deserializeNBT(tag);
        }
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
                setChanged();
                return true;
            }
        }
        return false;
    }
}