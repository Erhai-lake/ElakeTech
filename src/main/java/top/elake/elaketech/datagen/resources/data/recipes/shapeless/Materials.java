package top.elake.elaketech.datagen.resources.data.recipes.shapeless;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import top.elake.elaketech.ElakeTech;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class Materials {
    public static void generateRecipes(RecipeOutput fileOutput) {
        String common = "crafting/shapeless/common/";
        // 燧石
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.FLINT)
                .requires(Items.GRAVEL, 3)
                .unlockedBy("has_gravel", has(Items.GRAVEL))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "flint"));
        // 草绳
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, top.elake.elaketech.register.item.Materials.GRASS_STRING)
                .requires(top.elake.elaketech.register.item.Materials.GRASS_FIBER, 3)
                .unlockedBy("has_grass_fiber", has(top.elake.elaketech.register.item.Materials.GRASS_FIBER))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "grass_string"));
    }
}