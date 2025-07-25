package top.elake.elaketech.datagen.data.recipes.shaped;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.block.CommonBlock;
import top.elake.elaketech.register.block.MachineBlock;
import top.elake.elaketech.tag.ModItemTags;

import static top.elake.elaketech.datagen.data.recipes.utils.RecipesGeneratoresUtils.hasItem;

/**
 * @author Elake Studio
 */
public class MachineShaped {
    public static void register(RecipeOutput output) {
        String machine = "crafting/shaped/machine/";
        // 锅炉
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MachineBlock.BOILER)
                .pattern("AAA")
                .pattern("A A")
                .pattern("BBB")
                .define('A', ModItemTags.BRONZE_PLATE)
                .define('B', CommonBlock.REFRACTORY_BRICKS)
                .unlockedBy("has_bronze_plate", hasItem(ModItemTags.BRONZE_PLATE))
                .save(output, ElakeTech.loadResource(machine + "boiler"));
    }
}