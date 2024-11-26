package top.elake.elaketech.datagen.resources.assets.model.main;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.resources.assets.model.ModItemModel;

import java.util.List;

/**
 * @author Erhai-lake
 */
public class ModItemModelGen extends ItemModelProvider {
    public ModItemModelGen(PackOutput output, ExistingFileHelper helper) {
        super(output, ElakeTech.MODID, helper);
    }

    @Override
    protected void registerModels() {
        for (List<String> item : ModItemModel.LIST) {
            itemModelGen(item.get(0), item.get(1), item.get(2));
        }
    }

    public void itemModelGen(String file, String path, String type) {
        switch (type) {
            case "Item":
                this.getBuilder(file)
                        .parent(new ModelFile.UncheckedModelFile("minecraft:item/generated"))
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path));
                break;
            case "BlockItem":
                this.getBuilder(file)
                        .parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path)));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
