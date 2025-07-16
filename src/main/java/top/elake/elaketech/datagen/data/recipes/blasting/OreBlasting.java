package top.elake.elaketech.datagen.data.recipes.blasting;

import net.minecraft.data.recipes.RecipeOutput;
import top.elake.elaketech.register.item.ores.Ingots;
import top.elake.elaketech.tag.ModItemTags;

/**
 * @author Elake Studio
 */
public class OreBlasting {
    public static void register(RecipeOutput output) {
        OreBlastingUtil.addOreSmeltingRecipes(Ingots.TIN, ModItemTags.RAW_TIN, output);
    }
}