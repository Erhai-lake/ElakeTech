package top.elake.registers.item;

import top.elake.ElakeChemical;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import net.minecraft.world.item.Item;

public class ModItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ElakeChemical.MODID);

    public static final Supplier<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem(
            "test", new Item.Properties()
    );
}
