package net.regions_unexplored.block.compat;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.regions_unexplored.Constants;

import static net.regions_unexplored.block.compat.FurnaceBurnTimes.*;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class FurnaceBurnTimesNeo {

    @SubscribeEvent
    public static void burnTime(final FurnaceFuelBurnTimeEvent event) {
        if (BURN_TIME_300.isEmpty()) return;
        BURN_TIME_300.forEach(item -> event.setBurnTime(300));

        if (BURN_TIME_200.isEmpty()) return;
        BURN_TIME_200.forEach(item -> event.setBurnTime(200));

        if (BURN_TIME_150.isEmpty()) return;
        BURN_TIME_150.forEach(item -> event.setBurnTime(150));

        if (BURN_TIME_100.isEmpty()) return;
        BURN_TIME_100.forEach(item -> event.setBurnTime(100));
    }
}
