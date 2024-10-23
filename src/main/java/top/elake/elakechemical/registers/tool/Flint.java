package top.elake.elakechemical.registers.tool;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.tags.ModBlockTags;
import top.elake.elakechemical.registers.tags.ModItemTags;

import java.util.function.Supplier;

public class Flint {
    public static final DeferredRegister.Items ITEMS = DeferredRegister
            .createItems(ElakeChemical.MODID);

    public static void register(IEventBus event) {
        ITEMS.register(event);
    }

    // Tier Registers
    public static final Tier FLINT_TIER = new SimpleTier(
            ModBlockTags.NEEDS_FLINT_TOOL,
            200,
            5f,
            1.5f,
            20,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    // Tool Registers
    public static final Supplier<SwordItem> FLINT_SWORD = ITEMS.register("flint_sword",
            () -> new SwordItem(FLINT_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(FLINT_TIER, 3, -2.4f))
            ));

    public static final Supplier<PickaxeItem> FLINT_PICKAXE = ITEMS.register("flint_pickaxe",
            () -> new PickaxeItem(FLINT_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(FLINT_TIER, 3, -2.4f))
            ));
}