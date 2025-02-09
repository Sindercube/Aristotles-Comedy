package com.sindercube.aristotlesComedy.client.content.entity.renderer;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.client.content.entity.model.AshBunnyModel;
import com.sindercube.aristotlesComedy.content.entity.AshBunnyEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class AshBunnyRenderer extends MobEntityRenderer<AshBunnyEntity, AshBunnyModel> {

	public static final Identifier TEXTURE = AristotlesComedy.of("textures/entity/ash_bunny.png");

	public AshBunnyRenderer(EntityRendererFactory.Context ctx, AshBunnyModel model) {
		super(ctx, model, 0.5f);
	}

	@Override
	public Identifier getTexture(AshBunnyEntity entity) {
		return TEXTURE;
	}

}
