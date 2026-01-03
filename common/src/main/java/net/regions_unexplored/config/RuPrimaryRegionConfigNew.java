package net.regions_unexplored.config;

import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigValue;
import net.regions_unexplored.internal.config.annotation.ConfigOption;
import net.regions_unexplored.world.level.biome.DefaultBiomes;

public class RuPrimaryRegionConfigNew extends Config {
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_ICY_ARID = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[0][0].location().toString());
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_ICY_DRY = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[0][1].location().toString());
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_ICY_NEUTRAL = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[0][2].location().toString());
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_ICY_WET = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[0][3].location().toString());
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_ICY_HUMID = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[0][4].location().toString());
    @ConfigOption(category = "middle_biomes.cool_biomes")
    public static final ConfigValue<String> MID_COOL_ARID = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[1][0].location().toString());
    @ConfigOption(category = "middle_biomes.cool_biomes")
    public static final ConfigValue<String> MID_COOL_DRY = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[1][1].location().toString());
    @ConfigOption(category = "middle_biomes.cool_biomes")
    public static final ConfigValue<String> MID_COOL_NEUTRAL = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[1][2].location().toString());
    @ConfigOption(category = "middle_biomes.icy_biomes")
    public static final ConfigValue<String> MID_COOL_WET = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[1][3].location().toString());
    @ConfigOption(category = "middle_biomes.cool_biomes")
    public static final ConfigValue<String> MID_COOL_HUMID = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[1][4].location().toString());
    @ConfigOption(category = "middle_biomes.neutral_biomes")
    public static final ConfigValue<String> MID_NEUTRAL_ARID = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[2][0].location().toString());
    @ConfigOption(category = "middle_biomes.neutral_biomes")
    public static final ConfigValue<String> MID_NEUTRAL_DRY = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[2][1].location().toString());
    @ConfigOption(category = "middle_biomes.neutral_biomes")
    public static final ConfigValue<String> MID_NEUTRAL_NEUTRAL = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[2][2].location().toString());
    @ConfigOption(category = "middle_biomes.neutral_biomes")
    public static final ConfigValue<String> MID_NEUTRAL_WET = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[2][3].location().toString());
    @ConfigOption(category = "middle_biomes.neutral_biomes")
    public static final ConfigValue<String> MID_NEUTRAL_HUMID = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[2][4].location().toString());
    @ConfigOption(category = "middle_biomes.warm_biomes")
    public static final ConfigValue<String> MID_WARM_ARID = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[3][0].location().toString());
    @ConfigOption(category = "middle_biomes.warm_biomes")
    public static final ConfigValue<String> MID_WARM_DRY = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[3][1].location().toString());
    @ConfigOption(category = "middle_biomes.warm_biomes")
    public static final ConfigValue<String> MID_WARM_NEUTRAL = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[3][2].location().toString());
    @ConfigOption(category = "middle_biomes.warm_biomes")
    public static final ConfigValue<String> MID_WARM_WET = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[3][3].location().toString());
    @ConfigOption(category = "middle_biomes.warm_biomes")
    public static final ConfigValue<String> MID_WARM_HUMID = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[3][4].location().toString());
    @ConfigOption(category = "middle_biomes.hot_biomes")
    public static final ConfigValue<String> MID_HOT_ARID = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[4][0].location().toString());
    @ConfigOption(category = "middle_biomes.hot_biomes")
    public static final ConfigValue<String> MID_HOT_DRY = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[4][1].location().toString());
    @ConfigOption(category = "middle_biomes.hot_biomes")
    public static final ConfigValue<String> MID_HOT_NEUTRAL = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[4][2].location().toString());
    @ConfigOption(category = "middle_biomes.hot_biomes")
    public static final ConfigValue<String> MID_HOT_WET = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[4][3].location().toString());
    @ConfigOption(category = "middle_biomes.hot_biomes")
    public static final ConfigValue<String> MID_HOT_HUMID = text(DefaultBiomes.PRIMARY_MIDDLE_BIOMES[4][4].location().toString());

}
