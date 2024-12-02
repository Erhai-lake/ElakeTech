package top.elake.elaketech.registers.tool;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.registers.ModCreativeModeTab;
import top.elake.elaketech.registers.tag.ModItemTags;
import top.elake.elaketech.utils.Registers;

/**
 * @author Erhai-lake
 */
public class Flint {
    /**
     * 注册
     */
    public static void register() {
        // 小刀
        ModCreativeModeTab.addTools(FLINT_KNIFE);
        // 剑
        ModCreativeModeTab.addTools(FLINT_SWORD);
        // 镐
        ModCreativeModeTab.addTools(FLINT_PICKAXE);
        // 斧
        ModCreativeModeTab.addTools(FLINT_AXE);
        // 手斧
        ModCreativeModeTab.addTools(FLINT_HATCHET);
        // 锹
        ModCreativeModeTab.addTools(FLINT_SHOVEL);
        // 锄
        ModCreativeModeTab.addTools(FLINT_HOE);
    }

    /**
     * 燧石工具等级
     */
    public static final Tier FLINT_TIER = new SimpleTier(
            Tiers.WOOD.getIncorrectBlocksForDrops(),
            10,
            3F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    /**
     * 燧石小刀等级
     */
    public static final Tier FLINT_KNIFE_TIER = new SimpleTier(
            Tiers.WOOD.getIncorrectBlocksForDrops(),
            7,
            1.5F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    /**
     * 燧石手斧等级
     */
    public static final Tier FLINT_HATCHET_TIER = new SimpleTier(
            Tiers.WOOD.getIncorrectBlocksForDrops(),
            2,
            1.5F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    /**
     * 小刀
     */
    public static final DeferredItem<Item> FLINT_KNIFE = Registers.registerTool("flint_knife", "Sword", FLINT_KNIFE_TIER, new Item.Properties()
            .attributes(SwordItem.createAttributes(FLINT_KNIFE_TIER, 2, -2)), 0
    );

    /**
     * 剑
     */
    public static final DeferredItem<Item> FLINT_SWORD = Registers.registerTool("flint_sword", "Sword", FLINT_TIER, new Item.Properties()
            .attributes(SwordItem.createAttributes(FLINT_TIER, 3, -2.4f)), 0
    );

    /**
     * 镐
     */
    public static final DeferredItem<Item> FLINT_PICKAXE = Registers.registerTool("flint_pickaxe", "Pickaxe", FLINT_TIER, new Item.Properties()
            .attributes(PickaxeItem.createAttributes(FLINT_TIER, 1, -2.8f)), 0
    );

    /**
     * 斧
     */
    public static final DeferredItem<Item> FLINT_AXE = Registers.registerTool("flint_axe", "Axe", FLINT_TIER, new Item.Properties()
            .attributes(AxeItem.createAttributes(FLINT_TIER, 1, -2)), 0
    );

    /**
     * 手斧
     */
    public static final DeferredItem<Item> FLINT_HATCHET = Registers.registerTool("flint_hatchet", "Axe", FLINT_HATCHET_TIER, new Item.Properties()
            .attributes(AxeItem.createAttributes(FLINT_HATCHET_TIER, 1, -2)), 0
    );

    /**
     * 锹
     */
    public static final DeferredItem<Item> FLINT_SHOVEL = Registers.registerTool("flint_shovel", "Hoe", FLINT_TIER, new Item.Properties()
            .attributes(HoeItem.createAttributes(FLINT_TIER, 1, -2)), 0
    );

    /**
     * 锄
     */
    public static final DeferredItem<Item> FLINT_HOE = Registers.registerTool("flint_hoe", "Hoe", FLINT_TIER, new Item.Properties()
            .attributes(HoeItem.createAttributes(FLINT_TIER, 1, -2)), 0
    );
}