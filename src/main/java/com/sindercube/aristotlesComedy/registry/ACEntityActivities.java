package com.sindercube.aristotlesComedy.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ACEntityActivities {

	public static void init() {}

	public static final Activity WITHER_RECOVERY = register("wither_recovery");

	private static Activity register(String name) {
		Identifier id = AristotlesComedy.of(name);
		return Registry.register(Registries.ACTIVITY, id, new Activity(id.toString()));
	}

}
