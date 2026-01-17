package net.regions_unexplored.config;

import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigValue;
import net.regions_unexplored.internal.config.annotation.ConfigOption;
import net.regions_unexplored.internal.config.annotation.Range;
import net.regions_unexplored.internal.config.annotation.RequiresRestart;

public class RuCommonConfig extends Config {
    @RequiresRestart(RequiresRestart.RestartType.GAME)
    @ConfigOption(comment = "Enable this before changing the other region config files. If disabled, RU will use builtin biome placement.")
    public static final ConfigValue<Boolean> TOGGLE_CUSTOM_REGIONS = bool(false);
    @Range(min = 0, max = 2147483646)
    @RequiresRestart(RequiresRestart.RestartType.GAME)
    @ConfigOption(comment = "Sets Terrablender region weight for the primary region.")
    public static final ConfigValue<Integer> REGION_PRIMARY_WEIGHT = integer(11);
    @Range(min = 0, max = 2147483646)
    @RequiresRestart(RequiresRestart.RestartType.GAME)
    @ConfigOption(comment = "Sets Terrablender region weight for the secondary region.")
    public static final ConfigValue<Integer> REGION_SECONDARY_WEIGHT = integer(8);
    @Range(min = 0, max = 2147483646)
    @RequiresRestart(RequiresRestart.RestartType.GAME)
    @ConfigOption(comment = "Sets Terrablender region weight for the rare region.")
    public static final ConfigValue<Integer> REGION_RARE_WEIGHT = integer(1);
    @Range(min = 0, max = 2147483646)
    @RequiresRestart(RequiresRestart.RestartType.GAME)
    @ConfigOption(comment = "Sets Terrablender region weight for Nether region.")
    public static final ConfigValue<Integer> REGION_NETHER_WEIGHT = integer(14);

    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ALPHA_GROVE = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ARID_MOUNTAINS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ASHEN_WOODLAND = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_AUTUMNAL_MAPLE_FOREST = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BAMBOO_FOREST = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BAOBAB_SAVANNA = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BARLEY_FIELDS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BAYOU = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BLACKWOOD_TAIGA = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BOREAL_TAIGA = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_CHALK_CLIFFS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_CLOVER_PLAINS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_COLD_BOREAL_TAIGA = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_COLD_DECIDUOUS_FOREST = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_COLD_RIVER = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_DECIDUOUS_FOREST = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_DRY_BUSHLAND = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_EUCALYPTUS_FOREST = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_FEN = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_FLOWER_FIELDS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_FROZEN_PINE_TAIGA = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_FROZEN_TUNDRA = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_FUNGAL_FEN = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_GOLDEN_BOREAL_TAIGA = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_GRASSLAND = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_GRASSY_BEACH = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_GRAVEL_BEACH = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_HIGHLAND_FIELDS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_HYACINTH_DEEPS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ICY_DESERT = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ICY_HEIGHTS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_JOSHUA_DESERT = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MAGNOLIA_WOODLAND = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MAPLE_FOREST = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MARSH = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MAUVE_HILLS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MEADOW = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MOUNTAINS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MUDDY_RIVER = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_OLD_GROWTH_BAYOU = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ORCHARD = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_OUTBACK = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_PINE_SLOPES = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_PINE_TAIGA = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_POPPY_FIELDS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_PRAIRIE = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_PUMPKIN_FIELDS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_RAINFOREST = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ROCKY_REEF = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_REDWOODS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SAGUARO_DESERT = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SHRUBLAND = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SILVER_BIRCH_FOREST = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SPARSE_RAINFOREST = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SPARSE_REDWOODS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SPIRES = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_STEPPE = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_TEMPERATE_GROVE = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_TOWERING_CLIFFS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_TROPICAL_RIVER = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_TROPICS = bool(true);
    @ConfigOption(category = "overworld_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_WILLOW_FOREST = bool(true);

    @ConfigOption(category = "overworld_cave_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_ANCIENT_DELTA = bool(true);
    @ConfigOption(category = "overworld_cave_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BIOSHROOM_CAVES = bool(true);
    @ConfigOption(category = "overworld_cave_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_PRISMACHASM = bool(true);
    @ConfigOption(category = "overworld_cave_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_REDSTONE_CAVES = bool(true);
    @ConfigOption(category = "overworld_cave_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_SCORCHING_CAVES = bool(true);

    @ConfigOption(category = "nether_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_BLACKSTONE_BASIN = bool(true);
    @ConfigOption(category = "nether_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_GLISTERING_MEADOW = bool(true);
    @ConfigOption(category = "nether_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_INFERNAL_HOLT = bool(true);
    @ConfigOption(category = "nether_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_MYCOTOXIC_UNDERGROWTH = bool(true);
    @ConfigOption(category = "nether_biome_toggles")
    public static final ConfigValue<Boolean> TOGGLE_REDSTONE_ABYSS = bool(true);

    @ConfigOption(category = "worldgen_surface_rules")
    public static final ConfigValue<Boolean> TOGGLE_CUSTOM_DIRTS = bool(true);
}