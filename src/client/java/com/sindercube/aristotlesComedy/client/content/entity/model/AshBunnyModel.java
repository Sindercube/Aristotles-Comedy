package com.sindercube.aristotlesComedy.client.content.entity.model;

import com.sindercube.aristotlesComedy.content.entity.AshBunnyEntity;
import com.sindercube.iconic.customModel.api.content.entity.model.LoadedEntityModel;
import net.minecraft.client.model.ModelPart;
import net.minecraft.util.Identifier;

public class AshBunnyModel extends LoadedEntityModel<AshBunnyEntity> {

	public AshBunnyModel(ModelPart root, Identifier id) {
		super(root, id);
	}

	@Override
	public void setAngles(AshBunnyEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}

}
