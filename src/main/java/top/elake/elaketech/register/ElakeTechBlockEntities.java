package top.elake.elaketech.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.register.block.MachineBlock;
import top.elake.elaketech.register.block.entity.function.DryRackBlockEntity;
import top.elake.elaketech.register.block.FunctionBlock;
import top.elake.elaketech.register.block.entity.machine.BoilerBlockEntity;

import java.util.function.Supplier;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author Elake Studio
 */
public class ElakeTechBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    private static Supplier registerBlockEntity(String id, BlockEntityType.BlockEntitySupplier entity, Block block) {
        return BLOCK_ENTITIES.register(id, () -> {
            return BlockEntityType.Builder.of(entity, block)
                    .build(null);
        });
    }

    public static final Supplier<BlockEntityType<DryRackBlockEntity>> DRY_RACK;
    public static final Supplier<BlockEntityType<BoilerBlockEntity>> BOILER;

    static {
        // 晾干架
        DRY_RACK = registerBlockEntity("dry_rack", DryRackBlockEntity::new, FunctionBlock.DRY_RACK.get());
        // 锅炉
        BOILER = registerBlockEntity("boiler", BoilerBlockEntity::new, MachineBlock.BOILER.get());
    }
}