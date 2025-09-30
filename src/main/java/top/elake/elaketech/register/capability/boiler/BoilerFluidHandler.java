package top.elake.elaketech.register.capability.boiler;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;
import net.minecraft.world.level.material.Fluid;

/**
 * @author Elake Studio
 */
public class BoilerFluidHandler implements IFluidHandler, INBTSerializable<CompoundTag> {
    private final NonNullList<FluidStack> fluids = NonNullList.withSize(2, FluidStack.EMPTY);

    @Override
    public int getTanks() {
        return fluids.size();
    }

    @Override
    public @NotNull FluidStack getFluidInTank(int tank) {
        return fluids.get(tank);
    }

    @Override
    public int getTankCapacity(int tank) {
        return 10000;
    }

    @Override
    public boolean isFluidValid(int tank, @NotNull FluidStack stack) {
        return tank != 0 || stack.is(Fluids.WATER);
    }

    @Override
    public int fill(@NotNull FluidStack stack, @NotNull FluidAction action) {
        if (!isFluidValid(0, stack)) {
            return 0;
        }
        FluidStack current = fluids.get(0);
        int fillAmount = current.isEmpty()
                ? Math.min(stack.getAmount(), getTankCapacity(0))
                : current.is(stack.getFluid())
                ? Math.min(stack.getAmount() + current.getAmount(), getTankCapacity(0)) - current.getAmount()
                : 0;

        if (action.execute() && fillAmount > 0) {
            fluids.set(0, current.isEmpty()
                    ? new FluidStack(stack.getFluid(), fillAmount)
                    : new FluidStack(stack.getFluid(), current.getAmount() + fillAmount));
        }
        return fillAmount;
    }

    @Override
    public @NotNull FluidStack drain(@NotNull FluidStack stack, @NotNull FluidAction action) {
        for (int i = 0; i < getTanks(); i++) {
            FluidStack current = fluids.get(i);
            if (!current.isEmpty() && current.is(stack.getFluid())) {
                int drained = Math.min(stack.getAmount(), current.getAmount());
                if (action.execute()) {
                    fluids.set(i, new FluidStack(current.getFluid(), current.getAmount() - drained));
                }
                return new FluidStack(current.getFluid(), drained);
            }
        }
        return FluidStack.EMPTY;
    }

    @Override
    public @NotNull FluidStack drain(int amount, @NotNull FluidAction action) {
        FluidStack out = fluids.get(1);
        if (out.isEmpty()) {
            return FluidStack.EMPTY;
        }
        int drained = Math.min(amount, out.getAmount());
        if (action.execute()) {
            fluids.set(1, new FluidStack(out.getFluid(), out.getAmount() - drained));
        }
        return new FluidStack(out.getFluid(), drained);
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.@NotNull Provider provider) {
        CompoundTag tag = new CompoundTag();
        ListTag list = new ListTag();
        for (int i = 0; i < fluids.size(); i++) {
            FluidStack f = fluids.get(i);
            if (!f.isEmpty()) {
                CompoundTag sub = (CompoundTag) f.save(provider, new CompoundTag());
                sub.putInt("Slot", i);
                list.add(sub);
            }
        }
        tag.put("Fluids", list);
        return tag;
    }

    @Override
    public void deserializeNBT(HolderLookup.@NotNull Provider provider, @NotNull CompoundTag tag) {
        for (int i = 0; i < getTanks(); i++) {
            fluids.set(i, FluidStack.EMPTY);
        }
        ListTag list = tag.getList("Fluids", 10);
        for (int i = 0; i < list.size(); i++) {
            CompoundTag sub = list.getCompound(i);
            FluidStack.parse(provider, sub)
                    .ifPresent((f) -> {
                        int s = sub.getInt("Slot");
                        if (s >= 0 && s < fluids.size()) {
                            fluids.set(s, f);
                        }
                    });
        }
    }

    /**
     * @param amount 要设置的水量
     */
    public void setWaterAmount(int amount) {
        FluidStack current = fluids.get(0);
        if (current.isEmpty() && amount > 0) {
            fluids.set(0, new FluidStack(Fluids.WATER, amount));
        } else if (!current.isEmpty()) {
            fluids.set(0, new FluidStack(current.getFluid(), amount));
        }
    }

    /**
     * @param fluid  要设置的流体类型
     * @param amount 要设置的流体量
     */
    public void setSteamAmount(Fluid fluid, int amount) {
        if (amount <= 0) {
            fluids.set(1, FluidStack.EMPTY);
        } else {
            fluids.set(1, new FluidStack(fluid, amount));
        }
    }
}