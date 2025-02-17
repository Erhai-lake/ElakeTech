package top.elake.elaketech.register.fluid;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import top.elake.elaketech.ElakeTech;

/**
 * @author Qi-Month
 */
public class Gas {
    public static final Registrate REGISTRATE = Registrate.create(ElakeTech.MODID);

    public static void register() {
    }

    public static final FluidEntry<BaseFlowingFluid.Flowing> TEST_FLUID = REGISTRATE.fluid("test_fluid",
                    ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, "fluid/unstable_sky_stone_still"),
                    ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, "fluid/unstable_sky_stone_flowing"))
            .properties((p) -> p
                    .density(1000)
                    .viscosity(1000)
                    .lightLevel(15)
            ).register();
}