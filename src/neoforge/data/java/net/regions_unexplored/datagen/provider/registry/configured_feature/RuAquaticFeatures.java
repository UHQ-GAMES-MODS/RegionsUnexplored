package net.regions_unexplored.datagen.provider.registry.configured_feature;

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
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.datagen.provider.registry.RUConfiguredFeatureBootstrap;
import net.regions_unexplored.registry.RUFeatureTypes;
import net.regions_unexplored.world.level.feature.configuration.HyacinthStockConfiguration;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;
import net.regions_unexplored.world.level.feature.configuration.SeaRockConfiguration;

import java.util.function.Supplier;

public class RuAquaticFeatures {
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> FEN_CATTAIL = () -> RUConfiguredFeatureBootstrap.createKey("fen_cattail");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> WATER_CATTAIL = () -> RUConfiguredFeatureBootstrap.createKey("water_cattail");

    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> TALL_HYACINTH_STOCK = () -> RUConfiguredFeatureBootstrap.createKey("tall_hyacinth_stock");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> HYACINTH_PLANTS = () -> RUConfiguredFeatureBootstrap.createKey("hyacinth_plants");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> HYACINTH_FLOWERS = () -> RUConfiguredFeatureBootstrap.createKey("hyacinth_flowers");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> HYACINTH_ROCKS = () -> RUConfiguredFeatureBootstrap.createKey("hyacinth_rocks");

    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> MOSSY_SEA_ROCKS = () -> RUConfiguredFeatureBootstrap.createKey("mossy_sea_rocks");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> BLUE_MAGNOLIA_FLOWERS_AQUATIC = () -> RUConfiguredFeatureBootstrap.createKey("red_magnolia_flowers_aquatic");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> PINK_MAGNOLIA_FLOWERS_AQUATIC = () -> RUConfiguredFeatureBootstrap.createKey("pink_magnolia_flowers_aquatic");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> WHITE_MAGNOLIA_FLOWERS_AQUATIC = () -> RUConfiguredFeatureBootstrap.createKey("white_magnolia_flowers_aquatic");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> JUNGLE_AQUATIC = () -> RUConfiguredFeatureBootstrap.createKey("jungle_tree_aquatic");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> PALM_AQUATIC = () -> RUConfiguredFeatureBootstrap.createKey("palm_tree_aquatic");
    public static final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> ELEPHANT_EAR_AQUATIC = () -> RUConfiguredFeatureBootstrap.createKey("elephant_ear_aquatic");
    
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, FEN_CATTAIL.get(), RUFeatureTypes.FEN_CATTAIL.get(), FeatureConfiguration.NONE);
        register(context, WATER_CATTAIL.get(), RUFeatureTypes.WATER_CATTAIL.get(), FeatureConfiguration.NONE);
        
        register(context, TALL_HYACINTH_STOCK.get(), RUFeatureTypes.TALL_HYACINTH_STOCK.get(), new HyacinthStockConfiguration(BlockStateProvider.simple(RUBlocks.TALL_HYACINTH_STOCK.get().defaultBlockState()), 1, 14));
        register(context, HYACINTH_PLANTS.get(), RUFeatureTypes.HYACINTH_PLANTS.get(), new ProbabilityFeatureConfiguration(0.1F));
        register(context, HYACINTH_FLOWERS.get(), Feature.MULTIFACE_GROWTH, new MultifaceGrowthConfiguration((MultifaceBlock) RUBlocks.HYACINTH_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS)));
        register(context, HYACINTH_ROCKS.get(), RUFeatureTypes.OCEAN_ROCK.get(), new SeaRockConfiguration(Blocks.STONE.defaultBlockState(), RUBlocks.MOSSY_STONE.get().defaultBlockState()));
        //ROCKY_REEF
        register(context, MOSSY_SEA_ROCKS.get(), RUFeatureTypes.ROCK_PILLAR.get(), FeatureConfiguration.NONE);
        register(context, BLUE_MAGNOLIA_FLOWERS_AQUATIC.get(), RUFeatureTypes.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock) RUBlocks.BLUE_MAGNOLIA_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, RUBlocks.STONE_GRASS_BLOCK.get())));
        register(context, PINK_MAGNOLIA_FLOWERS_AQUATIC.get(), RUFeatureTypes.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock) RUBlocks.PINK_MAGNOLIA_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, RUBlocks.STONE_GRASS_BLOCK.get())));
        register(context, WHITE_MAGNOLIA_FLOWERS_AQUATIC.get(), RUFeatureTypes.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock) RUBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, RUBlocks.STONE_GRASS_BLOCK.get())));
        register(context, JUNGLE_AQUATIC.get(), RUFeatureTypes.SAKURA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(Blocks.JUNGLE_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.JUNGLE_LEAVES.defaultBlockState()), BlockStateProvider.simple(RUBlocks.JUNGLE_NATURAL_SET.getBranch().defaultBlockState()), 1, 4));

        register(context, PALM_AQUATIC.get(), RUFeatureTypes.PALM_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PALM_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PALM_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PALM_NATURAL_SET.getBranch().defaultBlockState()), 8, 4));
        register(context, ELEPHANT_EAR_AQUATIC.get(), Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RUBlocks.ELEPHANT_EAR.get().defaultBlockState()), 32));
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
