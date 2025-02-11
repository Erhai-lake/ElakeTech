package top.elake.elaketech.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import top.elake.elaketech.ElakeTech;

/**
 * @author Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD)
public class NetworkHandler {
    @SubscribeEvent
    public static void register(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(ElakeTech.MODID)
                .versioned("1.0.0");

        registrar.playToServer(
                OpenGeneratorScreenPacket.TYPE,
                OpenGeneratorScreenPacket.STREAM_CODEC,
                OpenGeneratorScreenPacket::handle
        );
    }
}