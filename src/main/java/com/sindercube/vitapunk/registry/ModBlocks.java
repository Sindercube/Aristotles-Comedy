package com.sindercube.vitapunk.registry;

import com.sindercube.vitapunk.Vitapunk;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static void init() {}

	public static Block DEEPSLATE_NICKEL_ORE = register("deepslate_nickel_ore", Block::new, AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE));
    public static Block NICKEL_ORE = register("nickel_ore", Block::new, AbstractBlock.Settings.copy(Blocks.IRON_ORE));

	public static Block register(String name, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings settings) {
        Identifier id = Vitapunk.of(name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        Block block = function.apply(settings);
        return Registry.register(Registries.BLOCK, key, block);
    }

}
