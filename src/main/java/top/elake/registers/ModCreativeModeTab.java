package top.elake.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.registers.item.Elements;

import java.util.function.Supplier;

import static top.elake.ElakeChemical.MODID;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final Supplier<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("element_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MODID + ".element_tab"))
            .icon(() -> new ItemStack((ItemLike) Elements.getRegisteredElements().get(0)))
            .displayItems((params, output) -> {
                for (DeferredItem<Item> item : Elements.getRegisteredElements()) {
                    output.accept(item);
                }
            }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}