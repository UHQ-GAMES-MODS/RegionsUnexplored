package net.regions_unexplored.config;

import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigValue;
import net.regions_unexplored.internal.config.annotation.ConfigOption;

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


    @ConfigOption(category = "block_color_options")
    public static final ConfigValue<Boolean> EUCALYPTUS_TRANSITION_SIZE = bool(true);
    @ConfigOption(category = "block_color_options")
    public static final ConfigValue<Boolean> EUCALYPTUS_SATURATION = bool(true);
    @ConfigOption(category = "block_color_options")
    public static final ConfigValue<Boolean> EUCALYPTUS_BRIGHTNESS = bool(true);
}
