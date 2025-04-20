package top.elake.elaketech.register.tool;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import top.elake.elaketech.tag.ModItemTags;

/**
 * @author Qi-Month
 */
public class ModTiers {
    /**
     * 燧石
     */
    public static final Tier FLINT_TIER = new SimpleTier(
            Tiers.STONE.getIncorrectBlocksForDrops(),
            60,
            3F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    /**
     * 燧石手斧
     */
    public static final Tier FLINT_HATCHET_TIER = new SimpleTier(
            Tiers.STONE.getIncorrectBlocksForDrops(),
            40,
            1.5F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    /**
     * 青铜
     */
    public static final Tier BRONZE_TIER = new SimpleTier(
            Tiers.IRON.getIncorrectBlocksForDrops(),
            120,
            6F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.BRONZE_INGOT)
    );
}