package top.elake.elaketech.datagen.resources.data.recipes.minecraft.shaped.tool;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.tool.Flint;
import top.elake.elaketech.tag.ModItemTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author Qi-Month
 */
public class FlintTool extends RecipeProvider {
    public FlintTool(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput fileOutput) {
        String path = "crafting/shaped/tool/flint/";

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_SWORD.get())
                .pattern(" A ")
                .pattern("BAB")
                .pattern(" C ")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_PICKAXE.get())
                .pattern("ABA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_AXE.get())
                .pattern("AB")
                .pattern("AC")
                .pattern(" C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_HATCHET.get())
                .pattern("AB")
                .pattern(" C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "hatchet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_SHOVEL.get())
                .pattern("A")
                .pattern("B")
                .pattern("C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_HOE.get())
                .pattern("AB")
                .pattern(" C")
                .pattern(" C")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path + "hoe"));
    }
}