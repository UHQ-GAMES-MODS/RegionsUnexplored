package net.regions_unexplored.client.particle;

import net.regions_unexplored.platform.Services;

public class RuParticles {
    public static void init() {
        // Registers the particles clientside
        Services.PARTICLES.register(RuParticleTypes.MYCOTOXIC_SPORE, MycotoxicSporeParticle.MycotoxicSporeParticleProvider::new);
        Services.PARTICLES.register(RuParticleTypes.MAUVE_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        Services.PARTICLES.register(RuParticleTypes.PINK_MAGNOLIA_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        Services.PARTICLES.register(RuParticleTypes.WHITE_MAGNOLIA_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        Services.PARTICLES.register(RuParticleTypes.BLUE_MAGNOLIA_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        Services.PARTICLES.register(RuParticleTypes.ENCHANTED_BIRCH_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        Services.PARTICLES.register(RuParticleTypes.SILVER_BIRCH_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        Services.PARTICLES.register(RuParticleTypes.ORANGE_MAPLE_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
        Services.PARTICLES.register(RuParticleTypes.RED_MAPLE_LEAVES, spriteSet -> (simpleParticleType, clientLevel, d, e, f, g, h, i) -> new LeafParticle(clientLevel, d, e, f, spriteSet));
    }
}
