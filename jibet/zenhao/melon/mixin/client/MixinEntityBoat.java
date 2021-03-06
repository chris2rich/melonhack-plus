package jibet.zenhao.melon.mixin.client;

import melon. Y.melon. 2;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityBoat.class})
public abstract class MixinEntityBoat {
   public Minecraft mc;

   @Shadow
   public abstract double func_70042_X();

   @Inject(
      method = {"applyOrientationToEntity"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void applyOrientationToEntity(Entity var1, CallbackInfo var2) {
      if ( 2.INSTANCE.isEnabled()) {
         var2.cancel();
      }

   }

   @Inject(
      method = {"controlBoat"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void controlBoat(CallbackInfo var1) {
      if ( 2.INSTANCE.isEnabled()) {
         var1.cancel();
      }

   }
}
