package top.elake.elaketech.datagen.resources.assets.model;

import top.elake.elaketech.registers.item.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake
 */
public class ModItemModel {
    public static void registers() {
        // 元素
        for (String element : Elements.ELEMENTS_ITEM_ARR) {
            addItemModels(element, "item/element/" + element, "Item");
        }
        // 书
        addItemModels("book", "item/book", "Item");
        // 材料
        // 草纤维
        addItemModels("grass_fiber", "item/materials/grass_fiber", "Item");
        // 草绳
        addItemModels("grass_string", "item/materials/grass_string", "Item");
        // 粗石磨
        addItemModels("raw_graphite", "item/materials/alone/graphite/ore", "Item");
        // 石墨
        addItemModels("graphite_ingot", "item/materials/alone/graphite/ingot", "Item");
        // 石墨板
        addItemModels("graphite_plate", "item/materials/alone/graphite/plate", "Item");
        // 青铜锭
        addItemModels("bronze_ingot", "item/materials/color/ingot", "Item");
        // 锡锭
        addItemModels("tin_ingot", "item/materials/color/ingot", "Item");
        // 粗石磨
        addItemModels("raw_graphite", "item/materials/alone/graphite/ore", "Item");
        // 粉碎白云岩
        addItemModels("fragment_dolomite", "item/materials/fragment_dolomite", "Item");
        // 高岭土
        addItemModels("kaolinite", "item/materials/kaolinite", "Item");
        // 耐火砖
        addItemModels("refractory_brick", "item/materials/refractory_brick", "Item");
        // 潮湿耐火砖
        addItemModels("wet_refractory_brick", "item/materials/wet_refractory_brick", "Item");
        // 耐火粘土球
        addItemModels("refractory_clay_ball", "item/materials/refractory_clay_ball", "Item");

        // 工具
        // 燧石剑
        addItemModels("flint_sword", "item/tool/flint/sword", "Item");
        // 燧石镐
        addItemModels("flint_pickaxe", "item/tool/flint/pickaxe", "Item");
        // 燧石斧
        addItemModels("flint_axe", "item/tool/flint/axe", "Item");
        // 燧石手斧
        addItemModels("flint_hatchet", "item/tool/flint/hatchet", "Item");
        // 燧石锄
        addItemModels("flint_shovel", "item/tool/flint/shovel", "Item");
        // 燧石锄头
        addItemModels("flint_hoe", "item/tool/flint/hoe", "Item");

        // 化学用具
        // 石棉网
        addItemModels("asbestos_net", "item/chemical_appliances/asbestos_net", "Item");
        // 方块
        // 酒精灯
        addItemModels("alcohol_lamp", "block/chemical_appliances/alcohol_lamp", "BlockItem");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addItemModels(String file, String texture, String type) {
        List<String> newList = new ArrayList<>();
        newList.add(file);
        newList.add(texture);
        newList.add(type);
        LIST.add(newList);
    }
}
