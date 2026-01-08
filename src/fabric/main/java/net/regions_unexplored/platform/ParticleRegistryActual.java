package net.regions_unexplored.platform;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.msrandom.multiplatform.annotations.Actual;

public class ParticleRegistryActual {
    @Actual
    public static <T extends ParticleOptions> void register(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> factory) {
        ParticleFactoryRegistry.getInstance().register(type, factory::create);
    }
}
