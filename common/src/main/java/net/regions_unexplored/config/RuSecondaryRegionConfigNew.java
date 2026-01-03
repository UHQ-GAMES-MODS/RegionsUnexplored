package net.regions_unexplored.config;

import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigValue;
import net.regions_unexplored.internal.config.annotation.ConfigOption;
import net.regions_unexplored.world.level.biome.DefaultBiomes;

public class RuSecondaryRegionConfigNew extends Config {
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_ICY_ARID = text(DefaultBiomes.SECONDARY_MIDDLE_BIOMES[0][0].location().toString());
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_ICY_DRY = text(DefaultBiomes.SECONDARY_MIDDLE_BIOMES[0][1].location().toString());
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_ICY_NEUTRAL = text(DefaultBiomes.SECONDARY_MIDDLE_BIOMES[0][2].location().toString());
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_ICY_WET = text(DefaultBiomes.SECONDARY_MIDDLE_BIOMES[0][3].location().toString());
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_ICY_HUMID = text(DefaultBiomes.SECONDARY_MIDDLE_BIOMES[0][4].location().toString());
}
