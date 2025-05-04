package top.elake.elaketech.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RecipesUpdatedEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.config.RecipeRemovalConfig;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.GAME, value = { Dist.CLIENT, Dist.DEDICATED_SERVER })
public class RemoveRecipes {

    /**
     * 在服务器启动前加载配置
     */
    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        RecipeRemovalConfig.getInstance().loadConfig();
    }

    /**
     * 客户端配方更新时移除配方
     */
    @SubscribeEvent
    public static void onRecipesUpdated(RecipesUpdatedEvent event) {
        removeRecipes(event.getRecipeManager());
    }

    /**
     * 服务器启动时移除配方
     */
    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        removeRecipes(event.getServer().getRecipeManager());
    }

    private static void removeRecipes(RecipeManager recipeManager) {
        RecipeRemovalConfig config = RecipeRemovalConfig.getInstance();
        Set<String> modsToRemove = config.getModIds();
        Set<ResourceLocation> recipesToRemove = config.getRecipeIds();
        
        // 如果配置为空，不需要进行处理
        if (modsToRemove.isEmpty() && recipesToRemove.isEmpty()) {
            return;
        }
        
        Collection<RecipeHolder<?>> allRecipes = recipeManager.getRecipes();
        int originalSize = allRecipes.size();
        
        Collection<RecipeHolder<?>> recipesToKeep = allRecipes.stream()
                .filter((holder) -> {
                    ResourceLocation id = holder.id();
                    return !modsToRemove.contains(id.getNamespace()) && !recipesToRemove.contains(id);
                }).collect(Collectors.toList());
        
        recipeManager.replaceRecipes(recipesToKeep);
        
        int removedCount = originalSize - recipesToKeep.size();
    }
}