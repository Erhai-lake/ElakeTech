package top.elake.elaketech.datagen.world.oregen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.registers.block.Org;

import java.util.List;

/**
 * @author Erhai-lake
 */
public class ModOreFeatures {
    /**
     * 石墨
     */
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GRAPHITE = createKey("graphite");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext) {
        // 替换规则
        // 石墨替换石头
        RuleTest stoneOreReplaceRuleGraphite = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        // 石墨替换深板岩
        RuleTest deepSlateOreReplaceRuleGraphite = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> list = List.of(
                OreConfiguration.target(stoneOreReplaceRuleGraphite, Org.GRAPHITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepSlateOreReplaceRuleGraphite, Org.DEEPSLATE_GRAPHITE_ORE.get().defaultBlockState())
        );

        // 创建规则(size:矿物的大小,取值为0到64的闭区间)
        // 创建石墨
        FeatureUtils.register(pContext, ORE_GRAPHITE, Feature.ORE, new OreConfiguration(list, 12));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, pName));
    }
}
