package com.sindercube.aristotlesComedy.datagen.provider;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.content.block.BrazierBlock;
import com.sindercube.aristotlesComedy.datagen.AristotlesComedyDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.*;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.Optional;

public class ACModelProvider extends FabricModelProvider {

	public ACModelProvider(FabricDataOutput output) {
		super(output);
	}

	@FunctionalInterface
	public interface BlockStateProvider {
		void generate(BlockStateModelGenerator generate, Block block, Identifier id);
	}

	public static Map<Class<? extends Block>, BlockStateProvider> BLOCK_STATE_PROVIDERS = Map.of(
		BrazierBlock.class, ACModelProvider::registerBrazier,
		PillarBlock.class, ACModelProvider::registerPillar,
		SnowBlock.class, ACModelProvider::registerLayeredModel
	);

	public static void registerBrazier(BlockStateModelGenerator generator, Block block, Identifier id) {
		Identifier blockId = id.withPrefixedPath("block/");

		Model litModel = new Model(
			Optional.of(AristotlesComedy.of("block/template/brazier")),
			Optional.empty(),
			TextureKey.FIRE
		);
		TextureMap litTextures = new TextureMap()
			.put(TextureKey.FIRE, blockId.withSuffixedPath("_fire"));
		litModel.upload(block, litTextures, generator.modelCollector);

		Model offModel = new Model(
			Optional.of(AristotlesComedy.of("block/template/brazier")),
			Optional.empty(),
			TextureKey.FIRE
		);
		TextureMap offTextures = new TextureMap()
			.put(TextureKey.FIRE, AristotlesComedy.of("block/empty"));
		offModel.upload(block, "_off", offTextures, generator.modelCollector);

		generator.blockStateCollector.accept(
			VariantsBlockStateSupplier.create(block).coordinate(
				BlockStateVariantMap.create(Properties.LIT)
					.register(true, BlockStateVariant.create()
						.put(VariantSettings.MODEL, blockId))
					.register(false, BlockStateVariant.create()
						.put(VariantSettings.MODEL, blockId.withSuffixedPath("_off")))
			)
		);

		generator.registerParentedItemModel(block, id);
	}

	public static void registerPillar(BlockStateModelGenerator generator, Block block, Identifier id) {
		generator.registerAxisRotated(block, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
		generator.registerParentedItemModel(block, id);
	}

	public static void registerLayeredModel(BlockStateModelGenerator generator, Block block, Identifier id) {
		Identifier blockId = id.withPrefixedPath("block/");
		VariantsBlockStateSupplier supplier = VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(Properties.LAYERS).register(height -> {
			BlockStateVariant variant = BlockStateVariant.create();
			VariantSetting<Identifier> setting = VariantSettings.MODEL;
			Identifier path;
			if (height < 8) path = blockId.withSuffixedPath("/height/" + height * 2);
			else path = blockId.withSuffixedPath("_block");

			return variant.put(setting, path);
		}));
		generator.blockStateCollector.accept(supplier);
		generator.registerParentedItemModel(block, blockId.withSuffixedPath("/height/2"));
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator generator) {
		Registries.BLOCK.streamEntries()
			.filter(AristotlesComedyDataGenerator::ownsRegistry)
			.forEach(entry -> this.generateBlockModel(generator, entry));
	}

	public void generateBlockModel(BlockStateModelGenerator generator, RegistryEntry<Block> entry) {
		Block block = entry.value();
		Identifier id = entry.getKeyOrValue().left().orElseThrow().getValue();

		BLOCK_STATE_PROVIDERS.forEach((clazz, provider) -> {
			if (clazz.isInstance(block)) provider.generate(generator, block, id);
		});

		if (block.getClass() == Block.class) {
			generator.registerSimpleCubeAll(block);
			generator.registerParentedItemModel(block, id);
		}
	}

	@Override
	public void generateItemModels(ItemModelGenerator generator) {
		Registries.ITEM.streamEntries()
			.filter(AristotlesComedyDataGenerator::ownsRegistry)
			.forEach(entry -> this.generateItemModel(generator, entry));
	}

	public void generateItemModel(ItemModelGenerator generator, RegistryEntry<Item> entry) {
		Item item = entry.value();

		if (item instanceof ToolItem) {
			generator.register(item, Models.HANDHELD);
		} else if (item.getClass() == Item.class) {
			generator.register(item, Models.GENERATED);
		}
	}

}
