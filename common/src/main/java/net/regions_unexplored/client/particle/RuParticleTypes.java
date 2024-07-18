package net.regions_unexplored.client.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.regions_unexplored.platform.Services;

public class RuParticleTypes {
    public static final SimpleParticleType MAUVE_LEAVES = new SimpleParticleType(false);
    public static final SimpleParticleType MYCOTOXIC_SPORE = new SimpleParticleType(false);
    public static final SimpleParticleType BLUE_MAGNOLIA_LEAVES = new SimpleParticleType(false);
    public static final SimpleParticleType ENCHANTED_BIRCH_LEAVES = new SimpleParticleType(false);
    public static final SimpleParticleType ORANGE_MAPLE_LEAVES = new SimpleParticleType(false);
    public static final SimpleParticleType PINK_MAGNOLIA_LEAVES = new SimpleParticleType(false);
    public static final SimpleParticleType RED_MAPLE_LEAVES = new SimpleParticleType(false);
    public static final SimpleParticleType SILVER_BIRCH_LEAVES = new SimpleParticleType(false);
    public static final SimpleParticleType WHITE_MAGNOLIA_LEAVES = new SimpleParticleType(false);

    public static void addParticles() {
        register("mauve_leaves", MAUVE_LEAVES);
        register("mycotoxic_spore", MYCOTOXIC_SPORE);
        register("enchanted_birch_leaves", ENCHANTED_BIRCH_LEAVES);
        register("silver_birch_leaves", SILVER_BIRCH_LEAVES);
        register("blue_magnolia_leaves", BLUE_MAGNOLIA_LEAVES);
        register("pink_magnolia_leaves", PINK_MAGNOLIA_LEAVES);
        register("white_magnolia_leaves", WHITE_MAGNOLIA_LEAVES);
        register("red_maple_leaves", RED_MAPLE_LEAVES);
        register("orange_maple_leaves", ORANGE_MAPLE_LEAVES);
    }

    private static void register(String name, ParticleType<?> particleType) {
        Services.REGISTAR.register(BuiltInRegistries.PARTICLE_TYPE, name, () -> particleType);
    }
}