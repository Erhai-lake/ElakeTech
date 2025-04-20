package top.elake.elaketech.register.item.material;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import top.elake.elaketech.tag.ModItemTags;

import static top.elake.elaketech.ElakeTech.REGISTRATE;

/**
 * @author Qi-Month
 */
public class PlateItem {
    public static ItemEntry<Item> TIN = addColorPlateItem("tin", "Tin", 0xFFE1FFFF);
    public static ItemEntry<Item> GRAPHITE = addAllonPlateItem("graphite", "Graphite");

    public static ItemEntry<Item> addColorPlateItem(String id, String name, int color) {
        return REGISTRATE.item(id + "_plate", Item::new)
                .color(() -> () -> (itemStack, tintIndex) -> color)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/color/plate")))
                .lang(name + " PlateItem")
                .tag(ModItemTags.Items.PLATES)
                .register();
    }

    public static ItemEntry<Item> addAllonPlateItem(String id, String name) {
        return REGISTRATE.item(id + "_plate" + id, Item::new)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/" + id + "/plate")))
                .lang(name + " PlateItem")
                .tag(ModItemTags.Items.PLATES)
                .register();
    }

    public static void register() {
    }
}