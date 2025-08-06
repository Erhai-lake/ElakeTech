package top.elake.elaketech.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.register.block.CommonBlock;
import top.elake.elaketech.register.block.FunctionBlock;
import top.elake.elaketech.register.item.materials.Materials;
import top.elake.elaketech.register.item.tools.FlintTools;

import java.util.function.Supplier;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author Elake Studio
 */
public class ElakeTechCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> MATERIALS_TAB;
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> TOOLS_TAB;
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> COMMON_BLOCK_TAB;
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> FUNCTION_BLOCK_TAB;

    static {
        // 材料
        MATERIALS_TAB = addCreativeModeTab("materials", () -> Materials.GRASS_FIBER);
        // 工具
        TOOLS_TAB = addCreativeModeTab("tools", () -> FlintTools.FLINT_PICKAXE);
        // 普通方块
        COMMON_BLOCK_TAB = addCreativeModeTab("common_blocks", () -> CommonBlock.REFRACTORY_BRICKS);
        // 功能性方块
        FUNCTION_BLOCK_TAB = addCreativeModeTab("function_blocks", () -> FunctionBlock.DRY_RACK);
    }

    public static void register(IEventBus event) {
        TABS.register(event);
    }

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> addCreativeModeTab(String name, Supplier<? extends ItemLike> displayIcon) {
        return TABS.register(name + "_tab", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(displayIcon.get()))
                .title(Component.translatable("itemGroup.%s.%s_tab".formatted(MODID, name)))
                .build());
    }
}