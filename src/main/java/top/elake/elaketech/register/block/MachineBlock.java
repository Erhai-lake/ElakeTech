package top.elake.elaketech.register.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.register.block.custom.machine.BoilerBlock;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTER;

/**
 * @author Elake Studio
 */
public class MachineBlock {
    public static void registers() {
    }

    static {
        REGISTER.defaultCreativeTab(Objects.requireNonNull(ElakeTechCreativeModeTabs.FUNCTION_BLOCK_TAB.getKey()));
    }

    public static final BlockEntry<BoilerBlock> BOILER = REGISTER.block("boiler", BoilerBlock::new)
            .simpleItem()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate((c, p) -> {
                p.horizontalBlock(c.get(), (state) -> {
                    boolean on = state.getValue(BoilerBlock.ON);
                    return p.models().getExistingFile(ElakeTech.loadResource(on ? "block/machine/boiler/on" : "block/machine/boiler/off"));
                });
            })
            .register();
}