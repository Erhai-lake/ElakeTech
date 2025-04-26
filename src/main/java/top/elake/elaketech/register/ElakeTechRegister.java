package top.elake.elaketech.register;

import net.neoforged.bus.api.IEventBus;
import top.elake.elaketech.register.item.ores.Ingots;
import top.elake.elaketech.register.item.materials.Materials;
import top.elake.elaketech.register.item.tools.Tools;

/**
 * @author Elake Studio
 */
public class ElakeTechRegister {
    /**
     * 注册物品
     */
    public static void register(IEventBus event) {
        // 材料
        Materials.register();
        // 工具
        Tools.register();
        // 矿物
        Ingots.register();
        // 创造模式物品栏(必须最后)
        ElakeTechCreativeModeTabs.register(event);
    }
}
