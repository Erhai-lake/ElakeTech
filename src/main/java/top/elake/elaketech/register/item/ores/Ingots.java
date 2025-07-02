package top.elake.elaketech.register.item.ores;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.tag.ModItemTags;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTER;

/**
 * @author Elake Studio
 */
public class Ingots {
    /**
     * 注册矿物
     */
    public static void register() {
    }

    static {
        REGISTER.defaultCreativeTab(Objects.requireNonNull(ElakeTechCreativeModeTabs.MATERIALS_TAB.getKey()));
    }

    public static ItemEntry<Item> TIN = addIngotItem("tin", 0xFFE1FFFF);
    public static ItemEntry<Item> BRONZE = addIngotItem("bronze", 0xFFFF8C00);
    public static ItemEntry<Item> GRAPHITE = addIngotItem("graphite");

    /**
     * 注册颜色矿物锭
     *
     * @param id    id
     * @param color 颜色
     * @return ItemEntry
     */
    public static ItemEntry<Item> addIngotItem(String id, int color) {
        return REGISTER.item(id + "_ingot", Item::new)
                .color(() -> () -> (itemStack, tintIndex) -> color)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/color/ingot")))
                .tag(Tags.Items.INGOTS)
                .tag(ModItemTags.createItemTag("c", "ingots/" + id))
                .register();
    }

    /**
     * 注册其他矿物锭
     *
     * @param id id
     * @return ItemEntry
     */
    public static ItemEntry<Item> addIngotItem(String id) {
        return REGISTER.item(id + "_ingot", Item::new)
                .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/" + id + "/ingot")))
                .tag(Tags.Items.INGOTS)
                .tag(ModItemTags.createItemTag("c", "ingots/" + id))
                .register();
    }
}