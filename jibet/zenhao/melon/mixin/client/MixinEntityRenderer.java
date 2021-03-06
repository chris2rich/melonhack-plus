package jibet.zenhao.melon.mixin.client;

import com.google.common.base.Predicate;
import java.util.ArrayList;
import java.util.List;
import melon. 0c.melon. 8;
import melon. 0c.melon. A;
import melon. 0c.melon. y;
import melon. 0c.melon. z;
import melon. 1.melon. 0;
import melon. 9.melon. B;
import melon. Z.melon. f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {EntityRenderer.class},
   priority = 9999
)
public abstract class MixinEntityRenderer {
   private boolean injection = (int)(1405550269L & 1908724287L) ^ (int)((long)-1898624278 ^ (long)-1700495771) << 2;
   @Shadow
   public ItemStack field_190566_ab;
   @Shadow
   @Final
   public Minecraft field_78531_r;
   private boolean nightVision = (int)((long)((int)685218679L ^ 1272082642) ^ (long)((int)((long)-473626437 ^ (long)-2134842594)));

   @Shadow
   public abstract void func_78473_a(float var1);

   @Inject(
      method = {"renderItemActivation"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void renderItemActivationHook(CallbackInfo var1) {
      if (this.field_190566_ab != null &&  z.getInstance().isEnabled() && (Boolean) z.getInstance().totemPops.getValue() && this.field_190566_ab.func_77973_b() == Items.field_190929_cY) {
         var1.cancel();
      }

   }

   @Inject(
      method = {"updateLightmap"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void updateLightmap(float var1, CallbackInfo var2) {
      if ( z.getInstance().isEnabled() && ( z.getInstance().skylight.getValue() ==  A.ENTITY ||  z.getInstance().skylight.getValue() ==  A.ALL)) {
         var2.cancel();
      }

   }

   @Inject(
      method = {"updateLightmap"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void updateLightmap2(float var1, CallbackInfo var2) {
       B var3 = new  B(var1);
       0.EVENT_BUS.post(var3);
      if (var3.isCancelled()) {
         var2.cancel();
      }

   }

   @Inject(
      method = {"hurtCameraEffect"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void hurtCameraEffect(float var1, CallbackInfo var2) {
      if ( y.shouldDisable()) {
         var2.cancel();
      }

   }

   @Redirect(
      method = {"getMouseOver"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/multiplayer/WorldClient;getEntitiesInAABBexcluding(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;"
)
   )
   public List<Entity> getEntitiesInAABBexcluding(WorldClient var1, Entity var2, AxisAlignedBB var3, Predicate var4) {
      return (List)( f.shouldBlock() ? new ArrayList() : var1.func_175674_a(var2, var3, var4));
   }

   @Redirect(
      method = {"orientCamera"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/multiplayer/WorldClient;rayTraceBlocks(Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;)Lnet/minecraft/util/math/RayTraceResult;"
),
      expect = 0
   )
   private RayTraceResult rayTraceBlocks(WorldClient var1, Vec3d var2, Vec3d var3) {
      melon. 9.melon. z var4 = new melon. 9.melon. z();
       0.EVENT_BUS.post(var4);
      return var4.isCancelled() ? null : var1.func_72933_a(var2, var3);
   }

   @ModifyVariable(
      method = {"orientCamera"},
      ordinal = 3,
      at = @At(
   value = "STORE",
   ordinal = 0
),
      require = 1
   )
   public double changeCameraDistanceHook(double var1) {
      return  8.getInstance().isEnabled() && (Boolean) 8.getInstance().extend.getValue() ? (Double) 8.getInstance().distance.getValue() : var1;
   }

   @ModifyVariable(
      method = {"orientCamera"},
      ordinal = 7,
      at = @At(
   value = "STORE",
   ordinal = 0
),
      require = 1
   )
   public double orientCameraHook(double var1) {
      return  8.getInstance().isEnabled() && (Boolean) 8.getInstance().extend.getValue() ? (Double) 8.getInstance().distance.getValue() : ( 8.getInstance().isEnabled() && !(Boolean) 8.getInstance().extend.getValue() ? Double.longBitsToDouble((long)((int)((long)165435066 ^ (long)199174143) << 1) ^ 4616189618181564334L & 4616189618392851083L) : var1);
   }
}
