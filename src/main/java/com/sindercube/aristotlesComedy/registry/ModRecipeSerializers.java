package com.sindercube.aristotlesComedy.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.content.recipe.TransmutationRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeSerializers {

	public static void init() {}

	public static final RecipeSerializer<TransmutationRecipe> TRANSMUTATION = register("transmutation", TransmutationRecipe.SERIALIZER);

	static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String name, S serializer) {
		Identifier id = AristotlesComedy.of(name);
		return Registry.register(Registries.RECIPE_SERIALIZER, id, serializer);
	}

}
