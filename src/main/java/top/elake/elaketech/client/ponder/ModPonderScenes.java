package top.elake.elaketech.client.ponder;

import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import top.elake.elaketech.register.item.IngotItem;

/**
 * @author Qi-Month
 */
public class ModPonderScenes {
    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?, ?>> event = helper.withKeyFunction(RegistryEntry::getId);

        event.forComponents((Iterable<? extends ItemProviderEntry<?, ?>>) IngotItem.BRONZE.get())
                .addStoryBoard("test_ponder", TestPonder::testPonder);
    }
}