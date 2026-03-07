package net.regions_unexplored.datagen.provider.registry;

import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.datagen.provider.registry.placed_feature.*;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.registry.tag.RUBlockTags;

public class RUPlacedFeatureBootstrap {
    public static final BlockPredicate onDirtPredicate = BlockPredicate.matchesTag(Vec3i.ZERO.below(), RUBlockTags.DIRT_AND_PODZOL);
    // TODO: Convert these into tags
    public static final BlockPredicate onGrassBlockPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK, RUBlocks.PEAT_GRASS_BLOCK.get(), RUBlocks.SILT_GRASS_BLOCK.get(), RUBlocks.STONE_GRASS_BLOCK.get(), RUBlocks.DEEPSLATE_GRASS_BLOCK.get());
    public static final BlockPredicate onViridescentNyliumPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), RUBlocks.VIRIDESCENT_NYLIUM.get(), RUBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get());
    public static final BlockPredicate onSnowPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.SNOW_BLOCK, Blocks.GRASS_BLOCK, RUBlocks.PEAT_GRASS_BLOCK.get(), RUBlocks.SILT_GRASS_BLOCK.get());

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        RuAquaticPlacements.bootstrap(context);
        RuMiscOverworldPlacements.bootstrap(context);
        RuNetherPlacements.bootstrap(context);
        RuTreePlacements.bootstrap(context);
        RuVegetationPlacements.bootstrap(context);
    }
}
