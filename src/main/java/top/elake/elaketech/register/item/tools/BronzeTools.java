package top.elake.elaketech.register.item.tools;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import top.elake.elaketech.register.ElakeTechCreativeModeTabs;
import top.elake.elaketech.util.tools.ToolBuilder;
import top.elake.elaketech.util.tools.ToolType;

import java.util.Objects;

import static top.elake.elaketech.ElakeTech.REGISTER;

public class BronzeTools {
    public static void register() {
    }

    static {
        REGISTER.defaultCreativeTab(Objects.requireNonNull(ElakeTechCreativeModeTabs.TOOLS_TAB.getKey()));
    }

    /**
     * 剑
     */
    public static final ItemEntry<? extends Item> BRONZE_SWORD = new ToolBuilder()
            .id("bronze_sword")
            .type(ToolType.SWORD)
            .tier(ElakeTechTiers.BRONZE_TIER)
            .property(5, -2.4f)
            .color(0xFFC370)
            .texture("tools/color/sword/head")
            .texture("tools/color/sword/handle")
            .build();
}