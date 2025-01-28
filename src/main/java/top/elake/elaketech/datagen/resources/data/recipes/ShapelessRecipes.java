package top.elake.elaketech.datagen.resources.data.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.Materials;

import java.util.concurrent.CompletableFuture;

/**
 * @author Qi-Month
 */
public class ShapelessRecipes extends RecipeProvider {
    public ShapelessRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput fileOutput) {
        // Common
        String common = "crafting/shapeless/common/";
        // 燧石
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.FLINT)
                .requires(Items.GRAVEL, 3)
                .unlockedBy("has_gravel", has(Items.GRAVEL))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "flint"));
        // 草绳
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Materials.GRASS_STRING)
                .requires(Materials.GRASS_FIBER, 3)
                .unlockedBy("has_grass_fiber", has(Materials.GRASS_FIBER))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "grass_string"));
    }
}