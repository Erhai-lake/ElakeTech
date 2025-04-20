package top.elake.elaketech.register;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import top.elake.elaketech.register.item.ETItems;

import static top.elake.elaketech.ElakeTech.REGISTRATE;

/**
 * @author Erhai-lake
 */
public class ETCreativeTabs {
//    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> TEST_TAB = REGISTRATE.defaultCreativeTab("test_tab",
//            (c) -> {
//                c.icon(() -> new ItemStack(ETItems.TEST.asItem()));
//            }).register();

    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> TEST_TAB = REGISTRATE
            .defaultCreativeTab("test_tab", (builder) -> builder
                    .title(Component.literal("测试物品栏"))
                    .icon(() -> new ItemStack(ETItems.TEST.asItem())))
            .register();

    public static void register() {
    }
}