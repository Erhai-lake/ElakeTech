package top.elake.elakechemical.registers.tool;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.ModCreativeModeTab;

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

    public static final DeferredItem<Item> STONE_HAMMER = ITEMS.register("stone_hammer", () -> new PickaxeItem(Tiers.STONE, new Item.Properties()
            .attributes(PickaxeItem.createAttributes(Tiers.STONE, 1, -2)))
            .getCraftingRemainingItem()
    );

//    public static final DeferredItem<PickaxeItem> STONE_HAMMER = ITEMS.register("stone_hammer", () -> {
//        return new PickaxeItem(Tiers.STONE, new Item.Properties()
//                .stacksTo(1)
//                .durability(Tiers.STONE.getUses())) {
//            @Override
//            public @NotNull ItemStack getCraftingRemainingItem(@NotNull ItemStack itemStack) {
                //                if (remainingStack.getDamageValue() < remainingStack.getMaxDamage() - 1) {
//                    remainingStack.setDamageValue(remainingStack.getDamageValue() + 1);
//                }
//                return super.getCraftingRemainingItem(itemStack);
//            }
//        };
//    });


    /**
     * 注册
     */
    public static void register(IEventBus event) {
        ITEMS.register(event);

        // 石锤
        ModCreativeModeTab.addTools(STONE_HAMMER);
    }
}