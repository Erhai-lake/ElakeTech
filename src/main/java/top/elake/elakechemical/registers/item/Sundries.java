package top.elake.elakechemical.registers.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.ModCreativeModeTab;

import java.util.function.Supplier;

/**
 * @author Qi-Month
 */
public class Sundries {
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
        ModCreativeModeTab.addSubItems((DeferredItem<? extends Item>) GRASS_FIBER);
        ModCreativeModeTab.addSubItems((DeferredItem<? extends Item>) GRASS_STRING);
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