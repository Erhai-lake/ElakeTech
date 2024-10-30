package top.elake.elakechemical.registers.tool;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import org.jetbrains.annotations.NotNull;

/**
 * @author Erhai-lake
 */
public class Aaa extends PickaxeItem {
    public Aaa() {
        super(Tiers.STONE, new Properties());
    }

    @Override
    public @NotNull ItemStack getCraftingRemainingItem(@NotNull ItemStack stack) {
        int damageValue = stack.getDamageValue();
        stack.setDamageValue(damageValue + 1);
        return stack;
    }
}