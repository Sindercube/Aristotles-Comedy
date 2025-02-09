package com.sindercube.aristotlesComedy.datagen.provider;

import com.sindercube.aristotlesComedy.datagen.AristotlesComedyDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.data.client.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {

	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator generator) {
		Registries.BLOCK.streamEntries()
			.filter(AristotlesComedyDataGenerator::ownsRegistry)
			.forEach(entry -> this.generateBlockModel(generator, entry));
	}

	public void generateBlockModel(BlockStateModelGenerator generator, RegistryEntry<Block> entry) {
		Block block = entry.value();
		Class<? extends Block> blockClass = block.getClass();

		if (blockClass == AnvilBlock.class) {
			generator.registerAnvil(block);
		} else if (blockClass == SnowBlock.class) {
			this.generateLayeredBlockModels(generator, entry);
		} else if (blockClass == Block.class) {
			generator.registerSimpleCubeAll(block);
			generator.registerParentedItemModel(block, ModelIds.getBlockModelId(block));
		}
	}

	public void generateLayeredBlockModels(BlockStateModelGenerator generator, RegistryEntry<Block> entry) {
		Identifier id = entry.getKey().orElseThrow().getValue().withPrefixedPath("block/");
		Block block = entry.value();

		VariantsBlockStateSupplier supplier = VariantsBlockStateSupplier.create(block).coordinate(BlockStateVariantMap.create(Properties.LAYERS).register(height -> {
			BlockStateVariant variant = BlockStateVariant.create();
			VariantSetting<Identifier> setting = VariantSettings.MODEL;
			Identifier path;
			if (height < 8) path = id.withSuffixedPath("/height/" + height * 2);
			else path = id.withSuffixedPath("_block");

			return variant.put(setting, path);
		}));
		generator.blockStateCollector.accept(supplier);
		generator.registerParentedItemModel(block, id.withSuffixedPath("/height/2"));
	}

	@Override
	public void generateItemModels(ItemModelGenerator generator) {
//		Registries.ITEM.streamEntries()
//			.filter(AristotlesComedyDataGenerator::ownsRegistry)
//			.forEach(entry -> this.generateItemModel(generator, entry));
	}

	public void generateItemModel(ItemModelGenerator generator, RegistryEntry<Item> entry) {
		Item item = entry.value();
		Class<? extends Item> itemClass = item.getClass();

		Model model;
		if (itemClass == ToolItem.class) {
			model = Models.HANDHELD;
		} else if (itemClass == BlockItem.class) {
			return;
		} else {
			model = Models.GENERATED;
		}
		generator.register(item, model);

//		Model model = switch (item) {
//			case ToolItem t -> Models.HANDHELD;
//			case BlockItem b -> {
//				yield Models.TEMPLATE_COMMAND_BLOCK;
//			}
//			default -> Models.GENERATED;
//		};
	}

}
