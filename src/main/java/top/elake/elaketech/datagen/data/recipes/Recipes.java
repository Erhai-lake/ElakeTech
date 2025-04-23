package top.elake.elaketech.datagen.data.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.datagen.data.recipes.blasting.MaterialBlasting;
import top.elake.elaketech.datagen.data.recipes.blasting.OreBlasting;
import top.elake.elaketech.datagen.data.recipes.shaped.MaterialShaped;
import top.elake.elaketech.datagen.data.recipes.shapeless.MaterialShapeless;
import top.elake.elaketech.datagen.data.recipes.stonecutting.MaterialStoneCutting;

import java.util.concurrent.CompletableFuture;

/**
 * @author Elake Studio
 */
public class Recipes extends RecipeProvider {
    public Recipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        shaped(output);
        shapeless(output);
        stoneCutting(output);
        blasting(output);
    }

    /**
     * Shaped(有序合成)
     *
     * @param output 输出
     */
    private void shaped(RecipeOutput output) {
        // 材料
        MaterialShaped.register(output);
    }

    /**
     * Shapeless(无序合成)
     *
     * @param output 输出
     */
    private void shapeless(RecipeOutput output) {
        // 材料
        MaterialShapeless.register(output);
    }

    /**
     * StoneCutting(切石机)
     *
     * @param output 输出
     */
    private void stoneCutting(RecipeOutput output) {
        // 材料
        MaterialStoneCutting.register(output);
    }

    /**
     * Blasting(烧炼)
     *
     * @param output 输出
     */
    private void blasting(RecipeOutput output) {
        // 材料
        MaterialBlasting.register(output);
        // 矿石
        OreBlasting.register(output);
    }
}
