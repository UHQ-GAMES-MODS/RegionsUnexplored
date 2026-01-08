package net.regions_unexplored.platform;

import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.msrandom.multiplatform.annotations.Expect;

import java.util.HashMap;
import java.util.Map;

public class ParticleRegistry {
    @Expect
    public static <T extends ParticleOptions> void register(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> factory);
}
