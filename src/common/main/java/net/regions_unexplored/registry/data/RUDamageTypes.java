package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.regions_unexplored.RegionsUnexplored;

public interface RUDamageTypes {
    ResourceKey<DamageType> DORCEL = key("dorcel");
    ResourceKey<DamageType> DUSK_TRAP = key("dusk_trap");

    static ResourceKey<DamageType> key(String name) {
        return RegionsUnexplored.key(Registries.DAMAGE_TYPE, name);
    }
}
