package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.RegionsUnexplored;

public interface RUPlacedFeatures {
    static ResourceKey<PlacedFeature> key(String name) {
        return RegionsUnexplored.key(Registries.PLACED_FEATURE, name);
    }

    static ResourceKey<ConfiguredFeature<?, ?>> toConfigured(ResourceKey<PlacedFeature> placedKey) {
        return RegionsUnexplored.key(Registries.CONFIGURED_FEATURE, placedKey.identifier().getPath());
    }
}
