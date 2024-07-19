package net.regions_unexplored.platform;

import com.google.auto.service.AutoService;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.regions_unexplored.platform.services.IParticleRegistry;

@AutoService(IParticleRegistry.class)
public class FabricParticleRegistry implements IParticleRegistry {
    @Override
    public <T extends ParticleOptions> void register(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> factory) {
        ParticleFactoryRegistry.getInstance().register(type, factory::create);
    }
}
