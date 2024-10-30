package top.elake.elakechemical.registers.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/**
 * @author Qi-Month
 */
public class Test extends Block {
    /**
     * 创建一个方块状态"on", 类型是boolean
     */
    public static final BooleanProperty ON = BooleanProperty
            .create("on");

    public Test(Properties properties) {
        super(properties);
        // 设置默认方块状态(放下来默认关闭)
        this.registerDefaultState(this.defaultBlockState().setValue(ON, false));
    }

    /**
     * 意义不明的碰撞箱
     */
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(0d, 0d, 0d, 16d, 16d, 16d);
    }

    /**
     * 玩家右键(use)让其更换状态on or off(只能空手)
     *
     * @param stack  玩家手
     * @param state  当前方块状态
     * @param level  世界
     * @param pos    坐标
     * @param player 玩家
     * @param hand   手
     * @param result 点击结果
     */
    @Override
    public @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND && player.getItemInHand(hand).isEmpty()) {
            level.setBlock(pos, state.cycle(ON), 3);
            return super.useItemOn(stack, state, level, pos, player, hand, result);
        }
        // 调用右键动画
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ON);
    }
}