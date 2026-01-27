package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.RegionsUnexplored;

public interface RUPlacedFeatures {
    ResourceKey<PlacedFeature> BONEMEAL_ALPHA_GRASS = key("bonemeal/grass/alpha");
    ResourceKey<PlacedFeature> BONEMEAL_ARGILLITE_GRASS = key("bonemeal/grass/argillite");
    ResourceKey<PlacedFeature> BONEMEAL_CHALK_GRASS = key("bonemeal/grass/chalk");
    ResourceKey<PlacedFeature> BONEMEAL_DEEPSLATE_GRASS = key("bonemeal/grass/deepslate");
    ResourceKey<PlacedFeature> BONEMEAL_PEAT_GRASS = key("bonemeal/grass/peat");
    ResourceKey<PlacedFeature> BONEMEAL_SILT_GRASS = key("bonemeal/grass/silt");
    ResourceKey<PlacedFeature> BONEMEAL_STONE_GRASS = key("bonemeal/grass/stone");

    static ResourceKey<PlacedFeature> key(String name) {
        return RegionsUnexplored.key(Registries.PLACED_FEATURE, name);
    }
}
