package net.regions_unexplored.client.particle;

import net.regions_unexplored.client.particle.spore.FallingSporeParticle;
import net.regions_unexplored.client.particle.spore.FloatingSporeParticle;
import net.regions_unexplored.client.particle.spore.GroundSporeParticle;
import net.regions_unexplored.registry.RUParticleTypes;

import static net.regions_unexplored.platform.ParticleRegistry.register;

public interface RUParticleProviders {
    static void init() {
        register(RUParticleTypes.SMALL_LEAVES.get(), RULeavesParticle.Provider::flowing);
        register(RUParticleTypes.STANDARD_LEAVES.get(), RULeavesParticle.Provider::swirling);
        register(RUParticleTypes.LARGE_LEAVES.get(), RULeavesParticle.Provider::large);
        register(RUParticleTypes.PINE_LEAVES.get(), RULeavesParticle.Provider::pine);
        register(RUParticleTypes.MAGNOLIA_LEAVES.get(), RULeavesParticle.Provider::magnolia);
        register(RUParticleTypes.PINK_MAGNOLIA_LEAVES.get(), RULeavesParticle.Provider::magnolia);
        register(RUParticleTypes.WHITE_MAGNOLIA_LEAVES.get(), RULeavesParticle.Provider::magnolia);
        register(RUParticleTypes.BLUE_MAGNOLIA_LEAVES.get(), RULeavesParticle.Provider::magnolia);

        register(RUParticleTypes.GROUND_SPORE.get(), GroundSporeParticle.Provider::new);
        register(RUParticleTypes.FALLING_SPORE.get(), FallingSporeParticle.Provider::new);
        register(RUParticleTypes.FLOATING_SPORE.get(), FloatingSporeParticle.Provider::new);

        register(RUParticleTypes.MYCOTOXIC_SPORE.get(), MycotoxicSporeParticle.MycotoxicSporeParticleProvider::new);
    }
}
