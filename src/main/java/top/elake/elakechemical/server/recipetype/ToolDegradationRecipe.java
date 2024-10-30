package top.elake.elakechemical.server.recipetype;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import top.elake.elakechemical.ElakeChemical;

import java.util.function.Supplier;

/**
 * @author Erhai-lake
 */
public class ToolDegradationRecipe implements Recipe<ToolDegradationInput> {
    private final BlockState inputState;
    private final Ingredient inputItem;
    private final ItemStack result;

    public ToolDegradationRecipe(BlockState inputState, Ingredient inputItem, ItemStack result) {
        this.inputState = inputState;
        this.inputItem = inputItem;
        this.result = result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    /**
     * 返回合成配方所需的输入物品
     *
     * @return 列表
     */
    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(this.inputItem);
        return list;
    }

    /**
     * 检查合成配方是否可以在指定大小的合成表中制作
     *
     * @param width  宽度
     * @param height 高度
     * @return 是否可以
     */
    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 4;
    }

    /**
     * 检查输入是否与配方匹配
     *
     * @param input 输入
     * @param level
     * @return 是否匹配
     */
    @Override
    public boolean matches(ToolDegradationInput input, @NotNull Level level) {
        return this.inputState == input.state() && this.inputItem.test(input.stack());
    }

    /**
     * 返回合成后的物品
     *
     * @param registries 注册
     * @return
     */
    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider registries) {
        return this.result;
    }

    /**
     * 组装合成后的物品
     *
     * @param input      输入
     * @param registries 注册
     * @return
     */
    @Override
    public @NotNull ItemStack assemble(@NotNull ToolDegradationInput input, HolderLookup.@NotNull Provider registries) {
        return this.result.copy();
    }

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, ElakeChemical.MODID);

    public static final Supplier<RecipeType<ToolDegradationRecipe>> RIGHT_CLICK_BLOCK =
            RECIPE_TYPES.register(
                    "right_click_block",
                    () -> RecipeType.<ToolDegradationRecipe>simple(ResourceLocation.fromNamespaceAndPath(ElakeChemical.MODID, "right_click_block"))
            );

    @Override
    public @NotNull RecipeType<?> getType() {
        return RIGHT_CLICK_BLOCK.get();
    }
}