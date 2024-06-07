package net.regions_unexplored.registry;

import io.github.uhq_games.regions_unexplored.RegionsUnexplored;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.Block;

public class ItemRegistry {

    public static Item registerDefaultBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, RegionsUnexplored.ID(name), new BlockItem(block, new Item.Properties()));
    }

    public static Item registerPlaceOnWaterItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, RegionsUnexplored.ID(name), new PlaceOnWaterBlockItem(block, new Item.Properties()));
    }
}
