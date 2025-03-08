package top.elake.elaketech.register.tool;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.custom.function.MetalDetector;
import top.elake.elaketech.register.item.custom.function.MetalDetectorT2;
import top.elake.elaketech.register.item.custom.function.MetalDetectorT3;
import top.elake.elaketech.register.tool.tier.Flint;

/**
 * @author Qi-Month
 */
public class FunctionTool {
    static {
        ElakeTech.REGISTER.defaultCreativeTab("tool", (c) -> {
            c.icon(() -> new ItemStack(Flint.FLINT_PICKAXE.asItem()));
        }).register();
    }

    /**
     * 一级探测器 - 只显示粒子
     */
    public static final ItemEntry<MetalDetector> METAL_DETECTOR = ElakeTech.REGISTER.item("metal_detector", MetalDetector::new)
            .lang("Basic Metal Detector")
            .properties((properties) -> properties
                    .durability(256)
                    .rarity(Rarity.COMMON))
            .model((c, p) -> p.handheld(c, p.modLoc("item/tool/function/metal_detector")))
            .tag(Tags.Items.TOOLS)
            .register();

    /**
     * 二级探测器 - 显示矿物名称
     */
    public static final ItemEntry<MetalDetectorT2> METAL_DETECTOR_T2 = ElakeTech.REGISTER.item("metal_detector_t2", MetalDetectorT2::new)
            .lang("Advanced Metal Detector")
            .properties((properties) -> properties
                    .durability(512)
                    .rarity(Rarity.RARE))
            .model((c, p) -> p.handheld(c, p.modLoc("item/tool/function/metal_detector_t2")))
            .tag(Tags.Items.TOOLS)
            .register();

    /**
     * 三级探测器 - 显示矿物名称和坐标
     */
    public static final ItemEntry<MetalDetectorT3> METAL_DETECTOR_T3 = ElakeTech.REGISTER.item("metal_detector_t3", MetalDetectorT3::new)
            .lang("Elite Metal Detector")
            .properties((properties) -> properties
                    .durability(1024)
                    .rarity(Rarity.UNCOMMON))
            .model((c, p) -> p.handheld(c, p.modLoc("item/tool/function/metal_detector_t3")))
            .tag(Tags.Items.TOOLS)
            .register();

    public static void register() {
    }
}