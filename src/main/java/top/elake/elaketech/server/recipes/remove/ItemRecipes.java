package top.elake.elaketech.server.recipes.remove;


import top.elake.elaketech.event.RemoveRecipes;

/**
 * @author Qi-Month Erhai-lake
 */
public class ItemRecipes {
    public static void removeRecipes() {
        RemoveRecipes.removeItemId("minecraft:bucket");
    }
}