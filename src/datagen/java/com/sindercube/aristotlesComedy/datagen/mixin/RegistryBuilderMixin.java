package com.sindercube.aristotlesComedy.datagen.mixin;

import net.minecraft.registry.RegistryBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RegistryBuilder.class)
public class RegistryBuilderMixin {

	@Redirect(
		method = "createWrapperLookup(Lnet/minecraft/registry/DynamicRegistryManager;)Lnet/minecraft/registry/RegistryWrapper$WrapperLookup;",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/registry/RegistryBuilder$Registries;checkUnreferencedKeys()V"
		)
	)
	private void ignoreReferenceErrors(RegistryBuilder.Registries instance) {}

}
