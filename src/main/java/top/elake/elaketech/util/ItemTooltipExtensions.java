package top.elake.elaketech.util;

import com.tterrag.registrate.builders.ItemBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.*;

/**
 * @author Elake Studio
 */
public class ItemTooltipExtensions {
    private static final Map<Item, List<Component>> TOOLTIP_MAP = new HashMap<>();

    public static <T extends Item, P> ItemBuilder<T, P> tooltip(ItemBuilder<T, P> builder, Component tooltip) {
        builder.onRegister((item) -> {
            TOOLTIP_MAP.computeIfAbsent(item, (k) -> new ArrayList<>()).add(tooltip);
        });
        return builder;
    }

    public static List<Component> getTooltips(Item item) {
        return TOOLTIP_MAP.getOrDefault(item, Collections.emptyList());
    }
}