package top.elake.elaketech;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.*;
import net.neoforged.neoforge.common.NeoForge;
import top.elake.elaketech.client.ModTooltip;
import top.elake.elaketech.datagen.assets.model.*;
import top.elake.elaketech.datagen.assets.translation.Common;
import top.elake.elaketech.event.*;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.register.ModMenuType;
import top.elake.elaketech.register.TestBlock;
import top.elake.elaketech.register.block.*;
import top.elake.elaketech.register.block.blockentity.ThermalBlockEntity;
import top.elake.elaketech.register.fluid.Gas;
import top.elake.elaketech.register.item.*;
import top.elake.elaketech.register.tool.*;
import top.elake.elaketech.server.recipes.remove.ItemRecipes;
import top.elake.elaketech.util.Registers;

/**
 * @author Erhai-lake Qi-Month
 */
@Mod(ElakeTech.MODID)
public class ElakeTech {
    /**
     * ModID
     */
    public static final String MODID = "elake_tech";

    /**
     * 构造函数
     *
     * @param event 事件总线
     */
    public ElakeTech(IEventBus event) {
        Gas.register();
        TestBlock.register();

        // 创造模式物品栏
        ModCreativeModeTab.register(event);
        // 元素
        Elements.register();
        // 材料
        Materials.register();
        // 粗矿
        OreItem.register();
        // 金属锭
        MetalIngot.register();
        // 板材
        PlateItem.register();
        // 金属板
        // 化学用具(方块)
        ChemicalAppliancesBlock.register();
        // 矿物
        Ore.register();
        // 方块
        CommonBlock.registers();
        // 化学工具(物品)
        ChemicalAppliancesItem.register();

        // 注册物品
        Registers.registerItems(event);
        // 注册方块
        Registers.registerBlocks(event);

        // 燧石工具
        Flint.register();
        // 青铜工具
        Bronze.register();
        // 石头工具
        Stone.register();

        //数据生成器
        // CommonBlastingMaterial
        Common.registers();
        // 物品模型
        ModItemModel.registers();
        // 工具模型
        ModToolItemModel.registers();
        // 方块
        ModBlockModel.registers();
        // 方块状态
        ModBlockState.registers();

        // 非空手挖掘木头
        NoDiggingWood.register(NeoForge.EVENT_BUS);
        // 右键获取杂草
        RightClickGetGrassFiber.register(NeoForge.EVENT_BUS);
        // Tooltip
        ModTooltip.register(NeoForge.EVENT_BUS);
        // 删除配方
//        RemoveRecipes.register(NeoForge.EVENT_BUS);

        // test
        Machine.BLOCKS.register(event);
        Machine.ITEMS.register(event);
        ModBlockEntity.BLOCK_ENTITIES.register(event);
        ModMenuType.MENU_TYPES.register(event);

        event.addListener(this::registerCapabilities);

        ItemRecipes.removeRecipes();
    }

    private void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntity.THERMAL_POWER.get(), ThermalBlockEntity::getEnergyStorage);
    }
}