package com.sindercube.aristotlesComedy.client;

import com.sindercube.aristotlesComedy.client.registry.ACEntityRenderers;
import net.fabricmc.api.ClientModInitializer;

public class AristotlesComedyClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ACEntityRenderers.init();
	}

}
