package top.elake.elaketech.datagen.resources.assets.model.main;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.resources.assets.model.BlockModel;

import java.util.List;

/**
 * @author Erhai-lake
 */
public class BlockModelGen extends BlockModelProvider {
    public BlockModelGen(PackOutput output, ExistingFileHelper helper) {
        super(output, ElakeTech.MODID, helper);
    }

    @Override
    protected void registerModels() {
        for (List<String> item : BlockModel.LIST) {
            blockModelGen(item.get(0), item.get(1), item.get(2));
        }
    }

    public void blockModelGen(String namespace, String path, String type) {
        this.getBuilder(namespace)
                .parent(new ModelFile.UncheckedModelFile("minecraft:block/cube_all"))
                .texture("all", ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path));
    }
}
