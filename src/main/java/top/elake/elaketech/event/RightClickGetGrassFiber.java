package top.elake.elaketech.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.Materials;
import top.elake.elaketech.tag.ModBlockTags;

import java.util.Random;

/**
 * @author Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class RightClickGetGrassFiber {
    /**
     * 注册事件
     *
     * @param event 事件总线
     */
    public static void register(IEventBus event) {
        event.register(RightClickGetGrassFiber.class);
    }

    /**
     * 玩家右键事件
     *
     * @param event 事件
     */
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos blockPos = event.getPos();
        BlockState blockState = level.getBlockState(blockPos);

        // 确保事件只在服务器端执行
        if (level.isClientSide()) {
            return;
        }

        // 只能空手
        if (!player.getMainHandItem().isEmpty()) {
            return;
        }

        // 可以触发的方块
        boolean isCanGetGrassFiber = blockState.is(ModBlockTags.Blocks.GET_GRASS_FIBER);

        if (isCanGetGrassFiber) {
            // 生成破坏粒子效果
            if (level instanceof ServerLevel serverLevel) {
                serverLevel.levelEvent(2001, blockPos, Block.getId(blockState));
            }

            // 替换成空气
            level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
            // 右键动画
            player.swing(event.getHand(), true);

            // 生成物品
            double randomValue = new Random().nextDouble();
            // 概率35%
            if (randomValue < 0.35) {
                BlockPos spawnPos = blockPos.above();
                ItemStack itemStack = new ItemStack(Materials.GRASS_FIBER.get());
                ItemEntity itemEntity = new ItemEntity(level, spawnPos.getX() + 0.5, spawnPos.getY() - 0.5, spawnPos.getZ() + 0.5, itemStack);

                // 添加物品在世界内
                level.addFreshEntity(itemEntity);
                // 防止物品乱飞
                // itemEntity.setDeltaMovement(0, 0, 0);
            }
        }
    }
}