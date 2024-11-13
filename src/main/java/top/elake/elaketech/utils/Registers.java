package top.elake.elaketech.utils;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.utils.tooldamege.*;

import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class Registers {
    /**
     * Item
     */
    private static final DeferredRegister.Items ITEMS = DeferredRegister
            .createItems(ElakeTech.MODID);

    /**
     * Block
     */
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister
            .createBlocks(ElakeTech.MODID);

    /**
     * 注册物品
     *
     * @param name       名称
     * @param properties 物品属性
     * @return 物品句柄
     */
    public static DeferredItem<Item> registerItem(String name, Item.Properties properties) {
        return ITEMS.register(name, () -> new Item(properties));
    }

    /**
     * 注册物品
     *
     * @param event 事件总线
     */
    public static void registerItems(IEventBus event) {
        ITEMS.register(event);
    }

    /**
     * 注册方块
     *
     * @param name       名称
     * @param properties 方块属性
     * @return 方块句柄
     */
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> properties) {
        return BLOCKS.register(name, properties);
    }

    /**
     * 注册方块物品
     *
     * @param name       名称
     * @param properties 物品属性
     * @return 物品句柄
     */
    public static <T extends Block> DeferredItem<Item> registerBlockItem(String name, Supplier<T> block, Item.Properties properties) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }

    /**
     * 注册方块
     *
     * @param event 事件总线
     */
    public static void registerBlocks(IEventBus event) {
        BLOCKS.register(event);
    }

    /**
     * 注册工具
     *
     * @param name       名称
     * @param type       类型: Sword/Pickaxe/Axe/Shovel/Hoe
     * @param tier       等级
     * @param properties 工具属性
     * @return 工具句柄
     */
    public static DeferredItem<Item> registerTool(String name, String type, Tier tier, Item.Properties properties, int subtractingDamage) {
        return switch (type) {
            case "Sword" -> ITEMS.register(name, () -> new SwordDamageToolCrafting(tier, properties, subtractingDamage));
            case "Pickaxe" -> ITEMS.register(name, () -> new PickaxeDamageToolCrafting(tier, properties, subtractingDamage));
            case "Axe" -> ITEMS.register(name, () -> new AxeDamageToolCrafting(tier, properties, subtractingDamage));
            case "Shovel" -> ITEMS.register(name, () -> new ShovelDamageToolCrafting(tier, properties, subtractingDamage));
            case "Hoe" -> ITEMS.register(name, () -> new HoeDamageToolCrafting(tier, properties, subtractingDamage));
            default -> throw new IllegalArgumentException("Error Type");
        };
    }
}