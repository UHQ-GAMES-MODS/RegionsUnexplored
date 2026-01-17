package net.regions_unexplored.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.entity.custom.RuChestBoat;
import net.regions_unexplored.platform.Registar;

import java.util.function.Supplier;

public class RuEntities {
    public static Supplier<EntityType<RuBoat>> BOAT = Registar.registerEntity("boat", () -> EntityType.Builder.<RuBoat>of(RuBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F)
            .clientTrackingRange(10).build("boat"));


    public static Supplier<EntityType<RuChestBoat>> CHEST_BOAT = Registar.registerEntity("chest_boat", () -> EntityType.Builder.<RuChestBoat>of(RuChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F)
            .clientTrackingRange(10).build("chest_boat"));

    public static void addEntities() {

    }
}