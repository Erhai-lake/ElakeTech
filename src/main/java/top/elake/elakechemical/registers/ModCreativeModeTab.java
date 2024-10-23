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

import java.util.function.Supplier;

/**
 * 创造模式物品栏
 *
 * @author Erhai_lake
 */
public class ModCreativeModeTab {
    /**
     * 创造模式物品栏注册
     */
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElakeChemical.MODID);

    /**
     * 元素创造模式物品栏
     */
    public static final Supplier<CreativeModeTab> ELEMENT_TAB = CREATIVE_MODE_TABS.register("element_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + ElakeChemical.MODID + ".element_tab"))
            .icon(() -> new ItemStack((ItemLike) Elements.getRegisteredElements().get(0)))
            .displayItems((params, output) -> {
                output.accept(ModBlock.TEST_BLOCK.get());
                output.accept(ModBlock.TEST_BLOCK_ENTITY.get());
                for (DeferredItem<Item> item : Elements.getRegisteredElements()) {
                    output.accept(item);
                }
            }).build()
    );

    /**
     * 注册
     *
     * @param eventBus
     */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}