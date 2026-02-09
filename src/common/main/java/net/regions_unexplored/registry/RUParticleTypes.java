package net.regions_unexplored.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.regions_unexplored.platform.Registrar;

import java.util.function.Supplier;

public interface RUParticleTypes {
    Supplier<ParticleType<ColorParticleOption>> SMALL_LEAVES = registerColored("leaves/small", false);
    Supplier<ParticleType<ColorParticleOption>> STANDARD_LEAVES = registerColored("leaves/standard", false);
    Supplier<ParticleType<ColorParticleOption>> LARGE_LEAVES = registerColored("leaves/large", false);
    Supplier<ParticleType<ColorParticleOption>> PINE_LEAVES = registerColored("leaves/pine", false);
    Supplier<ParticleType<ColorParticleOption>> MAGNOLIA_LEAVES = registerColored("leaves/magnolia", false);
    Supplier<SimpleParticleType> PINK_MAGNOLIA_LEAVES = registerSimple("leaves/magnolia_pink", false);
    Supplier<SimpleParticleType> WHITE_MAGNOLIA_LEAVES = registerSimple("leaves/magnolia_white", false);
    Supplier<SimpleParticleType> BLUE_MAGNOLIA_LEAVES = registerSimple("leaves/magnolia_blue", false);

    Supplier<SimpleParticleType> GROUND_SPORE = registerSimple("spore/ground", false);
    Supplier<ParticleType<ColorParticleOption>> FALLING_SPORE = registerColored("spore/falling", false);
    Supplier<ParticleType<ColorParticleOption>> FLOATING_SPORE = registerColored("spore/floating", false);

    Supplier<SimpleParticleType> MYCOTOXIC_SPORE = registerSimple("mycotoxic_spore", false);

    private static Supplier<SimpleParticleType> registerSimple(String name, boolean alwaysSpawn) {
        SimpleParticleType type = new SimpleParticleType(alwaysSpawn);
        register(name, type);
        return () -> type;
    }
    
    private static Supplier<ParticleType<ColorParticleOption>> registerColored(String name, boolean alwaysSpawn) {
        ParticleType<ColorParticleOption> type = new ParticleType<>(alwaysSpawn) {
            @Override
            public MapCodec<ColorParticleOption> codec() {
                return ColorParticleOption.codec(this);
            }

            @Override
            public StreamCodec<? super RegistryFriendlyByteBuf, ColorParticleOption> streamCodec() {
                return ColorParticleOption.streamCodec(this);
            }
        };
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