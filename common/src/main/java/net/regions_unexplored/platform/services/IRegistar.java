package net.regions_unexplored.platform.services;

import net.minecraft.core.Registry;

import java.util.function.Supplier;

public interface IRegistar {
    <T> Supplier<T> register(Registry<T> registry, String name, Supplier<T> value);
}
