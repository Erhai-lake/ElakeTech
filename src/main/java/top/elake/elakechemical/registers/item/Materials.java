package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
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
        // 铜板
        ModCreativeModeTab.addSubItems(Registers.registerItem("copper_plate", new Item.Properties()));
        // 铜线
        ModCreativeModeTab.addSubItems(Registers.registerItem("copper_wire", new Item.Properties()));
        // 铜简易单闸线圈
        ModCreativeModeTab.addSubItems(Registers.registerItem("simple_copper_single_solenoid", new Item.Properties()));
        // 石墨
        ModCreativeModeTab.addSubItems(Registers.registerItem("graphite", new Item.Properties()));
    }
}