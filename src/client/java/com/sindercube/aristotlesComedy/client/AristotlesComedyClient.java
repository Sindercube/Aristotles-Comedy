package com.sindercube.aristotlesComedy.client;

import com.sindercube.aristotlesComedy.client.registry.ACEntityRenderers;
import com.sindercube.aristotlesComedy.registry.ACBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class AristotlesComedyClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ACEntityRenderers.init();
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
			ACBlocks.BRAZIER,
			ACBlocks.SOUL_BRAZIER
		);
	}

}
