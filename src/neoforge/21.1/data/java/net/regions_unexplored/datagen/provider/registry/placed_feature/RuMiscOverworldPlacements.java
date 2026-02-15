package net.regions_unexplored.datagen.provider.registry.placed_feature;

import dev.worldgen.lithostitched.worldgen.blockpredicate.InStructurePredicate;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.datagen.provider.registry.configured_feature.RuMiscOverworldFeatures;
import net.regions_unexplored.datagen.provider.registry.RUPlacedFeatureBootstrap;
import net.regions_unexplored.registry.data.RUPlacedFeatures;

import java.util.List;
import java.util.Optional;

public class RuMiscOverworldPlacements {
    //-----------------------KEYS-----------------------//
    public static final ResourceKey<PlacedFeature> DISK_CLAY = RUPlacedFeatureBootstrap.key("disk_clay");
    public static final ResourceKey<PlacedFeature> DISK_GRAVEL = RUPlacedFeatureBootstrap.key("disk_gravel");
    public static final ResourceKey<PlacedFeature> DISK_SAND = RUPlacedFeatureBootstrap.key("disk_sand");
    //ROCKS
    public static final ResourceKey<PlacedFeature> REDWOODS_ROCK = RUPlacedFeatureBootstrap.key("redwoods_rock");
    //FALLEN_TREES
    public static final ResourceKey<PlacedFeature> FALLEN_LARCH = RUPlacedFeatureBootstrap.key("fallen_larch");
    public static final ResourceKey<PlacedFeature> FALLEN_MAPLE = RUPlacedFeatureBootstrap.key("fallen_maple");
    public static final ResourceKey<PlacedFeature> FALLEN_OAK_SPARSE = RUPlacedFeatureBootstrap.key("fallen_oak_tree_sparse");
    public static final ResourceKey<PlacedFeature> FALLEN_OAK_DENSE = RUPlacedFeatureBootstrap.key("fallen_oak_tree_dense");
    public static final ResourceKey<PlacedFeature> FALLEN_PINE = RUPlacedFeatureBootstrap.key("fallen_pine");
    public static final ResourceKey<PlacedFeature> FALLEN_PINE_ON_DIRT = RUPlacedFeatureBootstrap.key("fallen_pine_tree_on_dirt");
    public static final ResourceKey<PlacedFeature> FALLEN_PINE_ON_SNOW = RUPlacedFeatureBootstrap.key("fallen_pine_tree_on_snow");
    public static final ResourceKey<PlacedFeature> FALLEN_SILVER_BIRCH = RUPlacedFeatureBootstrap.key("fallen_silver_birch");
    //CAVE_FEATURES
    public static final ResourceKey<PlacedFeature>  POINTED_REDSTONE = RUPlacedFeatureBootstrap.key("pointed_redstone");
    public static final ResourceKey<PlacedFeature>  LARGE_POINTED_REDSTONE = RUPlacedFeatureBootstrap.key("large_pointed_redstone");
    public static final ResourceKey<PlacedFeature>  POINTED_REDSTONE_CLUSTER = RUPlacedFeatureBootstrap.key("pointed_redstone_cluster");
    public static final ResourceKey<PlacedFeature>  ORE_REDSTONE_LARGE = RUPlacedFeatureBootstrap.key("ore_redstone_large");
    public static final ResourceKey<PlacedFeature>  PRISMARITE_CLUSTERS = RUPlacedFeatureBootstrap.key("prismarite_clusters");
    public static final ResourceKey<PlacedFeature>  HANGING_PRISMARITE_CLUSTER = RUPlacedFeatureBootstrap.key("hanging_prismarite_cluster");
    public static final ResourceKey<PlacedFeature>  LAVA_FALL = RUPlacedFeatureBootstrap.key("lava_fall");
    public static final ResourceKey<PlacedFeature>  OVERWORLD_LAVA_DELTA = RUPlacedFeatureBootstrap.key("overworld_lava_delta");
    public static final ResourceKey<PlacedFeature>  ASH_VENT = RUPlacedFeatureBootstrap.key("ash_vent");
    public static final ResourceKey<PlacedFeature>  BASALT_BLOB = RUPlacedFeatureBootstrap.key("basalt_blob");
    //OTHER_FEATURES
    public static final ResourceKey<PlacedFeature>  MINERAL_POOL = RUPlacedFeatureBootstrap.key("mineral_pool");

    public static final ResourceKey<PlacedFeature> MOSS_PATCH_WITH_WATER = RUPlacedFeatureBootstrap.key("moss_patch_with_water");
    public static final ResourceKey<PlacedFeature> MOSS_PATCH_WITH_WATER_UNCOMMON = RUPlacedFeatureBootstrap.key("moss_patch_with_water_uncommon");
    public static final ResourceKey<PlacedFeature> MOSS_PATCH_WITH_WATER_RARE = RUPlacedFeatureBootstrap.key("moss_patch_with_water_rare");
    public static final ResourceKey<PlacedFeature> MARSH = RUPlacedFeatureBootstrap.key("marsh");
    public static final ResourceKey<PlacedFeature> WATER_EDGE = RUPlacedFeatureBootstrap.key("water_edge");
    public static final ResourceKey<PlacedFeature> ICICLE_UP = RUPlacedFeatureBootstrap.key("icicle_up");
    public static final ResourceKey<PlacedFeature> MEADOW_ROCK = RUPlacedFeatureBootstrap.key("meadow_rock");
    public static final ResourceKey<PlacedFeature> ROCK = RUPlacedFeatureBootstrap.key("rock");
    public static final ResourceKey<PlacedFeature> ROCK_ON_GRAVEL = RUPlacedFeatureBootstrap.key("rock_on_gravel");
    public static final ResourceKey<PlacedFeature> ROCK_ON_SNOW = RUPlacedFeatureBootstrap.key("rock_on_snow");
    public static final ResourceKey<PlacedFeature> NOISE_PUMPKINS = RUPlacedFeatureBootstrap.key("noise_pumpkins");
    public static final ResourceKey<PlacedFeature> NOISE_ROCKS = RUPlacedFeatureBootstrap.key("noise_rocks");
    public static final ResourceKey<PlacedFeature> NOISE_BUSH = RUPlacedFeatureBootstrap.key("noise_bush");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> featureGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        //---------------------FEATURES---------------------//
        Holder<ConfiguredFeature<?, ?>> DISK_CLAY = featureGetter.getOrThrow(RuMiscOverworldFeatures.DISK_CLAY);
        Holder<ConfiguredFeature<?, ?>> DISK_GRAVEL = featureGetter.getOrThrow(RuMiscOverworldFeatures.DISK_GRAVEL);
        Holder<ConfiguredFeature<?, ?>> DISK_SAND = featureGetter.getOrThrow(RuMiscOverworldFeatures.DISK_SAND);
        //ROCKS
        final Holder<ConfiguredFeature<?, ?>> REDWOODS_ROCK = featureGetter.getOrThrow(RuMiscOverworldFeatures.REDWOODS_ROCK);
        //FALLEN_TREES
        final Holder<ConfiguredFeature<?, ?>> FALLEN_LARCH = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_LARCH);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_MAPLE = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_MAPLE);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_OAK = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_OAK);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_OAK_WITH_BLOB = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_OAK_WITH_BLOB);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_PINE = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_PINE);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_SNOW_PINE = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_SNOW_PINE);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_SILVER_BIRCH = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_SILVER_BIRCH);
        //CAVE_FEATURES
        final Holder<ConfiguredFeature<?, ?>>  POINTED_REDSTONE = featureGetter.getOrThrow(RuMiscOverworldFeatures.POINTED_REDSTONE);
        final Holder<ConfiguredFeature<?, ?>>  LARGE_POINTED_REDSTONE = featureGetter.getOrThrow(RuMiscOverworldFeatures.LARGE_POINTED_REDSTONE);
        final Holder<ConfiguredFeature<?, ?>>  POINTED_REDSTONE_CLUSTER = featureGetter.getOrThrow(RuMiscOverworldFeatures.POINTED_REDSTONE_CLUSTER);
        final Holder<ConfiguredFeature<?, ?>>  ORE_REDSTONE_LARGE = featureGetter.getOrThrow(RuMiscOverworldFeatures.ORE_REDSTONE_LARGE);

        final Holder<ConfiguredFeature<?, ?>>  PRISMARITE_CLUSTERS = featureGetter.getOrThrow(RuMiscOverworldFeatures.PRISMARITE_CLUSTERS);
        final Holder<ConfiguredFeature<?, ?>>  HANGING_PRISMARITE_CLUSTER = featureGetter.getOrThrow(RuMiscOverworldFeatures.HANGING_PRISMARITE_CLUSTER);

        final Holder<ConfiguredFeature<?, ?>>  MINERAL_POOL = featureGetter.getOrThrow(RuMiscOverworldFeatures.MINERAL_POOL);

        final Holder<ConfiguredFeature<?, ?>>  LAVA_FALL = featureGetter.getOrThrow(RuMiscOverworldFeatures.LAVA_FALL);
        final Holder<ConfiguredFeature<?, ?>>  OVERWORLD_LAVA_DELTA = featureGetter.getOrThrow(RuMiscOverworldFeatures.OVERWORLD_LAVA_DELTA);
        final Holder<ConfiguredFeature<?, ?>>  ASH_VENT = featureGetter.getOrThrow(RuMiscOverworldFeatures.ASH_VENT);
        final Holder<ConfiguredFeature<?, ?>>  BASALT_BLOB = featureGetter.getOrThrow(RuMiscOverworldFeatures.BASALT_BLOB);
        //OTHER_FEATURES
        final Holder<ConfiguredFeature<?, ?>>  MOSS_PATCH_WITH_WATER = featureGetter.getOrThrow(RuMiscOverworldFeatures.MOSS_PATCH_WITH_WATER);
        final Holder<ConfiguredFeature<?, ?>>  MARSH = featureGetter.getOrThrow(RuMiscOverworldFeatures.MARSH);
        final Holder<ConfiguredFeature<?, ?>>  WATER_EDGE = featureGetter.getOrThrow(RuMiscOverworldFeatures.WATER_EDGE);
        final Holder<ConfiguredFeature<?, ?>>  ICICLE_UP = featureGetter.getOrThrow(RuMiscOverworldFeatures.ICICLE_UP);
        final Holder<ConfiguredFeature<?, ?>>  MEADOW_ROCK = featureGetter.getOrThrow(RuMiscOverworldFeatures.MEADOW_ROCK);
        final Holder<ConfiguredFeature<?, ?>>  ROCK = featureGetter.getOrThrow(RuMiscOverworldFeatures.ROCK);
        final Holder<ConfiguredFeature<?, ?>>  NOISE_PUMPKINS = featureGetter.getOrThrow(RuMiscOverworldFeatures.PATCH_NOISE_PUMPKINS);
        final Holder<ConfiguredFeature<?, ?>>  NOISE_ROCKS = featureGetter.getOrThrow(RuMiscOverworldFeatures.PATCH_NOISE_ROCKS);
        final Holder<ConfiguredFeature<?, ?>>  NOISE_BUSH = featureGetter.getOrThrow(RuMiscOverworldFeatures.PATCH_NOISE_BUSH);

        //--------------------PLACEMENTS--------------------//
        register(context, RuMiscOverworldPlacements.DISK_CLAY, DISK_CLAY, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)), BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.DISK_GRAVEL, DISK_GRAVEL, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)), BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.DISK_SAND, DISK_SAND, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)), BiomeFilter.biome());
        //ROCKS
        register(context, RuMiscOverworldPlacements.REDWOODS_ROCK, REDWOODS_ROCK, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        //FALLEN_TREES
        register(context, RuMiscOverworldPlacements.FALLEN_LARCH, FALLEN_LARCH, List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_SILVER_BIRCH, FALLEN_SILVER_BIRCH, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_MAPLE, FALLEN_MAPLE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_OAK_SPARSE, FALLEN_OAK, List.of(RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_OAK_DENSE, FALLEN_OAK_WITH_BLOB, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_PINE, FALLEN_PINE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_PINE_ON_DIRT, FALLEN_PINE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onDirtPredicate), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_PINE_ON_SNOW, FALLEN_SNOW_PINE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));
        //CAVE_FEATURES
        register(context, RuMiscOverworldPlacements.POINTED_REDSTONE, POINTED_REDSTONE, CountPlacement.of(UniformInt.of(192, 256)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(UniformInt.of(1, 5)), RandomOffsetPlacement.of(ClampedNormalInt.of(0.0F, 3.0F, -10, 10), ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.LARGE_POINTED_REDSTONE, LARGE_POINTED_REDSTONE, CountPlacement.of(UniformInt.of(10, 48)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.POINTED_REDSTONE_CLUSTER, POINTED_REDSTONE_CLUSTER, CountPlacement.of(UniformInt.of(78, 126)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.ORE_REDSTONE_LARGE, ORE_REDSTONE_LARGE, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(112))));

        register(context, RuMiscOverworldPlacements.PRISMARITE_CLUSTERS, PRISMARITE_CLUSTERS, List.of(CountOnEveryLayerPlacement.of(8), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.HANGING_PRISMARITE_CLUSTER, HANGING_PRISMARITE_CLUSTER, CountPlacement.of(UniformInt.of(78, 126)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());

        register(context, RuMiscOverworldPlacements.MINERAL_POOL, MINERAL_POOL, CountPlacement.of(70), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());

        var notInStructurePredicate = BlockPredicateFilter.forPredicate(BlockPredicate.not(new InStructurePredicate(Optional.empty(), new InStructurePredicate.SearchRange(4))));
        register(context, RuMiscOverworldPlacements.LAVA_FALL, LAVA_FALL, List.of(
                CountOnEveryLayerPlacement.of(1),
                BiomeFilter.biome(),
                notInStructurePredicate
        ));
        register(context, RuMiscOverworldPlacements.OVERWORLD_LAVA_DELTA, OVERWORLD_LAVA_DELTA,
                CountPlacement.of(115),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                BiomeFilter.biome(),
                notInStructurePredicate
        );
        register(context, RuMiscOverworldPlacements.ASH_VENT, ASH_VENT, List.of(
                CountOnEveryLayerPlacement.of(7),
                BiomeFilter.biome(),
                notInStructurePredicate
        ));
        register(context, RuMiscOverworldPlacements.BASALT_BLOB, BASALT_BLOB, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
        //OTHER_FEATURES
        register(context, RuMiscOverworldPlacements.MOSS_PATCH_WITH_WATER, MOSS_PATCH_WITH_WATER, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.MOSS_PATCH_WITH_WATER_UNCOMMON, MOSS_PATCH_WITH_WATER, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.MOSS_PATCH_WITH_WATER_RARE, MOSS_PATCH_WITH_WATER, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.MARSH, MARSH, CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.WATER_EDGE, WATER_EDGE, CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,  BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.ICICLE_UP, ICICLE_UP, List.of(CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.MEADOW_ROCK, MEADOW_ROCK, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.ROCK, ROCK, List.of(CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.ROCK_ON_GRAVEL, ROCK, List.of(CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(RUBlocks.GRASS_SPROUTS.get()), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.ROCK_ON_SNOW, ROCK, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.NOISE_PUMPKINS, NOISE_PUMPKINS, List.of(NoiseBasedCountPlacement.of(4, 40, 0.4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.NOISE_ROCKS, NOISE_ROCKS, List.of(CountPlacement.of(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.NOISE_BUSH, NOISE_BUSH, List.of(CountPlacement.of(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        final Holder<ConfiguredFeature<?, ?>>  singlePieceOfGrass = featureGetter.getOrThrow(VegetationFeatures.SINGLE_PIECE_OF_GRASS);
        PlacementModifier airCheck = BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(BlockTags.AIR));
        register(context, RUPlacedFeatures.BONEMEAL_ARGILLITE_GRASS, singlePieceOfGrass, airCheck);
        register(context, RUPlacedFeatures.BONEMEAL_CHALK_GRASS, singlePieceOfGrass, airCheck);
        register(context, RUPlacedFeatures.BONEMEAL_DEEPSLATE_GRASS, singlePieceOfGrass, airCheck);
        register(context, RUPlacedFeatures.BONEMEAL_PEAT_GRASS, singlePieceOfGrass, airCheck);
        register(context, RUPlacedFeatures.BONEMEAL_SILT_GRASS, singlePieceOfGrass, airCheck);
        register(context, RUPlacedFeatures.BONEMEAL_STONE_GRASS, singlePieceOfGrass, airCheck);
    }
    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier1) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier1, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(i), placementModifier);
    }

    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placement) {
        register(context, key, feature, List.of(placement));
    }

    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placement) {
        context.register(key, new PlacedFeature(feature, placement));
    }
}
