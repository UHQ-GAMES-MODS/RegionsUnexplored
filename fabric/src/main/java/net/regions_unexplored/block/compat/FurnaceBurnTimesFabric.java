package net.regions_unexplored.block.compat;

import net.fabricmc.fabric.api.registry.FuelRegistry;

import static net.regions_unexplored.block.compat.FurnaceBurnTimes.BURN_TIME_300;
import static net.regions_unexplored.block.compat.FurnaceBurnTimes.BURN_TIME_200;
import static net.regions_unexplored.block.compat.FurnaceBurnTimes.BURN_TIME_150;
import static net.regions_unexplored.block.compat.FurnaceBurnTimes.BURN_TIME_100;

public class FurnaceBurnTimesFabric {
    public static FuelRegistry registry = FuelRegistry.INSTANCE;

    public static void setup() {
        BURN_TIME_300.forEach(item -> registry.add(item, 300));

//        if (BURN_TIME_200.isEmpty()) return;
        BURN_TIME_200.forEach(item -> registry.add(item, 200));

//        if (BURN_TIME_150.isEmpty()) return;
        BURN_TIME_150.forEach(item -> registry.add(item, 150));

//        if (BURN_TIME_100.isEmpty()) return;
        BURN_TIME_100.forEach(item -> registry.add(item, 100));
    }
}
