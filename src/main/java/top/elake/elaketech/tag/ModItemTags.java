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
     * 获取neoforge的tag
     *
     * @param tag 标签名
     */
    private static TagKey<Item> getTag(String namespace, String tag) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(namespace, tag));
    }

    public static class Items {
        public static final TagKey<Item> FLINT = getTag("c", "flint");
        public static final TagKey<Item> INGOTS = getTag("c", "ingots");
        public static final TagKey<Item> BRONZE = getTag("c", "ingots/bronze");
        public static final TagKey<Item> GRAPHITE = getTag("c", "ingots/graphite");
    }
}