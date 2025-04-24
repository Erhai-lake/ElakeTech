package top.elake.elaketech.register.item.tools;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import top.elake.elaketech.tag.ModItemTags;

/**
 * @author Elake Studio
 */
public class Tools {
    /**
     * 注册工具
     */
    public static void register() {
        // 燧石工具
        FlintTools.register();
    }

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
     * 燧石
     */
    public static final Tier FLINT_HATCHET_TIER = new SimpleTier(
            Tiers.STONE.getIncorrectBlocksForDrops(),
            10,
            1.5F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );
}
