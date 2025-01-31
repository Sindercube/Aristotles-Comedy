package com.sindercube.vitapunk.content.recipe;

import com.sindercube.vitapunk.content.recipe.input.TransmutationRecipeInput;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class TransmutationRecipe implements Recipe<TransmutationRecipeInput> {

    @Override
    public boolean matches(TransmutationRecipeInput input, World world) {
        return false;
    }

    @Override
    public ItemStack craft(TransmutationRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
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

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }

}
