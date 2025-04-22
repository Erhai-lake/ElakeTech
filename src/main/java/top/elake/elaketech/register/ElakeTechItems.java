package top.elake.elaketech.register;

import top.elake.elaketech.register.item.materials.Materials;
import top.elake.elaketech.register.item.tools.Tools;

/**
 * @author Elake Studio
 */
public class ElakeTechItems {
    /**
     * 注册物品
     */
    public static void register() {
        // 材料
        Materials.register();
        // 工具
        Tools.register();
    }
}
