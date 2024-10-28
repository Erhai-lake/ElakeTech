package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.utils.Registers;

/**
 * @author Qi-Month
 */
public class Materials {
    /**
     * 注册
     */
    public static void register() {
        ModCreativeModeTab.addSubItems(COPPER_PLATE);
        ModCreativeModeTab.addSubItems(COPPER_WIRE);
        ModCreativeModeTab.addSubItems(COPPER_SPOOL);
    }

    /**
     * 铜板
     */
    public static final DeferredItem<Item> COPPER_PLATE = Registers.registerItem("copper_plate", new Item.Properties());
    /**
     * 铜线
     */
    public static final DeferredItem<Item> COPPER_WIRE = Registers.registerItem("copper_wire", new Item.Properties());
    /**
     * 铜单轴线圈
     */
    public static final DeferredItem<Item> COPPER_SPOOL = Registers.registerItem("copper_spool", new Item.Properties());
}