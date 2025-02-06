package com.sindercube.vitapunk.registry;

import com.sindercube.vitapunk.Vitapunk;
import com.sindercube.vitapunk.content.recipe.TransmutationRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeTypes {

	public static void init() {}

	public static final RecipeType<TransmutationRecipe> TRANSMUTATION = register("transmutation");

	static <T extends Recipe<?>> RecipeType<T> register(String name) {
		Identifier id = Vitapunk.of(name);
		return Registry.register(Registries.RECIPE_TYPE, id, new RecipeType<T>() {
			public String toString() {
				return id.toString();
			}
		});
	}

}
