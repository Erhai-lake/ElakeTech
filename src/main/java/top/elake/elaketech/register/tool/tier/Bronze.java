package top.elake.elaketech.register.tool.tier;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.*;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.register.tool.ModTiers;
import top.elake.elaketech.util.Registers;

/**
 * @author Qi-Month
 */
public class Bronze {
    static {
        ElakeTech.REGISTER.defaultCreativeTab(ModCreativeModeTab.TOOLS.getKey());
    }

    public static void register() {
    }

    /**
     * 剑
     */
    public static final ItemEntry<? extends Item> BRONZE_SWORD = Registers.registerColorTool(
            "bronze_sword",
            "Bronze Sword",
            0xFFFF8C00,
            "sword",
            ModTiers.BRONZE_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.BRONZE_TIER, 3, -2.4f)), 0
    );
    /**
     * 镐
     */
    public static final ItemEntry<? extends Item> BRONZE_PICKAXE = Registers.registerColorTool(
            "bronze_pickaxe",
            "Bronze Pickaxe",
            0xFFFF8C00,
            "pickaxe",
            ModTiers.BRONZE_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModTiers.BRONZE_TIER, 1, -2.8f)), 0
    );
    /**
     * 斧
     */
    public static final ItemEntry<? extends Item> BRONZE_AXE = Registers.registerColorTool(
            "bronze_axe",
            "Bronze Axe",
            0xFFFF8C00,
            "axe",
            ModTiers.BRONZE_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModTiers.BRONZE_TIER, 1, -2)), 0
    );
    /**
     * 锹
     */
    public static final ItemEntry<? extends Item> BRONZE_SHOVEL = Registers.registerColorTool(
            "bronze_shovel",
            "Bronze Shovel",
            0xFFFF8C00,
            "shovel",
            ModTiers.BRONZE_TIER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.BRONZE_TIER, 1, -2)), 0
    );
    /**
     * 锄
     */
    public static final ItemEntry<? extends Item> BRONZE_HOE = Registers.registerColorTool(
            "bronze_hoe",
            "Bronze Hoe",
            0xFFFF8C00,
            "hoe",
            ModTiers.BRONZE_TIER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.BRONZE_TIER, 1, -2)), 0
    );
    /**
     * 锤
     */
    public static final ItemEntry<? extends Item> BRONZE_HAMMER = Registers.registerColorTool(
            "bronze_hammer",
            "Bronze Hammer",
            0xFFFF8C00,
            "pickaxe",
            ModTiers.BRONZE_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModTiers.BRONZE_TIER, 1, -2)), 0
    );
}