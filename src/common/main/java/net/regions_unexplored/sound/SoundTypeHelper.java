package net.regions_unexplored.sound;

import net.minecraft.world.level.block.SoundType;

import static net.regions_unexplored.registry.RUSoundEvents.register;

public class SoundTypeHelper {
    public static SoundType create(String name) {
        return new SoundType(
            1f,
            1f,
            register(id(name, ".break")),
            register(id(name, ".step")),
            register(id(name, ".place")),
            register(id(name, ".hit")),
            register(id(name, ".fall"))
        );
    }

    private static String id(String baseName, String suffix) {
        return "block." + baseName + suffix;
    }
}
