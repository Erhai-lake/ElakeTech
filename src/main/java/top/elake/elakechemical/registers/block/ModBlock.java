package top.elake.elakechemical.registers.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.registers.block.custom.Test;
import top.elake.elakechemical.registers.block.custom.box.AlcoholLamp;
import top.elake.elakechemical.utils.Registers;

/**
 * @author Erhai-lake Qi-Month
 */
public class ModBlock {
    /**
     * 测试方块
     */
    public static final DeferredBlock<Block> TEST_BLOCK = Registers.registerBlock("test_block",
            () -> new Test(BlockBehaviour.Properties
                    // 复制方块属性
                    .ofFullCopy(Blocks.STONE)
                    // 设置声音类型
                    .sound(SoundType.STONE)
                    // 设置硬度和爆炸抗性(分别为2和6)
                    .strength(2f, 6f)
                    // 这边是一个比较运算符, 当条件符合ON的时候返回15的亮度,否则为3
                    .lightLevel(state -> state.getValue(Test.ON) ? 15 : 3)
            )
    );

    /**
     * 酒精灯
     */
    public static final DeferredBlock<Block> ALCOHOL_LAMP = Registers.registerBlock("alcohol_lamp",
            () -> new AlcoholLamp(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.GLASS)
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
            )
    );

    /**
     * 石墨矿石
     */
    public static final DeferredBlock<Block> GRAPHITE_ORE = Registers.registerBlock("graphite_ore",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.IRON_ORE)
                    .sound(SoundType.STONE)
            )
    );
    public static final DeferredBlock<Block> DEEPSLATE_GRAPHITE_ORE = Registers.registerBlock("deepslate_graphite_ore",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                    .sound(SoundType.DEEPSLATE)
            )
    );

    /**
     * 注册
     */
    public static void register() {
        // 物品
        ModCreativeModeTab.addAll(Registers.registerBlockItem("test_block", TEST_BLOCK, new Item.Properties()));
        ModCreativeModeTab.addAll(Registers.registerBlockItem("alcohol_lamp", ALCOHOL_LAMP, new Item.Properties()));
        // 矿石
        // 石墨
        ModCreativeModeTab.addAll(Registers.registerBlockItem("graphite_ore", GRAPHITE_ORE, new Item.Properties()));
        ModCreativeModeTab.addAll(Registers.registerBlockItem("deepslate_graphite_ore", DEEPSLATE_GRAPHITE_ORE, new Item.Properties()));
        // 测试方块(实体)
        ModCreativeModeTab.addAll(Registers.registerBlockItem("test_block_entity",
                Registers.registerBlock("test_block_entity",
                        () -> new Test(BlockBehaviour.Properties
                                // 复制方块属性
                                .ofFullCopy(Blocks.STONE)
                                // 设置声音类型
                                .sound(SoundType.STONE)
                                // 设置硬度和爆炸抗性(分别为2和6)
                                .strength(2f, 6f)
                        )
                ), new Item.Properties()
        ));
    }
}