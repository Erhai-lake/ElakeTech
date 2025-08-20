package top.elake.elaketech.util;

import vazkii.patchouli.api.IMultiblock;
import vazkii.patchouli.api.PatchouliAPI;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import vazkii.patchouli.api.IStateMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Elake Studio
 */
public class MultiblockStructureBuilder {
    private final String[][] structure;
    private final List<Object> matchers = new ArrayList<>();

    public MultiblockStructureBuilder(String[][] structure) {
        this.structure = structure;
    }

    /**
     * 添加方块匹配规则
     *
     * @param pos   结构中的字符标识
     * @param block 支持的匹配类型:
     *              - Block: 具体方块
     *              - BlockState: 具体方块状态
     *              - TagKey<Block>: 方块标签
     *              - IStateMatcher: 状态匹配器
     *              - Supplier<?>: 延迟加载的匹配器
     * @return 构建器自身
     */
    public MultiblockStructureBuilder where(char pos, Object block) {
        validateBlockType(block);
        matchers.add(pos);
        matchers.add(block);
        return this;
    }

    private void validateBlockType(Object block) {
        boolean isValid = block instanceof Block
                || block instanceof BlockState
                || block instanceof TagKey
                || block instanceof IStateMatcher
                || block instanceof Supplier;

        if (!isValid) {
            String errorMessage = "Invalid block matcher type. Supported types: Block, BlockState, TagKey<Block>, IStateMatcher, Supplier";
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public IMultiblock build() {
        return PatchouliAPI.get().makeMultiblock(structure, matchers.toArray());
    }
}