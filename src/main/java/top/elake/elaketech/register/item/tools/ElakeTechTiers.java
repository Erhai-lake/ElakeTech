package top.elake.elaketech.register.item.tools;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import top.elake.elaketech.tag.ModItemTags;

/**
 * @author Elake Studio
 */
public class ElakeTechTiers {
    /**
     * 燧石
     */
    public static final Tier FLINT_TIER = new SimpleTier(
            Tiers.STONE.getIncorrectBlocksForDrops(),
            20,
            1.5F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.FLINT)
    );

    /**
     * 燧石
     */
    public static final Tier FLINT_HATCHET_TIER = new SimpleTier(
            Tiers.STONE.getIncorrectBlocksForDrops(),
            10,
            1.0F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.FLINT)
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
            () -> Ingredient.of(ModItemTags.BRONZE_INGOT)
    );
}