package net.regions_unexplored.config;

import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigValue;
import net.regions_unexplored.internal.config.annotation.ConfigOption;
import net.regions_unexplored.internal.config.annotation.Range;

public class RuClientConfig extends Config {
    @ConfigOption(category = "client_options")
    public static final ConfigValue<Boolean> TOGGLE_MAUVE_LEAVES_PARTICLE = bool(true);
    @ConfigOption(category = "client_options")
    public static final ConfigValue<Boolean> TOGGLE_BLUE_MAGNOLIA_LEAVES_PARTICLE = bool(true);
    @ConfigOption(category = "client_options")
    public static final ConfigValue<Boolean> TOGGLE_PINK_MAGNOLIA_LEAVES_PARTICLE = bool(true);
    @ConfigOption(category = "client_options")
    public static final ConfigValue<Boolean> TOGGLE_WHITE_MAGNOLIA_LEAVES_PARTICLE = bool(true);
    @ConfigOption(category = "client_options")
    public static final ConfigValue<Boolean> TOGGLE_RED_MAPLE_LEAVES_PARTICLE = bool(true);
    @ConfigOption(category = "client_options")
    public static final ConfigValue<Boolean> TOGGLE_ORANGE_MAPLE_LEAVES_PARTICLE = bool(true);
    @ConfigOption(category = "client_options")
    public static final ConfigValue<Boolean> TOGGLE_SILVER_BIRCH_LEAVES_PARTICLE = bool(true);
    @ConfigOption(category = "client_options")
    public static final ConfigValue<Boolean> TOGGLE_ENCHANTED_BIRCH_LEAVES_PARTICLE = bool(true);

    @Range(min = 0.0, max = 200.0)
    @ConfigOption(category = "block_color_options", comment = "Sets Eucalyptus colour transition size. Bigger number = bigger distance between colours.")
    public static final ConfigValue<Float> EUCALYPTUS_TRANSITION_SIZE = decimal(25f);
    @Range(min = 0.0, max = 1.0)
    @ConfigOption(category = "block_color_options", comment = "Sets Eucalyptus colour saturation.")
    public static final ConfigValue<Float> EUCALYPTUS_SATURATION = decimal(0.5f);
    @Range(min = 0.0, max = 1.0)
    @ConfigOption(category = "block_color_options", comment = "Sets Eucalyptus colour brightness.")
    public static final ConfigValue<Float> EUCALYPTUS_BRIGHTNESS = decimal(0.8f);
}
