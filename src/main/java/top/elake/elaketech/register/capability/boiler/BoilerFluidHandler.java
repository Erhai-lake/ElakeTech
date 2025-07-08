package top.elake.elaketech.register.capability.boiler;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

/**
 * @author Elake Studio
 */
public class BoilerFluidHandler implements IFluidHandler, INBTSerializable<CompoundTag> {
    /**
     * 定义两个流体槽位(1个输入[Water]一个输出[Steam])
     */
    public NonNullList<FluidStack> fluids = NonNullList.withSize(2, FluidStack.EMPTY);

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.@NotNull Provider provider) {
        return null;
    }

    @Override
    public void deserializeNBT(HolderLookup.@NotNull Provider provider, @NotNull CompoundTag tag) {

    }

    /**
     * 返回实际的槽位数量
     *
     * @return
     */
    @Override
    public int getTanks() {
        return fluids.size();
    }

    /**
     * 获取指定槽位中当前存储的流体信息
     *
     * @param tank 要查询的槽位索引
     * @return
     */
    @Override
    public @NotNull FluidStack getFluidInTank(int tank) {
        return fluids.get(tank);
    }

    public void setFluidInTank(int i, FluidStack stack) {
        fluids.set(i, stack);
    }


    /**
     * 设置流体槽位容量
     *
     * @param amount 容量(mb)
     * @return
     */
    @Override
    public int getTankCapacity(int amount) {
        return 10000;
    }

    /**
     * 检查指定流体是否可以被填充到指定槽位。
     * <p>
     * 该方法用于确定某种流体是否被允许存储在特定的槽位中。一般情况下, 如果所有流体都被允许, 返回 {@code true} 即可。
     *
     * @param i     要检查的槽位索引。
     * @param stack 要检查的 {@link FluidStack}, 包含流体类型和数量。
     * @return 如果指定的流体可以被填充到指定槽位, 返回 {@code true};否则返回 {@code false}。
     */
    @Override
    public boolean isFluidValid(int i, @NotNull FluidStack stack) {
        // 允许所有流体
        return true;
    }

    /**
     * 向第一个流体槽位(槽位 0)中填充指定类型和数量的流体。
     * <p>
     * 如果槽位为空, 将填充一个新的 {@link FluidStack};
     * 如果槽位中已有相同类型的流体, 则尝试叠加;
     * 如果槽位含有不同类型的流体, 则不会进行填充。
     * </p>
     *
     * @param stack  要填充的 {@link FluidStack}, 包含流体类型和最大填充量。
     * @param action 操作类型, 控制是否实际填充：
     *               {@link IFluidHandler.FluidAction#SIMULATE} — 仅模拟填充, 不修改槽位;
     *               {@link IFluidHandler.FluidAction#EXECUTE} — 实际执行填充, 修改槽位内容。
     * @return 实际填充到槽位中的流体量(毫升, mB);若槽位类型不匹配或容量已满, 则返回 0。
     * @implNote 使用 {@code Math.min} 来确保填充量不会超过槽位剩余容量。
     */

    @Override
    public int fill(@NotNull FluidStack stack, @NotNull FluidAction action) {
        FluidStack currentFluid = fluids.get(0);
        if (currentFluid.isEmpty()) {
            int fillAmount = Math.min(stack.getAmount(), this.getTankCapacity(0));
            if (action.execute()) {
                fluids.set(0, new FluidStack(stack.getFluid(), fillAmount));
            }
            return fillAmount;
        }
        if (!currentFluid.is(stack.getFluid())) {
            return 0;
        }
        int fillAmount = Math.min(stack.getAmount() + currentFluid.getAmount(), this.getTankCapacity(0))
                - currentFluid.getAmount();
        if (action.execute()) {
            fluids.set(0, new FluidStack(stack.getFluid(), currentFluid.getAmount() + fillAmount));
        }
        return fillAmount;
    }

    /**
     * 输出流体
     *
     * @param amount 抽取的最大流体量(mb)
     * @param action 真正执行抽取, 会减掉槽位中的流体; 是"仅模拟"(不改变状态)还是"实际抽取"(改变状态)
     * @return
     */
    @Override
    public @NotNull FluidStack drain(int amount, @NotNull FluidAction action) {
        return this.drain(new FluidStack(fluids.get(1).getFluid(), amount), action);
    }

    /**
     * 从第二个流体槽位(槽位 1)中抽取指定流体
     * <p>
     * 如果槽位为空、或槽内流体类型与请求类型不匹配, 则直接返回 {@link FluidStack#EMPTY}。
     * 否则, 将最多抽取请求量和当前槽中剩余量中的最小值。
     * 在 {@code FluidAction.EXECUTE} 模式下, 槽位中的流体会减少;
     * 在 {@code SIMULATE} 模式下, 只计算可抽取量而不会修改槽内容。
     * </p>
     *
     * @param stack  要抽取的流体类型和最大抽取量的 {@link FluidStack}。
     * @param action 操作类型, 控制是否真的抽取：
     *                    {@link FluidAction#SIMULATE} — 模拟操作, 不会减少槽内流体;
     *                    {@link FluidAction#EXECUTE} — 真正执行抽取, 减少槽内流体。
     * @return 抽取出的 {@link FluidStack}, 其类型与请求类型相同, 数量为实际抽取到的流体量;
     * 若无法抽取, 则返回 {@link FluidStack#EMPTY}。
     * @implNote 使用 {@code Math.min} 保证不会抽取超过当前槽内流体量。
     * @see IFluidHandler#drain(FluidStack, FluidAction)
     */
    @Override
    public @NotNull FluidStack drain(@NotNull FluidStack stack, @NotNull FluidAction action) {
        FluidStack currentFluid = fluids.get(1);
        if (currentFluid.isEmpty()) {
            return FluidStack.EMPTY;
        }
        if (!currentFluid.is(stack.getFluid())) {
            return FluidStack.EMPTY;
        }

        int drainAmount = Math.min(stack.getAmount(), currentFluid.getAmount());
        if (action.execute()) {
            fluids.set(1, new FluidStack(stack.getFluid(), currentFluid.getAmount() - drainAmount));
        }
        return new

                FluidStack(stack.getFluid(), drainAmount);
    }

}