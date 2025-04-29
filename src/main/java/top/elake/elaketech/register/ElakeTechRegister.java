package top.elake.elaketech.register;

import net.neoforged.bus.api.IEventBus;
import top.elake.elaketech.register.block.*;
import top.elake.elaketech.register.item.ores.Ingots;
import top.elake.elaketech.register.item.materials.Materials;
import top.elake.elaketech.register.item.ores.OreItem;
import top.elake.elaketech.register.item.ores.Plates;
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
        // 锭
        Ingots.register();
        // 板
        Plates.register();
        // 粗矿
        OreItem.register();
        // 矿石方块
        OreBlock.register();
        // 方块
        CommonBlock.registers();
        // 创造模式物品栏(必须最后)
        ElakeTechCreativeModeTabs.register(event);
    }
}
