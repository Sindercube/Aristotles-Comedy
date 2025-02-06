package com.sindercube.vitapunk.registry;

import com.sindercube.vitapunk.Vitapunk;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
	public static Block NETHER_LEAD_ORE = register("nether_lead_ore", Block::new, AbstractBlock.Settings.copy(Blocks.IRON_ORE));
	public static Block SACRED_HEART = register("sacred_heart", Block::new, AbstractBlock.Settings.create());

	public static Block register(String name, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings settings) {
		return register(name, function, settings, new Item.Settings());
	}

	public static Block register(String name, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
        Identifier id = Vitapunk.of(name);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        Block block = function.apply(blockSettings);
        Registry.register(Registries.BLOCK, blockKey, block);
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
		Item item = new BlockItem(block, itemSettings);
		Registry.register(Registries.ITEM, itemKey, item);
		return block;
    }

}
