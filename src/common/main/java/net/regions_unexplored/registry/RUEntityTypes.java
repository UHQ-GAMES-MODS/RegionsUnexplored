package net.regions_unexplored.registry;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.entity.custom.RuChestBoat;
import net.regions_unexplored.platform.Registrar;

import java.util.function.Supplier;

public interface RUEntityTypes {
    Supplier<EntityType<RuBoat>> BOAT = register("boat", () -> EntityType.Builder.<RuBoat>of(RuBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("boat"));
    Supplier<EntityType<RuChestBoat>> CHEST_BOAT = register("chest_boat", () -> EntityType.Builder.<RuChestBoat>of(RuChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("chest_boat"));

    static <T extends Entity> Supplier<EntityType<T>> register(String name, Supplier<EntityType<T>> type) {
        return Registrar.registerEntity(name, type);
    }

    static void init() {

    }
}