package top.elake.elakechemical;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class Utils {
    /**
     * ITEMS
     */
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ElakeChemical.MODID);

    /**
     * Block
     */
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ElakeChemical.MODID);

    /**
     * 注册物品
     *
     * @param name           名称
     * @param itemProperties 物品属性
     * @return 物品句柄
     */
    public static DeferredItem<Item> registerItem(String name, Item.Properties itemProperties) {
        return ITEMS.register(name, () -> new Item(itemProperties));
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
     * @param name            名称
     * @param blockProperties 方块属性
     * @return 方块句柄
     */
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> blockProperties) {
        return BLOCKS.register(name, blockProperties);
    }

    /**
     * 注册方块物品
     *
     * @param name           名称
     * @param itemProperties 物品属性
     * @return 物品句柄
     */
    public static <T extends Block> DeferredItem<Item> registerBlockItem(String name, Supplier<T> block, Item.Properties itemProperties) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
    }

    /**
     * 注册方块
     *
     * @param event 事件总线
     */
    public static void registerBlocks(IEventBus event) {
        BLOCKS.register(event);
    }
}
