package top.elake.elaketech.registers.item;

import net.minecraft.world.item.Item;
import top.elake.elaketech.registers.ModCreativeModeTab;
import top.elake.elaketech.utils.Registers;

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