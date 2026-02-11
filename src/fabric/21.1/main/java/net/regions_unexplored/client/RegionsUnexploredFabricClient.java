package net.regions_unexplored.client;

import net.fabricmc.api.ClientModInitializer;
import net.regions_unexplored.client.color.RuColors;
import net.regions_unexplored.client.particle.RUParticleProviders;

public class RegionsUnexploredFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RegionsUnexploredClient.clientInit();
        RUParticleProviders.init();
        RuColors.tintBlocks();
        RuColors.tintItems();
    }
}