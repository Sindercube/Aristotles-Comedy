package com.sindercube.aristotlesComedy.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

	protected ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(output, registryLookup);
	}

	@Override
	public void generateAdvancement(RegistryWrapper.WrapperLookup lookup, Consumer<AdvancementEntry> consumer) {
		lookup.getWrapperOrThrow(RegistryKeys.RECIPE).streamEntries().forEach(entry -> {
			Identifier id = entry.getKey().orElseThrow().getValue();
			Recipe<?> recipe = entry.value();
			Advancement.Builder builder = Advancement.Builder.create();
			recipe.getIngredients().forEach(ingredient -> {
//				ingredient.
//				builder.criterion()
			});
		});
	}

}
