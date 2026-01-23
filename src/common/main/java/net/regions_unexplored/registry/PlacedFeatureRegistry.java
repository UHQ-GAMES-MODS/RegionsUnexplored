package net.regions_unexplored.registry;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.data.worldgen.placement.*;

public class PlacedFeatureRegistry {
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        RuAquaticPlacements.bootstrap(context);
        RuMiscOverworldPlacements.bootstrap(context);
        RuNetherPlacements.bootstrap(context);
        RuTreePlacements.bootstrap(context);
        RuVegetationPlacements.bootstrap(context);
    }

    public static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, RegionsUnexplored.id(name));
    }

    // TODO: Convert these into tags
    public static BlockPredicate onDirtPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT, RUBlocks.PEAT_DIRT.get(), RUBlocks.SILT_DIRT.get(), RUBlocks.PEAT_COARSE_DIRT.get(), RUBlocks.SILT_COARSE_DIRT.get(), RUBlocks.PEAT_PODZOL.get(), RUBlocks.SILT_PODZOL.get());
    public static BlockPredicate onGrassBlockPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK, RUBlocks.PEAT_GRASS_BLOCK.get(), RUBlocks.SILT_GRASS_BLOCK.get(), RUBlocks.STONE_GRASS_BLOCK.get(), RUBlocks.DEEPSLATE_GRASS_BLOCK.get());
    public static BlockPredicate onViridescentNyliumPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), RUBlocks.VIRIDESCENT_NYLIUM.get(), RUBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get());
    public static BlockPredicate onSnowPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.SNOW_BLOCK, Blocks.GRASS_BLOCK, RUBlocks.PEAT_GRASS_BLOCK.get(), RUBlocks.SILT_GRASS_BLOCK.get());
}
