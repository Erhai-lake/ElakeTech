package top.elake.elakechemical.registers.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.registers.block.custom.Test;
import top.elake.elakechemical.registers.item.Elements;

import java.util.function.Supplier;

/**
 * @author Qi-Month
 */
public class ModBlock {
    /**
     * Block
     */
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister
            .createBlocks(ElakeChemical.MODID);

    /**
     * 测试方块
     */
    public static final DeferredBlock<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Test(BlockBehaviour.Properties
                    // 复制方块属性
                    .ofFullCopy(Blocks.STONE)
                    // 设置声音类型
                    .sound(SoundType.WOOD)
                    // 设置硬度和爆炸抗性(分别为2和6)
                    .strength(2f, 6f)
                    // 这边是一个比较运算符, 当条件符合ON的时候返回15的亮度,否则为3
                    .lightLevel(state -> state.getValue(Test.ON) ? 15 : 3)
            )
    );

    /**
     * 测试方块(实体)
     */
    public static final DeferredBlock<Block> TEST_BLOCK_ENTITY = registerBlock("test_block_entity",
            () -> new Test(BlockBehaviour.Properties
                    // 复制方块属性
                    .ofFullCopy(Blocks.STONE)
                    // 设置声音类型
                    .sound(SoundType.WOOD)
                    // 设置硬度和爆炸抗性(分别为2和6)
                    .strength(2f, 6f)
            )
    );

    /**
     * 注册方块
     *
     * @param name  名称
     * @param block 方块
     */
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    /**
     * 注册方块物品
     *
     * @param name  名称
     * @param block 方块
     */
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        // 实在懒得注册一个新的Item类了(
        DeferredItem<BlockItem> item = Elements.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        ModCreativeModeTab.addAll(item);
    }

    /**
     * 注册
     *
     * @param event 事件总线
     */
    public static void register(IEventBus event) {
        BLOCKS.register(event);
    }
}