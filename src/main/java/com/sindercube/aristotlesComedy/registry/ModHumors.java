package com.sindercube.aristotlesComedy.registry;

import com.sindercube.aristotlesComedy.AristotlesComedy;
import com.sindercube.aristotlesComedy.content.humor.Humor;
import net.minecraft.registry.Registry;

public class ModHumors {

    public static void init() {}

    public static Humor BLOOD = register("blood", new Humor());
    public static Humor YELLOW_BILE = register("yellow_bile", new Humor());
    public static Humor BLACK_BILE = register("black_bile", new Humor());
    public static Humor PHLEGHM = register("phleghm", new Humor());

    public static Humor register(String name, Humor humor) {
        return Registry.register(ModRegistries.HUMOR, AristotlesComedy.of(name), humor);
    }

}
