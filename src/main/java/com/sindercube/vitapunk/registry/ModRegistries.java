package com.sindercube.vitapunk.registry;

import com.mojang.serialization.Lifecycle;
import com.sindercube.vitapunk.content.humor.Humor;
import net.minecraft.registry.*;

public class ModRegistries {

    public static void init() {}

    public static final Registry<Humor> HUMOR = new SimpleRegistry<>(ModRegistryKeys.HUMOR, Lifecycle.stable());

}
