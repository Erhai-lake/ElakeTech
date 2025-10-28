package top.elake.elaketech.register.item.metal;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.tag.ModItemTags;
import top.elake.elaketech.util.UtilsMethod;

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

    public static ItemEntry<Item> TIN;
    public static ItemEntry<Item> GRAPHITE;

    static {
        // 锡
        TIN = addOreItem("tin", 0xE1FFFF);
        // 石墨
        GRAPHITE = addOreItem("graphite");
    }

    public static ItemEntry<Item> addOreItem(String id, int color) {
        return ElakeTech.REGISTER.item("raw_" + id, Item::new)
                .color(() -> () -> (itemStack, tintIndex) -> UtilsMethod.colorConversion(color))
                .model((context, provider) -> {
                    provider.generated(context, provider.modLoc("item/materials/color/raw_ore"));
                })
                .tag(Tags.Items.RAW_MATERIALS)
                .tag(ModItemTags.createItemTag("c", "raw_materials/" + id))
                .register();
    }

    public static ItemEntry<Item> addOreItem(String id) {
        return ElakeTech.REGISTER.item("raw_" + id, Item::new)
                .model((context, provider) -> {
                    provider.generated(context, provider.modLoc("item/materials/alone/" + id + "/ore"));
                })
                .tag(Tags.Items.RAW_MATERIALS)
                .tag(ModItemTags.createItemTag("c", "raw_materials/" + id))
                .register();
    }
}