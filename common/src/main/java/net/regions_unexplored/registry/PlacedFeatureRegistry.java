package net.regions_unexplored.registry;

import io.github.uhq_games.regions_unexplored.RegionsUnexplored;
import io.github.uhq_games.regions_unexplored.block.RuBlocks;
import io.github.uhq_games.regions_unexplored.data.worldgen.placement.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PlacedFeatureRegistry {
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        RuAquaticPlacements.bootstrap(context);
        RuMiscOverworldPlacements.bootstrap(context);
        RuNetherPlacements.bootstrap(context);
        RuTreePlacements.bootstrap(context);
        RuVegetationPlacements.bootstrap(context);
    }

    public static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, RegionsUnexplored.ID(name));
    }

    public static BlockPredicate onDirtPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT, RuBlocks.PEAT_DIRT, RuBlocks.SILT_DIRT, RuBlocks.PEAT_COARSE_DIRT, RuBlocks.SILT_COARSE_DIRT, RuBlocks.PEAT_PODZOL, RuBlocks.SILT_PODZOL);
    public static BlockPredicate onGrassBlockPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK, RuBlocks.PEAT_GRASS_BLOCK, RuBlocks.SILT_GRASS_BLOCK, RuBlocks.STONE_GRASS_BLOCK, RuBlocks.DEEPSLATE_GRASS_BLOCK);
    public static BlockPredicate onViridescentNyliumPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), RuBlocks.VIRIDESCENT_NYLIUM, RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM);
    public static BlockPredicate onSnowPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.SNOW_BLOCK, Blocks.GRASS_BLOCK, RuBlocks.PEAT_GRASS_BLOCK, RuBlocks.SILT_GRASS_BLOCK);
}
