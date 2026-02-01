package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.regions_unexplored.RegionsUnexplored;

public interface RUNoises {
    @Deprecated(forRemoval = true)
    ResourceKey<NormalNoise.NoiseParameters> WEIGHTED = key("weighted");
    ResourceKey<NormalNoise.NoiseParameters> SHIELD = key("shield");

    static ResourceKey<NormalNoise.NoiseParameters> key(String name) {
        return RegionsUnexplored.key(Registries.NOISE, name);
    }
}
