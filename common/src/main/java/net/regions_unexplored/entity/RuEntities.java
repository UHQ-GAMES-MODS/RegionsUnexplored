package net.regions_unexplored.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.regions_unexplored.Constants;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.entity.custom.RuChestBoat;
import net.regions_unexplored.platform.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RuEntities {
    public static Map<String, EntityType<?>> ENTITY = new HashMap<>();


    public static EntityType<RuBoat> BOAT = EntityType.Builder.<RuBoat>of(RuBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F)
            .clientTrackingRange(10).build("boat");


    public static EntityType<RuChestBoat> CHEST_BOAT = EntityType.Builder.<RuChestBoat>of(RuChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F)
            .clientTrackingRange(10).build("chest_boat");

    public static void addEntities() {
        registerEntity("boat", () -> BOAT);
        registerEntity("chest_boat", () -> CHEST_BOAT);
    }

    private static void registerEntity(String path, Supplier<EntityType<?>> type) {
        Services.REGISTAR.register(BuiltInRegistries.ENTITY_TYPE, path, type);
    }
}