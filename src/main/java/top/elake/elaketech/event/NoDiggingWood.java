package top.elake.elaketech.event;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * @author Erhai-lake Qi-Month
 */
public class NoDiggingWood {
    /**
     * 注册事件
     *
     * @param event 事件总线
     */
    public static void register(IEventBus event) {
        event.register(new NoDiggingWood());
    }

    /**
     * 玩家挖掘事件
     *
     * @param event 事件
     */
    @SubscribeEvent
    public void onHarvestCheck(PlayerEvent.HarvestCheck event) {
        BlockState blockState = event.getLevel().getBlockState(event.getPos());
        Player player = event.getEntity();
        ItemStack tool = player.getMainHandItem();

        // 判断是否是木头或木板
        boolean isWoodOrPlank = blockState.is(BlockTags.LOGS) || blockState.is(BlockTags.PLANKS);
        // 判断玩家是否处于创造模式
        boolean isCreativeMode = player.getAbilities().instabuild;

        // 如果方块是Tags, 并且玩家不是创造模式
        if (isWoodOrPlank && !isCreativeMode) {
            // 那就只能工具破坏, 否则不会掉落任何掉落物
            event.setCanHarvest(tool.isCorrectToolForDrops(event.getTargetBlock()));
        }
    }
}