package top.elake.elaketech.datagen;

import net.minecraft.data.DataProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import top.elake.elaketech.datagen.assets.translation.language.English;
import top.elake.elaketech.datagen.assets.translation.language.Chinese;
import top.elake.elaketech.datagen.data.recipes.Recipes;
import top.elake.elaketech.datagen.data.tags.ElakeTechBlockTagsGen;
import top.elake.elaketech.datagen.data.tags.ElakeTechFluidTagsGen;
import top.elake.elaketech.datagen.data.tags.ElakeTechItemTagsGen;
import top.elake.elaketech.datagen.data.worldgen.ore.ElakeWorldGen;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author Elake Studio
 */
@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // Language Files
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<English>) English::new);
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<Chinese>) Chinese::new);
        // OreBlastingUtil Generation
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ElakeWorldGen>)
                (output) -> new ElakeWorldGen(output, event.getLookupProvider()));
        // Block Tags
        ElakeTechBlockTagsGen blockTagsProvider = event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ElakeTechBlockTagsGen>)
                (output) -> new ElakeTechBlockTagsGen(output, event.getLookupProvider(), event.getExistingFileHelper()));
        // Item Tags
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ElakeTechItemTagsGen>)
                (output) -> new ElakeTechItemTagsGen(output, event.getLookupProvider(), blockTagsProvider.contentsGetter(), event.getExistingFileHelper()));
        // Fluid Tags
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ElakeTechFluidTagsGen>)
                (output) -> new ElakeTechFluidTagsGen(output, event.getLookupProvider(), event.getExistingFileHelper()));
        // Recipes
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<Recipes>)
                (output) -> new Recipes(output, event.getLookupProvider()));
    }
}
