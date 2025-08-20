package top.elake.elaketech.datagen.assets.translation;

/**
 * @author Elake Studio
 */
public class CreativeModeTab {
    /**
     * 注册物品栏翻译
     */
    public static void registers() {
        Translation.addLanguage("itemGroup", "materials_tab", "ElakeTech Materials", "洱海科技-材料");
        Translation.addLanguage("itemGroup", "tools_tab", "ElakeTech Tools", "洱海科技-工具");
        Translation.addLanguage("itemGroup", "common_blocks_tab", "ElakeTech Blocks", "洱海科技-方块");
        Translation.addLanguage("itemGroup", "function_blocks_tab", "ElakeTech Function Blocks", "洱海科技-功能性方块");
    }
}