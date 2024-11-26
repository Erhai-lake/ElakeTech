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
        // 石墨
        addItemModels("graphite_ingot", "item/materials/alone/graphite/ingot", "Item");
        // 石墨板
        addItemModels("graphite_plate", "item/materials/alone/graphite/plate", "Item");
        // 粗石磨
        addItemModels("raw_graphite", "item/materials/alone/graphite/ore", "Item");
        // 工具
        // 燧石剑
        addItemModels("flint_sword", "item/tool/flint/sword", "Item");
        // 燧石镐
        addItemModels("flint_pickaxe", "item/tool/flint/pickaxe", "Item");
        // 燧石斧
        addItemModels("flint_axe", "item/tool/flint/axe", "Item");
        // 燧石手斧
        addItemModels("flint_handaxe", "item/tool/flint/handaxe", "Item");
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

    public static void addItemModels(String file, String path, String type) {
        List<String> newList = new ArrayList<>();
        newList.add(file);
        newList.add(path);
        newList.add(type);
        LIST.add(newList);
    }
}
