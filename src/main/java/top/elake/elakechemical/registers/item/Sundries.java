package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.utils.Registers;

/**
 * @author Erhai-lake Qi-Month
 */
public class Sundries {
    /**
     * 注册
     */
    public static void register() {
        ModCreativeModeTab.addSubItems(Registers.registerItem("grass_fiber", new Item.Properties()));
        ModCreativeModeTab.addSubItems(Registers.registerItem("grass_string", new Item.Properties()));
        ModCreativeModeTab.addSubItems(TEST_INGOT);
    }

    public static final DeferredItem<Item> TEST_INGOT = Registers.registerItem("test_ingot", new Item.Properties());

}