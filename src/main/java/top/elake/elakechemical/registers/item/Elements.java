package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;

import java.util.ArrayList;
import java.util.List;

/**
 * 元素物品注册类
 *
 * @author Erhai_lake
 */
public class Elements {
    /**
     * 元素ID列表
     */
    public static String[] ELEMENTS_ITEM_ARR = new String[]{
            "h", "he", "li", "be", "b", "c", "n", "o", "f", "ne", "na", "mg", "al", "si", "p", "s", "cl", "ar", "k", "ca", "sc", "ti", "v", "cr", "mn", "fe", "co", "ni", "cu", "zn", "ga", "ge", "as", "se", "br", "kr", "rb", "sr", "y", "zr", "nb", "mo", "tc", "ru", "rh", "pd", "ag", "cd", "in", "sn", "sb", "te", "i", "xe", "cs", "ba", "la", "ce", "pr", "nd", "pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm", "yb", "lu", "hf", "ta", "w", "re", "os", "ir", "pt", "au", "hg", "tl", "pb", "bi", "po", "at", "rn", "fr", "ra", "ac", "th", "pa", "u", "np", "pu", "am", "cm", "bk", "cf", "es", "fm", "md", "no", "lr", "rf", "db", "sg", "bh", "hs", "mt", "ds", "rg", "cn", "nh", "fl", "mc", "lv", "ts", "og"
    };

    /**
     * Item
     */
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ElakeChemical.MODID);

    /**
     * 已注册的元素
     */
    public static final List<DeferredItem<Item>> REGISTERED_ELEMENTS = new ArrayList<>();

    /**
     * 注册
     *
     * @param eventBus 事件总线
     */
    public static void register(IEventBus eventBus) {
        for (String element : ELEMENTS_ITEM_ARR) {
            registerElement(element);
        }
        ITEMS.register(eventBus);
    }

    /**
     * 注册单个元素物品
     *
     * @param name 物品名称
     */
    private static void registerElement(String name) {
        DeferredItem<Item> item = ITEMS.registerItem(name, Item::new, new Item.Properties()
                .rarity(Rarity.EPIC)
        );
        REGISTERED_ELEMENTS.add(item);
    }

    /**
     * 获取已注册的元素物品列表
     *
     * @return 已注册的元素物品列表
     */
    public static List<DeferredItem<Item>> getRegisteredElements() {
        return REGISTERED_ELEMENTS;
    }
}