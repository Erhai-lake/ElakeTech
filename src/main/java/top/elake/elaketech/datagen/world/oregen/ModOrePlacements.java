package top.elake.elaketech.datagen.world.oregen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import top.elake.elaketech.ElakeTech;

import java.util.List;

/**
 * @author Erhai-lake
 */
public class ModOrePlacements {
    public static final ResourceKey<PlacedFeature> ORE_GRAPHITE = createKey("ore_graphite");

    public static void bootstrap(BootstrapContext<PlacedFeature> pContext) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = pContext.lookup(Registries.CONFIGURED_FEATURE);

        // 添加到placed_feature中(HeightRangePlacement:生成的最低高度和最高的高度)
        // 石墨
        Holder<ConfiguredFeature<?, ?>> oreGraphiteHolder = holdergetter.getOrThrow(ModOreFeatures.ORE_GRAPHITE);
        PlacementUtils.register(
                pContext, ORE_GRAPHITE, oreGraphiteHolder, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(72)))
        );
    }


    /**
     * 矿石放置
     *
     * @param pCountPlacement 计数放置
     * @param pHeightRange 生成范围
     * @return 列表
     */
    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    /**
     * 常见矿物
     *
     * @param pCount 计数
     * @param pHeightRange 生成范围
     * @return 列表
     */
    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    /**
     * 稀有矿物
     *
     * @param pChance 机会
     * @param pHeightRange 生成范围
     * @return 列表
     */
    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }

    public static ResourceKey<PlacedFeature> createKey(String pKey) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, pKey));
    }
}
