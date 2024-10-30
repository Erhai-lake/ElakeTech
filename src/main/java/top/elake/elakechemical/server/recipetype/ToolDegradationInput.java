package top.elake.elakechemical.server.recipetype;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/**
 * @author Erhai-lake
 */
public record ToolDegradationInput(BlockState state, ItemStack stack) implements RecipeInput {
    @Override
    public @NotNull ItemStack getItem(int slot) {
        if (slot != 0) {
            throw new IllegalArgumentException("No item for index " + slot);
        }
        return this.stack();
    }

    @Override
    public int size() {
        return 1;
    }
}
