package top.elake.elaketech.util.transform.client;

import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.*;

/**
 * @author Elake Studio
 */
public class AddTooltip {
    private static final Map<Item, List<Component>> TOOLTIP_MAP = new HashMap<>();

    public static <T extends Item, P> NonNullFunction<ItemBuilder<T, P>, ItemBuilder<T, P>> tooltip(Component tooltip) {
        return ((builder) -> {
            return builder.onRegister((item) -> {
                TOOLTIP_MAP.computeIfAbsent(item, (stack) -> {
                    return new ArrayList<>();
                }).add(tooltip);
            });
        });
    }

    public static List<Component> getTooltips(Item item) {
        return TOOLTIP_MAP.getOrDefault(item, Collections.emptyList());
    }
}