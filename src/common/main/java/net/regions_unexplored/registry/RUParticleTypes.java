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
    Supplier<ParticleType<ColorParticleOption>> SMALL_LEAVES = registerColored("leaves/small");
    Supplier<ParticleType<ColorParticleOption>> STANDARD_LEAVES = registerColored("leaves/standard");
    Supplier<ParticleType<ColorParticleOption>> LARGE_LEAVES = registerColored("leaves/large");
    Supplier<ParticleType<ColorParticleOption>> PINE_LEAVES = registerColored("leaves/pine");
    Supplier<ParticleType<ColorParticleOption>> MAGNOLIA_LEAVES = registerColored("leaves/magnolia");
    Supplier<SimpleParticleType> PINK_MAGNOLIA_LEAVES = registerSimple("leaves/magnolia_pink");
    Supplier<SimpleParticleType> WHITE_MAGNOLIA_LEAVES = registerSimple("leaves/magnolia_white");
    Supplier<SimpleParticleType> BLUE_MAGNOLIA_LEAVES = registerSimple("leaves/magnolia_blue");

    Supplier<SimpleParticleType> GROUND_SPORE = registerSimple("spore/ground");
    Supplier<ParticleType<ColorParticleOption>> FALLING_SPORE = registerColored("spore/falling");
    Supplier<ParticleType<ColorParticleOption>> FLOATING_SPORE = registerColored("spore/floating");

    Supplier<ParticleType<ColorParticleOption>> FLOATING_HYACINTH = registerColored("floating_hyacinth");
    Supplier<SimpleParticleType> PRISMARITE_SPARKLE = registerSimple("prismarite_sparkle");
    Supplier<SimpleParticleType> MYCOTOXIC_SPORE = registerSimple("mycotoxic_spore");

    private static Supplier<SimpleParticleType> registerSimple(String name) {
        SimpleParticleType type = new SimpleParticleType(false);
        register(name, type);
        return () -> type;
    }
    
    private static Supplier<ParticleType<ColorParticleOption>> registerColored(String name) {
        ParticleType<ColorParticleOption> type = new ParticleType<>(false) {
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