package top.elake.elaketech.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.register.item.materials.Materials;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author ElakeStudio
 */
public class ElakeTechCreativeModeTabs {
    /**
     * 注册创造模式物品栏
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
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MATERIALS_TAB = TABS.register("materials",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Materials.GRASS_FIBER.get()))
                    .title(Component.translatable("itemGroup." + MODID + ".materials_tab"))
                    .build()
    );

    /**
     * 工具物品栏
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOOLS_TAB = TABS.register("tools",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Materials.GRASS_FIBER.get()))
                    .title(Component.translatable("itemGroup." + MODID + ".tools_tab"))
                    .build()
    );
}