package net.regions_unexplored;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.compat.BlockToolCompat;
import net.regions_unexplored.block.compat.FlammableBlocks;
import net.regions_unexplored.block.entity.RuBlockEntities;
import net.regions_unexplored.client.particle.RuParticleTypes;
import net.regions_unexplored.config.RuClientConfig;
import net.regions_unexplored.config.RuCommonConfigNew;
import net.regions_unexplored.entity.RuEntities;
import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigManager;
import net.regions_unexplored.internal.config.gui.ConfigScreenRegistry;
import net.regions_unexplored.item.RuItems;
import net.regions_unexplored.item.tab.RuTabs;
import net.regions_unexplored.registry.BiomeRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import org.jetbrains.annotations.Nullable;
import terrablender.api.SurfaceRuleManager;

public class RegionsUnexplored {

    @Nullable
    private static String initializedFrom = null;


    public static SurfaceRules.RuleSource getSurfaceRules(SurfaceRules.RuleSource fallBack) {
        return SurfaceRuleManager.getNamespacedRules(SurfaceRuleManager.RuleCategory.NETHER, fallBack);
    }


    // We do this because terrablender might load before us or after us, so this catches both cases.
    public static void init(String from) {
        if (initializedFrom != null) {
            Constants.LOG.info("Already initialized Regions Unexplored from %s entrypoint.".formatted(initializedFrom));
            return;
        }
        initializedFrom = from;

        Constants.LOG.info("Initializing Regions Unexplored from %s entrypoint.".formatted(initializedFrom));

        registerConfig("regions unexplored/regions_unexplored-client", "client", RuClientConfig.class);
        registerConfig("regions unexplored/regions_unexplored-common", "common", RuCommonConfigNew.class);

        FeatureRegistry.addFeatures();
        RuParticleTypes.addParticles();
        BiomeRegistry.addBiomes();
        RuBlocks.addBlocks();
        RuItems.addItems();
        RuTabs.init();
        RuBlockEntities.addBlockEntities();
        RuEntities.addEntities();
    }

    public static void afterRegistriesFreeze(){
        BlockToolCompat.setup();
//        CompostableBlocks.setup();
        FlammableBlocks.setup();
    }

    /**
     * Helper method to register a config with both the config system and GUI registry.
     * This is the ONLY place you need to add new configs!
     *
     * @param filePath The config file path (without .toml extension)
     * @param configClass The config class
     * @param displayName Custom display name for the GUI
     */
    private static void registerConfig(String filePath, String displayName, Class<? extends Config> configClass) {
        ConfigManager manager = ConfigManager.of(filePath, configClass);
        ConfigScreenRegistry.register(filePath, manager, displayName);
        Constants.LOG.debug("Registered config '{}' with GUI system as '{}'", filePath, displayName);
    }
}