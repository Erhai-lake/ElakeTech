package top.elake.elaketech.event;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import top.elake.elaketech.register.block.CommonBlock;

import static top.elake.elaketech.ElakeTech.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME, value = {Dist.CLIENT, Dist.DEDICATED_SERVER})
public class PlaceRockFlintEvent {

    public static void register(IEventBus event) {
        event.register(PlaceRockFlintEvent.class);
    }

    @SubscribeEvent
    public static void onRightClickBlockWithFlint(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos clickedPos = event.getPos();
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (level.isClientSide()) {
            return;
        }
        if (!heldItem.is(Items.FLINT)) {
            return;
        }
        BlockState clickedBlockState = level.getBlockState(clickedPos);
        if (!clickedBlockState.isSolidRender(level, clickedPos)) {
            return;
        }
        BlockPos placePos = clickedPos.above();
        if (!level.getBlockState(placePos).isAir()) {
            return;
        }
        BlockState rockFlintState = CommonBlock.ROCK_FLINT.get().defaultBlockState();
        if (!rockFlintState.canSurvive(level, placePos)) {
            return;
        }
        level.setBlock(placePos, rockFlintState, 3);
        level.playSound(null, placePos, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
        if (!player.getAbilities().instabuild) {
            heldItem.shrink(1);
        }
        player.swing(event.getHand(), true);
    }
} 