package top.elake.elaketech.register.tool;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.custom.MetalDetector;

/**
 * @author Qi-Month
 */
public class FunctionTool {
    public static final ItemEntry<MetalDetector> METAL_DETECTOR = ElakeTech.REGISTER.item("metal_detector", MetalDetector::new)
            .lang("Metal Detector")
            .properties((properties) -> properties
                    .durability(250)
                    .rarity(Rarity.UNCOMMON))
            .model((c, p) -> p.generated(c, p.modLoc("item/tool/function/metal_detector")))
            .tag(Tags.Items.TOOLS)
            .register();


    public static void register() {
    }
}