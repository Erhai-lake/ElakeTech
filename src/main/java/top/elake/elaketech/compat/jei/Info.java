package top.elake.elaketech.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.item.Materials;

/**
 * @author Qi-Month
 */
@JeiPlugin
public class Info implements IModPlugin {
    static ResourceLocation PLUGIN = ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, "plugin");

    private IRecipeRegistration registry;

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return PLUGIN;
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registry) {
        this.registry = registry;
        addInfo(new ItemStack(Materials.GRASS_FIBER.get()), "jei.info.elake_tech.grass_fiber");
    }

    public void addInfo(ItemStack item, String key) {
        if (registry != null) {
            registry.addIngredientInfo(item, VanillaTypes.ITEM_STACK, Component.translatable(key));
        }
    }
}