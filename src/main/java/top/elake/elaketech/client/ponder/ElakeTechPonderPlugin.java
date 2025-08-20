package top.elake.elaketech.client.ponder;

import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.ElakeTech;

/**
 * @author Elake Studio
 */
public class ElakeTechPonderPlugin implements PonderPlugin {
    @Override
    public @NotNull String getModId() {
        return ElakeTech.MODID;
    }

    @Override
    public void registerScenes(@NotNull PonderSceneRegistrationHelper<ResourceLocation> helper) {
        ElakeTechPonderRegisters.register(helper);
    }
}