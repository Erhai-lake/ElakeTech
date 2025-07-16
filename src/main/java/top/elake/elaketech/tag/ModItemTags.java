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

    public static final TagKey<Item> CLAY_BALL = createItemTag("c", "clay_ball");
    public static final TagKey<Item> FLINT = createItemTag("c", "flint");

    public static final TagKey<Item> RAW_TIN = createItemTag("c", "raw_materials/tin");

    public static final TagKey<Item> INGOTS = createItemTag("c", "ingots");
    public static final TagKey<Item> TIN_INGOT = createItemTag("c", "ingots/tin");
    public static final TagKey<Item> BRONZE_INGOT = createItemTag("c", "ingots/bronze");
    public static final TagKey<Item> GRAPHITE_INGOT = createItemTag("c", "ingots/graphite");

    public static final TagKey<Item> PLATES = createItemTag("c", "plates");
    public static final TagKey<Item> IRON_PLATE = createItemTag("c", "plates/iron");
    public static final TagKey<Item> TIN_PLATE = createItemTag("c", "plates/tin");
    public static final TagKey<Item> BRONZE_PLATE = createItemTag("c", "plates/bronze");
    public static final TagKey<Item> GRAPHITE_PLATE = createItemTag("c", "plates/graphite");
}