package top.elake.elaketech.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import top.elake.elaketech.ElakeTech;

/**
 * @author Qi-Month
 */
public class ModBlockTags {
    /**
     * 定义定义Tags
     *
     * @param namespace 命名空间
     * @param tag       标签名
     */
    public static TagKey<Block> createBlockTag(String namespace, String tag) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(namespace, tag));
    }

    public static class Blocks {
        public static final TagKey<Block> GET_GRASS_FIBER = createBlockTag(ElakeTech.MODID, "get_grass_fiber");
    }
}