package top.elake.elaketech.register.item.tools;

/**
 * @author Elake Studio
 */
public class Tools {
    /**
     * 注册工具
     */
    public static void register() {
        // 功能
        FunctionTool.register();
        // 燧石
        FlintTools.register();
        // 青铜
        BronzeTools.register();
    }
}
