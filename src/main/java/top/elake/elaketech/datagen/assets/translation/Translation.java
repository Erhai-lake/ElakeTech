package top.elake.elaketech.datagen.assets.translation;

import java.util.ArrayList;
import java.util.List;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author Elake Studio
 */
public class Translation {
    /**
     * 注册翻译
     */
    public static void registers() {
        // 创造模式物品栏
        CreativeModeTab.registers();
        // 工具提示
        TooltipLanguage.registers();
        // 材料
        Materials.registers();
    }

    /**
     * 翻译列表
     */
    public static final List<List<String>> LIST = new ArrayList<>();

    /**
     * 添加翻译
     * @param type 类型
     * @param id 物品id
     * @param EN 英文
     * @param ZH 中文
     */
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public static void addLanguage(String type, String id, String EN, String ZH) {
        List<String> newList = new ArrayList<>();
        if (type == null) {
            newList.add(MODID + "." + id);
        } else {
            newList.add(type + "." + MODID + "." + id);
        }
        newList.add(EN);
        newList.add(ZH);
        LIST.add(newList);
    }
}
