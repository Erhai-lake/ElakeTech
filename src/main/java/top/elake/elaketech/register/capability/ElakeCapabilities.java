package top.elake.elaketech.register.capability;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import top.elake.elaketech.register.ElakeTechBlockEntities;
import top.elake.elaketech.register.block.entity.machine.BoilerBlockEntity;

/**
 * @author Elake Studio
 */
public class ElakeCapabilities {
    @SubscribeEvent
    private static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                ElakeTechBlockEntities.BOILER.get(),
                BoilerBlockEntity::getInvCap
        );
        event.registerBlockEntity(
                Capabilities.FluidHandler.BLOCK,
                ElakeTechBlockEntities.BOILER.get(),
                BoilerBlockEntity::getFluidInvCap
        );
    }
}