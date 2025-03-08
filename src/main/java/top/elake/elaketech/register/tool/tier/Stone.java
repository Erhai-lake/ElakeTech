package top.elake.elaketech.register.tool.tier;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.ModCreativeModeTab;
import top.elake.elaketech.util.Registers;

/**
 * @author Qi-Month
 */
public class Stone {
    static {
        ElakeTech.REGISTER.defaultCreativeTab("tool", (c) -> {
            c.icon(() -> new ItemStack(Flint.FLINT_PICKAXE.asItem()));
        }).register();
    }

    public static void register() {
    }

    public static final ItemEntry<? extends Item> STONE_HAMMER = Registers.registerColorTool(
            "stone_hammer",
            "Stone Hammer",
            0xFFFF8C00,
            "pickaxe",
            Tiers.STONE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.STONE, 1, -2)), 0
    );
}