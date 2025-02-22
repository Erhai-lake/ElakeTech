package top.elake.elaketech.datagen.assets.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake
 */
public class ModBlockModel {
    public static void registers() {
        // 白云岩
        addBlockModels("dolostone", "block/dolostone", "Block");
        // 高岭土
        addBlockModels("kaolin", "block/kaolin", "Block");
        // 耐火砖块
        addBlockModels("refractory_bricks", "block/refractory_bricks", "Block");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addBlockModels(String output, String texture, String type) {
        List<String> newList = new ArrayList<>();
        newList.add(output);
        newList.add(texture);
        newList.add(type);
        LIST.add(newList);
    }
}