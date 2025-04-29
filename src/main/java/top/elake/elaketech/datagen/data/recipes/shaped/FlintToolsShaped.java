package top.elake.elaketech.datagen.data.recipes.shaped;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.neoforged.neoforge.common.Tags;
import top.elake.elaketech.register.item.tools.FlintTools;
import top.elake.elaketech.tag.ModItemTags;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;
import static top.elake.elaketech.ElakeTech.loadResource;

/**
 * @author Elake Studio
 */
public class FlintToolsShaped {
    /**
     * 工具有序合成配方
     *
     * @param output 输出
     */
    public static void register(RecipeOutput output) {
        String flint = "crafting/shaped/tools/flint/";
        // 剑
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FlintTools.FLINT_SWORD)
                .pattern(" A ")
                .pattern("BAB")
                .pattern(" C ")
                .define('A', ModItemTags.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.FLINT))
                .save(output, loadResource( flint + "sword"));
        // 镐
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FlintTools.FLINT_PICKAXE)
                .pattern("ABA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItemTags.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.FLINT))
                .save(output, loadResource( flint + "pickaxe"));
        // 斧
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FlintTools.FLINT_AXE)
                .pattern("AB")
                .pattern("AC")
                .pattern(" C")
                .define('A', ModItemTags.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.FLINT))
                .save(output, loadResource( flint + "axe"));
        // 手符
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FlintTools.FLINT_HATCHET)
                .pattern("AB")
                .pattern(" C")
                .define('A', ModItemTags.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.FLINT))
                .save(output, loadResource( flint + "hatchet"));
        // 铲
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FlintTools.FLINT_SHOVEL)
                .pattern("A")
                .pattern("B")
                .pattern("C")
                .define('A', ModItemTags.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.FLINT))
                .save(output, loadResource( flint + "shovel"));
        // 锄
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FlintTools.FLINT_HOE)
                .pattern("AB")
                .pattern(" C")
                .pattern(" C")
                .define('A', ModItemTags.FLINT)
                .define('B', Tags.Items.STRINGS)
                .define('C', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_flint", has(ModItemTags.FLINT))
                .save(output, loadResource( flint + "hoe"));
    }
}
