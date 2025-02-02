package top.elake.elaketech.datagen.assets.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake
 */
public class ModBlockModel {
    public static void registers() {
        // 石墨矿
        addBlockModels("graphite_ore", "block/ore/graphite/ore", "Block");
        // 深层石墨矿
        addBlockModels("deepslate_graphite_ore", "block/ore/graphite/deepslate", "Block");
        // 石英矿
        addBlockModels("quartz_ore", "block/ore/quartz/ore", "Block");
        // 深层石英矿
        addBlockModels("deepslate_quartz_ore", "block/ore/quartz/deepslate", "Block");
        // 白云岩
        addBlockModels("dolostone", "block/dolostone", "Block");
        // 高岭土
        addBlockModels("kaolin", "block/kaolin", "Block");
        // 耐火砖块
        addBlockModels("refractory_bricks", "block/refractory_bricks", "Block");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addBlockModels(String file, String texture, String type) {
        List<String> newList = new ArrayList<>();
        newList.add(file);
        newList.add(texture);
        newList.add(type);
        LIST.add(newList);
    }
}