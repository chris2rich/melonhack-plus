package jibet.zenhao.melon.mixin.client;

import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.handshake.client.C00Handshake;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({C00Handshake.class})
public class MixinC00Handshake {
   @Shadow
   int field_149600_a;
   @Shadow
   String field_149598_b;
   @Shadow
   int field_149599_c;
   @Shadow
   EnumConnectionState field_149597_d;

   public MixinC00Handshake() {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"writePacketData"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void writePacketData(PacketBuffer param1, CallbackInfo param2) {
      // $FF: Couldn't be decompiled
   }
}
