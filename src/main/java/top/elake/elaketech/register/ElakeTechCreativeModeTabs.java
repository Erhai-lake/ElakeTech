package top.elake.elaketech.register;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.register.item.materials.Materials;

import java.util.function.Supplier;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author Elake Studio
 */
public class ElakeTechCreativeModeTabs {
    /**
     * 注册创造模式物品栏
     *
     * @param event 事件总线
     */
    public static void register(IEventBus event) {
        TABS.register(event);
    }

    /**
     * 创造模式物品栏注册
     */
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    /**
     * 材料物品栏
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MATERIALS_TAB = addCreativeModeTab("materials", () -> Materials.GRASS_FIBER);

    /**
     * 工具物品栏
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOOLS_TAB = addCreativeModeTab("tools", () -> Materials.GRASS_STRING);

    /**
     * 创造模式物品栏注册
     */
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> addCreativeModeTab(String name, Supplier<ItemEntry<? extends Item>> displayIcon) {
        return TABS.register(name + "_tab", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(displayIcon.get().asItem()))
                .title(Component.translatable("itemGroup.%s.%s_tab".formatted(MODID, name)))
                .build());
    }
}