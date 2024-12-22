package top.elake.elaketech.registers.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.registers.ModCreativeModeTab;
import top.elake.elaketech.utils.Registers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qi-Month Erhai-lake
 */
public class MetalIngot {
    /**
     * 注册
     */
    public static void register() {
        addIngot("bronze", "Bronze", "青铜", 0xFFFF8C00);
        addIngot("tin", "Tin", "锡", 0xFFF5F5F5);
    }

    /**
     * 方法声明
     * @param id 金属ID
     * @param en 英文语言
     * @param cn 简体中文语言
     * @param color 颜色 颜色0*ARGB
     */
    public static void addIngot(String id, String en, String cn, int color) {
        DeferredItem<Item> item = Registers.registerItem(id + "_ingot", new Item.Properties());
        ModCreativeModeTab.addMaterials(item);
        INGOT_ITEM_GROUP.add(new IngotItem(id, en, cn, item, color));
    }

    public static final List<IngotItem> INGOT_ITEM_GROUP = new ArrayList<>();

    public record IngotItem(String id, String en, String cn, DeferredItem<Item> item, int color) {
    }
}