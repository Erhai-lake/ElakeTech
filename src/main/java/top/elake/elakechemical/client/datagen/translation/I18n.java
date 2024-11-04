package top.elake.elakechemical.client.datagen.translation;

import top.elake.elakechemical.ElakeChemical;
import top.elake.elakechemical.registers.item.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake
 */
public class I18n {
    public static void registers() {
        // 标签页
        addLang("itemGroup", "all", "ElakeChemical - All", "洱海化学 - 全部");
        addLang("itemGroup", "element", "ElakeChemical - Elements", "洱海化学 - 元素");
        addLang("itemGroup", "tool", "ElakeChemical - Tool", "洱海化学 - 工具");
        addLang("itemGroup", "materials", "ElakeChemical - Materials", "洱海化学 - 材料");
        addLang("itemGroup", "chemical_appliances", "ElakeChemical - Chemical Appliances", "洱海化学 - 化学用具");
        // 画
        addLang("painting", "periodic_table_of_elements.title", "Periodic table of elements", "化学元素周期表");
        addLang("painting", "periodic_table_of_elements.author", "Дми́трий Ива́нович Менделе́ев/Elake", "德米特里·伊万诺维奇·门捷列夫/Elake");
        // 书
        addLang(null, "patchouli.book.name", "EC Manual", "EC手册");
        addLang(null, "patchouli.book.landing", "EC Complete Reference Guide$(br2)(Content under development, please refer to the official release for actual content)", "EC完整参考指南$(br2)(开发中内容,实际内容请以正式上线为准)");
        // 元素
        for (String element : Elements.ELEMENTS_ITEM_ARR) {
            addLang("item", element, element, element);
        }
        // 材料
        addLang("item", "grass_fiber", "Grass Fiber", "草纤维");
        addLang("item", "grass_string", "Grass String", "草绳");
        addLang("item", "copper_plate", "Copper Plate", "铜板");
        addLang("item", "copper_wire", "Copper Wire", "铜线");
        addLang("item", "easy_copper_coil", "Easy Copper Coil", "简易铜线圈");
        addLang("item", "graphite_ingot", "Graphite Ingot", "石墨锭");
        addLang("item", "graphite_plate", "Graphite Plate", "石墨板");
        // 工具
        addLang("item", "flint_sword", "Flint Sword", "燧石剑");
        addLang("item", "flint_pickaxe", "Flint Pickaxe", "燧石镐");
        addLang("item", "flint_axe", "Flint Axe", "燧石斧");
        addLang("item", "flint_handaxe", "Flint Hand Axe", "燧石手斧");
        addLang("item", "flint_shovel", "Flint Shovel", "燧石锹");
        addLang("item", "flint_hoe", "Flint Hoe", "燧石锄");
        addLang("item", "stone_hammer", "Stone Hammer", "石锤");
        // 矿石
        addLang("item", "raw_graphite", "Raw Graphite", "粗石墨");
        addLang("block", "graphite_ore", "Graphite Ore", "石墨矿石");
        addLang("block", "deepslate_graphite_ore", "Deepslate Graphite Ore", "深层石墨矿石");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public static void addLang(String type, String itemID, String EN_US, String ZH_CN) {
        List<String> newList = new ArrayList<>();
        if (type == null) {
            newList.add(ElakeChemical.MODID + "." + itemID);
        } else {
            newList.add(type + "." + ElakeChemical.MODID + "." + itemID);
        }
        newList.add(EN_US);
        newList.add(ZH_CN);
        LIST.add(newList);
    }
}