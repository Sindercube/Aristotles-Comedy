package com.sindercube.aristotlesComedy;

import com.sindercube.aristotlesComedy.content.humor.Humors;
import com.sindercube.aristotlesComedy.registry.ACBiomes;
import com.sindercube.aristotlesComedy.registry.*;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AristotlesComedy implements ModInitializer {

	public static final String MOD_ID = "aristotles_comedy";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier of(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ACRegistryKeys.init();
		ACRegistries.init();

		ACRecipeTypes.init();
		ACRecipeSerializers.init();

		ACBlockEntityComponents.init();

		Humors.init();
		ACBlocks.init();
		ACItems.init();
		ACEntityTypes.init();
		ACBlockEntities.init();

		ACPlacedFeatures.init();
		ACBiomes.init();
	}

}
