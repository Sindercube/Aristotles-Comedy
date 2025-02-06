package com.sindercube.vitapunk.registry;

import com.sindercube.vitapunk.Vitapunk;
import com.sindercube.vitapunk.content.humor.Humor;
import net.minecraft.registry.Registry;

public class ModHumors {

    public static void init() {}

    public static Humor BLOOD = register("blood", new Humor());
    public static Humor YELLOW_BILE = register("yellow_bile", new Humor());
    public static Humor BLACK_BILE = register("black_bile", new Humor());
    public static Humor PHLEGHM = register("phleghm", new Humor());

    public static Humor register(String name, Humor humor) {
        return Registry.register(ModRegistries.HUMOR, Vitapunk.of(name), humor);
    }

}
