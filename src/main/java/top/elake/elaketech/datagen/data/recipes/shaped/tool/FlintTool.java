package top.elake.elaketech.datagen.data.recipes.shaped.tool;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.tool.Flint;
import top.elake.elaketech.tag.ModItemTags;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class FlintTool {
    public static void generateRecipes(RecipeOutput fileOutput) {
        String flint = "crafting/shaped/tool/flint/";
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Flint.FLINT_SWORD)
                .pattern(" A ")
                .pattern("BAB")
                .pattern(" C ")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Flint.FLINT_PICKAXE)
                .pattern("ABA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Flint.FLINT_AXE)
                .pattern("AB")
                .pattern("AC")
                .pattern(" C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Flint.FLINT_HATCHET)
                .pattern("AB")
                .pattern(" C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "hatchet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Flint.FLINT_SHOVEL)
                .pattern("A")
                .pattern("B")
                .pattern("C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Flint.FLINT_HOE)
                .pattern("AB")
                .pattern(" C")
                .pattern(" C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "hoe"));
    }
}