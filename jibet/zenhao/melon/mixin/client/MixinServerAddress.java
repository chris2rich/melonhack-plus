package jibet.zenhao.melon.mixin.client;

import melon. 02.melon. m;
import net.minecraft.client.multiplayer.ServerAddress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({ServerAddress.class})
public abstract class MixinServerAddress {
   @Redirect(
      method = {"fromString"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/multiplayer/ServerAddress;getServerAddress(Ljava/lang/String;)[Ljava/lang/String;"
)
   )
   private static String[] getServerAddressHook(String var0) {
      int var2;
      if (var0.equals( m.getInstance().ip.getValue()) && (var2 =  m.getInstance().getPort()) != ((int)(-1528404757L & -1804143989L) ^ ((int)-1722315803L ^ -2018382792) << 2)) {
         String[] var10000 = new String[((int)(1340020895L & 1340060574L) ^ (int)-795023807L ^ -1622935842) << ((int)533099860L ^ 533099861)];
         var10000[(int)((long)((int)1855156205L ^ -1821158688) ^ (long)((int)1000276120L ^ -964739691))] = (String) m.getInstance().ip.getValue();
         var10000[(int)(-1088898063L & -142033927L) ^ (int)((long)-56873859 ^ (long)1268029325)] = Integer.toString(var2);
         return var10000;
      } else {
         return IServerAddress.getServerAddress(var0);
      }
   }
}
