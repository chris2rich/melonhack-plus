package jibet.zenhao.melon.mixin.client;

import melon. Q.melon. 5;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Frustum.class})
public abstract class MixinFrustum {
   @Inject(
      method = {"Lnet/minecraft/client/renderer/culling/Frustum;isBoundingBoxInFrustum(Lnet/minecraft/util/math/AxisAlignedBB;)Z"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void isBoundingBoxEtc(AxisAlignedBB var1, CallbackInfoReturnable<Boolean> var2) {
      if ( 5.isModuleEnabled("Freecam")) {
         var2.setReturnValue(Boolean.valueOf((boolean)((int)((long)((int)-526135474L ^ 13424770) ^ (long)((int)-1725521638L ^ 2034874071)))));
      }

   }
}
