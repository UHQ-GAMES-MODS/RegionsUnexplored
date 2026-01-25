package net.regions_unexplored.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.regions_unexplored.platform.Registrar;
import net.regions_unexplored.world.features.treedecorators.*;

import java.util.function.Supplier;

public interface RUTreeDecoratorTypes {
    Supplier<TreeDecoratorType<BlackwoodBioshroom>> BLACKWOOD_BIOSHROOMS = register("blackwood_bioshrooms", BlackwoodBioshroom.TYPE);
    Supplier<TreeDecoratorType<BranchDecorator>> BRANCH = register("branch", BranchDecorator.TYPE);
    Supplier<TreeDecoratorType<PlaceOnGroundDecorator>> PLACE_ON_GROUND = register("place_on_ground", PlaceOnGroundDecorator.TYPE);
    Supplier<TreeDecoratorType<WillowTrunkDecorator>> WILLOW = register("willow", WillowTrunkDecorator.TYPE);

    static <T extends TreeDecorator> Supplier<TreeDecoratorType<T>> register(String name, TreeDecoratorType<T> type) {
        Registrar.register(BuiltInRegistries.TREE_DECORATOR_TYPE, name, () -> type);
        return () -> type;
    }

    static void init() {
    }
}
