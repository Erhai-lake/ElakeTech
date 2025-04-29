package top.elake.elaketech.register.block.custom.box;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/**
 * @author Qi-Month
 */
public class RockFlint extends Block {
    public RockFlint(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Block.box(5.5d, 0d, 5.5d, 10.5d, 2d, 10.5d);
    }

    /**
     * 检查方块是否可以存在于当前位置
     *
     * @param state
     * @param level
     * @param pos
     * @return
     */
    @Override
    public boolean canSurvive(@NotNull BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        return belowState.isFaceSturdy(level, belowPos, Direction.UP);
    }

    /**
     * 当邻居方块变化时触发检测
     *
     * @param state
     * @param level
     * @param pos
     * @param neighborBlock
     * @param neighborPos
     * @param movedByPiston
     */
    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos neighborPos, boolean movedByPiston) {
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
        checkAndDestroyIfInvalid(state, level, pos);
    }

    /**
     * 方块被放置时立即检测
     *
     * @param state
     * @param level
     * @param pos
     * @param oldState
     * @param isMoving
     */
    @Override
    public void onPlace(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        checkAndDestroyIfInvalid(state, level, pos);
    }

    /**
     * 统一检测并销毁逻辑
     *
     * @param state
     * @param level
     * @param pos
     */
    private void checkAndDestroyIfInvalid(BlockState state, Level level, BlockPos pos) {
        if (!state.canSurvive(level, pos)) {
            // 第二个参数表示是否掉落物品
            level.destroyBlock(pos, true);
        }
    }
}