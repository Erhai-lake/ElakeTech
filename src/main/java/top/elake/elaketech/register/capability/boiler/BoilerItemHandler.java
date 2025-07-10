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
     * @param slot     要抽取的槽位索引
     * @param amount   请求抽取的物品数量
     * @param simulate 如果为 true, 则为模拟操作, 不会真正改变物品数量
     * @return 实际抽取的物品堆, 如果不允许抽取则返回空堆
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
     * @param slot     要插入的槽位索引
     * @param stack    要插入的物品堆
     * @param simulate 如果为 true, 则为模拟操作, 不会真正插入物品
     * @return 未被插入的剩余物品堆, 如果插入成功则可能返回空堆
     */
    @Override
    public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        if (slot != 0) {
            return stack;
        }
        return super.insertItem(slot, stack, simulate);
    }
}