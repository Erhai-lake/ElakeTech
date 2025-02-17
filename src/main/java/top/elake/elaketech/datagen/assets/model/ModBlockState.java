package top.elake.elaketech.datagen.assets.model;

import net.minecraft.world.level.block.Block;
import top.elake.elaketech.register.block.CommonBlock;
import top.elake.elaketech.register.block.OreRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class ModBlockState {
    public static void registers() {
        // 石墨矿
        addBlockState("graphite_ore", OreRegistry.GRAPHITE_ORE, "block/ore/graphite/ore");
        // 深层石墨矿
        addBlockState("deepslate_graphite_ore", OreRegistry.DEEPSLATE_GRAPHITE_ORE, "block/ore/graphite/deepslate");
        // 石英矿
        addBlockState("quartz_ore", OreRegistry.QUARTZ_ORE, "block/ore/quartz/ore");
        // 深层石英矿
        addBlockState("deepslate_quartz_ore", OreRegistry.DEEPSLATE_QUARTZ_ORE, "block/ore/quartz/deepslate");
        // 白云岩
        addBlockState("dolostone", CommonBlock.DOLOSTONE, "block/dolostone");
        // 高岭土
        addBlockState("kaolin", CommonBlock.KAOLIN, "block/kaolin");
        // 耐火砖块
        addBlockState("refractory_bricks", CommonBlock.REFRACTORY_BRICKS, "block/refractory_bricks");

//        addBlockState("test_block", TestBlock.TEST_BLOCK, "block/metal/block");
    }

    public static final List<BlockStateList> LIST = new ArrayList<>();

    public static void addBlockState(String file, Supplier<Block> block, String texture) {
        LIST.add(new BlockStateList(file, block, texture));
    }

    public record BlockStateList(String file, Supplier<Block> blockSupplier, String path) {
    }
}