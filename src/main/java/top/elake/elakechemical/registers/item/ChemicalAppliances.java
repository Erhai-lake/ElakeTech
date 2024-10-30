package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.utils.Registers;

/**
 * @author Qi-Month
 */
public class ChemicalAppliances {
    /**
     * 注册
     */
    public static void register() {
        ModCreativeModeTab.addChemicalAppliances(Registers.registerItem("asbestos_net", new Item.Properties()));
    }
}