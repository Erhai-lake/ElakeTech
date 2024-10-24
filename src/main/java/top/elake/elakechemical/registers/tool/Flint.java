package top.elake.elakechemical.registers.tool;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.tag.ModItemTags;

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

    /**
     * Item
     */
    public static final DeferredRegister.Items ITEMS = DeferredRegister
            .createItems(ElakeChemical.MODID);

    /**
     * 燧石镐可以破坏的方块(继承原版木质工具)
     */
    public static final TagKey<Block> NEEDS_FLINT_TOOL = TagKey
            .create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath("minecraft", "incorrect_for_wooden_tool"));

    /**
     * 等级
     */
    public static final Tier FLINT_TIER = new SimpleTier(
            NEEDS_FLINT_TOOL,
            5,
            0.3F,
            1,
            0,
            () -> Ingredient.of(ModItemTags.Items.FLINT)
    );

    /**
     * 注册剑
     */
    public static final Supplier<SwordItem> SWORD = ITEMS.register("flint_sword",
            () -> new SwordItem(FLINT_TIER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(FLINT_TIER, 3, -2.4f))
            ));

    static {
        REGISTERED_ELEMENTS.add((DeferredItem<? extends Item>) SWORD);
    }

    /**
     * 注册镐
     */
    public static final Supplier<PickaxeItem> PICKAXE = ITEMS.register("flint_pickaxe",
            () -> new PickaxeItem(FLINT_TIER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(FLINT_TIER, 1, -2.8f))
            ));

    static {
        REGISTERED_ELEMENTS.add((DeferredItem<? extends Item>) PICKAXE);
    }

    /**
     * 注册斧
     */
    public static final Supplier<AxeItem> AXE = ITEMS.register("flint_axe",
            () -> new AxeItem(FLINT_TIER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(FLINT_TIER, 1, -2))
            ));
    /**
     * 注册手斧
     */
    public static final Supplier<AxeItem> HANDAXE = ITEMS.register("flint_handaxe",
            () -> new AxeItem(FLINT_TIER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(FLINT_TIER, 1, -2))
            ));
    /**
     * 注册锹
     */
    public static final Supplier<ShovelItem> SHOVEL = ITEMS.register("flint_shovel",
            () -> new ShovelItem(FLINT_TIER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(FLINT_TIER, 1.5F, -3))
            ));
    /**
     * 注册锄
     */
    public static final Supplier<HoeItem> HOE = ITEMS.register("flint_hoe",
            () -> new HoeItem(FLINT_TIER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(FLINT_TIER, 1, -2))
            ));

    static {
        REGISTERED_ELEMENTS.add((DeferredItem<? extends Item>) AXE);
    }

    static {
        REGISTERED_ELEMENTS.add((DeferredItem<? extends Item>) HANDAXE);
    }

    static {
        REGISTERED_ELEMENTS.add((DeferredItem<? extends Item>) SHOVEL);
    }

    static {
        REGISTERED_ELEMENTS.add((DeferredItem<? extends Item>) HOE);
    }
}