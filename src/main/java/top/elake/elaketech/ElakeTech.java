package top.elake.elaketech;

import com.tterrag.registrate.Registrate;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import top.elake.elaketech.register.ETCreativeTabs;
import top.elake.elaketech.register.block.OreBlock;
import top.elake.elaketech.register.item.ETItems;
import top.elake.elaketech.register.item.material.IngotItem;
import top.elake.elaketech.register.item.material.OreItem;
import top.elake.elaketech.register.item.material.PlateItem;
import top.elake.elaketech.register.tool.FunctionTool;
import top.elake.elaketech.register.tool.tier.Bronze;
import top.elake.elaketech.register.tool.tier.Flint;
import top.elake.elaketech.register.tool.tier.Stone;

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

    public static ResourceLocation loadResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    /**
     * 初始化
     *
     * @param event 总线
     */
    public ElakeTech(IEventBus event) {
        // 注册物品
        ETItems.register();
        // 注册锭
        IngotItem.register();
        // 注册板材
        PlateItem.register();
        // 粗矿
        OreItem.register();
        // 矿物
        OreBlock.register();
        // 燧石工具
        Flint.register();
        // 青铜工具
        Bronze.register();
        // 石头工具
        Stone.register();
        // 功能性工具
        FunctionTool.register();
        // 注册创造物品栏
        ETCreativeTabs.register();
    }

//    private void registerCapabilities(RegisterCapabilitiesEvent event) {
//        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntity.THERMAL_POWER.get(), ThermalBlockEntity::getEnergyStorage);
//    }
}
