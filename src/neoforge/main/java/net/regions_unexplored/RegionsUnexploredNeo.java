package net.regions_unexplored;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.client.RegionsUnexploredClient;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.config.RuPrimaryRegionConfig;
import net.regions_unexplored.config.RuSecondaryRegionConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@Mod(value = RegionsUnexplored.MOD_ID)
public class RegionsUnexploredNeo {
    public static final Logger LOGGER = LogManager.getLogger(RegionsUnexploredNeo.class);
    public static final Map<ResourceKey, DeferredRegister> REGISTER_CACHE = new HashMap<>();

    public RegionsUnexploredNeo(ModContainer container) {
        IEventBus bus = container.getEventBus();

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::setupBlockEntities);

        registerConfig(container);

        RegionsUnexplored.init("Forge Mod Initializer");

        REGISTER_CACHE.values().forEach(deferredRegister -> deferredRegister.register(bus));
        RegionsUnexploredNeoClient.regionsUnexploredNeoClient(bus);

        var blockRegistry = DeferredRegister.create(Registries.BLOCK, RegionsUnexplored.MOD_ID);
        for (var entry : RuBlocks.BLOCK_ALIASES.entrySet()) {
            blockRegistry.addAlias(entry.getKey(), entry.getValue());
        }
    }

    private void setupBlockEntities(BlockEntityTypeAddBlocksEvent event) {
        for (WoodSet set : RuBlocks.WOOD_SETS) {
            if (set.getSign() != null) {
                event.modify(BlockEntityType.SIGN, set.getSign());
            }
            if (set.getWallSign() != null) {
                event.modify(BlockEntityType.SIGN, set.getWallSign());
            }

            if (set.getHangingSign() != null) {
                event.modify(BlockEntityType.SIGN, set.getHangingSign());
            }
            if (set.getWallHangingSign() != null) {
                event.modify(BlockEntityType.SIGN, set.getWallHangingSign());
            }
        }
    }

    //set up client side features
    public void clientSetup(final FMLClientSetupEvent event) {
        RegionsUnexploredClient.clientInit();
    }

    //set up non-client side features
    @SubscribeEvent
    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(RegionsUnexplored::afterRegistriesFreeze);
    }

    private void registerConfig(ModContainer container){
        container.registerConfig(ModConfig.Type.COMMON, RuCommonConfig.SPEC, "regions_unexplored/regions_unexplored-common.toml");
        container.registerConfig(ModConfig.Type.COMMON, RuPrimaryRegionConfig.SPEC, "regions_unexplored/regions_unexplored-primary-region.toml");
        container.registerConfig(ModConfig.Type.COMMON, RuSecondaryRegionConfig.SPEC, "regions_unexplored/regions_unexplored-secondary-region.toml");
    }
}