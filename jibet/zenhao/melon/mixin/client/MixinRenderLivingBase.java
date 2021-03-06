package jibet.zenhao.melon.mixin.client;

import melon. 0c.melon. I;
import melon. 0c.melon. V;
import melon. 0c.melon. X;
import melon. 0d.melon. a;
import melon. 0d.melon. x;
import melon. 9.melon. 07;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderLivingEvent.Post;
import net.minecraftforge.client.event.RenderLivingEvent.Pre;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({RenderLivingBase.class})
public abstract class MixinRenderLivingBase<T extends EntityLivingBase> extends Render<T> {
   @Shadow
   protected ModelBase field_77045_g;
   @Shadow
   private static final Logger field_147923_a = LogManager.getLogger();
   @Shadow
   protected boolean field_188323_j;
   float red = 0.0F;
   float green = 0.0F;
   float blue = 0.0F;

   @Shadow
   protected abstract boolean func_193115_c(EntityLivingBase var1);

   @Shadow
   protected abstract float func_77040_d(T var1, float var2);

   @Shadow
   protected abstract float func_77034_a(float var1, float var2, float var3);

   @Shadow
   protected abstract float func_77044_a(T var1, float var2);

   @Shadow
   protected abstract void func_77043_a(T var1, float var2, float var3, float var4);

   @Shadow
   public abstract float func_188322_c(T var1, float var2);

   @Shadow
   protected abstract void func_180565_e();

   @Shadow
   protected abstract boolean func_177088_c(T var1);

   @Shadow
   protected abstract void func_77039_a(T var1, double var2, double var4, double var6);

   @Shadow
   protected abstract void func_177091_f();

   @Shadow
   protected abstract void func_77036_a(T var1, float var2, float var3, float var4, float var5, float var6, float var7);

   @Shadow
   protected abstract void func_177093_a(T var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8);

   @Shadow
   protected abstract boolean func_177090_c(T var1, float var2);

   protected MixinRenderLivingBase(RenderManager var1) {
      super(var1);
   }

   @Redirect(
      method = {"renderModel"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/model/ModelBase;render(Lnet/minecraft/entity/Entity;FFFFFF)V"
)
   )
   private void renderModelHook(ModelBase var1, Entity var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      int var9 = (int)((long)((int)86855246L ^ -244646705) ^ (long)((int)((long)-394122291 ^ (long)482711884)));
      if ( I.getInstance().isEnabled()) {
          07 var10 = new  07((int)(-356890473L & -290042997L) ^ (int)-2118898672L ^ 1795581075, var1, var2, var3, var4, var5, var6, var7, var8);
         if ( I.getInstance().isEnabled()) {
             I.getInstance().onRenderModel(var10);
         }
      } else {
         var1.func_78088_a(var2, var3, var4, var5, var6, var7, var8);
      }

   }

   @Overwrite
   public void func_76986_a(T var1, double var2, double var4, double var6, float var8, float var9) {
      if (!MinecraftForge.EVENT_BUS.post(new Pre(var1, (RenderLivingBase)RenderLivingBase.class.cast(this), var9, var2, var4, var6))) {
         GlStateManager.func_179094_E();
         GL11.glShadeModel((int)((long)(((int)1899845245L ^ 1972709934) << 1) ^ (long)((int)-703679468L ^ -547468113)) << ((int)((long)1522597159 ^ (long)1522597158) << 3));
         GlStateManager.func_179129_p();
         this.field_77045_g.field_78095_p = this.func_77040_d(var1, var9);
         int var10 = var1.func_184218_aH() && var1.func_184187_bx() != null && var1.func_184187_bx().shouldRiderSit() ? (int)(2071326679L & 1538619356L) ^ (int)((long)245427548 ^ (long)1435863689) : (int)(-1266765915L & -1101598731L) ^ (int)-568050354L ^ 1785893611;
         this.field_77045_g.field_78093_q = (boolean)var10;
         this.field_77045_g.field_78091_s = var1.func_70631_g_();

         try {
            float var11 = this.func_77034_a(var1.field_70760_ar, var1.field_70761_aq, var9);
            float var12 = this.func_77034_a(var1.field_70758_at, var1.field_70759_as, var9);
            float var13 = var12 - var11;
            float var15;
            if (var10 != 0 && var1.func_184187_bx() instanceof EntityLivingBase) {
               EntityLivingBase var14 = (EntityLivingBase)var1.func_184187_bx();
               var11 = this.func_77034_a(var14.field_70760_ar, var14.field_70761_aq, var9);
               var13 = var12 - var11;
               var15 = MathHelper.func_76142_g(var13);
               if (var15 < Float.intBitsToFloat((int)(1574810983L & 2035412295L) ^ (int)711881047L ^ -1315580912)) {
                  var15 = Float.intBitsToFloat((int)-1527326721L ^ -1396182688 ^ (int)((long)-1818571609 ^ (long)1493297720));
               }

               if (var15 >= Float.intBitsToFloat((int)(1509473331L & 2042542387L) ^ (int)-557051238L ^ -975263063)) {
                  var15 = Float.intBitsToFloat((int)((long)(((int)857260346L ^ 1033197387) << 3) ^ (long)((int)((long)-1108503675 ^ (long)-1154136588) << 3)));
               }

               var11 = var12 - var15;
               if (var15 * var15 > Float.intBitsToFloat((int)((long)((int)1964359276L ^ 1216334421) ^ (long)((int)-1205016219L ^ -1067786916)))) {
                  var11 += var15 * Float.intBitsToFloat((int)((long)((int)-943583806L ^ -1497513919) ^ (long)((int)((long)-1367909880 ^ (long)-2115052881) << 1)));
               }

               var13 = var12 - var11;
            }

            float var21 = var1.field_70127_C + (var1.field_70125_A - var1.field_70127_C) * var9;
            this.func_77039_a(var1, var2, var4, var6);
            var15 = this.func_77044_a(var1, var9);
            this.func_77043_a(var1, var15, var11, var9);
            float var16 = this.func_188322_c(var1, var9);
            float var17 = 0.0F;
            float var18 = 0.0F;
            if (!var1.func_184218_aH()) {
               var17 = var1.field_184618_aE + (var1.field_70721_aZ - var1.field_184618_aE) * var9;
               var18 = var1.field_184619_aG - var1.field_70721_aZ * (1.0F - var9);
               if (var1.func_70631_g_()) {
                  var18 *= Float.intBitsToFloat((int)((long)((int)1984446866L ^ 1571434501) ^ (long)((int)((long)-936973161 ^ (long)-1551590144))));
               }

               if (var17 > 1.0F) {
                  var17 = 1.0F;
               }

               var13 = var12 - var11;
            }

            GlStateManager.func_179141_d();
            this.field_77045_g.func_78086_a(var1, var18, var17, var9);
            this.field_77045_g.func_78087_a(var18, var17, var15, var13, var21, var16, var1);
            boolean var19;
            if (this.field_188301_f) {
               var19 = this.func_177088_c(var1);
               GlStateManager.func_179142_g();
               GlStateManager.func_187431_e(this.func_188298_c(var1));
               if (!this.field_188323_j) {
                  this.func_77036_a(var1, var18, var17, var15, var13, var21, var16);
               }

               if (!(var1 instanceof EntityPlayer) || !((EntityPlayer)var1).func_175149_v()) {
                  this.func_177093_a(var1, var18, var17, var9, var15, var13, var21, var16);
               }

               GlStateManager.func_187417_n();
               GlStateManager.func_179119_h();
               if (var19) {
                  this.func_180565_e();
               }
            } else {
               if ( V.getINSTANCE().isEnabled() && (Boolean) V.getINSTANCE().players.getValue() && var1 instanceof EntityPlayer && (( X) V.getINSTANCE().mode.getValue()).equals( X.SOLID)) {
                  this.red = (float)(Integer) V.getInstance().red.getValue() / Float.intBitsToFloat((int)(2094259829L & 1559788517L) ^ (int)((long)-486130066 ^ (long)-56007669));
                  this.green = (float)(Integer) V.getInstance().green.getValue() / Float.intBitsToFloat((int)((long)((int)((long)1542103269 ^ (long)1407308070) << 2) ^ (long)((int)((long)-349013333 ^ (long)-202978456) << 2)));
                  this.blue = (float)(Integer) V.getInstance().blue.getValue() / Float.intBitsToFloat((int)((long)-1650891500 ^ (long)-1349556745) << 1 ^ (int)((long)-1263284003 ^ (long)-1491447746) << 1);
                  GlStateManager.func_179094_E();
                  GL11.glPushAttrib((int)(-1124811219L & -1909114243L) ^ (int)-243735666L ^ 2101552732);
                  GL11.glDisable((int)((long)((int)519914318L ^ -2009385176) ^ (long)((int)((long)52579560 ^ (long)-1780206225))));
                  GL11.glDisable(((int)(-2047066985L & -1681949419L) ^ (int)((long)-970488581 ^ (long)1201387611)) << ((int)((long)-1870596289 ^ (long)-1870596290) << 2));
                  GL11.glEnable(((int)(2078539742L & 1034131420L) ^ (int)((long)-1679324889 ^ (long)-1572594014)) << (int)((long)2146737389 ^ (long)2146737384));
                  GL11.glEnable(((int)(-50335066L & -34867537L) ^ (int)-583664870L ^ 568200269) << (int)((long)1037958003 ^ (long)1037958002));
                  GL11.glBlendFunc(((int)(1370715564L & 1371477950L) ^ (int)((long)487709418 ^ (long)1285738183)) << ((int)1605064237L ^ 1605064236), (int)(520584619L & 524778859L) ^ (int)((long)1493508495 ^ (long)1525009994) << 3);
                  GL11.glDisable((int)((long)((int)1212367831L ^ 1835761752) ^ (long)(((int)-599783373L ^ -824939444) << 1)));
                  GL11.glDepthMask((boolean)((int)((long)((int)1840654360L ^ 1400135477) ^ (long)((int)1437185177L ^ 1802224564))));
                  if (! x.isFriend(var1.func_70005_c_()) && var1 != Minecraft.func_71410_x().field_71439_g) {
                     GL11.glColor4f((Boolean) V.getInstance().rainbow.getValue() ? (float) a.rainbow((Integer) V.getInstance().rainbowHue.getValue()).getRed() / Float.intBitsToFloat((int)((long)((int)((long)-1372467226 ^ (long)-1109430845) << 2) ^ (long)((int)((long)-1023248535 ^ (long)-1070394036) << 2))) : this.red, (Boolean) V.getInstance().rainbow.getValue() ? (float) a.rainbow((Integer) V.getInstance().rainbowHue.getValue()).getGreen() / Float.intBitsToFloat((int)((long)1401180044 ^ (long)840239695) ^ (int)1665638614L ^ 1101653269) : this.green, (Boolean) V.getInstance().rainbow.getValue() ? (float) a.rainbow((Integer) V.getInstance().rainbowHue.getValue()).getBlue() / Float.intBitsToFloat((int)621845121L ^ 2101889578 ^ (int)-91724964L ^ -508578825) : this.blue, (Float) V.getINSTANCE().alpha.getValue() / Float.intBitsToFloat((int)((long)(((int)1754572881L ^ 1628078972) << 2) ^ (long)(((int)-658330126L ^ -1048361249) << 2))));
                  } else {
                     GL11.glColor4f(0.0F, Float.intBitsToFloat((int)(939291517L & 2113427317L) ^ (int)-306016907L ^ -1694114304), Float.intBitsToFloat((int)(1998863981L & 924237516L) ^ (int)((long)-220133623 ^ (long)-268449638) << 2), (Float) V.getINSTANCE().alpha.getValue() / Float.intBitsToFloat((int)((long)((int)((long)-1611995934 ^ (long)-1896116477)) ^ (long)((int)943504064L ^ 1783812385))));
                  }

                  this.func_77036_a(var1, var18, var17, var15, var13, var21, var16);
                  GL11.glDisable(((int)(931311287L & 937606711L) ^ (int)((long)-2005410506 ^ (long)-1816753545) << 1) << ((int)((long)550458793 ^ (long)550458792) << 2));
                  GL11.glEnable((int)(-1637966213L & -1680491911L) ^ (int)((long)-193496402 ^ (long)1847847846));
                  GL11.glDepthMask((boolean)((int)((long)((int)((long)-1341476355 ^ (long)-1135544454)) ^ (long)((int)((long)809821872 ^ (long)912901619) << 1))));
                  if (! x.isFriend(var1.func_70005_c_()) && var1 != Minecraft.func_71410_x().field_71439_g) {
                     GL11.glColor4f((Boolean) V.getInstance().rainbow.getValue() ? (float) a.rainbow((Integer) V.getInstance().rainbowHue.getValue()).getRed() / Float.intBitsToFloat((int)((long)((int)((long)1217777951 ^ (long)1080038972)) ^ (long)((int)-1512201077L ^ -296262744))) : this.red, (Boolean) V.getInstance().rainbow.getValue() ? (float) a.rainbow((Integer) V.getInstance().rainbowHue.getValue()).getGreen() / Float.intBitsToFloat((int)(802286182L & 1054335734L) ^ ((int)2095957675L ^ 1245362072) << 1) : this.green, (Boolean) V.getInstance().rainbow.getValue() ? (float) a.rainbow((Integer) V.getInstance().rainbowHue.getValue()).getBlue() / Float.intBitsToFloat((int)((long)((int)((long)710133829 ^ (long)67191370)) ^ (long)((int)((long)306744563 ^ (long)2137327356)))) : this.blue, (Float) V.getINSTANCE().alpha.getValue() / Float.intBitsToFloat((int)((long)-1661783237 ^ (long)-1162565228) ^ (int)1860780292L ^ 198302635));
                  } else {
                     GL11.glColor4f(0.0F, Float.intBitsToFloat((int)((long)(((int)1001897283L ^ 213674898) << 1) ^ (long)(((int)826297237L ^ 668212548) << 1))), Float.intBitsToFloat((int)(1027536362L & 1026883310L) ^ (int)((long)-482510576 ^ (long)-602373275) << 1), (Float) V.getINSTANCE().alpha.getValue() / Float.intBitsToFloat((int)-1123117146L ^ -205954235 ^ (int)-1587022230L ^ -1397816695));
                  }

                  this.func_77036_a(var1, var18, var17, var15, var13, var21, var16);
                  GL11.glEnable(((int)(251429580L & 1792862285L) ^ (int)-478567450L ^ -375053537) << ((int)((long)483301819 ^ (long)483301818) << 2));
                  GlStateManager.func_179099_b();
                  GlStateManager.func_179121_F();
               }

               var19 = this.func_177090_c(var1, var9);
               if (!(var1 instanceof EntityPlayer) ||  V.getINSTANCE().isEnabled() && (( X) V.getINSTANCE().mode.getValue()).equals( X.WIREFRAME) && (Boolean) V.getINSTANCE().playerModel.getValue() ||  V.getINSTANCE().isDisabled()) {
                  this.func_77036_a(var1, var18, var17, var15, var13, var21, var16);
               }

               if (var19) {
                  this.func_177091_f();
               }

               GlStateManager.func_179132_a((boolean)((int)(-1074414823L & -144329271L) ^ (int)-1213067828L ^ 14138564));
               if (!(var1 instanceof EntityPlayer) || !((EntityPlayer)var1).func_175149_v()) {
                  this.func_177093_a(var1, var18, var17, var9, var15, var13, var21, var16);
               }

               if ( V.getINSTANCE().isEnabled() && (Boolean) V.getINSTANCE().players.getValue() && var1 instanceof EntityPlayer && (( X) V.getINSTANCE().mode.getValue()).equals( X.WIREFRAME)) {
                  this.red = (float)(Integer) V.getInstance().red.getValue() / Float.intBitsToFloat((int)690193452L ^ 2126583667 ^ (int)-1058329305L ^ -730415496);
                  this.green = (float)(Integer) V.getInstance().green.getValue() / Float.intBitsToFloat((int)((long)((int)-1885373237L ^ -1298036776) ^ (long)((int)-1849751781L ^ -268502008)));
                  this.blue = (float)(Integer) V.getInstance().blue.getValue() / Float.intBitsToFloat((int)-273037325L ^ -1956992634 ^ (int)703756205L ^ 242096600);
                  GlStateManager.func_179094_E();
                  GL11.glPushAttrib((int)(-541241171L & -11859L) ^ (int)821196737L ^ -280962925);
                  GL11.glPolygonMode(((int)(-192806017L & -1264448642L) ^ (int)504380356L ^ -1433257925) << (int)((long)-38813120 ^ (long)-38813117), (int)(-744700293L & -473833733L) ^ (int)-1167169830L ^ 2045688736);
                  GL11.glDisable((int)(-661489493L & -606635271L) ^ (int)((long)1309963803 ^ (long)-1769602221));
                  GL11.glDisable(((int)(1467774919L & 1987999639L) ^ ((int)2115691826L ^ 1428479659) << 1) << ((int)((long)2049884790 ^ (long)2049884791) << 2));
                  GL11.glDisable((int)(-288830055L & -245514855L) ^ (int)((long)-1018886635 ^ (long)588087549));
                  GL11.glEnable(((int)(967302119L & 967242742L) ^ (int)1387362476L ^ 1796713235) << ((int)-579647413L ^ -579647410));
                  GL11.glEnable((int)((long)((int)-166444480L ^ 1580222052) ^ (long)((int)((long)720935057 ^ (long)-2099472060))) << ((int)1912832859L ^ 1912832858));
                  GL11.glBlendFunc((int)((long)((int)((long)957566456 ^ (long)-1441030405)) ^ (long)((int)-1263375569L ^ 666548653)) << (int)((long)819690645 ^ (long)819690644), (int)(1062584211L & 928378833L) ^ (int)((long)-1028231844 ^ (long)-652428523) << 1);
                  if (! x.isFriend(var1.func_70005_c_()) && var1 != Minecraft.func_71410_x().field_71439_g) {
                     GL11.glColor4f((Boolean) V.getInstance().rainbow.getValue() ? (float) a.rainbow((Integer) V.getInstance().rainbowHue.getValue()).getRed() / Float.intBitsToFloat((int)((long)((int)-1987697599L ^ -1135169062) ^ (long)((int)((long)-1052522176 ^ (long)-1209246501)))) : this.red, (Boolean) V.getInstance().rainbow.getValue() ? (float) a.rainbow((Integer) V.getInstance().rainbowHue.getValue()).getGreen() / Float.intBitsToFloat((int)((long)(((int)1531612346L ^ 1600474611) << 2) ^ (long)((int)((long)-861155522 ^ (long)-665072009) << 2))) : this.green, (Boolean) V.getInstance().rainbow.getValue() ? (float) a.rainbow((Integer) V.getInstance().rainbowHue.getValue()).getBlue() / Float.intBitsToFloat((int)((long)((int)((long)1546316049 ^ (long)2028353798) << 1) ^ (long)(((int)-1393880915L ^ -1449639750) << 1))) : this.blue, (Float) V.getINSTANCE().alpha.getValue() / Float.intBitsToFloat((int)(1373779311L & 1442067950L) ^ ((int)-633880676L ^ -747100885) << 1));
                  } else {
                     GL11.glColor4f(0.0F, Float.intBitsToFloat(((int)1399717799L ^ 2021211454) << 1 ^ ((int)1653167638L ^ 1744966799) << 1), Float.intBitsToFloat((int)((long)(((int)-1020880794L ^ -976518399) << 1) ^ (long)((int)((long)525203988 ^ (long)941580659) << 1))), (Float) V.getINSTANCE().alpha.getValue() / Float.intBitsToFloat((int)((long)((int)((long)-1536288190 ^ (long)-1972961781) << 1) ^ (long)(((int)39478153L ^ 233637824) << 1))));
                  }

                  GL11.glLineWidth((Float) V.getINSTANCE().lineWidth.getValue());
                  this.func_77036_a(var1, var18, var17, var15, var13, var21, var16);
                  GL11.glEnable((int)((long)((int)((long)594321873 ^ (long)-125716550)) ^ (long)((int)((long)1579936442 ^ (long)-2050556828))) << (((int)1922767456L ^ 1922767457) << 2));
                  GlStateManager.func_179099_b();
                  GlStateManager.func_179121_F();
               }
            }

            GlStateManager.func_179101_C();
         } catch (Exception var20) {
            field_147923_a.error("Couldn't render entity", var20);
         }

         GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
         GlStateManager.func_179098_w();
         GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
         GlStateManager.func_179089_o();
         GlStateManager.func_179121_F();
         super.func_76986_a(var1, var2, var4, var6, var8, var9);
         MinecraftForge.EVENT_BUS.post(new Post(var1, (RenderLivingBase)RenderLivingBase.class.cast(this), var9, var2, var4, var6));
      }

   }
}
