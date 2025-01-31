package com.sindercube.vitapunk.content.recipe.input;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record TransmutationRecipeInput (
        ItemStack ingredient
) implements RecipeInput {

    public static Codec<TransmutationRecipeInput> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ItemStack.CODEC.fieldOf("ingredient").forGetter(TransmutationRecipeInput::ingredient)
    ).apply(instance, TransmutationRecipeInput::new));

    @Override
    public ItemStack getStackInSlot(int slot) {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

}
