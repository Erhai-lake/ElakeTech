package top.elake.elakechemical.registers.tag;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import top.elake.elakechemical.ElakeChemical;

/**
 * @author Qi-Month
 */
public class ModBlockTags {
    public static final TagKey<Block> NEEDS_FLINT_TOOL = TagKey
            .create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(ElakeChemical.MODID, "needs_flint_tool"));
}