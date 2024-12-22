package top.elake.elaketech.datagen.resources.assets.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qi-Month
 */
public class ModToolItemModel {
    public static void registers() {
        // 燧石剑
        addToolItemModel("Item", "flint_sword", "item/tool/flint/sword");
        // 燧石镐
        addToolItemModel("Item","flint_pickaxe", "item/tool/flint/pickaxe");
        // 燧石斧
        addToolItemModel("Item","flint_axe", "item/tool/flint/axe");
        // 燧石手斧
        addToolItemModel("Item","flint_hatchet", "item/tool/flint/hatchet");
        // 燧石锹
        addToolItemModel("Item","flint_shovel", "item/tool/flint/shovel");
        // 燧石锄头
        addToolItemModel("Item","flint_hoe", "item/tool/flint/hoe");

        // 青铜剑
        addToolItemModel("Item","bronze_sword", "item/tool/color/sword/head", "item/tool/color/sword/handle");
        // 青铜镐
        addToolItemModel("Item","bronze_pickaxe", "item/tool/color/pickaxe/head", "item/tool/color/pickaxe/handle");
        // 青铜斧
        addToolItemModel("Item","bronze_axe", "item/tool/color/axe/head", "item/tool/color/axe/handle");
        // 青铜锄
        addToolItemModel("Item","bronze_shovel", "item/tool/color/shovel/head", "item/tool/color/shovel/handle");
        // 青铜锄头
        addToolItemModel("Item","bronze_hoe", "item/tool/color/hoe/head", "item/tool/color/hoe/handle");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addToolItemModel(String type, String file, String... texture) {
        List<String> newList = new ArrayList<>();
        newList.add(type);
        newList.add(file);
        newList.addAll(Arrays.asList(texture));
        LIST.add(newList);
    }
}