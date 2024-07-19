package net.regions_unexplored.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.NeoForgeTintHelper;

@EventBusSubscriber(value = Dist.CLIENT, modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class TintRegistration {
    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        // Parameters are the block's state, the level the block is in, the block's position, and the tint index.
        // The level and position may be null.
        NeoForgeTintHelper.BLOCK_TINTS.forEach(event::register);

    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        // Parameters are the item stack and the tint index.
        NeoForgeTintHelper.ITEM_TINTS.forEach(event::register);
    }
}
