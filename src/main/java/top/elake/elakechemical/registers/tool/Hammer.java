package top.elake.elakechemical.registers.tool;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.utils.Registers;

/**
 * @author Erhai-lake
 */
public class Hammer {
    /**
     * 注册
     */
    public static void register() {
        // 镐
        ModCreativeModeTab.addTools(Registers.registerTool("stone_hammer", "Pickaxe", Tiers.STONE, new Item.Properties()
                .attributes(PickaxeItem.createAttributes(Tiers.STONE, 5, -3))
        ));
    }
}