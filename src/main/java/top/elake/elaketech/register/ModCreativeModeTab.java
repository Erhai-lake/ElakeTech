package top.elake.elaketech.register;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.NoConfigBuilder;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.block.OreBlock;
import top.elake.elaketech.register.item.ChemicalAppliancesItem;
import top.elake.elaketech.register.tool.tier.Flint;


/**
 * @author Erhai-lake
 */
public class ModCreativeModeTab {
    private static final String IG = "itemGroup.";

    /**
     * 元素
     */
    public static final NoConfigBuilder<CreativeModeTab, CreativeModeTab, Registrate> ELEMENTS = ElakeTech.REGISTER.defaultCreativeTab("elements",
            (c) -> {
                c.title(Component.translatable(IG + ElakeTech.MODID + ".elements"));
                c.icon(() -> new ItemStack(ChemicalAppliancesItem.ASBESTOS_NET.asItem()));
                c.build();
            });


    /**
     * 化学用具
     */
    public static final NoConfigBuilder<CreativeModeTab, CreativeModeTab, Registrate> CHEMICAL_APPLIANCES = ElakeTech.REGISTER.defaultCreativeTab("chemical_appliances",
            (c) -> {
                c.title(Component.translatable(IG + ElakeTech.MODID + ".chemical_appliances"));
                c.icon(() -> new ItemStack(ChemicalAppliancesItem.ASBESTOS_NET.asItem()));
                c.build();
            });

    /**
     * 材料
     */
    public static final NoConfigBuilder<CreativeModeTab, CreativeModeTab, Registrate> MATERIALS = ElakeTech.REGISTER.defaultCreativeTab("materials",
            (c) -> {
                c.title(Component.translatable(IG + ElakeTech.MODID + ".materials"));
                c.icon(() -> new ItemStack(OreBlock.TIN.asItem()));
                c.build();
            });

    /**
     * 工具
     */
    public static final NoConfigBuilder<CreativeModeTab, CreativeModeTab, Registrate> TOOLS = ElakeTech.REGISTER.defaultCreativeTab("tools",
            (c) -> {
                c.title(Component.translatable(IG + ElakeTech.MODID + ".tools"));
                c.icon(() -> new ItemStack(Flint.FLINT_PICKAXE.asItem()));
                c.build();
            });

    public static void register() {
    }
}