package net.regions_unexplored.platform;

import com.google.auto.service.AutoService;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.regions_unexplored.platform.services.IParticleRegistry;

import java.util.HashMap;
import java.util.Map;

@AutoService(IParticleRegistry.class)
public class NeoForgeParticleHelper implements IParticleRegistry {
    public static final Map<ParticleType, ParticleEngine.SpriteParticleRegistration> spriteParticleRegistrationMap = new HashMap<>();

    @Override
    public <T extends ParticleOptions> void register(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> factory) {
        spriteParticleRegistrationMap.computeIfAbsent(type, k -> factory);
    }
}
