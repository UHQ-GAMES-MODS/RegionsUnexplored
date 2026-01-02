package net.regions_unexplored.internal.config.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.regions_unexplored.internal.config.ConfigManager;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Helper class to manage and open config GUI screens.
 * Automatically tracks all registered configs for easy GUI access.
 */
public class ConfigScreenRegistry {
    private static final Map<String, ConfigManager> registeredConfigs = new LinkedHashMap<>();

    /**
     * Registers a config manager for GUI access.
     * Configs are automatically available in ModMenu and selection screens.
     *
     * @param configName The name/identifier for this config
     * @param manager The config manager
     */
    public static void register(String configName, ConfigManager manager) {
        registeredConfigs.put(configName, manager);
    }

    /**
     * Opens a config screen for a registered config.
     *
     * @param configName The name of the config to open
     * @param parent The parent screen to return to when closed
     */
    public static void openConfigScreen(String configName, Screen parent) {
        ConfigManager manager = registeredConfigs.get(configName);
        if (manager != null) {
            Minecraft.getInstance().setScreen(new ConfigScreen(parent, manager));
        }
    }

    /**
     * Opens a config screen directly from a config manager.
     *
     * @param manager The config manager
     * @param parent The parent screen to return to when closed
     */
    public static void openConfigScreen(ConfigManager manager, Screen parent) {
        Minecraft.getInstance().setScreen(new ConfigScreen(parent, manager));
    }

    /**
     * Gets a registered config manager.
     *
     * @param configName The config name
     * @return The config manager, or null if not found
     */
    public static ConfigManager getConfigManager(String configName) {
        return registeredConfigs.get(configName);
    }

    /**
     * Gets all registered configs.
     * Useful for creating selection screens.
     *
     * @return Map of config names to managers
     */
    public static Map<String, ConfigManager> getAllConfigs() {
        return new LinkedHashMap<>(registeredConfigs);
    }

    /**
     * Checks if a config is registered.
     *
     * @param configName The config name
     * @return True if registered, false otherwise
     */
    public static boolean isRegistered(String configName) {
        return registeredConfigs.containsKey(configName);
    }

    /**
     * Gets the number of registered configs.
     *
     * @return The count of registered configs
     */
    public static int getConfigCount() {
        return registeredConfigs.size();
    }

    /**
     * Creates the appropriate config screen based on the number of registered configs.
     * - If 0 configs: Returns null
     * - If 1 config: Returns the config screen directly
     * - If 2+ configs: Returns a selection screen
     *
     * @param parent The parent screen
     * @return The appropriate config screen, or null if no configs registered
     */
    public static Screen createConfigScreen(Screen parent) {
        if (registeredConfigs.isEmpty()) {
            return null;
        } else if (registeredConfigs.size() == 1) {
            // Only one config - open it directly
            ConfigManager manager = registeredConfigs.values().iterator().next();
            return new ConfigScreen(parent, manager);
        } else {
            // Multiple configs - show selection screen
            return new ConfigSelectionScreen(parent);
        }
    }
}