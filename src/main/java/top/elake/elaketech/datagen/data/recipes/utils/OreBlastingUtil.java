package top.elake.elaketech.datagen.data.recipes.utils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import top.elake.elaketech.ElakeTech;

import static top.elake.elaketech.datagen.data.recipes.utils.RecipesGeneratoresUtils.hasItem;

/**
 * @author Elake Studio
 */
public class OreBlastingUtil {
    static String smeltingPath = "smelting/materials/smelting/";
    static String blastingPath = "smelting/materials/blasting/";

    /**
     * 物品处理
     *
     * @param outputItem 输出物品
     * @param inputItem  输入物品
     */
    public static void addOreSmeltingRecipes(ItemLike outputItem, ItemLike inputItem, RecipeOutput output) {
        String getItemName = BuiltInRegistries.ITEM.getKey(outputItem.asItem()).getPath();

        // 判断输入是否为方块
        boolean isBlock = inputItem instanceof Block;
        if (isBlock) {
            getItemName = getItemName + "_ore_block";
        }

        // 熔炉配方
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(inputItem), RecipeCategory.MISC, outputItem.asItem(), 0.7f, 200)
                .unlockedBy("has_" + inputItem, hasItem(inputItem))
                .save(output, ElakeTech.loadResource(smeltingPath + getItemName));

        // 高炉配方
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(inputItem), RecipeCategory.MISC, outputItem.asItem(), 0.7f, 100)
                .unlockedBy("has_" + inputItem, hasItem(inputItem))
                .save(output, ElakeTech.loadResource(blastingPath + getItemName));
    }

    /**
     * 标签处理
     *
     * @param outputItem 输出物品
     * @param inputItem  输入物品
     */
    public static void addOreSmeltingRecipes(ItemLike outputItem, TagKey<Item> inputItem, RecipeOutput output) {
        String getItemName = BuiltInRegistries.ITEM.getKey(outputItem.asItem()).getPath();

        // 如果 tag 名里包含 "ores", 加上 _ore_block
        String tagLocation = inputItem.location().getPath();
        if (tagLocation.contains("ores")) {
            getItemName = getItemName + "_ore_block";
        }

        // 熔炉配方
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(inputItem), RecipeCategory.MISC, outputItem.asItem(), 0.7f, 200)
                .unlockedBy("has_" + inputItem, hasItem(inputItem))
                .save(output, ElakeTech.loadResource(smeltingPath + getItemName));

        // 高炉配方
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(inputItem), RecipeCategory.MISC, outputItem.asItem(), 0.7f, 100)
                .unlockedBy("has_" + inputItem, hasItem(inputItem))
                .save(output, ElakeTech.loadResource(blastingPath + getItemName));
    }
}