package top.elake.elaketech.datagen.data.recipes.blasting;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.Materials;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class CommonBlastingMaterial {
    public static void generateRecipes(RecipeOutput output) {
        String smelting = "smelting/materials/smelting/";
        String blasting = "smelting/materials/blasting/";

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Materials.WET_REFRACTORY_BRICK), RecipeCategory.MISC, Materials.REFRACTORY_BRICK, 0.3f, 200)
                .unlockedBy("has_wet_refractory_brick", has(Materials.WET_REFRACTORY_BRICK))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, smelting + "refractory_brick"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Materials.WET_REFRACTORY_BRICK), RecipeCategory.MISC, Materials.REFRACTORY_BRICK, 0.3f, 100)
                .unlockedBy("has_wet_refractory_brick", has(Materials.WET_REFRACTORY_BRICK))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, blasting + "refractory_brick"));
    }
}