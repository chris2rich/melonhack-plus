package jibet.zenhao.melon.mixin.client;

import melon. V.melon. 2;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({GuiNewChat.class})
public abstract class MixinGuiNewChat {
   @Redirect(
      method = {"drawChat"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/gui/GuiNewChat;drawRect(IIIII)V"
)
   )
   private void drawRectBackgroundClean(int var1, int var2, int var3, int var4, int var5) {
      if (! 2.enabled() ||  2.enabled() && !(Boolean) 2.chatGlobal.getValue()) {
         Gui.func_73734_a(var1, var2, var3, var4, var5);
      }

   }

   @Redirect(
      method = {"drawChat"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/gui/FontRenderer;drawStringWithShadow(Ljava/lang/String;FFI)I"
)
   )
   private int drawStringWithShadowClean(FontRenderer var1, String var2, float var3, float var4, int var5) {
      return  2.enabled() && (! 2.enabled() || (Boolean) 2.chatGlobal.getValue()) ? var1.func_78276_b(var2, (int)var3, (int)var4, var5) : var1.func_175063_a(var2, var3, var4, var5);
   }
}
