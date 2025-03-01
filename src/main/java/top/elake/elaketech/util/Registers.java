package top.elake.elaketech.util;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.util.tool.*;


/**
 * @author Erhai-lake
 */
public class Registers {
    /**
     * 注册工具
     *
     * @param name       名称
     * @param type       类型: Sword/Pickaxe/Axe/Shovel/Hoe
     * @param tier       等级
     * @param properties 工具属性
     * @return 工具句柄
     */
    public static ItemEntry<? extends Item> registerAloneTool(String id, String name, String type, Tier tier, Item.Properties properties, int craftingDamage, String texture) {
        return switch (type) {
            case "sword" -> ElakeTech.REGISTER.<SwordDamageToolCrafting>item(id,
                            (p) -> new SwordDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .lang(name)
                    .register();
            case "pickaxe" -> ElakeTech.REGISTER.<PickaxeDamageToolCrafting>item(id,
                            (p) -> new PickaxeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .lang(name)
                    .register();
            case "axe" -> ElakeTech.REGISTER.<AxeDamageToolCrafting>item(id,
                            (p) -> new AxeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .lang(name)
                    .register();
            case "shovel" -> ElakeTech.REGISTER.<ShovelDamageToolCrafting>item(id,
                            (p) -> new ShovelDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .lang(name)
                    .register();
            case "hoe" -> ElakeTech.REGISTER.<HoeDamageToolCrafting>item(id,
                            (p) -> new HoeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .lang(name)
                    .register();
            case "hammer" -> ElakeTech.REGISTER.<HammerDamageToolCrafting>item(id,
                            (p) -> new HammerDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .lang(name)
                    .register();
            default -> throw new IllegalArgumentException("Error Type");
        };
    }

    public static ItemEntry<? extends Item> registerColorTool(String id, String name, int color, String type, Tier tier, Item.Properties properties, int craftingDamage) {
        return switch (type) {
            case "sword" -> ElakeTech.REGISTER.<SwordDamageToolCrafting>item(id,
                            (p) -> new SwordDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/sword/head"));
                        p.handheld(c, p.modLoc("item/tool/color/sword/handle"));
                    })
                    .lang(name)
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            case "pickaxe" -> ElakeTech.REGISTER.<PickaxeDamageToolCrafting>item(id,
                            (p) -> new PickaxeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/pickaxe/head"));
                        p.handheld(c, p.modLoc("item/tool/color/pickaxe/handle"));
                    })
                    .lang(name)
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            case "axe" -> ElakeTech.REGISTER.<AxeDamageToolCrafting>item(id,
                            (p) -> new AxeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/axe/head"));
                        p.handheld(c, p.modLoc("item/tool/color/axe/handle"));
                    })
                    .lang(name)
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            case "shovel" -> ElakeTech.REGISTER.<ShovelDamageToolCrafting>item(id,
                            (p) -> new ShovelDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/shovel/head"));
                        p.handheld(c, p.modLoc("item/tool/color/shovel/handle"));
                    })
                    .lang(name)
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            case "hoe" -> ElakeTech.REGISTER.<HoeDamageToolCrafting>item(id,
                            (p) -> new HoeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/hoe/head"));
                        p.handheld(c, p.modLoc("item/tool/color/hoe/handle"));
                    })
                    .lang(name)
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            case "hammer" -> ElakeTech.REGISTER.<HammerDamageToolCrafting>item(id,
                            (p) -> new HammerDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/hammer/head"));
                        p.handheld(c, p.modLoc("item/tool/color/hammer/handle"));
                    })
                    .lang(name)
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            default -> throw new IllegalArgumentException("Error Type");
        };
    }
}