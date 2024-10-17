package top.elake;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import top.elake.registers.Paintings;
import top.elake.registers.block.ModBlock;
import top.elake.registers.item.Elements;
import top.elake.registers.ModCreativeModeTab;

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
        Paintings.register(event);
    }
}