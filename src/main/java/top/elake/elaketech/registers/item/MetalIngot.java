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
        addItem("bronze", "Bronze", "青铜", 0xFF8C00);
        addItem("tin", "Tin", "锡", 0xFFF5F5F5);
    }

    public static void addItem(String id, String en, String cn, int color) {
        DeferredItem<Item> item = Registers.registerItem(id + "_ingot", new Item.Properties().);
        ModCreativeModeTab.addMaterials(item);
        INGOT_ITEM_ARR.add(new IngotItem(id, en, cn, item, color));
    }

    public static final List<IngotItem> INGOT_ITEM_ARR = new ArrayList<>();

    public record IngotItem(String id, String en, String cn, DeferredItem<Item> item, int color) {
    }
}