package net.regions_unexplored.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.Services;

import java.util.function.Supplier;

public class ItemRegistry {

    public static Supplier<Item> registerDefaultBlockItem(String name, Supplier<Block> block) {
        return Services.REGISTAR.register(BuiltInRegistries.ITEM, name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static Supplier<Item> registerPlaceOnWaterItem(String name, Block block) {
        return Services.REGISTAR.register(BuiltInRegistries.ITEM, name, () -> new PlaceOnWaterBlockItem(block, new Item.Properties()));
    }
}
