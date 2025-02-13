package top.elake.elaketech.register.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredBlock;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.util.Registers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.world.level.block.Block.Properties;

/**
 * 矿石注册类
 *
 * @author Qi-Month
 */
public class Ore {
    public static final Map<String, DeferredBlock<Block>> ORE_MAP = new HashMap<>();
    public static final Map<String, DeferredBlock<Block>> DEEPSLATE_ORE_MAP = new HashMap<>();

    /**
     * 定义常量
     */
    public static final DeferredBlock<Block> TIN_ORE;
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE;
    public static final DeferredBlock<Block> GRAPHITE_ORE;
    public static final DeferredBlock<Block> DEEPSLATE_GRAPHITE_ORE;
    public static final DeferredBlock<Block> QUARTZ_ORE;
    public static final DeferredBlock<Block> DEEPSLATE_QUARTZ_ORE;

    private static final List<OreInfo> ORES = List.of(
            // 后两个参数属于可选, 如果不写默认就是下面所定义的默认矿石
            new OreInfo("tin"),
            new OreInfo("graphite"),
            new OreInfo("quartz", Blocks.NETHER_QUARTZ_ORE, Blocks.NETHER_QUARTZ_ORE)
    );

    static {
        for (OreInfo ore : ORES) {
            ORE_MAP.put(ore.name, registerShallowOreBlock(ore.name, ore.shallowBaseBlock));
            DEEPSLATE_ORE_MAP.put(ore.name, registerDeepslateOreBlock(ore.name, ore.deepslateBaseBlock));
        }

        TIN_ORE = ORE_MAP.get("tin");
        DEEPSLATE_TIN_ORE = DEEPSLATE_ORE_MAP.get("tin");
        GRAPHITE_ORE = ORE_MAP.get("graphite");
        DEEPSLATE_GRAPHITE_ORE = DEEPSLATE_ORE_MAP.get("graphite");
        QUARTZ_ORE = ORE_MAP.get("quartz");
        DEEPSLATE_QUARTZ_ORE = DEEPSLATE_ORE_MAP.get("quartz");
    }

    public static void register() {
        ORE_MAP.values().forEach(Ore::registerOreItem);
        DEEPSLATE_ORE_MAP.values().forEach(Ore::registerOreItem);
    }

    private static DeferredBlock<Block> registerShallowOreBlock(String name, Block baseBlock) {
        return Registers.registerBlock(getShallowOreName(name),
                () -> new Block(Properties.ofFullCopy(baseBlock))
        );
    }

    private static DeferredBlock<Block> registerDeepslateOreBlock(String name, Block baseBlock) {
        return Registers.registerBlock(getDeepslateOreName(name),
                () -> new Block(Properties.ofFullCopy(baseBlock != null ? baseBlock : Blocks.DEEPSLATE_IRON_ORE))
        );
    }

    private static void registerOreItem(DeferredBlock<Block> block) {
        String name = block.getId().getPath();
        ModCreativeModeTab.addAll(Registers.registerBlockItem(name, block, new Item.Properties()));
    }

    private static String getShallowOreName(String name) {
        return "%s_ore".formatted(name);
    }

    private static String getDeepslateOreName(String name) {
        return "deepslate_%s_ore".formatted(name);
    }

    private static class OreInfo {
        final String name;
        final Block shallowBaseBlock;
        final Block deepslateBaseBlock;

        OreInfo(String name) {
            this(name, Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE);
        }

        OreInfo(String name, Block shallowBaseBlock) {
            this(name, shallowBaseBlock, Blocks.DEEPSLATE_IRON_ORE);
        }

        OreInfo(String name, Block shallowBaseBlock, Block deepslateBaseBlock) {
            this.name = name;
            this.shallowBaseBlock = shallowBaseBlock;
            this.deepslateBaseBlock = deepslateBaseBlock != null ? deepslateBaseBlock : Blocks.DEEPSLATE_IRON_ORE;
        }
    }
}