package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.regions_unexplored.RegionsUnexplored;

public interface RUDamageTypes {
    ResourceKey<DamageType> DORCEL = key("dorcel");
    ResourceKey<DamageType> DUSK_TRAP = key("dusk_trap");

    static ResourceKey<DamageType> key(String name) {
        return RegionsUnexplored.key(Registries.DAMAGE_TYPE, name);
    }

    static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(DORCEL, new DamageType("dorcel", 1.0F));
        context.register(DUSK_TRAP, new DamageType("dusk_trap", 1.0F));
    }
}
