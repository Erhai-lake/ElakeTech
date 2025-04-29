package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.register.block.custom.box.RockFlint;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTER;

/**
 * @author Qi-Month
 */
public class CommonBlock {
    /**
     * 注册
     */
    public static void registers() {
    }

    static {
        REGISTER.defaultCreativeTab(Objects.requireNonNull(ElakeTechCreativeModeTabs.COMMON_BLOCK_TAB.getKey()));
    }

    /**
     * 耐火砖块
     */
    public static final BlockEntry<Block> REFRACTORY_BRICKS = ElakeTech.REGISTER.block("refractory_bricks", Block::new)
            .simpleItem()
            .properties((properties) -> BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS))
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .register();

    /**
     * 燧石碎块
     */
    public static final BlockEntry<RockFlint> ROCK_FLINT = ElakeTech.REGISTER.block("rock_flint", RockFlint::new)
            .blockstate((c, p) -> p.getVariantBuilder(c.get())
                    .forAllStatesExcept((state) -> ConfiguredModel.builder()
                            .modelFile(p.models()
                                    .getExistingFile(ElakeTech.loadResource("block/rock_flint")))
                            .build()))
            .loot((t, b) -> t.add(b, LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(Items.FLINT)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                    )))
            .register();
}