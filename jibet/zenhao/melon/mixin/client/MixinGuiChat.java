package jibet.zenhao.melon.mixin.client;

import melon. 0d.melon. 0P;
import melon. 3.melon. 0;
import melon. q.melon. c;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiChat.class})
public abstract class MixinGuiChat {
   @Shadow
   protected GuiTextField field_146415_a;
   @Shadow
   public String field_146410_g;
   @Shadow
   public int field_146416_h;

   @Shadow
   public abstract void func_73866_w_();

   @Inject(
      method = {"Lnet/minecraft/client/gui/GuiChat;keyTyped(CI)V"},
      at = {@At("RETURN")}
   )
   public void returnKeyTyped(char var1, int var2, CallbackInfo var3) {
      if ( 0P.getMinecraft().field_71462_r instanceof GuiChat && !( 0P.getMinecraft().field_71462_r instanceof  c)) {
         if (this.field_146415_a.func_146179_b().startsWith( 0.getCommandPrefix())) {
             0P.getMinecraft().func_147108_a(new  c(this.field_146415_a.func_146179_b(), this.field_146410_g, this.field_146416_h));
         }

      }
   }
}
