package net.regions_unexplored.client;

import net.fabricmc.api.ClientModInitializer;
import net.regions_unexplored.RegionsUnexploredFabric;

public class RegionsUnexploredFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RegionsUnexploredClient.clientInit();
        RegionsUnexploredFabric.afterRegistriesFreeze();
    }
}