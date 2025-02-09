package top.elake.elaketech.register.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.util.Registers;

/**
 * @author Qi-Month
 */
public class MetalPlate {
    public static final DeferredItem<Item> IRON_PLATE = Registers.registerItem("iron_plate", new Item.Properties());

    public static void register() {
        ModCreativeModeTab.addMaterials(IRON_PLATE);
    }
}