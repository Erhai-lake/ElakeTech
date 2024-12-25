package top.elake.elaketech.register.tool;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.register.ETCreativeModeTab;
import top.elake.elaketech.tag.ETItemTags;
import top.elake.elaketech.util.Registers;

/**
 * @author Erhai-lake
 */
public class Flint {
    /**
     * 注册
     */
    public static void register() {
        // 剑
        ETCreativeModeTab.addTools(FLINT_SWORD);
        // 镐
        ETCreativeModeTab.addTools(FLINT_PICKAXE);
        // 斧
        ETCreativeModeTab.addTools(FLINT_AXE);
        // 手斧
        ETCreativeModeTab.addTools(FLINT_HATCHET);
        // 锹
        ETCreativeModeTab.addTools(FLINT_SHOVEL);
        // 锄
        ETCreativeModeTab.addTools(FLINT_HOE);
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
            () -> Ingredient.of(ETItemTags.Items.FLINT)
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
            () -> Ingredient.of(ETItemTags.Items.FLINT)
    );

    /**
     * 剑
     */
    public static final DeferredItem<Item> FLINT_SWORD = Registers.registerTool("flint_sword", "Sword", FLINT_TIER, new Item.Properties()
            .attributes(SwordItem.createAttributes(FLINT_TIER, 3, -2.4f)), 0);

    /**
     * 镐
     */
    public static final DeferredItem<Item> FLINT_PICKAXE = Registers.registerTool("flint_pickaxe", "Pickaxe", FLINT_TIER, new Item.Properties()
            .attributes(PickaxeItem.createAttributes(FLINT_TIER, 1, -2.8f)), 0);

    /**
     * 斧
     */
    public static final DeferredItem<Item> FLINT_AXE = Registers.registerTool("flint_axe", "Axe", FLINT_TIER, new Item.Properties()
            .attributes(AxeItem.createAttributes(FLINT_TIER, 1, -2)), 0);

    /**
     * 手斧
     */
    public static final DeferredItem<Item> FLINT_HATCHET = Registers.registerTool("flint_hatchet", "Axe", FLINT_HATCHET_TIER, new Item.Properties()
            .attributes(AxeItem.createAttributes(FLINT_HATCHET_TIER, 1, -2)), 0);

    /**
     * 锹
     */
    public static final DeferredItem<Item> FLINT_SHOVEL = Registers.registerTool("flint_shovel", "Shovel", FLINT_TIER, new Item.Properties()
            .attributes(HoeItem.createAttributes(FLINT_TIER, 1, -2)), 0);

    /**
     * 锄
     */
    public static final DeferredItem<Item> FLINT_HOE = Registers.registerTool("flint_hoe", "Hoe", FLINT_TIER, new Item.Properties()
            .attributes(HoeItem.createAttributes(FLINT_TIER, 1, -2)), 0);
}