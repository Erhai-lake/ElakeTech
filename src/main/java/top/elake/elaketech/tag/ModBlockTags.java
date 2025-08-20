package top.elake.elaketech.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author Elake Studio
 */
public class ModBlockTags {
    /**
     * 定义Tags
     *
     * @param namespace 命名空间
     * @param tag       标签名
     */
    public static TagKey<Block> createBlockTag(String namespace, String tag) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(namespace, tag));
    }

    public static final TagKey<Block> GET_GRASS_FIBER;

    static {
        GET_GRASS_FIBER = createBlockTag(MODID, "get_grass_fiber");
    }
}