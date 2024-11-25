package top.elake.elaketech.datagen.resources.assets.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake
 */
public class BlockModel {
    public static void registers() {
        // 石墨矿
        addBlockModels("graphite_ore", "block/metal/ore/graphite/ore", "Block");
        // 深层石墨矿
        addBlockModels("deepslate_graphite_ore", "block/metal/ore/graphite/deepslate", "Block");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addBlockModels(String namespace, String path, String type) {
        List<String> newList = new ArrayList<>();
        newList.add(namespace);
        newList.add(path);
        newList.add(type);
        LIST.add(newList);
    }
}
