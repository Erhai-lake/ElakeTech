package top.elake.elaketech.event;

import net.neoforged.neoforge.common.NeoForge;
import top.elake.elaketech.datagen.assets.translation.Translation;

/**
 * @author Elake Studio
 */
public class Event {
    /**
     * 注册事件
     */
    public static void register() {
        // 翻译
        Translation.registers();
        // 非空手挖掘木头
        NoDiggingWood.register(NeoForge.EVENT_BUS);
        // 右键获取杂草
        RightClickGetGrassFiber.register(NeoForge.EVENT_BUS);
    }
}
