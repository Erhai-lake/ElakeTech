package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import top.elake.elaketech.ElakeTech;

import static top.elake.elaketech.ElakeTech.*;

/**
 * 矿石注册
 *
 * @author Qi-Month
 * @Tin 锡
 * @Graphite 石墨
 * @Quartz 石英
 */
public class OreBlock {
    static TagKey<Block> PICKAXE = BlockTags.MINEABLE_WITH_PICKAXE;

    public static BlockEntry<Block> TIN = registerColorOreBlock("tin", 0xFFE1FFFF, BlockTags.NEEDS_STONE_TOOL);
    public static BlockEntry<Block> DEEPSLATE_TIN = registerColorDeepslateOreBlock("tin", 0xFFE1FFFF, BlockTags.NEEDS_STONE_TOOL);
    public static BlockEntry<Block> GRAPHITE = registerOtherOreBlock("graphite", BlockTags.INCORRECT_FOR_STONE_TOOL);
    public static BlockEntry<Block> DEEPSLATE_GRAPHITE = registerOtherDeepslateOreBlock("graphite", BlockTags.INCORRECT_FOR_STONE_TOOL);
    public static BlockEntry<Block> QUARTZ = registerOtherOreBlock("quartz", BlockTags.INCORRECT_FOR_STONE_TOOL);
    public static BlockEntry<Block> DEEPSLATE_QUARTZ = registerOtherDeepslateOreBlock("quartz", BlockTags.INCORRECT_FOR_STONE_TOOL);

    /**
     * 浅层颜色矿石
     *
     * @param name
     * @param color
     * @param miningLevel
     * @return
     */
    public static BlockEntry<Block> registerColorOreBlock(String name, int color, TagKey<Block> miningLevel) {
        BlockEntry<Block> blockEntry = REGISTER.block(name + "_ore", Block::new)
                .simpleItem()
                .tag(PICKAXE)
                .tag(miningLevel)
                .color(() -> () -> (state, world, pos, tintIndex) -> tintIndex == 0 ? color : -1)
                .initialProperties(() -> Blocks.IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .getExistingFile(ElakeTech.loadResourceFile("block/ore/ore")))
                                .build()))
                .register();
        return blockEntry;
    }

    /**
     * 深层颜色矿石
     *
     * @param name
     * @param color
     * @param miningLevel
     * @return
     */
    public static BlockEntry<Block> registerColorDeepslateOreBlock(String name, int color, TagKey<Block> miningLevel) {
        BlockEntry<Block> blockEntry = REGISTER.block("deepslate_" + name + "_ore", Block::new)
                .simpleItem()
                .tag(PICKAXE)
                .tag(miningLevel)
                .color(() -> () -> (state, world, pos, tintIndex) -> tintIndex == 0 ? color : -1)
                .initialProperties(() -> Blocks.DEEPSLATE_IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .getExistingFile(ElakeTech.loadResourceFile("block/ore/deepslate")))
                                .build()))
                .register();
        return blockEntry;
    }

    /**
     * 其他矿石
     *
     * @param name
     * @param miningLevel
     * @return
     */
    public static BlockEntry<Block> registerOtherOreBlock(String name, TagKey<Block> miningLevel) {
        BlockEntry<Block> blockEntry = REGISTER.block(name + "_ore", Block::new)
                .simpleItem()
                .tag(PICKAXE)
                .tag(miningLevel)
                .initialProperties(() -> Blocks.IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .cubeAll(name + "ore", p.modLoc("block/ore/" + name + "/ore"))
                                        .texture("0", "block/ore/" + name + "/ore")
                                ).build()))
                .register();
        return blockEntry;
    }

    /**
     * 深层其它矿石
     *
     * @param name
     * @param miningLevel
     * @return
     */
    public static BlockEntry<Block> registerOtherDeepslateOreBlock(String name, TagKey<Block> miningLevel) {
        BlockEntry<Block> blockEntry = REGISTER.block("deepslate_" + name + "_ore", Block::new)
                .simpleItem()
                .tag(PICKAXE)
                .tag(miningLevel)
                .initialProperties(() -> Blocks.DEEPSLATE_IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .cubeAll("deepslate_" + name + "_ore", p.modLoc("block/ore/" + name + "/deepslate"))
                                        .texture("0", "block/ore/" + name + "/deepslate")
                                ).build()))
                .register();
        return blockEntry;
    }

    public static void register() {
    }
}