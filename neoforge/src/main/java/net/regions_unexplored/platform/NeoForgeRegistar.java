package net.regions_unexplored.platform;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.services.IRegistar;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NeoForgeRegistar implements IRegistar {

    public static final Map<ResourceKey, DeferredRegister> CACHE = new HashMap<>();

    @Override
    public <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value) {
        return CACHE.computeIfAbsent(registry.key(), key -> DeferredRegister.create(registry.key().location(), Constants.MOD_ID)).register(name, value);
    }
}
