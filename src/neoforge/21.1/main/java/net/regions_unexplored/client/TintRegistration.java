package net.regions_unexplored.client;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.regions_unexplored.client.color.RuColors;

import java.util.HashMap;
import java.util.Map;

public class TintRegistration {
    public static Map<BlockColor, Block[]> BLOCK_TINTS = new HashMap<>();
    public static Map<ItemColor, Block[]> ITEM_TINTS = new HashMap<>();

    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        RuColors.tintBlocks();
        // Parameters are the block's state, the level the block is in, the block's position, and the tint index.
        // The level and position may be null.
        BLOCK_TINTS.forEach(event::register);

    }

    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        RuColors.tintItems();
        // Parameters are the item stack and the tint index.
        ITEM_TINTS.forEach(event::register);
    }
}
