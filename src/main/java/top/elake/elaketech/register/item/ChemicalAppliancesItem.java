package top.elake.elaketech.register.item;

import net.minecraft.world.item.Item;
import top.elake.elaketech.register.ETCreativeModeTab;
import top.elake.elaketech.util.Registers;

/**
 * @author Qi-Month
 */
public class ChemicalAppliancesItem {
    /**
     * 注册
     */
    public static void register() {
        ETCreativeModeTab.addChemicalAppliances(Registers.registerItem("asbestos_net", new Item.Properties()));
    }
}