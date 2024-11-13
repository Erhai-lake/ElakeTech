package top.elake.elaketech.client.datagen;

import net.minecraft.data.DataProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.client.datagen.itemmodel.ItemModelMain;
import top.elake.elaketech.client.datagen.translation.language.en_us;
import top.elake.elaketech.client.datagen.translation.language.zh_cn;

/**
 * @author Erhai-lake
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper efh = event.getExistingFileHelper();
        // 语言文件
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<en_us>) en_us::new);
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<zh_cn>) zh_cn::new);
        // 物品模型
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ItemModelMain>)
                output -> new ItemModelMain(output, efh));
    }
}