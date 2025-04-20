package top.elake.elaketech.client.ponder;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.IngotItem;

/**
 * @author Qi-Month
 */
public class ModPonderTags {
    public static void register(PonderTagRegistrationHelper<ResourceLocation> event) {
        PonderTagRegistrationHelper<RegistryEntry<?, ?>> helper = event.withKeyFunction(RegistryEntry::getId);

        PonderTagRegistrationHelper<ItemLike> itemHelper = event.withKeyFunction(RegisteredObjectsHelper::getKeyOrThrow);

        event.registerTag(ElakeTech.loadResource("test_ponder_tag"))
                .addToIndex()
                .icon(ResourceLocation.fromNamespaceAndPath("minecraft", "grass_block"))
                .title("Test Ponder Tag")
                .description("Test Ponder Tag")
                .register();

        itemHelper.addToTag(ElakeTech.loadResource("test_ponder_tag"))
                .add(IngotItem.BRONZE);
    }
}