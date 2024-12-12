package top.elake.elaketech.registers.item;

import net.minecraft.world.item.Item;
import top.elake.elaketech.registers.ModCreativeModeTab;
import top.elake.elaketech.utils.Registers;

/**
 * @author Qi-Month
 */
public class MetalIngot {
    /**
     * 注册
     */
    public static void register() {
        for (String ingot : INGOT_REGISTERS) {
            ModCreativeModeTab.addMaterials(Registers.registerItem(ingot + "_ingot", new Item.Properties()));
        }
    }

    public static final String[] INGOT_REGISTERS = new String[]{
            "tin",
            "bronze"
    };
}