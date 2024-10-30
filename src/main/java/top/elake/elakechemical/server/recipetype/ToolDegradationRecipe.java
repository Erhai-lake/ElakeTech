package top.elake.elakechemical.server.recipetype;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.Level;

/**
 * @author Erhai-lake
 */
public class ToolDegradationRecipe extends ShapelessRecipe {
    public ToolDegradationRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(group, category, result, ingredients);
    }

    @Override
    public ItemStack assemble(Container inv, Level level) {
        // 获取合成结果
        ItemStack result = super.assemble((CraftingInput) inv, (HolderLookup.Provider) level);
        // 减少工具耐久度
        reduceToolDurability(inv, level);
        return result;
    }

    private void reduceToolDurability(Container inv, Level level) {
        for (int i = 0; i < inv.getContainerSize(); ++i) {
            ItemStack itemStack = inv.getItem(i);
            if (!itemStack.isEmpty() && itemStack.isDamageableItem()) {
                // 减少耐久度，使用level来获取随机性
                itemStack.hurt(1, level.getRandom(), null);
                if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) {
                    // 如果工具耐久耗尽，则移除工具
                    itemStack.shrink(1);
                }
            }
        }
    }
}
