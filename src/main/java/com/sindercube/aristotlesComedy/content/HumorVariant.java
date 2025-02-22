package com.sindercube.aristotlesComedy.content;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sindercube.aristotlesComedy.content.humor.Humor;
import com.sindercube.aristotlesComedy.content.humor.Humors;
import com.sindercube.aristotlesComedy.registry.ACRegistries;
import net.fabricmc.fabric.api.transfer.v1.storage.TransferVariant;
import net.minecraft.component.ComponentChanges;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.ComponentMapImpl;
import net.minecraft.registry.entry.RegistryEntry;

public record HumorVariant (
	Humor humor,
	ComponentChanges components
) implements TransferVariant<Humor> {

	public static final Codec<HumorVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		ACRegistries.HUMOR.getEntryCodec().fieldOf("humor").forGetter(HumorVariant::getRegistryEntry),
		ComponentChanges.CODEC.optionalFieldOf("components", ComponentChanges.EMPTY).forGetter(HumorVariant::components)
	).apply(instance, HumorVariant::of));

	public static HumorVariant blank() {
		return of(Humors.EMPTY);
	}

	public static HumorVariant of(RegistryEntry<Humor> humor, ComponentChanges components) {
		return of(humor.value(), components);
	}

	public static HumorVariant of(Humor humor) {
		return of(humor, ComponentChanges.EMPTY);
	}

	public static HumorVariant of(Humor humor, ComponentChanges components) {
		return new HumorVariant(humor, components);
	}

	@Override
	public boolean isBlank() {
		return this.humor == Humors.EMPTY;
	}

	@Override
	public Humor getObject() {
		return this.humor;
	}

	@Override
	public ComponentChanges getComponents() {
		return this.components;
	}

	@Override
	public ComponentMap getComponentMap() {
		return ComponentMapImpl.create(ComponentMap.EMPTY, this.components);
	}

	public RegistryEntry<Humor> getRegistryEntry() {
		return ACRegistries.HUMOR.getEntry(this.humor);
	}

}
