package top.elake.elaketech.datagen.assets.translation;

import top.elake.elaketech.ElakeTech;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Erhai-lake Qi-Month
 */
public class Common {
    public static void registers() {
        // 进度
        addLanguage("advancements", "main.root.description", "Welcome to the Elake Tech", "欢迎来到洱海科技");
        addLanguage("advancements", "main.root.title", "Elake Tech", "洱海科技");

        // 画
        addLanguage("painting", "periodic_table_of_elements.title", "Periodic table of elements", "化学元素周期表");
        addLanguage("painting", "periodic_table_of_elements.author", "Дми́трий Ива́нович Менделе́ев/Elake", "德米特里·伊万诺维奇·门捷列夫/Elake");
        // 书
        addLanguage(null, "patchouli.book.name", "E-T Manual", "E-T手册");
        addLanguage(null, "patchouli.book.landing", "E-T Complete Reference Guide", "E-T完整参考指南");

        // 金属板

        // 工具
        addLanguage("item", "stone_hammer", "Stone Hammer", "石锤");

        addLanguage("item", "flint_sword", "Flint Sword", "燧石剑");
        addLanguage("item", "flint_pickaxe", "Flint Pickaxe", "燧石镐");
        addLanguage("item", "flint_axe", "Flint Axe", "燧石斧");
        addLanguage("item", "flint_hatchet", "Flint Hatchet", "燧石手斧");
        addLanguage("item", "flint_shovel", "Flint Shovel", "燧石锹");
        addLanguage("item", "flint_hoe", "Flint Hoe", "燧石锄");

        addLanguage("item", "bronze_sword", "Bronze Sword", "青铜剑");
        addLanguage("item", "bronze_pickaxe", "Bronze Pickaxe", "青铜镐");
        addLanguage("item", "bronze_axe", "Bronze Axe", "青铜斧");
        addLanguage("item", "bronze_shovel", "Bronze Shovel", "青铜锹");
        addLanguage("item", "bronze_hoe", "Bronze Hoe", "青铜锄");
        addLanguage("item", "bronze_hammer", "Bronze Hammer", "青铜锤");

        //方块
        addLanguage("block", "alcohol_lamp", "Alcohol Lamp", "酒精灯");
        addLanguage("block", "dolostone", "Dolostone", "白云岩");
        addLanguage("block", "kaolin", "Kaolin", "高岭土");
        addLanguage("block", "refractory_bricks", "Refractory Bricks", "耐火砖块");

        // 化学用具
        addLanguage("item", "asbestos_net", "Asbestos Net", "石棉网");

        // Info
        addLanguage("info", "metal_detector", "Ore not found!", "未找到矿石!");
        addLanguage("info", "metal_detector_2", "[%s, %s, %s] have %s ", "在[%s, %s, %s]找到 %s");

        // Tooltip
        addLanguage("tooltip", "wet_refractory_brick", "Pinch your~~", "捏捏你的");

        // JEI Info
        addLanguage("jei.info", "grass_fiber", "R-Click grass has a chance to obtain", "右键草有几率获得");
        addLanguage("jei.info", "flint", "Can be found on the ground\nDig dirt and sand also have a chance to fall", "可以在地上找到\n挖掘泥土和沙子也有几率掉落");
    }

    public static final List<List<String>> LIST = new ArrayList<>();

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public static void addLanguage(String type, String id, String EN, String ZH) {
        List<String> newList = new ArrayList<>();
        if (type == null) {
            newList.add(ElakeTech.MODID + "." + id);
        } else {
            newList.add(type + "." + ElakeTech.MODID + "." + id);
        }
        newList.add(EN);
        newList.add(ZH);
        LIST.add(newList);
    }
}