package top.elake.elaketech.datagen.data.recipes.shaped;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.tag.ModItemTags;

import static top.elake.elaketech.datagen.data.recipes.utils.RecipesGeneratoresUtils.hasItem;

/**
 * @author Qi-Month
 */
public class WorkBenchShaped {
    /**
     * 工作台有序合成配方
     *
     * @param output 输出
     */
    public static void register(RecipeOutput output) {
        String workbench = "crafting/shaped/workbench/";

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CRAFTING_TABLE)
                .pattern("AB")
                .pattern("CC")
                .define('A', ModItemTags.FLINT)
                .define('B', ItemTags.LOGS)
                .define('C', ItemTags.PLANKS)
                .unlockedBy("has_logs", hasItem(ItemTags.LOGS))
                .save(output, ElakeTech.loadResource(workbench + "crafting_table"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FURNACE)
                .pattern("AAA")
                .pattern("A A")
                .pattern("CBC")
                .define('A', Tags.Items.COBBLESTONES)
                .define('B', Items.CLAY_BALL)
                .define('C', Items.CLAY)
                .unlockedBy("has_cobblestones", hasItem(Tags.Items.COBBLESTONES))
                .save(output, ElakeTech.loadResource(workbench + "furnace"));
    }
}