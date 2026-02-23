package net.regions_unexplored.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.regions_unexplored.platform.Registrar;
import net.regions_unexplored.worldgen.foliageplacer.RedwoodFoliagePlacer;
import net.regions_unexplored.worldgen.foliageplacer.SakuraFoliagePlacer;
import net.regions_unexplored.worldgen.foliageplacer.WillowFoliagePlacer;

import java.util.function.Supplier;

public interface RUFoliagePlacerTypes {
    Supplier<FoliagePlacerType<SakuraFoliagePlacer>> SAKURA = register("sakura", SakuraFoliagePlacer.TYPE);
    Supplier<FoliagePlacerType<WillowFoliagePlacer>> WILLOW = register("willow", WillowFoliagePlacer.TYPE);
    Supplier<FoliagePlacerType<RedwoodFoliagePlacer>> REDWOOD = register("redwood", RedwoodFoliagePlacer.TYPE);

    static <T extends FoliagePlacer> Supplier<FoliagePlacerType<T>> register(String name, FoliagePlacerType<T> type) {
        Registrar.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, name, () -> type);
        return () -> type;
    }

    static void init() {
    }
}
