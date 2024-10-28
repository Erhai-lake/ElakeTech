package top.elake.elakechemical;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import top.elake.elakechemical.event.NoDiggingWood;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.registers.block.ModBlock;
import top.elake.elakechemical.registers.item.ChemicalAppliances;
import top.elake.elakechemical.registers.item.Elements;
import top.elake.elakechemical.registers.item.Materials;
import top.elake.elakechemical.registers.item.Sundries;
import top.elake.elakechemical.registers.tool.Hammer;
import top.elake.elakechemical.registers.tool.tier.Flint;
import top.elake.elakechemical.utils.Registers;

/**
 * @author Erhai-lake Qi-Month
 */
@Mod(ElakeChemical.MODID)
public class ElakeChemical {
    /**
     * 模组ID
     */
    public static final String MODID = "elake_chemical";

    /**
     * 构造函数
     *
     * @param event 事件总线
     */
    public ElakeChemical(IEventBus event) {
        // 元素
        Elements.register();
        // 杂项
        Sundries.register();
        // 材料
        Materials.register();
        // 方块
        ModBlock.register();
        // 燧石工具
        Flint.register();
        // 化学工具
        ChemicalAppliances.register();
        // 锤子
        Hammer.register();

        // 注册物品
        Registers.registerItems(event);
        // 注册方块
        Registers.registerBlocks(event);


        // 注册非空手掘木
        NoDiggingWood.register(NeoForge.EVENT_BUS);
        // 注册创造模式物品栏
        ModCreativeModeTab.register(event);
    }
}