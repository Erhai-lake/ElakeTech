package top.elake.elaketech.datagen;

import net.minecraft.data.DataProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.resources.assets.model.main.BlockModelGen;
import top.elake.elaketech.datagen.resources.assets.model.main.BlockStateGen;
import top.elake.elaketech.datagen.resources.assets.model.main.ItemModelGen;
import top.elake.elaketech.datagen.resources.assets.translation.language.en_us;
import top.elake.elaketech.datagen.resources.assets.translation.language.zh_cn;
import top.elake.elaketech.datagen.resources.data.worldgen.ore.ModWorldGen;

/**
 * @author Erhai-lake
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper efh = event.getExistingFileHelper();
        var lp = event.getLookupProvider();
        // 语言文件
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<en_us>) en_us::new);
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<zh_cn>) zh_cn::new);
        // 物品模型
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ItemModelGen>)
                output -> new ItemModelGen(output, efh));
        // 方块模型
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<BlockModelGen>)
                output -> new BlockModelGen(output, efh));
        // 方块状态
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<BlockStateGen>)
                output -> new BlockStateGen(output, efh));
        // 矿物生成
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModWorldGen>)
                output -> new ModWorldGen(output, lp));
    }
}