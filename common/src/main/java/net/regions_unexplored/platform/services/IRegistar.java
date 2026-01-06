package net.regions_unexplored.platform.services;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.List;
import java.util.function.Supplier;

public interface IRegistar {
    <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value);

    Supplier<Block> registerBlock(String name, Supplier<Block> value);

    Supplier<Feature> registerFeature(String name, Supplier<Feature> value);

    <T extends Entity> Supplier<EntityType<T>> registerEntity(String path, Supplier<EntityType<T>> type);

    Supplier<CreativeModeTab> registerCreativeModeTab(String path, Supplier<ItemStack> icon, Supplier<CreativeModeTab.DisplayItemsGenerator> items);
}
