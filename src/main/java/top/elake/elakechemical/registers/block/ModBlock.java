package top.elake.elakechemical.registers.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
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

    public static final DeferredBlock<Block> ALCOHOL_LAMP = Registers.registerBlock("alcohol_lamp",
            () -> new AlcoholLamp(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.GLASS)
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
            ));

    /**
     * 注册
     */
    public static void register() {
        // 测试方块
        ModCreativeModeTab.addAll(Registers.registerBlockItem("test_block", TEST_BLOCK, new Item.Properties()));
        ModCreativeModeTab.addAll(Registers.registerBlockItem("alcohol_lamp", ALCOHOL_LAMP, new Item.Properties()));
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