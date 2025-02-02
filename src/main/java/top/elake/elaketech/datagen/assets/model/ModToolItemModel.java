package top.elake.elaketech.datagen.assets.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qi-Month
 */
public class ModToolItemModel {
    public static void registers() {
        // 燧石剑
        addToolItemModel("flint_sword", "item/tool/flint/sword");
        // 燧石镐
        addToolItemModel("flint_pickaxe", "item/tool/flint/pickaxe");
        // 燧石斧
        addToolItemModel("flint_axe", "item/tool/flint/axe");
        // 燧石手斧
        addToolItemModel("flint_hatchet", "item/tool/flint/hatchet");
        // 燧石锹
        addToolItemModel("flint_shovel", "item/tool/flint/shovel");
        // 燧石锄头
        addToolItemModel("flint_hoe", "item/tool/flint/hoe");

        // 青铜剑
        addToolItemModel("bronze_sword", "item/tool/color/sword/head", "item/tool/color/sword/handle");
        // 青铜镐
        addToolItemModel("bronze_pickaxe", "item/tool/color/pickaxe/head", "item/tool/color/pickaxe/handle");
        // 青铜斧
        addToolItemModel("bronze_axe", "item/tool/color/axe/head", "item/tool/color/axe/handle");
        // 青铜锄
        addToolItemModel("bronze_shovel", "item/tool/color/shovel/head", "item/tool/color/shovel/handle");
        // 青铜锄头
        addToolItemModel("bronze_hoe", "item/tool/color/hoe/head", "item/tool/color/hoe/handle");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addToolItemModel(String file, String... textures) {
        List<String> newList = new ArrayList<>();
        newList.add("Item");
        newList.add(file);
        newList.addAll(Arrays.asList(textures));
        LIST.add(newList);
    }
}