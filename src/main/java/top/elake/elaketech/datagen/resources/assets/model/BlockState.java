package top.elake.elaketech.datagen.resources.assets.model;

import net.minecraft.world.level.block.Block;
import top.elake.elaketech.registers.block.Org;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class BlockState {
    public static void registers() {
        // 石墨矿
        addBlockState(Org.GRAPHITE_ORE);
        // 深层石墨矿
        addBlockState(Org.DEEPSLATE_GRAPHITE_ORE);
    }

    public static final List<Supplier<Block>> LIST = new ArrayList<>();

    public static void addBlockState(Supplier<Block> block) {
        LIST.add(block);
    }
}
