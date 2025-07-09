package top.elake.elaketech.register.block.entity.machine;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.items.IItemHandler;
import top.elake.elaketech.register.ElakeTechBlockEntities;
import top.elake.elaketech.register.capability.boiler.BoilerFluidHandler;
import top.elake.elaketech.register.capability.boiler.BoilerItemHandler;

/**
 * @author Elake Studio
 */
public class BoilerBlockEntity extends BlockEntity {
    public BoilerBlockEntity(BlockPos pos, BlockState state) {
        super(ElakeTechBlockEntities.BOILER.get(), pos, state);
    }

    private final BoilerItemHandler itemInventory = new BoilerItemHandler();
    private final BoilerFluidHandler fluidInventory = new BoilerFluidHandler();

    public IItemHandler getInvCap(Direction side) {
        return itemInventory;
    }

    public IFluidHandler getFluidInvCap(Direction side) {
        return fluidInventory;
    }
}