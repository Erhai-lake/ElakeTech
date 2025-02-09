package top.elake.elaketech.register.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.util.Registers;

/**
 * @author Qi-Month
 */
public class OreItem {
    /**
     * 粗锡
     */
    public static final DeferredItem<Item> RAW_TIN = Registers.registerItem("raw_tin", new Item.Properties());

    public static void register() {
        // 粗锡
        ModCreativeModeTab.addMaterials(RAW_TIN);
    }
}