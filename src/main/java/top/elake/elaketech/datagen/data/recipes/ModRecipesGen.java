package top.elake.elaketech.datagen.data.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.datagen.data.recipes.blasting.CommonBlastingMaterial;
import top.elake.elaketech.datagen.data.recipes.shaped.CommonShapedMaterials;
import top.elake.elaketech.datagen.data.recipes.shaped.WorkBench;
import top.elake.elaketech.datagen.data.recipes.shaped.tool.FunctionToolRecipes;
import top.elake.elaketech.datagen.data.recipes.shaped.tool.tier.BronzeTool;
import top.elake.elaketech.datagen.data.recipes.shaped.tool.tier.FlintTool;
import top.elake.elaketech.datagen.data.recipes.shaped.tool.tier.StoneTool;
import top.elake.elaketech.datagen.data.recipes.shapeless.CommonMaterial;
import top.elake.elaketech.datagen.data.recipes.blasting.OreBlasting;
import top.elake.elaketech.datagen.data.recipes.stonecutting.Material;

import java.util.concurrent.CompletableFuture;


/**
 * @author Qi-Month
 */
public class ModRecipesGen extends RecipeProvider {
    public ModRecipesGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        // Shaped
        FlintTool.generateRecipes(output);
        BronzeTool.generateRecipes(output);
        StoneTool.generateRecipes(output);
        WorkBench.generateRecipes(output);
        FunctionToolRecipes.generateRecipes(output);
        CommonShapedMaterials.generateRecipes(output);
        // Shapeless
        CommonMaterial.generateRecipes(output);
        // Stonecutting
        Material.generateRecipes(output);
        // Blasting
        CommonBlastingMaterial.generateRecipes(output);
        OreBlasting.generateRecipes(output);
    }
}