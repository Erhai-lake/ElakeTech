package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;

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

    public static BlockEntry<Block> TIN = registerColorOreBlock("tin", "Tin", 0xFFE1FFFF, BlockTags.NEEDS_STONE_TOOL);
    public static BlockEntry<Block> DEEPSLATE_TIN = registerColorDeepslateOreBlock("tin", "Tin", 0xFFE1FFFF, BlockTags.NEEDS_STONE_TOOL);
    public static BlockEntry<Block> GRAPHITE = registerOtherOreBlock("graphite", "Graphite", BlockTags.INCORRECT_FOR_STONE_TOOL);
    public static BlockEntry<Block> DEEPSLATE_GRAPHITE = registerOtherDeepslateOreBlock("graphite", "Graphite", BlockTags.INCORRECT_FOR_STONE_TOOL);
    public static BlockEntry<Block> QUARTZ = registerOtherOreBlock("quartz", "Quartz", BlockTags.INCORRECT_FOR_STONE_TOOL);
    public static BlockEntry<Block> DEEPSLATE_QUARTZ = registerOtherDeepslateOreBlock("quartz", "Quartz", BlockTags.INCORRECT_FOR_STONE_TOOL);


    /**
     * 浅层着色矿石
     *
     * @param id          金属ID
     * @param name        英文名
     * @param color       色号
     * @param miningLevel 挖掘等级
     */
    public static BlockEntry<Block> registerColorOreBlock(String id, String name, int color, TagKey<Block> miningLevel) {
        return ElakeTech.REGISTER.block(id + "_ore", Block::new)
                .item()
                .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                .tag(Tags.Items.ORES)
                .build()

                .tag(Tags.Blocks.ORES)
                .tag(PICKAXE)
                .tag(miningLevel)
                .color(() -> () -> (state, world, pos, tintIndex) -> tintIndex == 0 ? color : -1)
                .initialProperties(() -> Blocks.IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .getExistingFile(ElakeTech.loadResourceFile("block/ore/ore")))
                                .build()))
                .lang(name + " Ore")
                .register();
    }

    /**
     * 深层着色矿石
     *
     * @param id          金属ID
     * @param name        英文名
     * @param color       色号
     * @param miningLevel 挖掘等级
     */
    public static BlockEntry<Block> registerColorDeepslateOreBlock(String id, String name, int color, TagKey<Block> miningLevel) {
        return ElakeTech.REGISTER.block("deepslate_" + id + "_ore", Block::new)
                .item()
                .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                .tag(Tags.Items.ORES)
                .build()

                .tag(Tags.Blocks.ORES)
                .tag(PICKAXE)
                .tag(miningLevel)
                .color(() -> () -> (state, world, pos, tintIndex) -> tintIndex == 0 ? color : -1)
                .initialProperties(() -> Blocks.DEEPSLATE_IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .getExistingFile(ElakeTech.loadResourceFile("block/ore/deepslate")))
                                .build()))
                .lang("Deepslate " + name + " Ore")
                .register();
    }

    /**
     * 其他矿石
     *
     * @param id          金属ID
     * @param name        英文名
     * @param miningLevel 挖掘等级
     */
    public static BlockEntry<Block> registerOtherOreBlock(String id, String name, TagKey<Block> miningLevel) {
        return ElakeTech.REGISTER.block(id + "_ore", Block::new)
                .item()
                .tag(Tags.Items.ORES)
                .build()

                .tag(Tags.Blocks.ORES)
                .tag(PICKAXE)
                .tag(miningLevel)
                .initialProperties(() -> Blocks.IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .cubeAll(id + "ore", p.modLoc("block/ore/" + id + "/ore"))
                                        .texture("0", "block/ore/" + id + "/ore")
                                ).build()))
                .lang(name + " Ore")
                .register();
    }

    /**
     * 深层其它矿石
     *
     * @param id          金属ID
     * @param name        英文名
     * @param miningLevel 挖掘等级
     */
    public static BlockEntry<Block> registerOtherDeepslateOreBlock(String id, String name, TagKey<Block> miningLevel) {
        return ElakeTech.REGISTER.block("deepslate_" + id + "_ore", Block::new)
                .item()
                .tag(Tags.Items.ORES)
                .build()

                .tag(Tags.Blocks.ORES)
                .tag(PICKAXE)
                .tag(miningLevel)
                .initialProperties(() -> Blocks.DEEPSLATE_IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .cubeAll("deepslate_" + id + "_ore", p.modLoc("block/ore/" + id + "/deepslate"))
                                        .texture("0", "block/ore/" + id + "/deepslate")
                                ).build()))
                .lang("Deepslate " + name + " Ore")
                .register();
    }

    public static void register() {
    }
}