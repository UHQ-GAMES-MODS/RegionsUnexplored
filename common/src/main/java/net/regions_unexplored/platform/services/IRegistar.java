package net.regions_unexplored.platform.services;

import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.regions_unexplored.Constants;

import java.util.function.Supplier;

public interface IRegistar {
    <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value);

    Supplier<Block> registerBlock(String name, Supplier<Block> value);

    <FC extends FeatureConfiguration> Supplier<Feature> registerFeature(String name, Supplier<Feature> value);

    <T extends Entity> Supplier<EntityType<T>> register(DefaultedRegistry<EntityType<?>> entityType, String path, Supplier<EntityType<T>> type);
}
