package net.regions_unexplored.client.particle;

import net.regions_unexplored.platform.ParticleRegistry;
import net.regions_unexplored.registry.RUParticleTypes;

public class RuParticles {
    public static void init() {
        ParticleRegistry.register(RUParticleTypes.MYCOTOXIC_SPORE.get(), MycotoxicSporeParticle.MycotoxicSporeParticleProvider::new);
        ParticleRegistry.register(RUParticleTypes.SMALL_LEAVES.get(), RULeavesParticle.Provider::flowing);
        ParticleRegistry.register(RUParticleTypes.STANDARD_LEAVES.get(), RULeavesParticle.Provider::swirling);
        ParticleRegistry.register(RUParticleTypes.LARGE_LEAVES.get(), RULeavesParticle.Provider::large);
        ParticleRegistry.register(RUParticleTypes.PINE_LEAVES.get(), RULeavesParticle.Provider::pine);
        ParticleRegistry.register(RUParticleTypes.MAGNOLIA_LEAVES.get(), RULeavesParticle.Provider::magnolia);
        ParticleRegistry.register(RUParticleTypes.PINK_MAGNOLIA_LEAVES.get(), RULeavesParticle.Provider::magnolia);
        ParticleRegistry.register(RUParticleTypes.WHITE_MAGNOLIA_LEAVES.get(), RULeavesParticle.Provider::magnolia);
        ParticleRegistry.register(RUParticleTypes.BLUE_MAGNOLIA_LEAVES.get(), RULeavesParticle.Provider::magnolia);

    }
}
