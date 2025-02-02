package top.elake.elaketech.datagen.resources.data.recipes.shaped;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.tag.ModItemTags;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class WorkBench {
    public static void generateRecipes(RecipeOutput fileOutput) {
        String workbench = "crafting/shaped/workbench/";
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CRAFTING_TABLE)
                .pattern("AB")
                .pattern("CC")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', ItemTags.LOGS)
                .define('C', ItemTags.PLANKS)
                .unlockedBy("has_logs", has(ItemTags.LOGS))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, workbench + "crafting_table"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FURNACE)
                .pattern("AAA")
                .pattern("A A")
                .pattern("BCB")
                .define('A', Tags.Items.COBBLESTONES)
                .define('B', Items.CLAY_BALL)
                .define('C', Items.CLAY)
                .unlockedBy("has_cobblestones", has(Tags.Items.COBBLESTONES))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, workbench + "furnace"));
    }
}