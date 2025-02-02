package top.elake.elaketech.datagen.data.worldgen.ore;

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
 * @author Erhai-lake Qi-Month
 */
public class ModOrePlacements {
    public static final ResourceKey<PlacedFeature> ORE_GRAPHITE = createKey("ore_graphite");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        // 添加到placed_feature中(HeightRangePlacement:生成的最低高度和最高的高度)
        // 石墨
        Holder<ConfiguredFeature<?, ?>> oreGraphiteHolder = holdergetter.getOrThrow(ModOreFeatures.ORE_GRAPHITE);
        PlacementUtils.register(
                context, ORE_GRAPHITE, oreGraphiteHolder, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(72)))
        );
    }

    /**
     * 矿石放置
     *
     * @param countPlacement 计数放置
     * @param heightRange    生成范围
     * @return 列表
     */
    private static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightRange) {
        return List.of(countPlacement, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    /**
     * 常见矿物
     *
     * @param count        计数
     * @param pHeightRange 生成范围
     * @return 列表
     */
    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(count), pHeightRange);
    }

    /**
     * 稀有矿物
     *
     * @param chance      机会
     * @param heightRange 生成范围
     * @return 列表
     */
    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), heightRange);
    }

    public static ResourceKey<PlacedFeature> createKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, key));
    }
}