package top.elake.elaketech.client.color;

import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.registers.item.Materials;

/**
 * @author Erhai-lake Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemColor {
    private static ItemColors ITEM_COLOR = null;

    @SubscribeEvent
    private static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        ITEM_COLOR = event.getItemColors();
        // 青铜锭
        registerColorsForItem(Materials.BRONZE_INGOT.toStack(), 0, 0xffd2691e);
        // 锡锭
        registerColorsForItem(Materials.TIN_INGOT.toStack(), 0, 0xfff5f5f5);
    }

    /**
     * 注册物品颜色
     *
     * @param stack 物品
     * @param colors 颜色0*ARGB
     */
    private static void registerColorsForItem(ItemStack stack, Object... colors) {
        if (ITEM_COLOR == null) {
            throw new IllegalArgumentException("Initialization not completed");
        }
        if (colors.length % 2 != 0) {
            throw new IllegalArgumentException("Color parameters must occur in pairs: layer index, color value");
        }
        for (int i = 0; i < colors.length; i += 2) {
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