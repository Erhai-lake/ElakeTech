package top.elake.elaketech.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.resources.assets.model.main.ModBlockModelGen;
import top.elake.elaketech.datagen.resources.assets.model.main.ModBlockStateGen;
import top.elake.elaketech.datagen.resources.assets.model.main.ModItemModelGen;
import top.elake.elaketech.datagen.resources.assets.translation.i18n.language.ZH;
import top.elake.elaketech.datagen.resources.assets.translation.i18n.language.EN;
import top.elake.elaketech.datagen.resources.data.tags.ModBlockTagsGen;
import top.elake.elaketech.datagen.resources.data.tags.ModItemTagsGen;
import top.elake.elaketech.datagen.resources.data.worldgen.ore.ModWorldGen;

import java.util.concurrent.CompletableFuture;

/**
 * @author Erhai-lake Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        CompletableFuture<HolderLookup.Provider> lp = event.getLookupProvider();
        // Language Files
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<EN>) EN::new);
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ZH>) ZH::new);
        // Item Models
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ModItemModelGen>)
                output -> new ModItemModelGen(output, event.getExistingFileHelper()));
        // Block Models
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ModBlockModelGen>)
                output -> new ModBlockModelGen(output, event.getExistingFileHelper()));
        // Block States
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ModBlockStateGen>)
                output -> new ModBlockStateGen(output, event.getExistingFileHelper()));
        // Ore Generation
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModWorldGen>)
                output -> new ModWorldGen(output, event.getLookupProvider()));
        // Block Tags
        ExistingFileHelper efhBlock = event.getExistingFileHelper();
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModBlockTagsGen>)
                output -> new ModBlockTagsGen(output, lp, efhBlock));
        // Item Tags
        ExistingFileHelper efhItem = event.getExistingFileHelper();
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModItemTagsGen>)
                output -> new ModItemTagsGen(output, lp, efhItem));
    }
}