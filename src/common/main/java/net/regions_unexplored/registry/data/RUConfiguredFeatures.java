package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.RegionsUnexplored;

public interface RUConfiguredFeatures {
    ResourceKey<ConfiguredFeature<?, ?>> BONEMEAL_ALPHA_GRASS = key("bonemeal/grass/alpha");
    ResourceKey<ConfiguredFeature<?, ?>> BONEMEAL_MYCOTOXIC_NYLIUM = key("bonemeal/nylium/mycotoxic");
    ResourceKey<ConfiguredFeature<?, ?>> BONEMEAL_GLISTERING_NYLIUM = key("bonemeal/nylium/glistering");
    ResourceKey<ConfiguredFeature<?, ?>> BONEMEAL_COBALT_NYLIUM = key("bonemeal/nylium/cobalt");
    ResourceKey<ConfiguredFeature<?, ?>> BONEMEAL_BRIMSPROUT_NYLIUM = key("bonemeal/nylium/brimsprout");

    static ResourceKey<ConfiguredFeature<?, ?>> key(String name) {
        return RegionsUnexplored.key(Registries.CONFIGURED_FEATURE, name);
    }
}
