package net.regions_unexplored.client.particle;

import net.regions_unexplored.platform.ParticleRegistry;
import net.regions_unexplored.registry.RUParticleTypes;

public class RuParticles {
    public static void init() {
        ParticleRegistry.register(RUParticleTypes.MYCOTOXIC_SPORE, MycotoxicSporeParticle.MycotoxicSporeParticleProvider::new);
        ParticleRegistry.register(RUParticleTypes.MAUVE_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RUParticleTypes.PINK_MAGNOLIA_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RUParticleTypes.WHITE_MAGNOLIA_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RUParticleTypes.BLUE_MAGNOLIA_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RUParticleTypes.ENCHANTED_BIRCH_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RUParticleTypes.SILVER_BIRCH_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RUParticleTypes.ORANGE_MAPLE_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RUParticleTypes.RED_MAPLE_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
    }
}
