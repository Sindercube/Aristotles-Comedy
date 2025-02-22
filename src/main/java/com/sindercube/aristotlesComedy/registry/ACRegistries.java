package com.sindercube.aristotlesComedy.registry;

import com.mojang.serialization.Lifecycle;
import com.sindercube.aristotlesComedy.content.humor.Humor;
import net.minecraft.registry.*;

public class ACRegistries {

    public static void init() {}

    public static final Registry<Humor> HUMOR = new SimpleRegistry<>(ACRegistryKeys.HUMOR, Lifecycle.stable());

}
