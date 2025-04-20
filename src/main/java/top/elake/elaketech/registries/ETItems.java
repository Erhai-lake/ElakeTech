package top.elake.elaketech.registries;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTRATE;

/**
 * @author Erhai-lake
 */
public class ETItems {
    public static void register() {
    }

    static {
        REGISTRATE.defaultCreativeTab(Objects.requireNonNull(ETCreativeTabs.TEST_TAB.getKey()));
    }

    public static ItemEntry<Item> TEST = REGISTRATE.item("test", Item::new)
            .lang("Test")
            .model((c, p) -> p.generated(c, p.modLoc("item/a")))
            .register();
}
