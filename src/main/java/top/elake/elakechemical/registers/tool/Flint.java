package top.elake.elakechemical.registers.tool;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.tags.ModBlockTags;
import top.elake.elakechemical.registers.tags.ModItemTags;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Qi-Month
 */
public class Flint {
    /**
     * 已注册的元素
     */
    public static final List<DeferredItem<? extends Item>> REGISTERED_ELEMENTS = new ArrayList<>();

    /**
     * 注册剑
     */
    public static final Supplier<SwordItem> SWORD = ITEMS.register("flint_sword",
            () -> new SwordItem(FLINT_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(FLINT_TIER, 3, -2.4f))
            ));
    /**
     * 注册剑
     */
    public static final Supplier<PickaxeItem> PICKAXE = ITEMS.register("flint_pickaxe",
            () -> new PickaxeItem(FLINT_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(FLINT_TIER, 3, -2.4f))
            ));

    /**
     * Item
     */
    public static final DeferredRegister.Items ITEMS = DeferredRegister
            .createItems(ElakeChemical.MODID);
    /**
     * 等级
     */
    public static final Tier FLINT_TIER = new SimpleTier(
            ModBlockTags.NEEDS_FLINT_TOOL,
            200,
            5f,
            1.5f,
            20,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    /**
     * 获取已注册的元素物品列表
     *
     * @return 已注册的元素物品列表
     */
    public static List<DeferredItem<? extends Item>> getRegisteredElements() {
        return REGISTERED_ELEMENTS;
    }

    /**
     * 注册
     *
     * @param eventBus 事件总线
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    static {
        REGISTERED_ELEMENTS.add((DeferredItem<? extends Item>) SWORD);
    }

    static {
        REGISTERED_ELEMENTS.add((DeferredItem<? extends Item>) PICKAXE);
    }
}