package top.elake.elaketech.register.capability.boiler;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.register.block.entity.machine.BoilerBlockEntity;

public class BoilerItemHandler extends ItemStackHandler {
    private final BoilerBlockEntity blockEntity;

    public BoilerItemHandler(BoilerBlockEntity entity) {
        super(1);
        this.blockEntity = entity;
    }

    @Override
    protected void onContentsChanged(int slot) {
        super.onContentsChanged(slot);
        if (blockEntity != null) {
            blockEntity.setChanged();
        }
    }

    @Override
    public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (slot == 0) {
            // 禁止从 fuel 槽取出
            return ItemStack.EMPTY;
        }
        return super.extractItem(slot, amount, simulate);
    }

    @Override
    public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        if (slot != 0) {
            // 只能插入 slot 0
            return stack;
        }
        return super.insertItem(slot, stack, simulate);
    }
}