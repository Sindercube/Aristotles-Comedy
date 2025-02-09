package com.sindercube.aristotlesComedy.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static void init() {}

	public static final FoodComponent ASH_SOUP_FOOD_COMPONENT = new FoodComponent.Builder()
		.nutrition(-2).saturationModifier(-0.2f).alwaysEdible().usingConvertsTo(Items.BOWL).build();

    public static final Item RAW_NICKEL = register("raw_nickel", Item::new, new Item.Settings());
	public static final Item NICKEL_INGOT = register("nickel_ingot", Item::new, new Item.Settings());
	public static final Item PALLADIUM_INGOT = register("palladium_ingot", Item::new, new Item.Settings());
	public static final Item PLATINUM_INGOT = register("platinum_ingot", Item::new, new Item.Settings());
	public static final Item MERCURY_INGOT = register("mercury_ingot", Item::new, new Item.Settings());
	public static final Item RAW_LEAD = register("raw_lead", Item::new, new Item.Settings());
	public static final Item LEAD_INGOT = register("lead_ingot", Item::new, new Item.Settings());
	public static final Item ASH_SOUP = register("ash_soup", Item::new, new Item.Settings()
		.food(ASH_SOUP_FOOD_COMPONENT)
	);

	public static  Item register(String name, Function<Item.Settings, Item> function, Item.Settings settings) {
        Identifier id = AristotlesComedy.of(name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = function.apply(settings);
        return Registry.register(Registries.ITEM, key, item);
    }

}
