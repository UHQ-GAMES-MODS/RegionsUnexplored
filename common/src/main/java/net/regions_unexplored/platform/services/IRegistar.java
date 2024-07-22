package net.regions_unexplored.platform.services;

import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public interface IRegistar {
    <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value);

    Supplier<Block> registerBlock(String name, Supplier<Block> value);

    <FC extends FeatureConfiguration> Supplier<Feature> registerFeature(String name, Supplier<Feature> value);

    <T extends BlockEntity> Supplier<BlockEntityType> registerBlockEntity(String path, Supplier<BlockEntityType> type);

    <T extends Entity> Supplier<EntityType<T>> registerEntity(String path, Supplier<EntityType<T>> type);

    Supplier<CreativeModeTab> registerCreativeModeTab(String path, Supplier<ItemStack> icon, Supplier<List<Item>> items);
}
