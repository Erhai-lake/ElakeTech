package top.elake.elakechemical.client.color;

import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import top.elake.elakechemical.registers.item.Sundries;

public class ItemColor {
    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(Sundries.TEST_INGOT);
    }
}