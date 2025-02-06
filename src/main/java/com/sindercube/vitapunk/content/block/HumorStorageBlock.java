package com.sindercube.vitapunk.content.block;

import com.mojang.serialization.MapCodec;
import com.sindercube.vitapunk.content.humor.Humor;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class HumorStorageBlock extends BlockWithEntity {

	private final Humor humor;
	private final int capacity;

	protected HumorStorageBlock(Settings settings, Humor humor, int capacity) {
		super(settings);
		this.humor = humor;
		this.capacity = capacity;
	}

	@Override
	protected MapCodec<? extends BlockWithEntity> getCodec() {
		return null;
	}

	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return null;
	}

}
