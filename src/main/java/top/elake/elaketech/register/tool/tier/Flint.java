package top.elake.elaketech.register.tool.tier;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.*;
import top.elake.elaketech.register.tool.ModTiers;
import top.elake.elaketech.util.Registers;

/**
 * @author Erhai-lake
 */
public class Flint {

    public static void register() {
    }

    /**
     * 剑
     */
    public static final ItemEntry<? extends Item> FLINT_SWORD = Registers.addAloneTool(
            "flint_sword",
            "Flint Sword",
            "sword",
            ModTiers.FLINT_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.FLINT_TIER, 3, -2.4f)), 0,
            "item/tool/flint/sword"
    );
    /**
     * 镐
     */
    public static final ItemEntry<? extends Item> FLINT_PICKAXE = Registers.addAloneTool(
            "flint_pickaxe",
            "Flint Pickaxe",
            "pickaxe",
            ModTiers.FLINT_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.FLINT_TIER, 1, -2.8f)), 0,
            "item/tool/flint/pickaxe"
    );
    /**
     * 斧
     */
    public static final ItemEntry<? extends Item> FLINT_AXE = Registers.addAloneTool(
            "flint_axe",
            "Flint Axe",
            "axe",
            ModTiers.FLINT_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.FLINT_TIER, 1, -2)), 0,
            "item/tool/flint/axe"
    );
    /**
     * 手斧
     */
    public static final ItemEntry<? extends Item> FLINT_HATCHET = Registers.addAloneTool(
            "flint_hatchet",
            "Flint Hatchet",
            "axe",
            ModTiers.FLINT_TIER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModTiers.FLINT_HATCHET_TIER, 1, -2)), 0,
            "item/tool/flint/hatchet"
    );
    /**
     * 锹
     */
    public static final ItemEntry<? extends Item> FLINT_SHOVEL = Registers.addAloneTool(
            "flint_shovel",
            "Flint Shovel",
            "shovel",
            ModTiers.FLINT_TIER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.FLINT_TIER, 1, -2)), 0,
            "item/tool/flint/shovel"
    );
    /**
     * 锄
     */
    public static final ItemEntry<? extends Item> FLINT_HOE = Registers.addAloneTool(
            "flint_hoe",
            "Flint Hoe",
            "hoe",
            ModTiers.FLINT_TIER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.FLINT_TIER, 1, -2)), 0,
            "item/tool/flint/hoe"
    );
}