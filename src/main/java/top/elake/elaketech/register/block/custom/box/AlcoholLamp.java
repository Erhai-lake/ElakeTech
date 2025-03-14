package top.elake.elaketech.register.block.custom.box;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/**
 * @author Qi- Month
 */
public class AlcoholLamp extends Block {
    public AlcoholLamp(Properties properties) {
        super(properties);
    }

    // 获取方块的碰撞箱需要重写VoxelShape#getShape方法
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Block.box(5d, 0d, 5d, 11d, 5d, 11d);
    }
}