package com.sindercube.aristotlesComedy.client.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.client.content.entity.model.AshBunnyModel;
import com.sindercube.aristotlesComedy.client.content.entity.renderer.AshBunnyRenderer;
import com.sindercube.aristotlesComedy.registry.ACEntityTypes;
import com.sindercube.iconic.customModel.loader.CustomModelLoader;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ACEntityRenderers {

	public static final Identifier ASH_BUNNY_ID = AristotlesComedy.of("ash_bunny");
	public static final EntityModelLayer ASH_BUNNY_LAYER = new EntityModelLayer(ASH_BUNNY_ID, "main");

	public static void init() {
		EntityRendererRegistry.register(
			ACEntityTypes.ASH_BUNNY,
			context -> new AshBunnyRenderer(context, new AshBunnyModel(context.getPart(ASH_BUNNY_LAYER), ASH_BUNNY_ID))
		);
		EntityModelLayerRegistry.registerModelLayer(
			ASH_BUNNY_LAYER,
			() -> CustomModelLoader.getEntity(ASH_BUNNY_ID)
		);
	}

}
