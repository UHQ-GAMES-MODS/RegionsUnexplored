package net.regions_unexplored.config;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigValue;
import net.regions_unexplored.internal.config.annotation.ConfigOption;
import net.regions_unexplored.registry.data.RUBiomes;

import java.util.HashMap;
import java.util.Map;

public class RuCommonConfig extends Config {
    public static final Map<ResourceKey<Biome>, ConfigValue<Boolean>> BIOME_CONFIGS = new HashMap<>();
    
    @ConfigOption(category = "features")
    public static final ConfigValue<Boolean> USE_LOGS_FOR_BRANCHES = bool(false);

    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ALPHA_GROVE = biome(RUBiomes.ALPHA_GROVE);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ARID_MOUNTAINS = biome(RUBiomes.ARID_MOUNTAINS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ASHEN_WOODLAND = biome(RUBiomes.ASHEN_WOODLAND);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_AUTUMNAL_MAPLE_FOREST = biome(RUBiomes.AUTUMNAL_MAPLE_FOREST);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BAMBOO_FOREST = biome(RUBiomes.BAMBOO_FOREST);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BAOBAB_SAVANNA = biome(RUBiomes.BAOBAB_SAVANNA);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BARLEY_FIELDS = biome(RUBiomes.BARLEY_FIELDS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BAYOU = biome(RUBiomes.BAYOU);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BLACKWOOD_TAIGA = biome(RUBiomes.BLACKWOOD_TAIGA);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BOREAL_TAIGA = biome(RUBiomes.BOREAL_TAIGA);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_CHALK_CLIFFS = biome(RUBiomes.CHALK_CLIFFS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_CLOVER_PLAINS = biome(RUBiomes.CLOVER_PLAINS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_COLD_BOREAL_TAIGA = biome(RUBiomes.COLD_BOREAL_TAIGA);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_COLD_DECIDUOUS_FOREST = biome(RUBiomes.COLD_DECIDUOUS_FOREST);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_COLD_RIVER = biome(RUBiomes.COLD_RIVER);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_DECIDUOUS_FOREST = biome(RUBiomes.DECIDUOUS_FOREST);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_DRY_BUSHLAND = biome(RUBiomes.DRY_BUSHLAND);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_EUCALYPTUS_FOREST = biome(RUBiomes.EUCALYPTUS_FOREST);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_FEN = biome(RUBiomes.FEN);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_FLOWER_FIELDS = biome(RUBiomes.FLOWER_FIELDS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_FROZEN_PINE_TAIGA = biome(RUBiomes.FROZEN_PINE_TAIGA);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_FROZEN_TUNDRA = biome(RUBiomes.FROZEN_TUNDRA);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_FUNGAL_FEN = biome(RUBiomes.FUNGAL_FEN);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_GOLDEN_BOREAL_TAIGA = biome(RUBiomes.GOLDEN_BOREAL_TAIGA);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_GRASSLAND = biome(RUBiomes.GRASSLAND);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_GRASSY_BEACH = biome(RUBiomes.GRASSY_BEACH);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_GRAVEL_BEACH = biome(RUBiomes.GRAVEL_BEACH);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_HIGHLAND_FIELDS = biome(RUBiomes.HIGHLAND_FIELDS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_HYACINTH_DEEPS = biome(RUBiomes.HYACINTH_DEEPS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ICY_HEIGHTS = biome(RUBiomes.ICY_HEIGHTS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_JOSHUA_DESERT = biome(RUBiomes.JOSHUA_DESERT);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MAGNOLIA_WOODLAND = biome(RUBiomes.MAGNOLIA_WOODLAND);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MAPLE_FOREST = biome(RUBiomes.MAPLE_FOREST);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MARSH = biome(RUBiomes.MARSH);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MAUVE_HILLS = biome(RUBiomes.MAUVE_HILLS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ROCKY_MEADOW = biome(RUBiomes.ROCKY_MEADOW);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MOUNTAINS = biome(RUBiomes.MOUNTAINS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MUDDY_RIVER = biome(RUBiomes.MUDDY_RIVER);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_OLD_GROWTH_BAYOU = biome(RUBiomes.OLD_GROWTH_BAYOU);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ORCHARD = biome(RUBiomes.ORCHARD);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_OUTBACK = biome(RUBiomes.OUTBACK);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_PINE_SLOPES = biome(RUBiomes.PINE_SLOPES);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_PINE_TAIGA = biome(RUBiomes.PINE_TAIGA);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_POPPY_FIELDS = biome(RUBiomes.POPPY_FIELDS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_PRAIRIE = biome(RUBiomes.PRAIRIE);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_PUMPKIN_FIELDS = biome(RUBiomes.PUMPKIN_FIELDS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_RAINFOREST = biome(RUBiomes.RAINFOREST);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ROCKY_REEF = biome(RUBiomes.ROCKY_REEF);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_REDWOODS = biome(RUBiomes.REDWOODS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SAGUARO_DESERT = biome(RUBiomes.SAGUARO_DESERT);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SHRUBLAND = biome(RUBiomes.SHRUBLAND);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SILVER_BIRCH_FOREST = biome(RUBiomes.SILVER_BIRCH_FOREST);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SPARSE_RAINFOREST = biome(RUBiomes.SPARSE_RAINFOREST);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SPARSE_REDWOODS = biome(RUBiomes.SPARSE_REDWOODS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SPIRES = biome(RUBiomes.SPIRES);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_STEPPE = biome(RUBiomes.STEPPE);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_TEMPERATE_GROVE = biome(RUBiomes.TEMPERATE_GROVE);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_TOWERING_CLIFFS = biome(RUBiomes.TOWERING_CLIFFS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_TROPICAL_RIVER = biome(RUBiomes.TROPICAL_RIVER);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_TROPICS = biome(RUBiomes.TROPICS);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_WILLOW_FOREST = biome(RUBiomes.WILLOW_FOREST);

    @ConfigOption(category = "overworld_cave_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ANCIENT_DELTA = biome(RUBiomes.ANCIENT_DELTA);
    @ConfigOption(category = "overworld_cave_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BIOSHROOM_CAVES = biome(RUBiomes.BIOSHROOM_CAVES);
    @ConfigOption(category = "overworld_cave_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_PRISMACHASM = biome(RUBiomes.PRISMACHASM);
    @ConfigOption(category = "overworld_cave_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_REDSTONE_CAVES = biome(RUBiomes.REDSTONE_CAVES);
    @ConfigOption(category = "overworld_cave_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SCORCHING_CAVES = biome(RUBiomes.SCORCHING_CAVES);

    @ConfigOption(category = "nether_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BLACKSTONE_BASIN = biome(RUBiomes.BLACKSTONE_BASIN);
    @ConfigOption(category = "nether_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_GLISTERING_MEADOW = biome(RUBiomes.GLISTERING_MEADOW);
    @ConfigOption(category = "nether_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_INFERNAL_HOLT = biome(RUBiomes.INFERNAL_HOLT);
    @ConfigOption(category = "nether_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MYCOTOXIC_UNDERGROWTH = biome(RUBiomes.MYCOTOXIC_UNDERGROWTH);
    @ConfigOption(category = "nether_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_REDSTONE_ABYSS = biome(RUBiomes.REDSTONE_ABYSS);

    @ConfigOption(category = "worldgen_surface_rules")
    public static final ConfigValue<Boolean> TOGGLE_CUSTOM_DIRTS = bool(true);
    
    private static ConfigValue<Boolean> biome(ResourceKey<Biome> biome) {
        var config = bool(true);
        BIOME_CONFIGS.put(biome, config);
        return config;
    }
}