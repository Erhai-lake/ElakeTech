package top.elake.elaketech.register.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import top.elake.elaketech.ElakeTech;

/**
 * @author Qi-Month
 */
public class ChemicalAppliancesItem {
    public static ItemEntry<Item> ASBESTOS_NET = ElakeTech.REGISTER.item("asbestos_net", Item::new)
            .model((c, p) -> p.generated(c, p.modLoc("item/chemical_appliances/asbestos_net")))
            .register();

    public static void register() {
    }
}