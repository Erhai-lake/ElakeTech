package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.SoundType;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.block.blockentity.registers.RegistersThermalBlockEntity;


/**
 * @author Qi-Month
 */
public class Machine {
    public static final BlockEntry<RegistersThermalBlockEntity> THERMAL_POWER = ElakeTech.REGISTER.block("thermal_power", RegistersThermalBlockEntity::new)
            .simpleItem()
            .properties((properties) -> properties
                    .sound(SoundType.LANTERN)
                    .strength(3.0f)
                    .requiresCorrectToolForDrops())
            .register();

    public static void registers() {
    }
}