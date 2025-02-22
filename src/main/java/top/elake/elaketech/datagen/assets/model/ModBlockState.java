package top.elake.elaketech.datagen.assets.model;

import net.minecraft.world.level.block.Block;
import top.elake.elaketech.register.block.CommonBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class ModBlockState {
    public static void registers() {
        // 白云岩
        addBlockState("dolostone", CommonBlock.DOLOSTONE, "block/dolostone");
        // 高岭土
        addBlockState("kaolin", CommonBlock.KAOLIN, "block/kaolin");
        // 耐火砖块
        addBlockState("refractory_bricks", CommonBlock.REFRACTORY_BRICKS, "block/refractory_bricks");
    }

    public static final List<BlockStateList> LIST = new ArrayList<>();

    public static void addBlockState(String output, Supplier<Block> block, String texture) {
        LIST.add(new BlockStateList(output, block, texture));
    }

    public record BlockStateList(String file, Supplier<Block> blockSupplier, String path) {
    }
}