package top.elake.elakechemical;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import top.elake.elakechemical.function.NoDiggingWood;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.registers.block.ModBlock;
import top.elake.elakechemical.registers.item.Elements;
import top.elake.elakechemical.registers.item.Sundries;
import top.elake.elakechemical.registers.tool.Flint;

/**
 * @author Erhai-lake
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
        // 方块
        ModBlock.register();

        // 注册物品
        Utils.registerItems(event);
        // 注册方块
        Utils.registerBlocks(event);


        // 注册非空手掘木
        NoDiggingWood.register(NeoForge.EVENT_BUS);
        // 注册创造模式物品栏
        ModCreativeModeTab.register(event);
        // 注册燧石工具
        Flint.register(event);
    }
}