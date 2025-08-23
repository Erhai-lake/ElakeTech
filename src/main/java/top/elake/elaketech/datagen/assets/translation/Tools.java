package top.elake.elaketech.datagen.assets.translation;

/**
 * @author Elake Studio
 */
public class Tools {
    /**
     * 注册材料翻译
     */
    public static void registers() {
        Translation.addLanguage("item", "flint_sword", "Flint Sword", "燧石剑");
        Translation.addLanguage("item", "flint_pickaxe", "Flint Pickaxe", "燧石镐");
        Translation.addLanguage("item", "flint_axe", "Flint Axe", "燧石斧");
        Translation.addLanguage("item", "flint_hatchet", "Flint Hatchet", "燧石手斧");
        Translation.addLanguage("item", "flint_shovel", "Flint Shovel", "燧石锹");
        Translation.addLanguage("item", "flint_hoe", "Flint Hoe", "燧石锄");

        Translation.addLanguage("item", "metal_detector", "Basic Metal Detector", "基础金属探测仪");
        Translation.addLanguage("item", "metal_detector_t2", "Advanced Metal Detector", "高级金属探测仪");
        Translation.addLanguage("item", "metal_detector_t3", "Elite Metal Detector", "精英金属探测仪");
    }
}