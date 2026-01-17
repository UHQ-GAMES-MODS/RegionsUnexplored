package net.regions_unexplored;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.compat.BlockToolCompat;
import net.regions_unexplored.block.compat.FlammableBlocks;
import net.regions_unexplored.client.particle.RuParticleTypes;
import net.regions_unexplored.entity.RuEntities;
import net.regions_unexplored.item.RuItems;
import net.regions_unexplored.item.tab.RuTabs;
import net.regions_unexplored.registry.BiomeRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.RuBiolith;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegionsUnexplored {
	public static final String MOD_ID = "regions_unexplored";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Nullable
	private static String initializedFrom = null;

	// We do this because terrablender might load before us or after us, so this catches both cases.
	public static void init(String from) {
		if (initializedFrom != null) {
			RegionsUnexplored.LOGGER.info("Already initialized Regions Unexplored from %s entrypoint.".formatted(initializedFrom));
			return;
		}
		initializedFrom = from;

		RegionsUnexplored.LOGGER.info("Initializing Regions Unexplored from %s entrypoint.".formatted(initializedFrom));


		FeatureRegistry.addFeatures();
		RuParticleTypes.addParticles();
		BiomeRegistry.addBiomes();
		RuBlocks.addBlocks();
		RuItems.addItems();
		RuTabs.init();
		RuEntities.addEntities();
	}

	public static void afterRegistriesFreeze(){
		BlockToolCompat.setup();
		//CompostableBlocks.setup();
		FlammableBlocks.setup();

		RuBiolith.init();
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	public static <T> ResourceKey<T> key(ResourceKey<? extends Registry<T>> key, String name) {
		return ResourceKey.create(key, id(name));
	}
}