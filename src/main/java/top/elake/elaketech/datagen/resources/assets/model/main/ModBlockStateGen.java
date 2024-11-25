package top.elake.elaketech.datagen.resources.assets.model.main;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.resources.assets.model.ModBlockState;

import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class ModBlockStateGen extends BlockStateProvider {
    public ModBlockStateGen(PackOutput output, ExistingFileHelper helper) {
        super(output, ElakeTech.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (ModBlockState.BlockStateList item : ModBlockState.LIST) {
            blockStateGen(item.namespace() ,item.blockSupplier(), item.path());
        }
    }

    public void blockStateGen(String namespace, Supplier<Block> block, String path) {
        ModelFile model = models().cubeAll(namespace, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path));
        this.simpleBlockWithItem(block.get(), model);
    }
}
