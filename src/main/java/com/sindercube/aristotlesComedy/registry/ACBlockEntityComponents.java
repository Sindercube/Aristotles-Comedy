package com.sindercube.aristotlesComedy.registry;

import com.mojang.serialization.Codec;
import com.sindercube.aristotlesComedy.AristotlesComedy;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ACBlockEntityComponents {

	public static void init() {}

	public static final ComponentType<FluidVariant> FLUID_VARIANT = register("fluid_variant", FluidVariant.CODEC);
	public static final ComponentType<Long> FLUID_AMOUNT = register("fluid_amount", Codec.LONG);

	private static <T> ComponentType<T> register(String name, Codec<T> codec) {
		return register(name, builder -> builder.codec(codec).packetCodec(PacketCodecs.codec(codec)));
	}

	private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
		Identifier id = AristotlesComedy.of(name);
		return Registry.register(Registries.DATA_COMPONENT_TYPE, id, builderOperator.apply(ComponentType.builder()).build());
	}

}
