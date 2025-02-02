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
     * 获取neoforge的tag
     *
     * @param tag 标签名
     */
    private static TagKey<Block> getTag(String namespace, String tag) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(namespace, tag));
    }

    public static class Blocks {
        public static final TagKey<Block> GET_GRASS_FIBER = getTag(ElakeTech.MODID, "get_grass_fiber");
    }
}