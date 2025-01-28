package top.elake.elaketech.datagen.resources.data.recipes;

import blusunrize.immersiveengineering.common.register.IEItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.tool.Bronze;
import top.elake.elaketech.register.tool.Flint;
import top.elake.elaketech.tag.ModItemTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author Qi-Month
 */
public class CommonShapedRecipes extends RecipeProvider {
    public CommonShapedRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput fileOutput) {
        // Common-Workbench
        // crafting table
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

        // CommonTool
        String commonTool = "crafting/shaped/tool/";
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IEItems.Tools.HAMMER)
                .pattern(" AB")
                .pattern(" CA")
                .pattern("C  ")
                .define('A', Tags.Items.INGOTS_COPPER)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_copper_ingots", has(Tags.Items.INGOTS_COPPER))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, commonTool + "hammer"));

        // 燧石
        String flint = "crafting/shaped/tool/flint/";
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_SWORD)
                .pattern(" A ")
                .pattern("BAB")
                .pattern(" C ")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_PICKAXE)
                .pattern("ABA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_AXE)
                .pattern("AB")
                .pattern("AC")
                .pattern(" C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_HATCHET)
                .pattern("AB")
                .pattern(" C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "hatchet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_SHOVEL)
                .pattern("A")
                .pattern("B")
                .pattern("C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_HOE)
                .pattern("AB")
                .pattern(" C")
                .pattern(" C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, flint + "hoe"));

        // 青铜
        String bronze = "crafting/shaped/tool/bronze/";
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Bronze.BRONZE_SWORD)
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, bronze + "sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Bronze.BRONZE_PICKAXE)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, bronze + "pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Bronze.BRONZE_AXE)
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, bronze + "axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Bronze.BRONZE_SHOVEL)
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, bronze + "shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Bronze.BRONZE_HOE)
                .pattern("AA")
                .pattern(" B")
                .pattern(" B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, bronze + "hoe"));
    }
}