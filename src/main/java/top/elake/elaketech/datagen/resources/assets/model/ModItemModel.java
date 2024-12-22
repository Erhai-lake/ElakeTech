package top.elake.elaketech.datagen.resources.assets.model;

import top.elake.elaketech.registers.item.Elements;
import top.elake.elaketech.registers.item.MetalIngot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Erhai-lake Qi-Month
 */
public class ModItemModel {
    public static void registers() {
        // 元素
        for (String element : Elements.ELEMENTS_ITEM_ARR) {
            addItemModels("Item", element, "item/element/" + element);
        }

        // 金属锭
        for (MetalIngot.IngotItem ingot : MetalIngot.INGOT_ITEM_GROUP) {
            addItemModels("Item", ingot.id() + "_ingot", "item/materials/color/ingot");
        }
        // 书
        addItemModels("Item", "book", "item/book");
        // 材料
        // 草纤维
        addItemModels("Item", "grass_fiber", "item/materials/grass_fiber");
        // 草绳
        addItemModels("Item", "grass_string", "item/materials/grass_string");
        // 粗石磨
        addItemModels("Item", "raw_graphite", "item/materials/alone/graphite/ore");
        // 石墨
        addItemModels("Item", "graphite_ingot", "item/materials/alone/graphite/ingot");
        // 石墨板
        addItemModels("Item", "graphite_plate", "item/materials/alone/graphite/plate");
        // 粗石磨
        addItemModels("Item", "raw_graphite", "item/materials/alone/graphite/ore");
        // 粉碎白云岩
        addItemModels("Item", "fragment_dolomite", "item/materials/fragment_dolomite");
        // 高岭土
        addItemModels("Item", "kaolinite", "item/materials/kaolinite");
        // 耐火砖
        addItemModels("Item", "refractory_brick", "item/materials/refractory_brick");
        // 潮湿耐火砖
        addItemModels("Item", "wet_refractory_brick", "item/materials/wet_refractory_brick");
        // 耐火粘土球
        addItemModels("Item", "refractory_clay_ball", "item/materials/refractory_clay_ball");

        // 工具
        // 燧石剑
        addItemModels("Item", "flint_sword", "item/tool/flint/sword");
        // 燧石镐
        addItemModels("Item", "flint_pickaxe", "item/tool/flint/pickaxe");
        // 燧石斧
        addItemModels("Item", "flint_axe", "item/tool/flint/axe");
        // 燧石手斧
        addItemModels("Item", "flint_hatchet", "item/tool/flint/hatchet");
        // 燧石锄
        addItemModels("Item", "flint_shovel", "item/tool/flint/shovel");
        // 燧石锄头
        addItemModels("Item", "flint_hoe", "item/tool/flint/hoe");

        // 化学用具
        // 石棉网
        addItemModels("Item", "asbestos_net", "item/chemical_appliances/asbestos_net");
        // 方块
        // 酒精灯
        addItemModels("BlockItem", "alcohol_lamp", "block/chemical_appliances/alcohol_lamp");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addItemModels(String type, String file, String... texture) {
        List<String> newList = new ArrayList<>();
        newList.add(type);
        newList.add(file);
        newList.addAll(Arrays.asList(texture));
        LIST.add(newList);
    }
}
