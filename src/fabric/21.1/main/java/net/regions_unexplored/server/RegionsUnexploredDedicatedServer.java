package net.regions_unexplored.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.regions_unexplored.RegionsUnexplored;

public class RegionsUnexploredDedicatedServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        RegionsUnexplored.afterRegistriesFreeze();
    }
}
