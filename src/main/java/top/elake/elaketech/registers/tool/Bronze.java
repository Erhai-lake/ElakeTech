package top.elake.elaketech.registers.tool;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.registers.ModCreativeModeTab;
import top.elake.elaketech.registers.tag.ModItemTags;
import top.elake.elaketech.utils.Registers;

/**
 * @author Qi-Month
 */
public class Bronze {
    /**
     * 注册
     */
    public static void register() {
        // 剑
        ModCreativeModeTab.addTools(BRONZE_SWORD);
        // 镐
        ModCreativeModeTab.addTools(BRONZE_PICKAXE);
        // 斧
        ModCreativeModeTab.addTools(BRONZE_AXE);
        // 锹
        ModCreativeModeTab.addTools(BRONZE_SHOVEL);
        // 锄
        ModCreativeModeTab.addTools(BRONZE_HOE);
    }

    /**
     * 青铜工具等级
     */
    public static final Tier BRONZE_TIER = new SimpleTier(
            Tiers.IRON.getIncorrectBlocksForDrops(),
            120,
            6F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.BRONZE)
    );

    /**
     * 剑
     */
    public static final DeferredItem<Item> BRONZE_SWORD = Registers.registerTool("bronze_sword", "Sword", BRONZE_TIER, new Item.Properties()
            .attributes(SwordItem.createAttributes(BRONZE_TIER, 3, -2.4f)), 0);

    /**
     * 镐
     */
    public static final DeferredItem<Item> BRONZE_PICKAXE = Registers.registerTool("bronze_pickaxe", "Pickaxe", BRONZE_TIER, new Item.Properties()
            .attributes(PickaxeItem.createAttributes(BRONZE_TIER, 1, -2.8f)), 0);

    /**
     * 斧
     */
    public static final DeferredItem<Item> BRONZE_AXE = Registers.registerTool("bronze_axe", "Axe", BRONZE_TIER, new Item.Properties()
            .attributes(AxeItem.createAttributes(BRONZE_TIER, 1, -2)), 0);

    /**
     * 锹
     */
    public static final DeferredItem<Item> BRONZE_SHOVEL = Registers.registerTool("bronze_shovel", "Shovel", BRONZE_TIER, new Item.Properties()
            .attributes(HoeItem.createAttributes(BRONZE_TIER, 1, -2)), 0);

    /**
     * 锄
     */
    public static final DeferredItem<Item> BRONZE_HOE = Registers.registerTool("bronze_hoe", "Hoe", BRONZE_TIER, new Item.Properties()
            .attributes(HoeItem.createAttributes(BRONZE_TIER, 1, -2)), 0);
}