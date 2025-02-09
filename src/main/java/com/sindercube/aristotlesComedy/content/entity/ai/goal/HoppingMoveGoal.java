package com.sindercube.aristotlesComedy.content.entity.ai.goal;

import com.sindercube.aristotlesComedy.content.entity.HoppingEntity;
import com.sindercube.aristotlesComedy.content.entity.controls.HoppingMoveControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;

import java.util.EnumSet;

public class HoppingMoveGoal<T extends MobEntity & HoppingEntity> extends Goal {

	private final T entity;

	public HoppingMoveGoal(T entity) {
		this.entity = entity;
		this.setControls(EnumSet.of(Goal.Control.JUMP, Goal.Control.MOVE));
	}

	@Override
	public boolean canStart() {
		return !this.entity.hasVehicle();
	}

	@Override
	public void tick() {
		MoveControl control = this.entity.getMoveControl();
		if (control instanceof HoppingMoveControl<?> hoppingControl) hoppingControl.move(1.0F);
	}

}
