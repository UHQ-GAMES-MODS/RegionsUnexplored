package net.regions_unexplored.platform;

import com.google.auto.service.AutoService;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.services.IRegistar;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("rawtypes")
@AutoService(IRegistar.class)
public class NeoForgeRegistar implements IRegistar {

    public static final Map<ResourceKey, DeferredRegister> CACHE = new HashMap<>();

    @SuppressWarnings("unchecked")
    @Override
    public <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value) {
        return CACHE.computeIfAbsent(registry.key(), key -> DeferredRegister.create(registry.key().location(), Constants.MOD_ID)).register(name, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Supplier<Block> registerBlock(String name, Supplier<Block> value) {
        return CACHE.computeIfAbsent(BuiltInRegistries.BLOCK.key(), key -> DeferredRegister.create(BuiltInRegistries.BLOCK.key().location(), Constants.MOD_ID)).register(name, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <FC extends FeatureConfiguration> Supplier<Feature> registerFeature(String name, Supplier<Feature> value) {
        return CACHE.computeIfAbsent(BuiltInRegistries.FEATURE.key(), resourceKey -> DeferredRegister.create(BuiltInRegistries.FEATURE, Constants.MOD_ID)).register(name, value);

    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Entity> Supplier<EntityType<T>> register(DefaultedRegistry<EntityType<?>> entityType, String path, Supplier<EntityType<T>> type) {
        return CACHE.computeIfAbsent(entityType.key(), resourceKey -> DeferredRegister.create(entityType, Constants.MOD_ID)).register(path, type);
    }
}
