package net.regions_unexplored;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.regions_unexplored.client.ParticleRegistration;
import net.regions_unexplored.client.TintRegistration;

@Mod(value = RegionsUnexplored.MOD_ID, dist = Dist.CLIENT)
public class RegionsUnexploredNeoClient {

    public static void regionsUnexploredNeoClient(IEventBus bus) {
        bus.addListener(TintRegistration::registerBlockColorHandlers);
        bus.addListener(TintRegistration::registerItemColorHandlers);
        bus.addListener(ParticleRegistration::registerParticleProviders);
    }
}
