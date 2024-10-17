package top.elake.elakechemical.registers.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.block.custom.Test;
import top.elake.elakechemical.registers.item.Elements;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister
            .createBlocks(ElakeChemical.MODID);

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

    // BlockItem
    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        // 实在懒得注册一个新的Item类了(
        Elements.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus event) {
        BLOCKS.register(event);
    }
}