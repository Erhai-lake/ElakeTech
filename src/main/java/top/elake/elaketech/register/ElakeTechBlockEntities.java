package top.elake.elaketech.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.register.block.entity.DryRackBlockEntity;
import top.elake.elaketech.register.block.FunctionBlock;

import java.util.function.Supplier;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author Elake Studio
 */
public class ElakeTechBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    /**
     * 晾干架
     */
    public static final Supplier<BlockEntityType<DryRackBlockEntity>> DRY_RACK = BLOCK_ENTITIES.register("dry_rack",
            () -> BlockEntityType.Builder.of(DryRackBlockEntity::new,
                    FunctionBlock.DRY_RACK.get()).build(null));
}