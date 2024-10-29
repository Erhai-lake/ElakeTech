package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elakechemical.client.datagen.translation.I18n;
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
    public static final DeferredItem<Item> SIMPLE_COPPER_SINGLE_SOLENOID = Registers.registerItem("simple_copper_single_solenoid", new Item.Properties());
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
        I18n.addList("item", "grass_fiber", "Grass Fiber", "草纤维");
        // 草绳
        ModCreativeModeTab.addSubItems(GRASS_STRING);
        I18n.addList("item", "grass_string", "Grass String", "草绳");
        // 铜板
        ModCreativeModeTab.addSubItems(COPPER_PLATE);
        I18n.addList("item", "copper_plate", "Copper Plate", "铜板");
        // 铜线
        ModCreativeModeTab.addSubItems(COPPER_WIRE);
        I18n.addList("item", "copper_wire", "Copper Wire", "铜线");
        // 铜简易单闸线圈
        ModCreativeModeTab.addSubItems(SIMPLE_COPPER_SINGLE_SOLENOID);
        I18n.addList("item", "simple_copper_single_solenoid", "Simple Copper Single Solenoid", "铜简易单闸线圈");
        // 石墨
        ModCreativeModeTab.addSubItems(GRAPHITE);
        I18n.addList("item", "graphite", "Graphite", "石墨");
    }
}