package top.elake.elaketech.event;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

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
    public void onPlayerDig(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        Block block = event.getLevel().getBlockState(event.getPos()).getBlock();
        ItemStack heldItem = player.getMainHandItem();

        // 判断方块是否为木头(Tag)如果玩家没有使用斧头，则取消破坏方块(并且有添加创造模式判断)
        if ((block.defaultBlockState().is(BlockTags.LOGS)) && (!player.getAbilities().instabuild) && !(heldItem.getItem() instanceof AxeItem)) {
            event.setCanceled(true);
        }
    }
}