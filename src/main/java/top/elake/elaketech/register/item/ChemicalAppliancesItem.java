package top.elake.elaketech.register.item;

import net.minecraft.world.item.Item;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.util.Registers;

/**
 * @author Qi-Month
 */
public class ChemicalAppliancesItem {
    /**
     * 注册
     */
    public static void register() {
        ModCreativeModeTab.addChemicalAppliances(Registers.registerItem("asbestos_net", new Item.Properties()));
    }
}