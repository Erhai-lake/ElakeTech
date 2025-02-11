package top.elake.elaketech.register;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.client.menu.ThermalMenu;

import java.util.function.Supplier;

/**
 * @author Qi-Month
 */
public class ModMenuType {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(BuiltInRegistries.MENU, ElakeTech.MODID);

    public static final Supplier<MenuType<ThermalMenu>> THERMAL_MENU =
            MENU_TYPES.register("thermal",
                    () -> IMenuTypeExtension.create(ThermalMenu::new));
}