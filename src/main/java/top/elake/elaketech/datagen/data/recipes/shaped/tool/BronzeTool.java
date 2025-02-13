package top.elake.elaketech.datagen.data.recipes.shaped.tool;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.tool.Bronze;
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
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, bronze + "sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Bronze.BRONZE_PICKAXE)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, bronze + "pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Bronze.BRONZE_AXE)
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, bronze + "axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Bronze.BRONZE_SHOVEL)
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, bronze + "shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Bronze.BRONZE_HOE)
                .pattern("AA")
                .pattern(" B")
                .pattern(" B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, bronze + "hoe"));
    }
}