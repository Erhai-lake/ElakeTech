package top.elake.elaketech.register.item.ores;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.tag.ModItemTags;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTER;

/**
 * @author Qi-Month
 */
public class OreItem {
    public static void register() {
    }

    static {
        REGISTER.defaultCreativeTab(Objects.requireNonNull(ElakeTechCreativeModeTabs.MATERIALS_TAB.getKey()));
    }

    public static ItemEntry<Item> TIN = registerColorOreItem("tin", 0xFFE1FFFF);
    public static ItemEntry<Item> GRAPHITE = registerAloneOreItem("graphite");

    public static ItemEntry<Item> registerColorOreItem(String id, int color) {
        return ElakeTech.REGISTER.item("raw_" + id, Item::new)
                .color(() -> () -> (itemStack, tintIndex) -> color)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/color/raw_ore")))
                .tag(Tags.Items.RAW_MATERIALS)
                .tag(ModItemTags.createItemTag("c", "raw_materials/" + id))
                .register();
    }

    public static ItemEntry<Item> registerAloneOreItem(String id) {
        return ElakeTech.REGISTER.item("raw_" + id, Item::new)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/" + id + "/ore")))
                .tag(Tags.Items.RAW_MATERIALS)
                .tag(ModItemTags.createItemTag("c", "raw_materials/" + id))
                .register();
    }
}