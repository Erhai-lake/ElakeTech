package top.elake.elaketech.datagen.data.recipes.utils;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * @author Elake Studio
 */
public class RecipesGeneratoresUtils extends RecipeProvider {
    public RecipesGeneratoresUtils(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }

    public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> hasItem(@NotNull TagKey<Item> item) {
        return RecipeProvider.has(item);
    }

    public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> hasItem(@NotNull ItemLike item) {
        return RecipeProvider.has(item);
    }
}