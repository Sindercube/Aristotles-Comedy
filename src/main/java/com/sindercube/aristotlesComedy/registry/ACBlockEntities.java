package com.sindercube.aristotlesComedy.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.content.block.entity.AlembicBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ACBlockEntities {

	public static void init() {}

	public static final BlockEntityType<AlembicBlockEntity> ALEMBIC = register("alembic",
		BlockEntityType.Builder.create(AlembicBlockEntity::new, ACBlocks.ALEMBIC).build()
	);

	public static <T extends BlockEntityType<?>> T register(String name, T type) {
		Identifier id = AristotlesComedy.of(name);
		return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, type);
	}

}
