package top.elake.elakechemical.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.block.ModBlock;
import top.elake.elakechemical.registers.item.Elements;
import top.elake.elakechemical.registers.item.Sundries;
import top.elake.elakechemical.registers.tool.Flint;

import java.util.function.Supplier;

/**
 * 创造模式物品栏
 *
 * @author Erhai-lake
 */
public class ModCreativeModeTab {
    /**
     * 创造模式物品栏注册
     */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, ElakeChemical.MODID);
    /**
     * 全部物品创造模式标签页
     */
    public static final Supplier<CreativeModeTab> ALL = CREATIVE_MODE_TABS.register("all",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + ElakeChemical.MODID + ".all"))
                    .icon(() -> new ItemStack((ItemLike) Elements.getRegisteredElements().get(0)))
                    .displayItems((params, output) -> {
                        output.accept(ModBlock.TEST_BLOCK.get());
                        output.accept(ModBlock.TEST_BLOCK_ENTITY.get());
                        // 元素
                        for (DeferredItem<? extends Item> item : Elements.getRegisteredElements()) {
                            output.accept(item);
                        }
                        // 燧石工具
                        for (DeferredItem<? extends Item> item : Flint.getRegisteredElements()) {
                            output.accept(item);
                        }
                        // 杂物
                        for (DeferredItem<? extends Item> item : Sundries.getRegisteredElements()) {
                            output.accept(item);
                        }
                    }).build()
    );
    /**
     * 元素创造模式标签页
     */
    public static final Supplier<CreativeModeTab> ELEMENT = CREATIVE_MODE_TABS.register("element",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + ElakeChemical.MODID + ".element"))
                    .icon(() -> new ItemStack((ItemLike) Elements.getRegisteredElements().get(0)))
                    .displayItems((params, output) -> {
                        for (DeferredItem<? extends Item> item : Elements.getRegisteredElements()) {
                            output.accept(item);
                        }
                    }).build()
    );

    /**
     * 工具创造模式标签页
     */
    public static final Supplier<CreativeModeTab> TOOL = CREATIVE_MODE_TABS.register("tool",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + ElakeChemical.MODID + ".tool"))
                    .icon(() -> new ItemStack((ItemLike) Flint.getRegisteredElements().get(0)))
                    .displayItems((params, output) -> {
                        for (DeferredItem<? extends Item> item : Flint.getRegisteredElements()) {
                            output.accept(item);
                        }
                    }).build()
    );

    /**
     * 杂物创造模式标签页
     */
    public static final Supplier<CreativeModeTab> SUNDRIES = CREATIVE_MODE_TABS.register("sundries",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + ElakeChemical.MODID + ".sundries"))
                    .icon(() -> new ItemStack((ItemLike) Sundries.getRegisteredElements().get(0)))
                    .displayItems((params, output) -> {
                        for (DeferredItem<? extends Item> item : Sundries.getRegisteredElements()) {
                            output.accept(item);
                        }
                    }).build()
    );

    /**
     * 注册
     *
     * @param eventBus 事件总线
     */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
