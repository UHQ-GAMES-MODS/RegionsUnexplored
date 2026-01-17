package net.regions_unexplored.internal.config;

import net.regions_unexplored.RegionsUnexplored;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ConfigValue<T> {
    private String key;
    private T value;
    private final T defaultValue;
    private String comment;
    private String category;

    // Validation
    private Predicate<T> validator;
    private Double minValue;
    private Double maxValue;
    private List<String> allowedValues;
    private boolean requiresRestart;

    public ConfigValue(String key, T defaultValue) {
        this.key = key;
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.comment = null;
        this.category = "";
    }

    public ConfigValue(String key, T defaultValue, String comment) {
        this.key = key;
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.comment = comment;
        this.category = "";
    }

    public static <T> ConfigValue<T> create(String key, T value) {
        return new ConfigValue<>(key, value);
    }

    public static <T> ConfigValue<T> create(String key, T value, String comment) {
        return new ConfigValue<>(key, value, comment);
    }

    /**
     * Returns the key you've set
     * @return The key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the key. Used internally during annotation processing.
     * @param key The key to set
     */
    void setKey(String key) {
        this.key = key;
    }

    /**
     * Returns the current value.
     * @return The value.
     */
    public T get() {
        return value;
    }

    /**
     * Returns the default value.
     * @return The default value.
     */
    public T getDefault() {
        return defaultValue;
    }

    /**
     * Sets the value with validation.
     * @param value The new value
     * @throws IllegalArgumentException if validation fails
     */
    public void setValue(T value) {
        if (!isValid(value)) {
            RegionsUnexplored.LOGGER.warn("Invalid value for config key '{}': {}. Using previous value: {}",
                    key, value, this.value);
            return;
        }
        this.value = value;
    }

    /**
     * Validates a value against all configured constraints.
     * @param value The value to validate
     * @return true if valid, false otherwise
     */
    public boolean isValid(T value) {
        if (value == null) {
            return false;
        }

        // Custom validator
        if (validator != null && !validator.test(value)) {
            return false;
        }

        // Range validation for numbers
        if (value instanceof Number && (minValue != null || maxValue != null)) {
            double numValue = ((Number) value).doubleValue();
            if (minValue != null && numValue < minValue) {
                RegionsUnexplored.LOGGER.debug("Value {} is below minimum {} for key '{}'", numValue, minValue, key);
                return false;
            }
            if (maxValue != null && numValue > maxValue) {
                RegionsUnexplored.LOGGER.debug("Value {} is above maximum {} for key '{}'", numValue, maxValue, key);
                return false;
            }
        }

        // Allowed values for strings
        if (value instanceof String && allowedValues != null && !allowedValues.isEmpty()) {
            if (!allowedValues.contains(value)) {
                RegionsUnexplored.LOGGER.debug("Value '{}' is not in allowed values {} for key '{}'",
                        value, allowedValues, key);
                return false;
            }
        }

        return true;
    }

    /**
     * Resets to the default value.
     */
    public void reset() {
        this.value = defaultValue;
    }

    // Getters and setters for metadata

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean requiresRestart() {
        return requiresRestart;
    }

    public void setRequiresRestart(boolean requiresRestart) {
        this.requiresRestart = requiresRestart;
    }

    // Range configuration

    public void setRange(double min, double max) {
        this.minValue = min;
        this.maxValue = max;
    }

    public Double getMinValue() {
        return minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    // Allowed values configuration

    public void setAllowedValues(String... values) {
        this.allowedValues = Arrays.asList(values);
    }

    public void setAllowedValues(List<String> values) {
        this.allowedValues = values;
    }

    public List<String> getAllowedValues() {
        return allowedValues;
    }

    // Custom validator

    public void setValidator(Predicate<T> validator) {
        this.validator = validator;
    }

    @Override
    public String toString() {
        return "ConfigValue{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", default=" + defaultValue +
                (minValue != null || maxValue != null ?
                        ", range=[" + (minValue != null ? minValue : "-∞") +
                                ", " + (maxValue != null ? maxValue : "+∞") + "]" : "") +
                '}';
    }
}