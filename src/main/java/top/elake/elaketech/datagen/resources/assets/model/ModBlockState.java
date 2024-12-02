package top.elake.elaketech.datagen.resources.assets.model;

import net.minecraft.world.level.block.Block;
import top.elake.elaketech.registers.block.Ore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class ModBlockState {
    public static void registers() {
        // 石墨矿
        addBlockState("graphite_ore", Ore.GRAPHITE_ORE, "block/ore/graphite/ore");
        // 深层石墨矿
        addBlockState("deepslate_graphite_ore", Ore.DEEPSLATE_GRAPHITE_ORE, "block/ore/graphite/deepslate");
    }

    public static final List<BlockStateList> LIST = new ArrayList<>();

    public static void addBlockState(String file, Supplier<Block> block, String path) {
        LIST.add(new BlockStateList(file, block, path));
    }

    public record BlockStateList(String file, Supplier<Block> blockSupplier, String path) {
    }
}