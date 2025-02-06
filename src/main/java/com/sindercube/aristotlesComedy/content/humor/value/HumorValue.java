package com.sindercube.aristotlesComedy.content.humor.value;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.codecs.UnboundedMapCodec;
import com.sindercube.aristotlesComedy.content.humor.Humor;
import com.sindercube.aristotlesComedy.registry.ModRegistries;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;

import java.util.Map;

public record HumorValue (
	TagKey<Item> tag,
	Map<RegistryEntry<Humor>, Integer> values
) {

	public static UnboundedMapCodec<RegistryEntry<Humor>, Integer> VALUES_CODEC = Codec.unboundedMap(
		ModRegistries.HUMOR.getEntryCodec(), Codec.INT
	);

	public static Codec<HumorValue> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		TagKey.codec(RegistryKeys.ITEM).fieldOf("tag").forGetter(HumorValue::tag),
		VALUES_CODEC.fieldOf("values").forGetter(HumorValue::values)
	).apply(instance, HumorValue::new));

}
