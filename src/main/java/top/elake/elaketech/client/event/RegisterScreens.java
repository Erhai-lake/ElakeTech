package top.elake.elaketech.client.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.client.screen.ThermalScreen;
import top.elake.elaketech.register.ModMenuType;

/**
 * @author Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterScreens {
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuType.THERMAL_MENU.get(), ThermalScreen::new);
    }
}