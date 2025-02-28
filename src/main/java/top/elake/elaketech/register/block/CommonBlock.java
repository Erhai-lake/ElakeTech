package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.item.Item;
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
import net.neoforged.neoforge.registries.DeferredBlock;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.register.block.custom.box.RockFlint;
import top.elake.elaketech.util.Registers;

/**
 * @author Qi-Month
 */
public class CommonBlock {
    /**
     * 白云岩
     */
    public static final BlockEntry<Block> DOLOSTONE = ElakeTech.REGISTER.block("dolostone", Block::new)
            .properties((properties) -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
            .register();
    /**
     * 高岭土
     */
    public static final BlockEntry<Block> KAOLIN = ElakeTech.REGISTER.block("kaolin", Block::new)
            .properties((properties) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY))
            .register();
    /**
     * 耐火砖块
     */
    public static final BlockEntry<Block> REFRACTORY_BRICKS = ElakeTech.REGISTER.block("refractory_bricks", Block::new)
            .properties((properties) -> BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS))
            .register();

    public static final BlockEntry<RockFlint> ROCK_FLINT = ElakeTech.REGISTER.block("rock_flint", RockFlint::new)
            .lang("Rock Flint")
            .blockstate((c, p) -> p.getVariantBuilder(c.get())
                    .forAllStatesExcept((state) -> ConfiguredModel.builder()
                            .modelFile(p.models()
                                    .getExistingFile(ElakeTech.loadResource("block/rock_flint")))
                            .build()))
            .loot((tb, block) -> tb.add(block, LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(Items.FLINT)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                    )))
            .register();

    /**
     * 注册
     */
    public static void registers() {
    }
}