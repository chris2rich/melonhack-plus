package jibet.zenhao.melon.mixin.client;

import java.util.List;
import javax.annotation.Nullable;
import melon. 9.melon. 7;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
   value = {Block.class},
   priority = Integer.MAX_VALUE
)
public class MixinBlock {
   private  7 bbEvent;

   public MixinBlock() {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"addCollisionBoxToList(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/entity/Entity;Z)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void in(IBlockState param1, World param2, BlockPos param3, AxisAlignedBB param4, List<AxisAlignedBB> param5, @Nullable Entity param6, boolean param7, CallbackInfo param8) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"canCollideCheck"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void canCollideCheckHook(IBlockState param1, boolean param2, CallbackInfoReturnable<Boolean> param3) {
      // $FF: Couldn't be decompiled
   }

   @Inject(
      method = {"addCollisionBoxToList(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/entity/Entity;Z)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void addCollisionBoxToListHook(IBlockState param1, World param2, BlockPos param3, AxisAlignedBB param4, List<AxisAlignedBB> param5, @Nullable Entity param6, boolean param7, CallbackInfo param8) {
      // $FF: Couldn't be decompiled
   }
}
