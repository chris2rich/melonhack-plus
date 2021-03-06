package jibet.zenhao.melon.mixin.client;

import melon. 1.melon. 0;
import melon. 9.melon. 1;
import melon. 9.melon. 6;
import melon. 9.melon. 9;
import melon. 9.melon. h;
import melon. 9.melon. j;
import melon. 9.melon. o;
import melon. Q.melon. 5;
import melon. Z.melon. p;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({PlayerControllerMP.class})
public abstract class MixinPlayerControllerMP {
   @Shadow
   public abstract void func_78750_j();

   @Inject(
      method = {"onPlayerDamageBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onPlayerDamageBlock2(BlockPos var1, EnumFacing var2, CallbackInfoReturnable<Boolean> var3) {
       o var4 = new  o(var1, var2);
       0.EVENT_BUS.post(var4);
      if (var4.isCancelled()) {
         var3.setReturnValue(Boolean.valueOf((boolean)((int)(1590570491L & 1859915258L) ^ (int)((long)132885744 ^ (long)546155021) << 1)));
         var3.cancel();
      }

   }

   @Inject(
      method = {"onPlayerDamageBlock(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)Z"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onPlayerDamageBlock1(BlockPos var1, EnumFacing var2, CallbackInfoReturnable<Boolean> var3) {
       9 var4 = new  9(var1, var2);
       0.EVENT_BUS.post(var4);
      if (var4.isCancelled()) {
         var3.setReturnValue(Boolean.valueOf((boolean)((int)((long)((int)2118202014L ^ -739215657) ^ (long)((int)((long)1655511970 ^ (long)-820224021))))));
      }

   }

   @Inject(
      method = {"onPlayerDamageBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onPlayerDamageBlock(BlockPos var1, EnumFacing var2, CallbackInfoReturnable<Boolean> var3) {
       j var4 = new  j(var1, var2);
       0.EVENT_BUS.post(var4);
      if (var4.isCancelled()) {
         var3.setReturnValue(Boolean.valueOf((boolean)((int)(731641335L & 1805349365L) ^ (int)1887524471L ^ 1528440706)));
         var3.cancel();
      }

       h var5 = new  h((int)((long)(((int)-2146215074L ^ -2045617623) << 3) ^ (long)((int)1477684842L ^ 1746642387)) << ((int)((long)250433943 ^ (long)250433942) << 1), var1, var2);
       0.EVENT_BUS.post(var5);
   }

   @Inject(
      method = {"clickBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void clickBlockHook(BlockPos var1, EnumFacing var2, CallbackInfoReturnable<Boolean> var3) {
       h var4 = new  h((int)((long)((int)1745370715L ^ -1758135747) ^ (long)((int)((long)542067933 ^ (long)-546076488))), var1, var2);
       0.EVENT_BUS.post(var4);
   }

   @Inject(
      method = {"attackEntity"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void attackEntity(EntityPlayer var1, Entity var2, CallbackInfo var3) {
      if (var2 != null) {
         if (var2 instanceof EntityPlayerSP) {
             6 var4 = new  6(var2);
             0.EVENT_BUS.post(var4);
            if (var4.isCancelled()) {
               var3.cancel();
            }
         }

      }
   }

   @Inject(
      method = {"extendedReach"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void reachHook(CallbackInfoReturnable<Boolean> var1) {
      if ( p.isEnable()) {
         var1.setReturnValue(Boolean.valueOf((boolean)((int)(-1141482510L & -1829254158L) ^ (int)((long)-547594244 ^ (long)1302991887))));
         var1.cancel();
      }

   }

   @Inject(
      method = {"getBlockReachDistance"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void getReachDistanceHook(CallbackInfoReturnable<Float> var1) {
      if ( p.isEnable()) {
         var1.setReturnValue( p.getReach());
         var1.cancel();
      }

   }

   @Inject(
      method = {"onStoppedUsingItem"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onStoppedUsingItem(EntityPlayer var1, CallbackInfo var2) {
      if (var1.func_184586_b(var1.func_184600_cs()).func_77973_b() instanceof ItemFood) {
          5 var10000 =  0.moduleManager;
         if ( 5.isModuleEnabled("PacketEat")) {
            this.func_78750_j();
            var1.func_184597_cx();
            var2.cancel();
         }
      }

   }

   @Inject(
      method = {"clickBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void clickBlockHook2(BlockPos var1, EnumFacing var2, CallbackInfoReturnable<Boolean> var3) {
       1 var4 = new  1((int)(-548878624L & -806824094L) ^ (int)1935701577L ^ -1138184150, var1, var2);
      MinecraftForge.EVENT_BUS.post(var4);
   }

   @Inject(
      method = {"onPlayerDamageBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onPlayerDamageBlockHook(BlockPos var1, EnumFacing var2, CallbackInfoReturnable<Boolean> var3) {
       1 var4 = new  1((int)((long)((int)((long)-866083141 ^ (long)-991874846) << 2) ^ (long)((int)614376285L ^ 110631480)) << (((int)-1213749484L ^ -1213749483) << 1), var1, var2);
      MinecraftForge.EVENT_BUS.post(var4);
   }
}
