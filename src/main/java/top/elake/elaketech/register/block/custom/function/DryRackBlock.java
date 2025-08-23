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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.elake.elaketech.register.block.entity.function.DryRackBlockEntity;

/**
 * @author Elake Studio
 */
public class DryRackBlock extends BaseEntityBlock {
    /**
     * 定义朝向
     */
    private static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    public DryRackBlock(BlockBehaviour.Properties properties) {
        super(Properties.ofFullCopy(Blocks.OAK_LOG).noOcclusion());

        // 默认朝向(北)
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(AXIS, Direction.Axis.Y)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    public @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return BaseEntityBlock.simpleCodec(DryRackBlock::new);
    }

    @Override
    public void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, AXIS);
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(AXIS, Direction.Axis.Y);
    }

    @Override
    public @NotNull BlockState mirror(BlockState state, @NotNull Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState rotate(BlockState state, @NotNull Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

//    @Override
//    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
//        return Block.box(0d, 0d, 0d, 16d, 10d, 16d);
//    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        // 脚
        VoxelShape leg1 = Block.box(0, 0, 0, 2, 8, 2);
        VoxelShape leg2 = Block.box(0, 0, 14, 2, 8, 16);
        VoxelShape leg3 = Block.box(14, 0, 0, 16, 8, 2);
        VoxelShape leg4 = Block.box(14, 0, 14, 16, 8, 16);

        // 晒板
        VoxelShape topPlate = Block.box(0, 8, 0, 16, 9, 16);

        // 顶部围栏
        VoxelShape southRail = Block.box(1, 9, 0, 15, 10, 1);
        VoxelShape northRail = Block.box(1, 9, 15, 15, 10, 16);
        VoxelShape westRail = Block.box(0, 9, 0, 1, 10, 16);
        VoxelShape eastRail = Block.box(15, 9, 0, 16, 10, 16);

        // 合并所有碰撞箱
        return Shapes.or(
                leg1, leg2, leg3, leg4,
                topPlate,
                southRail, northRail, westRail, eastRail
        );
    }

    // 设置渲染方式
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (blockEntity instanceof DryRackBlockEntity dryRackBlockEntity) {
            if (!level.isClientSide()) {
                if (player.isShiftKeyDown()) {
                    if (dryRackBlockEntity.hasItems()) {
                        ItemStack removedItem = dryRackBlockEntity.removeItem();
                        if (!removedItem.isEmpty()) {
                            if (!player.getInventory().add(removedItem)) {
                                player.drop(removedItem, false);
                            }
                            return ItemInteractionResult.SUCCESS;
                        }
                    }
                } else {
                    if (!player.getMainHandItem().isEmpty() && dryRackBlockEntity.addItem(player.getMainHandItem())) {
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }
        }
        return ItemInteractionResult.CONSUME;
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean movedByPiston) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof DryRackBlockEntity dryRackBlockEntity) {
                ItemStackHandler inventory = dryRackBlockEntity.getInventory();
                for (int i = 0; i < inventory.getSlots(); i++) {
                    ItemStack stack = inventory.getStackInSlot(i);
                    if (!stack.isEmpty()) {
                        popResource(level, pos, stack);
                    }
                }
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new DryRackBlockEntity(pos, state);
    }
}