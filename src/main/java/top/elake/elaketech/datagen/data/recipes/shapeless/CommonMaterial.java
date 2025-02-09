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
    public static void generateRecipes(RecipeOutput output) {
        String common = "crafting/shapeless/common/";
        // 燧石
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.FLINT)
                .requires(Items.GRAVEL, 4)
                .unlockedBy("has_gravel", has(Items.GRAVEL))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "flint"));
        // 草绳
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Materials.GRASS_STRING)
                .requires(Materials.GRASS_FIBER, 3)
                .unlockedBy("has_grass_fiber", has(Materials.GRASS_FIBER))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "grass_string"));
        // 耐火黏土球
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Materials.REFRACTORY_CLAY_BALL, 4)
                .requires(Items.WATER_BUCKET)
                .requires(Items.CLAY_BALL, 2)
                .requires(Items.QUARTZ)
                .requires(Materials.KAOLINITE, 2)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "refractory_clay_ball"));
        // 潮湿耐火砖
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Materials.WET_REFRACTORY_BRICK, 4)
                .requires(Materials.REFRACTORY_CLAY_BALL, 4)
                .unlockedBy("has_fire_clay", has(Materials.REFRACTORY_CLAY_BALL))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "wet_refractory_brick"));
    }
}