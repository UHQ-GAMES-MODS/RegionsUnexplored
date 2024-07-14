package net.regions_unexplored.client;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.NeoForgeParticleHelper;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class ParticleRegistration {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        NeoForgeParticleHelper.spriteParticleRegistrationMap.forEach(event::registerSpriteSet);
    }
}
