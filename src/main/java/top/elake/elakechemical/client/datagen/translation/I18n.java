package top.elake.elakechemical.client.datagen.translation;

import top.elake.elakechemical.ElakeChemical;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake
 */
public class I18n {
    public static void registers() {
        // 材料
        I18n.addList("item", "grass_fiber", "Grass Fiber", "草纤维");
        I18n.addList("item", "grass_string", "Grass String", "草绳");
        I18n.addList("item", "copper_plate", "Copper Plate", "铜板");
        I18n.addList("item", "copper_wire", "Copper Wire", "铜线");
        I18n.addList("item", "simple_copper_single_solenoid", "Simple Copper Single Solenoid", "铜简易单闸线圈");
        I18n.addList("item", "graphite", "Graphite", "石墨");
    }
    public static final List<List<String>> LIST = new ArrayList<>();
    public static void addList(String type, String name, String nameEn, String nameZh) {
        List<String> newList = new ArrayList<>();
        newList.add(type + "." + ElakeChemical.MODID + "." + name);
        newList.add(nameEn);
        newList.add(nameZh);
        LIST.add(newList);
    }
}
