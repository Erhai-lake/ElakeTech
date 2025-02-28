package top.elake.elaketech.register.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import top.elake.elaketech.ElakeTech;

/**
 * @author Erhai-lake
 */
public class Materials {
    static {
        ElakeTech.REGISTER.defaultCreativeTab("material", (c) -> {
            c.title(Component.translatable("itemGroup" + ElakeTech.MODID + "material"));
//            c.icon(() -> new ItemStack());
            c.build();
        });
    }

    /**
     * 草纤维
     */
    public static final ItemEntry<Item> GRASS_FIBER = ElakeTech.REGISTER.item("grass_fiber", Item::new)
            .lang("Grass Fiber")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/grass_fiber")))
            .register();
    /**
     * 草绳
     */
    public static final ItemEntry<Item> GRASS_STRING = ElakeTech.REGISTER.item("grass_string", Item::new)
            .lang("Grass String")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/grass_string")))
            .register();
    /**
     * 石墨锭
     */
    public static final ItemEntry<Item> GRAPHITE_INGOT = ElakeTech.REGISTER.item("graphite_ingot", Item::new)
            .lang("Graphite Ingot")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/graphite/ingot")))
            .register();
    /**
     * 石墨板
     */
    public static final ItemEntry<Item> GRAPHITE_PLATE = ElakeTech.REGISTER.item("graphite_plate", Item::new)
            .lang("Graphite Plate")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/alone/graphite/plate")))
            .register();
    /**
     * 粉碎白云岩
     */
    public static final ItemEntry<Item> FRAGMENT_DOLOMITE = ElakeTech.REGISTER.item("fragment_dolomite", Item::new)
            .lang("Fragment Dolomite")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/fragment_dolomite")))
            .register();
    /**
     * 高岭土
     */
    public static final ItemEntry<Item> KAOLINITE = ElakeTech.REGISTER.item("kaolinite", Item::new)
            .lang("Kaolinite")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/kaolinite")))
            .register();
    /**
     * 耐火砖
     */
    public static final ItemEntry<Item> REFRACTORY_BRICK = ElakeTech.REGISTER.item("refractory_brick", Item::new)
            .lang("Refractory Brick")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/refractory_brick")))
            .register();
    /**
     * 潮湿耐火砖
     */
    public static final ItemEntry<Item> WET_REFRACTORY_BRICK = ElakeTech.REGISTER.item("wet_refractory_brick", Item::new)
            .lang("Wet Refractory Brick")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/wet_refractory_brick")))
            .register();
    /**
     * 耐火黏土
     */
    public static final ItemEntry<Item> REFRACTORY_CLAY_BALL = ElakeTech.REGISTER.item("refractory_clay_ball", Item::new)
            .lang("Refractory Clay Ball")
            .model((c, p) -> p.generated(c, p.modLoc("item/materials/refractory_clay_ball")))
            .register();

    public static void register() {
    }
}