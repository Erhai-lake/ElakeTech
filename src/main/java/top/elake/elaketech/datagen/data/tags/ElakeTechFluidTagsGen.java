package top.elake.elaketech.datagen.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.fluid.ElakeTechFluidRegister;
import top.elake.elaketech.tag.ModFluidTags;

import java.util.concurrent.CompletableFuture;

public class ElakeTechFluidTagsGen extends FluidTagsProvider {
    public ElakeTechFluidTagsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ElakeTech.MODID, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ModFluidTags.STEAM)
                .add(ElakeTechFluidRegister.STEAM.get());
    }
}