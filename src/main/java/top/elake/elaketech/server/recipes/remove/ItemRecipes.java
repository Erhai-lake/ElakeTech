package top.elake.elaketech.server.recipes.remove;

import top.elake.elaketech.event.RemoveRecipes;

import java.util.List;

/**
 * @author Qi-Month
 * @author Erhai-lake
 */
public class ItemRecipes {
    public static void removeRecipes() {
        List<String> itemGroup = List.of(
                // 其它杂物
                "minecraft:bucket",
                // 工作方块
                "minecraft:crafting_table",
                "minecraft:furnace"
        );
        itemGroup.forEach(RemoveRecipes::removeItemId);
        // 工具
        List<String> toolGroup = List.of("_sword", "_pickaxe", "_axe", "_shovel", "_hoe");
        toolGroup.forEach((toolType) -> {
            RemoveRecipes.removeItemId("minecraft:wooden" + toolType);
            RemoveRecipes.removeItemId("minecraft:stone" + toolType);
        });
    }
}