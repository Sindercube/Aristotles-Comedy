package com.sindercube.aristotlesComedy.datagen.provider;

import com.sindercube.aristotlesComedy.registry.ACBlocks;
import com.sindercube.aristotlesComedy.registry.ACItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ACRecipeProvider extends FabricRecipeProvider {

	public ACRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generate(RecipeExporter exporter) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ACBlocks.ATHANOR)
			.input('b', ACItems.BRONZE_INGOT)
			.pattern("bbb")
			.pattern("b b")
			.pattern("bbb")
			.criterion(hasItem(ACItems.BRONZE_INGOT), conditionsFromItem(ACItems.BRONZE_INGOT))
			.offerTo(exporter);
	}

}
