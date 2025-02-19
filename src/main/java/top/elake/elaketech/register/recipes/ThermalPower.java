package top.elake.elaketech.register.recipes;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.server.recipes.type.ThermalRecipe;

import java.util.function.Supplier;

/**
 * @author Qi-Month
 */
public class ThermalPower {
    public static final DeferredRegister<RecipeSerializer<?>> DR_SERIALIZER =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, ElakeTech.MODID);
    public static final DeferredRegister<RecipeType<?>> DR_TYPE =
            DeferredRegister.create(Registries.RECIPE_TYPE, ElakeTech.MODID);

    public static final Supplier<ThermalRecipe.Serializer> ENERGIZING_SERIALIZER = DR_SERIALIZER.register("thermal_power",
            ThermalRecipe.Serializer::new);
    public static final Supplier<RecipeType<ThermalRecipe>> ENERGIZING = DR_TYPE.register("thermal_power",
            () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return ThermalRecipe.ID.toString();
                }
            }
    );
}