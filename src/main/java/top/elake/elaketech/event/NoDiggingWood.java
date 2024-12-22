package top.elake.elaketech.event;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import top.elake.elaketech.ElakeTech;

/**
 * @author Erhai-lake Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class NoDiggingWood {
    /**
     * 注册事件
     *
     * @param event 事件总线
     */
    public static void register(IEventBus event) {
        event.register(NoDiggingWood.class);
    }

    /**
     * 玩家挖掘事件
     *
     * @param event 事件
     */
    @SubscribeEvent
    public static void onHarvestCheck(PlayerEvent.HarvestCheck event) {
        BlockState blockState = event.getLevel().getBlockState(event.getPos());
        Player player = event.getEntity();
        ItemStack tool = player.getMainHandItem();

        // 判断是否为#木头或#木板
        boolean isWoodOrPlank = blockState.is(BlockTags.LOGS) || blockState.is(BlockTags.PLANKS) || blockState.is(Blocks.CRAFTING_TABLE);
        // 判断玩家是否处于创造模式
        boolean isCreativeMode = player.getAbilities().instabuild;

        // 如果方块是Tags, 并且玩家不是创造模式
        if (isWoodOrPlank && !isCreativeMode) {
            // 那就只能工具破坏, 否则不会掉落任何掉落物
            event.setCanHarvest(tool.isCorrectToolForDrops(event.getTargetBlock()));
        }
    }
}