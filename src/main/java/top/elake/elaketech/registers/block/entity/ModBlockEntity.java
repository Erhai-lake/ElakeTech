package top.elake.elaketech.registers.block.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.registers.block.ModBlock;

import java.util.function.Supplier;

/**
 * @author Qi-Month
 */
public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister
            .create(Registries.BLOCK_ENTITY_TYPE, ElakeTech.MODID);

    public static final Supplier<BlockEntityType<CustomTestBlockEntity>> CUSTOM_GUI = BLOCK_ENTITY.register("custom_gui",
            () -> BlockEntityType.Builder.of(CustomTestBlockEntity::new, ModBlock.TEST_BLOCK.get())
                    .build(null));
}