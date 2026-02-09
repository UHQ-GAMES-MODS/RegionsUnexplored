package net.regions_unexplored.config;

import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigValue;
import net.regions_unexplored.internal.config.annotation.ConfigOption;
import net.regions_unexplored.internal.config.annotation.Range;

public class RuClientConfig extends Config {
    @ConfigOption(category = "client_options")
    public static final ConfigValue<Boolean> CUSTOM_ITEMS_IN_VANILLA_CREATIVE_TABS = bool(true);

    @ConfigOption(category = "particles")
    public static final ConfigValue<Boolean> LEAVES_PARTICLES = bool(true);
    @Range(min = 0.0, max = 5.0)
    @ConfigOption(category = "particles")
    public static final ConfigValue<Float> PRISMARITE_SPARKLE_RATE = decimal(1f);

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
