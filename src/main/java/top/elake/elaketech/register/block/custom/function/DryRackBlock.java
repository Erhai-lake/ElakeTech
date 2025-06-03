package top.elake.elaketech.register.block.custom.function;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.elake.elaketech.register.block.entity.DryRackBlockEntity;

/**
 * @author Elake Studio
 */
public class DryRackBlock extends BaseEntityBlock {
    /**
     * 定义朝向
     */
    private static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public DryRackBlock(Properties properties) {
        super(properties);
        try {
            this.registerDefaultState(this.getStateDefinition().any()
                    .setValue(FACING, Direction.NORTH));
        } catch (Exception e) {
            System.err.println("Error initializing DryRackBlock:");
            e.printStackTrace();
            throw e;
        }
        // 默认朝向(北)
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return BaseEntityBlock.simpleCodec(DryRackBlock::new);
    }

    @Override
    public void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull BlockState mirror(BlockState state, @NotNull Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState rotate(BlockState state, @NotNull Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Block.box(0d, 0d, 0d, 16d, 10d, 16d);
    }

    // 设置渲染方式
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        // 获取BlockEntity的坐标(pos)
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (blockEntity instanceof DryRackBlockEntity dryRackBlockEntity) {
            // 如果不是在Client执行
            if (!level.isClientSide() && dryRackBlockEntity.addItem(player.getMainHandItem())) {
                return ItemInteractionResult.SUCCESS;
            }
        }
        // 阻止动画
        return ItemInteractionResult.CONSUME;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new DryRackBlockEntity(pos, state);
    }
}