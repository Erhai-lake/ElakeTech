package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.utils.Registers;

/**
 * @author Erhai-lake
 */
public class Materials {
    /**
     * 草纤维
     */
    public static final DeferredItem<Item> GRASS_FIBER = Registers.registerItem("grass_fiber", new Item.Properties());
    /**
     * 草绳
     */
    public static final DeferredItem<Item> GRASS_STRING = Registers.registerItem("grass_string", new Item.Properties());
    /**
     * 铜板
     */
    public static final DeferredItem<Item> COPPER_PLATE = Registers.registerItem("copper_plate", new Item.Properties());
    /**
     * 铜线
     */
    public static final DeferredItem<Item> COPPER_WIRE = Registers.registerItem("copper_wire", new Item.Properties());
    /**
     * 铜简易单闸线圈
     */
    public static final DeferredItem<Item> EASY_COPPER_COIL = Registers.registerItem("easy_copper_coil", new Item.Properties());
    /**
     * 石墨
     */
    public static final DeferredItem<Item> GRAPHITE = Registers.registerItem("graphite", new Item.Properties());

    /**
     * 注册
     */
    public static void register() {
        // 草纤维
        ModCreativeModeTab.addSubItems(GRASS_FIBER);
        // 草绳
        ModCreativeModeTab.addSubItems(GRASS_STRING);
        // 铜板
        ModCreativeModeTab.addSubItems(COPPER_PLATE);
        // 铜线
        ModCreativeModeTab.addSubItems(COPPER_WIRE);
        // 铜简易单闸线圈
        ModCreativeModeTab.addSubItems(EASY_COPPER_COIL);
        // 石墨
        ModCreativeModeTab.addSubItems(GRAPHITE);
    }
}