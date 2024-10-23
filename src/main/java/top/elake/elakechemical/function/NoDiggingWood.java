package top.elake.elakechemical.function;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

/**
 * @author Erhai-lake
 */
public class NoDiggingWood {
    /**
     * 注册事件
     *
     * @param eventBus
     */
    public static void register(IEventBus eventBus) {
        eventBus.register(new NoDiggingWood());
    }

    /**
     * 玩家挖掘事件
     *
     * @param event
     */
    @SubscribeEvent
    public void onPlayerDig(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        Block block = event.getLevel().getBlockState(event.getPos()).getBlock();
        ItemStack heldItem = player.getMainHandItem();

        // 判断方块是否为木头(Tag)
        if ((block.defaultBlockState().is(BlockTags.LOGS))
                // 如果玩家没有使用斧头，则取消破坏方块(并且有添加创造模式判断)
                && (!player.getAbilities().instabuild) && !(heldItem.getItem() instanceof AxeItem)) {
            event.setCanceled(true);
        }
    }
}
