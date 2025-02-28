package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.SoundType;
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