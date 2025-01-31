package com.sindercube.vitapunk.registry;

import com.sindercube.vitapunk.Vitapunk;
import com.sindercube.vitapunk.content.humor.Humor;
import net.minecraft.registry.Registry;

public class ModHumors {

    public static void init() {}

    public static Humor BLOOD = new Humor();
    public static Humor YELLOW_BILE = new Humor();
    public static Humor BLACK_BILE = new Humor();
    public static Humor PHLEGHM = new Humor();

    public static Humor register(String name, Humor humor) {
        return Registry.register(ModRegistries.HUMOR, Vitapunk.of(name), humor);
    }

}
