package com.sindercube.vitapunk;

import com.sindercube.vitapunk.registry.*;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vitapunk implements ModInitializer {

	public static final String MOD_ID = "vitapunk";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier of(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModRegistryKeys.init();
		ModRegistries.init();

		ModRecipeTypes.init();
		ModRecipeSerializers.init();

		ModHumors.init();
		ModBlocks.init();
		ModItems.init();

		ModPlacedFeatures.init();
	}

}
