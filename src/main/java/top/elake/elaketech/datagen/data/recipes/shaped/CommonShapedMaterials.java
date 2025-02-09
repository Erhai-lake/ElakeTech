package top.elake.elaketech.datagen.data.recipes.shaped;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.register.block.CommonBlock;
import top.elake.elaketech.register.item.Materials;
import top.elake.elaketech.tag.ModItemTags;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;

/**
 * @author Qi-Month
 */
public class CommonShapedMaterials {
    public static void generateRecipes(RecipeOutput output) {
        String common = "crafting/shaped/materials/";

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CommonBlock.REFRACTORY_BRICKS)
                .pattern("AA")
                .pattern("AA")
                .define('A', Materials.REFRACTORY_BRICK)
                .unlockedBy("has_fire_brick", has(Materials.REFRACTORY_BRICK))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "refractory_bricks"));
        // 铁桶
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BUCKET)
                .pattern("A A")
                .pattern(" A ")
                .define('A', ModItemTags.Items.IRON_PLATE)
                .unlockedBy("has_iron_plate", has(ModItemTags.Items.IRON_PLATE))
                .save(output, ResourceLocation.fromNamespaceAndPath(ElakeTech.MODID, common + "bucket"));
    }
}