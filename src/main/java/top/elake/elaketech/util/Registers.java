package top.elake.elaketech.util;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.util.tool.*;

import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class Registers {
    /**
     * 注册物品
     *
     * @param name       名称
     * @param properties 物品属性
     * @return 物品句柄
     */
    public static ItemEntry<Item> registerItem(String name, Item.Properties properties) {
        return ElakeTech.REGISTER.item(name, p -> new Item(properties))
                .register();
    }

    /**
     * 注册方块
     *
     * @param name       名称
     * @param properties 方块属性
     * @return 方块句柄
     */
    public static <T extends Block> BlockEntry<T> registerBlock(String name, BlockBehaviour.Properties properties, Supplier<T> factory) {
        return ElakeTech.REGISTER.block(name, p -> factory.get())
                .properties(p -> properties)
                .register();
    }

    /**
     * 注册方块物品
     *
     * @param name       名称
     * @param block      方块
     * @param properties 物品属性
     * @return 物品句柄
     */
    public static ItemEntry<BlockItem> registerBlockItem(String name, BlockEntry<? extends Block> block, Item.Properties properties) {
        return ElakeTech.REGISTER.item(name, p -> new BlockItem(block.get(), properties))
                .register();
    }

    /**
     * 注册工具
     *
     * @param name       名称
     * @param type       类型: Sword/Pickaxe/Axe/Shovel/Hoe
     * @param tier       等级
     * @param properties 工具属性
     * @return 工具句柄
     */
    public static ItemEntry<? extends Item> registerTool(String name, int color, String type, Tier tier, Item.Properties properties, int craftingSubtractingDamage) {
        return switch (type) {
            case "sword" -> ElakeTech.REGISTER.<SwordDamageToolCrafting>item(name,
                p -> new SwordDamageToolCrafting(tier, properties, craftingSubtractingDamage)).register();
            case "pickaxe" -> ElakeTech.REGISTER.<PickaxeDamageToolCrafting>item(name,
                p -> new PickaxeDamageToolCrafting(tier, properties, craftingSubtractingDamage)).register();
            case "axe" -> ElakeTech.REGISTER.<AxeDamageToolCrafting>item(name,
                p -> new AxeDamageToolCrafting(tier, properties, craftingSubtractingDamage)).register();
            case "shovel" -> ElakeTech.REGISTER.<ShovelDamageToolCrafting>item(name,
                p -> new ShovelDamageToolCrafting(tier, properties, craftingSubtractingDamage)).register();
            case "hoe" -> ElakeTech.REGISTER.<HoeDamageToolCrafting>item(name,
                p -> new HoeDamageToolCrafting(tier, properties, craftingSubtractingDamage)).register();
            default -> throw new IllegalArgumentException("Error Type");
        };
    }
}