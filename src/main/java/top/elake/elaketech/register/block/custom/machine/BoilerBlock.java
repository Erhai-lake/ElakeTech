package top.elake.elaketech.register.block.custom.machine;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.elake.elaketech.register.block.entity.machine.BoilerBlockEntity;

/**
 * @author Elake Studio
 */
public class BoilerBlock extends BaseEntityBlock {
    public static final BooleanProperty ON = BooleanProperty.create("on");

    public BoilerBlock(BlockBehaviour.Properties properties) {
        super(properties);
        // 让玩家放下后默认关闭
        this.registerDefaultState(this.stateDefinition.any().setValue(ON, false));
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return BlockBehaviour.simpleCodec(BoilerBlock::new);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new BoilerBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        if (level.isClientSide) {
            return null;
        }
        return (lvl, pos, st, be) -> {
            if (be instanceof BoilerBlockEntity boiler) {
                // 调用原来的 tick
                boiler.tick();

                // 根据工作状态同步 ON 属性
                boolean working = boiler.isWorking();

                BlockState currentState = lvl.getBlockState(pos);
                if (currentState.getValue(ON) != working) {
                    lvl.setBlock(pos, currentState.setValue(ON, working), 3);
                }
            }
        };
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ON);
    }
}