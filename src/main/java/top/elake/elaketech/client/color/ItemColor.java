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
        registerColorsForItem(Materials.BRONZE_INGOT.toStack(), 0, 0xffcd853f);
        // 锡锭
        registerColorsForItem(Materials.TIN_INGOT.toStack(), 0, 0xfff5f5f5);
    }

    /**
     * 注册物品颜色
     *
     * @param itemStack 物品
     * @param colors 颜色0*ARGB
     */
    private static void registerColorsForItem(ItemStack itemStack, Object... colors) {
        if (ITEM_COLOR == null) {
            throw new IllegalArgumentException("初始化未完成");
        }
        if (colors.length % 2 != 0) {
            throw new IllegalArgumentException("颜色参数必须成对出现:图层索引,颜色值");
        }
        for (int i = 0; i < colors.length; i += 2) {
            int tintIndex = (Integer) colors[i];
            int colorValue = (Integer) colors[i + 1];
            ITEM_COLOR.register((stack, tint) -> {
                if (tint == tintIndex) {
                    return colorValue;
                }
                return -1;
            }, itemStack.getItem());
        }
    }
}