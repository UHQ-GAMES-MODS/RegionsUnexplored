package net.regions_unexplored.datagen.provider.registry.configured_feature;

import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.datagen.provider.registry.RUConfiguredFeatureBootstrap;
import net.regions_unexplored.registry.RUFeatureTypes;
import net.regions_unexplored.registry.data.RUConfiguredFeatures;
import net.regions_unexplored.world.level.block.plant.flower.GroundCoverBlock;
import net.regions_unexplored.world.level.feature.configuration.LargePointedRedstoneConfiguration;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneClusterConfiguration;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneConfiguration;

public class RuNetherFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_YELLOW_BIOSHROOM = RUConfiguredFeatureBootstrap.createKey("small_yellow_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MYCOTOXIC_MUSHROOMS = RUConfiguredFeatureBootstrap.createKey("patch_mycotoxic_mushrooms");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MYCOTOXIC_GRASS = RUConfiguredFeatureBootstrap.createKey("patch_mycotoxic_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MYCOTOXIC_DAISY = RUConfiguredFeatureBootstrap.createKey("patch_mycotoxic_daisy");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BRIMSPROUT = RUConfiguredFeatureBootstrap.createKey("patch_brimsprout");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BRIM_FLAMES = RUConfiguredFeatureBootstrap.createKey("patch_brim_flames");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DORCEL = RUConfiguredFeatureBootstrap.createKey("dorcel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BRIMWOOD_SHRUB = RUConfiguredFeatureBootstrap.createKey("brimwood_shrub");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ROCK = RUConfiguredFeatureBootstrap.createKey("nether_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLISTERING_IVY = RUConfiguredFeatureBootstrap.createKey("patch_glistering_ivy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLISTERING_SPROUT = RUConfiguredFeatureBootstrap.createKey("patch_glistering_sprout");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLISTERING_FERN = RUConfiguredFeatureBootstrap.createKey("patch_glistering_fern");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLISTERING_BLOOM = RUConfiguredFeatureBootstrap.createKey("patch_glistering_bloom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLISTER_SPIRE = RUConfiguredFeatureBootstrap.createKey("patch_glister_spire");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLISTER_BULB = RUConfiguredFeatureBootstrap.createKey("patch_glister_bulb");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_HANGING_EARLIGHT = RUConfiguredFeatureBootstrap.createKey("patch_hanging_earlight");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_COBALT_EARLIGHT = RUConfiguredFeatureBootstrap.createKey("patch_cobalt_earlight");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_COBALT_EARLIGHT = RUConfiguredFeatureBootstrap.createKey("tall_cobalt_earlight");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLACKSTONE_CLUSTER = RUConfiguredFeatureBootstrap.createKey("patch_blackstone_cluster");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_COBALT_ROOTS = RUConfiguredFeatureBootstrap.createKey("patch_cobalt_roots");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OBSIDIAN_SPIRE = RUConfiguredFeatureBootstrap.createKey("obsidian_spire");

    public static final ResourceKey<ConfiguredFeature<?, ?>> POINTED_REDSTONE_NETHER = RUConfiguredFeatureBootstrap.createKey("pointed_redstone_nether");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_POINTED_REDSTONE_NETHER = RUConfiguredFeatureBootstrap.createKey("large_pointed_redstone_nether");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POINTED_REDSTONE_CLUSTER_NETHER = RUConfiguredFeatureBootstrap.createKey("pointed_redstone_cluster_nether");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        SimpleWeightedRandomList.Builder<BlockState> mycotoxicMushroomsBuilder = SimpleWeightedRandomList.builder();
        SimpleWeightedRandomList.Builder<BlockState> mycotoxicBoneMealBlocks = SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.MYCOTOXIC_GRASS.get().defaultBlockState(), 100).add(RUBlocks.YELLOW_BIOSHROOM.get().defaultBlockState(), 7);
        SimpleWeightedRandomList.Builder<BlockState> glisteringBoneMealBlocks = SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.GLISTERING_SPROUT.get().defaultBlockState(), 140).add(RUBlocks.GLISTERING_BLOOM.get().defaultBlockState(), 30).add(RUBlocks.GLISTERING_BLOOM.get().defaultBlockState(), 10);
        SimpleWeightedRandomList.Builder<BlockState> cobaltBoneMealBlocks = SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.COBALT_ROOTS.get().defaultBlockState(), 100).add(RUBlocks.COBALT_EARLIGHT.get().defaultBlockState(), 2);
        SimpleWeightedRandomList.Builder<BlockState> brimsproutBoneMealBlocks = SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.BRIMSPROUT.get().defaultBlockState(), 140).add(RUBlocks.DORCEL.get().defaultBlockState(), 1);
        for(int i = 1; i <= 4; ++i) {
            for(Direction direction : Direction.Plane.HORIZONTAL) {
                mycotoxicMushroomsBuilder.add(RUBlocks.MYCOTOXIC_MUSHROOMS.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, i).setValue(GroundCoverBlock.FACING, direction), 1);
            }
        }
        WeightedStateProvider mycotoxicWeights = new WeightedStateProvider(mycotoxicBoneMealBlocks);
        WeightedStateProvider glisteringWeights = new WeightedStateProvider(glisteringBoneMealBlocks);
        WeightedStateProvider cobaltWeights = new WeightedStateProvider(cobaltBoneMealBlocks);
        WeightedStateProvider brimsproutWeights = new WeightedStateProvider(brimsproutBoneMealBlocks);

        register(context, SMALL_YELLOW_BIOSHROOM, RUFeatureTypes.SMALL_YELLOW_BIOSHROOM.get(), FeatureConfiguration.NONE);
        register(context, PATCH_MYCOTOXIC_MUSHROOMS, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(mycotoxicMushroomsBuilder)))));
        register(context, PATCH_MYCOTOXIC_GRASS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RUBlocks.MYCOTOXIC_GRASS.get().defaultBlockState()), 32));
        register(context, PATCH_MYCOTOXIC_DAISY, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RUBlocks.MYCOTOXIC_DAISY.get().defaultBlockState()), 16));

        register(context, PATCH_BRIMSPROUT, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RUBlocks.BRIMSPROUT.get().defaultBlockState()), 32));
        register(context, PATCH_BRIM_FLAMES, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(Blocks.FIRE.defaultBlockState()), 12));
        register(context, DORCEL, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.DORCEL.get())));
        register(context, BRIMWOOD_SHRUB, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.BRIMWOOD_NATURAL_SET.getShrub())));

        register(context, NETHER_ROCK, RUFeatureTypes.NETHER_ROCK.get(), FeatureConfiguration.NONE);
        register(context, PATCH_GLISTERING_IVY, RUFeatureTypes.GLISTERING_IVY.get(), FeatureConfiguration.NONE);
        register(context, PATCH_GLISTERING_SPROUT, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RUBlocks.GLISTERING_SPROUT.get().defaultBlockState()), 32));
        register(context, PATCH_GLISTERING_FERN, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.GLISTERING_FERN.get().defaultBlockState())));
        register(context, PATCH_GLISTERING_BLOOM, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.GLISTERING_BLOOM.get().defaultBlockState())));
        register(context, PATCH_GLISTER_SPIRE, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RUBlocks.GLISTER_SPIRE.get().defaultBlockState()), 16));
        register(context, PATCH_GLISTER_BULB, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.GLISTER_BULB.get().defaultBlockState())));

        register(context, PATCH_HANGING_EARLIGHT, RUFeatureTypes.HANGING_EARLIGHT.get(), FeatureConfiguration.NONE);
        register(context, PATCH_BLACKSTONE_CLUSTER, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RUBlocks.BLACKSTONE_CLUSTER.get().defaultBlockState()), 16));
        register(context, PATCH_COBALT_EARLIGHT, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RUBlocks.COBALT_EARLIGHT.get().defaultBlockState()), 6));
        register(context, TALL_COBALT_EARLIGHT, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.TALL_COBALT_EARLIGHT.get().defaultBlockState())));
        register(context, PATCH_COBALT_ROOTS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RUBlocks.COBALT_ROOTS.get().defaultBlockState()), 32));
        register(context, OBSIDIAN_SPIRE, RUFeatureTypes.OBSIDIAN_SPIRE.get(), FeatureConfiguration.NONE);

        register(context, POINTED_REDSTONE_NETHER, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(PlacementUtils.inlinePlaced(RUFeatureTypes.POINTED_REDSTONE.get(), new PointedRedstoneConfiguration(0.5F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1))), PlacementUtils.inlinePlaced(RUFeatureTypes.POINTED_REDSTONE.get(), new PointedRedstoneConfiguration(0.5F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1))))));
        register(context, LARGE_POINTED_REDSTONE_NETHER, RUFeatureTypes.LARGE_POINTED_REDSTONE.get(), new LargePointedRedstoneConfiguration(30, UniformInt.of(1, 6), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F));
        register(context, POINTED_REDSTONE_CLUSTER_NETHER, RUFeatureTypes.POINTED_REDSTONE_CLUSTER.get(), new PointedRedstoneClusterConfiguration(12, UniformInt.of(3, 6), UniformInt.of(2, 8), 1, 3, UniformInt.of(2, 4), UniformFloat.of(0.3F, 0.7F), ClampedNormalFloat.of(0.0F, 0.0F, 0.0F, 0.0F), 0.1F, 3, 8));

        //BONEMEALS

        register(context, RUConfiguredFeatures.BONEMEAL_MYCOTOXIC_NYLIUM, Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(mycotoxicWeights, 3, 1));
        register(context, RUConfiguredFeatures.BONEMEAL_GLISTERING_NYLIUM, Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(glisteringWeights, 3, 1));
        register(context, RUConfiguredFeatures.BONEMEAL_COBALT_NYLIUM, Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(cobaltWeights, 3, 1));
        register(context, RUConfiguredFeatures.BONEMEAL_BRIMSPROUT_NYLIUM, Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(brimsproutWeights, 3, 1));
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
