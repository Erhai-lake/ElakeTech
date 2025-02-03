package top.elake.elaketech.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import top.elake.elaketech.register.item.Materials;
import top.elake.elaketech.tag.ModBlockTags;

import java.util.Random;

/**
 * @author Qi-Month
 */
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

        // 可以触发的方块
        boolean isCanGetGrassFiber = blockState.is(ModBlockTags.Blocks.GET_GRASS_FIBER);

        if (isCanGetGrassFiber) {
            // 右键动画(草方块没有)
            player.swing(event.getHand(), true);

            // 如果触发的对象不是草方块, 则替换为空气
            if (!blockState.is(Blocks.GRASS_BLOCK)) {
                level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
            }

            // 生成物品
            if (new Random().nextDouble() < 0.3) {
                BlockPos spawnPos = blockPos.above();
                ItemStack itemStack = new ItemStack(Materials.GRASS_FIBER.get());
                ItemEntity itemEntity = new ItemEntity(level, spawnPos.getX() + 0.5, spawnPos.getY() + 0.5, spawnPos.getZ() + 0.5, itemStack);

                // 防止物品乱飞
                itemEntity.setDeltaMovement(0, 0, 0);
                level.addFreshEntity(itemEntity);
            }
        }
    }
}