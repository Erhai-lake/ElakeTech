package top.elake.elaketech.register.fluid;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import top.elake.elaketech.ElakeTech;

import static top.elake.elaketech.ElakeTech.REGISTRATE;

/**
 * @author Qi-Month
 */
public class Gas {
    public static void register() {
    }

    public static final FluidEntry<BaseFlowingFluid.Flowing> TEST_FLUID = REGISTRATE.fluid("test_fluid",
                    ElakeTech.loadRes("fluid/sky_stone_still"),
                    ElakeTech.loadRes("fluid/sky_stone_flowing"))
            .properties((properties) -> properties
                    .viscosity(1000)
                    .density(1000)
                    .lightLevel(15)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                    .canHydrate(false)
                    .canDrown(false)
                    .canSwim(false))
            .register();
}