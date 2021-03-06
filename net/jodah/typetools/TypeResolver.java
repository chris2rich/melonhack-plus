package net.jodah.typetools;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import melon. c.melon. 0;
import melon. c.melon. 1;
import melon. c.melon. c;
import sun.misc.Unsafe;

public final class TypeResolver {
   private static final Map<Class<?>, Reference<Map<TypeVariable<?>, Type>>> TYPE_VARIABLE_CACHE;
   private static volatile boolean CACHE_ENABLED;
   private static boolean RESOLVES_LAMBDAS;
   private static Method GET_CONSTANT_POOL;
   private static Method GET_CONSTANT_POOL_SIZE;
   private static Method GET_CONSTANT_POOL_METHOD_AT;
   private static final Map<String, Method> OBJECT_METHODS;
   private static final Map<Class<?>, Class<?>> PRIMITIVE_WRAPPERS;
   private static final Double JAVA_VERSION;

   private TypeResolver() {
      if ( 1.1 <= 0) {
         ;
      }

      super();
   }

   public static void enableCache() {
      if ( c.0 <= 0) {
         ;
      }

      CACHE_ENABLED = (boolean)((int)(-378507297L & -854569058L) ^ (int)23024874L ^ -934339723);
   }

   public static void disableCache() {
      if ( 0.1 < 0) {
         ;
      }

      TYPE_VARIABLE_CACHE.clear();
      CACHE_ENABLED = (boolean)((int)((long)((int)((long)-1319923149 ^ (long)-998165808)) ^ (long)((int)949494067L ^ 1296728528)));
   }

   public static <T, S extends T> Class<?> resolveRawArgument(Class<T> var0, Class<S> var1) {
      if ( 1.0 < 0) {
         ;
      }

      return resolveRawArgument(resolveGenericType(var0, var1), var1);
   }

   public static Class<?> resolveRawArgument(Type var0, Class<?> var1) {
      if ( 0.1 < 0) {
         ;
      }

      Class[] var2 = resolveRawArguments(var0, var1);
      if (var2 == null) {
         return TypeResolver.Unknown.class;
      } else if (var2.length != ((int)(1872741095L & 800816871L) ^ ((int)770811512L ^ 977012491) << 1)) {
         throw new IllegalArgumentException("Expected 1 argument for generic type " + var0 + " but found " + var2.length);
      } else {
         return var2[(int)((long)((int)((long)-1367989809 ^ (long)-367637428)) ^ (long)((int)-905268234L ^ -1905598859))];
      }
   }

   public static <T, S extends T> Class<?>[] resolveRawArguments(Class<T> var0, Class<S> var1) {
      if ( 0.1 < 0) {
         ;
      }

      return resolveRawArguments(resolveGenericType(var0, var1), var1);
   }

   public static Class<?>[] resolveRawArguments(Type var0, Class<?> var1) {
      if ( c.0 < 0) {
         ;
      }

      Class[] var2 = null;
      Class var3 = null;
      if (RESOLVES_LAMBDAS && var1.isSynthetic()) {
         Class var4 = var0 instanceof ParameterizedType && ((ParameterizedType)var0).getRawType() instanceof Class ? (Class)((ParameterizedType)var0).getRawType() : (var0 instanceof Class ? (Class)var0 : null);
         if (var4 != null && var4.isInterface()) {
            var3 = var4;
         }
      }

      if (var0 instanceof ParameterizedType) {
         ParameterizedType var7 = (ParameterizedType)var0;
         Type[] var5 = var7.getActualTypeArguments();
         var2 = new Class[var5.length];

         for(int var6 = (int)((long)((int)-304654815L ^ 1259011226) ^ (long)((int)-207205427L ^ 1434182006)); var6 < var5.length; ++var6) {
            var2[var6] = resolveRawClass(var5[var6], var1, var3);
         }
      } else if (var0 instanceof TypeVariable) {
         var2 = new Class[(int)((long)((int)((long)-1688067015 ^ (long)-1276953466) << 1) ^ (long)((int)((long)190789077 ^ (long)1516045482)))];
         var2[(int)(1976223439L & 1959419599L) ^ (int)((long)1548018259 ^ (long)680436892)] = resolveRawClass(var0, var1, var3);
      } else if (var0 instanceof Class) {
         TypeVariable[] var8 = ((Class)var0).getTypeParameters();
         var2 = new Class[var8.length];

         for(int var9 = (int)((long)((int)((long)1993412131 ^ (long)2019336490)) ^ (long)((int)88701285L ^ 197449324)); var9 < var8.length; ++var9) {
            var2[var9] = resolveRawClass(var8[var9], var1, var3);
         }
      }

      return var2;
   }

   public static Type resolveGenericType(Class<?> var0, Type var1) {
      if ( 0.c <= 0) {
         ;
      }

      Class var2;
      if (var1 instanceof ParameterizedType) {
         var2 = (Class)((ParameterizedType)var1).getRawType();
      } else {
         var2 = (Class)var1;
      }

      if (var0.equals(var2)) {
         return var1;
      } else {
         Type var3;
         if (var0.isInterface()) {
            Type[] var4 = var2.getGenericInterfaces();
            int var5 = var4.length;

            for(int var6 = (int)(-1402331346L & -864347245L) ^ (int)((long)1032995644 ^ (long)-1309124546); var6 < var5; ++var6) {
               Type var7 = var4[var6];
               if (var7 != null && !var7.equals(Object.class) && (var3 = resolveGenericType(var0, var7)) != null) {
                  return var3;
               }
            }
         }

         Type var8 = var2.getGenericSuperclass();
         return var8 != null && !var8.equals(Object.class) && (var3 = resolveGenericType(var0, var8)) != null ? var3 : null;
      }
   }

   public static Class<?> resolveRawClass(Type var0, Class<?> var1) {
      if ( 1.c < 0) {
         ;
      }

      return resolveRawClass(var0, var1, (Class)null);
   }

   private static Class<?> resolveRawClass(Type var0, Class<?> var1, Class<?> var2) {
      if ( 0.0 <= 0) {
         ;
      }

      if (var0 instanceof Class) {
         return (Class)var0;
      } else if (var0 instanceof ParameterizedType) {
         return resolveRawClass(((ParameterizedType)var0).getRawType(), var1, var2);
      } else if (var0 instanceof GenericArrayType) {
         GenericArrayType var6 = (GenericArrayType)var0;
         Class var4 = resolveRawClass(var6.getGenericComponentType(), var1, var2);
         return Array.newInstance(var4, (int)(1817894627L & 1911789929L) ^ (int)619942818L ^ 1151404995).getClass();
      } else {
         if (var0 instanceof TypeVariable) {
            TypeVariable var3 = (TypeVariable)var0;
            Type var5 = (Type)getTypeVariableMap(var1, var2).get(var3);
            var0 = var5 == null ? resolveBound(var3) : resolveRawClass(var5, var1, var2);
         }

         return var0 instanceof Class ? (Class)var0 : TypeResolver.Unknown.class;
      }
   }

   private static Map<TypeVariable<?>, Type> getTypeVariableMap(Class<?> var0, Class<?> var1) {
      if ( 0.c <= 0) {
         ;
      }

      Reference var2 = (Reference)TYPE_VARIABLE_CACHE.get(var0);
      Object var3 = var2 != null ? (Map)var2.get() : null;
      if (var3 == null) {
         var3 = new HashMap();
         if (var1 != null) {
            populateLambdaArgs(var1, var0, (Map)var3);
         }

         populateSuperTypeArgs(var0.getGenericInterfaces(), (Map)var3, (boolean)(var1 != null ? (int)(1997248783L & 2101547503L) ^ ((int)45645064L ^ 943322511) << 1 : (int)(2050948747L & 2071003035L) ^ (int)2098476360L ^ 119851971));
         Type var4 = var0.getGenericSuperclass();

         Class var5;
         for(var5 = var0.getSuperclass(); var5 != null && !Object.class.equals(var5); var5 = var5.getSuperclass()) {
            if (var4 instanceof ParameterizedType) {
               populateTypeArgs((ParameterizedType)var4, (Map)var3, (boolean)((int)(-15761445L & -1081704499L) ^ (int)((long)-1289011731 ^ (long)204292644)));
            }

            populateSuperTypeArgs(var5.getGenericInterfaces(), (Map)var3, (boolean)((int)((long)((int)-1405073981L ^ -1956226282) ^ (long)((int)-896994315L ^ -307303136))));
            var4 = var5.getGenericSuperclass();
         }

         for(var5 = var0; var5.isMemberClass(); var5 = var5.getEnclosingClass()) {
            var4 = var5.getGenericSuperclass();
            if (var4 instanceof ParameterizedType) {
               populateTypeArgs((ParameterizedType)var4, (Map)var3, (boolean)(var1 != null ? (int)(-33854295L & -170390229L) ^ (int)1416045274L ^ -1581306126 : (int)(1795028729L & 2069952377L) ^ (int)((long)-1999415812 ^ (long)-491543675)));
            }
         }

         if (CACHE_ENABLED) {
            TYPE_VARIABLE_CACHE.put(var0, new WeakReference(var3));
         }
      }

      return (Map)var3;
   }

   private static void populateSuperTypeArgs(Type[] var0, Map<TypeVariable<?>, Type> var1, boolean var2) {
      if ( c.1 >= 0) {
         ;
      }

      Type[] var3 = var0;
      int var4 = var0.length;

      for(int var5 = (int)((long)((int)-486734399L ^ 739389363) ^ (long)((int)-1010004497L ^ 220440477)); var5 < var4; ++var5) {
         Type var6 = var3[var5];
         if (var6 instanceof ParameterizedType) {
            ParameterizedType var7 = (ParameterizedType)var6;
            if (!var2) {
               populateTypeArgs(var7, var1, var2);
            }

            Type var8 = var7.getRawType();
            if (var8 instanceof Class) {
               populateSuperTypeArgs(((Class)var8).getGenericInterfaces(), var1, var2);
            }

            if (var2) {
               populateTypeArgs(var7, var1, var2);
            }
         } else if (var6 instanceof Class) {
            populateSuperTypeArgs(((Class)var6).getGenericInterfaces(), var1, var2);
         }
      }

   }

   private static void populateTypeArgs(ParameterizedType var0, Map<TypeVariable<?>, Type> var1, boolean var2) {
      if ( 1.c < 0) {
         ;
      }

      if (var0.getRawType() instanceof Class) {
         TypeVariable[] var3 = ((Class)var0.getRawType()).getTypeParameters();
         Type[] var4 = var0.getActualTypeArguments();
         if (var0.getOwnerType() != null) {
            Type var5 = var0.getOwnerType();
            if (var5 instanceof ParameterizedType) {
               populateTypeArgs((ParameterizedType)var5, var1, var2);
            }
         }

         for(int var10 = (int)(1711205359L & 1832283117L) ^ (int)1413995541L ^ 829536248; var10 < var4.length; ++var10) {
            TypeVariable var6 = var3[var10];
            Type var7 = var4[var10];
            if (var7 instanceof Class) {
               var1.put(var6, var7);
            } else if (var7 instanceof GenericArrayType) {
               var1.put(var6, var7);
            } else if (var7 instanceof ParameterizedType) {
               var1.put(var6, var7);
            } else if (var7 instanceof TypeVariable) {
               TypeVariable var8 = (TypeVariable)var7;
               Type var9;
               if (var2) {
                  var9 = (Type)var1.get(var6);
                  if (var9 != null) {
                     var1.put(var8, var9);
                     continue;
                  }
               }

               var9 = (Type)var1.get(var8);
               if (var9 == null) {
                  var9 = resolveBound(var8);
               }

               var1.put(var6, var9);
            }
         }
      }

   }

   public static Type resolveBound(TypeVariable<?> var0) {
      if ( 1.0 < 0) {
         ;
      }

      Type[] var1 = var0.getBounds();
      if (var1.length == 0) {
         return TypeResolver.Unknown.class;
      } else {
         Type var2 = var1[(int)((long)((int)((long)-1152315028 ^ (long)-1517096969) << 2) ^ (long)(((int)-650081866L ^ -947685587) << 2))];
         if (var2 instanceof TypeVariable) {
            var2 = resolveBound((TypeVariable)var2);
         }

         return (Type)(var2 == Object.class ? TypeResolver.Unknown.class : var2);
      }
   }

   private static void populateLambdaArgs(Class<?> var0, Class<?> var1, Map<TypeVariable<?>, Type> var2) {
      if ( 1.0 < 0) {
         ;
      }

      if (RESOLVES_LAMBDAS) {
         Method[] var3 = var0.getMethods();
         int var4 = var3.length;

         for(int var5 = (int)(249139491L & 1285525815L) ^ (int)((long)284811853 ^ (long)476083054); var5 < var4; ++var5) {
            Method var6 = var3[var5];
            if (!isDefaultMethod(var6) && !Modifier.isStatic(var6.getModifiers()) && !var6.isBridge()) {
               Method var7 = (Method)OBJECT_METHODS.get(var6.getName());
               if (var7 == null || !Arrays.equals(var6.getTypeParameters(), var7.getTypeParameters())) {
                  Type var8 = var6.getGenericReturnType();
                  Type[] var9 = var6.getGenericParameterTypes();
                  Member var10 = getMemberRef(var1);
                  if (var10 == null) {
                     return;
                  }

                  if (var8 instanceof TypeVariable) {
                     Class var11 = var10 instanceof Method ? ((Method)var10).getReturnType() : ((Constructor)var10).getDeclaringClass();
                     var11 = wrapPrimitives(var11);
                     if (!var11.equals(Void.class)) {
                        var2.put((TypeVariable)var8, var11);
                     }
                  }

                  Class[] var15 = var10 instanceof Method ? ((Method)var10).getParameterTypes() : ((Constructor)var10).getParameterTypes();
                  int var12 = (int)(-558818705L & -633666185L) ^ (int)((long)2086843967 ^ (long)-1504463272);
                  if (var9.length > 0 && var9[(int)((long)(((int)133900612L ^ 128311871) << 2) ^ (long)(((int)378188567L ^ 383023212) << 2))] instanceof TypeVariable && var9.length == var15.length + ((int)(2013195764L & 1038055264L) ^ (int)((long)109805762 ^ (long)861267363))) {
                     Class var13 = var10.getDeclaringClass();
                     var2.put((TypeVariable)var9[(int)(1423416590L & 1425956303L) ^ ((int)1568875142L ^ 2011704321) << 1], var13);
                     var12 = (int)((long)((int)((long)-1481209486 ^ (long)-1426510307) << 1) ^ (long)((int)((long)1121208105 ^ (long)1481312758)));
                  }

                  int var16 = (int)(2138295647L & 1975774303L) ^ (int)-1774821179L ^ -478827366;
                  if (var9.length < var15.length) {
                     var16 = var15.length - var9.length;
                  }

                  for(int var14 = (int)((long)((int)338537803L ^ 1841722104) ^ (long)((int)((long)125072632 ^ (long)2124393291))); var14 + var16 < var15.length; ++var14) {
                     if (var9[var14] instanceof TypeVariable) {
                        var2.put((TypeVariable)var9[var14 + var12], wrapPrimitives(var15[var14 + var16]));
                     }
                  }

                  return;
               }
            }
         }
      }

   }

   private static boolean isDefaultMethod(Method var0) {
      if ( 1.1 <= 0) {
         ;
      }

      return (boolean)(JAVA_VERSION >= Double.longBitsToDouble((long)((int)((long)791658153 ^ (long)240615748) << 1) ^ 4610785297469078295L & 4610785297725109015L) && var0.isDefault() ? (int)((long)((int)620552457L ^ 1809773254) ^ (long)(((int)-135188149L ^ -799000404) << 1)) : (int)(-172131353L & -7503897L) ^ (int)538731250L ^ -711911147);
   }

   private static Member getMemberRef(Class<?> var0) {
      if ( 1.c > 0) {
         ;
      }

      Object var1;
      try {
         var1 = GET_CONSTANT_POOL.invoke(var0);
      } catch (Exception var5) {
         return null;
      }

      Member var2 = null;

      for(int var3 = getConstantPoolSize(var1) - ((int)(1909000061L & 1842317237L) ^ ((int)-568272015L ^ -967664964) << 2); var3 >= 0; --var3) {
         Member var4 = getConstantPoolMethodAt(var1, var3);
         if (var4 != null && (!(var4 instanceof Constructor) || !var4.getDeclaringClass().getName().equals("java.lang.invoke.SerializedLambda")) && !var4.getDeclaringClass().isAssignableFrom(var0)) {
            var2 = var4;
            if (!(var4 instanceof Method) || !isAutoBoxingMethod((Method)var4)) {
               break;
            }
         }
      }

      return var2;
   }

   private static boolean isAutoBoxingMethod(Method var0) {
      if ( c.1 > 0) {
         ;
      }

      Class[] var1 = var0.getParameterTypes();
      return (boolean)(var0.getName().equals("valueOf") && var1.length == (int)((long)(((int)-59866341L ^ -471386498) << 2) ^ (long)((int)9355241L ^ 2124966524)) && var1[(int)((long)((int)((long)217690246 ^ (long)-144096547)) ^ (long)((int)((long)1726419489 ^ (long)-1653088134)))].isPrimitive() && wrapPrimitives(var1[(int)(1761499899L & 1958665067L) ^ (int)-3089995L ^ -1620147234]).equals(var0.getDeclaringClass()) ? (int)(490716328L & 494919297L) ^ (int)((long)-1118054578 ^ (long)-1604039729) : (int)(1919090295L & 1827078066L) ^ (int)((long)1235412059 ^ (long)2039716674) << 1);
   }

   private static Class<?> wrapPrimitives(Class<?> var0) {
      if ( 1.0 < 0) {
         ;
      }

      return var0.isPrimitive() ? (Class)PRIMITIVE_WRAPPERS.get(var0) : var0;
   }

   private static int getConstantPoolSize(Object var0) {
      if ( 0.1 < 0) {
         ;
      }

      try {
         return (Integer)GET_CONSTANT_POOL_SIZE.invoke(var0);
      } catch (Exception var2) {
         return (int)(2146369183L & 1599043087L) ^ (int)127314497L ^ 1490607182;
      }
   }

   private static Member getConstantPoolMethodAt(Object var0, int var1) {
      if ( 1.c > 0) {
         ;
      }

      try {
         Method var10000 = GET_CONSTANT_POOL_METHOD_AT;
         Object[] var10002 = new Object[(int)((long)((int)((long)651122110 ^ (long)-491046812)) ^ (long)((int)((long)-355697573 ^ (long)783815040)))];
         var10002[(int)(1727450101L & 1739574012L) ^ ((int)844005778L ^ 736572207) << 2] = var1;
         return (Member)var10000.invoke(var0, var10002);
      } catch (Exception var3) {
         return null;
      }
   }

   static {
      if ( 1.c < 0) {
         ;
      }

      TYPE_VARIABLE_CACHE = Collections.synchronizedMap(new WeakHashMap());
      CACHE_ENABLED = (boolean)((int)((long)((int)((long)610053352 ^ (long)-737192485)) ^ (long)((int)1597540862L ^ -1351913268)));
      OBJECT_METHODS = new HashMap();
      JAVA_VERSION = Double.parseDouble(System.getProperty("java.specification.version", "0"));

      try {
         Unsafe var0 = (Unsafe)AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
            {
               if ( 0.1 <= 0) {
                  ;
               }

            }

            public Unsafe run() throws Exception {
               if ( c.0 < 0) {
                  ;
               }

               Field var1 = Unsafe.class.getDeclaredField("theUnsafe");
               var1.setAccessible((boolean)((int)((long)((int)-1689221956L ^ 1072251802) ^ (long)((int)((long)653783059 ^ (long)-2108803276)))));
               return (Unsafe)var1.get((Object)null);
            }
         });
         GET_CONSTANT_POOL = Class.class.getDeclaredMethod("getConstantPool");
         String var1 = JAVA_VERSION < Double.longBitsToDouble((long)((int)((long)829790094 ^ (long)555037329)) ^ 4621256168447452479L & 4621256167970285535L) ? "sun.reflect.ConstantPool" : "jdk.internal.reflect.ConstantPool";
         Class var2 = Class.forName(var1);
         GET_CONSTANT_POOL_SIZE = var2.getDeclaredMethod("getSize");
         Class[] var10002 = new Class[(int)((long)((int)460407204L ^ -1488862075) ^ (long)((int)-723546322L ^ 1760496142))];
         var10002[(int)(-537739803L & -545867035L) ^ (int)1280868493L ^ -1825949592] = Integer.TYPE;
         GET_CONSTANT_POOL_METHOD_AT = var2.getDeclaredMethod("getMethodAt", var10002);
         Field var3 = AccessibleObject.class.getDeclaredField("override");
         long var4 = var0.objectFieldOffset(var3);
         var0.putBoolean(GET_CONSTANT_POOL, var4, (boolean)((int)((long)((int)659772229L ^ -1840608094) ^ (long)((int)2062627952L ^ -806818922))));
         var0.putBoolean(GET_CONSTANT_POOL_SIZE, var4, (boolean)((int)((long)((int)840016308L ^ -1588927780) ^ (long)((int)72342796L ^ -1760256411))));
         var0.putBoolean(GET_CONSTANT_POOL_METHOD_AT, var4, (boolean)((int)(1471872703L & 1207664279L) ^ (int)((long)160989479 ^ (long)709213804) << 1));
         Object var6 = GET_CONSTANT_POOL.invoke(Object.class);
         GET_CONSTANT_POOL_SIZE.invoke(var6);
         Method[] var7 = Object.class.getDeclaredMethods();
         int var8 = var7.length;

         for(int var9 = (int)(1517226207L & 1533349087L) ^ (int)940685182L ^ 1651818401; var9 < var8; ++var9) {
            Method var10 = var7[var9];
            OBJECT_METHODS.put(var10.getName(), var10);
         }

         RESOLVES_LAMBDAS = (boolean)((int)(475909187L & 1820179691L) ^ (int)((long)-1623268753 ^ (long)-1726995378) << 1);
      } catch (Exception var11) {
      }

      HashMap var12 = new HashMap();
      var12.put(Boolean.TYPE, Boolean.class);
      var12.put(Byte.TYPE, Byte.class);
      var12.put(Character.TYPE, Character.class);
      var12.put(Double.TYPE, Double.class);
      var12.put(Float.TYPE, Float.class);
      var12.put(Integer.TYPE, Integer.class);
      var12.put(Long.TYPE, Long.class);
      var12.put(Short.TYPE, Short.class);
      var12.put(Void.TYPE, Void.class);
      PRIMITIVE_WRAPPERS = Collections.unmodifiableMap(var12);
   }

   public static final class Unknown {
      private Unknown() {
         if ( 0.0 <= 0) {
            ;
         }

         super();
      }
   }
}
