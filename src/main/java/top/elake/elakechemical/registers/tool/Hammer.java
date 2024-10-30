package top.elake.elakechemical.registers.tool;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.checkerframework.checker.units.qual.A;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.ModCreativeModeTab;
import top.elake.elakechemical.utils.Registers;

import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class Hammer {
    private static final DeferredRegister.Items ITEMS = DeferredRegister
            .createItems(ElakeChemical.MODID);

    /**
     * 石锤
     */
//    public static final DeferredItem<Item> STONE_HAMMER = Registers.registerTool("stone_hammer", "Hoe", Tiers.STONE, new Item.Properties()
//            .attributes(HoeItem.createAttributes(Tiers.STONE, 1, -2))
//    );

    public static final DeferredItem<Item> STONE_HAMMER = ITEMS.register("stone_hammer", Aaa::new);

    /**
     * 注册
     */
    public static void register(IEventBus event) {
        ITEMS.register(event);

        // 石锤
        ModCreativeModeTab.addTools(STONE_HAMMER);
    }
}