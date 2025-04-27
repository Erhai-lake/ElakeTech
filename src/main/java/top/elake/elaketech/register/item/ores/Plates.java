package top.elake.elaketech.register.item.ores;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.tag.ModItemTags;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTER;

/**
 * @author Qi-Month
 */
public class Plates {
    public static void register() {
    }

    static {
        REGISTER.defaultCreativeTab(Objects.requireNonNull(ElakeTechCreativeModeTabs.MATERIALS_TAB.getKey()));
    }

    public static ItemEntry<Item> TIN = registerColorPlateItem("tin", 0xFFE1FFFF);
    public static ItemEntry<Item> GRAPHITE = registerAlonePlateItem("graphite");

    public static ItemEntry<Item> registerColorPlateItem(String id, int color) {
        return ElakeTech.REGISTER.item(id + "_plate", Item::new)
                .color(() -> () -> (itemStack, tintIndex) -> color)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/color/plate")))
                .tag(ModItemTags.Items.PLATES)
                .tag(ModItemTags.createItemTag("c", "plates/" + id))
                .register();
    }

    public static ItemEntry<Item> registerAlonePlateItem(String id) {
        return ElakeTech.REGISTER.item(id + "_plate", Item::new)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/" + id + "/plate")))
                .tag(ModItemTags.Items.PLATES)
                .tag(ModItemTags.createItemTag("c", "plates/" + id))
                .register();
    }
}