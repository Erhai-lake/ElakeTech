package top.elake.elaketech;

import com.tterrag.registrate.Registrate;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import top.elake.elaketech.config.RecipeRemoveConfig;
import top.elake.elaketech.datagen.assets.translation.Translation;
import top.elake.elaketech.event.Event;
import top.elake.elaketech.register.ElakeTechBlockEntities;
import top.elake.elaketech.register.ElakeTechRegister;
import top.elake.elaketech.register.block.entity.machine.BoilerBlockEntity;
import top.elake.elaketech.register.block.entity.render.DryRackBlockEntityRender;

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

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ElakeTechBlockEntities.DRY_RACK.get(), DryRackBlockEntityRender::new);
        }
    }
}