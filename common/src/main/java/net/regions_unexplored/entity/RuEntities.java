package net.regions_unexplored.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.entity.custom.RuChestBoat;
import net.regions_unexplored.platform.Services;

import java.util.function.Supplier;

public class RuEntities {
    public static Supplier<EntityType<RuBoat>> BOAT = registerEntity("boat", () -> EntityType.Builder.<RuBoat>of(RuBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F)
            .clientTrackingRange(10).build("boat"));


    public static Supplier<EntityType<RuChestBoat>> CHEST_BOAT = registerEntity("chest_boat", () -> EntityType.Builder.<RuChestBoat>of(RuChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F)
            .clientTrackingRange(10).build("chest_boat"));

    public static void addEntities() {

    }

    private static <T extends Entity> Supplier<EntityType<T>> registerEntity(String path, Supplier<EntityType<T>> type) {
        return Services.REGISTAR.register(BuiltInRegistries.ENTITY_TYPE, path, type);
    }
}