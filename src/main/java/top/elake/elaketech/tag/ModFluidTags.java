package top.elake.elaketech.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

/**
 * @author Qi-Month
 */
public class ModFluidTags {
    public static TagKey<Fluid> createFluidTag(String namespace, String tag) {
        return FluidTags.create(ResourceLocation.fromNamespaceAndPath(namespace, tag));
    }

    public static final TagKey<Fluid> STEAM = createFluidTag("c", "steam");
}