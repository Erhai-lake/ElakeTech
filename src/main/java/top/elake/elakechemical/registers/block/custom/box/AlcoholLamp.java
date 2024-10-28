package top.elake.elakechemical.registers.block.custom.box;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AlcoholLamp extends Block {
    public AlcoholLamp(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = Block
            .box(5d, 0d, 5d, 11d, 5d, 11d);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}