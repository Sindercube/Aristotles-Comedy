package com.sindercube.aristotlesComedy.datagen.provider;

import com.sindercube.aristotlesComedy.datagen.AristotlesComedyDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

	public ModLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
		super(output, lookup);
	}

	@Override
	public void generate() {
		this.registryLookup
			.getWrapperOrThrow(RegistryKeys.BLOCK)
			.streamEntries()
			.filter(AristotlesComedyDataGenerator::ownsRegistry)
			.map(RegistryEntry.Reference::value)
			.forEach(this::addDrop);
	}

}
