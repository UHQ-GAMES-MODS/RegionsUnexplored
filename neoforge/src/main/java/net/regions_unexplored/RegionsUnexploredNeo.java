package net.regions_unexplored;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.config.RuPrimaryRegionConfig;
import net.regions_unexplored.config.RuSecondaryRegionConfig;
import net.regions_unexplored.platform.NeoForgeRegistar;

@Mod(Constants.MOD_ID)
public class RegionsUnexploredNeo {

    public RegionsUnexploredNeo(ModContainer container) {
        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.
        container.registerConfig(ModConfig.Type.COMMON, RuCommonConfig.SPEC);
        container.registerConfig(ModConfig.Type.COMMON, RuPrimaryRegionConfig.SPEC);
        container.registerConfig(ModConfig.Type.COMMON, RuSecondaryRegionConfig.SPEC);

        IEventBus bus = container.getEventBus();

        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello NeoForge world!");
        RegionsUnexplored.init();
        NeoForgeRegistar.CACHE.values().forEach(deferredRegister -> deferredRegister.register(bus));
    }
}