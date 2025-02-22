package com.sindercube.aristotlesComedy.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.content.entity.AshBunnyEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ACEntityTypes {

	public static void init() {
		FabricDefaultAttributeRegistry.register(ASH_BUNNY, AshBunnyEntity.createAshBunnyAttributes());
	}

	public static final EntityType<AshBunnyEntity> ASH_BUNNY = register("ash_bunny",
		EntityType.Builder.create(AshBunnyEntity::new, SpawnGroup.CREATURE)
			.dimensions(0.5f, 0.5f)
			.maxTrackingRange(10)
	);

	private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
		Identifier id = AristotlesComedy.of(name);
		RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id);
		return Registry.register(Registries.ENTITY_TYPE, key, builder.build(id.toString()));
	}

}
