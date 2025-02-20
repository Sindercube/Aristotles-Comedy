package com.sindercube.aristotlesComedy.datagen.provider;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.datagen.AristotlesComedyDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModLanguageProvider extends FabricLanguageProvider {

	public static final List<RegistryKey<?>> REGISTRY_BLACKLIST = List.of(
		RegistryKeys.RECIPE_SERIALIZER,
		RegistryKeys.BIOME
	);

	public ModLanguageProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
		super(output, lookup);
	}

	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup lookup, TranslationBuilder builder) {
		generateRegistryTranslations(lookup, builder);
//		generateTagTranslations(lookup, builder);
	}

	private static void generateRegistryTranslations(RegistryWrapper.WrapperLookup lookup, TranslationBuilder builder) {
		lookup.streamAllRegistryKeys()
			.filter(ModLanguageProvider::keyIsNotBlacklisted)
			.map(lookup::getOptionalWrapper)
			.filter(Optional::isPresent)
			.map(Optional::get)
			.forEach(wrapper -> wrapper.streamEntries()
				.filter(AristotlesComedyDataGenerator::ownsRegistry)
				.forEach(entry -> generateEntryTranslation(builder, entry))
			);
	}

	public static void generateEntryTranslation(TranslationBuilder builder, RegistryEntry<?> entry) {
		Optional<? extends RegistryKey<?>> maybeKey = entry.getKey();
		if (maybeKey.isEmpty()) return;
		RegistryKey<?> registryKey = maybeKey.get();
		Identifier id = registryKey.getValue();
		if (!id.getNamespace().equals(AristotlesComedy.MOD_ID)) return;
		String dataType = registryKey.getRegistry().getPath();
		if (dataType.endsWith("_type")) dataType = dataType.split("_type")[0];
		String key = id.toTranslationKey(dataType);
		String translation = Arrays
			.stream(id.getPath().split("([_.])"))
			.map(ModLanguageProvider::toUpperCase)
			.collect(Collectors.joining(" "));
		builder.add(key, translation);
	}

	public static boolean keyIsNotBlacklisted(RegistryKey<?> key) {
		return !REGISTRY_BLACKLIST.contains(key);
	}

	private static void generateTagTranslations(RegistryWrapper.WrapperLookup lookup, TranslationBuilder builder) {
		lookup.streamAllRegistryKeys().forEach(sKey -> {
			lookup.getWrapperOrThrow(sKey).streamTagKeys().forEach(tag -> {
				generateTagTranslation(builder, tag);
			});
		});
	}

	private static void generateTagTranslation(TranslationBuilder builder, TagKey<?> tag) {
		Identifier id = tag.id();
		String key = id.toTranslationKey("tag." + tag.registry().getValue().getPath());
		String translation = Arrays
			.stream(id.getPath().split("([_.])"))
			.map(ModLanguageProvider::toUpperCase)
			.collect(Collectors.joining(" "));
		builder.add(key, translation);
	}

	private static String toUpperCase(String str) {
		return str.substring(0,1).toUpperCase() + str.substring(1);
	}

}
