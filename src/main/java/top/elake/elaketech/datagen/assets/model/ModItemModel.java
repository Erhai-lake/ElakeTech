package top.elake.elaketech.datagen.assets.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Erhai-lake Qi-Month
 */
public class ModItemModel {
    public static void registers() {
        // 书
        addItemModel("Item", "book", "item/book");
        // 化学用具
        // 石棉网
        addItemModel("Item", "asbestos_net", "item/chemical_appliances/asbestos_net");
        // 方块
        // 酒精灯
        addItemModel("BlockItem", "alcohol_lamp", "block/chemical_appliances/alcohol_lamp");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addItemModel(String output, String file, String... texture) {
        List<String> newList = new ArrayList<>();
        newList.add(output);
        newList.add(file);
        newList.addAll(Arrays.asList(texture));
        LIST.add(newList);
    }
}
