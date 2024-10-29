package top.elake.elakechemical.client.datagen;

import net.minecraft.data.DataProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.client.datagen.translation.en_us;
import top.elake.elakechemical.client.datagen.translation.zh_cn;

/**
 * @author Erhai-lake
 */
@EventBusSubscriber(modid = ElakeChemical.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // 语言文件
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<en_us>) en_us::new
        );
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<zh_cn>) zh_cn::new
        );
    }
}