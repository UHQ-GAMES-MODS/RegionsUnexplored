package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.regions_unexplored.RegionsUnexplored;

public interface RUNoises {
    @Deprecated(forRemoval = true)
    ResourceKey<NormalNoise.NoiseParameters> WEIGHTED = key("weighted");
    ResourceKey<NormalNoise.NoiseParameters> SHIELD = key("shield");
    ResourceKey<NormalNoise.NoiseParameters> SURFACE_MEDIUM = key("surface_medium");
    ResourceKey<NormalNoise.NoiseParameters> TREE_DENSITY = key("tree_density");
    ResourceKey<NormalNoise.NoiseParameters> FLOWER_DENSITY = key("flower_density");

    static ResourceKey<NormalNoise.NoiseParameters> key(String name) {
        return RegionsUnexplored.key(Registries.NOISE, name);
    }
}
