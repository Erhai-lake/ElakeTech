package top.elake.elaketech.register.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ModCreativeModeTab;

import java.util.Locale;

/**
 * @author Qi-Month
 */
public class Element {
    static {
        ElakeTech.REGISTER.defaultCreativeTab(ModCreativeModeTab.ELEMENTS.getKey());
    }

    public enum Elements {
        // 元素组
        H, He, Li, Be, B, C, N, O, F, Ne, Na, Mg, Al, Si, P, S, Cl, Ar, K, Ca, Sc, Ti, V, Cr, Mn, Fe, Co, Ni, Cu, Zn, Ga, Ge, As, Se, Br, Kr, Rb, Sr, Y, Zr, Nb, Mo, Tc, Ru, Rh, Pd, Ag, Cd, In, Sn, Sb, Te, I, Xe, Cs, Ba, La, Ce, Pr, Nd, Pm, Sm, Eu, Gd, Tb, Dy, Ho, Er, Tm, Yb, Lu, Hf, Ta, W, Re, Os, Ir, Pt, Au, Hg, Tl, Pb, Bi, Po, At;

        public final ItemEntry<Item> item;

        Elements() {
            String id = name().toLowerCase(Locale.ROOT);
            item = ElakeTech.REGISTER.item(id, Item::new)
                    .lang(id)
                    .model((c, p) -> p.generated(c, p.modLoc("item/element/" + id)))
                    .properties((properties) -> properties
                            .fireResistant()
                            .rarity(Rarity.EPIC))
                    .register();
        }

        public static void register() {
        }
    }
}