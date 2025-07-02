package top.elake.elaketech.event;

import net.neoforged.neoforge.common.NeoForge;

/**
 * @author Elake Studio
 */
public class Event {
    /**
     * 注册事件
     */
    public static void register() {
        // 非空手挖掘木头
        NoDiggingWood.register(NeoForge.EVENT_BUS);
        // 右键获取杂草
        RightClickGetGrassFiber.register(NeoForge.EVENT_BUS);
        // 使用燧石放置RockFlint方块
        PlaceRockFlintEvent.register(NeoForge.EVENT_BUS);

        Test.register(NeoForge.EVENT_BUS);
    }
}
