package com.sindercube.aristotlesComedy.content.entity;

import com.sindercube.aristotlesComedy.content.entity.ai.goal.HoppingFaceTowardTargetGoal;
import com.sindercube.aristotlesComedy.content.entity.ai.goal.HoppingMoveGoal;
import com.sindercube.aristotlesComedy.content.entity.ai.goal.HoppingRandomLookGoal;
import com.sindercube.aristotlesComedy.content.entity.controls.HoppingMoveControl;
import com.sindercube.aristotlesComedy.registry.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AshBunnyEntity extends AbstractAshBunnyEntity {

	public AshBunnyEntity(EntityType<? extends PassiveEntity> entityType, World world) {
		super(entityType, world);
		this.moveControl = new HoppingMoveControl<>(this);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(2, new HoppingFaceTowardTargetGoal<>(this));
		this.goalSelector.add(3, new HoppingRandomLookGoal<>(this));
		this.goalSelector.add(5, new HoppingMoveGoal<>(this));
	}

	@Override
	public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return ModEntityTypes.ASH_BUNNY.create(world);
	}

	@Override
	public SoundEvent getJumpSound() {
		return SoundEvents.ENTITY_SLIME_JUMP;
	}

}
