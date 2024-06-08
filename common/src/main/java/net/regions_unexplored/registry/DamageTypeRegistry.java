package net.regions_unexplored.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.regions_unexplored.Constants;

public class DamageTypeRegistry {
    public static ResourceKey<DamageType> createKey(String key) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, Constants.id(key));
    }
}
