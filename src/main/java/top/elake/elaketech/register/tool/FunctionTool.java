package top.elake.elaketech.register.tool;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
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
            .tab(ResourceKey.create(Registries.CREATIVE_MODE_TAB, ElakeTech.loadResource("test")))
            .properties((properties) -> properties
                    .durability(250)
                    .rarity(Rarity.RARE))
            .model((c, p) -> p.handheld(c, p.modLoc("item/tool/function/metal_detector")))
            .tag(Tags.Items.TOOLS)
            .register();


    public static void register() {
    }
}