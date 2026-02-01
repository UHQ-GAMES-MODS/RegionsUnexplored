package net.regions_unexplored.datagen.provider.registry;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageType;

import static net.regions_unexplored.registry.data.RUDamageTypes.*;

public class RUDamageTypeBootstrap {
    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(DORCEL, new DamageType("dorcel", 1.0F));
        context.register(DUSK_TRAP, new DamageType("dusk_trap", 1.0F));
    }
}
