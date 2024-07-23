package net.regions_unexplored;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.regions_unexplored.client.ParticleRegistration;
import net.regions_unexplored.client.RegionsUnexploredClient;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.config.RuPrimaryRegionConfig;
import net.regions_unexplored.config.RuSecondaryRegionConfig;
import net.regions_unexplored.platform.NeoForgeRegistar;
import net.regions_unexplored.registry.BiomeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value = Constants.MOD_ID)
public class RegionsUnexploredNeo {
    public static final Logger LOGGER = LogManager.getLogger(RegionsUnexploredNeo.class);

    public RegionsUnexploredNeo(ModContainer container) {
        IEventBus bus = container.getEventBus();

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);

        registerConfig(container);

        RegionsUnexplored.init("Forge Mod Initializer");

        NeoForgeRegistar.CACHE.values().forEach(deferredRegister -> deferredRegister.register(bus));
        RegionsUnexploredNeoClient.regionsUnexploredNeoClient(bus);
    }
    //set up client side features
    public void clientSetup(final FMLClientSetupEvent event) {
        RegionsUnexploredClient.clientInit();
    }

    //set up non-client side features
    @SubscribeEvent
    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BiomeRegistry.setupTerrablender();
            //PottedPlants.setup();
            RegionsUnexplored.afterRegistriesFreeze();
        });
    }

    private void registerConfig(ModContainer container){
        container.registerConfig(ModConfig.Type.COMMON, RuCommonConfig.SPEC, "regions_unexplored/regions_unexplored-common.toml");
        container.registerConfig(ModConfig.Type.COMMON, RuPrimaryRegionConfig.SPEC, "regions_unexplored/regions_unexplored-primary-region.toml");
        container.registerConfig(ModConfig.Type.COMMON, RuSecondaryRegionConfig.SPEC, "regions_unexplored/regions_unexplored-secondary-region.toml");
    }
}