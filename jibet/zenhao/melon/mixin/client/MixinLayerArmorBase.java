package jibet.zenhao.melon.mixin.client;

import melon. 0c.melon. 0;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LayerArmorBase.class})
public abstract class MixinLayerArmorBase {
   @Inject(
      method = {"renderArmorLayer"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onRenderArmorLayer(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, EntityEquipmentSlot var9, CallbackInfo var10) {
      if ( 0.INSTANCE.isEnabled()) {
         if (!(Boolean) 0.INSTANCE.player.getValue() && var1 instanceof EntityPlayer) {
            if (! 0.shouldRenderPiece(var9)) {
               var10.cancel();
            }
         } else if (!(Boolean) 0.INSTANCE.armourstand.getValue() && var1 instanceof EntityArmorStand) {
            if (! 0.shouldRenderPiece(var9)) {
               var10.cancel();
            }
         } else if (!(Boolean) 0.INSTANCE.mobs.getValue() && var1 instanceof EntityMob && ! 0.shouldRenderPiece(var9)) {
            var10.cancel();
         }
      }

   }
}
