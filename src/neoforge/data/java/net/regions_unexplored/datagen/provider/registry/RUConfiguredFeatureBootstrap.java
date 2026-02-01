package net.regions_unexplored.datagen.provider.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.datagen.provider.registry.configured_feature.*;

public class RUConfiguredFeatureBootstrap {
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuAquaticFeatures.bootstrap(context);
        RuMiscOverworldFeatures.bootstrap(context);
        RuNetherFeatures.bootstrap(context);
        RuTreeFeatures.bootstrap(context);
        RuVegetationFeatures.bootstrap(context);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return RegionsUnexplored.key(Registries.CONFIGURED_FEATURE, name);
    }
}
