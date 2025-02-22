package com.sindercube.aristotlesComedy.datagen;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.datagen.provider.ACLanguageProvider;
import com.sindercube.aristotlesComedy.datagen.provider.ACLootTableProvider;
import com.sindercube.aristotlesComedy.datagen.provider.ACModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.entry.RegistryEntry;

public class AristotlesComedyDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(ACLanguageProvider::new);
		pack.addProvider(ACModelProvider::new);
		pack.addProvider(ACLootTableProvider::new);
	}

	public static boolean ownsRegistry(RegistryEntry<?> entry) {
		return entry.getKey().orElseThrow().getValue().getNamespace().equals(AristotlesComedy.MOD_ID);
	}

}
