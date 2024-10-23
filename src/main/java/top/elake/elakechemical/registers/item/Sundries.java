package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Qi-Month
 */
public class Sundries {
    /**
     * 已注册的元素
     */
    public static final List<DeferredItem<? extends Item>> REGISTERED_ELEMENTS = new ArrayList<>();

    /**
     * 获取已注册的元素物品列表
     *
     * @return 已注册的元素物品列表
     */
    public static List<DeferredItem<? extends Item>> getRegisteredElements() {
        return REGISTERED_ELEMENTS;
    }

    /**
     * Item
     */
    public static final DeferredRegister.Items ITEMS = DeferredRegister
            .createItems(ElakeChemical.MODID);
    /**
     * 注册杂草
     */
    public static final Supplier<Item> GRASS_FIBER = ITEMS.registerSimpleItem("grass_fiber", new Item.Properties());
    /**
     * 注册草绳
     */
    public static final Supplier<Item> GRASS_STRING = ITEMS.registerSimpleItem("grass_string", new Item.Properties());

    static {
        REGISTERED_ELEMENTS.add((DeferredItem<? extends Item>) GRASS_FIBER);
    }

    static {
        REGISTERED_ELEMENTS.add((DeferredItem<? extends Item>) GRASS_STRING);
    }

    /**
     * 注册
     *
     * @param eventBus 事件总线
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}