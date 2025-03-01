package top.elake.elaketech.register.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ModCreativeModeTab;

import java.util.List;

/**
 * @author Erhai-lake Qi-Month
 */
public class Elements {
    static {
        ElakeTech.REGISTER.defaultCreativeTab(ModCreativeModeTab.ELEMENTS.get());
    }

    public static void register() {
        List<String> elementsGroup = List.of("h", "he", "li", "be", "b", "c", "n", "o", "f", "ne", "na", "mg", "al", "si", "p", "s", "cl", "ar", "k", "ca", "sc", "ti", "v", "cr", "mn", "fe", "co", "ni", "cu", "zn", "ga", "ge", "as", "se", "br", "kr", "rb", "sr", "y", "zr", "nb", "mo", "tc", "ru", "rh", "pd", "ag", "cd", "in", "sn", "sb", "te", "i", "xe", "cs", "ba", "la", "ce", "pr", "nd", "pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm", "yb", "lu", "hf", "ta", "w", "re", "os", "ir", "pt", "au", "hg", "tl", "pb", "bi", "po", "at", "rn", "fr", "ra", "ac", "th", "pa", "u", "np", "pu", "am", "cm", "bk", "cf", "es", "fm", "md", "no", "lr", "rf", "db", "sg", "bh", "hs", "mt", "ds", "rg", "cn", "nh", "fl", "mc", "lv", "ts", "og");
        elementsGroup.forEach((element) -> {
            ElakeTech.REGISTER.item(element, Item::new)
                    .lang(element)
                    .model((c, p) -> p.generated(c, p.modLoc("item/element/" + element)))
                    .properties((properties) -> properties
                            .rarity(Rarity.EPIC))
                    .register();
        });
    }
}