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
        addItem("bronze", "青铜", 0xffd2691e);
        addItem("tin", "锡", 0xfff5f5f5);
    }

    public static void addItem(String en, String cn, int color) {
        DeferredItem<Item> item = Registers.registerItem(en + "_ingot", new Item.Properties());
        ModCreativeModeTab.addMaterials(item);
        INGOT_ITEM_ARR.add(new IngotItem(en, cn, item, color));
    }

    public static final List<IngotItem> INGOT_ITEM_ARR = new ArrayList<>();

    public record IngotItem(String en, String cn, DeferredItem<Item> item, int color) {
    }
}