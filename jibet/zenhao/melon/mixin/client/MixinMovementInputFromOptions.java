package jibet.zenhao.melon.mixin.client;

import melon. 1.melon. 0;
import melon. 9.melon. x;
import melon. Q.melon. 5;
import melon. Y.melon. k;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {MovementInputFromOptions.class},
   priority = Integer.MAX_VALUE
)
public abstract class MixinMovementInputFromOptions extends MovementInput {
   @Redirect(
      method = {"updatePlayerMoveState"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z"
)
   )
   public boolean isKeyPressed(KeyBinding var1) {
      if (Minecraft.func_71410_x().field_71439_g != null && Minecraft.func_71410_x().field_71462_r != null && !(Minecraft.func_71410_x().field_71462_r instanceof GuiChat)) {
          5 var10000 =  0.moduleManager;
         if ( 5.isModuleEnabled("InventoryMove") && ((Boolean)(( k) 0.moduleManager.getModuleByClass( k.class)).sneak.getValue() || Minecraft.func_71410_x().field_71474_y.field_74311_E.func_151463_i() != var1.func_151463_i() || (Boolean)(( k) 0.moduleManager.getModuleByClass( k.class)).sneak.getValue())) {
            return Keyboard.isKeyDown(var1.func_151463_i());
         }
      }

      return var1.func_151470_d();
   }

   @Inject(
      method = {"updatePlayerMoveState"},
      at = {@At("RETURN")}
   )
   public void updatePlayerMoveStateReturn(CallbackInfo var1) {
       0.EVENT_BUS.post(new  x());
   }
}
