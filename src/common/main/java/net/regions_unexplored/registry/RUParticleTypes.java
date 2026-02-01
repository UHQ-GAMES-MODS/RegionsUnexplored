package net.regions_unexplored.registry;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.regions_unexplored.platform.Registrar;

import java.util.function.Supplier;

public interface RUParticleTypes {
    Supplier<SimpleParticleType> MAUVE_LEAVES = registerSimple("mauve_leaves", true);
    Supplier<SimpleParticleType> MYCOTOXIC_SPORE = registerSimple("mycotoxic_spore", true);
    Supplier<SimpleParticleType> BLUE_MAGNOLIA_LEAVES = registerSimple("blue_magnolia_leaves", true);
    Supplier<SimpleParticleType> ENCHANTED_BIRCH_LEAVES = registerSimple("enchanted_birch_leaves", true);
    Supplier<SimpleParticleType> ORANGE_MAPLE_LEAVES = registerSimple("orange_maple_leaves", true);
    Supplier<SimpleParticleType> PINK_MAGNOLIA_LEAVES = registerSimple("pink_magnolia_leaves", true);
    Supplier<SimpleParticleType> RED_MAPLE_LEAVES = registerSimple("red_maple_leaves", true);
    Supplier<SimpleParticleType> SILVER_BIRCH_LEAVES = registerSimple("silver_birch_leaves", true);
    Supplier<SimpleParticleType> WHITE_MAGNOLIA_LEAVES = registerSimple("white_magnolia_leaves", true);

    private static Supplier<SimpleParticleType> registerSimple(String name, boolean alwaysSpawn) {
        SimpleParticleType type = new SimpleParticleType(alwaysSpawn);
        register(name, type);
        return () -> type;
    }

    private static <T extends ParticleOptions> ParticleType<T> register(String name, ParticleType<T> particleType) {
        Registrar.register(BuiltInRegistries.PARTICLE_TYPE, name, () -> particleType);
        return particleType;
    }

    static void init() {
    }
}