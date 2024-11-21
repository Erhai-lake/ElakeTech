package top.elake.elaketech.registers.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import top.elake.elaketech.registers.ModCreativeModeTab;
import top.elake.elaketech.utils.Registers;

public class Org {
    /**
     * 石墨矿石
     */
    public static final DeferredBlock<Block> GRAPHITE_ORE = Registers.registerBlock("graphite_ore",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.IRON_ORE)
            )
    );
    public static final DeferredBlock<Block> DEEPSLATE_GRAPHITE_ORE = Registers.registerBlock("deepslate_graphite_ore",
            () -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
            )
    );

    /**
     * 注册
     */
    public static void register() {
        // 石墨
        ModCreativeModeTab.addAll(Registers.registerBlockItem("graphite_ore", GRAPHITE_ORE, new Item.Properties()));
        ModCreativeModeTab.addAll(Registers.registerBlockItem("deepslate_graphite_ore", DEEPSLATE_GRAPHITE_ORE, new Item.Properties()));
    }
}
