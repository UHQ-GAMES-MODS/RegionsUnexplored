package net.regions_unexplored.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.Constants;

public class ItemRegistry {

    public static Item registerDefaultBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, Constants.id(name), new BlockItem(block, new Item.Properties()));
    }

    public static Item registerPlaceOnWaterItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, Constants.id(name), new PlaceOnWaterBlockItem(block, new Item.Properties()));
    }
}
