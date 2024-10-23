package top.elake.elakechemical.registers.Tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    private static TagKey<Item> neoforgeTag(String name) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge", name));
    }

    public static class Items {
        public static final TagKey<Item> FLINT = neoforgeTag("flint");
    }
}