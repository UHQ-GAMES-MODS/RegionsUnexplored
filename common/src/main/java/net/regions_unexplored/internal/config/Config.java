package net.regions_unexplored.internal.config;

import net.regions_unexplored.Constants;
import net.regions_unexplored.internal.config.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Annotation-based configuration system.
 * Config values are defined using @ConfigOption and related annotations.
 */
public abstract class Config {
    private final Map<String, ConfigValue<?>> configValues = new LinkedHashMap<>();

    /**
     * Process annotations on this config class and register all config values.
     * This is called automatically by ConfigManager after instantiation.
     */
    public void processAnnotations() {
        Class<?> clazz = this.getClass();
        Constants.LOG.debug("Processing annotations for config class: {}", clazz.getName());

        for (Field field : clazz.getDeclaredFields()) {
            // Only process public static fields with @ConfigOption
            if (!Modifier.isStatic(field.getModifiers()) ||
                    !Modifier.isPublic(field.getModifiers()) ||
                    !field.isAnnotationPresent(ConfigOption.class)) {
                continue;
            }

            // Field must be of type ConfigValue
            if (!ConfigValue.class.isAssignableFrom(field.getType())) {
                Constants.LOG.warn("Field {} has @ConfigOption but is not of type ConfigValue", field.getName());
                continue;
            }

            try {
                field.setAccessible(true);
                ConfigValue<?> configValue = (ConfigValue<?>) field.get(null);

                if (configValue == null) {
                    Constants.LOG.warn("Field {} is null, skipping", field.getName());
                    continue;
                }

                // Process @ConfigOption annotation
                ConfigOption option = field.getAnnotation(ConfigOption.class);
                processConfigOption(configValue, option, field.getName());

                // Process @Range annotation
                if (field.isAnnotationPresent(Range.class)) {
                    Range range = field.getAnnotation(Range.class);
                    processRange(configValue, range);
                }

                // Process @AllowedValues annotation
                if (field.isAnnotationPresent(AllowedValues.class)) {
                    AllowedValues allowed = field.getAnnotation(AllowedValues.class);
                    processAllowedValues(configValue, allowed);
                }

                // Process @RequiresRestart annotation
                if (field.isAnnotationPresent(RequiresRestart.class)) {
                    configValue.setRequiresRestart(true);
                }

                // Register the config value
                String key = configValue.getKey();
                configValues.put(key, configValue);
                Constants.LOG.debug("Registered config value: {} = {}", key, configValue.get());

            } catch (IllegalAccessException e) {
                Constants.LOG.error("Failed to access field {}", field.getName(), e);
            }
        }
    }

    private void processConfigOption(ConfigValue<?> configValue, ConfigOption option, String fieldName) {
        // Set comment if provided
        if (!option.comment().isEmpty()) {
            configValue.setComment(option.comment());
        }

        // Set category if provided
        if (!option.category().isEmpty()) {
            configValue.setCategory(option.category());
        }

        // Determine the key to use
        String key = option.key();
        if (key.isEmpty()) {
            // Auto-generate key from field name
            key = toSnakeCase(fieldName);
        }

        // Set the key if it's empty or different
        if (configValue.getKey().isEmpty() || !configValue.getKey().equals(key)) {
            configValue.setKey(key);
            Constants.LOG.debug("Set config key for field {} to '{}'", fieldName, key);
        }
    }

    private void processRange(ConfigValue<?> configValue, Range range) {
        double min = range.min();
        double max = range.max();

        // Only set if not infinity
        if (!Double.isInfinite(min) || !Double.isInfinite(max)) {
            configValue.setRange(
                    Double.isInfinite(min) ? Double.NEGATIVE_INFINITY : min,
                    Double.isInfinite(max) ? Double.POSITIVE_INFINITY : max
            );
            Constants.LOG.debug("Set range for {}: [{}, {}]", configValue.getKey(), min, max);
        }
    }

    private void processAllowedValues(ConfigValue<?> configValue, AllowedValues allowed) {
        if (allowed.value().length > 0) {
            configValue.setAllowedValues(allowed.value());
            Constants.LOG.debug("Set allowed values for {}: {}",
                    configValue.getKey(), String.join(", ", allowed.value()));
        }
    }

    /**
     * Converts a field name from camelCase to snake_case.
     * @param fieldName The field name
     * @return The snake_case version
     */
    private String toSnakeCase(String fieldName) {
        return fieldName
                .replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
                .replaceAll("([a-z])([A-Z])", "$1_$2")
                .toLowerCase();
    }

    /**
     * Gets all registered config values.
     * @return List of config values
     */
    public List<ConfigValue<?>> getConfigValues() {
        return new ArrayList<>(configValues.values());
    }

    /**
     * Gets a config value by key.
     * @param key The config key
     * @return The config value, or null if not found
     */
    protected ConfigValue<?> getConfigValue(String key) {
        return configValues.get(key);
    }

    /**
     * Helper method to create a boolean config value.
     */
    protected static ConfigValue<Boolean> bool(boolean defaultValue) {
        return new ConfigValue<>("", defaultValue);
    }

    /**
     * Helper method to create an integer config value.
     */
    protected static ConfigValue<Integer> integer(int defaultValue) {
        return new ConfigValue<>("", defaultValue);
    }

    /**
     * Helper method to create a double config value.
     */
    protected static ConfigValue<Double> number(double defaultValue) {
        return new ConfigValue<>("", defaultValue);
    }

    /**
     * Helper method to create a float config value.
     */
    protected static ConfigValue<Float> decimal(float defaultValue) {
        return new ConfigValue<>("", defaultValue);
    }

    /**
     * Helper method to create a long config value.
     */
    protected static ConfigValue<Long> longNum(long defaultValue) {
        return new ConfigValue<>("", defaultValue);
    }

    /**
     * Helper method to create a string config value.
     */
    protected static ConfigValue<String> text(String defaultValue) {
        return new ConfigValue<>("", defaultValue);
    }
}
