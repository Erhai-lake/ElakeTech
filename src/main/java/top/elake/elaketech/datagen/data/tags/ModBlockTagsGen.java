package top.elake.elaketech.datagen.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.block.CommonBlock;
import top.elake.elaketech.tag.ModBlockTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author Qi-Month
 */
public class ModBlockTagsGen extends BlockTagsProvider {
    public ModBlockTagsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ElakeTech.MODID, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        // 铲子挖
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(CommonBlock.KAOLIN.get());
        // 可获取杂草的方块
        this.tag(ModBlockTags.Blocks.GET_GRASS_FIBER)
                .add(Blocks.SHORT_GRASS)
                .add(Blocks.TALL_GRASS);
    }
}