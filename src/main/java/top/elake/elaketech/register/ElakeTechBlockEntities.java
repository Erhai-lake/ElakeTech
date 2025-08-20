package top.elake.elaketech.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
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

    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, BlockEntityType.BlockEntitySupplier<T> entity, Supplier<? extends Block> block) {
        return BLOCK_ENTITIES.register(id, () -> {
            return BlockEntityType.Builder.of(entity, block.get()).build(null);
        });
    }

    public static final Supplier<BlockEntityType<DryRackBlockEntity>> DRY_RACK =
            registerBlockEntity("dry_rack", DryRackBlockEntity::new, FunctionBlock.DRY_RACK);

    public static final Supplier<BlockEntityType<BoilerBlockEntity>> BOILER =
            registerBlockEntity("boiler", BoilerBlockEntity::new, MachineBlock.BOILER);
}