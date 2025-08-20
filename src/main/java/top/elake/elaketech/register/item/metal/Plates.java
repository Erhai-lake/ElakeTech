package top.elake.elaketech.register.item.metal;

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

    public static ItemEntry<Item> TIN;
    public static ItemEntry<Item> BRONZE;
    public static ItemEntry<Item> GRAPHITE;

    static {
        // 锡
        TIN = addPlateItem("tin", 0xE1FFFF);
        // 青铜
        BRONZE = addPlateItem("bronze", 0xFFC370);
        // 石墨
        GRAPHITE = addPlateItem("graphite");
    }

    public static ItemEntry<Item> addPlateItem(String id, int color) {
        int fullColor = 0xFF000000 | color;
        return ElakeTech.REGISTER.item(id + "_plate", Item::new)
                .color(() -> () -> (itemStack, tintIndex) -> fullColor)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/color/plate")))
                .tag(ModItemTags.PLATES)
                .tag(ModItemTags.createItemTag("c", "plates/" + id))
                .register();
    }

    public static ItemEntry<Item> addPlateItem(String id) {
        return ElakeTech.REGISTER.item(id + "_plate", Item::new)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/" + id + "/plate")))
                .tag(ModItemTags.PLATES)
                .tag(ModItemTags.createItemTag("c", "plates/" + id))
                .register();
    }
}