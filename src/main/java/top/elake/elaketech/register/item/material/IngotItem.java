package top.elake.elaketech.register.item.material;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;

import static top.elake.elaketech.ElakeTech.REGISTRATE;

/**
 * @author Qi-Month Erhai-lake
 */
public class IngotItem {
    public static ItemEntry<Item> TIN = addColorIngotItem("tin", "Tin", 0xFFE1FFFF);
    public static ItemEntry<Item> BRONZE = addColorIngotItem("bronze", "Bronze", 0xFFFF8C00);
    public static ItemEntry<Item> GRAPHITE = addAloneIngotItem("graphite", "Graphite");

    /**
     * @param id    注册id
     * @param name  材料名称
     * @param color 颜色
     */
    public static ItemEntry<Item> addColorIngotItem(String id, String name, int color) {
        return REGISTRATE.item(id + "_ingot", Item::new)
                .color(() -> () -> (itemStack, tintIndex) -> color)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/color/ingot")))
                .tag(Tags.Items.INGOTS)
                .lang(name + " Inogt")
                .register();
    }

    public static ItemEntry<Item> addAloneIngotItem(String id, String name) {
        return REGISTRATE.item(id + "_ingot", Item::new)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/" + id + "/ingot")))
                .lang(name + " Inogt")
                .tag(Tags.Items.INGOTS)
                .register();
    }

    public static void register() {
    }
}