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
                .define('A', Tags.Items.INGOTS_COPPER)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_copper_ingot", has(Tags.Items.INGOTS_COPPER))
                .save(output, ElakeTech.loadResource(function + "metal_detector_t1"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FunctionTool.METAL_DETECTOR_T2)
                .pattern(" AA")
                .pattern(" BA")
                .pattern("B  ")
                .define('A', Tags.Items.INGOTS_IRON)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
                .save(output, ElakeTech.loadResource(function + "metal_detector_t2"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FunctionTool.METAL_DETECTOR_T3)
                .pattern(" AA")
                .pattern(" BA")
                .pattern("B  ")
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_diamond", has(Tags.Items.GEMS_DIAMOND))
                .save(output, ElakeTech.loadResource(function + "metal_detector_t3"));
    }
}