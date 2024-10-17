package top.elake.elakechemical;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import top.elake.elakechemical.registers.block.ModBlock;
import top.elake.elakechemical.registers.item.Elements;
import top.elake.elakechemical.registers.ModCreativeModeTab;

/**
 * @author Erhai_lake
 */
@Mod(ElakeChemical.MODID)
public class ElakeChemical {
    public static final String MODID = "elake_chemical";

    public ElakeChemical(IEventBus event) {
        Elements.register(event);
        ModBlock.register(event);
        ModCreativeModeTab.register(event);
    }
}