package com.sindercube.aristotlesComedy.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static void init() {}

    public static Item RAW_NICKEL = register("raw_nickel", Item::new, new Item.Settings());
	public static Item NICKEL_INGOT = register("nickel_ingot", Item::new, new Item.Settings());
	public static Item PALLADIUM_INGOT = register("palladium_ingot", Item::new, new Item.Settings());
	public static Item PLATINUM_INGOT = register("platinum_ingot", Item::new, new Item.Settings());
	public static Item MERCURY_INGOT = register("mercury_ingot", Item::new, new Item.Settings());
	public static Item RAW_LEAD = register("raw_lead", Item::new, new Item.Settings());
	public static Item LEAD_INGOT = register("lead_ingot", Item::new, new Item.Settings());

	public static Item register(String name, Function<Item.Settings, Item> function, Item.Settings settings) {
        Identifier id = AristotlesComedy.of(name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = function.apply(settings);
        return Registry.register(Registries.ITEM, key, item);
    }

}
