package top.elake.elaketech.registers.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * @author Qi-Month
 */
public class ModItemTags {
    /**
     * 新建neoforge的tag
     *
     * @param tag 标签名
     */
    private static TagKey<Item> neoforgeTag(String tag) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", tag));
    }

    public static class Items {
        public static final TagKey<Item> FLINT = neoforgeTag("flint");
        public static final TagKey<Item> BRONZE = neoforgeTag("bronze");
    }
}