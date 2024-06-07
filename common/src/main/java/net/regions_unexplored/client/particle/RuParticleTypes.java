package net.regions_unexplored.client.particle;

import io.github.uhq_games.regions_unexplored.RegionsUnexplored;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

public class RuParticleTypes {
    public static final SimpleParticleType MAUVE_LEAVES = FabricParticleTypes.simple(false);
    public static final SimpleParticleType MYCOTOXIC_SPORE = FabricParticleTypes.simple(false);
    public static final SimpleParticleType BLUE_MAGNOLIA_LEAVES = FabricParticleTypes.simple(false);
    public static final SimpleParticleType ENCHANTED_BIRCH_LEAVES = FabricParticleTypes.simple(false);
    public static final SimpleParticleType ORANGE_MAPLE_LEAVES = FabricParticleTypes.simple(false);
    public static final SimpleParticleType PINK_MAGNOLIA_LEAVES = FabricParticleTypes.simple(false);
    public static final SimpleParticleType RED_MAPLE_LEAVES = FabricParticleTypes.simple(false);
    public static final SimpleParticleType SILVER_BIRCH_LEAVES = FabricParticleTypes.simple(false);
    public static final SimpleParticleType WHITE_MAGNOLIA_LEAVES = FabricParticleTypes.simple(false);

    public static void addParticles() {
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, RegionsUnexplored.ID("mauve_leaves"), MAUVE_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, RegionsUnexplored.ID("mycotoxic_spore"), MYCOTOXIC_SPORE);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, RegionsUnexplored.ID("enchanted_birch_leaves"), ENCHANTED_BIRCH_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, RegionsUnexplored.ID("silver_birch_leaves"), SILVER_BIRCH_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, RegionsUnexplored.ID("blue_magnolia_leaves"), BLUE_MAGNOLIA_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, RegionsUnexplored.ID("pink_magnolia_leaves"), PINK_MAGNOLIA_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, RegionsUnexplored.ID("white_magnolia_leaves"), WHITE_MAGNOLIA_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, RegionsUnexplored.ID("red_maple_leaves"), RED_MAPLE_LEAVES);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, RegionsUnexplored.ID("orange_maple_leaves"), ORANGE_MAPLE_LEAVES);
    }
}