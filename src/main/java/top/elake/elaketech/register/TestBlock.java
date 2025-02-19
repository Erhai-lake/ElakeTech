package top.elake.elaketech.register;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;

import static top.elake.elaketech.ElakeTech.REGISTRATE;

/**
 * @author Qi-Month
 */
public class TestBlock {
    public static void register() {
    }

    public static final BlockEntry<Block> TEST_BLOCK = REGISTRATE.block("test_block", Block::new)
            .blockstate((c, p) -> p.getVariantBuilder(c.get())
                    .forAllStatesExcept((state) -> ConfiguredModel.builder()
                            .modelFile(p.models()
                                    .withExistingParent("cube_all", p.modLoc("test_block"))
                                    .texture("0", p.modLoc("metal/block")))
                            .build()))
            .simpleItem()
            .color(() -> () -> (state, world, pos, tintIndex) -> 0xFFFF7C00)
            .register();
}