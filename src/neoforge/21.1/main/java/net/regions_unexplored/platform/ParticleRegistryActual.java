package net.regions_unexplored.platform;

import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.msrandom.multiplatform.annotations.Actual;
import net.regions_unexplored.client.ParticleRegistration;

public class ParticleRegistryActual {
    @Actual
    public static <T extends ParticleOptions> void register(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> factory) {
        ParticleRegistration.spriteParticleRegistrationMap.computeIfAbsent(type, k -> factory);
    }
}
