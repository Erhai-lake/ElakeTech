package top.elake.elaketech.register.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ModCreativeModeTab;

/**
 * @author Qi-Month Erhai-lake
 */
public class IngotItem {
    public static ItemEntry<Item> TIN = registerColorIngotItem("tin", "Tin", 0xFFE1FFFF);
    public static ItemEntry<Item> BRONZE = registerColorIngotItem("bronze", "Bronze", 0xFFFF8C00);
    public static ItemEntry<Item> GRAPHITE = registerOtherIngotItem("graphite", "Graphite");

    /**
     * @param id
     * @param name
     * @param color
     * @return
     */
    public static ItemEntry<Item> registerColorIngotItem(String id, String name, int color) {
        return ElakeTech.REGISTER.item(id + "_ingot", Item::new)
                .color(() -> () -> (itemStack, tintIndex) -> color)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/color/ingot")))
                .tag(Tags.Items.INGOTS)
//                .tab(ResourceKey.create(Registries.CREATIVE_MODE_TAB, ElakeTech.loadResource("test")))
                .lang(name + " Inogt")
                .register();
    }

    public static ItemEntry<Item> registerOtherIngotItem(String id, String name) {
        return ElakeTech.REGISTER.item(id + "_ingot", Item::new)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/" + id + "/ingot")))
                .lang(name + " Inogt")
                .tag(Tags.Items.INGOTS)
                .register();
    }

    public static void register() {
    }
}