package top.elake.elakechemical.registers.tool.tier;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.registers.tag.ModItemTags;
import top.elake.elakechemical.utils.Registers;

/**
 * @author Qi-Month
 */
public class Flint {
    /**
     * 注册
     */
    public static void register() {
        // 剑
        ModCreativeModeTab.addTools(Registers.registerTool("flint_sword", "Sword", FLINT_TIER, new Item.Properties()
                .attributes(SwordItem.createAttributes(FLINT_TIER, 3, -2.4f))
        ));
        // 镐
        ModCreativeModeTab.addTools(Registers.registerTool("flint_pickaxe", "Pickaxe", FLINT_TIER, new Item.Properties()
                .attributes(PickaxeItem.createAttributes(FLINT_TIER, 1, -2.8f))
        ));
        // 斧
        ModCreativeModeTab.addTools(Registers.registerTool("flint_axe", "Axe", FLINT_TIER, new Item.Properties()
                .attributes(AxeItem.createAttributes(FLINT_TIER, 1, -2))
        ));
        // 手斧
        ModCreativeModeTab.addTools(Registers.registerTool("flint_handaxe", "Axe", FLINT_HANDAXE_TIER, new Item.Properties()
                .attributes(AxeItem.createAttributes(FLINT_HANDAXE_TIER, 1, -2))
        ));
        // 锹
        ModCreativeModeTab.addTools(Registers.registerTool("flint_shovel", "Shovel", FLINT_TIER, new Item.Properties()
                .attributes(ShovelItem.createAttributes(FLINT_TIER, 1.5f, -3))
        ));
        // 锄
        ModCreativeModeTab.addTools(Registers.registerTool("flint_hoe", "Hoe", FLINT_TIER, new Item.Properties()
                .attributes(HoeItem.createAttributes(FLINT_TIER, 1, -2))
        ));
    }

    /**
     * 燧石镐可以破坏的方块(继承原版木质工具Tag)
     */
    public static final TagKey<Block> INCORRECT_FOR_FLINT_TOOL = TagKey
            .create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath("minecraft", "incorrect_for_wooden_tool"));

    /**
     * 等级
     */
    public static final Tier FLINT_TIER = new SimpleTier(
            INCORRECT_FOR_FLINT_TOOL,
            10,
            0.5F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    /**
     * 手斧等级
     */
    public static final Tier FLINT_HANDAXE_TIER = new SimpleTier(
            INCORRECT_FOR_FLINT_TOOL,
            2,
            0.3F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );
}