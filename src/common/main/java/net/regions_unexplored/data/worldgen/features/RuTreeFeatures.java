package net.regions_unexplored.data.worldgen.features;

import com.google.common.collect.ImmutableList;
import dev.worldgen.lithostitched.util.weighted.WeightedList;
import dev.worldgen.lithostitched.worldgen.feature.WeightedSelectorFeature;
import dev.worldgen.lithostitched.worldgen.feature.config.WeightedSelectorConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.registry.RUFeatureTypes;
import net.regions_unexplored.world.features.foliageplacers.SakuraFoliagePlacer;
import net.regions_unexplored.world.features.foliageplacers.WillowFoliagePlacer;
import net.regions_unexplored.world.features.treedecorators.PlaceOnGroundDecorator;
import net.regions_unexplored.world.features.treedecorators.WillowTrunkDecorator;
import net.regions_unexplored.world.level.block.leaves.AppleLeavesBlock;
import net.regions_unexplored.world.level.block.wood.BambooLogBlock;
import net.regions_unexplored.world.level.feature.configuration.GiantBioshroomConfiguration;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.List;
import java.util.OptionalInt;

public class RuTreeFeatures {
    //-----------------------KEYS-----------------------//
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_BLUE_BIOSHROOM = key("giant_blue_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_GREEN_BIOSHROOM = key("giant_green_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_PINK_BIOSHROOM = key("giant_pink_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_YELLOW_BIOSHROOM = key("giant_yellow_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_RED_MUSHROOM = key("giant_red_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_BROWN_MUSHROOM = key("giant_brown_mushroom");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BRIM_WILLOW = key("brim_willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_BRIM_WILLOW = key("tall_brim_willow");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ACACIA = key("acacia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACACIA_SHRUB = key("acacia_shrub");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ALPHA_OAK = key("alpha_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHEN = key("ashen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHEN_PINE = key("ashen_pine");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BAMBOO = key("bamboo");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_BAOBAB = key("mega_baobab");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ULTRA_BAOBAB = key("ultra_baobab");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_OAK = key("flowering_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_FLOWERING_OAK = key("big_flowering_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_OAK = key("apple_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_APPLE_OAK = key("big_apple_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD = key("blackwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_BLACKWOOD = key("big_blackwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_BLACKWOOD = key("giant_blackwood");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_ASPEN = key("birch_aspen");

    public static final ResourceKey<ConfiguredFeature<?, ?>> COBALT = key("cobalt");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_DARK_OAK = key("tall_dark_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGNOLIA = key("magnolia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_MAGNOLIA = key("blue_magnolia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_MAGNOLIA = key("pink_magnolia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_MAGNOLIA = key("white_magnolia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_MAGNOLIA = key("big_magnolia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_BLUE_MAGNOLIA = key("big_blue_magnolia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_PINK_MAGNOLIA = key("big_pink_magnolia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_WHITE_MAGNOLIA = key("big_white_magnolia");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS = key("cypress");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_CYPRESS = key("giant_cypress");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY = key("cherry");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_BOG = key("dead_bog");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD = key("dead");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_DEAD = key("big_dead");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PINE = key("dead_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PINE_TALL = key("dead_pine_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_STRIPPED_PINE = key("dead_stripped_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_STRIPPED_PINE_TALL = key("dead_stripped_pine_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_STRIPPED_PINE_MOUNTAIN = key("dead_stripped_pine_mountain");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_EUCALYPTUS = key("small_eucalyptus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EUCALYPTUS = key("eucalyptus");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_JOSHUA = key("large_joshua");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEDIUM_JOSHUA = key("medium_joshua");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JOSHUA_SHRUB = key("joshua_shrub");

    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE = key("jungle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_JUNGLE = key("big_jungle");

    public static final ResourceKey<ConfiguredFeature<?, ?>> KAPOK = key("kapok");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH = key("larch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_LARCH = key("big_larch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_LARCH = key("larch_golden");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_GOLDEN_LARCH = key("big_golden_larch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE = key("maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_MAPLE = key("big_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE = key("red_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_RED_MAPLE = key("big_red_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MAPLE = key("orange_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_ORANGE_MAPLE = key("big_orange_maple");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAUVE_OAK_BEE = key("mauve_oak_bee");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAUVE_OAK = key("mauve_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_MAUVE_OAK = key("big_mauve_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_WITH_BRANCH = key("oak_with_branch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_WITH_FLOWERS = key("oak_with_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK = key("oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TALL = key("oak_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_OAK = key("big_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_SHRUB = key("oak_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_BUSH = key("oak_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_BUSH_WITH_FLOWERS = key("oak_bush_with_flowers");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM = key("palm");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_PALM = key("tall_palm");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_SHRUB = key("palm_shrub");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE = key("pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TALL = key("pine_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRIPPED_PINE = key("stripped_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRIPPED_PINE_TALL = key("stripped_pine_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRIPPED_PINE_MOUNTAIN = key("stripped_pine_mountain");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_SHRUB = key("pine_shrub");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_PINE = key("lush_pine");
    //DONE
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAGUARO_CACTUS = key("saguaro_cactus");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ICE_SPIRE = key("ice_spire");
    //DONE
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_BIRCH = key("silver_birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_BIRCH_TALL = key("silver_birch_tall");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_BIRCH = key("enchanted_birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENCHANTED_BIRCH_TALL = key("enchanted_birch_tall");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TALL = key("spruce_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_SHRUB = key("spruce_shrub");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_OAK = key("small_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_SOCOTRA = key("large_socotra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_SOCOTRA = key("small_socotra");
    //DONE
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD = key("redwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_REDWOOD = key("giant_redwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ULTRA_REDWOOD = key("ultra_redwood");

    //DONE
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW = key("willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_WILLOW = key("big_willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_VINES = key("willow_vines");

    public static final ResourceKey<ConfiguredFeature<?,?>> GROUP_OLD_GROWTH_BAYOU = group("old_growth_bayou");
    public static final ResourceKey<ConfiguredFeature<?,?>> GROUP_AUTUMNAL_MAPLE_FOREST = group("autumnal_maple");
    public static final ResourceKey<ConfiguredFeature<?,?>> GROUP_PUMPKIN_FIELDS = group("pumpkin_fields");

    private static ResourceKey<ConfiguredFeature<?,?>> group(String name) {
        return key("group/" + name);
    }

    private static ResourceKey<ConfiguredFeature<?,?>> key(String name) {
        return RegionsUnexplored.key(Registries.CONFIGURED_FEATURE, "tree/" + name);
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, GIANT_BLUE_BIOSHROOM, RUFeatureTypes.GIANT_BLUE_BIOSHROOM.get(), new GiantBioshroomConfiguration(BlockStateProvider.simple(RUBlocks.BLUE_BIOSHROOM_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.BLUE_BIOSHROOM_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(RUBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get().defaultBlockState()), 7, 7));
        register(context, GIANT_GREEN_BIOSHROOM, RUFeatureTypes.GIANT_GREEN_BIOSHROOM.get(), new GiantBioshroomConfiguration(BlockStateProvider.simple(RUBlocks.GREEN_BIOSHROOM_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.GREEN_BIOSHROOM_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(RUBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get().defaultBlockState()), 8, 5));
        register(context, GIANT_PINK_BIOSHROOM, RUFeatureTypes.GIANT_PINK_BIOSHROOM.get(), new GiantBioshroomConfiguration(BlockStateProvider.simple(RUBlocks.PINK_BIOSHROOM_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINK_BIOSHROOM_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(RUBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get().defaultBlockState()), 7, 8));
        register(context, GIANT_YELLOW_BIOSHROOM, RUFeatureTypes.GIANT_YELLOW_BIOSHROOM.get(), new GiantBioshroomConfiguration(BlockStateProvider.simple(RUBlocks.YELLOW_BIOSHROOM_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(RUBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState()), 5, 4));
        register(context, GIANT_BROWN_MUSHROOM, Feature.HUGE_BROWN_MUSHROOM, new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(Blocks.BROWN_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(true)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), 3));
        register(context, GIANT_RED_MUSHROOM, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.valueOf(false)).setValue(HugeMushroomBlock.DOWN, Boolean.valueOf(false))), 2));

        register(context, ASHEN , RUFeatureTypes.ASHEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.ASHEN_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.ASHEN_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.DEAD_NATURAL_SET.getBranch().defaultBlockState()), 12, 5));
        register(context, ASHEN_PINE , RUFeatureTypes.ASHEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.ASHEN_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.DEAD_NATURAL_SET.getBranch().defaultBlockState()), 12, 7));

        register(context, BRIM_WILLOW , RUFeatureTypes.BRIM_WILLOW.get(), FeatureConfiguration.NONE);
        register(context, TALL_BRIM_WILLOW , RUFeatureTypes.TALL_BRIM_WILLOW.get(), FeatureConfiguration.NONE);

        register(context, ACACIA , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.ACACIA_LOG), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(Blocks.ACACIA_LEAVES), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
        register(context, ACACIA_SHRUB, RUFeatureTypes.TREE_SHRUB.get(), new RuTreeConfiguration(BlockStateProvider.simple(Blocks.ACACIA_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.ACACIA_LEAVES.defaultBlockState()), BlockStateProvider.simple(RUBlocks.ACACIA_NATURAL_SET.getBranch().defaultBlockState()), 1, 3));

        register(context, ALPHA_OAK , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.ALPHA_WOOD_SET.getLog().defaultBlockState()), new StraightTrunkPlacer(4, 2, 0),BlockStateProvider.simple(RUBlocks.ALPHA_NATURAL_SET.getLeaves().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, BAMBOO , RUFeatureTypes.BAMBOO_TREE.get(), new RuTreeConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.BAMBOO_LOG.get().defaultBlockState(), 1).add(RUBlocks.BAMBOO_LOG.get().defaultBlockState().setValue(BambooLogBlock.LEAVES, true), 2)), BlockStateProvider.simple(RUBlocks.BAMBOO_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.OAK_NATURAL_SET.getBranch().defaultBlockState()), 12, 8));

        register(context, FLOWERING_OAK , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new StraightTrunkPlacer(4, 3, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3).add(RUBlocks.FLOWERING_NATURAL_SET.getLeaves().defaultBlockState(), 1)),new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
        register(context, BIG_FLOWERING_OAK , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3).add(RUBlocks.FLOWERING_NATURAL_SET.getLeaves().defaultBlockState(), 1)),new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        register(context, APPLE_OAK , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new StraightTrunkPlacer(4, 2, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 18).add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves().defaultBlockState(), 1).add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(1)), 1).add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(2)), 2).add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(3)), 2).add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(4)), 2)),new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
        register(context, BIG_APPLE_OAK , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 14).add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves().defaultBlockState(), 1).add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(1)), 1).add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(2)), 2).add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(3)), 2).add(RUBlocks.APPLE_OAK_NATURAL_SET.getLeaves().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(4)), 2)),new FancyFoliagePlacer(ConstantInt.of(1), ConstantInt.of(2), 3), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        register(context, MEGA_BAOBAB , RUFeatureTypes.MEGA_BAOBAB_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.BAOBAB_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.BAOBAB_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.BAOBAB_NATURAL_SET.getBranch()), 5, 5));
        register(context, ULTRA_BAOBAB , RUFeatureTypes.ULTRA_BAOBAB_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.BAOBAB_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.BAOBAB_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.BAOBAB_NATURAL_SET.getBranch()), 12, 6));

        register(context, BLACKWOOD , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.BLACKWOOD_WOOD_SET.getLog().defaultBlockState()), new StraightTrunkPlacer(12, 4, 2), BlockStateProvider.simple(RUBlocks.BLACKWOOD_NATURAL_SET.getLeaves().defaultBlockState()), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(2, 2), UniformInt.of(5, 5)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
        register(context, BIG_BLACKWOOD , RUFeatureTypes.BLACKWOOD_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.BLACKWOOD_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.BLACKWOOD_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.BLACKWOOD_NATURAL_SET.getBranch().defaultBlockState()), 19, 5));

        register(context, BIRCH_ASPEN, RUFeatureTypes.ASPEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(Blocks.BIRCH_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.BIRCH_LEAVES.defaultBlockState()), BlockStateProvider.simple(RUBlocks.BIRCH_NATURAL_SET.getBranch().defaultBlockState()), 4, 3));

        register(context, COBALT , RUFeatureTypes.COBALT_TREE.get(), FeatureConfiguration.NONE);

        register(context, TALL_DARK_OAK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.DARK_OAK_LOG), new DarkOakTrunkPlacer(8, 4, 1), BlockStateProvider.simple(Blocks.DARK_OAK_LEAVES), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().build());

        register(context, MAGNOLIA , RUFeatureTypes.SAKURA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.MAGNOLIA_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.MAGNOLIA_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.MAGNOLIA_NATURAL_SET.getBranch().defaultBlockState()), 1, 4));
        register(context, BLUE_MAGNOLIA , RUFeatureTypes.SAKURA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.MAGNOLIA_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.MAGNOLIA_NATURAL_SET.getBranch().defaultBlockState()), 1, 4));
        register(context, PINK_MAGNOLIA , RUFeatureTypes.SAKURA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.MAGNOLIA_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.MAGNOLIA_NATURAL_SET.getBranch().defaultBlockState()), 1, 4));
        register(context, WHITE_MAGNOLIA , RUFeatureTypes.SAKURA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.MAGNOLIA_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.MAGNOLIA_NATURAL_SET.getBranch().defaultBlockState()), 1, 5));
        register(context, BIG_MAGNOLIA , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.MAGNOLIA_WOOD_SET.getLog().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RUBlocks.MAGNOLIA_NATURAL_SET.getLeaves().defaultBlockState()),new SakuraFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, BIG_BLUE_MAGNOLIA , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.MAGNOLIA_WOOD_SET.getLog().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getLeaves().defaultBlockState()),new SakuraFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, BIG_PINK_MAGNOLIA , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.MAGNOLIA_WOOD_SET.getLog().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getLeaves().defaultBlockState()),new SakuraFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, BIG_WHITE_MAGNOLIA , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.MAGNOLIA_WOOD_SET.getLog().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getLeaves().defaultBlockState()),new SakuraFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        var cypress = register(context, CYPRESS , RUFeatureTypes.CYPRESS_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.CYPRESS_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.CYPRESS_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.CYPRESS_NATURAL_SET.getBranch().defaultBlockState()), 17, 4));
        var giantCypress = register(context, GIANT_CYPRESS , RUFeatureTypes.GIANT_CYPRESS_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.CYPRESS_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.CYPRESS_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.CYPRESS_NATURAL_SET.getBranch().defaultBlockState()), 25, 5));
        register(context, GROUP_OLD_GROWTH_BAYOU, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
            List.of(new WeightedPlacedFeature(direct(cypress), 0.4f)),
            direct(giantCypress)
        ));

        register(context, CHERRY , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.CHERRY_LOG), new CherryTrunkPlacer(7, 1, 0, new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()), UniformInt.of(2, 4), UniformInt.of(-4, -3), UniformInt.of(-1, 0)), BlockStateProvider.simple(Blocks.CHERRY_LEAVES), new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context, DEAD_BOG , RUFeatureTypes.DEAD_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.DEAD_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.DEAD_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.DEAD_NATURAL_SET.getBranch().defaultBlockState()), 6, 2));

        register(context, DEAD , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.DEAD_WOOD_SET.getLog().defaultBlockState()), new StraightTrunkPlacer(6, 2, 0),BlockStateProvider.simple(RUBlocks.DEAD_NATURAL_SET.getLeaves().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
        register(context, BIG_DEAD , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.DEAD_WOOD_SET.getLog().defaultBlockState()),new FancyTrunkPlacer(12, 3, 0),BlockStateProvider.simple(RUBlocks.DEAD_NATURAL_SET.getLeaves().defaultBlockState()),new FancyFoliagePlacer(ConstantInt.of(1), ConstantInt.of(2), 3), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        register(context, DEAD_PINE , RUFeatureTypes.PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.DEAD_PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 10, 4));
        register(context, DEAD_PINE_TALL, RUFeatureTypes.PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.DEAD_PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 14, 5));
        register(context, DEAD_STRIPPED_PINE , RUFeatureTypes.STRIPPED_PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.DEAD_PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 10, 4));
        register(context, DEAD_STRIPPED_PINE_TALL, RUFeatureTypes.STRIPPED_PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.DEAD_PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 14, 5));
        register(context, DEAD_STRIPPED_PINE_MOUNTAIN, RUFeatureTypes.STRIPPED_PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.DEAD_PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 15, 7));

        register(context, SMALL_EUCALYPTUS , RUFeatureTypes.SMALL_EUCALYPTUS_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.EUCALYPTUS_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.EUCALYPTUS_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.EUCALYPTUS_NATURAL_SET.getBranch().defaultBlockState()), 13, 8));
        register(context, EUCALYPTUS , RUFeatureTypes.EUCALYPTUS_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.EUCALYPTUS_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.EUCALYPTUS_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.EUCALYPTUS_NATURAL_SET.getBranch().defaultBlockState()), 14, 8));

        register(context, MEDIUM_JOSHUA , RUFeatureTypes.MEDIUM_JOSHUA_TREE.get(), FeatureConfiguration.NONE);
        register(context, LARGE_JOSHUA , RUFeatureTypes.LARGE_JOSHUA_TREE.get(), FeatureConfiguration.NONE);
        register(context, JOSHUA_SHRUB, RUFeatureTypes.SMALL_JOSHUA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.JOSHUA_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.JOSHUA_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.JOSHUA_NATURAL_SET.getBranch().defaultBlockState()), 1, 1));

        register(context, JUNGLE , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.JUNGLE_LOG.defaultBlockState()), new StraightTrunkPlacer(6, 5, 0), BlockStateProvider.simple(Blocks.JUNGLE_LEAVES.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(ImmutableList.of(new LeaveVineDecorator(0.25f))).build());
        register(context, BIG_JUNGLE , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.JUNGLE_LOG.defaultBlockState()), new FancyTrunkPlacer(9, 11, 0), BlockStateProvider.simple(Blocks.JUNGLE_LEAVES.defaultBlockState()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().decorators(ImmutableList.of(new LeaveVineDecorator(0.25f))).build());

        register(context, KAPOK , RUFeatureTypes.KAPOK_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.KAPOK_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.KAPOK_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.KAPOK_NATURAL_SET.getBranch().defaultBlockState()), 20, 7));

        register(context, LARCH , RUFeatureTypes.LARCH_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.LARCH_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.LARCH_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.LARCH_NATURAL_SET.getBranch().defaultBlockState()), 18, 5));
        register(context, BIG_LARCH , RUFeatureTypes.LARCH_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.LARCH_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.LARCH_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.LARCH_NATURAL_SET.getBranch().defaultBlockState()), 23, 7));

        register(context, GOLDEN_LARCH , RUFeatureTypes.LARCH_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.LARCH_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.LARCH_NATURAL_SET.getBranch().defaultBlockState()), 18, 5));
        register(context, BIG_GOLDEN_LARCH , RUFeatureTypes.LARCH_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.LARCH_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.LARCH_NATURAL_SET.getBranch().defaultBlockState()), 23, 7));

        var maple = register(context, MAPLE , RUFeatureTypes.MAPLE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.MAPLE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.MAPLE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.MAPLE_NATURAL_SET.getBranch().defaultBlockState()), List.of(PlaceOnGroundDecorator.leafLitter(RUBlocks.MAPLE_LEAF_PILE.get(), 96)), 6, 4));
        var bigMaple = register(context, BIG_MAPLE , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.MAPLE_WOOD_SET.getLog().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RUBlocks.MAPLE_NATURAL_SET.getLeaves().defaultBlockState()),new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).decorators(List.of(PlaceOnGroundDecorator.leafLitter(RUBlocks.MAPLE_LEAF_PILE.get(), 144))).ignoreVines().build());
        var redMaple = register(context, RED_MAPLE , RUFeatureTypes.MAPLE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.MAPLE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.RED_MAPLE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.MAPLE_NATURAL_SET.getBranch().defaultBlockState()), List.of(PlaceOnGroundDecorator.leafLitter(RUBlocks.RED_MAPLE_LEAF_PILE.get(), 96)), 6, 4));
        var bigRedMaple = register(context, BIG_RED_MAPLE , Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.MAPLE_WOOD_SET.getLog().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RUBlocks.RED_MAPLE_NATURAL_SET.getLeaves().defaultBlockState()),new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).decorators(List.of(PlaceOnGroundDecorator.leafLitter(RUBlocks.RED_MAPLE_LEAF_PILE.get(), 144))).ignoreVines().build());
        var orangeMaple = register(context, ORANGE_MAPLE , RUFeatureTypes.MAPLE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.MAPLE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.MAPLE_NATURAL_SET.getBranch().defaultBlockState()), List.of(PlaceOnGroundDecorator.leafLitter(RUBlocks.ORANGE_MAPLE_LEAF_PILE.get(), 96)), 6, 4));
        var bigOrangeMaple = register(context, BIG_ORANGE_MAPLE , Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.MAPLE_WOOD_SET.getLog().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getLeaves().defaultBlockState()),new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).decorators(List.of(PlaceOnGroundDecorator.leafLitter(RUBlocks.ORANGE_MAPLE_LEAF_PILE.get(), 144))).ignoreVines().build());

        var silverBirch = register(context, SILVER_BIRCH , RUFeatureTypes.ASPEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_NATURAL_SET.getBranch().defaultBlockState()), List.of(PlaceOnGroundDecorator.leafLitter(RUBlocks.SILVER_BIRCH_LEAF_PILE.get(), 96)), 4, 4));
        var silverBirchTall = register(context, SILVER_BIRCH_TALL, RUFeatureTypes.ASPEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_NATURAL_SET.getBranch().defaultBlockState()), List.of(PlaceOnGroundDecorator.leafLitter(RUBlocks.SILVER_BIRCH_LEAF_PILE.get(), 96)), 5, 5));

        register(context, GROUP_AUTUMNAL_MAPLE_FOREST, WeightedSelectorFeature.FEATURE, new WeightedSelectorConfig(WeightedList.<Holder<PlacedFeature>>builder()
            .add(direct(maple), 2)
            .add(direct(redMaple), 2)
            .add(direct(orangeMaple), 2)
            .add(direct(silverBirch), 2)
            .add(direct(bigRedMaple))
            .add(direct(bigOrangeMaple))
        .build()));
        register(context, GROUP_PUMPKIN_FIELDS, WeightedSelectorFeature.FEATURE, new WeightedSelectorConfig(WeightedList.<Holder<PlacedFeature>>builder()
            .add(direct(bigMaple), 3)
            .add(direct(bigRedMaple), 3)
            .add(direct(bigOrangeMaple), 3)
            .add(direct(maple), 2)
            .add(direct(redMaple), 2)
            .add(direct(orangeMaple), 2)
            .add(direct(silverBirch), 2)
        .build()));

        register(context, MAUVE_OAK_BEE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.MAUVE_WOOD_SET.getLog().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0),BlockStateProvider.simple(RUBlocks.MAUVE_NATURAL_SET.getLeaves().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new BeehiveDecorator(1f))).ignoreVines().build());
        register(context, MAUVE_OAK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.MAUVE_WOOD_SET.getLog().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0),BlockStateProvider.simple(RUBlocks.MAUVE_NATURAL_SET.getLeaves().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new BeehiveDecorator(0.25f))).ignoreVines().build());
        register(context, BIG_MAUVE_OAK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.MAUVE_WOOD_SET.getLog().defaultBlockState()), new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RUBlocks.MAUVE_NATURAL_SET.getLeaves().defaultBlockState()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        register(context, OAK_WITH_FLOWERS, RUFeatureTypes.ASPEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3).add(RUBlocks.FLOWERING_NATURAL_SET.getLeaves().defaultBlockState(), 1)), BlockStateProvider.simple(RUBlocks.OAK_NATURAL_SET.getBranch().defaultBlockState()), 5, 5));

        register(context, OAK_WITH_BRANCH, RUFeatureTypes.MAPLE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()), BlockStateProvider.simple(RUBlocks.OAK_NATURAL_SET.getBranch().defaultBlockState()), 6, 4));
        register(context, OAK , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), new StraightTrunkPlacer(5, 3, 0),BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new BeehiveDecorator(0.005f))).ignoreVines().build());
        register(context, OAK_TALL, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), new StraightTrunkPlacer(6, 4, 0),BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new BeehiveDecorator(0.005f))).ignoreVines().build());
        register(context, BIG_OAK , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), new FancyTrunkPlacer(7, 10, 0),BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, OAK_SHRUB, RUFeatureTypes.TREE_SHRUB.get(), new RuTreeConfiguration(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()), BlockStateProvider.simple(RUBlocks.OAK_NATURAL_SET.getBranch().defaultBlockState()), 1, 0));
        register(context, OAK_BUSH, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2), new TwoLayersFeatureSize(0, 0, 0)).build());
        register(context, OAK_BUSH_WITH_FLOWERS, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), new StraightTrunkPlacer(1, 0, 0), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3).add(RUBlocks.FLOWERING_NATURAL_SET.getLeaves().defaultBlockState(), 1)), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2), new TwoLayersFeatureSize(0, 0, 0)).build());

        register(context, PALM , RUFeatureTypes.PALM_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PALM_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PALM_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PALM_NATURAL_SET.getBranch().defaultBlockState()), 8, 5));
        register(context, TALL_PALM , RUFeatureTypes.PALM_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PALM_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PALM_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PALM_NATURAL_SET.getBranch().defaultBlockState()), 12, 5));
        register(context, PALM_SHRUB, RUFeatureTypes.PALM_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PALM_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PALM_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PALM_NATURAL_SET.getBranch().defaultBlockState()), 2, 1));

        register(context, PINE , RUFeatureTypes.PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 10, 4));
        register(context, PINE_TALL, RUFeatureTypes.PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 14, 5));
        register(context, STRIPPED_PINE , RUFeatureTypes.STRIPPED_PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 10, 4));
        register(context, STRIPPED_PINE_TALL, RUFeatureTypes.STRIPPED_PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 14, 5));
        register(context, STRIPPED_PINE_MOUNTAIN, RUFeatureTypes.STRIPPED_PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 15, 7));
        register(context, PINE_SHRUB, RUFeatureTypes.TREE_SHRUB.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 1, 2));

        register(context, LUSH_PINE , RUFeatureTypes.LUSH_PINE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.PINE_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getBranch().defaultBlockState()), 19, 4));

        register(context, SAGUARO_CACTUS, RUFeatureTypes.SAGUARO_CACTUS.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.SAGUARO_CACTUS.get().defaultBlockState()), BlockStateProvider.simple(RUBlocks.SAGUARO_CACTUS_NATURAL_SET.getSapling().defaultBlockState()), BlockStateProvider.simple(RUBlocks.REDWOOD_NATURAL_SET.getBranch().defaultBlockState()), 7, 2));

        register(context, ICE_SPIRE, RUFeatureTypes.SPIRE.get(), new RuTreeConfiguration(BlockStateProvider.simple(Blocks.PACKED_ICE.defaultBlockState()), BlockStateProvider.simple(Blocks.ICE.defaultBlockState()), BlockStateProvider.simple(Blocks.BLUE_ICE), 14, 9));

        register(context, ENCHANTED_BIRCH , RUFeatureTypes.ASPEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_NATURAL_SET.getBranch().defaultBlockState()), List.of(PlaceOnGroundDecorator.leafLitter(RUBlocks.ENCHANTED_BIRCH_LEAF_PILE.get(), 96)), 4, 4));
        register(context, ENCHANTED_BIRCH_TALL, RUFeatureTypes.ASPEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_NATURAL_SET.getBranch().defaultBlockState()), List.of(PlaceOnGroundDecorator.leafLitter(RUBlocks.ENCHANTED_BIRCH_LEAF_PILE.get(), 96)), 5, 5));

        register(context, SPRUCE_TALL, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()), new StraightTrunkPlacer(13, 2, 2), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES.defaultBlockState()), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(2, 2), UniformInt.of(5, 5)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
        register(context, SPRUCE_SHRUB, RUFeatureTypes.TREE_SHRUB.get(), new RuTreeConfiguration(BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES.defaultBlockState()), BlockStateProvider.simple(RUBlocks.OAK_NATURAL_SET.getBranch().defaultBlockState()), 1, 0));

        register(context, SMALL_OAK , RUFeatureTypes.SMALL_OAK_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.SMALL_OAK_LOG.get().defaultBlockState()), BlockStateProvider.simple(RUBlocks.SMALL_OAK_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.OAK_NATURAL_SET.getBranch().defaultBlockState()), 5, 4));

        register(context, LARGE_SOCOTRA , RUFeatureTypes.LARGE_SOCOTRA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.SOCOTRA_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.SOCOTRA_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.SOCOTRA_NATURAL_SET.getBranch()), 8, 5));
        register(context, SMALL_SOCOTRA , RUFeatureTypes.SMALL_SOCOTRA_TREE.get(), FeatureConfiguration.NONE);

        register(context, REDWOOD , RUFeatureTypes.REDWOOD_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.REDWOOD_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.REDWOOD_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.REDWOOD_NATURAL_SET.getBranch()), 21, 9));
        register(context, GIANT_REDWOOD , RUFeatureTypes.SUPER_REDWOOD_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.REDWOOD_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.REDWOOD_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.REDWOOD_NATURAL_SET.getBranch()), 30, 14));
        register(context, ULTRA_REDWOOD , RUFeatureTypes.ULTRA_REDWOOD_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RUBlocks.REDWOOD_WOOD_SET.getLog().defaultBlockState()), BlockStateProvider.simple(RUBlocks.REDWOOD_NATURAL_SET.getLeaves().defaultBlockState()), BlockStateProvider.simple(RUBlocks.REDWOOD_NATURAL_SET.getBranch()), 45, 9));

        register(context, WILLOW , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.WILLOW_WOOD_SET.getLog().defaultBlockState()), new StraightTrunkPlacer(8, 2, 0),BlockStateProvider.simple(RUBlocks.WILLOW_NATURAL_SET.getLeaves().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(ImmutableList.of(WillowTrunkDecorator.of(0.5f))).build());
        register(context, BIG_WILLOW , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.WILLOW_WOOD_SET.getLog().defaultBlockState()), new FancyTrunkPlacer(9, 9, 0), BlockStateProvider.simple(RUBlocks.WILLOW_NATURAL_SET.getLeaves().defaultBlockState()), new WillowFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().decorators(ImmutableList.of(WillowTrunkDecorator.of(0.5f))).build());
        register(context, WILLOW_VINES, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RUBlocks.WILLOW_WOOD_SET.getLog().defaultBlockState()), new StraightTrunkPlacer(8, 2, 0),BlockStateProvider.simple(RUBlocks.WILLOW_NATURAL_SET.getLeaves().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(ImmutableList.of(new LeaveVineDecorator(0.25f), WillowTrunkDecorator.of(1))).build());


    }

    private static Holder<PlacedFeature> direct(Holder.Reference<ConfiguredFeature<?, ?>> feature) {
        return Holder.direct(new PlacedFeature(feature, List.of()));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder.Reference<ConfiguredFeature<?, ?>> register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        return context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
