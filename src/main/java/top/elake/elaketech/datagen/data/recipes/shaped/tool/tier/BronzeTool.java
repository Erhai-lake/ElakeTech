package top.elake.elaketech.datagen.data.recipes.shaped.tool.tier;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.tool.tier.Bronze;
import top.elake.elaketech.tag.ModItemTags;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class BronzeTool {
    public static void generateRecipes(RecipeOutput output) {
        String bronze = "crafting/shaped/tool/bronze/";
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Bronze.BRONZE_SWORD)
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', ModItemTags.Items.BRONZE_INGOT)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE_INGOT))
                .save(output, ElakeTech.loadResource( bronze + "sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Bronze.BRONZE_PICKAXE)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItemTags.Items.BRONZE_INGOT)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE_INGOT))
                .save(output, ElakeTech.loadResource( bronze + "pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Bronze.BRONZE_AXE)
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .define('A', ModItemTags.Items.BRONZE_INGOT)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE_INGOT))
                .save(output, ElakeTech.loadResource( bronze + "axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Bronze.BRONZE_SHOVEL)
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItemTags.Items.BRONZE_INGOT)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE_INGOT))
                .save(output, ElakeTech.loadResource( bronze + "shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Bronze.BRONZE_HOE)
                .pattern("AA")
                .pattern(" B")
                .pattern(" B")
                .define('A', ModItemTags.Items.BRONZE_INGOT)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE_INGOT))
                .save(output, ElakeTech.loadResource( bronze + "hoe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Bronze.BRONZE_HAMMER)
                .pattern("AAA")
                .pattern("ABA")
                .pattern(" B ")
                .define('A', ModItemTags.Items.BRONZE_INGOT)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE_INGOT))
                .save(output, ElakeTech.loadResource( bronze + "hammer"));
    }
}