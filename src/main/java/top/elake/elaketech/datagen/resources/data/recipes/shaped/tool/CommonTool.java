package top.elake.elaketech.datagen.resources.data.recipes.shaped.tool;

import blusunrize.immersiveengineering.common.register.IEItems;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class CommonTool {
    public static void generateRecipes(RecipeOutput fileOutput) {
        String common = "crafting/shaped/tool/";
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IEItems.Tools.HAMMER)
                .pattern(" AB")
                .pattern(" CA")
                .pattern("C  ")
                .define('A', Tags.Items.INGOTS_COPPER)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_copper_ingots", has(Tags.Items.INGOTS_COPPER))
                .save(fileOutput, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "hammer"));
    }
}