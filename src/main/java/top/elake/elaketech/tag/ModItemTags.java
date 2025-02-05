package top.elake.elaketech.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * @author Qi-Month
 */
public class ModItemTags {
    /**
     * 定义Tags
     *
     * @param namespace 命名空间
     * @param tag       标签名
     */
    public static TagKey<Item> createItemTag(String namespace, String tag) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(namespace, tag));
    }

    public static class Items {
        public static final TagKey<Item> FLINT = createItemTag("c", "flint");

        public static final TagKey<Item> INGOTS = createItemTag("c", "ingots");
        public static final TagKey<Item> BRONZE = createItemTag("c", "ingots/bronze");
        public static final TagKey<Item> GRAPHITE = createItemTag("c", "ingots/graphite");
    }
}