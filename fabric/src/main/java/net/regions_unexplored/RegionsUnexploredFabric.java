package net.regions_unexplored;

import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.neoforged.fml.config.ModConfig;
import net.regions_unexplored.block.BlockToolCompat;
import net.regions_unexplored.block.CompostableBlocks;
import net.regions_unexplored.block.FlammableBlocks;
import net.regions_unexplored.block.compat.FurnaceBurnTimesFabric;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.config.RuPrimaryRegionConfig;
import net.regions_unexplored.config.RuSecondaryRegionConfig;
import net.regions_unexplored.registry.BiomeRegistry;
import terrablender.api.TerraBlenderApi;

public class RegionsUnexploredFabric implements ModInitializer, TerraBlenderApi {

    static {
        Constants.LOG.info("[Regions Unexplored] generating and loading config");
        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.COMMON, RuCommonConfig.SPEC, "regions_unexplored/regions_unexplored-common.toml");
        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.COMMON, RuPrimaryRegionConfig.SPEC, "regions_unexplored/regions_unexplored-primary-region.toml");
        NeoForgeConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.COMMON, RuSecondaryRegionConfig.SPEC, "regions_unexplored/regions_unexplored-secondary-region.toml");
    }

    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        RegionsUnexplored.init();

        BlockToolCompat.setup();
        CompostableBlocks.setup();
        FlammableBlocks.setup();
        FurnaceBurnTimesFabric.setup();
    }

    @Override
    public void onTerraBlenderInitialized() {
        BiomeRegistry.setupTerrablender();
    }
}
