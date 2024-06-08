package net.regions_unexplored.client.particle;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.regions_unexplored.Constants;

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
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Constants.id("mauve_leaves"), MAUVE_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Constants.id("mycotoxic_spore"), MYCOTOXIC_SPORE);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Constants.id("enchanted_birch_leaves"), ENCHANTED_BIRCH_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Constants.id("silver_birch_leaves"), SILVER_BIRCH_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Constants.id("blue_magnolia_leaves"), BLUE_MAGNOLIA_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Constants.id("pink_magnolia_leaves"), PINK_MAGNOLIA_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Constants.id("white_magnolia_leaves"), WHITE_MAGNOLIA_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Constants.id("red_maple_leaves"), RED_MAPLE_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Constants.id("orange_maple_leaves"), ORANGE_MAPLE_LEAVES);
    }
}