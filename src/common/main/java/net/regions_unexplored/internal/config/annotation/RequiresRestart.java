package net.regions_unexplored.internal.config.annotation;

import java.lang.annotation.*;


/**
 * Marks a config option as requiring a restart to take effect.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RequiresRestart {
    /**
     * Type of restart required.
     * @return The restart type
     */
    RestartType value() default RestartType.GAME;

    enum RestartType {
        GAME,    // Requires full game restart
        WORLD    // Requires world reload
    }
}