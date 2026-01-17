package net.regions_unexplored.client;

import net.fabricmc.api.ClientModInitializer;
import net.regions_unexplored.RegionsUnexploredFabric;
import net.regions_unexplored.client.color.RuColors;
import net.regions_unexplored.client.particle.RuParticles;

public class RegionsUnexploredFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RegionsUnexploredClient.clientInit();
        RuParticles.init();
        RuColors.tintBlocks();
        RuColors.tintItems();
        RegionsUnexploredFabric.afterRegistriesFreeze();
    }
}