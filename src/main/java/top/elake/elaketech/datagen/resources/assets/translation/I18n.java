package top.elake.elaketech.datagen.resources.assets.translation;

import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.registers.item.Elements;
import top.elake.elaketech.registers.item.MetalIngot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake
 */
public class I18n {
    public static void registers() {
        // 元素
        for (String element : Elements.ELEMENTS_ITEM_ARR) {
            addLang("item", element, element, element);
        }

        // 金属锭
        for (MetalIngot.IngotItem ingot : MetalIngot.INGOT_ITEM_ARR) {
            addLang("item", ingot.id() + "_ingot", ingot.en() + " Ingot", ingot.cn() + "锭");
        }

        // 标签页
        addLang("itemGroup", "all", "ElakeTech - All", "洱海科技 - 全部");
        addLang("itemGroup", "element", "ElakeTech - Elements", "洱海科技 - 元素");
        addLang("itemGroup", "tool", "ElakeTech - Tool", "洱海科技 - 工具");
        addLang("itemGroup", "materials", "ElakeTech - Materials", "洱海科技 - 材料");
        addLang("itemGroup", "chemical_appliances", "ElakeTech - Chemical Appliances", "洱海科技 - 化学用具");
        addLang("itemGroup", "sundries", "ElakeTech - Sundries", "洱海科技 - 杂项");
        // 画
        addLang("painting", "periodic_table_of_elements.title", "Periodic table of elements", "化学元素周期表");
        addLang("painting", "periodic_table_of_elements.author", "Дми́трий Ива́нович Менделе́ев/Elake", "德米特里·伊万诺维奇·门捷列夫/Elake");
        // 书
        addLang(null, "patchouli.book.name", "EC Manual", "EC手册");
        addLang(null, "patchouli.book.landing", "EC Complete Reference Guide$(br2)(Content under development, please refer to the official release for actual content)", "EC完整参考指南$(br2)(开发中内容,实际内容请以正式上线为准)");

        // 材料
        addLang("item", "grass_fiber", "Grass Fiber", "草纤维");
        addLang("item", "grass_string", "Grass String", "草绳");
        addLang("item", "raw_graphite", "Raw Graphite", "粗石墨");
        addLang("item", "graphite_ingot", "Graphite Ingot", "石墨锭");
        addLang("item", "graphite_plate", "Graphite Plate", "石墨板");
        addLang("item", "fragment_dolomite", "Fragment Dolomite", "粉碎白云岩");
        addLang("item", "kaolinite", "Kaolinite", "高岭土");
        addLang("item", "refractory_brick", "Refractory Brick", "耐火砖");
        addLang("item", "refractory_clay_ball", "Refractory Clay Ball", "耐火黏土球");
        addLang("item", "wet_refractory_brick", "Wet Refractory Brick", "潮湿耐火砖");

        // 工具
        addLang("item", "flint_sword", "Flint Sword", "燧石剑");
        addLang("item", "flint_pickaxe", "Flint Pickaxe", "燧石镐");
        addLang("item", "flint_axe", "Flint Axe", "燧石斧");
        addLang("item", "flint_hatchet", "Flint Hand Axe", "燧石手斧");
        addLang("item", "flint_shovel", "Flint Shovel", "燧石锹");
        addLang("item", "flint_hoe", "Flint Hoe", "燧石锄");

        //方块
        addLang("block", "alcohol_lamp", "Alcohol Lamp", "酒精灯");
        addLang("block", "dolostone", "Dolostone", "白云岩");
        addLang("block", "kaolin", "Kaolin", "高岭土");
        addLang("block", "refractory_bricks", "Refractory Bricks", "耐火砖块");

        // 矿石
        addLang("block", "graphite_ore", "Graphite Ore", "石墨矿石");
        addLang("block", "deepslate_graphite_ore", "Deepslate Graphite Ore", "深层石墨矿石");
        addLang("block", "quartz_ore", "Quartz Ore", "石英矿");
        addLang("block", "deepslate_quartz_ore", "Deepslate Quartz Ore", "深层石英矿");

        // 化学用具
        addLang("item", "asbestos_net", "Asbestos Net", "石棉网");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public static void addLang(String type, String id, String EN_US, String ZH_CN) {
        List<String> newList = new ArrayList<>();
        if (type == null) {
            newList.add(ElakeTech.MODID + "." + id);
        } else {
            newList.add(type + "." + ElakeTech.MODID + "." + id);
        }
        newList.add(EN_US);
        newList.add(ZH_CN);
        LIST.add(newList);
    }
}