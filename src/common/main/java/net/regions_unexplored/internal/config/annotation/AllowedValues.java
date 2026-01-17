package net.regions_unexplored.internal.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines a list of allowed values for string config options.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AllowedValues {
    /**
     * Array of allowed string values.
     *
     * @return The allowed values
     */
    String[] value();
}
