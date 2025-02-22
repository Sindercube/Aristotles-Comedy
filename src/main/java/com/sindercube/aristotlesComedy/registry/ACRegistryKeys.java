package com.sindercube.aristotlesComedy.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.content.humor.Humor;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class ACRegistryKeys {

    public static void init() {}

    public static final RegistryKey<Registry<Humor>> HUMOR = RegistryKey.ofRegistry(AristotlesComedy.of("humor"));

}
