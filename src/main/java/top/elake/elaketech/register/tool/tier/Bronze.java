package top.elake.elaketech.register.tool.tier;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.tag.ModItemTags;
import top.elake.elaketech.util.Registers;

/**
 * @author Qi-Month
 */
public class Bronze {
    /**
     * 注册
     */
    public static void register() {
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
            () -> Ingredient.of(ModItemTags.Items.BRONZE_INGOT)
    );

    /**
     * 剑
     */
    public static final ItemEntry<? extends Item> BRONZE_SWORD = Registers.registerColorTool(
            "bronze_sword",
            "Bronze Sword",
            0xFFFF8C00,
            "sword",
            BRONZE_TIER,
            new Item.Properties()
                    .attributes(SwordItem.createAttributes(BRONZE_TIER, 3, -2.4f)), 0
    );
    /**
     * 镐
     */
    public static final ItemEntry<? extends Item> BRONZE_PICKAXE = Registers.registerColorTool(
            "bronze_pickaxe",
            "Bronze Pickaxe",
            0xFFFF8C00,
            "pickaxe",
            BRONZE_TIER,
            new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(BRONZE_TIER, 1, -2.8f)), 0
    );
    /**
     * 斧
     */
    public static final ItemEntry<? extends Item> BRONZE_AXE = Registers.registerColorTool(
            "bronze_axe",
            "Bronze Axe",
            0xFFFF8C00,
            "axe",
            BRONZE_TIER,
            new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(BRONZE_TIER, 1, -2)), 0
    );
    /**
     * 锹
     */
    public static final ItemEntry<? extends Item> BRONZE_SHOVEL = Registers.registerColorTool(
            "bronze_shovel",
            "Bronze Shovel",
            0xFFFF8C00,
            "shovel",
            BRONZE_TIER,
            new Item.Properties()
                    .attributes(HoeItem.createAttributes(BRONZE_TIER, 1, -2)), 0
    );
    /**
     * 锄
     */
    public static final ItemEntry<? extends Item> BRONZE_HOE = Registers.registerColorTool(
            "bronze_hoe",
            "Bronze Hoe",
            0xFFFF8C00,
            "hoe",
            BRONZE_TIER,
            new Item.Properties()
                    .attributes(HoeItem.createAttributes(BRONZE_TIER, 1, -2)), 0
    );
    /**
     * 锤
     */
    public static final ItemEntry<? extends Item> BRONZE_HAMMER = Registers.registerColorTool(
            "bronze_hammer",
            "Bronze Hammer",
            0xFFFF8C00,
            "pickaxe",
            BRONZE_TIER,
            new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(BRONZE_TIER, 1, -2)), 0
    );
}