package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
import top.elake.elakechemical.Utils;
import top.elake.elakechemical.registers.ModCreativeModeTab;

/**
 * @author Erhai-lake
 */
public class Sundries {
    /**
     * 注册
     */
    public static void register() {
        ModCreativeModeTab.addSubItems(Utils.registerItem("grass_fiber", new Item.Properties()));
        ModCreativeModeTab.addSubItems(Utils.registerItem("grass_string", new Item.Properties()));
    }
}