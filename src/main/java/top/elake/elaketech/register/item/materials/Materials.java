package top.elake.elaketech.register.item.materials;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.util.ItemTooltipExtensions;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTRATE;

/**
 * @author Elake Studio
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
     * 杂草
     */
    public static ItemEntry<Item> GRASS_FIBER = REGISTRATE.item("grass_fiber", Item::new)
            .transform((b) -> ItemTooltipExtensions.tooltip(b, Component.translatable("tooltip.elaketech.grass_fiber")))
            .lang("Grass Fiber")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/grass_fiber")))
            .register();

    /**
     * 草绳
     */
    public static ItemEntry<Item> GRASS_STRING = REGISTRATE.item("grass_string", Item::new)
            .lang("Grass String")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/grass_string")))
            .register();


}