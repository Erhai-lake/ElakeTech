package top.elake.elakechemical.client.datagen.translation;

import top.elake.elakechemical.ElakeChemical;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake
 */
public class I18n {
    public static final List<List<String>> LIST = new ArrayList<>();

    public static void addList(String type, String name, String nameEn, String nameZh) {
        List<String> newList = new ArrayList<>();
        newList.add(type + "." + ElakeChemical.MODID + "." + name);
        newList.add(nameEn);
        newList.add(nameZh);
        LIST.add(newList);
    }
}
