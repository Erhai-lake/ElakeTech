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
        I18n.addList("itemGroup", "all", "ElakeChemical - All", "洱海化学 - 全部");
        I18n.addList("itemGroup", "element", "ElakeChemical - Elements", "洱海化学 - 元素");
        I18n.addList("itemGroup", "tool", "ElakeChemical - Tool", "洱海化学 - 工具");
        I18n.addList("itemGroup", "sundries", "ElakeChemical - Sundries", "洱海化学 - 杂项");
        I18n.addList("itemGroup", "materials", "ElakeChemical - Materials", "洱海化学 - 材料");
        // 画
        I18n.addList("painting", "periodic_table_of_elements.title", "Periodic table of elements", "化学元素周期表");
        I18n.addList("painting", "periodic_table_of_elements.author", "Дми́трий Ива́нович Менделе́ев/Elake", "德米特里·伊万诺维奇·门捷列夫/Elake");
        // 书
        I18n.addList(null, "patchouli.book.name", "EC Manual", "EC手册");
        I18n.addList(null, "patchouli.book.landing", "EC Complete Reference Guide$(br2)(Content under development, please refer to the official release for actual content)", "EC完整参考指南$(br2)(开发中内容,实际内容请以正式上线为准)");
        // 元素
        for (String element : Elements.ELEMENTS_ITEM_ARR) {
            I18n.addList("item", element, element, element);
        }
        // 材料
        I18n.addList("item", "grass_fiber", "Grass Fiber", "草纤维");
        I18n.addList("item", "grass_string", "Grass String", "草绳");
        I18n.addList("item", "copper_plate", "Copper Plate", "铜板");
        I18n.addList("item", "copper_wire", "Copper Wire", "铜线");
        I18n.addList("item", "simple_copper_single_solenoid", "Simple Copper Single Solenoid", "铜简易单闸线圈");
        I18n.addList("item", "graphite", "Graphite", "石墨");
        // 工具
        I18n.addList("item", "flint_sword", "Flint Sword", "燧石剑");
        I18n.addList("item", "flint_pickaxe", "Flint Pickaxe", "燧石镐");
        I18n.addList("item", "flint_axe", "Flint Axe", "燧石斧");
        I18n.addList("item", "flint_handaxe", "Flint Handaxe", "燧石手斧");
        I18n.addList("item", "flint_shovel", "Flint Shovel", "燧石锹");
        I18n.addList("item", "flint_hoe", "Flint Hoe", "燧石锄");
        I18n.addList("item", "stone_hammer", "Stone Hammer", "石锤");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addList(String type, String name, String nameEn, String nameZh) {
        List<String> newList = new ArrayList<>();
        if (type == null) {
            newList.add(ElakeChemical.MODID + "." + name);
        } else {
            newList.add(type + "." + ElakeChemical.MODID + "." + name);
        }
        newList.add(nameEn);
        newList.add(nameZh);
        LIST.add(newList);
    }
}
