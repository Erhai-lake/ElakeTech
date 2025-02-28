package top.elake.elaketech.datagen.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.Materials;
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
        // 板砖
        this.tag(Tags.Items.BRICKS)
                .add(Items.BRICK)
                .add(Materials.WET_REFRACTORY_BRICK.get())
                .add(Materials.REFRACTORY_BRICK.get());
        // 黏土球
        this.tag(ModItemTags.Items.CLAY_BALL)
                .add(Items.CLAY_BALL)
                .add(Materials.REFRACTORY_CLAY_BALL.get());
        // 燧石
        this.tag(ModItemTags.Items.FLINT)
                .add(Items.FLINT);
        // 为单个锭添加Tags
        this.tag(ModItemTags.Items.GRAPHITE_INGOT)
                .add(Materials.GRAPHITE_INGOT.get());
    }
}