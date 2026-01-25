package net.regions_unexplored.item;

import net.minecraft.world.item.Item;

import java.util.function.Function;

public interface ItemFactory extends Function<Item.Properties, Item> {
}
