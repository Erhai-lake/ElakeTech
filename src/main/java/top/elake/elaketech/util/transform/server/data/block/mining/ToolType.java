package top.elake.elaketech.util.transform.server.data.block.mining;

import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

public class ToolType {
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> pickaxeOnly() {
        return ((builder) -> {
            return builder.tag(BlockTags.MINEABLE_WITH_PICKAXE);
        });
    }

    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> axeOnly() {
        return ((builder) -> {
            return builder.tag(BlockTags.MINEABLE_WITH_AXE);
        });
    }

    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> shovelOnly() {
        return ((builder) -> {
            return builder.tag(BlockTags.MINEABLE_WITH_SHOVEL);
        });
    }

    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> hoeOnly() {
        return ((builder) -> {
            return builder.tag(BlockTags.MINEABLE_WITH_HOE);
        });
    }
}