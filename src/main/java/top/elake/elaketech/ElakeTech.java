package top.elake.elaketech;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import top.elake.elaketech.datagen.model.item.ItemModel;
import top.elake.elaketech.datagen.translation.I18n;
import top.elake.elaketech.event.NoDiggingWood;
import top.elake.elaketech.registers.ModCreativeModeTab;
import top.elake.elaketech.registers.block.ModBlock;
import top.elake.elaketech.registers.item.ChemicalAppliances;
import top.elake.elaketech.registers.item.Elements;
import top.elake.elaketech.registers.item.Materials;
import top.elake.elaketech.registers.tool.tier.Flint;
import top.elake.elaketech.utils.Registers;

/**
 * @author Erhai-lake Qi-Month
 */
@Mod(ElakeTech.MODID)
public class ElakeTech {
    /**
     * 模组ID
     */
    public static final String MODID = "elake_tech";

    /**
     * 构造函数
     *
     * @param event 事件总线
     */
    public ElakeTech(IEventBus event) {
        // 元素
        Elements.register();
        // 材料
        Materials.register();
        // 方块
        ModBlock.register();
        // 燧石工具
        Flint.register();
        // 化学工具
        ChemicalAppliances.register();

        // 注册物品
        Registers.registerItems(event);
        // 注册方块
        Registers.registerBlocks(event);

        //数据生成器
        // i18n
        I18n.registers();
        // 物品模型
        ItemModel.registers();

        // 注册非空手掘木
        NoDiggingWood.register(NeoForge.EVENT_BUS);
        // 注册创造模式物品栏
        ModCreativeModeTab.register(event);
    }
}