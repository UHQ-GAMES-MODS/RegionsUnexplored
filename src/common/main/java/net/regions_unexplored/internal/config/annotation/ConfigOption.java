package net.regions_unexplored.internal.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a field as a configuration option.
 * The field must be public static and of type ConfigValue<T>.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigOption {
    /**
     * The config key. If empty, uses the field name converted to snake_case.
     * @return The config key
     */
    String key() default "";

    /**
     * Comment/description for this config option.
     * Use \n for multi-line comments.
     * @return The comment
     */
    String comment() default "";

    /**
     * Category for grouping related options.
     * @return The category name
     */
    String category() default "";
}
