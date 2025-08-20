package top.elake.elaketech.datagen.data.worldgen.ore;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import top.elake.elaketech.ElakeTech;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * @author Elake Studio
 */
public class ElakeWorldGen extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ElakeOreFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ElakeOrePlacements::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ElakeBiomeModifiers::bootstrap);

    public ElakeWorldGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ElakeTech.MODID));
    }
}