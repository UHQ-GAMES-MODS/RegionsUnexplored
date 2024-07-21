package net.regions_unexplored.platform;

import com.google.auto.service.AutoService;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.services.IRegistar;

import java.util.function.Supplier;

@AutoService(IRegistar.class)
public class FabricRegistar implements IRegistar {
    @Override
    public <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value) {
        return () -> Registry.register(registry, Constants.id(name), value.get());
    }

    @Override
    public <FC extends FeatureConfiguration> Supplier<Feature> register(String name, Supplier<Feature> value) {
        Registry.register(BuiltInRegistries.FEATURE, Constants.id(name), value.get());
        return value;
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> register(DefaultedRegistry<EntityType<?>> entityType, String path, Supplier<EntityType<T>> type) {
        return () -> Registry.register(entityType, Constants.id(path), type.get());
    }
}
