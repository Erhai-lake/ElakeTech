package top.elake.elaketech.datagen.data.recipes.shapeless;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.Materials;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class CommonMaterial {
    public static void generateRecipes(RecipeOutput fileOutput) {
        String common = "crafting/shapeless/common/";
        // 燧石
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.FLINT)
                .requires(Items.GRAVEL, 4)
                .unlockedBy("has_gravel", has(Items.GRAVEL))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "flint"));
        // 草绳
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Materials.GRASS_STRING)
                .requires(Materials.GRASS_FIBER, 3)
                .unlockedBy("has_grass_fiber", has(Materials.GRASS_FIBER))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "grass_string"));
    }
}