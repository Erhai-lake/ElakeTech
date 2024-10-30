package top.elake.elakechemical.utils.tooldamege;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

/**
 * @author Erhai-lake Qi-Month
 */
public class ShovelDamageToolCrafting extends ShovelItem {
    public ShovelDamageToolCrafting(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public @NotNull ItemStack getCraftingRemainingItem(@NotNull ItemStack stack) {
        int damageValue = stack.getDamageValue();
        int damage = 130;
        if (damageValue >= damage) {
            return new ItemStack(Items.AIR);
        }
        ItemStack itemStack = stack.copy();
        itemStack.setDamageValue(damageValue + 1);
        return itemStack;
    }

    @Override
    public boolean hasCraftingRemainingItem(@NotNull ItemStack stack) {
        return true;
    }
}
