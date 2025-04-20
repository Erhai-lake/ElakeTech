package top.elake.elaketech.register.item.material;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;

import static top.elake.elaketech.ElakeTech.REGISTRATE;

/**
 * @author Qi-Month
 */
public class OreItem {
    public static ItemEntry<Item> TIN = registerColorOreItem("tin", "Tin", 0xFFE1FFFF);
    public static ItemEntry<Item> GRAPHITE = registerOtherOreItem("graphite", "Graphite");

    public static ItemEntry<Item> registerColorOreItem(String id, String name, int color) {
        return REGISTRATE.item("raw_" + id, Item::new)
                .color(() -> () -> (itemStack, tintIndex) -> color)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/color/raw_ore")))
                .tag(Tags.Items.RAW_MATERIALS)
                .lang("Raw " + name)
                .register();
    }

    public static ItemEntry<Item> registerOtherOreItem(String id, String name) {
        return REGISTRATE.item("raw_" + id, Item::new)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/" + id + "/ore")))
                .lang("Raw " + name)
                .tag(Tags.Items.RAW_MATERIALS)
                .register();
    }

    public static void register() {
    }
}