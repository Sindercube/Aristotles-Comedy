package com.sindercube.aristotlesComedy.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.content.block.*;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ACBlocks {

    public static void init() {}

	public static Block DEEPSLATE_ZINC_ORE = register("deepslate_tin_ore", AbstractBlock.Settings.copy(Blocks.DEEPSLATE_COPPER_ORE));
    public static Block TIN_ORE = register("tin_ore", AbstractBlock.Settings.copy(Blocks.COPPER_ORE));
	public static Block NETHER_LEAD_ORE = register("nether_lead_ore", AbstractBlock.Settings.copy(Blocks.IRON_ORE));

	public static Block LEAD_BARREL = register("lead_barrel", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK));
	public static Block LEAD_BARS = register("lead_bars", PaneBlock::new, AbstractBlock.Settings.copy(Blocks.IRON_BARS));
	public static Block BRAZIER = register("brazier", settings -> new BrazierBlock(true, settings), AbstractBlock.Settings.copy(Blocks.IRON_BARS));
	public static Block SOUL_BRAZIER = register("soul_brazier", settings -> new BrazierBlock(false, settings), AbstractBlock.Settings.copy(Blocks.IRON_BARS));

	public static Block SACRED_HEART = register("sacred_heart", PhilosopherStoneBlock::new, AbstractBlock.Settings.create());
	public static Block PHILOSOPHERS_STONE = register("philosophers_stone", PhilosopherStoneBlock::new, AbstractBlock.Settings.create());
	public static Block ASH = register("ash", SnowBlock::new, AbstractBlock.Settings.copy(Blocks.SNOW));
	public static Block ASH_BLOCK = register("ash_block", Block::new, AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK));
	public static Block NUMITRON = register("numitron", NumitronBlock::new, AbstractBlock.Settings.copy(Blocks.GLASS).luminance(s -> 2));

	public static Block ATHANOR = register("athanor", AthanorBlock::new, AbstractBlock.Settings.copy(Blocks.FURNACE));
	public static Block ALEMBIC = register("alembic", AlembicBlock::new, AbstractBlock.Settings.copy(Blocks.GLASS));

	public static Block register(String name, AbstractBlock.Settings settings) {
		return register(name, Block::new, settings);
	}

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
