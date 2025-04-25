package top.elake.elaketech.register.item.tools;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.*;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.util.ToolsUtil;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTER;

/**
 * @author Elake Studio
 */
public class FlintTools {
    /**
     * 注册燧石工具
     */
    public static void register() {
    }

    static {
        REGISTER.defaultCreativeTab(Objects.requireNonNull(ElakeTechCreativeModeTabs.TOOLS_TAB.getKey()));
    }

    /**
     * 剑
     */
    public static final ItemEntry<? extends Item> FLINT_SWORD = ToolsUtil.registerAloneTool(
            "flint_sword",
            "Flint Sword",
            "sword",
            Tiers.FLINT_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.FLINT_TIER, 3, -2.4f)), 0,
            "item/tools/flint/sword"
    );

    /**
     * 镐
     */
    public static final ItemEntry<? extends Item> FLINT_PICKAXE = ToolsUtil.registerAloneTool(
            "flint_pickaxe",
            "Flint Pickaxe",
            "pickaxe",
            Tiers.FLINT_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.FLINT_TIER, 1, -2.8f)), 0,
            "item/tools/flint/pickaxe"
    );

    /**
     * 斧
     */
    public static final ItemEntry<? extends Item> FLINT_AXE = ToolsUtil.registerAloneTool(
            "flint_axe",
            "Flint Axe",
            "axe",
            Tiers.FLINT_TIER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(Tiers.FLINT_TIER, 1, -2)), 0,
            "item/tools/flint/axe"
    );

    /**
     * 手斧
     */
    public static final ItemEntry<? extends Item> FLINT_HATCHET = ToolsUtil.registerAloneTool(
            "flint_hatchet",
            "Flint Hatchet",
            "axe",
            Tiers.FLINT_HATCHET_TIER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(Tiers.FLINT_HATCHET_TIER, 1, -2)), 0,
            "item/tools/flint/hatchet"
    );

    /**
     * 锹
     */
    public static final ItemEntry<? extends Item> FLINT_SHOVEL = ToolsUtil.registerAloneTool(
            "flint_shovel",
            "Flint Shovel",
            "shovel",
            Tiers.FLINT_TIER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(Tiers.FLINT_TIER, 1, -2)), 0,
            "item/tools/flint/shovel"
    );

    /**
     * 锄
     */
    public static final ItemEntry<? extends Item> FLINT_HOE = ToolsUtil.registerAloneTool(
            "flint_hoe",
            "Flint Hoe",
            "hoe",
            Tiers.FLINT_TIER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(Tiers.FLINT_TIER, 1, -2)), 0,
            "item/tools/flint/hoe"
    );
}
