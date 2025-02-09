package top.elake.elaketech.datagen.assets.model.main;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.assets.model.ModItemModel;
import top.elake.elaketech.datagen.assets.model.ModToolItemModel;

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
            itemModelGen(item.get(0), item.get(1), item.subList(2, item.size()).toArray(new String[0]));
        }
        // 工具
        for (List<String> item : ModToolItemModel.LIST) {
            itemModelGen(item.get(0), item.get(1), item.subList(2, item.size()).toArray(new String[0]));
        }
    }

    public void itemModelGen(String type, String file, String... path) {
        switch (type) {
            case "Item":
                this.getBuilder(file).parent(new ModelFile.UncheckedModelFile("minecraft:item/generated"));
                for (int i = 0; i < path.length; i++) {
                    this.getBuilder(file).texture("layer" + i, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path[i]));
                }
                break;
            case "BlockItem":
                this.getBuilder(file).parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path[0])));
                break;
            case "Tool":
                this.getBuilder(file).parent(new ModelFile.UncheckedModelFile("minecraft:item/handheld"));
                for (int i = 0; i < path.length; i++) {
                    this.getBuilder(file).texture("layer" + i, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, path[i]));
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}