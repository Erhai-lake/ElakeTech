package top.elake.elaketech.datagen;

import net.minecraft.data.DataProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import top.elake.elaketech.datagen.assets.translation.language.EN;
import top.elake.elaketech.datagen.assets.translation.language.ZH;
import top.elake.elaketech.datagen.data.tags.ModBlockTagsGen;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author ElakeStudio
 */
@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // Language Files
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<EN>) EN::new);
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ZH>) ZH::new);
        // Block Tags
        var blockTagsProvider = event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModBlockTagsGen>)
                (output) -> new ModBlockTagsGen(output, event.getLookupProvider(), event.getExistingFileHelper()));
    }
}
