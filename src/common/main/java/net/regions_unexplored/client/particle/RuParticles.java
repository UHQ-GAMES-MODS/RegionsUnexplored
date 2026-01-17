package net.regions_unexplored.client.particle;

import net.regions_unexplored.platform.ParticleRegistry;

public class RuParticles {
    public static void init() {
        ParticleRegistry.register(RuParticleTypes.MYCOTOXIC_SPORE, MycotoxicSporeParticle.MycotoxicSporeParticleProvider::new);
        ParticleRegistry.register(RuParticleTypes.MAUVE_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RuParticleTypes.PINK_MAGNOLIA_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RuParticleTypes.WHITE_MAGNOLIA_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RuParticleTypes.BLUE_MAGNOLIA_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RuParticleTypes.ENCHANTED_BIRCH_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RuParticleTypes.SILVER_BIRCH_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RuParticleTypes.ORANGE_MAPLE_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        ParticleRegistry.register(RuParticleTypes.RED_MAPLE_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
    }
}
