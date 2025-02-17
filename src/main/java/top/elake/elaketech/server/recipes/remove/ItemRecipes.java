package top.elake.elaketech.server.recipes.remove;


import static top.elake.elaketech.event.RemoveRecipes.removeItemId;

/**
 * @author Qi-Month Erhai-lake
 */
public class ItemRecipes {
    public static void removeRecipes() {
        removeItemId("minecraft:bucket");
    }
}