package top.elake.elaketech.client;

import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import top.elake.elaketech.util.ItemTooltipExtensions;

/**
 * @author Elake Studio
 */
@EventBusSubscriber(Dist.CLIENT)
public class ClientTooltipHandler {
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        Item item = event.getItemStack().getItem();
        event.getToolTip().addAll(ItemTooltipExtensions.getTooltips(item));
    }
}