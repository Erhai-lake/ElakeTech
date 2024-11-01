package top.elake.elakechemical.client.datagen.itemmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake
 */
public class ItemModel {
    public static void registers() {
//        addItemModels("asa", "item/element/ac");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addItemModels(String namespace, String texture) {
        List<String> newList = new ArrayList<>();
        newList.add(namespace);
        newList.add(texture);
        LIST.add(newList);
    }
}
