package net.regions_unexplored.internal.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.Services;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Manages configuration files with annotation support.
 * Automatically processes @ConfigOption and related annotations.
 */
@SuppressWarnings("unused")
public class ConfigManager {
    private String fileName;
    private String displayName;
    private Config configFile;
    private CommentedFileConfig config;

    /**
     * Registers a configuration file with the manager.
     *
     * @param fileName The name of the config file (without extension)
     * @param configClass The Config class to instantiate
     * @return This ConfigManager instance for method chaining
     */
    public ConfigManager register(String fileName, Class<? extends Config> configClass) {
        this.fileName = fileName;
        try {
            this.configFile = configClass.getDeclaredConstructor().newInstance();

            // Process annotations to register config values
            configFile.processAnnotations();

            Constants.LOG.info("Registered annotated config: {}", fileName);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Constants.LOG.error("Failed to instantiate config class: {}", configClass.getName(), e);
            throw new RuntimeException("Failed to create config instance", e);
        }
        return this;
    }

    /**
     * Initializes the configuration by loading existing values or creating a new file.
     */
    public void initialize() {
        if (fileName == null || configFile == null) {
            throw new IllegalStateException("ConfigManager must be registered before initialization");
        }

        Path configPath = getConfigPath(fileName);
        config = CommentedFileConfig.builder(configPath)
                .defaultResource(fileName + ".toml")
                .preserveInsertionOrder()
                .sync()
                .build();

        if (!config.getFile().exists()) {
            Constants.LOG.info("Config file not found, creating new one: {}", fileName);
            store();
        } else {
            Constants.LOG.info("Loading config file: {}", fileName);
            load();
        }
    }

    /**
     * Creates and initializes a config manager in one call.
     *
     * @param filePath The name of the config file (without extension)
     * @param configClass The Config class to instantiate
     * @return Initialized ConfigManager instance
     */
    public static ConfigManager of(String filePath, Class<? extends Config> configClass) {
        ConfigManager manager = new ConfigManager();
        manager.register(filePath, configClass).initialize();
        return manager;
    }


    /**
     * Loads configuration values from the file and updates the Config object.
     */
    private void load() {
        try {
            config.load();

            // Load values from both root and categorized sections
            for (ConfigValue<?> configValue : configFile.getConfigValues()) {
                String category = configValue.getCategory();
                String key = configValue.getKey();
                Object loadedValue = null;

                // Try to load from category section first, then from root
                if (!category.isEmpty()) {
                    loadedValue = config.get(category + "." + key);
                }
                if (loadedValue == null) {
                    loadedValue = config.get(key);
                }

                if (loadedValue != null) {
                    // Convert numeric types if needed
                    Object convertedValue = convertNumericType(loadedValue, configValue.get());

                    // Validate and assign
                    if (isTypeCompatible(configValue.get(), convertedValue)) {
                        @SuppressWarnings("unchecked")
                        ConfigValue<Object> objectConfigValue = (ConfigValue<Object>) configValue;

                        // Use setValue which includes validation
                        objectConfigValue.setValue(convertedValue);

                        Constants.LOG.debug("Loaded config value: {} = {} {}",
                                key,
                                convertedValue,
                                configValue.requiresRestart() ? "(requires restart)" : "");
                    } else {
                        Constants.LOG.warn("Type mismatch for config key '{}'. Expected: {}, Found: {}. Using default value.",
                                key, configValue.get().getClass().getSimpleName(), convertedValue.getClass().getSimpleName());
                    }
                } else {
                    Constants.LOG.debug("Config key '{}' not found in file, using default: {}", key, configValue.get());
                }
            }

            // Save to update file with any missing keys and organize by category
            store();

        } catch (Exception e) {
            Constants.LOG.error("Failed to load config file: {}", fileName, e);
            throw new RuntimeException("Failed to load config", e);
        }
    }

    /**
     * Stores the current configuration values to the file.
     * Organizes values by category using TOML sections.
     */
    private void store() {
        Path path = getConfigPath(fileName);

        try {
            // Ensure parent directory exists
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }

            // Clear existing values
            config.clear();

            // Group values by category
            Map<String, List<ConfigValue<?>>> categorizedValues = new LinkedHashMap<>();

            for (ConfigValue<?> configValue : configFile.getConfigValues()) {
                String category = configValue.getCategory();
                categorizedValues
                        .computeIfAbsent(category, k -> new ArrayList<>())
                        .add(configValue);
            }

            // Write uncategorized values first (empty category)
            if (categorizedValues.containsKey("")) {
                List<ConfigValue<?>> rootValues = categorizedValues.get("");
                for (ConfigValue<?> configValue : rootValues) {
                    writeConfigValue(config, configValue, null);
                }
            }

            // Write categorized values in sections
            for (Map.Entry<String, List<ConfigValue<?>>> entry : categorizedValues.entrySet()) {
                String category = entry.getKey();

                // Skip empty category (already written)
                if (category.isEmpty()) {
                    continue;
                }

                List<ConfigValue<?>> values = entry.getValue();

                // Write values under category section
                for (ConfigValue<?> configValue : values) {
                    writeConfigValue(config, configValue, category);
                }
            }

            // Save to file
            config.save();
            Constants.LOG.debug("Saved config file: {}", fileName);

        } catch (IOException e) {
            Constants.LOG.error("Failed to save config file: {}", fileName, e);
            throw new RuntimeException("Failed to save config", e);
        }
    }

    /**
     * Writes a single config value to the config file.
     *
     * @param config The config file
     * @param configValue The config value to write
     * @param category The category (null for root level)
     */
    private void writeConfigValue(CommentedFileConfig config, ConfigValue<?> configValue, String category) {
        String key = configValue.getKey();
        String fullPath = category != null ? category + "." + key : key;

        // Set the value
        config.set(fullPath, configValue.get());

        // Build comment with metadata
        StringBuilder commentBuilder = new StringBuilder();

        if (configValue.getComment() != null && !configValue.getComment().isEmpty()) {
            commentBuilder.append(configValue.getComment());
        }

        // Add range info for numeric values
        if (configValue.getMinValue() != null || configValue.getMaxValue() != null) {
            if (!commentBuilder.isEmpty()) {
                commentBuilder.append("\n");
            }
            commentBuilder.append("Range: [");
            commentBuilder.append(configValue.getMinValue() != null ?
                    configValue.getMinValue() : "-∞");
            commentBuilder.append(", ");
            commentBuilder.append(configValue.getMaxValue() != null ?
                    configValue.getMaxValue() : "+∞");
            commentBuilder.append("]");
        }

        // Add allowed values for strings
        if (configValue.getAllowedValues() != null && !configValue.getAllowedValues().isEmpty()) {
            if (!commentBuilder.isEmpty()) {
                commentBuilder.append("\n");
            }
            commentBuilder.append("Allowed values: ");
            commentBuilder.append(String.join(", ", configValue.getAllowedValues()));
        }

        // Add default value info
        if (!commentBuilder.isEmpty()) {
            commentBuilder.append("\n");
        }
        commentBuilder.append("Default: ").append(configValue.getDefault());

        // Add restart warning
        if (configValue.requiresRestart()) {
            commentBuilder.append("\n Requires restart to take effect");
        }

        if (!commentBuilder.isEmpty()) {
            config.setComment(fullPath, commentBuilder.toString());
        }
    }

    /**
     * Reloads the configuration from the file.
     */
    public void reload() {
        Constants.LOG.info("Reloading config: {}", fileName);
        load();
    }

    /**
     * Saves the current configuration to the file.
     */
    public void save() {
        Constants.LOG.info("Saving config: {}", fileName);
        store();
    }

    /**
     * Gets the path to the config file.
     */
    private static Path getConfigPath(String fileName) {
        return Services.PLATFORM.getConfigDirectory().resolve(fileName + ".toml");
    }

    /**
     * Converts numeric types to match the expected type.
     */
    private Object convertNumericType(Object loadedValue, Object expectedValue) {
        if (loadedValue == null || expectedValue == null) {
            return loadedValue;
        }

        Class<?> expectedClass = expectedValue.getClass();
        Class<?> loadedClass = loadedValue.getClass();

        if (expectedClass.equals(loadedClass)) {
            return loadedValue;
        }

        if (loadedValue instanceof Number numberValue && expectedValue instanceof Number) {
            if (expectedClass == Long.class) {
                return numberValue.longValue();
            } else if (expectedClass == Integer.class) {
                return numberValue.intValue();
            } else if (expectedClass == Double.class) {
                return numberValue.doubleValue();
            } else if (expectedClass == Float.class) {
                return numberValue.floatValue();
            } else if (expectedClass == Short.class) {
                return numberValue.shortValue();
            } else if (expectedClass == Byte.class) {
                return numberValue.byteValue();
            }
        }

        return loadedValue;
    }

    /**
     * Checks if two values are type-compatible for assignment.
     */
    private boolean isTypeCompatible(Object expected, Object actual) {
        if (expected == null || actual == null) {
            return false;
        }

        Class<?> expectedClass = expected.getClass();
        Class<?> actualClass = actual.getClass();

        if (expectedClass.equals(actualClass)) {
            return true;
        }

        return isNumericType(expectedClass) && isNumericType(actualClass);
    }

    /**
     * Checks if a class is a numeric type.
     */
    private boolean isNumericType(Class<?> clazz) {
        return Number.class.isAssignableFrom(clazz) ||
                clazz == int.class || clazz == long.class ||
                clazz == float.class || clazz == double.class ||
                clazz == short.class || clazz == byte.class;
    }

    public Config getConfig() {
        return configFile;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDisplayName() {
        if (displayName != null && !displayName.isEmpty()) {
            return displayName;
        }
        return formatDisplayName(fileName);
    }


    public ConfigManager setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    private static String formatDisplayName(String filePath) {
        String name = filePath;

        if (name.contains("/")) {
            name = name.substring(name.lastIndexOf("/") + 1);
        }

        name = name.replace("_", " ").replace("-", " ");

        String[] words = name.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                if (!result.isEmpty()) {
                    result.append(" ");
                }
                result.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase());
            }
        }

        return result.toString();
    }
}