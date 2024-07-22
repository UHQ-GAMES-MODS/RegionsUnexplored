package net.regions_unexplored.client;

import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.regions_unexplored.client.color.RuColors;
import net.regions_unexplored.platform.NeoForgeTintHelper;

public class TintRegistration {
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        RuColors.tintBlocks();
        // Parameters are the block's state, the level the block is in, the block's position, and the tint index.
        // The level and position may be null.
        NeoForgeTintHelper.BLOCK_TINTS.forEach(event::register);

    }

    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        RuColors.tintItems();
        // Parameters are the item stack and the tint index.
        NeoForgeTintHelper.ITEM_TINTS.forEach(event::register);
    }
}
