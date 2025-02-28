package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.register.block.blockentity.registers.RegistersThermalBlockEntity;

import java.util.function.Supplier;

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