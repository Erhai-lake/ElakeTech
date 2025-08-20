package top.elake.elaketech.register.block.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec2;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.register.block.entity.function.DryRackBlockEntity;

/**
 * @author Elake Studio
 */
public class DryRackBlockEntityRender implements BlockEntityRenderer<DryRackBlockEntity> {
    public DryRackBlockEntityRender(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(@NotNull DryRackBlockEntity entity, float partialTicks, @NotNull PoseStack stack, @NotNull MultiBufferSource source, int combinedLight, int icombinedoverLay) {
        Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        ItemStackHandler inventory = entity.getInventory();
        int posLong = (int) entity.getBlockPos().asLong();
        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if (!itemStack.isEmpty()) {
                stack.pushPose();
                stack.translate(0.5, 0.5625, 0.5);
                float f = -direction.toYRot();
                stack.mulPose(Axis.YP.rotationDegrees(f));
                stack.mulPose(Axis.XP.rotationDegrees(90f));
                Vec2 itemOffset = entity.getItemOffset(i);
                stack.translate(itemOffset.x, itemOffset.y, 0.0);
                stack.scale(0.285f, 0.285f, 0.285f);

                if (entity.getLevel() != null) {
                    // 光照值
                    int lightLevel = LevelRenderer.getLightColor(entity.getLevel(), entity.getBlockPos().above());

                    Minecraft.getInstance().getItemRenderer().renderStatic(
                            itemStack,
                            ItemDisplayContext.FIXED,
                            lightLevel,
                            icombinedoverLay,
                            stack,
                            source,
                            entity.getLevel(),
                            posLong + i
                    );
                }
                stack.popPose();
            }
        }
    }
}