package top.elake.elaketech;

import com.tterrag.registrate.Registrate;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import top.elake.elaketech.registries.ETCreativeTabs;
import top.elake.elaketech.registries.ETItems;

/**
 * @author Erhai-lake
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
    public static final Registrate REGISTRATE = Registrate.create(MODID);

//    public static ResourceLocation loadRes(String path) {
//        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
//    }

    /**
     * 初始化
     *
     * @param event 总线
     */
    public ElakeTech(IEventBus event) {
        // 注册物品
        ETItems.register();
        // 注册创造物品栏
        ETCreativeTabs.register();
    }

//    private void registerCapabilities(RegisterCapabilitiesEvent event) {
//        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntity.THERMAL_POWER.get(), ThermalBlockEntity::getEnergyStorage);
//    }
}
