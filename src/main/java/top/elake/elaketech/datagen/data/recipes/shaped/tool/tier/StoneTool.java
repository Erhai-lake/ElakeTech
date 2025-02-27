package top.elake.elaketech.datagen.data.recipes.shaped.tool.tier;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.tool.tier.Stone;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class StoneTool {
    public static void generateRecipes(RecipeOutput output) {
        String stone = "crafting/shaped/tool/stone/";
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Stone.STONE_HAMMER)
                .pattern("AAA")
                .pattern("BCB")
                .pattern(" C ")
                .define('A', Tags.Items.COBBLESTONES)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_cobblestone", has(Tags.Items.COBBLESTONES))
                .save(output, ElakeTech.loadResource( stone + "sword"));
    }
}