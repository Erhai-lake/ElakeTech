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

    public static final TagKey<Item> CLAY_BALL;
    public static final TagKey<Item> FLINT;

    public static final TagKey<Item> RAW_TIN;

    public static final TagKey<Item> TIN_ORE;

    public static final TagKey<Item> INGOTS;
    public static final TagKey<Item> TIN_INGOT;
    public static final TagKey<Item> BRONZE_INGOT;
    public static final TagKey<Item> GRAPHITE_INGOT;

    public static final TagKey<Item> PLATES;
    public static final TagKey<Item> IRON_PLATE;
    public static final TagKey<Item> TIN_PLATE;
    public static final TagKey<Item> BRONZE_PLATE;
    public static final TagKey<Item> GRAPHITE_PLATE;

    static {
        CLAY_BALL = createItemTag("c", "clay_ball");
        FLINT = createItemTag("c", "flint");

        TIN_ORE = createItemTag("c", "ores/tin");

        RAW_TIN = createItemTag("c", "raw_materials/tin");

        INGOTS = createItemTag("c", "ingots");
        TIN_INGOT = createItemTag("c", "ingots/tin");
        BRONZE_INGOT = createItemTag("c", "ingots/bronze");
        GRAPHITE_INGOT = createItemTag("c", "ingots/graphite");

        PLATES = createItemTag("c", "plates");
        IRON_PLATE = createItemTag("c", "plates/iron");
        TIN_PLATE = createItemTag("c", "plates/tin");
        BRONZE_PLATE = createItemTag("c", "plates/bronze");
        GRAPHITE_PLATE = createItemTag("c", "plates/graphite");
    }
}