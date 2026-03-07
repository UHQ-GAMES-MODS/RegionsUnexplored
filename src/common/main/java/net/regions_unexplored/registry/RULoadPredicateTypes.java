package net.regions_unexplored.registry;

import com.mojang.serialization.MapCodec;
import dev.worldgen.lithostitched.api.predicate.LoadPredicate;
import dev.worldgen.lithostitched.api.registry.LithostitchedBuiltInRegistries;
import net.regions_unexplored.lithostitched.BiomeEnabledPredicate;
import net.regions_unexplored.platform.Registrar;

import java.util.function.Supplier;

public interface RULoadPredicateTypes {
    Supplier<MapCodec<BiomeEnabledPredicate>> BIOME_ENABLED = register("biome_enabled", BiomeEnabledPredicate.CODEC);

    static <T extends LoadPredicate> Supplier<MapCodec<T>> register(String name, MapCodec<T> codec) {
        Registrar.register(LithostitchedBuiltInRegistries.LOAD_PREDICATE_TYPE, name, () -> codec);
        return () -> codec;
    }

    static void init() {
    }
}
