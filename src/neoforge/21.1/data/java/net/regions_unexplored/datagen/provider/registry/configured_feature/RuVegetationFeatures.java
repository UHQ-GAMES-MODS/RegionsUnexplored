package net.regions_unexplored.datagen.provider.registry.configured_feature;

import com.google.common.collect.ImmutableList;
import dev.worldgen.lithostitched.api.worldgen.stateprovider.LithostitchedStateProviders;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.InclusiveRange;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.*;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.regions_unexplored.datagen.provider.registry.RUDatagenFeatureUtils;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.registry.RUFeatureTypes;
import net.regions_unexplored.registry.data.RUConfiguredFeatures;
import net.regions_unexplored.worldgen.treedecorator.BlackwoodBioshroomDecorator;
import net.regions_unexplored.world.level.block.plant.flower.GroundCoverBlock;
import net.regions_unexplored.world.level.block.plant.food.DuskmelonBlock;
import net.regions_unexplored.world.level.block.plant.food.SalmonBerryBushBlock;
import net.regions_unexplored.world.level.block.plant.grass.AshenGrassBlock;
import net.regions_unexplored.world.level.feature.configuration.ShrubConfiguration;

import java.util.List;

import static net.regions_unexplored.datagen.provider.registry.RUDatagenFeatureUtils.*;
import static net.regions_unexplored.registry.data.RUConfiguredFeatures.key;

public class RuVegetationFeatures {
    //-----------------------KEYS-----------------------//
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FROZEN_FLOWERS = key("patch_frozen_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PINK_FLOWERS = key("patch_pink_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_BIOSHROOMS = key("blackwood_bioshrooms");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_DECORATION = key("blackwood_decoration");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MEADOW_VEGETATION = key("patch_meadow_vegetation");
    //GRASS
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FERNS = key("patch_ferns");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GRASS = key("patch_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SNOW_GRASS = key("patch_snow_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_GRASS = key("patch_tall_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WINDSWEPT_GRASS = key("patch_windswept_grass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GRASS_SPROUTS = key("patch/grass_sprouts");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ASHEN_GRASS = key("patch/ashen_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SMOULDERING_ASHEN_GRASS = key("patch/smouldering_ashen_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ASH_VENTS = key("patch/ash_vents");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FERNS_DENSE = key("patch/ferns_dense");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_LUPINES = key("patch/lupines");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DAISIES = key("patch/daisies");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GRASS_SPARSE = key("patch/grass_sparse");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SANDY_GRASS_SPARSE = key("patch/sandy_grass_sparse");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DESERT_SHRUB_SPARSE = key("patch/desert_shrub_sparse");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLADED_GRASS = key("patch_bladed_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLACKWOOD_VEGETATION = key("patch_blackwood_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DECIDUOUS_VEGETATION = key("patch_deciduous_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FEN_VEGETATION = key("patch_fen_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SHRUBLAND_VEGETATION = key("patch_shrubland_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MOUNTAIN_VEGETATION = key("patch_mountain_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_STEPPE_VEGETATION = key("patch_steppe_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SOCOTRA_VEGETATION = key("patch_socotra_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_OUTBACK_VEGETATION = key("patch_outback_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SANDY_GRASS_VEGETATION = key("patch_sandy_grass_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BAYOU_VEGETATION = key("patch_bayou_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DIRT_VEGETATION = key("patch_dirt_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GRASS_VEGETATION = key("patch_grass_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_REDSTONE_BUD = key("patch_redstone_bud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PRISMOSS_SPROUT = key("patch_prismoss_sprout");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLADED_GRASS_SINGLE = key("bladed_grass_single");
    //FLOWERS
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASTER = key("aster");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TULIPS = key("patch_tulips");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CAVE_HYSSOP = key("patch_cave_hyssop");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SMALL_FLOWERS = key("patch_small_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_FLOWERS = key("patch_tall_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ALPHA_DANDELION = key("patch_alpha_dandelion");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ALPHA_ROSE = key("patch_alpha_rose");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WHITE_TRILLIUM = key("patch_white_trillium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_AZURE_DAISY = key("patch_azure_daisy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DAISY = key("patch_daisy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WARATAH = key("patch_waratah");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILTING_TRILLIUM = key("patch_wilting_trillium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PRAIRIE_FLOWERS = key("patch_prairie_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SHRUBLAND_FLOWERS = key("patch_shrubland_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILLOW_FLOWERS = key("patch_willow_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_POPPIES = key("patch_poppies");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TASSEL = key("tassel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_SNOWBELLE = key("white_snowbelle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORPSE_FLOWER = key("corpse_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DUSKTRAP = key("dusktrap");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DAY_LILY = key("day_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TSUBAKI = key("patch_tsubaki");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_HIBISCUS = key("patch_hibiscus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MALLOW = key("patch_mallow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_HYSSOP = key("patch_hyssop");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BARLEY = key("patch_barley");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEADOW_SAGE = key("meadow_sage");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BARREL_CACTUS = key("barrel_cactus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SANDY_GRASS = key("sandy_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_REDSTONE_BULB = key("patch_redstone_bulb");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ORANGE_CONEFLOWER = key("patch_orange_coneflower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PURPLE_CONEFLOWER = key("patch_purple_coneflower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MAGNOLIA_FLOWERS = key("patch_magnolia_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CLOVER = key("patch_clover");
    //MULTIFACE FLOWERS
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_MAGNOLIA_FLOWERS = key("pink_magnolia_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_MAGNOLIA_FLOWERS = key("white_magnolia_flowers");
    //FOOD_PLANTS
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SALMONBERRY_BUSH = key("patch_salmonberry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DUSKMELON = key("duskmelon");
    //BIOSHROOM
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLUE_BIOSHROOM = key("patch_blue_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GREEN_BIOSHROOM = key("patch_green_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PINK_BIOSHROOM = key("patch_pink_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_YELLOW_BIOSHROOM = key("patch_yellow_bioshroom");
    //OTHER
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAMBOO = key("bamboo");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_LILY = key("flowering_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_LILY = key("giant_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ELEPHANT_EAR = key("elephant_ear");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DROPLEAF = key("dropleaf");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DUCKWEED = key("duckweed");
    //SHRUBS
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHEN_SHRUB = key("ashen_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACACIA_SHRUB = key("acacia_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAOBAB_SHRUB = key("baobab_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_SHRUB = key("birch_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_SHRUB = key("blackwood_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_SHRUB = key("cherry_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGNOLIA_SHRUB = key("magnolia_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_MAGNOLIA_SHRUB = key("pink_magnolia_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_MAGNOLIA_SHRUB = key("white_magnolia_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_SHRUB = key("cypress_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_OAK_SHRUB = key("dark_oak_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SHRUB = key("dead_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PINE_SHRUB = key("dead_pine_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EUCALYPTUS_SHRUB = key("eucalyptus_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_SHRUB = key("flowering_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JOSHUA_SHRUB = key("joshua_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_SHRUB = key("jungle_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH_SHRUB = key("larch_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_LARCH_SHRUB = key("golden_larch_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGROVE_SHRUB = key("mangrove_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_SHRUB = key("maple_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_SHRUB = key("red_maple_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MAPLE_SHRUB = key("orange_maple_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAUVE_SHRUB = key("mauve_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_SHRUB = key("oak_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_SHRUB = key("palm_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_SHRUB = key("pine_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_SHRUB = key("redwood_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_BIRCH_SHRUB = key("silver_birch_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOCOTRA_SHRUB = key("socotra_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_SHRUB = key("spruce_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_SHRUB = key("willow_shrub");
    //mixes
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAOBAB_ACACIA_SHRUB_MIX = key("baobab_acacia_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AUTUMNAL_SHRUB_MIX = key("autumnal_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_SHRUB_MIX = key("birch_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_DARK_OAK_SHRUB_MIX = key("blackwood_dark_oak_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGNOLIA_SHRUB_MIX = key("magnolia_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SHRUB_MIX = key("dead_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH_SHRUB_MIX = key("larch_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_LARCH_SHRUB_MIX = key("golden_larch_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_SHRUB_MIX = key("maple_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAUVE_ENCHANTED_SHRUB_MIX = key("mauve_enchanted_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_JUNGLE_SHRUB_MIX = key("palm_jungle_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_SPRUCE_SHRUB_MIX = key("pine_spruce_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_DEAD_SHRUB_MIX = key("pine_dead_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_CYPRESS_SHRUB_MIX = key("willow_cypress_shrub_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_MAGNOLIA_SHRUB_MIX = key("willow_magnolia_shrub_mix");
    //trees
    public static final ResourceKey<ConfiguredFeature<?, ?>> PRAIRIE_MIX = key("prairie_tree_mix");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> featureGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> OAK_TREE = featureGetter.getOrThrow(RUConfiguredFeatures.TREE_OAK);
        Holder<ConfiguredFeature<?, ?>> BIG_OAK_TREE = featureGetter.getOrThrow(RUConfiguredFeatures.TREE_BIG_OAK);
        //GroundCover Builders
        SimpleWeightedRandomList.Builder<BlockState> mapleLeafPileBuilder = SimpleWeightedRandomList.builder();
        SimpleWeightedRandomList.Builder<BlockState> redMapleLeafPileBuilder = SimpleWeightedRandomList.builder();
        SimpleWeightedRandomList.Builder<BlockState> orangeMapleLeafPileBuilder = SimpleWeightedRandomList.builder();
        SimpleWeightedRandomList.Builder<BlockState> silverBirchLeafPileBuilder = SimpleWeightedRandomList.builder();
        SimpleWeightedRandomList.Builder<BlockState> enchantedBirchLeafPileBuilder = SimpleWeightedRandomList.builder();
        //Petal-Like Builders
        SimpleWeightedRandomList.Builder<BlockState> orangeConeflowerBuilder = SimpleWeightedRandomList.builder();
        SimpleWeightedRandomList.Builder<BlockState> purpleConeflowerBuilder = SimpleWeightedRandomList.builder();
        SimpleWeightedRandomList.Builder<BlockState> magnoliaFlowerBuilder = SimpleWeightedRandomList.builder();
        SimpleWeightedRandomList.Builder<BlockState> cloverBuilder = SimpleWeightedRandomList.builder();
        //Other Builders
        SimpleWeightedRandomList.Builder<BlockState> duskMelon = SimpleWeightedRandomList.builder();
        duskMelon.add(RUBlocks.DUSKMELON.get().defaultBlockState().setValue(DuskmelonBlock.AGE, 1), 3).add(RUBlocks.DUSKMELON.get().defaultBlockState().setValue(DuskmelonBlock.AGE, 2), 2);
        for(int i = 1; i <= 4; ++i) {
            for(Direction direction : Direction.Plane.HORIZONTAL) {
                mapleLeafPileBuilder.add(RUBlocks.MAPLE_LEAF_LITTER.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
                redMapleLeafPileBuilder.add(RUBlocks.RED_MAPLE_LEAF_LITTER.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
                orangeMapleLeafPileBuilder.add(RUBlocks.ORANGE_MAPLE_LEAF_LITTER.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
                silverBirchLeafPileBuilder.add(RUBlocks.SILVER_BIRCH_LEAF_LITTER.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
                enchantedBirchLeafPileBuilder.add(RUBlocks.ENCHANTED_BIRCH_LEAF_LITTER.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
                orangeConeflowerBuilder.add(RUBlocks.ORANGE_CONEFLOWER.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
                purpleConeflowerBuilder.add(RUBlocks.PURPLE_CONEFLOWER.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
                magnoliaFlowerBuilder.add(Blocks.PINK_PETALS.defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
                cloverBuilder.add(RUBlocks.CLOVER.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
            }
        }


        //---------------------FEATURES---------------------//
        //SIMPLE_RANDOM_SELECTOR
        register(context, PATCH_TALL_FLOWERS, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.TASSEL.get())))), PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.DAY_LILY.get())))),  PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.MEADOW_SAGE.get())))), PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LILAC)))), PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.ROSE_BUSH)))), PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.PEONY)))), PlacementUtils.inlinePlaced(Feature.NO_BONEMEAL_FLOWER, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LILY_OF_THE_VALLEY)))))));
        //SIMPLE_BLOCK
        register(context, ASTER, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.ASTER.get())));
        register(context, BLACKWOOD_DECORATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.BLUE_BIOSHROOM.get().defaultBlockState(), 3).add(RUBlocks.PINK_BIOSHROOM.get().defaultBlockState(), 3).add(RUBlocks.TALL_BLUE_BIOSHROOM.get().defaultBlockState(), 1).add(RUBlocks.TALL_PINK_BIOSHROOM.get().defaultBlockState(), 1))));
        register(context, BLADED_GRASS_SINGLE, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.BLADED_GRASS.get().defaultBlockState())));
        register(context, CORPSE_FLOWER, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.CORPSE_FLOWER.get())));
        register(context, DAY_LILY, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.DAY_LILY.get())));
        register(context, DUSKTRAP, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.DUSKTRAP.get())));
        register(context, MEADOW_SAGE, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.MEADOW_SAGE.get())));
        register(context, BARREL_CACTUS, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.BARREL_CACTUS.get())));
        register(context, SANDY_GRASS, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.SANDY_GRASS.get())));
        register(context, TASSEL, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.TASSEL.get())));
        register(context, WHITE_SNOWBELLE, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.SNOWBELLES.getWhite().get())));
        //RANDOM_PATCH
        register(context, PATCH_ASHEN_GRASS, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.ASHEN_GRASS.get()), 32, BlockPredicate.matchesBlocks(Vec3i.ZERO.below(), RUBlocks.ASHEN_DIRT.get())));
        register(context, PATCH_SMOULDERING_ASHEN_GRASS, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.ASHEN_GRASS.get().defaultBlockState().setValue(AshenGrassBlock.SMOULDERING, true)), 64, BlockPredicate.matchesBlocks(Vec3i.ZERO.below(), RUBlocks.ASH.get(), Blocks.BASALT, Blocks.POLISHED_BASALT)));
        register(context, PATCH_ASH_VENTS, Feature.RANDOM_PATCH, new RandomPatchConfiguration(96, 6, 0, Holder.direct(new PlacedFeature(
            Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                List.of(new WeightedPlacedFeature(
                    inline(new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(LithostitchedStateProviders.randomBlock(Blocks.BASALT, Blocks.SMOOTH_BASALT)))),
                    0.9f
                )),
                inline(new ConfiguredFeature<>(Feature.BLOCK_COLUMN, new BlockColumnConfiguration(
                    List.of(
                        new BlockColumnConfiguration.Layer(UniformInt.of(0, 4), BlockStateProvider.simple(Blocks.BASALT)),
                        new BlockColumnConfiguration.Layer(ConstantInt.of(1), BlockStateProvider.simple(RUBlocks.ASH_VENT.get()))
                    ),
                    Direction.UP,
                    BlockPredicate.allOf(
                        BlockPredicate.matchesTag(BlockTags.AIR),
                        BlockPredicate.not(BlockPredicate.anyOf(
                            BlockPredicate.matchesBlocks(Vec3i.ZERO.north(), RUBlocks.ASH_VENT.get()),
                            BlockPredicate.matchesBlocks(Vec3i.ZERO.east(), RUBlocks.ASH_VENT.get()),
                            BlockPredicate.matchesBlocks(Vec3i.ZERO.south(), RUBlocks.ASH_VENT.get()),
                            BlockPredicate.matchesBlocks(Vec3i.ZERO.west(), RUBlocks.ASH_VENT.get())
                        ))
                    ),
                    true
                )))
            ))),
            List.of(
                RUDatagenFeatureUtils.airAndBlocksBelow(RUBlocks.ASH.get()),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1))
            )
        ))));

        register(context, PATCH_GRASS_SPARSE, Feature.RANDOM_PATCH, patch(weightedStates(pair(Blocks.SHORT_GRASS), pair(RUBlocks.GRASS_SPROUTS.get())), 64));
        register(context, PATCH_SANDY_GRASS_SPARSE, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.SANDY_GRASS.get()), 64));
        register(context, PATCH_DESERT_SHRUB_SPARSE, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.SMALL_DESERT_SHRUB.get()), 64, BlockPredicate.matchesTag(Vec3i.ZERO.below(), BlockTags.DIRT)));

        register(context, PATCH_BARLEY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.BARLEY.get()))));
        register(context, PATCH_BAYOU_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 30).add(Blocks.SHORT_GRASS.defaultBlockState(), 15).add(Blocks.TALL_GRASS.defaultBlockState(), 3)), 32));
        register(context, PATCH_BLACKWOOD_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 15).add(Blocks.SHORT_GRASS.defaultBlockState(), 20).add(Blocks.TALL_GRASS.defaultBlockState(), 10).add(Blocks.LARGE_FERN.defaultBlockState(), 1)), 32));
        register(context, PATCH_BLADED_GRASS, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.BLADED_GRASS.get().defaultBlockState(), 4).add(RUBlocks.BLADED_TALL_GRASS.get().defaultBlockState(), 1).add(Blocks.SHORT_GRASS.defaultBlockState(), 4)), 32));
        register(context, PATCH_CAVE_HYSSOP, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.CAVE_HYSSOP.get().defaultBlockState()), 32));
        register(context, PATCH_CLOVER, Feature.RANDOM_PATCH, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(cloverBuilder)))));
        register(context, PATCH_DECIDUOUS_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 30).add(Blocks.SHORT_GRASS.defaultBlockState(), 15).add(Blocks.TALL_GRASS.defaultBlockState(), 10).add(Blocks.LARGE_FERN.defaultBlockState(), 3)), 32));
        register(context, PATCH_FEN_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 30).add(Blocks.SHORT_GRASS.defaultBlockState(), 15).add(Blocks.TALL_GRASS.defaultBlockState(), 10).add(Blocks.LARGE_FERN.defaultBlockState(), 5)), 32));
        register(context, PATCH_DIRT_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 30).add(Blocks.SHORT_GRASS.defaultBlockState(), 5).add(Blocks.LARGE_FERN.defaultBlockState(), 3)), 32));
        register(context, PATCH_FERNS, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 10).add(Blocks.FERN.defaultBlockState(), 1)), 32));
        register(context, PATCH_GRASS, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(Blocks.SHORT_GRASS.defaultBlockState()), 32));
        register(context, PATCH_GRASS_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 7).add(Blocks.SHORT_GRASS.defaultBlockState(), 15).add(Blocks.TALL_GRASS.defaultBlockState(), 2)), 32));
        register(context, PATCH_PRISMOSS_SPROUT, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.PRISMOSS_SPROUT.get().defaultBlockState()), 32));
        register(context, PATCH_REDSTONE_BUD, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.REDSTONE_BUD.get().defaultBlockState()), 128));
        register(context, PATCH_REDSTONE_BULB, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.REDSTONE_BULB.get().defaultBlockState()), 64));
        register(context, PATCH_FERNS_DENSE, Feature.RANDOM_PATCH, patch(weightedStates(
            pair(Blocks.FERN, 5),
            pair(Blocks.LARGE_FERN, 2),
            pair(Blocks.SHORT_GRASS, 2),
            pair(RUBlocks.GRASS_SPROUTS.get())
        ), 128));
        register(context, PATCH_SHRUBLAND_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 15).add(Blocks.SHORT_GRASS.defaultBlockState(), 30).add(Blocks.TALL_GRASS.defaultBlockState(), 15)), 32));
        register(context, PATCH_MOUNTAIN_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 30).add(Blocks.LARGE_FERN.defaultBlockState(), 15).add(Blocks.SHORT_GRASS.defaultBlockState(), 20).add(Blocks.TALL_GRASS.defaultBlockState(), 5)), 32));
        register(context, PATCH_STEPPE_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.STEPPE_GRASS.get().defaultBlockState(), 10).add(RUBlocks.STEPPE_SHRUB.get().defaultBlockState(), 10).add(RUBlocks.SMALL_DESERT_SHRUB.get().defaultBlockState(), 1).add(RUBlocks.STEPPE_TALL_GRASS.get().defaultBlockState(), 1).add(RUBlocks.DEAD_STEPPE_SHRUB.get().defaultBlockState(), 10)), 32));
        register(context, PATCH_SOCOTRA_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.STEPPE_SHRUB.get().defaultBlockState(), 10).add(Blocks.SHORT_GRASS.defaultBlockState(), 10).add(RUBlocks.SMALL_DESERT_SHRUB.get().defaultBlockState(), 5).add(Blocks.TALL_GRASS.defaultBlockState(), 1)), 32));
        register(context, PATCH_OUTBACK_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.STEPPE_GRASS.get().defaultBlockState(), 10).add(Blocks.SHORT_GRASS.defaultBlockState(), 10).add(RUBlocks.DEAD_STEPPE_SHRUB.get().defaultBlockState(), 5).add(RUBlocks.SMALL_DESERT_SHRUB.get().defaultBlockState(), 10)), 32));
        register(context, PATCH_SANDY_GRASS_VEGETATION, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.SANDY_GRASS.get().defaultBlockState(), 20).add(RUBlocks.SANDY_TALL_GRASS.get().defaultBlockState(), 1)), 32));
        register(context, PATCH_SNOW_GRASS, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.FROZEN_GRASS.get().defaultBlockState()), 32));
        register(context, PATCH_GRASS_SPROUTS, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.GRASS_SPROUTS.get().defaultBlockState()), 32));
        register(context, PATCH_TALL_GRASS, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(Blocks.TALL_GRASS.defaultBlockState()), 32));
        register(context, PATCH_WINDSWEPT_GRASS, Feature.RANDOM_PATCH, patch(BlockStateProvider.simple(RUBlocks.WINDSWEPT_GRASS.get().defaultBlockState()), 32));
        //FLOWER
        register(context, PATCH_FROZEN_FLOWERS, Feature.FLOWER, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.BLEEDING_HEART.get().defaultBlockState(), 3).add(Blocks.LILY_OF_THE_VALLEY.defaultBlockState(), 2)))));
        register(context, PATCH_PINK_FLOWERS, Feature.FLOWER, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.FIREWEED.get().defaultBlockState(), 3).add(RUBlocks.TSUBAKI.get().defaultBlockState(), 2).add(RUBlocks.PINK_LUPINE.get().defaultBlockState(), 3).add(Blocks.PINK_TULIP.defaultBlockState(), 3)))));
        register(context, PATCH_ALPHA_DANDELION, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.ALPHA_DANDELION.get().defaultBlockState())))));
        register(context, PATCH_ALPHA_ROSE, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.ALPHA_ROSE.get().defaultBlockState())))));
        register(context, PATCH_AZURE_DAISY, Feature.FLOWER, new RandomPatchConfiguration(32, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AZURE_BLUET.defaultBlockState(), 1).add(Blocks.OXEYE_DAISY.defaultBlockState(), 1).add(RUBlocks.FELICIA_DAISY.get().defaultBlockState(), 2))))));
        register(context, PATCH_DAISY, Feature.FLOWER, new RandomPatchConfiguration(8, 1, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.DAISY.get())))));
        register(context, PATCH_WARATAH, Feature.FLOWER, new RandomPatchConfiguration(8, 1, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.WARATAH.get())))));
        register(context, PATCH_DAISIES, Feature.FLOWER, patch(new DualNoiseProvider(
            new InclusiveRange<>(2),
            new NormalNoise.NoiseParameters(-7, 2.5),
            0.6f,
            9987,
            new NormalNoise.NoiseParameters(-4, 1),
            1,
            List.of(
                state(RUBlocks.DAISY),
                state(Blocks.SHORT_GRASS),
                state(RUBlocks.FELICIA_DAISY)
            )
        ), 32));
        register(context, PATCH_LUPINES, Feature.FLOWER, patch(new DualNoiseProvider(
            new InclusiveRange<>(2),
            new NormalNoise.NoiseParameters(-7, 1),
            0.75f,
            9989,
            new NormalNoise.NoiseParameters(-4, 1),
            1,
            List.of(
                state(RUBlocks.YELLOW_LUPINE),
                state(RUBlocks.RED_LUPINE),
                state(RUBlocks.BLUE_LUPINE),
                state(RUBlocks.PURPLE_LUPINE),
                state(RUBlocks.PINK_LUPINE)
            )
        ), 64));

        register(context, PATCH_MAGNOLIA_FLOWERS, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(magnoliaFlowerBuilder)))));
        register(context, PATCH_MEADOW_VEGETATION, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.HYSSOP.get().defaultBlockState(), 20).add(RUBlocks.FIREWEED.get().defaultBlockState(), 15).add(RUBlocks.DAISY.get().defaultBlockState(), 10).add(Blocks.SHORT_GRASS.defaultBlockState(), 40))))));
        register(context, PATCH_ORANGE_CONEFLOWER, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(orangeConeflowerBuilder)))));
        register(context, PATCH_POPPIES, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.075F, List.of(RUBlocks.POPPY_BUSH.get().defaultBlockState(), RUBlocks.SALMON_POPPY_BUSH.get().defaultBlockState()))))));
        register(context, PATCH_PRAIRIE_FLOWERS, Feature.FLOWER, new RandomPatchConfiguration(32, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.POPPY_BUSH.get().defaultBlockState(), 3).add(RUBlocks.RED_LUPINE.get().defaultBlockState(), 2).add(RUBlocks.YELLOW_LUPINE.get().defaultBlockState(), 1))))));
        register(context, PATCH_PURPLE_CONEFLOWER, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(purpleConeflowerBuilder)))));
        register(context, PATCH_SHRUBLAND_FLOWERS, Feature.FLOWER, new RandomPatchConfiguration(32, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.RED_LUPINE.get().defaultBlockState(), 1).add(RUBlocks.BLUE_LUPINE.get().defaultBlockState(), 1))))));
        register(context, PATCH_WILLOW_FLOWERS, Feature.FLOWER, new RandomPatchConfiguration(32, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.FELICIA_DAISY.get().defaultBlockState(), 2).add(RUBlocks.BLUE_LUPINE.get().defaultBlockState(), 2).add(Blocks.ALLIUM.defaultBlockState(), 1).add(Blocks.CORNFLOWER.defaultBlockState(), 2))))));
        register(context, PATCH_SMALL_FLOWERS, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.075F, List.of(RUBlocks.MALLOW.get().defaultBlockState(), RUBlocks.YELLOW_LUPINE.get().defaultBlockState(), Blocks.PINK_TULIP.defaultBlockState(), RUBlocks.POPPY_BUSH.get().defaultBlockState(), Blocks.OXEYE_DAISY.defaultBlockState(), RUBlocks.RED_LUPINE.get().defaultBlockState(), Blocks.CORNFLOWER.defaultBlockState(), RUBlocks.PINK_LUPINE.get().defaultBlockState(), RUBlocks.TSUBAKI.get().defaultBlockState(), Blocks.ORANGE_TULIP.defaultBlockState(), RUBlocks.WARATAH.get().defaultBlockState(), Blocks.WHITE_TULIP.defaultBlockState(), RUBlocks.HYSSOP.get().defaultBlockState(), Blocks.ALLIUM.defaultBlockState(), RUBlocks.BLUE_LUPINE.get().defaultBlockState(), RUBlocks.BLEEDING_HEART.get().defaultBlockState(), RUBlocks.SALMON_POPPY_BUSH.get().defaultBlockState(), RUBlocks.WHITE_TRILLIUM.get().defaultBlockState(), Blocks.BLUE_ORCHID.defaultBlockState(), RUBlocks.FIREWEED.get().defaultBlockState(), RUBlocks.DAISY.get().defaultBlockState(), RUBlocks.PURPLE_LUPINE.get().defaultBlockState(), Blocks.RED_TULIP.defaultBlockState(), RUBlocks.FELICIA_DAISY.get().defaultBlockState(), Blocks.POPPY.defaultBlockState(), Blocks.LILY_OF_THE_VALLEY.defaultBlockState()))))));
        register(context, PATCH_TULIPS, Feature.FLOWER, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.WHITE_TULIP.defaultBlockState(), 4).add(Blocks.PINK_TULIP.defaultBlockState(), 2).add(Blocks.ORANGE_TULIP.defaultBlockState(), 2).add(Blocks.RED_TULIP.defaultBlockState(), 2)))));
        register(context, PATCH_WHITE_TRILLIUM, Feature.FLOWER, new RandomPatchConfiguration(32, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.WHITE_TRILLIUM.get().defaultBlockState())))));
        register(context, PATCH_WILTING_TRILLIUM, Feature.FLOWER, new RandomPatchConfiguration(32, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.WILTING_TRILLIUM.get().defaultBlockState())))));
        register(context, PATCH_TSUBAKI, Feature.FLOWER, new RandomPatchConfiguration(32, 1, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.TSUBAKI.get())))));
        register(context, PATCH_HIBISCUS, Feature.FLOWER, new RandomPatchConfiguration(14, 1, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.HIBISCUS.get())))));
        register(context, PATCH_MALLOW, Feature.FLOWER, new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.MALLOW.get())))));
        register(context, PATCH_HYSSOP, Feature.FLOWER, new RandomPatchConfiguration(16, 1, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.HYSSOP.get())))));
        //TREE
        register(context, BLACKWOOD_BIOSHROOMS, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState()), new StraightTrunkPlacer(2, 1, 0), BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0), new TwoLayersFeatureSize(0, 0, 0)).decorators(ImmutableList.of(BlackwoodBioshroomDecorator.INSTANCE)).ignoreVines().build());
        //MULTIFACE
        register(context, PINK_MAGNOLIA_FLOWERS, RUFeatureTypes.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock) RUBlocks.PINK_MAGNOLIA_FLOWERS.get(), 20, true, false, false, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.GRASS_BLOCK, RUBlocks.PEAT_GRASS_BLOCK.get(), RUBlocks.SILT_GRASS_BLOCK.get())));
        register(context, WHITE_MAGNOLIA_FLOWERS, RUFeatureTypes.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock) RUBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 20, true, false, false, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.GRASS_BLOCK, RUBlocks.PEAT_GRASS_BLOCK.get(), RUBlocks.SILT_GRASS_BLOCK.get())));
        //FOOD_PLANTS
        register(context, PATCH_SALMONBERRY_BUSH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.SALMONBERRY_BUSH.get().defaultBlockState().setValue(SalmonBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, RUBlocks.PEAT_GRASS_BLOCK.get(), RUBlocks.SILT_GRASS_BLOCK.get(), RUBlocks.PEAT_PODZOL.get(), RUBlocks.SILT_PODZOL.get())));
        register(context, DUSKMELON, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(duskMelon)));
        //BIOSHROOM
        register(context, PATCH_BLUE_BIOSHROOM, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.TALL_BLUE_BIOSHROOM.get().defaultBlockState(), 1).add(RUBlocks.BLUE_BIOSHROOM.get().defaultBlockState(), 10)), 16));
        register(context, PATCH_GREEN_BIOSHROOM, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.TALL_GREEN_BIOSHROOM.get().defaultBlockState(), 1).add(RUBlocks.GREEN_BIOSHROOM.get().defaultBlockState(), 10)), 16));
        register(context, PATCH_PINK_BIOSHROOM, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.TALL_PINK_BIOSHROOM.get().defaultBlockState(), 1).add(RUBlocks.PINK_BIOSHROOM.get().defaultBlockState(), 8)), 16));
        register(context, PATCH_YELLOW_BIOSHROOM, Feature.RANDOM_PATCH, patch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.TALL_YELLOW_BIOSHROOM.get().defaultBlockState(), 1).add(RUBlocks.YELLOW_BIOSHROOM.get().defaultBlockState(), 6)), 6));
        //OTHER
        register(context, BAMBOO, Feature.BAMBOO, new ProbabilityFeatureConfiguration(0.25F));
        register(context, FLOWERING_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.FLOWERING_LILY_PAD.get())))));
        register(context, GIANT_LILY, RUFeatureTypes.GIANT_LILY.get(), FeatureConfiguration.NONE);
        register(context, ELEPHANT_EAR, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.ELEPHANT_EAR.get())));
        register(context, DROPLEAF, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 4, 2,
            PlacementUtils.inlinePlaced(Feature.BLOCK_COLUMN, new BlockColumnConfiguration(
                List.of(
                    BlockColumnConfiguration.layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(UniformInt.of(0, 19), 2).add(UniformInt.of(0, 2), 3).add(UniformInt.of(0, 6), 10).build()), BlockStateProvider.simple(RUBlocks.DROPLEAF_PLANT.get())),
                    BlockColumnConfiguration.layer(ConstantInt.of(1), new RandomizedIntStateProvider(BlockStateProvider.simple(RUBlocks.DROPLEAF.get()), "age", UniformInt.of(22, 24)))
                ), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true
            ),
            BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.hasSturdyFace(Vec3i.ZERO.above(), Direction.DOWN), BlockPredicate.matchesTag(BlockTags.AIR))))));
        register(context, DUCKWEED, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RUBlocks.DUCKWEED.get())))));

        //SHRUBS
        register(context, ASHEN_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.ASHEN_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, ACACIA_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.ACACIA_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, BAOBAB_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.BAOBAB_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, BIRCH_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.BIRCH_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, BLACKWOOD_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.BLACKWOOD_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, CHERRY_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.CHERRY_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, MAGNOLIA_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.MAGNOLIA_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, PINK_MAGNOLIA_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, WHITE_MAGNOLIA_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, CYPRESS_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.CYPRESS_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, DARK_OAK_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.DARK_OAK_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, DEAD_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.DEAD_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, DEAD_PINE_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.DEAD_PINE_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, EUCALYPTUS_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.EUCALYPTUS_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, FLOWERING_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.FLOWERING_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, JOSHUA_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.JOSHUA_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, JUNGLE_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.JUNGLE_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, LARCH_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.LARCH_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, GOLDEN_LARCH_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, MANGROVE_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.MANGROVE_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, MAPLE_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.MAPLE_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, RED_MAPLE_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.RED_MAPLE_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, ORANGE_MAPLE_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, MAUVE_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.MAUVE_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, OAK_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.OAK_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, PALM_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.PALM_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, PINE_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.PINE_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, REDWOOD_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.REDWOOD_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, SILVER_BIRCH_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.SILVER_BIRCH_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, SOCOTRA_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.SOCOTRA_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, SPRUCE_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.SPRUCE_NATURAL_SET.getShrub().defaultBlockState())));
        register(context, WILLOW_SHRUB, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RUBlocks.WILLOW_NATURAL_SET.getShrub().defaultBlockState())));
        //mixes
        register(context, BAOBAB_ACACIA_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.BAOBAB_NATURAL_SET.getShrub().defaultBlockState(), 2).add(RUBlocks.ACACIA_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, AUTUMNAL_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.MAPLE_NATURAL_SET.getShrub().defaultBlockState(), 2).add(RUBlocks.SILVER_BIRCH_NATURAL_SET.getShrub().defaultBlockState(), 4).add(RUBlocks.RED_MAPLE_NATURAL_SET.getShrub().defaultBlockState(), 4).add(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getShrub().defaultBlockState(), 4))));
        register(context, BIRCH_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.SILVER_BIRCH_NATURAL_SET.getShrub().defaultBlockState(), 3).add(RUBlocks.BIRCH_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, BLACKWOOD_DARK_OAK_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.BLACKWOOD_NATURAL_SET.getShrub().defaultBlockState(), 3).add(RUBlocks.DARK_OAK_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, MAGNOLIA_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.MAGNOLIA_NATURAL_SET.getShrub().defaultBlockState(), 1).add(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getShrub().defaultBlockState(), 1).add(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, DEAD_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.DEAD_NATURAL_SET.getShrub().defaultBlockState(), 2).add(RUBlocks.DEAD_PINE_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, LARCH_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.LARCH_NATURAL_SET.getShrub().defaultBlockState(), 3).add(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, GOLDEN_LARCH_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.LARCH_NATURAL_SET.getShrub().defaultBlockState(), 1).add(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub().defaultBlockState(), 3))));
        register(context, MAPLE_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.MAPLE_NATURAL_SET.getShrub().defaultBlockState(), 4).add(RUBlocks.RED_MAPLE_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, MAUVE_ENCHANTED_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.MAUVE_NATURAL_SET.getShrub().defaultBlockState(), 3).add(RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, PINE_SPRUCE_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.PINE_NATURAL_SET.getShrub().defaultBlockState(), 1).add(RUBlocks.SPRUCE_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, PINE_DEAD_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.PINE_NATURAL_SET.getShrub().defaultBlockState(), 2).add(RUBlocks.DEAD_PINE_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, PALM_JUNGLE_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.PALM_NATURAL_SET.getShrub().defaultBlockState(), 5).add(RUBlocks.JUNGLE_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, WILLOW_CYPRESS_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.WILLOW_NATURAL_SET.getShrub().defaultBlockState(), 2).add(RUBlocks.CYPRESS_NATURAL_SET.getShrub().defaultBlockState(), 1))));
        register(context, WILLOW_MAGNOLIA_SHRUB_MIX, RUFeatureTypes.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RUBlocks.WILLOW_NATURAL_SET.getShrub().defaultBlockState(), 2).add(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getShrub().defaultBlockState(), 1))));

        register(context, PRAIRIE_MIX, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(BIG_OAK_TREE), 0.33333334F)), PlacementUtils.inlinePlaced(OAK_TREE)));

    }

    private static Holder<PlacedFeature> inline(ConfiguredFeature<?, ?> feature) {
        return Holder.direct(new PlacedFeature(Holder.direct(feature), List.of()));
    }

    private static RandomPatchConfiguration patch(BlockStateProvider stateProvider, int count) {
        return FeatureUtils.simpleRandomPatchConfiguration(count, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }

    private static RandomPatchConfiguration patch(BlockStateProvider stateProvider, int count, BlockPredicate predicate) {
        return FeatureUtils.simpleRandomPatchConfiguration(count, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider), BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, predicate)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
