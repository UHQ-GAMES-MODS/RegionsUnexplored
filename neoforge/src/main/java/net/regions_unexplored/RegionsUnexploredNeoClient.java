package net.regions_unexplored;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.regions_unexplored.client.ParticleRegistration;
import net.regions_unexplored.client.TintRegistration;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class RegionsUnexploredNeoClient {

    public static void regionsUnexploredNeoClient(IEventBus bus) {
        bus.addListener(TintRegistration::registerBlockColorHandlers);
        bus.addListener(TintRegistration::registerItemColorHandlers);
        bus.addListener(ParticleRegistration::registerParticleProviders);
    }
}
