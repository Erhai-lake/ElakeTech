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

    public static final BlockEntry<Block> RAW_WOLFRAMITE_BLOCK = REGISTRATE.block("test_block", Block::new)
            .color(() -> () -> ElakeTech.RAW_WOLFRAMITE_BLOCK_COLOR)
            .register();
}