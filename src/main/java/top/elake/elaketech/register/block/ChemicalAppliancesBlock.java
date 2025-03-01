package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.block.custom.box.AlcoholLamp;

/**
 * @author Erhai-lake Qi-Month
 */
public class ChemicalAppliancesBlock {
    /**
     * 酒精灯
     */
    public static final BlockEntry<AlcoholLamp> ALCOHOL_LAMP = ElakeTech.REGISTER.block("alcohol_lamp", AlcoholLamp::new)
            .blockstate((c, p) -> p.getVariantBuilder(c.get())
                    .forAllStatesExcept((state) -> ConfiguredModel.builder()
                            .modelFile(p.models()
                                    .cubeAll("alcohol_lamp", p.modLoc("block/chemical_appliances/alcohol_lamp"))
                                    .texture("0", "block/chemical_appliances/alcohol_lamp")
                                    .texture("particle", "block/chemical_appliances/alcohol_lamp"))
                            .build()))
            .properties((properties) -> properties
                    .strength(0.3F)
                    .sound(SoundType.GLASS))
            .register();

    /**
     * 注册
     */
    public static void register() {
    }
}