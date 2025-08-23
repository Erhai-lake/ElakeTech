package top.elake.elaketech.datagen.data.recipes.shapeless;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.materials.Materials;

import static top.elake.elaketech.datagen.data.recipes.utils.RecipesGeneratoresUtils.hasItem;

/**
 * @author Elake Studio
 */
public class MaterialShapeless {
    /**
     * 材料无序合成配方
     *
     * @param output 输出
     */
    public static void register(RecipeOutput output) {
        String common = "crafting/shapeless/common/";
        // 燧石
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.FLINT)
                .requires(Items.GRAVEL, 3)
                .unlockedBy("has_gravel", hasItem(Items.GRAVEL))
                .save(output, ElakeTech.loadResource(common + "flint"));
        // 草绳
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Materials.GRASS_STRING)
                .requires(Materials.GRASS_FIBER, 3)
                .unlockedBy("has_grass_fiber", hasItem(Materials.GRASS_FIBER))
                .save(output, ElakeTech.loadResource(common + "grass_string"));
    }
}