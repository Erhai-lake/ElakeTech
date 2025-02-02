package top.elake.elaketech.datagen.resources.data.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.datagen.resources.data.recipes.shaped.WorkBench;
import top.elake.elaketech.datagen.resources.data.recipes.shaped.tool.BronzeTool;
import top.elake.elaketech.datagen.resources.data.recipes.shaped.tool.CommonTool;
import top.elake.elaketech.datagen.resources.data.recipes.shaped.tool.FlintTool;
import top.elake.elaketech.datagen.resources.data.recipes.shapeless.CommonMaterial;
import top.elake.elaketech.datagen.resources.data.recipes.stonecutting.Material;

import java.util.concurrent.CompletableFuture;


/**
 * @author Qi-Month
 */
public class MainRecipes extends RecipeProvider {
    public MainRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        // Shaped
        FlintTool.generateRecipes(output);
        BronzeTool.generateRecipes(output);
        CommonTool.generateRecipes(output);
        WorkBench.generateRecipes(output);
        // Shapeless
        CommonMaterial.generateRecipes(output);
        // Stonecutting
        Material.generateRecipes(output);
    }
}