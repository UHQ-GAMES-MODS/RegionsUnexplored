package net.regions_unexplored;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.compat.BlockToolCompat;
import net.regions_unexplored.block.compat.FlammableBlocks;
import net.regions_unexplored.client.particle.RuParticleTypes;
import net.regions_unexplored.config.RuClientConfig;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.entity.RuEntities;
import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigManager;
import net.regions_unexplored.internal.config.gui.ConfigScreenRegistry;
import net.regions_unexplored.registry.RUItems;
import net.regions_unexplored.item.tab.RuTabs;
import net.regions_unexplored.registry.BiomeRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.RuBiolith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegionsUnexplored {
	public static final String MOD_ID = "regions_unexplored";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// We do this because terrablender might load before us or after us, so this catches both cases.
	public static void init() {
		registerConfig("regions unexplored/regions_unexplored-client", "Client", RuClientConfig.class);
		registerConfig("regions unexplored/regions_unexplored-common", "Common", RuCommonConfig.class);

		FeatureRegistry.addFeatures();
		RuParticleTypes.addParticles();
		BiomeRegistry.addBiomes();
		RUBlocks.init();
		RUItems.init();
		RuTabs.init();
		RuEntities.addEntities();
	}

	public static void afterRegistriesFreeze(){
		BlockToolCompat.setup();
		//CompostableBlocks.setup();
		FlammableBlocks.setup();

		RuBiolith.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	public static <T> ResourceKey<T> key(ResourceKey<? extends Registry<T>> key, String name) {
		return ResourceKey.create(key, id(name));
	}

	private static void registerConfig(String filePath, String displayName, Class<? extends Config> configClass) {
		ConfigManager manager = ConfigManager.of(filePath, configClass);
		ConfigScreenRegistry.register(filePath, manager, displayName);
		LOGGER.debug("Registered config '{}' with GUI system as '{}'", filePath, displayName);
	}
}