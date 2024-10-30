package top.elake.elakechemical.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.world.entity.projectile.FishingHook.class)
public class OpenWater {
    @Inject(method = {"isOpenWaterFishing", "calculateOpenWater"}, at = @At("RETURN"), cancellable = true)
    public void openWater(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}