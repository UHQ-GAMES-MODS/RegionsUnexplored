package net.regions_unexplored.internal.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines range constraints for numeric config values.
 * Applies to Integer, Long, Float, and Double types.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {
    /**
     * Minimum allowed value (inclusive).
     *
     * @return The minimum value
     */
    double min() default Double.NEGATIVE_INFINITY;

    /**
     * Maximum allowed value (inclusive).
     *
     * @return The maximum value
     */
    double max() default Double.POSITIVE_INFINITY;
}
