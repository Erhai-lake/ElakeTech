package top.elake.elaketech.datagen.resources.assets.model.item;

import top.elake.elaketech.registers.item.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake Qi-Month
 */
public class ItemModel {
    public static void registers() {
        // 书
        addItemModels("book", "item/book");
        // 元素
        for (String element : Elements.ELEMENTS_ITEM_ARR) {
            addItemModels(element, "item/element/" + element);
        }
        // 材料
        // 草纤维
        addItemModels("grass_fiber", "item/materials/grass_fiber");
        // 草绳
        addItemModels("grass_string", "item/materials/grass_string");
        // 铜板
        addItemModels("copper_plate", "item/materials/alone/copper/plate");
        // 铜线
        addItemModels("copper_wire", "item/materials/alone/copper/wire");
        // 简易铜线圈
        addItemModels("easy_copper_coil", "item/materials/alone/copper/easy_copper_coil");
        // 石墨
        addItemModels("graphite_ingot", "item/materials/alone/graphite/ingot");
        // 石墨板
        addItemModels("graphite_plate", "item/materials/alone/graphite/plate");
        // 粗石磨
        addItemModels("raw_graphite", "item/materials/alone/graphite/ore");

        // 工具
        // 燧石剑
        addItemModels("flint_sword", "item/tool/flint/sword");
        // 燧石镐
        addItemModels("flint_pickaxe", "item/tool/flint/pickaxe");
        // 燧石斧
        addItemModels("flint_axe", "item/tool/flint/axe");
        // 燧石手斧
        addItemModels("flint_handaxe", "item/tool/flint/handaxe");
        // 燧石锄
        addItemModels("flint_shovel", "item/tool/flint/shovel");
        // 燧石锄头
        addItemModels("flint_hoe", "item/tool/flint/hoe");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addItemModels(String namespace, String path) {
        List<String> newList = new ArrayList<>();
        newList.add(namespace);
        newList.add(path);
        LIST.add(newList);
    }
}