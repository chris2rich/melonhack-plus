package jibet.zenhao.melon.mixin.client;

import melon. 9.melon. M;
import melon. K.melon. 1;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.MoverType;
import net.minecraft.util.MovementInput;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
   value = {EntityPlayerSP.class},
   priority = 9999
)
public class MixinEntityPlayerSP extends MixinAbstractClientPlayer implements  1 {
   @Shadow
   @Final
   public NetHandlerPlayClient field_71174_a;
   @Shadow
   private float field_175164_bL;
   @Shadow
   private float field_175165_bM;
   @Shadow
   public MovementInput field_71158_b;
   @Shadow
   private double field_175172_bI;
   @Shadow
   private double field_175166_bJ;
   @Shadow
   private double field_175167_bK;
   @Shadow
   private int field_175168_bP;
   @Shadow
   protected Minecraft field_71159_c;
   @Shadow
   private boolean field_184844_co;
   @Shadow
   private boolean field_175171_bO;
   @Shadow
   private boolean field_175170_bN;
   @Shadow
   private boolean field_184841_cd;
   @Shadow
   private boolean field_189811_cr;
   private double cachedX;
   private double cachedY;
   private double cachedZ;
   private float cachedRotationPitch;
   private float cachedRotationYaw;
   private boolean cachedMoving;
   private boolean cachedOnGround;
   private  M motionEvent;

   public MixinEntityPlayerSP() {
      // $FF: Couldn't be decompiled
   }

   @Redirect(
      method = {"onLivingUpdate"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/entity/EntityPlayerSP;closeScreen()V"
)
   )
   public void closeScreen(EntityPlayerSP param1) {
      // $FF: Couldn't be decompiled
   }

   @Redirect(
      method = {"onLivingUpdate"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/Minecraft;displayGuiScreen(Lnet/minecraft/client/gui/GuiScreen;)V"
)
   )
   public void closeScreen(Minecraft param1, GuiScreen param2) {
      // $FF: Couldn't be decompiled
   }

   @Redirect(
      method = {"move"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/entity/AbstractClientPlayer;move(Lnet/minecraft/entity/MoverType;DDD)V"
)
   )
   public void move(AbstractClientPlayer param1, MoverType param2, double param3, double param5, double param7) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"pushOutOfBlocks"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void pushOutOfBlocksHook(double param1, double param3, double param5, CallbackInfoReturnable<Boolean> param7) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"move"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void move(MoverType param1, double param2, double param4, double param6, CallbackInfo param8) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"move"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void move2(MoverType param1, double param2, double param4, double param6, CallbackInfo param8) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"onUpdateWalkingPlayer"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void preMotion2(CallbackInfo param1) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"onUpdateWalkingPlayer"},
      at = {@At("RETURN")}
   )
   private void postMotion2(CallbackInfo param1) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"onUpdateWalkingPlayer"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void OnPreUpdateWalkingPlayer(CallbackInfo param1) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"onUpdateWalkingPlayer"},
      at = {@At("RETURN")},
      cancellable = true
   )
   public void OnPostUpdateWalkingPlayer(CallbackInfo param1) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"onUpdateWalkingPlayer"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onUpdateWalkingPlayerPre(CallbackInfo param1) {
      // $FF: Couldn't be decompiled
   }

   public  M getLastMotionEvent() {
      // $FF: Couldn't be decompiled
   }

   private boolean isMoving() {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"onUpdate"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onUpdate(CallbackInfo param1) {
      // $FF: Couldn't be decompiled
   }

   public void jump() {
      // $FF: Couldn't be decompiled
   }

   public float getLastReportedYaw() {
      // $FF: Couldn't be decompiled
   }

   public float getLastReportedPitch() {
      // $FF: Couldn't be decompiled
   }

   public boolean isPrevOnGround() {
      // $FF: Couldn't be decompiled
   }

   public double getLastReportedPosX() {
      // $FF: Couldn't be decompiled
   }

   public double getLastReportedPosY() {
      // $FF: Couldn't be decompiled
   }

   public double getLastReportedPosZ() {
      // $FF: Couldn't be decompiled
   }

   public void setLastReportedPosX(double param1) {
      // $FF: Couldn't be decompiled
   }

   public void setLastReportedPosY(double param1) {
      // $FF: Couldn't be decompiled
   }

   public void setLastReportedPosZ(double param1) {
      // $FF: Couldn't be decompiled
   }
}
