package top.elake.elaketech.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RecipesUpdatedEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import top.elake.elaketech.ElakeTech;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.DEDICATED_SERVER)
public class RemoveRecipes {
    private static final Set<String> MODS_TO_REMOVE = new HashSet<>();
    private static final Set<ResourceLocation> RECIPES_TO_REMOVE = new HashSet<>();

    /**
     * 删除模组的所有配方
     * 例如: removeMod("mekanism");
     */
    public static void removeMod(String modId) {
        MODS_TO_REMOVE.add(modId);
    }

    /**
     * 删除物品ID的配方
     * 例如: removeItemId("minecraft:diamond_block");
     */
    public static void removeItemId(String itemId) {
        RECIPES_TO_REMOVE.add(ResourceLocation.parse(itemId));
    }

    /**
     * 删除配方ID的配方
     * 例如: removeRecipe("mekanism:factory/advanced/purifying");
     */
    public static void removeRecipe(String recipeId) {
        RECIPES_TO_REMOVE.add(ResourceLocation.parse(recipeId));
    }

    /**
     * 删除指定命名空间和路径的配方
     * 例如: removeRecipe("minecraft", "furnace");
     */
    public static void removeRecipe(String namespace, String path) {
        RECIPES_TO_REMOVE.add(ResourceLocation.fromNamespaceAndPath(namespace, path));
    }

    @SubscribeEvent
    public static void onRecipesUpdated(RecipesUpdatedEvent event) {
        removeRecipes(event.getRecipeManager());
    }

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        removeRecipes(event.getServer().getRecipeManager());
    }

    private static void removeRecipes(RecipeManager recipeManager) {
        Collection<RecipeHolder<?>> allRecipes = recipeManager.getRecipes();
        Collection<RecipeHolder<?>> recipesToKeep = allRecipes.stream()
                .filter((holder) -> {
                    ResourceLocation id = holder.id();
                    return !MODS_TO_REMOVE.contains(id.getNamespace()) && !RECIPES_TO_REMOVE.contains(id);
                })
                .collect(Collectors.toList());
        recipeManager.replaceRecipes(recipesToKeep);
    }
}