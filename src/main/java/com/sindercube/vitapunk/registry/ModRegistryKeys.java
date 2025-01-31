package com.sindercube.vitapunk.registry;

import com.sindercube.vitapunk.Vitapunk;
import com.sindercube.vitapunk.content.humor.Humor;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class ModRegistryKeys {

    public static void init() {}

    public static final RegistryKey<Registry<Humor>> HUMOR = RegistryKey.ofRegistry(Vitapunk.of("humor"));

}
