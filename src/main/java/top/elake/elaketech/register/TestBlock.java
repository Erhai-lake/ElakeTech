package top.elake.elaketech.register;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import top.elake.elaketech.ElakeTech;

/**
 * @author Qi-Month
 */
public class TestBlock {
    public static final Registrate REGISTRATE = Registrate.create(ElakeTech.MODID);

    public static void register() {
    }

    public static final BlockEntry<Block> TEST_BLOCK = REGISTRATE.block("test_block", Block::new)
            .blockstate(((ctx, prov) -> {
                prov.blockTexture()
                prov.simpleBlock(ctx.getEntry());
            }))
            .simpleItem()
            .color(() -> () -> (state, world, pos, tintIndex) -> 0xFF808080)
            .register();
}