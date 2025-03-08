package top.elake.elaketech.register.block.entity.registers;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.elake.elaketech.network.OpenGeneratorScreenPacket;
import top.elake.elaketech.register.block.ModBlockEntity;
import top.elake.elaketech.register.block.entity.ThermalBlockEntity;

import java.util.List;

/**
 * @author Qi-Month
 */
public class RegisterThermalBlockEntity extends BaseEntityBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public RegisterThermalBlockEntity(Properties properties) {
        super((properties)
                // 当燃烧时发出亮度13的光
                .lightLevel((state) -> state.getValue(LIT) ? 13 : 0)
                // 允许光照传播
                .hasPostProcess((state, level, pos) -> state.getValue(LIT))
                // 发光渲染
                .emissiveRendering((state, level, pos) -> state.getValue(LIT))
        );
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    public void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof ThermalBlockEntity thermalDevice) {
                ItemStackHandler itemHandler = thermalDevice.getItemHandler();
                for (int i = 0; i < itemHandler.getSlots(); i++) {
                    popResource(level, pos, itemHandler.getStackInSlot(i));
                }
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState state, LootParams.@NotNull Builder builder) {
        List<ItemStack> drops = super.getDrops(state, builder);
        BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof ThermalBlockEntity generatorDevice) {
            ItemStackHandler itemHandler = generatorDevice.getItemHandler();
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                drops.add(itemHandler.getStackInSlot(i));
            }
        }
        return drops;
    }

    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new ThermalBlockEntity(ModBlockEntity.THERMAL_POWER.get(), pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return type ==
                ModBlockEntity.THERMAL_POWER.get() ? (level1, pos, state1, blockEntity) -> ((ThermalBlockEntity) blockEntity)
                .tick(level1, pos, state1, (ThermalBlockEntity) blockEntity) : null;
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(RegisterThermalBlockEntity::new);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (level.isClientSide) {
            PacketDistributor.sendToServer(new OpenGeneratorScreenPacket(pos));
        }
        return InteractionResult.SUCCESS;
    }
}