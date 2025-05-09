package top.elake.elaketech.client.color;

import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import top.elake.elaketech.ElakeTech;

/**
 * @author Erhai-lake Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemColor {
    private static ItemColors ITEM_COLOR = null;

    @SubscribeEvent
    private static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        ITEM_COLOR = event.getItemColors();
    }

    /**
     * 注册物品颜色
     *
     * @param stack  物品
     * @param colors 图层索引, 颜色0xARGB
     */
    @SuppressWarnings("deprecation")
    private static void registerColorsForItem(ItemStack stack, Object... colors) {
        if (ITEM_COLOR == null) {
            throw new IllegalArgumentException("Initialization not completed");
        }
        int length = 2;
        if (colors.length % length != 0) {
            throw new IllegalArgumentException("Color parameters must occur in pairs: layer index, color value");
        }
        for (int i = 0; i < colors.length; i += length) {
            int tintIndex = (Integer) colors[i];
            int colorValue = (Integer) colors[i + 1];
            ITEM_COLOR.register((itemStack, tint) -> {
                if (tint == tintIndex) {
                    return colorValue;
                }
                return -1;
            }, stack.getItem());
        }
    }
}