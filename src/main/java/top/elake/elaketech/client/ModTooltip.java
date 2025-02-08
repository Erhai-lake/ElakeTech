package top.elake.elaketech.client;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import top.elake.elaketech.register.item.Materials;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author Qi-Month
 */
public class ModTooltip {
    public static final Map<Supplier<Item>, String> TOOLTIP_MAP = new HashMap<>();

    public static void register(IEventBus event) {
        event.register(ModTooltip.class);
        initTooltips();
    }

    public static void initTooltips() {
        addTooltip(Materials.GRASS_FIBER, "tooltip.elake_tech.grass_fiber");
    }

    /**
     * @param item 物品
     * @param key  本地化键
     */
    public static void addTooltip(Supplier<Item> item, String key) {
        TOOLTIP_MAP.put(item, key);
    }

    /**
     * Tooltip 事件
     *
     * @param event 事件
     */
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        addTooltipToItem(event.getItemStack(), event);
    }

    /**
     * @param itme item
     * @param event Tooltip 事件
     */
    public static void addTooltipToItem(ItemStack itme, ItemTooltipEvent event) {
        Item item = itme.getItem();
        for (Map.Entry<Supplier<Item>, String> entry : TOOLTIP_MAP.entrySet()) {
            if (entry.getKey().get() == item) {
                event.getToolTip().add(Component.translatable(entry.getValue()));
            }
        }
    }
}