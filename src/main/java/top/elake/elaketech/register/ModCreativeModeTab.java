package top.elake.elaketech.register;

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
     * 化学用具
     */
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> CHEMICAL_APPLIANCES = ElakeTech.REGISTER.defaultCreativeTab("chemical_appliances",
            (c) -> {
                c.icon(() -> new ItemStack(ChemicalAppliancesItem.ASBESTOS_NET.asItem()));
            }).lang((t) -> IG + ElakeTech.MODID + ".chemical_appliances", "Chemical Appliances").register();

    /**
     * 材料
     */
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> MATERIALS = ElakeTech.REGISTER.defaultCreativeTab("materials",
            (c) -> {
                c.icon(() -> new ItemStack(OreBlock.TIN.asItem()));
            }).lang((t) -> IG + ElakeTech.MODID + ".materials", "Materials").register();

    /**
     * 工具
     */
//    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> TOOLS = ElakeTech.REGISTER.defaultCreativeTab("tool",
//            (c) -> {
//                c.icon(() -> new ItemStack(Flint.FLINT_PICKAXE.asItem()));
//            }).lang((t) -> IG + ElakeTech.MODID + ".tool", "Tool").register();

    public static void register() {
    }
}