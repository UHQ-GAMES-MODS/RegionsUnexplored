package net.regions_unexplored.datagen.provider.registry;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import static net.regions_unexplored.registry.data.RUNoises.*;

public class RUNoiseBootstrap {
    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context) {
        register(context, WEIGHTED, 0, 1);
        register(context, SHIELD, -5, 1, 1, 1);
        register(context, SURFACE_MEDIUM, -6, 1, 2, 1.5, 1.0);
        register(context, TREE_DENSITY, -7, 2.5);
        register(context, FLOWER_DENSITY, -6, 1.75);
    }

    private static void register(BootstrapContext<NormalNoise.NoiseParameters> context, ResourceKey<NormalNoise.NoiseParameters> key, int i, double v, double... doubles) {
        context.register(key, new NormalNoise.NoiseParameters(i, v, doubles));
    }
}
