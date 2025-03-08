package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.SoundType;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.block.entity.registers.RegisterThermalBlockEntity;

/**
 * @author Qi-Month
 */
public class Machine {
    public static final BlockEntry<RegisterThermalBlockEntity> THERMAL_POWER = ElakeTech.REGISTER.block("thermal_power", RegisterThermalBlockEntity::new)
            .simpleItem()
            .properties((properties) -> properties
                    .sound(SoundType.LANTERN)
                    .strength(3.0f)
                    .requiresCorrectToolForDrops())
            .register();

    public static void registers() {
    }
}