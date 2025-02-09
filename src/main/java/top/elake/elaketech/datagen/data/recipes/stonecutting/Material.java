package top.elake.elaketech.datagen.data.recipes.stonecutting;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.Materials;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class Material {
    public static void generateRecipes(RecipeOutput output) {
        String materials = "stonecutting/materials/";

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Materials.RAW_GRAPHITE), RecipeCategory.MISC, Materials.GRAPHITE_INGOT)
                .unlockedBy("has_raw_graphite", has(Materials.RAW_GRAPHITE))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, materials + "graphite_ingot"));
    }
}