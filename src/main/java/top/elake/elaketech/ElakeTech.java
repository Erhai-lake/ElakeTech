package top.elake.elaketech;

import com.tterrag.registrate.Registrate;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLPaths;
import top.elake.elaketech.config.RecipeRemoveConfig;
import top.elake.elaketech.datagen.assets.translation.Translation;
import top.elake.elaketech.event.Event;
import top.elake.elaketech.register.ElakeTechRegister;

/**
 * @author Elake Studio
 */
@Mod(ElakeTech.MODID)
public class ElakeTech {
    /**
     * 模组ID
     */
    public static final String MODID = "elake_tech";

    /**
     * 注册器
     */
    public static final Registrate REGISTER = Registrate.create(MODID);

    public static ResourceLocation loadResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    /**
     * 初始化
     *
     * @param event 总线
     */
    public ElakeTech(IEventBus event) {
        // 注册
        ElakeTechRegister.register(event);
        // 注册事件
        Event.register();
        // 语言
        Translation.registers();
        // 确保配置目录存在
        FMLPaths.CONFIGDIR.get().resolve(MODID).toFile().mkdirs();
        // 预加载配置
        RecipeRemoveConfig.getInstance();
    }

//    private void registerCapabilities(RegisterCapabilitiesEvent event) {
//        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntity.THERMAL_POWER.get(), ThermalBlockEntity::getEnergyStorage);
//    }
}
