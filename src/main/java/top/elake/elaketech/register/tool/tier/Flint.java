package top.elake.elaketech.register.tool.tier;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.tag.ModItemTags;
import top.elake.elaketech.util.Registers;

/**
 * @author Erhai-lake
 */
public class Flint {
//    static {
//        ElakeTech.REGISTER.defaultCreativeTab(ModCreativeModeTab.TOOLS.getKey());
//    }

    public static void register() {
    }

    /**
     * 燧石工具等级
     */
    public static final Tier FLINT_TIER = new SimpleTier(
            Tiers.STONE.getIncorrectBlocksForDrops(),
            60,
            3F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    /**
     * 燧石手斧等级
     */
    public static final Tier FLINT_HATCHET_TIER = new SimpleTier(
            Tiers.STONE.getIncorrectBlocksForDrops(),
            40,
            1.5F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    /**
     * 剑
     */
    public static final ItemEntry<? extends Item> FLINT_SWORD = Registers.registerAloneTool(
            "flint_sword",
            "Flint Sword",
            "sword",
            FLINT_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(FLINT_TIER, 3, -2.4f)), 0,
            "item/tool/flint/sword"
    );
    /**
     * 镐
     */
    public static final ItemEntry<? extends Item> FLINT_PICKAXE = Registers.registerAloneTool(
            "flint_pickaxe",
            "Flint Pickaxe",
            "pickaxe",
            FLINT_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(FLINT_TIER, 1, -2.8f)), 0,
            "item/tool/flint/pickaxe"
    );
    /**
     * 斧
     */
    public static final ItemEntry<? extends Item> FLINT_AXE = Registers.registerAloneTool(
            "flint_axe",
            "Flint Axe",
            "axe",
            FLINT_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(FLINT_TIER, 1, -2)), 0,
            "item/tool/flint/axe"
    );
    /**
     * 手斧
     */
    public static final ItemEntry<? extends Item> FLINT_HATCHET = Registers.registerAloneTool(
            "flint_hatchet",
            "Flint Hatchet",
            "axe",
            FLINT_TIER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(FLINT_HATCHET_TIER, 1, -2)), 0,
            "item/tool/flint/hatchet"
    );
    /**
     * 锹
     */
    public static final ItemEntry<? extends Item> FLINT_SHOVEL = Registers.registerAloneTool(
            "flint_shovel",
            "Flint Shovel",
            "shovel",
            FLINT_TIER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(FLINT_TIER, 1, -2)), 0,
            "item/tool/flint/shovel"
    );
    /**
     * 锄
     */
    public static final ItemEntry<? extends Item> FLINT_HOE = Registers.registerAloneTool(
            "flint_hoe",
            "Flint Hoe",
            "hoe",
            FLINT_TIER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(FLINT_TIER, 1, -2)), 0,
            "item/tool/flint/hoe"
    );
}