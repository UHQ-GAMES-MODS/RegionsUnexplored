package net.regions_unexplored.registry;

import io.github.uhq_games.regions_unexplored.RegionsUnexplored;
import io.github.uhq_games.regions_unexplored.data.worldgen.features.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
public class ConfiguredFeatureRegistry {
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuAquaticFeatures.bootstrap(context);
        RuMiscOverworldFeatures.bootstrap(context);
        RuNetherFeatures.bootstrap(context);
        RuTreeFeatures.bootstrap(context);
        RuVegetationFeatures.bootstrap(context);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, RegionsUnexplored.ID(name));
    }
}
