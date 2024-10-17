package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elakechemical.ElakeChemical;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Elements {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ElakeChemical.MODID);
    public static final List<DeferredItem<Item>> REGISTERED_ELEMENTS = new ArrayList<DeferredItem<Item>>();

    public static String[] ElementsItemArr = new String[]{
            "hydrogen", "helium", "lithium", "beryllium", "boron", "carbon", "nitrogen", "oxygen", "fluorine", "neon", "natrium", "magnesium", "aluminium", "silicon", "phosphorus", "sulfur", "chlorine", "argon", "kalium", "calcium", "scandium", "titanium", "vanadium", "chromium", "manganese", "ferrum", "cobalt", "nickel", "cuprum", "zinc", "gallium", "germanium", "arsenic", "selenium", "bromine", "krypton", "rubidium", "strontium", "yttrium", "zirconium", "niobium", "molybdenum", "technetium", "ruthenium", "rhodium", "palladium", "argentum", "cadmium", "indium", "stannum", "stibium", "tellurium", "iodine", "xenon", "cesium", "barium", "lanthanum", "cerium", "praseodymium", "neodymium", "promethium", "samarium", "europium", "gadolinium", "terbium", "dysprosium", "holmium", "erbium", "thulium", "ytterbium", "lutetium", "hafnium", "tantalum", "tungsten", "rhenium", "osmium", "iridium", "platinum", "aurum", "hydrargyrum", "thallium", "lead", "bismuth", "polonium", "astatine", "radon", "francium", "radium", "actinium", "thorium", "protactinium", "uranium", "neptunium", "plutonium", "americium", "curium", "berkelium", "californium", "einsteinium", "fermium", "mendelevium", "nobelium", "lawrencium", "rutherfordium", "dubnium", "seaborgium", "bohrium", "hassium", "meitnerium", "darmstadtium", "roentgenium", "copernicium", "nihonium", "flerovium", "moscovium", "livermorium", "tennessine", "oganesson"
    };

    public static void register(IEventBus eventBus) {
        for (String element : ElementsItemArr) {
            DeferredItem<Item> item = ITEMS.registerSimpleItem(element, new Item.Properties()
                    .rarity(Rarity.EPIC));
            REGISTERED_ELEMENTS.add(item);
        }
        ITEMS.register(eventBus);
    }

    public static List<DeferredItem<Item>> getRegisteredElements() {
        return REGISTERED_ELEMENTS;
    }
}