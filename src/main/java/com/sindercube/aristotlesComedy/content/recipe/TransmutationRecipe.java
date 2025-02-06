package com.sindercube.aristotlesComedy.content.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sindercube.aristotlesComedy.registry.ModRecipeTypes;
import com.sindercube.aristotlesComedy.util.CodecRecipeSerializer;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public record TransmutationRecipe (
	Ingredient ingredient,
	ItemStack result
) implements Recipe<RecipeInput> {

	public static final MapCodec<TransmutationRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
		Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(TransmutationRecipe::ingredient),
		ItemStack.CODEC.fieldOf("result").forGetter(TransmutationRecipe::result)
	).apply(instance, TransmutationRecipe::new));

	public static final RecipeSerializer<TransmutationRecipe> SERIALIZER = new CodecRecipeSerializer<>(CODEC);

	@Override
	public RecipeType<?> getType() {
		return ModRecipeTypes.TRANSMUTATION;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return SERIALIZER;
	}


    @Override
    public boolean matches(RecipeInput input, World world) {
        return false;
    }

    @Override
    public ItemStack craft(RecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return null;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return null;
    }

}
