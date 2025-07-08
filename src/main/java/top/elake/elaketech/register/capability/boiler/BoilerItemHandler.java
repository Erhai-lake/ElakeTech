package top.elake.elaketech.register.capability.boiler;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

/**
 * @author Elake Studio
 */
public class BoilerItemHandler extends ItemStackHandler {
    public BoilerItemHandler() {
        super(1);
    }

    /**
     * 抽取物品
     *
     * @param slot
     * @param amount
     * @param simulate
     * @return
     */
    @Override
    public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (slot == 0) {
            return ItemStack.EMPTY;
        }
        return super.extractItem(slot, amount, simulate);
    }

    /**
     * 输入物品
     *
     * @param slot
     * @param stack
     * @param simulate
     * @return
     */
    @Override
    public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        if (slot == 1) {
            return stack;
        }
        return super.insertItem(slot, stack, simulate);
    }
}