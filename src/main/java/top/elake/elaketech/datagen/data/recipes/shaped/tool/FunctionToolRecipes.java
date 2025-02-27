package top.elake.elaketech.datagen.data.recipes.shaped.tool;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.tool.FunctionTool;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class FunctionToolRecipes {
    public static void generateRecipes(RecipeOutput output) {
        String function = "crafting/shaped/tool/function/";

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FunctionTool.METAL_DETECTOR)
                .pattern(" AA")
                .pattern(" BA")
                .pattern("B  ")
                .define('A', Tags.Items.INGOTS_IRON)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON))
                .save(output, ElakeTech.loadResource(function + "metal_detector"));
    }
}