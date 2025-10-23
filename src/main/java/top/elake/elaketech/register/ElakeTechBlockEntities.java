package top.elake.elaketech.register;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import top.elake.elaketech.register.block.MachineBlock;
import top.elake.elaketech.register.block.entity.function.DryRackBlockEntity;
import top.elake.elaketech.register.block.FunctionBlock;
import top.elake.elaketech.register.block.entity.machine.BoilerBlockEntity;

import static top.elake.elaketech.ElakeTech.*;

/**
 * @author Elake Studio
 */
public class ElakeTechBlockEntities {
    public static void register() {
    }

    public static final BlockEntityEntry<DryRackBlockEntity> DRY_RACK = REGISTER
            .blockEntity("dry_rack", DryRackBlockEntity::new)
            .validBlocks(FunctionBlock.DRY_RACK)
            .register();

    public static final BlockEntityEntry<BoilerBlockEntity> BOILER = REGISTER
            .blockEntity("boiler", BoilerBlockEntity::new)
            .validBlocks(MachineBlock.BOILER)
            .register();
}