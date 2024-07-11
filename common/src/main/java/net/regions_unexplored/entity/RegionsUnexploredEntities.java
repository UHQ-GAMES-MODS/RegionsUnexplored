package net.regions_unexplored.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.regions_unexplored.Constants;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.entity.custom.RuChestBoat;

import java.util.HashMap;
import java.util.Map;

public class RegionsUnexploredEntities {
    public static Map<String, EntityType<?>> ENTITY = new HashMap<>();


    public static EntityType<RuBoat> BOAT = registerEntity("boat",
            EntityType.Builder.<RuBoat>of(RuBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F)
                    .clientTrackingRange(10).build("boat"));


    public static EntityType<RuChestBoat> CHEST_BOAT = registerEntity("chest_boat",
            EntityType.Builder.<RuChestBoat>of(RuChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F)
                    .clientTrackingRange(10).build("chest_boat"));

    public static void addEntities() {
        if (ENTITY.isEmpty()) return;
        ENTITY.forEach(RegionsUnexploredEntities::registerEntity);
    }

    private static <T extends Entity> EntityType<T> registerEntity(String path, EntityType<T> type) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, Constants.id(path), type);
    }
}