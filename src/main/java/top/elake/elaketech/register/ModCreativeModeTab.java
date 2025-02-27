package top.elake.elaketech.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.ElakeTech;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class ModCreativeModeTab {
    public static final String IG = "itemGroup.";

    /**
     * 全部
     */
    public static final List<DeferredItem<? extends Item>> REGISTERED_ALL = new ArrayList<>();
    /**
     * 元素
     */
    public static final List<DeferredItem<? extends Item>> REGISTERED_ELEMENTS = new ArrayList<>();
    /**
     * 工具
     */
    public static final List<DeferredItem<? extends Item>> REGISTERED_TOOLS = new ArrayList<>();
    /**
     * 杂项
     */
    public static final List<DeferredItem<? extends Item>> REGISTERED_SUNDRIES = new ArrayList<>();
    /**
     * 材料
     */
    public static final List<DeferredItem<? extends Item>> REGISTERED_MATERIALS = new ArrayList<>();
    /**
     * 化学用具
     */
    public static final List<DeferredItem<? extends Item>> REGISTERED_CHEMICAL_APPLIANCES = new ArrayList<>();
    /**
     * 创造模式物品栏注册
     */
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, ElakeTech.MODID);
    /**
     * 全部物品创造模式标签页
     */
    public static final Supplier<CreativeModeTab> ALL = CREATIVE_MODE_TABS.register("all",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(IG + ElakeTech.MODID + ".all"))
                    .icon(() -> new ItemStack(REGISTERED_ALL.get(0).asItem()))
                    .displayItems((params, output) -> REGISTERED_ALL.forEach(output::accept))
                    .build()
    );
    /**
     * 元素创造模式标签页
     */
    private static final Supplier<CreativeModeTab> ELEMENT = CREATIVE_MODE_TABS.register("element",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(IG + ElakeTech.MODID + ".element"))
                    .icon(() -> new ItemStack(REGISTERED_ELEMENTS.get(0).asItem()))
                    .displayItems((params, output) -> REGISTERED_ELEMENTS.forEach(output::accept))
                    .build()
    );
    /**
     * 工具创造模式标签页
     */
    private static final Supplier<CreativeModeTab> TOOL = CREATIVE_MODE_TABS.register("tool",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(IG + ElakeTech.MODID + ".tool"))
                    .icon(() -> new ItemStack(REGISTERED_TOOLS.get(0).asItem()))
                    .displayItems((params, output) -> REGISTERED_TOOLS.forEach(output::accept))
                    .build()
    );

    private static final Supplier<CreativeModeTab> TEST = CREATIVE_MODE_TABS.register("test",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(IG + ElakeTech.MODID + ".test"))
                    .icon(() -> new ItemStack(REGISTERED_TOOLS.get(0).asItem()))
                    .build()
    );
    /**
     * 材料创造模式标签页
     */
    private static final Supplier<CreativeModeTab> MATERIALS = CREATIVE_MODE_TABS.register("materials",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(IG + ElakeTech.MODID + ".sundries"))
                    .icon(() -> new ItemStack(REGISTERED_MATERIALS.get(0).asItem()))
                    .displayItems((params, output) -> REGISTERED_MATERIALS.forEach(output::accept))
                    .build()
    );
    /**
     * 化学用具创造模式标签页
     */
    private static final Supplier<CreativeModeTab> CHEMICAL_APPLIANCES = CREATIVE_MODE_TABS.register("chemical_appliances",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(IG + ElakeTech.MODID + ".chemical_appliances"))
                    .icon(() -> new ItemStack(REGISTERED_CHEMICAL_APPLIANCES.get(0).asItem()))
                    .displayItems((params, output) -> REGISTERED_CHEMICAL_APPLIANCES.forEach(output::accept))
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
     * 添加材料
     *
     * @param item 物品
     */
    public static void addMaterials(DeferredItem<? extends Item> item) {
        REGISTERED_MATERIALS.add(item);
        addAll(item);
    }

    /**
     * 添加化学用具
     *
     * @param item 物品
     */
    public static void addChemicalAppliances(DeferredItem<? extends Item> item) {
        REGISTERED_CHEMICAL_APPLIANCES.add(item);
        addAll(item);
    }

    /**
     * 注册
     *
     * @param event 事件总线
     */
    public static void register(IEventBus event) {
        CREATIVE_MODE_TABS.register(event);
    }
}