package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.OreItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

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

    public static BlockEntry<Block> TIN = registerColorOreBlock("tin", "Tin", 0xFFE1FFFF, BlockTags.NEEDS_STONE_TOOL, OreItem.TIN);
    public static BlockEntry<Block> DEEPSLATE_TIN = registerColorDeepslateOreBlock("tin", "Tin", 0xFFE1FFFF, BlockTags.NEEDS_STONE_TOOL, OreItem.TIN);
    public static BlockEntry<Block> GRAPHITE = registerOtherOreBlock("graphite", "Graphite", BlockTags.INCORRECT_FOR_STONE_TOOL, OreItem.GRAPHITE);
    public static BlockEntry<Block> DEEPSLATE_GRAPHITE = registerOtherDeepslateOreBlock("graphite", "Graphite", BlockTags.INCORRECT_FOR_STONE_TOOL, OreItem.GRAPHITE);
    public static BlockEntry<Block> QUARTZ = registerOtherOreBlockWithItem("quartz", "Quartz", BlockTags.INCORRECT_FOR_STONE_TOOL, Items.QUARTZ);
    public static BlockEntry<Block> DEEPSLATE_QUARTZ = registerOtherDeepslateOreBlockWithItem("quartz", "Quartz", BlockTags.INCORRECT_FOR_STONE_TOOL, Items.QUARTZ);

    /**
     * 浅层着色矿石
     *
     * @param id          金属ID
     * @param name        英文名
     * @param color       色号
     * @param miningLevel 挖掘等级
     * @param loot        战利品
     */
    public static BlockEntry<Block> registerColorOreBlock(String id, String name, int color, TagKey<Block> miningLevel, ItemEntry<Item> loot) {
        return ElakeTech.REGISTER.block(id + "_ore", Block::new)
                .item()
                .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                .tag(Tags.Items.ORES)
                .build()

                .lang(name + " Ore")
                .tag(Tags.Blocks.ORES)
                .tag(PICKAXE)
                .tag(miningLevel)
                .color(() -> () -> (state, world, pos, tintIndex) -> tintIndex == 0 ? color : -1)
                .initialProperties(() -> Blocks.IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .getExistingFile(ElakeTech.loadResource("block/ore/ore")))
                                .build()))
                .loot((l, b) -> {
                    HolderLookup.Provider provider = l.getRegistries();
                    Holder<Enchantment> fortune = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
                    Holder<Enchantment> silkTouch = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH);
                    l.add(b, LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .add(LootItem.lootTableItem(loot.get())
                                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))
                                            .apply(ApplyBonusCount.addOreBonusCount(fortune))
                                            .apply(ApplyBonusCount.addOreBonusCount(silkTouch))
                                    )));
                })
                .register();
    }

    /**
     * 深层着色矿石
     *
     * @param id          金属ID
     * @param name        英文名
     * @param color       色号
     * @param miningLevel 挖掘等级
     * @param loot        战利品
     */
    public static BlockEntry<Block> registerColorDeepslateOreBlock(String id, String name, int color, TagKey<Block> miningLevel, ItemEntry<Item> loot) {
        return ElakeTech.REGISTER.block("deepslate_" + id + "_ore", Block::new)
                .item()
                .color(() -> () -> (itemStack, tintIndex) -> tintIndex == 0 ? color : -1)
                .tag(Tags.Items.ORES)
                .build()

                .lang("Deepslate " + name + " Ore")
                .tag(Tags.Blocks.ORES)
                .tag(PICKAXE)
                .tag(miningLevel)
                .color(() -> () -> (state, world, pos, tintIndex) -> tintIndex == 0 ? color : -1)
                .initialProperties(() -> Blocks.DEEPSLATE_IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .getExistingFile(ElakeTech.loadResource("block/ore/deepslate")))
                                .build()))
                .loot((l, b) -> {
                    HolderLookup.Provider provider = l.getRegistries();
                    Holder<Enchantment> fortune = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
                    Holder<Enchantment> silkTouch = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH);
                    l.add(b, LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .add(LootItem.lootTableItem(loot.get())
                                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))
                                            .apply(ApplyBonusCount.addOreBonusCount(fortune))
                                            .apply(ApplyBonusCount.addOreBonusCount(silkTouch))
                                    )));
                })
                .register();
    }

    /**
     * 其他矿石
     *
     * @param id          金属ID
     * @param name        英文名
     * @param miningLevel 挖掘等级
     * @param loot        战利品
     */
    public static BlockEntry<Block> registerOtherOreBlock(String id, String name, TagKey<Block> miningLevel, ItemEntry<Item> loot) {
        return ElakeTech.REGISTER.block(id + "_ore", Block::new)
                .item()
                .tag(Tags.Items.ORES)
                .build()

                .lang(name + " Ore")
                .tag(Tags.Blocks.ORES)
                .tag(PICKAXE)
                .tag(miningLevel)
                .initialProperties(() -> Blocks.IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .cubeAll(id + "ore", p.modLoc("block/ore/" + id + "/ore"))
                                        .texture("0", "block/ore/" + id + "/ore"))
                                .build()))
                .loot((l, b) -> {
                    HolderLookup.Provider provider = l.getRegistries();
                    Holder<Enchantment> fortune = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
                    Holder<Enchantment> silkTouch = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH);
                    l.add(b, LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .add(LootItem.lootTableItem(loot.get())
                                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))
                                            .apply(ApplyBonusCount.addOreBonusCount(fortune))
                                            .apply(ApplyBonusCount.addOreBonusCount(silkTouch))
                                    )));
                })
                .register();
    }

    /**
     * 深层其它矿石
     *
     * @param id          金属ID
     * @param name        英文名
     * @param miningLevel 挖掘等级
     * @param loot        战利品
     */
    public static BlockEntry<Block> registerOtherDeepslateOreBlock(String id, String name, TagKey<Block> miningLevel, ItemEntry<Item> loot) {
        return ElakeTech.REGISTER.block("deepslate_" + id + "_ore", Block::new)
                .item()
                .tag(Tags.Items.ORES)
                .build()

                .lang("Deepslate " + name + " Ore")
                .tag(Tags.Blocks.ORES)
                .tag(PICKAXE)
                .tag(miningLevel)
                .initialProperties(() -> Blocks.DEEPSLATE_IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .cubeAll("deepslate_" + id + "_ore", p.modLoc("block/ore/" + id + "/deepslate"))
                                        .texture("0", "block/ore/" + id + "/deepslate"))
                                .build()))
                .loot((l, b) -> {
                    HolderLookup.Provider provider = l.getRegistries();
                    Holder<Enchantment> fortune = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
                    Holder<Enchantment> silkTouch = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH);
                    l.add(b, LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .add(LootItem.lootTableItem(loot.get())
                                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))
                                            .apply(ApplyBonusCount.addOreBonusCount(fortune))
                                            .apply(ApplyBonusCount.addOreBonusCount(silkTouch))
                                    )));
                })
                .register();
    }

    public static BlockEntry<Block> registerOtherOreBlockWithItem(String id, String name, TagKey<Block> miningLevel, Item loot) {
        return ElakeTech.REGISTER.block(id + "_ore", Block::new)
                .item()
                .tag(Tags.Items.ORES)
                .build()

                .lang(name + " Ore")
                .tag(Tags.Blocks.ORES)
                .tag(PICKAXE)
                .tag(miningLevel)
                .initialProperties(() -> Blocks.IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .cubeAll(id + "ore", p.modLoc("block/ore/" + id + "/ore"))
                                        .texture("0", "block/ore/" + id + "/ore"))
                                .build()))
                .loot((l, b) -> {
                    HolderLookup.Provider provider = l.getRegistries();
                    Holder<Enchantment> fortune = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
                    Holder<Enchantment> silkTouch = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH);
                    l.add(b, LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .add(LootItem.lootTableItem(loot)
                                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))
                                            .apply(ApplyBonusCount.addOreBonusCount(fortune))
                                            .apply(ApplyBonusCount.addOreBonusCount(silkTouch))
                                    )));
                })
                .register();
    }

    public static BlockEntry<Block> registerOtherDeepslateOreBlockWithItem(String id, String name, TagKey<Block> miningLevel, Item loot) {
        return ElakeTech.REGISTER.block("deepslate_" + id + "_ore", Block::new)
                .item()
                .tag(Tags.Items.ORES)
                .build()

                .lang("Deepslate " + name + " Ore")
                .tag(Tags.Blocks.ORES)
                .tag(PICKAXE)
                .tag(miningLevel)
                .initialProperties(() -> Blocks.DEEPSLATE_IRON_ORE)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStatesExcept((state) -> ConfiguredModel.builder()
                                .modelFile(p.models()
                                        .cubeAll("deepslate_" + id + "_ore", p.modLoc("block/ore/" + id + "/deepslate"))
                                        .texture("0", "block/ore/" + id + "/deepslate"))
                                .build()))
                .loot((l, b) -> {
                    HolderLookup.Provider provider = l.getRegistries();
                    Holder<Enchantment> fortune = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
                    Holder<Enchantment> silkTouch = provider.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH);
                    l.add(b, LootTable.lootTable()
                            .withPool(LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1))
                                    .add(LootItem.lootTableItem(loot)
                                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))
                                            .apply(ApplyBonusCount.addOreBonusCount(fortune))
                                            .apply(ApplyBonusCount.addOreBonusCount(silkTouch))
                                    )));
                })
                .register();
    }

    public static void register() {
    }
}