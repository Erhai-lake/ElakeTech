package top.elake.elaketech.register.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import top.elake.elaketech.register.ETCreativeModeTab;
import top.elake.elaketech.util.Registers;

/**
 * @author Qi-Month
 */
public class CommonBlock {
    /**
     * 白云岩
     */
    public static final DeferredBlock<Block> DOLOSTONE = Registers.registerBlock("dolostone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    /**
     * 高岭土
     */
    public static final DeferredBlock<Block> KAOLIN = Registers.registerBlock("kaolin",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY)));
    /**
     * 耐火砖块
     */
    public static final DeferredBlock<Block> REFRACTORY_BRICKS = Registers.registerBlock("refractory_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));

    /**
     * 注册
     */
    public static void registers() {
        ETCreativeModeTab.addAll(Registers.registerBlockItem("dolostone", DOLOSTONE, new Item.Properties()));
        ETCreativeModeTab.addAll(Registers.registerBlockItem("kaolin", KAOLIN, new Item.Properties()));
        ETCreativeModeTab.addAll(Registers.registerBlockItem("refractory_bricks", REFRACTORY_BRICKS, new Item.Properties()));
    }
}