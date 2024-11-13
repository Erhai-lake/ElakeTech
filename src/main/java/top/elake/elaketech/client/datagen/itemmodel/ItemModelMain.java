package top.elake.elaketech.client.datagen.itemmodel;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.elake.elaketech.ElakeTech;

import java.util.List;

/**
 * @author Erhai-lake
 */
public class ItemModelMain extends ItemModelProvider {
    public ItemModelMain(PackOutput output, ExistingFileHelper helper) {
        super(output, ElakeTech.MODID, helper);
    }

    @Override
    protected void registerModels() {
        for (List<String> item : ItemModel.LIST) {
            magicIngotModel(item.get(0), item.get(1));
        }
    }

    public void magicIngotModel(String namespace, String texture) {
        this.getBuilder(namespace)
                .parent(new ModelFile.UncheckedModelFile("minecraft:item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, texture));
    }
}