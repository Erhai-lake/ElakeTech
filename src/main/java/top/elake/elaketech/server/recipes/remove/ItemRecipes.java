package top.elake.elaketech.server.recipes.remove;

import top.elake.elaketech.event.RemoveRecipes;

import java.util.List;

/**
 * @author Qi-Month Erhai-lake
 */
public class ItemRecipes {
    public static void removeRecipes() {
        // 其它杂物
        RemoveRecipes.removeItemId("minecraft:bucket");
        // 工作方块
        RemoveRecipes.removeItemId("minecraft:crafting_table");
        RemoveRecipes.removeItemId("minecraft:furnace");
        // 工具
        List<String> toolGroup = List.of("_sword", "_pickaxe", "_axe", "_shovel", "_hoe");
        toolGroup.forEach((toolType) -> {
            RemoveRecipes.removeItemId("minecraft:wooden" + toolType);
            RemoveRecipes.removeItemId("minecraft:stone" + toolType);
        });
    }
}