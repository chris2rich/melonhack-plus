package jibet.zenhao.melon.mixin.client;

import melon. 9.melon. 06;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.ChunkRenderContainer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({RenderGlobal.class})
public class MixinRenderGlobal {
   @Final
   @Shadow
   public Minecraft field_72777_q;
   @Shadow
   public ChunkRenderContainer field_174996_N;
   public  06 event;

   public MixinRenderGlobal() {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"renderBlockLayer(Lnet/minecraft/util/BlockRenderLayer;DILnet/minecraft/entity/Entity;)I"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRenderBlockLayerPre(BlockRenderLayer param1, double param2, int param4, Entity param5, CallbackInfoReturnable<Integer> param6) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"renderBlockLayer(Lnet/minecraft/util/BlockRenderLayer;DILnet/minecraft/entity/Entity;)I"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void onRenderBlockLayerPost(BlockRenderLayer param1, double param2, int param4, Entity param5, CallbackInfoReturnable<Integer> param6) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"drawBlockDamageTexture"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void drawBlockDamageTexture(Tessellator param1, BufferBuilder param2, Entity param3, float param4, CallbackInfo param5) {
      // $FF: Couldn't be decompiled
   }
}
