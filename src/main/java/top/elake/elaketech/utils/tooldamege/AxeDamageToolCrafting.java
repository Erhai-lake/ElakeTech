package top.elake.elaketech.utils.tooldamege;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

/**
 * @author Erhai-lake
 */
public class AxeDamageToolCrafting extends AxeItem {
    private final int SUBTRACTING_DAMAGE;

    public AxeDamageToolCrafting(Tier tier, Properties properties, int subtractingDamage) {
        super(tier, properties);
        // 要减去的耐久
        SUBTRACTING_DAMAGE = subtractingDamage;
    }

    @Override
    public @NotNull ItemStack getCraftingRemainingItem(@NotNull ItemStack stack) {
        if (SUBTRACTING_DAMAGE == 0) {
            return stack;
        }
        // 获取最大耐久
        int maxDamage = stack.getMaxDamage();
        // 获取耐久损失值
        int currentDamage = stack.getDamageValue();
        // 计算剩余耐久
        int remainingDurability = maxDamage - currentDamage;
        // 计算合成后的耐久
        int synthesisDamage = remainingDurability - SUBTRACTING_DAMAGE;
        // 计算合成后的损失值
        int newDamage = maxDamage - synthesisDamage;
        if (synthesisDamage <= 0) {
            return new ItemStack(Items.AIR);
        }
        ItemStack itemStack = stack.copy();
        itemStack.setDamageValue(newDamage);
        return itemStack;
    }

    @Override
    public boolean hasCraftingRemainingItem(@NotNull ItemStack stack) {
        return true;
    }
}
