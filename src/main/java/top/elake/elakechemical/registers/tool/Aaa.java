package top.elake.elakechemical.registers.tool;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

/**
 * @author Erhai-lake Qi-Month
 */
public class Aaa extends PickaxeItem {
    public Aaa(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public @NotNull ItemStack getCraftingRemainingItem(ItemStack stack) {
        int damageValue = stack.getDamageValue();
        if (damageValue >= 1) {
            return new ItemStack(Items.AIR);
        }
        stack.setDamageValue(damageValue + 1);
        return stack;
    }
}
