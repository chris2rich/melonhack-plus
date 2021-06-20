package org.spongepowered.tools.obfuscation.service;

import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;

public class ObfuscationTypeDescriptor {
   private final String key;
   private final String inputFileArgName;
   private final String extraInputFilesArgName;
   private final String outFileArgName;
   private final Class<? extends ObfuscationEnvironment> environmentType;

   public ObfuscationTypeDescriptor(String var1, String var2, String var3, Class<? extends ObfuscationEnvironment> var4) {
      this(var1, var2, (String)null, var3, var4);
   }

   public ObfuscationTypeDescriptor(String var1, String var2, String var3, String var4, Class<? extends ObfuscationEnvironment> var5) {
      this.key = var1;
      this.inputFileArgName = var2;
      this.extraInputFilesArgName = var3;
      this.outFileArgName = var4;
      this.environmentType = var5;
   }

   public final String getKey() {
      return this.key;
   }

   public String getInputFileOption() {
      return this.inputFileArgName;
   }

   public String getExtraInputFilesOption() {
      return this.extraInputFilesArgName;
   }

   public String getOutputFileOption() {
      return this.outFileArgName;
   }

   public Class<? extends ObfuscationEnvironment> getEnvironmentType() {
      return this.environmentType;
   }
}
