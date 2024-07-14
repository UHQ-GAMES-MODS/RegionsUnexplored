package net.regions_unexplored.platform.services;

import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

public interface IParticleRegistry {
    <T extends ParticleOptions> void register(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> factory);
}
