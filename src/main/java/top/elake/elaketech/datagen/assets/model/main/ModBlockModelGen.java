package top.elake.elaketech.datagen.assets.model.main;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.assets.model.ModBlockModel;

import java.util.List;

/**
 * @author Erhai-lake
 */
public class ModBlockModelGen extends BlockModelProvider {
    public ModBlockModelGen(PackOutput output, ExistingFileHelper helper) {
        super(output, ElakeTech.MODID, helper);
    }

    @Override
    protected void registerModels() {
        for (List<String> item : ModBlockModel.LIST) {
            blockModelGen(item.get(0), item.get(1), item.get(2));
        }
    }

    public void blockModelGen(String file, String path, String type) {
        this.getBuilder(file)
                .parent(new ModelFile.UncheckedModelFile("minecraft:block/cube_all"))
                .texture("all", ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path));
    }
}