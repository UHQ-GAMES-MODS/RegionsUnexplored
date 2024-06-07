package net.regions_unexplored.registry;

import io.github.uhq_games.regions_unexplored.RegionsUnexplored;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public class DamageTypeRegistry {
    public static ResourceKey<DamageType> createKey(String key) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, RegionsUnexplored.ID(key));
    }
}
