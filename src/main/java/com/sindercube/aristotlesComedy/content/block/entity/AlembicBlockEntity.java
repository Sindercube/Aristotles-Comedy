package com.sindercube.aristotlesComedy.content.block.entity;

import com.sindercube.aristotlesComedy.registry.ACBlockEntities;
import com.sindercube.aristotlesComedy.registry.ACBlockEntityComponents;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.ComponentMap;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class AlembicBlockEntity extends BlockEntity {

	public final SingleVariantStorage<FluidVariant> storage;

	public AlembicBlockEntity(BlockPos pos, BlockState state) {
		super(ACBlockEntities.ALEMBIC, pos, state);
		this.storage = new AlembicStorage();
	}

	@Override
	protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
		nbt.put("fluid", FluidVariant.CODEC.encodeStart(NbtOps.INSTANCE, this.storage.variant).getOrThrow());
		nbt.putLong("amount", this.storage.amount);
	}


	@Override
	protected void addComponents(ComponentMap.Builder builder) {
		builder
			.add(ACBlockEntityComponents.FLUID_VARIANT, this.storage.variant)
			.add(ACBlockEntityComponents.FLUID_AMOUNT, this.storage.amount);
	}

	@Override
	protected void readComponents(ComponentsAccess components) {
		this.storage.variant = components.get(ACBlockEntityComponents.FLUID_VARIANT);
		this.storage.amount = components.get(ACBlockEntityComponents.FLUID_AMOUNT);
	}

	public static class AlembicStorage extends SingleVariantStorage<FluidVariant> {

		@Override
		protected FluidVariant getBlankVariant() {
			return FluidVariant.blank();
		}

		@Override
		protected long getCapacity(FluidVariant fluidVariant) {
			return (8 * FluidConstants.BUCKET);
		}

	}

}
