package net.regions_unexplored.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.regions_unexplored.platform.Registrar;
import net.regions_unexplored.world.features.treedecorators.BlackwoodBioshroom;
import net.regions_unexplored.world.features.treedecorators.BranchDecorator;
import net.regions_unexplored.world.features.treedecorators.PlaceOnGroundDecorator;
import net.regions_unexplored.world.features.treedecorators.WillowTrunkDecorator;
import net.regions_unexplored.worldgen.trunkplacer.RedwoodTrunkPlacer;

import java.util.function.Supplier;

public interface RUTrunkPlacerTypes {
    Supplier<TrunkPlacerType<RedwoodTrunkPlacer>> REDWOOD = register("redwood", RedwoodTrunkPlacer.TYPE);

    static <T extends TrunkPlacer> Supplier<TrunkPlacerType<T>> register(String name, TrunkPlacerType<T> type) {
        Registrar.register(BuiltInRegistries.TRUNK_PLACER_TYPE, name, () -> type);
        return () -> type;
    }

    static void init() {
    }
}
