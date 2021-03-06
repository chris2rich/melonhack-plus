package jibet.zenhao.melon.mixin.client;

import com.google.common.base.Predicate;
import java.util.List;
import melon. 9.melon. 02;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({World.class})
public abstract class MixinWorld {
   @Shadow
   @Final
   public boolean field_72995_K;

   @Redirect(
      method = {"getEntitiesWithinAABB(Ljava/lang/Class;Lnet/minecraft/util/math/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/world/chunk/Chunk;getEntitiesOfTypeWithinAABB(Ljava/lang/Class;Lnet/minecraft/util/math/AxisAlignedBB;Ljava/util/List;Lcom/google/common/base/Predicate;)V"
)
   )
   public <T extends Entity> void getEntitiesOfTypeWithinAABBHook(Chunk var1, Class<? extends T> var2, AxisAlignedBB var3, List<T> var4, Predicate<? super T> var5) {
      try {
         var1.func_177430_a(var2, var3, var4, var5);
      } catch (Exception var7) {
      }

   }

   @Redirect(
      method = {"handleMaterialAcceleration"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/Entity;isPushedByWater()Z"
)
   )
   public boolean isPushedbyWaterHook(Entity var1) {
       02 var2 = new  02(((int)(2120906415L & 1874818733L) ^ ((int)1306021433L ^ 1448268690) << 2) << (int)((long)2113048882 ^ (long)2113048883), var1);
      MinecraftForge.EVENT_BUS.post(var2);
      return (boolean)(var1.func_96092_aw() && !var2.isCanceled() ? (int)((long)((int)((long)1234604876 ^ (long)-647589623)) ^ (long)((int)-451059921L ^ 1978490219)) : (int)((long)((int)((long)-886531857 ^ (long)1945482564)) ^ (long)((int)((long)-664088758 ^ (long)1622663905))));
   }
}
