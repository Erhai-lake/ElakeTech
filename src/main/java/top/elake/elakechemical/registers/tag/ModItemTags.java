package top.elake.elakechemical.registers.tag;

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
     * @param name 标签名
     */
    private static TagKey<Item> neoforgeTag(String name) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge", name));
    }

    public static class Items {
        public static final TagKey<Item> FLINT = neoforgeTag("flint");
    }
}