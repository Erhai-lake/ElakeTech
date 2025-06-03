package top.elake.elaketech.register.block.custom.function;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.elake.elaketech.register.block.entity.DryRackBlockEntity;

/**
 * @author Elake Studio
 */
public class DryRackBlock extends BaseEntityBlock {
    private static final Logger log = LoggerFactory.getLogger(DryRackBlock.class);

    public DryRackBlock(Properties properties) {
        super(properties);
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

    @Override
    public @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new DryRackBlockEntity(pos, state);
    }
}