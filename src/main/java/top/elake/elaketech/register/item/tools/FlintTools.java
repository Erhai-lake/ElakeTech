package top.elake.elaketech.register.item.tools;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.*;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.util.tools.ToolBuilder;
import top.elake.elaketech.util.tools.ToolType;

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
    public static final ItemEntry<? extends Item> FLINT_SWORD = new ToolBuilder()
            .id("flint_sword")
            .type(ToolType.SWORD)
            .tier(ElakeTechTiers.FLINT_TIER)
            .property(3, -2.4f)
            .texture("tools/flint/sword")
            .build();

    /**
     * 镐
     */
    public static final ItemEntry<? extends Item> FLINT_PICKAXE = new ToolBuilder()
            .id("flint_pickaxe")
            .type(ToolType.PICKAXE)
            .tier(ElakeTechTiers.FLINT_TIER)
            .property(1, -2.8f)
            .texture("tools/flint/pickaxe")
            .build();

    /**
     * 斧
     */
    public static final ItemEntry<? extends Item> FLINT_AXE = new ToolBuilder()
            .id("flint_axe")
            .type(ToolType.AXE)
            .tier(ElakeTechTiers.FLINT_TIER)
            .property(3, -2.8f)
            .texture("tools/flint/axe")
            .build();

    /**
     * 手斧
     */
    public static final ItemEntry<? extends Item> FLINT_HATCHET = new ToolBuilder()
            .id("flint_hatchet")
            .type(ToolType.AXE)
            .tier(ElakeTechTiers.FLINT_HATCHET_TIER)
            .property(1, -2)
            .texture("tools/flint/hatchet")
            .build();

    /**
     * 锹
     */
    public static final ItemEntry<? extends Item> FLINT_SHOVEL = new ToolBuilder()
            .id("flint_shovel")
            .type(ToolType.SHOVEL)
            .tier(ElakeTechTiers.FLINT_TIER)
            .property(1, -2)
            .texture("tools/flint/shovel")
            .build();

    /**
     * 锄
     */
    public static final ItemEntry<? extends Item> FLINT_HOE = new ToolBuilder()
            .id("flint_hoe")
            .type(ToolType.HOE)
            .tier(ElakeTechTiers.FLINT_TIER)
            .property(1, -2)
            .texture("tools/flint/hoe")
            .build();
}