package net.regions_unexplored.registry;

import io.github.uhq_games.regions_unexplored.RegionsUnexplored;
import io.github.uhq_games.regions_unexplored.data.noise.RuNoises;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class NoiseRegistry {
    public static void bootstrap(BootstapContext<NormalNoise.NoiseParameters> context) {
        RuNoises.bootstrap(context);
    }

    public static ResourceKey<NormalNoise.NoiseParameters> createKey(String name) {
        return ResourceKey.create(Registries.NOISE, RegionsUnexplored.ID(name));
    }
}
