package top.elake.elaketech.register;

import com.tterrag.registrate.builders.NoConfigBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.ChemicalAppliancesItem;

import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class ModCreativeModeTab {
    public static final String IG = "itemGroup.";

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElakeTech.MODID);

    /**
     * 元素
     */
    public static final NoConfigBuilder<CreativeModeTab, CreativeModeTab, String> ELEMENTS = ElakeTech.REGISTER.defaultCreativeTab("elements", "Elements",
            (c) -> {
                c.title(Component.translatable(IG + ElakeTech.MODID + ".elements"));
                c.icon(() -> new ItemStack(ChemicalAppliancesItem.ASBESTOS_NET.asItem()));
                c.build();
            });


    /**
     * 化学用具
     */
    public static final Supplier<CreativeModeTab> CHEMICAL_APPLIANCES = CREATIVE_MODE_TABS.register("chemical_appliances",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(IG + ElakeTech.MODID + ".chemical_appliances"))
                    .icon(() -> new ItemStack(ChemicalAppliancesItem.ASBESTOS_NET.asItem()))
                    .build()
    );

    /**
     * 材料
     */
    public static final Supplier<CreativeModeTab> MATERIALS = CREATIVE_MODE_TABS.register("materals",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(IG + ElakeTech.MODID + ".materals"))
                    .icon(() -> new ItemStack(ChemicalAppliancesItem.ASBESTOS_NET.asItem()))
                    .build()
    );

    /**
     * 工具
     */
    public static final Supplier<CreativeModeTab> TOOLS = CREATIVE_MODE_TABS.register("tools",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(IG + ElakeTech.MODID + ".tools"))
                    .icon(() -> new ItemStack(ChemicalAppliancesItem.ASBESTOS_NET.asItem()))
                    .build()
    );

    public static void register(IEventBus event) {
        CREATIVE_MODE_TABS.register(event);
    }
}