package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.register.block.custom.function.DryRackBlock;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTER;

/**
 * @author Elake Studio
 */
public class FunctionBlock {
    public static void registers() {
    }

    static {
        REGISTER.defaultCreativeTab(Objects.requireNonNull(ElakeTechCreativeModeTabs.FUNCTION_BLOCK_TAB.getKey()));
    }

    public static final BlockEntry<DryRackBlock> DRY_RACK = REGISTER.block("dry_rack", DryRackBlock::new)
            .simpleItem()
            .properties((p) -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).noOcclusion())
            .tag(BlockTags.MINEABLE_WITH_AXE)
            .blockstate((c, p) -> p.getVariantBuilder(c.get())
                    .forAllStatesExcept((state) -> ConfiguredModel.builder()
                            .modelFile(p.models().getExistingFile(ElakeTech.loadResource("block/function/dry_rack")))
                            .build()))
            .register();
}