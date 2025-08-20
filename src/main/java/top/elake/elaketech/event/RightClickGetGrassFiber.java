package top.elake.elaketech.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import top.elake.elaketech.register.item.materials.Materials;
import top.elake.elaketech.tag.ModBlockTags;

import java.util.Random;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author Elake Studio
 */
@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class RightClickGetGrassFiber {
    public static void register(IEventBus event) {
        event.register(RightClickGetGrassFiber.class);
    }

    @SubscribeEvent
    public static void rightClickBlockGetGrassFiber(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos blockPos = event.getPos();
        BlockState blockState = level.getBlockState(blockPos);

        if (level.isClientSide() || !player.getMainHandItem().isEmpty()) {
            return;
        }

        double probability = 0.0;

        if (blockState.is(Blocks.VINE)) {
            probability = 1.0;
        } else if (blockState.is(ModBlockTags.GET_GRASS_FIBER)) {
            probability = 0.35;
        }

        if (probability <= 0) {
            return;
        }

        // 通用处理逻辑
        level.destroyBlock(blockPos, true, player, 1);
        player.swing(event.getHand(), true);

        if (new Random().nextDouble() < probability) {
            int x = blockPos.above().getX();
            int y = blockPos.above().getY();
            int z = blockPos.above().getZ();
            ItemStack stack = new ItemStack(Materials.GRASS_FIBER.get());
            ItemEntity item = new ItemEntity(level, x + 0.5, y - 0.5, z + 0.5, stack);
            level.addFreshEntity(item);
            // 防止物品乱飞
            // itemEntity.setDeltaMovement(0, 0, 0);
        }
    }
}