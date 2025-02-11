package top.elake.elaketech.register.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.block.blockentity.ThermalBlockEntity;

import java.util.function.Supplier;

/**
 * @author Qi-Month
 */
public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ElakeTech.MODID);

    public static final Supplier<BlockEntityType<ThermalBlockEntity>> THERMAL_POWER = BLOCK_ENTITIES.register("thermal",
            () -> BlockEntityType.Builder.<ThermalBlockEntity>of(
                    (pos, state) -> new ThermalBlockEntity(ModBlockEntity.THERMAL_POWER.get(), pos, state),
                    Machine.THERMAL_POWER.get()
            ).build(null));
}