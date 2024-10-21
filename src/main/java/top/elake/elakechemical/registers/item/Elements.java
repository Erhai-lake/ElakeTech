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
     * Item
     */
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ElakeChemical.MODID);

    /**
     * 已注册的元素
     */
    public static final List<DeferredItem<Item>> REGISTERED_ELEMENTS = new ArrayList<>();

    /**
     * 元素ID列表
     */
    public static String[] ELEMENTS_ITEM_ARR = new String[]{
            "hydrogen", "helium", "lithium", "beryllium", "boron", "carbon", "nitrogen", "oxygen", "fluorine", "neon", "natrium", "magnesium", "aluminium", "silicon", "phosphorus", "sulfur", "chlorine", "argon", "kalium", "calcium", "scandium", "titanium", "vanadium", "chromium", "manganese", "ferrum", "cobalt", "nickel", "cuprum", "zinc", "gallium", "germanium", "arsenic", "selenium", "bromine", "krypton", "rubidium", "strontium", "yttrium", "zirconium", "niobium", "molybdenum", "technetium", "ruthenium", "rhodium", "palladium", "argentum", "cadmium", "indium", "stannum", "stibium", "tellurium", "iodine", "xenon", "cesium", "barium", "lanthanum", "cerium", "praseodymium", "neodymium", "promethium", "samarium", "europium", "gadolinium", "terbium", "dysprosium", "holmium", "erbium", "thulium", "ytterbium", "lutetium", "hafnium", "tantalum", "tungsten", "rhenium", "osmium", "iridium", "platinum", "aurum", "hydrargyrum", "thallium", "lead", "bismuth", "polonium", "astatine", "radon", "francium", "radium", "actinium", "thorium", "protactinium", "uranium", "neptunium", "plutonium", "americium", "curium", "berkelium", "californium", "einsteinium", "fermium", "mendelevium", "nobelium", "lawrencium", "rutherfordium", "dubnium", "seaborgium", "bohrium", "hassium", "meitnerium", "darmstadtium", "roentgenium", "copernicium", "nihonium", "flerovium", "moscovium", "livermorium", "tennessine", "oganesson"
    };

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
        DeferredItem<Item> item = ITEMS.registerItem(
                name,
                Item::new,
                new Item.Properties()
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