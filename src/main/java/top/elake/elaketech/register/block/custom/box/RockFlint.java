package top.elake.elaketech.register.block.custom.box;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
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
        return Block.box(5.5f, 0f, 5.5f, 10.5f, 2f, 10.5f);
    }
}