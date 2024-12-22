package top.elake.elaketech.datagen.resources.assets.model;

import top.elake.elaketech.registers.item.Elements;
import top.elake.elaketech.registers.item.MetalIngot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Erhai-lake Qi-Month
 */
public class ModItemModel {
    public static void registers() {
        // 元素
        for (String element : Elements.ELEMENTS_ITEM_ARR) {
            addItemModel("Item", element, "item/element/" + element);
        }

        // 金属锭
        for (MetalIngot.IngotItem ingot : MetalIngot.INGOT_ITEM_GROUP) {
            addItemModel("Item", ingot.id() + "_ingot", "item/materials/color/ingot");
        }
        // 书
        addItemModel("Item", "book", "item/book");
        // 材料
        // 草纤维
        addItemModel("Item", "grass_fiber", "item/materials/grass_fiber");
        // 草绳
        addItemModel("Item", "grass_string", "item/materials/grass_string");
        // 粗石磨
        addItemModel("Item", "raw_graphite", "item/materials/alone/graphite/ore");
        // 石墨
        addItemModel("Item", "graphite_ingot", "item/materials/alone/graphite/ingot");
        // 石墨板
        addItemModel("Item", "graphite_plate", "item/materials/alone/graphite/plate");
        // 粗石磨
        addItemModel("Item", "raw_graphite", "item/materials/alone/graphite/ore");
        // 粉碎白云岩
        addItemModel("Item", "fragment_dolomite", "item/materials/fragment_dolomite");
        // 高岭土
        addItemModel("Item", "kaolinite", "item/materials/kaolinite");
        // 耐火砖
        addItemModel("Item", "refractory_brick", "item/materials/refractory_brick");
        // 潮湿耐火砖
        addItemModel("Item", "wet_refractory_brick", "item/materials/wet_refractory_brick");
        // 耐火粘土球
        addItemModel("Item", "refractory_clay_ball", "item/materials/refractory_clay_ball");

        // 化学用具
        // 石棉网
        addItemModel("Item", "asbestos_net", "item/chemical_appliances/asbestos_net");
        // 方块
        // 酒精灯
        addItemModel("BlockItem", "alcohol_lamp", "block/chemical_appliances/alcohol_lamp");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addItemModel(String type, String file, String... texture) {
        List<String> newList = new ArrayList<>();
        newList.add(type);
        newList.add(file);
        newList.addAll(Arrays.asList(texture));
        LIST.add(newList);
    }
}
