package top.elake.elaketech.datagen;

import net.minecraft.data.DataProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.assets.model.main.ModBlockModelGen;
import top.elake.elaketech.datagen.assets.model.main.ModBlockStateGen;
import top.elake.elaketech.datagen.assets.model.main.ModItemModelGen;
import top.elake.elaketech.datagen.assets.translation.language.ZH;
import top.elake.elaketech.datagen.assets.translation.language.EN;
import top.elake.elaketech.datagen.data.recipes.ModRecipesGen;
import top.elake.elaketech.datagen.data.tags.ModBlockTagsGen;
import top.elake.elaketech.datagen.data.tags.ModItemTagsGen;
import top.elake.elaketech.datagen.data.worldgen.ore.ModWorldGen;


/**
 * @author Erhai-lake Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // Language Files
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<EN>) EN::new);
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ZH>) ZH::new);
        // Item Models
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ModItemModelGen>)
                (output) -> new ModItemModelGen(output, event.getExistingFileHelper()));
        // Block Models
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ModBlockModelGen>)
                (output) -> new ModBlockModelGen(output, event.getExistingFileHelper()));
        // Block States
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ModBlockStateGen>)
                (output) -> new ModBlockStateGen(output, event.getExistingFileHelper()));
        // OreBlasting Generation
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModWorldGen>)
                (output) -> new ModWorldGen(output, event.getLookupProvider()));
        // Block Tags
        var blockTagsProvider = event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModBlockTagsGen>)
                (output) -> new ModBlockTagsGen(output, event.getLookupProvider(), event.getExistingFileHelper()));
        // Item Tags
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModItemTagsGen>)
                (output) -> new ModItemTagsGen(output, event.getLookupProvider(), blockTagsProvider.contentsGetter(), event.getExistingFileHelper()));
        // MainRecipes
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModRecipesGen>)
                (output) -> new ModRecipesGen(output, event.getLookupProvider()));
    }
}