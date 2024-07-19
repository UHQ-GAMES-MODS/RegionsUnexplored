package net.regions_unexplored;

import net.fabricmc.api.ClientModInitializer;
import net.regions_unexplored.client.RegionsUnexploredClient;

public class RegionsUnexploredFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RegionsUnexploredClient.clientInit();
    }
}