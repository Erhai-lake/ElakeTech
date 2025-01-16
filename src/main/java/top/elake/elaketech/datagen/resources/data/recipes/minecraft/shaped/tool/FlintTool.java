package top.elake.elaketech.datagen.resources.data.recipes.minecraft.shaped.tool;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
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
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Flint.FLINT_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItemTags.Items.FLINT)
                .define('B', Items.STICK)
                .unlockedBy("has_flint", has(ModItemTags.Items.FLINT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, "aaa/bbb"));
    }
}