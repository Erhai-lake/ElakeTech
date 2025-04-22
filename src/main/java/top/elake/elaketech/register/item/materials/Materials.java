package top.elake.elaketech.register.item.materials;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTRATE;

/**
 * @author ElakeStudio
 */
public class Materials {
    /**
     * 注册材料
     */
    public static void register() {
    }

    static {
        REGISTRATE.defaultCreativeTab(Objects.requireNonNull(ElakeTechCreativeModeTabs.MATERIALS_TAB.getKey()));
    }

    /**
     * 草纤维
     */
    public static ItemEntry<Item> GRASS_FIBER = REGISTRATE.item("grass_fiber", Item::new)
            .lang("Grass Fiber")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/grass_fiber")))
            .register();

}
