package top.elake.elaketech.datagen.resources.data.recipes.minecraft.shaped.tool;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.tool.Bronze;
import top.elake.elaketech.tag.ModItemTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author Qi-Month
 */
public class BronzeTool extends RecipeProvider {
    public BronzeTool(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput fileOutput) {
        String path = "crafting/shaped/tool/bronze/";

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Bronze.BRONZE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Bronze.BRONZE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Bronze.BRONZE_AXE.get())
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Bronze.BRONZE_SHOVEL.get())
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Bronze.BRONZE_HOE.get())
                .pattern("AA")
                .pattern(" B")
                .pattern(" B")
                .define('A', ModItemTags.Items.BRONZE)
                .define('B', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_bronze", has(ModItemTags.Items.BRONZE))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "hoe"));
    }
}