package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
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

    static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context) {
        register(context, WEIGHTED, 0, 1.0D);
        register(context, SHIELD, -5, 1.0D, 1.0D, 1.0D);
    }

    private static void register(BootstrapContext<NormalNoise.NoiseParameters> context, ResourceKey<NormalNoise.NoiseParameters> key, int i, double v, double... doubles) {
        context.register(key, new NormalNoise.NoiseParameters(i, v, doubles));
    }
}
