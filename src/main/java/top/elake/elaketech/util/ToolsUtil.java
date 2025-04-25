package top.elake.elaketech.util;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import top.elake.elaketech.util.tools.*;

import static top.elake.elaketech.ElakeTech.REGISTER;


/**
 * @author Erhai-lake
 */
public class ToolsUtil {
    /**
     * 注册工具
     *
     * @param name       名称
     * @param type       类型: Sword/Pickaxe/Axe/Shovel/Hoe
     * @param tier       等级
     * @param properties 工具属性
     * @return 工具句柄
     */
    public static ItemEntry<? extends Item> registerAloneTool(String id, String type, Tier tier, Item.Properties properties, int craftingDamage, String texture) {
        return switch (type) {
            case "sword" -> REGISTER.item(id,
                            (p) -> new SwordDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .register();
            case "pickaxe" -> REGISTER.item(id,
                            (p) -> new PickaxeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .register();
            case "axe" -> REGISTER.item(id,
                            (p) -> new AxeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .register();
            case "shovel" -> REGISTER.item(id,
                            (p) -> new ShovelDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .register();
            case "hoe" -> REGISTER.item(id,
                            (p) -> new HoeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .register();
            case "hammer" -> REGISTER.item(id,
                            (p) -> new HammerDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> p.generated(c, p.modLoc(texture)))
                    .register();
            default -> throw new IllegalArgumentException("Error Type");
        };
    }

    public static ItemEntry<? extends Item> registerColorTool(String id, int color, String type, Tier tier, Item.Properties properties, int craftingDamage) {
        return switch (type) {
            case "sword" -> REGISTER.item(id,
                            (p) -> new SwordDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/sword/head"));
                        p.handheld(c, p.modLoc("item/tool/color/sword/handle"));
                    })
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            case "pickaxe" -> REGISTER.item(id,
                            (p) -> new PickaxeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/pickaxe/head"));
                        p.handheld(c, p.modLoc("item/tool/color/pickaxe/handle"));
                    })
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            case "axe" -> REGISTER.item(id,
                            (p) -> new AxeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/axe/head"));
                        p.handheld(c, p.modLoc("item/tool/color/axe/handle"));
                    })
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            case "shovel" -> REGISTER.item(id,
                            (p) -> new ShovelDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/shovel/head"));
                        p.handheld(c, p.modLoc("item/tool/color/shovel/handle"));
                    })
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            case "hoe" -> REGISTER.item(id,
                            (p) -> new HoeDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/hoe/head"));
                        p.handheld(c, p.modLoc("item/tool/color/hoe/handle"));
                    })
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            case "hammer" -> REGISTER.item(id,
                            (p) -> new HammerDamageToolCrafting(tier, properties, craftingDamage))
                    .model((c, p) -> {
                        p.handheld(c, p.modLoc("item/tool/color/hammer/head"));
                        p.handheld(c, p.modLoc("item/tool/color/hammer/handle"));
                    })
                    .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                    .register();
            default -> throw new IllegalArgumentException("Error Type");
        };
    }
}