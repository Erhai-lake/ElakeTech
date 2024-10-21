package top.elake.elakechemical;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.registers.block.ModBlock;
import top.elake.elakechemical.registers.item.Elements;

/**
 * @author Erhai_lake
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
        Elements.register(event);
        ModBlock.register(event);
        ModCreativeModeTab.register(event);
    }
}