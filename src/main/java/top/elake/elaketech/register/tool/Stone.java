package top.elake.elaketech.register.tool;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.util.Registers;

/**
 * @author Qi-Month
 */
public class Stone {
    public static void register() {
        // 锤子
        ModCreativeModeTab.addTools(STONE_HAMMER);
    }

    public static final DeferredItem<Item> STONE_HAMMER = Registers.registerTool("stone_hammer", "pickaxe", Tiers.STONE, new Item.Properties()
            .attributes(PickaxeItem.createAttributes(Tiers.STONE, 3, -2.4f)), 5);
}