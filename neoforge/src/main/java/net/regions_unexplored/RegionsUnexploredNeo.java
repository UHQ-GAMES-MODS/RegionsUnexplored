package net.regions_unexplored;

import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.compat.BlockToolCompat;
import net.regions_unexplored.block.compat.CompostableBlocks;
import net.regions_unexplored.block.compat.FlammableBlocks;
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
        NeoForgeRegistar.CACHE.values().forEach(deferredRegister -> deferredRegister.register(NeoForge.EVENT_BUS));
        bus.addListener(this::commonSetup);

        //RuTabs.addTabs();

        registerConfig(container);

        RegionsUnexplored.init();
        Constants.LOG.info("{}", RuBlocks.TALL_HYACINTH_STOCK);
    }
    //set up client side features
    public void clientSetup(final FMLClientSetupEvent event) {
        //WoodTypeRegistry.addSheets();
        //BlockEntityRenderers.register(RuBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
        //BlockEntityRenderers.register(RuBlockEntities.HANGING_SIGN_BLOCK_ENTITIES.get(), HangingSignRenderer::new);
    }

    //set up non-client side features
    @SubscribeEvent
    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BiomeRegistry.setupTerrablender();
            //PottedPlants.setup();
            CompostableBlocks.setup();
            FlammableBlocks.setup();
            BlockToolCompat.setup();
        });
    }

    private void registerConfig(ModContainer container){
        container.registerConfig(ModConfig.Type.COMMON, RuCommonConfig.SPEC, "regions_unexplored/regions_unexplored-common.toml");
        container.registerConfig(ModConfig.Type.COMMON, RuPrimaryRegionConfig.SPEC, "regions_unexplored/regions_unexplored-primary-region.toml");
        container.registerConfig(ModConfig.Type.COMMON, RuSecondaryRegionConfig.SPEC, "regions_unexplored/regions_unexplored-secondary-region.toml");
    }
}