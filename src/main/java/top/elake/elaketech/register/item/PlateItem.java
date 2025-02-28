package top.elake.elaketech.register.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.tag.ModItemTags;

/**
 * @author Qi-Month
 */
public class PlateItem {
    public static ItemEntry<Item> TIN = registerColorPlateItem("tin", "Tin", 0xFFE1FFFF);
    public static ItemEntry<Item> GRAPHITE = registerOtherPlateItem("graphite", "Graphite");

    public static ItemEntry<Item> registerColorPlateItem(String id, String name, int color) {
        return ElakeTech.REGISTER.item(id + "_plate", Item::new)
                .color(() -> () -> (itemStack, tintIndex) -> color)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/color/plate")))
                .lang(name + "Plate")
                .tag(ModItemTags.Items.PLATES)
                .register();
    }

    public static ItemEntry<Item> registerOtherPlateItem(String id, String name) {
        return ElakeTech.REGISTER.item(id + "_plate" + id, Item::new)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/" + id + "/plate")))
                .lang(name + "Plate")
                .tag(ModItemTags.Items.PLATES)
                .register();
    }

    public static void register() {
    }
}