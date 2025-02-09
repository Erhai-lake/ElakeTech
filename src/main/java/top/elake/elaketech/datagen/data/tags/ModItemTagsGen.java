package top.elake.elaketech.datagen.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.Materials;
import top.elake.elaketech.register.item.MetalIngot;
import top.elake.elaketech.register.item.MetalPlate;
import top.elake.elaketech.tag.ModItemTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author Qi-Month
 */
public class ModItemTagsGen extends ItemTagsProvider {
    public ModItemTagsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ElakeTech.MODID, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        // 燧石
        this.tag(ModItemTags.Items.FLINT)
                .add(Items.FLINT);
        // 为单个锭添加Tags
        this.tag(ModItemTags.Items.GRAPHITE)
                .add(Materials.GRAPHITE_INGOT.get());
        // 金属板
        this.tag(ModItemTags.Items.PLATES)
                .add(MetalPlate.IRON_PLATE.get());
        // 铁板
        this.tag(ModItemTags.Items.IRON_PLATE)
                .add(MetalPlate.IRON_PLATE.get());
        // 为每个金属创建单独的IngotTags
        for (MetalIngot.IngotItem ingot : MetalIngot.INGOT_ITEM_GROUP) {
            TagKey<Item> ingotTag = TagKey.create(Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath("c", "ingots/" + ingot.id()));
            this.tag(ingotTag)
                    .add(ingot.item().get());
        }
        // 创建通用的c:ingots, 引用所有单独的IngotTags
        for (MetalIngot.IngotItem ingot : MetalIngot.INGOT_ITEM_GROUP) {
            this.tag(ModItemTags.Items.INGOTS)
                    .addTag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/" + ingot.id())))
                    .add(Materials.GRAPHITE_INGOT.get());
        }
    }
}