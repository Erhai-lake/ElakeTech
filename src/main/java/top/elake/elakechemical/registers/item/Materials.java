package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.utils.Registers;

public class Materials {
    public static void register() {
        ModCreativeModeTab.addSubItems(COPPER_PLATE);
    }

    public static final DeferredItem<Item> COPPER_PLATE = Registers.registerItem("copper_plate", new Item.Properties());
}