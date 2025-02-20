package com.sindercube.aristotlesComedy.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.content.block.NumitronBlock;
import com.sindercube.aristotlesComedy.content.block.PhilosopherStoneBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
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

	public static Block DEEPSLATE_ZINC_ORE = register("deepslate_zinc_ore", Block::new, AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE));
    public static Block ZINC_ORE = register("zinc_ore", Block::new, AbstractBlock.Settings.copy(Blocks.IRON_ORE));
	public static Block NETHER_LEAD_ORE = register("nether_lead_ore", Block::new, AbstractBlock.Settings.copy(Blocks.IRON_ORE));
	public static Block SACRED_HEART = register("sacred_heart", PhilosopherStoneBlock::new, AbstractBlock.Settings.create());
	public static Block PHILOSOPHERS_STONE = register("philosophers_stone", PhilosopherStoneBlock::new, AbstractBlock.Settings.create());
	public static Block ASH = register("ash", SnowBlock::new, AbstractBlock.Settings.copy(Blocks.SNOW));
	public static Block ASH_BLOCK = register("ash_block", Block::new, AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK));
	public static Block NUMITRON = register("numitron", NumitronBlock::new, AbstractBlock.Settings.copy(Blocks.GLASS).luminance(s -> 2));

	public static Block register(String name, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings settings) {
		return register(name, function, settings, new Item.Settings());
	}

	public static Block register(String name, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
        Identifier id = AristotlesComedy.of(name);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        Block block = function.apply(blockSettings);
        Registry.register(Registries.BLOCK, blockKey, block);
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
		Item item = new BlockItem(block, itemSettings);
		Registry.register(Registries.ITEM, itemKey, item);
		return block;
    }

}
