package top.elake.elakechemical.client.color;

import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.item.Sundries;

/**
 * @author Erhai-lake
 */
@EventBusSubscriber(modid = ElakeChemical.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemColor {
    private static ItemColors ITEMCOLOR = null;

    @SubscribeEvent
    private static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        ITEMCOLOR = event.getItemColors();

        registerColorsForItem(Sundries.TEST_INGOT.toStack(), 0, 0xff0000ff);
    }

    private static void registerColorsForItem(ItemStack itemStack, Object... colors) {
        if (ITEMCOLOR == null) {
            throw new IllegalArgumentException("初始化未完成");
        }
        if (colors.length % 2 != 0) {
            throw new IllegalArgumentException("颜色参数必须成对出现:图层索引,颜色值");
        }
        for (int i = 0; i < colors.length; i += 2) {
            int tintIndex = (Integer) colors[i];
            int colorValue = (Integer) colors[i + 1];
            ITEMCOLOR.register((stack, tint) -> {
                if (tint == tintIndex) {
                    return colorValue;
                }
                return -1;
            }, itemStack.getItem());
        }
    }
}