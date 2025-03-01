package top.elake.elaketech.register;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.block.OreBlock;
import top.elake.elaketech.register.item.ChemicalAppliancesItem;
import top.elake.elaketech.register.item.Element;
import top.elake.elaketech.register.tool.tier.Flint;


/**
 * @author Erhai-lake
 */
public class ModCreativeModeTab {
    private static final String IG = "itemGroup.";

    /**
     * 元素
     */
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> ELEMENTS = ElakeTech.REGISTER.defaultCreativeTab("elements",
                    (c) -> {
//                        c.title(Component.translatable(IG + ElakeTech.MODID + ".elements"));
                        c.icon(() -> new ItemStack(Element.Elements.H.item.asItem()));
                    })
            .register();


    /**
     * 化学用具
     */
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> CHEMICAL_APPLIANCES = ElakeTech.REGISTER.defaultCreativeTab("chemical_appliances",
            (c) -> {
//                c.title(Component.translatable(IG + ElakeTech.MODID + ".chemical_appliances"));
                c.icon(() -> new ItemStack(ChemicalAppliancesItem.ASBESTOS_NET.asItem()));
            }).register();

    /**
     * 材料
     */
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> MATERIALS = ElakeTech.REGISTER.defaultCreativeTab("materials",
            (c) -> {
                c.title(Component.translatable(IG + ElakeTech.MODID + ".materials"));
                c.icon(() -> new ItemStack(OreBlock.TIN.asItem()));
            }).register();

    /**
     * 工具
     */
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> TOOLS = ElakeTech.REGISTER.defaultCreativeTab("tools",
            (c) -> {
//                c.title(Component.translatable(IG + ElakeTech.MODID + ".tools"));
                c.icon(() -> new ItemStack(Flint.FLINT_PICKAXE.asItem()));
            }).register();

    public static void register() {
    }
}