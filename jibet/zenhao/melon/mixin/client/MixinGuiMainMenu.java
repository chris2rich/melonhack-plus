package jibet.zenhao.melon.mixin.client;

import melon. l.melon. 0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiMainMenu.class})
public abstract class MixinGuiMainMenu {
   @Inject(
      method = {"initGui"},
      at = {@At("RETURN")}
   )
   public void initGui(CallbackInfo var1) {
      Minecraft.func_71410_x().func_147108_a(new  0());
   }
}
