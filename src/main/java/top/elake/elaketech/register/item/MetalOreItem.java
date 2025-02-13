package top.elake.elaketech.register.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.util.Registers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qi-Month
 */
public class MetalOreItem {
    /**
     * 注册
     */
    public static void register() {
        addMetalOreItem("tin", "Tin", "锡", 0xFFF5F5F5);
    }

    /**
     * 方法声明
     *
     * @param id    金属ID
     * @param en    英文语言
     * @param cn    简体中文语言
     * @param color 颜色 颜色0*ARGB
     */
    public static void addMetalOreItem(String id, String en, String cn, int color) {
        DeferredItem<Item> item = Registers.registerItem("raw_" + id, new Item.Properties());
        ModCreativeModeTab.addMaterials(item);
        RAW_ORE_ITEM_GROUP.add(new RawMetalOreItem(id, en, cn, item, color));
    }

    public static final List<RawMetalOreItem> RAW_ORE_ITEM_GROUP = new ArrayList<>();

    public record RawMetalOreItem(String id, String en, String cn, DeferredItem<Item> item, int color) {
    }
}