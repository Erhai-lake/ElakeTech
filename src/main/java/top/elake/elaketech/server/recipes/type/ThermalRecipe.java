package top.elake.elaketech.server.recipes.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.ElakeTech;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Qi-Month
 */
public class ThermalRecipe implements Recipe<RecipeInput> {
    public static final ResourceLocation ID = ElakeTech.loadRes("thermal_power");
    private final ItemStack output;
    private final long energy;
    private final NonNullList<Ingredient> input;

    public static final MapCodec<ThermalRecipe> CODEC = RecordCodecBuilder.mapCodec((builder) -> builder.group(
                    ItemStack.CODEC.fieldOf("result").forGetter((e) -> e.output),
                    Codec.LONG.fieldOf("energy").forGetter((e) -> e.energy),
                    Ingredient.LIST_CODEC_NONEMPTY
                            .fieldOf("input")
                            .forGetter(e -> e.input))
            .apply(builder, ThermalRecipe::new));

    public ThermalRecipe(ItemStack output, long energy, List<Ingredient> ingredients) {
        this.output = output;
        this.energy = energy;
        this.input = NonNullList.of(Ingredient.EMPTY, ingredients.toArray(new Ingredient[0]));
    }

    /**
     * Type内部类，表示EnergizingRecipe的配方类型
     */
    public static class Type implements RecipeType<ThermalRecipe> {
        public static final Type INSTANCE = new Type();
        public static final ResourceLocation ID = ThermalRecipe.ID;

        private Type() {
        }
    }

    public static final StreamCodec<RegistryFriendlyByteBuf, ThermalRecipe> STREAM_CODEC = StreamCodec.composite(
            ItemStack.STREAM_CODEC,
            ThermalRecipe::getResultItem,
            ByteBufCodecs.VAR_LONG, ThermalRecipe::getEnergy,
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()),
            ThermalRecipe::getIngredients,
            ThermalRecipe::new
    );

    /**
     * Serializer内部类，用于定义如何序列化和反序列化EnergizingRecipe对象
     */
    public static class Serializer implements RecipeSerializer<ThermalRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public @NotNull MapCodec<ThermalRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, ThermalRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider registryAccess) {
        return this.output.copy();
    }

    @Override
    public boolean matches(RecipeInput inv, @NotNull Level world) {
        List<Ingredient> stacks = new ArrayList<>(getIngredients());
        for (int i = 1; i < inv.size(); i++) {
            ItemStack stack = inv.getItem(i);
            if (!stack.isEmpty()) {
                boolean flag = false;
                Iterator<Ingredient> itr = stacks.iterator();
                while (itr.hasNext()) {
                    Ingredient ingredient = itr.next();
                    if (ingredient.test(stack)) {
                        flag = true;
                        itr.remove();
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            }
        }
        return stacks.isEmpty();
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull RecipeInput recipeInput, HolderLookup.@NotNull Provider provider) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return false;
    }

    /**
     * 获取用于序列化此配方的RecipeSerializer
     *
     * @return
     */
    @Override
    public @NotNull RecipeSerializer<ThermalRecipe> getSerializer() {
        return ThermalRecipe.Serializer.INSTANCE;
    }

    /**
     * 获取此配方的类型
     *
     * @return
     */
    @Override
    public @NotNull RecipeType<?> getType() {
        return ThermalRecipe.Type.INSTANCE;
    }

    public ItemStack getResultItem() {
        return output;
    }

    /**
     * 获取进行合成所需的能量
     *
     * @return
     */
    public long getEnergy() {
        return this.energy;
    }

    /**
     * 获取合成所需的原材料列表
     */
    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return this.input;
    }

    /**
     * 表示这个配方是否特殊
     */
    @Override
    public boolean isSpecial() {
        return true;
    }
}