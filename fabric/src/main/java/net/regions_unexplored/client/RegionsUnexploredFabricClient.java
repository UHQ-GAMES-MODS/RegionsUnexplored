package net.regions_unexplored.client;

import net.fabricmc.api.ClientModInitializer;
import net.regions_unexplored.RegionsUnexploredFabric;
import net.regions_unexplored.client.color.RuColors;

public class RegionsUnexploredFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RegionsUnexploredClient.clientInit();
        RuColors.tintBlocks();
        RuColors.tintItems();
        RegionsUnexploredFabric.afterRegistriesFreeze();
    }
}