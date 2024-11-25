package top.elake.elaketech.datagen.resources.assets.model;

import net.minecraft.world.level.block.Block;
import top.elake.elaketech.registers.block.Org;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class ModBlockState {
    public static void registers() {
        // 石墨矿
        addBlockState("graphite_ore", Org.GRAPHITE_ORE, "block/metal/ore/graphite/ore");
        // 深层石墨矿
        addBlockState("deepslate_graphite_ore", Org.DEEPSLATE_GRAPHITE_ORE, "block/metal/ore/graphite/deepslate");
    }

    public static final List<BlockStateList> LIST = new ArrayList<>();

    public static void addBlockState(String namespace, Supplier<Block> block, String path) {
        LIST.add(new BlockStateList(namespace, block, path));
    }

    public record BlockStateList(String namespace, Supplier<Block> blockSupplier, String path) {
    }
}