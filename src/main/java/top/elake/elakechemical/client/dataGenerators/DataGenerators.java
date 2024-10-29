package top.elake.elakechemical.client.dataGenerators;

import net.minecraft.data.DataProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.client.dataGenerators.translation.en_us;

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
    }
}
