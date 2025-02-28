package top.elake.elaketech.register.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import top.elake.elaketech.ElakeTech;

/**
 * @author Qi-Month
 */
public class ChemicalAppliancesItem {
    public static ItemEntry<Item> ASBESTOS_NET = ElakeTech.REGISTER.item("asbestos_net", Item::new)
            .register();
    public static void register() {
    }
}