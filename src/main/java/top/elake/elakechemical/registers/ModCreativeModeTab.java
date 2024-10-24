package top.elake.elakechemical.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class ModCreativeModeTab {
    /**
     * 全部
     */
    private static final List<DeferredItem<? extends Item>> REGISTERED_ALL = new ArrayList<>();
    /**
     * 元素
     */
    private static final List<DeferredItem<? extends Item>> REGISTERED_ELEMENTS = new ArrayList<>();
    /**
     * 工具
     */
    private static final List<DeferredItem<? extends Item>> REGISTERED_TOOLS = new ArrayList<>();
    /**
     * 杂项
     */
    private static final List<DeferredItem<? extends Item>> REGISTERED_SUNDRIES = new ArrayList<>();
    /**
     * 创造模式物品栏注册
     */
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, ElakeChemical.MODID);
    /**
     * 全部物品创造模式标签页
     */
    private static final Supplier<CreativeModeTab> ALL = CREATIVE_MODE_TABS.register("all",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + ElakeChemical.MODID + ".all"))
                    .icon(() -> new ItemStack(REGISTERED_ALL.get(0).asItem()))
                    .displayItems((params, output) -> REGISTERED_ALL.forEach(output::accept))
                    .build()
    );
    /**
     * 元素创造模式标签页
     */
    private static final Supplier<CreativeModeTab> ELEMENT = CREATIVE_MODE_TABS.register("element",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + ElakeChemical.MODID + ".element"))
                    .icon(() -> new ItemStack(REGISTERED_ELEMENTS.get(0).asItem()))
                    .displayItems((params, output) -> REGISTERED_ELEMENTS.forEach(output::accept))
                    .build()
    );
    /**
     * 工具创造模式标签页
     */
    private static final Supplier<CreativeModeTab> TOOL = CREATIVE_MODE_TABS.register("tool",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + ElakeChemical.MODID + ".tool"))
                    .icon(() -> new ItemStack(REGISTERED_TOOLS.get(0).asItem()))
                    .displayItems((params, output) -> REGISTERED_TOOLS.forEach(output::accept))
                    .build()
    );
    /**
     * 杂物创造模式标签页
     */
    private static final Supplier<CreativeModeTab> SUNDRIES = CREATIVE_MODE_TABS.register("sundries",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + ElakeChemical.MODID + ".sundries"))
                    .icon(() -> new ItemStack(REGISTERED_SUNDRIES.get(0).asItem()))
                    .displayItems((params, output) -> REGISTERED_SUNDRIES.forEach(output::accept))
                    .build()
    );

    /**
     * 添加全部
     *
     * @param item 物品
     */

    public static void addAll(DeferredItem<? extends Item> item) {
        REGISTERED_ALL.add(item);
    }

    /**
     * 添加元素
     *
     * @param item 物品
     */

    public static void addElement(DeferredItem<? extends Item> item) {
        REGISTERED_ELEMENTS.add(item);
        addAll(item);
    }

    /**
     * 添加工具
     *
     * @param item 物品
     */

    public static void addTools(DeferredItem<? extends Item> item) {
        REGISTERED_TOOLS.add(item);
        addAll(item);
    }

    /**
     * 添加杂项
     *
     * @param item 物品
     */
    public static void addSubItems(DeferredItem<? extends Item> item) {
        REGISTERED_SUNDRIES.add(item);
        addAll(item);
    }

    /**
     * 注册
     *
     * @param eventBus 事件总线
     */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
