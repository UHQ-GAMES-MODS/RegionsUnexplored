package net.regions_unexplored.data.worldgen.features;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.level.feature.configuration.HyacinthStockConfiguration;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;
import net.regions_unexplored.world.level.feature.configuration.SeaRockConfiguration;

import java.util.function.Supplier;

public class RuAquaticFeatures {
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> FEN_CATTAIL = () -> ConfiguredFeatureRegistry.createKey("fen_cattail");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> WATER_CATTAIL = () -> ConfiguredFeatureRegistry.createKey("water_cattail");

    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> TALL_HYACINTH_STOCK = () -> ConfiguredFeatureRegistry.createKey("tall_hyacinth_stock");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> HYACINTH_PLANTS = () -> ConfiguredFeatureRegistry.createKey("hyacinth_plants");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> HYACINTH_FLOWERS = () -> ConfiguredFeatureRegistry.createKey("hyacinth_flowers");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> HYACINTH_ROCKS = () -> ConfiguredFeatureRegistry.createKey("hyacinth_rocks");

    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> MOSSY_SEA_ROCKS = () -> ConfiguredFeatureRegistry.createKey("mossy_sea_rocks");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> BLUE_MAGNOLIA_FLOWERS_AQUATIC = () -> ConfiguredFeatureRegistry.createKey("red_magnolia_flowers_aquatic");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> PINK_MAGNOLIA_FLOWERS_AQUATIC = () -> ConfiguredFeatureRegistry.createKey("pink_magnolia_flowers_aquatic");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> WHITE_MAGNOLIA_FLOWERS_AQUATIC = () -> ConfiguredFeatureRegistry.createKey("white_magnolia_flowers_aquatic");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> JUNGLE_TREE_AQUATIC = () -> ConfiguredFeatureRegistry.createKey("jungle_tree_aquatic");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> PALM_TREE_AQUATIC = () -> ConfiguredFeatureRegistry.createKey("palm_tree_aquatic");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> ELEPHANT_EAR_AQUATIC = () -> ConfiguredFeatureRegistry.createKey("elephant_ear_aquatic");
    
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, FEN_CATTAIL.get(), FeatureRegistry.FEN_CATTAIL, FeatureConfiguration.NONE);
        register(context, WATER_CATTAIL.get(), FeatureRegistry.WATER_CATTAIL, FeatureConfiguration.NONE);
        
        register(context, TALL_HYACINTH_STOCK.get(), FeatureRegistry.TALL_HYACINTH_STOCK, new HyacinthStockConfiguration(BlockStateProvider.simple(RuBlocks.TALL_HYACINTH_STOCK.get().defaultBlockState()), 1, 14));
        register(context, HYACINTH_PLANTS.get(), FeatureRegistry.HYACINTH_PLANTS, new ProbabilityFeatureConfiguration(0.1F));
        register(context, HYACINTH_FLOWERS.get(), Feature.MULTIFACE_GROWTH, new MultifaceGrowthConfiguration((MultifaceBlock) RuBlocks.HYACINTH_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS)));
        register(context, HYACINTH_ROCKS.get(), FeatureRegistry.OCEAN_ROCK, new SeaRockConfiguration(Blocks.STONE.defaultBlockState(), RuBlocks.MOSSY_STONE.get().defaultBlockState()));
        //ROCKY_REEF
        register(context, MOSSY_SEA_ROCKS.get(), FeatureRegistry.ROCK_PILLAR, FeatureConfiguration.NONE);
        register(context, BLUE_MAGNOLIA_FLOWERS_AQUATIC.get(), FeatureRegistry.AIR_MULTIFACE_GROWTH, new MultifaceGrowthConfiguration((MultifaceBlock) RuBlocks.BLUE_MAGNOLIA_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, RuBlocks.STONE_GRASS_BLOCK.get())));
        register(context, PINK_MAGNOLIA_FLOWERS_AQUATIC.get(), FeatureRegistry.AIR_MULTIFACE_GROWTH, new MultifaceGrowthConfiguration((MultifaceBlock) RuBlocks.PINK_MAGNOLIA_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, RuBlocks.STONE_GRASS_BLOCK.get())));
        register(context, WHITE_MAGNOLIA_FLOWERS_AQUATIC.get(), FeatureRegistry.AIR_MULTIFACE_GROWTH, new MultifaceGrowthConfiguration((MultifaceBlock) RuBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, RuBlocks.STONE_GRASS_BLOCK.get())));
        register(context, JUNGLE_TREE_AQUATIC.get(), FeatureRegistry.SAKURA_TREE, new RuTreeConfiguration(BlockStateProvider.simple(Blocks.JUNGLE_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.JUNGLE_LEAVES.defaultBlockState()), BlockStateProvider.simple(RuBlocks.JUNGLE_BRANCH.get().defaultBlockState()), 1, 4));

        register(context, PALM_TREE_AQUATIC.get(), FeatureRegistry.PALM_TREE, new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.PALM_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PALM_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PALM_BEARD.get().defaultBlockState()), 8, 4));
        register(context, ELEPHANT_EAR_AQUATIC.get(), Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.ELEPHANT_EAR.get().defaultBlockState()), 32));
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
