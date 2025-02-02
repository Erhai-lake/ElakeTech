package top.elake.elaketech.client.color;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import top.elake.elaketech.ElakeTech;

/**
 * @author Erhai-lake
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockColor {
    private static BlockColors Block_COLOR = null;

    @SubscribeEvent
    private static void registerBlockColor(RegisterColorHandlersEvent.Block event) {
        Block_COLOR = event.getBlockColors();
    }

    /**
     * 注册方块颜色
     *
     * @param stack  物品
     * @param colors 图层索引, 颜色0*ARGB
     */
    @SuppressWarnings("deprecation")
    private static void registerColorsForItem(ItemStack stack, Object... colors) {
        if (Block_COLOR == null) {
            throw new IllegalArgumentException("Initialization not completed");
        }
        int length = 2;
        if (colors.length % length != 0) {
            throw new IllegalArgumentException("Color parameters must occur in pairs: layer index, color value");
        }
        for (int i = 0; i < colors.length; i += length) {
            int tintIndex = (Integer) colors[i];
            int colorValue = (Integer) colors[i + 1];
            Block_COLOR.register((blockState, level, blockPos, tint)-> {
                if (tint == tintIndex) {
                    return colorValue;
                }
                return -1;
            });
        }
    }
}