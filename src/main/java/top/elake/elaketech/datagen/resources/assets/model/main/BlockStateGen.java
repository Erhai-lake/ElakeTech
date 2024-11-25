package top.elake.elaketech.datagen.resources.assets.model.main;


import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.resources.assets.model.BlockState;

import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class BlockStateGen extends BlockStateProvider {
    public BlockStateGen(PackOutput output, ExistingFileHelper helper) {
        super(output, ElakeTech.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (Supplier<Block> item : BlockState.LIST) {
            blockStateGen(item);
        }
    }

    public void blockStateGen(Supplier<Block> block) {
        this.simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
