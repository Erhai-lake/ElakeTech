package top.elake.elakechemical.registers.tool;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.utils.Registers;

/**
 * @author Erhai-lake
 */
public class Hammer {
    /**
     * 石锤
     */
    public static final DeferredItem<Item> STONE_HAMMER = Registers.registerTool("stone_hammer", "Pickaxe", Tiers.STONE, new Item.Properties()
            .attributes(PickaxeItem.createAttributes(Tiers.STONE, 1, -2))
    );

    /**
     * 注册
     */
    public static void register(IEventBus event) {
        // 石锤
        ModCreativeModeTab.addTools(STONE_HAMMER);
    }
}