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
        Tooltip.registers();
        // 材料
        Materials.registers();
        // 工具
        Tools.registers();
        // 矿物
        Metals.registers();
        // 方块
        CommonBlock.registers();
        // 功能性方块
        FunctionBlock.registers();
        // 机器方块
        MachineBlock.registers();
    }

    /**
     * 翻译列表
     */
    public static final List<List<String>> LIST = new ArrayList<>();

    /**
     * 添加翻译
     * @param type 类型
     * @param key 物品id
     * @param english 英文
     * @param chinese 中文
     */
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public static void addLanguage(String type, String key, String english, String chinese) {
        List<String> newList = new ArrayList<>();
        if (type == null) {
            newList.add(MODID + "." + key);
        } else {
            newList.add(type + "." + MODID + "." + key);
        }
        newList.add(english);
        newList.add(chinese);
        LIST.add(newList);
    }
}