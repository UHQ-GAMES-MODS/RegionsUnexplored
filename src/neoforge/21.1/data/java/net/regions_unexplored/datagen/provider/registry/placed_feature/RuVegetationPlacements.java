package net.regions_unexplored.datagen.provider.registry.placed_feature;

import dev.worldgen.lithostitched.worldgen.placementmodifier.NoiseSlopePlacement;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ClampedInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.regions_unexplored.datagen.provider.registry.RUDatagenFeatureUtils;
import net.regions_unexplored.datagen.provider.registry.configured_feature.RuVegetationFeatures;
import net.regions_unexplored.datagen.provider.registry.RUPlacedFeatureBootstrap;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.registry.data.RUConfiguredFeatures;
import net.regions_unexplored.registry.data.RUNoises;
import net.regions_unexplored.registry.data.RUPlacedFeatures;

import static net.regions_unexplored.datagen.provider.registry.RUDatagenFeatureUtils.*;

import java.util.List;

public class RuVegetationPlacements {
    //-----------------------KEYS-----------------------//
    public static final ResourceKey<PlacedFeature> BLACKWOOD_MUSHROOMS = RUPlacedFeatureBootstrap.key("blackwood_mushrooms");
    public static final ResourceKey<PlacedFeature> BLACKWOOD_DECORATION = RUPlacedFeatureBootstrap.key("blackwood_decoration");
    public static final ResourceKey<PlacedFeature> MEADOW_VEGETATION = RUPlacedFeatureBootstrap.key("meadow_vegetation");
    //GRASS
    public static final ResourceKey<PlacedFeature> SANDY_GRASS = RUPlacedFeatureBootstrap.key("sandy_grass");
    public static final ResourceKey<PlacedFeature> FERNS = RUPlacedFeatureBootstrap.key("ferns");
    public static final ResourceKey<PlacedFeature> GRASS = RUPlacedFeatureBootstrap.key("grass");
    public static final ResourceKey<PlacedFeature> CAVE_GRASS = RUPlacedFeatureBootstrap.key("cave_grass");
    public static final ResourceKey<PlacedFeature> TALL_GRASS = RUPlacedFeatureBootstrap.key("tall_grass");
    public static final ResourceKey<PlacedFeature> CAVE_TALL_GRASS = RUPlacedFeatureBootstrap.key("cave_tall_grass");
    public static final ResourceKey<PlacedFeature> SNOW_GRASS = RUPlacedFeatureBootstrap.key("snow_grass");
    public static final ResourceKey<PlacedFeature> WINDSWEPT_GRASS = RUPlacedFeatureBootstrap.key("windswept_grass");
    public static final ResourceKey<PlacedFeature> PATCH_GRASS_SPROUTS_DENSE = RUPlacedFeatureBootstrap.key("patch/grass_sprouts_dense");
    public static final ResourceKey<PlacedFeature> PATCH_GRASS_SPROUTS_SPARSE = RUPlacedFeatureBootstrap.key("patch/grass_sprouts_sparse");
    public static final ResourceKey<PlacedFeature> PATCH_ASHEN_GRASS = RUPlacedFeatureBootstrap.key("patch/ashen_grass");
    public static final ResourceKey<PlacedFeature> PATCH_ASHEN_GRASS_SMOULDERING = RUPlacedFeatureBootstrap.key("patch/smouldering_ashen_grass");
    public static final ResourceKey<PlacedFeature> PATCH_LUPINES = RUPlacedFeatureBootstrap.key("patch/lupines");
    public static final ResourceKey<PlacedFeature> PATCH_ASH_VENTS = RUPlacedFeatureBootstrap.key("patch/ash_vents");
    public static final ResourceKey<PlacedFeature> PATCH_FERNS_DENSE = RUPlacedFeatureBootstrap.key("patch/ferns_dense");
    public static final ResourceKey<PlacedFeature> PATCH_CLOVERS_DENSE = RUPlacedFeatureBootstrap.key("patch/clovers_dense");
    public static final ResourceKey<PlacedFeature> BLACKWOOD_VEGETATION = RUPlacedFeatureBootstrap.key("blackwood_vegetation");
    public static final ResourceKey<PlacedFeature> DECIDUOUS_VEGETATION = RUPlacedFeatureBootstrap.key("deciduous_vegetation");
    public static final ResourceKey<PlacedFeature> FEN_VEGETATION = RUPlacedFeatureBootstrap.key("fen_vegetation");
    public static final ResourceKey<PlacedFeature> SHRUBLAND_VEGETATION = RUPlacedFeatureBootstrap.key("shrubland_vegetation");
    public static final ResourceKey<PlacedFeature> MOUNTAIN_VEGETATION = RUPlacedFeatureBootstrap.key("mountain_vegetation");
    public static final ResourceKey<PlacedFeature> OUTBACK_VEGETATION = RUPlacedFeatureBootstrap.key("outback_vegetation");
    public static final ResourceKey<PlacedFeature> JOSHUA_VEGETATION = RUPlacedFeatureBootstrap.key("joshua_vegetation");
    public static final ResourceKey<PlacedFeature> STEPPE_VEGETATION = RUPlacedFeatureBootstrap.key("steppe_vegetation");
    public static final ResourceKey<PlacedFeature> SOCOTRA_VEGETATION = RUPlacedFeatureBootstrap.key("socotra_vegetation");
    public static final ResourceKey<PlacedFeature> BAYOU_VEGETATION = RUPlacedFeatureBootstrap.key("bayou_vegetation");
    public static final ResourceKey<PlacedFeature> DIRT_VEGETATION = RUPlacedFeatureBootstrap.key("dirt_vegetation");
    public static final ResourceKey<PlacedFeature> SANDY_GRASS_VEGETATION = RUPlacedFeatureBootstrap.key("sandy_grass_vegetation");
    public static final ResourceKey<PlacedFeature> GRASS_VEGETATION = RUPlacedFeatureBootstrap.key("grass_vegetation");
    public static final ResourceKey<PlacedFeature> REDSTONE_BUD = RUPlacedFeatureBootstrap.key("redstone_bud");
    public static final ResourceKey<PlacedFeature> PRISMOSS_SPROUT = RUPlacedFeatureBootstrap.key("prismoss_sprout");
    public static final ResourceKey<PlacedFeature> BLADED_GRASS = RUPlacedFeatureBootstrap.key("bladed_grass");
    public static final ResourceKey<PlacedFeature> BLADED_GRASS_BONEMEAL = RUPlacedFeatureBootstrap.key("bladed_grass_bonemeal");
    //FLOWERS
    public static final ResourceKey<PlacedFeature> CAVE_HYSSOP = RUPlacedFeatureBootstrap.key("cave_hyssop");
    public static final ResourceKey<PlacedFeature> ASTER = RUPlacedFeatureBootstrap.key("aster");
    public static final ResourceKey<PlacedFeature> TULIPS = RUPlacedFeatureBootstrap.key("tulips");
    public static final ResourceKey<PlacedFeature> SMALL_FLOWERS = RUPlacedFeatureBootstrap.key("small_flowers");
    public static final ResourceKey<PlacedFeature> TALL_FLOWERS = RUPlacedFeatureBootstrap.key("tall_flowers");
    public static final ResourceKey<PlacedFeature> ALPHA_DANDELION = RUPlacedFeatureBootstrap.key("alpha_dandelion");
    public static final ResourceKey<PlacedFeature> ALPHA_ROSE = RUPlacedFeatureBootstrap.key("alpha_rose");
    public static final ResourceKey<PlacedFeature> WILTING_TRILLIUM = RUPlacedFeatureBootstrap.key("wilting_trillium");
    public static final ResourceKey<PlacedFeature> WHITE_TRILLIUM = RUPlacedFeatureBootstrap.key("white_trillium");
    public static final ResourceKey<PlacedFeature> AZURE_DAISY = RUPlacedFeatureBootstrap.key("azure_daisy");
    public static final ResourceKey<PlacedFeature> DAISY = RUPlacedFeatureBootstrap.key("daisy");
    public static final ResourceKey<PlacedFeature> DAISIES = RUPlacedFeatureBootstrap.key("daisies");
    public static final ResourceKey<PlacedFeature> WARATAH = RUPlacedFeatureBootstrap.key("waratah");
    public static final ResourceKey<PlacedFeature> PRAIRIE_FLOWERS = RUPlacedFeatureBootstrap.key("prairie_flowers");
    public static final ResourceKey<PlacedFeature> SHRUBLAND_FLOWERS = RUPlacedFeatureBootstrap.key("shrubland_flowers");
    public static final ResourceKey<PlacedFeature> WILLOW_FLOWERS = RUPlacedFeatureBootstrap.key("willow_flowers");
    public static final ResourceKey<PlacedFeature> POPPIES = RUPlacedFeatureBootstrap.key("poppies");
    public static final ResourceKey<PlacedFeature> TASSEL_SPARSE = RUPlacedFeatureBootstrap.key("tassel_sparse");
    public static final ResourceKey<PlacedFeature> TASSEL_DENSE = RUPlacedFeatureBootstrap.key("tassel_dense");
    public static final ResourceKey<PlacedFeature> CORPSE_FLOWER = RUPlacedFeatureBootstrap.key("corpse_flower");
    public static final ResourceKey<PlacedFeature> DUSKTRAP = RUPlacedFeatureBootstrap.key("dusktrap");
    public static final ResourceKey<PlacedFeature> DAY_LILY = RUPlacedFeatureBootstrap.key("day_lily");
    public static final ResourceKey<PlacedFeature> TSUBAKI = RUPlacedFeatureBootstrap.key("tsubaki");
    public static final ResourceKey<PlacedFeature> HIBISCUS = RUPlacedFeatureBootstrap.key("hibiscus");
    public static final ResourceKey<PlacedFeature> MALLOW = RUPlacedFeatureBootstrap.key("mallow");
    public static final ResourceKey<PlacedFeature> HYSSOP = RUPlacedFeatureBootstrap.key("hyssop");
    public static final ResourceKey<PlacedFeature> FROZEN_FLOWERS = RUPlacedFeatureBootstrap.key("frozen_flowers");
    public static final ResourceKey<PlacedFeature> PINK_FLOWERS = RUPlacedFeatureBootstrap.key("pink_flowers");
    public static final ResourceKey<PlacedFeature> SNOWBELLE = RUPlacedFeatureBootstrap.key("snowbelle");
    public static final ResourceKey<PlacedFeature> BARLEY_SPARSE = RUPlacedFeatureBootstrap.key("barley_sparse");
    public static final ResourceKey<PlacedFeature> BARLEY_DENSE = RUPlacedFeatureBootstrap.key("barley_dense");
    public static final ResourceKey<PlacedFeature> MEADOW_SAGE = RUPlacedFeatureBootstrap.key("meadow_sage");
    public static final ResourceKey<PlacedFeature> REDSTONE_BULB = RUPlacedFeatureBootstrap.key("redstone_bulb");

    public static final ResourceKey<PlacedFeature> ORANGE_CONEFLOWER = RUPlacedFeatureBootstrap.key("orange_coneflower");
    public static final ResourceKey<PlacedFeature> SPARSE_ORANGE_CONEFLOWER = RUPlacedFeatureBootstrap.key("sparse_orange_coneflower");
    public static final ResourceKey<PlacedFeature> PURPLE_CONEFLOWER = RUPlacedFeatureBootstrap.key("purple_coneflower");
    public static final ResourceKey<PlacedFeature> MAGNOLIA_FLOWERS = RUPlacedFeatureBootstrap.key("magnolia_flowers");
    public static final ResourceKey<PlacedFeature> CLOVER_SPARSE = RUPlacedFeatureBootstrap.key("clover_sparse");
    //MULTIFACE FLOWERS
    public static final ResourceKey<PlacedFeature> PINK_MAGNOLIA_FLOWERS = RUPlacedFeatureBootstrap.key("pink_magnolia_flowers");
    public static final ResourceKey<PlacedFeature> WHITE_MAGNOLIA_FLOWERS = RUPlacedFeatureBootstrap.key("white_magnolia_flowers");
    //FOOD_PLANTS
    public static final ResourceKey<PlacedFeature> RARE_SALMONBERRY_BUSH = RUPlacedFeatureBootstrap.key("rare_salmonberry_bush");
    public static final ResourceKey<PlacedFeature> COMMON_SALMONBERRY_BUSH = RUPlacedFeatureBootstrap.key("common_salmonberry_bush");
    public static final ResourceKey<PlacedFeature> DUSKMELON = RUPlacedFeatureBootstrap.key("duskmelon");
    //BIOSHROOM
    public static final ResourceKey<PlacedFeature> BLUE_BIOSHROOM = RUPlacedFeatureBootstrap.key("blue_bioshroom");
    public static final ResourceKey<PlacedFeature> GREEN_BIOSHROOM = RUPlacedFeatureBootstrap.key("green_bioshroom");
    public static final ResourceKey<PlacedFeature> PINK_BIOSHROOM = RUPlacedFeatureBootstrap.key("pink_bioshroom");
    public static final ResourceKey<PlacedFeature> PINK_BIOSHROOM_DENSE = RUPlacedFeatureBootstrap.key("pink_bioshroom_dense");
    //OTHER
    public static final ResourceKey<PlacedFeature> CACTUS_DENSE = RUPlacedFeatureBootstrap.key("cactus_dense");
    public static final ResourceKey<PlacedFeature> BARREL_CACTUS = RUPlacedFeatureBootstrap.key("barrel_cactus");
    public static final ResourceKey<PlacedFeature> BAMBOO = RUPlacedFeatureBootstrap.key("bamboo");
    public static final ResourceKey<PlacedFeature> FLOWERING_LILY = RUPlacedFeatureBootstrap.key("flowering_lily");
    public static final ResourceKey<PlacedFeature> GIANT_LILY = RUPlacedFeatureBootstrap.key("giant_lily");
    public static final ResourceKey<PlacedFeature> ELEPHANT_EAR_SPARSE = RUPlacedFeatureBootstrap.key("elephant_ear_sparse");
    public static final ResourceKey<PlacedFeature> ELEPHANT_EAR_DENSE = RUPlacedFeatureBootstrap.key("elephant_ear_dense");
    public static final ResourceKey<PlacedFeature> DROPLEAF = RUPlacedFeatureBootstrap.key("dropleaf");
    public static final ResourceKey<PlacedFeature> DUCKWEED = RUPlacedFeatureBootstrap.key("duckweed");
    //SHRUBS
    public static final ResourceKey<PlacedFeature> ASHEN_SHRUB = RUPlacedFeatureBootstrap.key("ashen_shrub");
    public static final ResourceKey<PlacedFeature> ACACIA_SHRUB = RUPlacedFeatureBootstrap.key("acacia_shrub");
    public static final ResourceKey<PlacedFeature> BAOBAB_SHRUB = RUPlacedFeatureBootstrap.key("baobab_shrub");
    public static final ResourceKey<PlacedFeature> BIRCH_SHRUB = RUPlacedFeatureBootstrap.key("birch_shrub");
    public static final ResourceKey<PlacedFeature> BLACKWOOD_SHRUB = RUPlacedFeatureBootstrap.key("blackwood_shrub");
    public static final ResourceKey<PlacedFeature> CHERRY_SHRUB = RUPlacedFeatureBootstrap.key("cherry_shrub");
    public static final ResourceKey<PlacedFeature> MAGNOLIA_SHRUB = RUPlacedFeatureBootstrap.key("magnolia_shrub");
    public static final ResourceKey<PlacedFeature> PINK_MAGNOLIA_SHRUB = RUPlacedFeatureBootstrap.key("pink_magnolia_shrub");
    public static final ResourceKey<PlacedFeature> WHITE_MAGNOLIA_SHRUB = RUPlacedFeatureBootstrap.key("white_magnolia_shrub");
    public static final ResourceKey<PlacedFeature> CYPRESS_SHRUB = RUPlacedFeatureBootstrap.key("cypress_shrub");
    public static final ResourceKey<PlacedFeature> DARK_OAK_SHRUB = RUPlacedFeatureBootstrap.key("dark_oak_shrub");
    public static final ResourceKey<PlacedFeature> DEAD_SHRUB = RUPlacedFeatureBootstrap.key("dead_shrub");
    public static final ResourceKey<PlacedFeature> DEAD_PINE_SHRUB = RUPlacedFeatureBootstrap.key("dead_pine_shrub");
    public static final ResourceKey<PlacedFeature> EUCALYPTUS_SHRUB = RUPlacedFeatureBootstrap.key("eucalyptus_shrub");
    public static final ResourceKey<PlacedFeature> FLOWERING_SHRUB = RUPlacedFeatureBootstrap.key("flowering_shrub");
    public static final ResourceKey<PlacedFeature> JOSHUA_SHRUB = RUPlacedFeatureBootstrap.key("joshua_shrub");
    public static final ResourceKey<PlacedFeature> JUNGLE_SHRUB = RUPlacedFeatureBootstrap.key("jungle_shrub");
    public static final ResourceKey<PlacedFeature> LARCH_SHRUB = RUPlacedFeatureBootstrap.key("larch_shrub");
    public static final ResourceKey<PlacedFeature> GOLDEN_LARCH_SHRUB = RUPlacedFeatureBootstrap.key("golden_larch_shrub");
    public static final ResourceKey<PlacedFeature> MANGROVE_SHRUB = RUPlacedFeatureBootstrap.key("mangrove_shrub");
    public static final ResourceKey<PlacedFeature> MAPLE_SHRUB = RUPlacedFeatureBootstrap.key("maple_shrub");
    public static final ResourceKey<PlacedFeature> RED_MAPLE_SHRUB = RUPlacedFeatureBootstrap.key("red_maple_shrub");
    public static final ResourceKey<PlacedFeature> ORANGE_MAPLE_SHRUB = RUPlacedFeatureBootstrap.key("orange_maple_shrub");
    public static final ResourceKey<PlacedFeature> MAUVE_SHRUB = RUPlacedFeatureBootstrap.key("mauve_shrub");
    public static final ResourceKey<PlacedFeature> OAK_SHRUB = RUPlacedFeatureBootstrap.key("oak_shrub");
    public static final ResourceKey<PlacedFeature> PALM_SHRUB = RUPlacedFeatureBootstrap.key("palm_shrub");
    public static final ResourceKey<PlacedFeature> PINE_SHRUB = RUPlacedFeatureBootstrap.key("pine_shrub");
    public static final ResourceKey<PlacedFeature> REDWOOD_SHRUB = RUPlacedFeatureBootstrap.key("redwood_shrub");
    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_SHRUB = RUPlacedFeatureBootstrap.key("silver_birch_shrub");
    public static final ResourceKey<PlacedFeature> SOCOTRA_SHRUB = RUPlacedFeatureBootstrap.key("socotra_shrub");
    public static final ResourceKey<PlacedFeature> SPRUCE_SHRUB = RUPlacedFeatureBootstrap.key("spruce_shrub");
    public static final ResourceKey<PlacedFeature> WILLOW_SHRUB = RUPlacedFeatureBootstrap.key("willow_shrub");
    //mixes
    public static final ResourceKey<PlacedFeature> BAOBAB_ACACIA_SHRUB_MIX = RUPlacedFeatureBootstrap.key("baobab_acacia_shrub_mix");
    public static final ResourceKey<PlacedFeature> AUTUMNAL_SHRUB_MIX = RUPlacedFeatureBootstrap.key("autumnal_shrub_mix");
    public static final ResourceKey<PlacedFeature> BIRCH_SHRUB_MIX = RUPlacedFeatureBootstrap.key("birch_shrub_mix");
    public static final ResourceKey<PlacedFeature> BLACKWOOD_DARK_OAK_SHRUB_MIX = RUPlacedFeatureBootstrap.key("blackwood_dark_oak_shrub_mix");
    public static final ResourceKey<PlacedFeature> MAGNOLIA_SHRUB_MIX = RUPlacedFeatureBootstrap.key("magnolia_shrub_mix");
    public static final ResourceKey<PlacedFeature> DEAD_SHRUB_MIX = RUPlacedFeatureBootstrap.key("dead_shrub_mix");
    public static final ResourceKey<PlacedFeature> LARCH_SHRUB_MIX = RUPlacedFeatureBootstrap.key("larch_shrub_mix");
    public static final ResourceKey<PlacedFeature> GOLDEN_LARCH_SHRUB_MIX = RUPlacedFeatureBootstrap.key("golden_larch_shrub_mix");
    public static final ResourceKey<PlacedFeature> MAPLE_SHRUB_MIX = RUPlacedFeatureBootstrap.key("maple_shrub_mix");
    public static final ResourceKey<PlacedFeature> MAUVE_ENCHANTED_SHRUB_MIX = RUPlacedFeatureBootstrap.key("mauve_enchanted_shrub_mix");
    public static final ResourceKey<PlacedFeature> PALM_JUNGLE_SHRUB_MIX = RUPlacedFeatureBootstrap.key("palm_jungle_shrub_mix");
    public static final ResourceKey<PlacedFeature> PINE_SPRUCE_SHRUB_MIX = RUPlacedFeatureBootstrap.key("pine_spruce_shrub_mix");
    public static final ResourceKey<PlacedFeature> PINE_DEAD_SHRUB_MIX = RUPlacedFeatureBootstrap.key("pine_dead_shrub_mix");
    public static final ResourceKey<PlacedFeature> WILLOW_CYPRESS_SHRUB_MIX = RUPlacedFeatureBootstrap.key("willow_cypress_shrub_mix");
    public static final ResourceKey<PlacedFeature> WILLOW_MAGNOLIA_SHRUB_MIX = RUPlacedFeatureBootstrap.key("willow_magnolia_shrub_mix");

    public static final ResourceKey<PlacedFeature> PRAIRIE_TREES = RUPlacedFeatureBootstrap.key("prairie_trees");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> featureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        //---------------------FEATURES---------------------//
        final Holder<ConfiguredFeature<?, ?>> BLACKWOOD_MUSHROOMS = featureGetter.getOrThrow(RuVegetationFeatures.BLACKWOOD_BIOSHROOMS);
        final Holder<ConfiguredFeature<?, ?>> BLACKWOOD_DECORATION = featureGetter.getOrThrow(RuVegetationFeatures.BLACKWOOD_DECORATION);
        final Holder<ConfiguredFeature<?, ?>> MEADOW_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_MEADOW_VEGETATION);
        //GRASS
        final Holder<ConfiguredFeature<?, ?>> SANDY_GRASS = featureGetter.getOrThrow(RuVegetationFeatures.SANDY_GRASS);
        final Holder<ConfiguredFeature<?, ?>> SNOW_GRASS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_SNOW_GRASS);
        final Holder<ConfiguredFeature<?, ?>> FERNS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_FERNS);
        final Holder<ConfiguredFeature<?, ?>> GRASS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_GRASS);
        final Holder<ConfiguredFeature<?, ?>> TALL_GRASS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_TALL_GRASS);
        final Holder<ConfiguredFeature<?, ?>> WINDSWEPT_GRASS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_WINDSWEPT_GRASS);
        final Holder<ConfiguredFeature<?, ?>> PATCH_GRASS_SPROUTS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_GRASS_SPROUTS);
        final Holder<ConfiguredFeature<?, ?>> BLACKWOOD_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_BLACKWOOD_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> DECIDUOUS_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_DECIDUOUS_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> FEN_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_FEN_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> SHRUBLAND_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_SHRUBLAND_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> MOUNTAIN_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_MOUNTAIN_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> STEPPE_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_STEPPE_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> SOCOTRA_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_SOCOTRA_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> OUTBACK_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_OUTBACK_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> JOSHUA_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_JOSHUA_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> BAYOU_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_BAYOU_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> SANDY_GRASS_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_SANDY_GRASS_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> DIRT_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_DIRT_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> GRASS_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_GRASS_VEGETATION);
        final Holder<ConfiguredFeature<?, ?>> REDSTONE_BUD = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_REDSTONE_BUD);
        final Holder<ConfiguredFeature<?, ?>> PRISMOSS_SPROUT = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_PRISMOSS_SPROUT);
        final Holder<ConfiguredFeature<?, ?>> BLADED_GRASS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_BLADED_GRASS);
        final Holder<ConfiguredFeature<?, ?>> BLADED_GRASS_BONEMEAL = featureGetter.getOrThrow(RuVegetationFeatures.BLADED_GRASS_SINGLE);
       //FLOWERS
        final Holder<ConfiguredFeature<?, ?>> ASTER = featureGetter.getOrThrow(RuVegetationFeatures.ASTER);
        final Holder<ConfiguredFeature<?, ?>> TULIPS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_TULIPS);
        final Holder<ConfiguredFeature<?, ?>> CAVE_HYSSOP = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_CAVE_HYSSOP);
        final Holder<ConfiguredFeature<?, ?>> SMALL_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_SMALL_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> TALL_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_TALL_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> ALPHA_DANDELION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_ALPHA_DANDELION);
        final Holder<ConfiguredFeature<?, ?>> PATCH_ALPHA_ROSE = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_ALPHA_ROSE);
        final Holder<ConfiguredFeature<?, ?>> WILTING_TRILLIUM = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_WILTING_TRILLIUM);
        final Holder<ConfiguredFeature<?, ?>> WHITE_TRILLIUM = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_WHITE_TRILLIUM);
        final Holder<ConfiguredFeature<?, ?>> AZURE_DAISY = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_AZURE_DAISY);
        final Holder<ConfiguredFeature<?, ?>> WARATAH = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_WARATAH);
        final Holder<ConfiguredFeature<?, ?>> DAISY = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_DAISY);
        final Holder<ConfiguredFeature<?, ?>> DAISIES = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_DAISIES);
        final Holder<ConfiguredFeature<?, ?>> PRAIRIE_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_PRAIRIE_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> SHRUBLAND_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_SHRUBLAND_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> WILLOW_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_WILLOW_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> POPPIES = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_POPPIES);
        final Holder<ConfiguredFeature<?, ?>> TASSEL = featureGetter.getOrThrow(RuVegetationFeatures.TASSEL);
        final Holder<ConfiguredFeature<?, ?>> SNOWBELLE = featureGetter.getOrThrow(RuVegetationFeatures.WHITE_SNOWBELLE);
        final Holder<ConfiguredFeature<?, ?>> CORPSE_FLOWER = featureGetter.getOrThrow(RuVegetationFeatures.CORPSE_FLOWER);
        final Holder<ConfiguredFeature<?, ?>> DUSKTRAP = featureGetter.getOrThrow(RuVegetationFeatures.DUSKTRAP);
        final Holder<ConfiguredFeature<?, ?>> DAY_LILY = featureGetter.getOrThrow(RuVegetationFeatures.DAY_LILY);
        final Holder<ConfiguredFeature<?, ?>> TSUBAKI = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_TSUBAKI);
        final Holder<ConfiguredFeature<?, ?>> HIBISCUS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_HIBISCUS);
        final Holder<ConfiguredFeature<?, ?>> MALLOW = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_MALLOW);
        final Holder<ConfiguredFeature<?, ?>> HYSSOP = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_HYSSOP);
        final Holder<ConfiguredFeature<?, ?>> FROZEN_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_FROZEN_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> PINK_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_PINK_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> BARLEY = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_BARLEY);
        final Holder<ConfiguredFeature<?, ?>> MEADOW_SAGE = featureGetter.getOrThrow(RuVegetationFeatures.MEADOW_SAGE);
        final Holder<ConfiguredFeature<?, ?>> REDSTONE_BULB = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_REDSTONE_BULB);

        final Holder<ConfiguredFeature<?, ?>> ORANGE_CONEFLOWER = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_ORANGE_CONEFLOWER);
        final Holder<ConfiguredFeature<?, ?>> PURPLE_CONEFLOWER = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_PURPLE_CONEFLOWER);
        final Holder<ConfiguredFeature<?, ?>> MAGNOLIA_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_MAGNOLIA_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> CLOVER = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_CLOVER);
        //MULTIFACE FLOWERS
        final Holder<ConfiguredFeature<?, ?>> PINK_MAGNOLIA_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.PINK_MAGNOLIA_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> WHITE_MAGNOLIA_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.WHITE_MAGNOLIA_FLOWERS);
        //FOOD_PLANTS
        final Holder<ConfiguredFeature<?, ?>> SALMONBERRY_BUSH = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_SALMONBERRY_BUSH);
        final Holder<ConfiguredFeature<?, ?>> DUSKMELON = featureGetter.getOrThrow(RuVegetationFeatures.DUSKMELON);
        //BIOSHROOM
        final Holder<ConfiguredFeature<?, ?>> BLUE_BIOSHROOM = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_BLUE_BIOSHROOM);
        final Holder<ConfiguredFeature<?, ?>> GREEN_BIOSHROOM = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_GREEN_BIOSHROOM);
        final Holder<ConfiguredFeature<?, ?>> PINK_BIOSHROOM = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_PINK_BIOSHROOM);
        //OTHER
        final Holder<ConfiguredFeature<?, ?>> CACTUS = featureGetter.getOrThrow(VegetationFeatures.PATCH_CACTUS);
        final Holder<ConfiguredFeature<?, ?>> BARREL_CACTUS = featureGetter.getOrThrow(RuVegetationFeatures.BARREL_CACTUS);
        final Holder<ConfiguredFeature<?, ?>> BAMBOO = featureGetter.getOrThrow(RuVegetationFeatures.BAMBOO);
        final Holder<ConfiguredFeature<?, ?>> FLOWERING_LILY = featureGetter.getOrThrow(RuVegetationFeatures.FLOWERING_LILY);
        final Holder<ConfiguredFeature<?, ?>> GIANT_LILY = featureGetter.getOrThrow(RuVegetationFeatures.GIANT_LILY);
        final Holder<ConfiguredFeature<?, ?>> ELEPHANT_EAR = featureGetter.getOrThrow(RuVegetationFeatures.ELEPHANT_EAR);
        final Holder<ConfiguredFeature<?, ?>> DROPLEAF = featureGetter.getOrThrow(RuVegetationFeatures.DROPLEAF);
        final Holder<ConfiguredFeature<?, ?>> DUCKWEED = featureGetter.getOrThrow(RuVegetationFeatures.DUCKWEED);
        //SHRUBS
        final Holder<ConfiguredFeature<?, ?>> ASHEN_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.ASHEN_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> ACACIA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.ACACIA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> BAOBAB_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.BAOBAB_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> BIRCH_SHRUB =  featureGetter.getOrThrow(RuVegetationFeatures.BIRCH_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> BLACKWOOD_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.BLACKWOOD_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> CHERRY_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.CHERRY_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> MAGNOLIA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.MAGNOLIA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> PINK_MAGNOLIA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.PINK_MAGNOLIA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> WHITE_MAGNOLIA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.WHITE_MAGNOLIA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> CYPRESS_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.CYPRESS_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> DARK_OAK_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.DARK_OAK_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> DEAD_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.DEAD_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> DEAD_PINE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.DEAD_PINE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> EUCALYPTUS_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.EUCALYPTUS_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> FLOWERING_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.FLOWERING_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> JOSHUA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.JOSHUA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> JUNGLE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.JUNGLE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> LARCH_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.LARCH_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> GOLDEN_LARCH_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.GOLDEN_LARCH_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> MANGROVE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.MANGROVE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> MAPLE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.MAPLE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> RED_MAPLE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.RED_MAPLE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> ORANGE_MAPLE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.ORANGE_MAPLE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> MAUVE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.MAUVE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> OAK_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.OAK_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> PALM_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.PALM_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> PINE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.PINE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> REDWOOD_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.REDWOOD_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> SILVER_BIRCH_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.SILVER_BIRCH_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> SOCOTRA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.SOCOTRA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> SPRUCE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.SPRUCE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> WILLOW_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.WILLOW_SHRUB);
        //mixes
        final Holder<ConfiguredFeature<?, ?>> BAOBAB_ACACIA_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.BAOBAB_ACACIA_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> AUTUMNAL_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.AUTUMNAL_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> BIRCH_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.BIRCH_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> BLACKWOOD_DARK_OAK_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.BLACKWOOD_DARK_OAK_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> MAGNOLIA_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.MAGNOLIA_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> DEAD_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.DEAD_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> LARCH_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.LARCH_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> GOLDEN_LARCH_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.GOLDEN_LARCH_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> MAPLE_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.MAPLE_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> MAUVE_ENCHANTED_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.MAUVE_ENCHANTED_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> PALM_JUNGLE_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.PALM_JUNGLE_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> PINE_SPRUCE_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.PINE_SPRUCE_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> PINE_DEAD_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.PINE_DEAD_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> WILLOW_CYPRESS_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.WILLOW_CYPRESS_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> WILLOW_MAGNOLIA_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.WILLOW_MAGNOLIA_SHRUB_MIX);

        final Holder<ConfiguredFeature<?, ?>> PRAIRIE_MIX = featureGetter.getOrThrow(RuVegetationFeatures.PRAIRIE_MIX);

        //--------------------PLACEMENTS--------------------//
        register(context, RuVegetationPlacements.PINK_FLOWERS, PINK_FLOWERS, RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.FROZEN_FLOWERS, FROZEN_FLOWERS, RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.BLACKWOOD_MUSHROOMS, BLACKWOOD_MUSHROOMS, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuVegetationPlacements.BLACKWOOD_DECORATION, BLACKWOOD_DECORATION, List.of(CountPlacement.of(8), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuVegetationPlacements.MEADOW_VEGETATION, MEADOW_VEGETATION, NoiseThresholdCountPlacement.of(-0.8D, 5, 8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        //GRASS
        register(context, RuVegetationPlacements.SANDY_GRASS, SANDY_GRASS, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome());
        register(context, RuVegetationPlacements.FERNS, FERNS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.GRASS, GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.CAVE_GRASS, GRASS, List.of(CountOnEveryLayerPlacement.of(70), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE),  BiomeFilter.biome()));
        register(context, RuVegetationPlacements.TALL_GRASS, TALL_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.CAVE_TALL_GRASS, TALL_GRASS, List.of(CountOnEveryLayerPlacement.of(15), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome()));
        register(context, RuVegetationPlacements.SNOW_GRASS, SNOW_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.WINDSWEPT_GRASS, WINDSWEPT_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.PATCH_GRASS_SPROUTS_DENSE, PATCH_GRASS_SPROUTS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.PATCH_GRASS_SPROUTS_SPARSE, PATCH_GRASS_SPROUTS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.PATCH_ASHEN_GRASS, count(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, RUDatagenFeatureUtils.airAndBlocksBelow(RUBlocks.ASHEN_DIRT.get()), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PATCH_ASHEN_GRASS_SMOULDERING, count(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, RUDatagenFeatureUtils.airAndBlocksBelow(RUBlocks.ASHEN_DIRT.get(), Blocks.BASALT, Blocks.SMOOTH_BASALT), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PATCH_ASH_VENTS, count(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, RUDatagenFeatureUtils.airAndBlocksBelow(RUBlocks.ASH.get()), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PATCH_FERNS_DENSE,
            count(20),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            BiomeFilter.biome()
        );
        register(context, RuVegetationPlacements.PATCH_LUPINES,
            new NoiseSlopePlacement(RUNoises.FLOWER_DENSITY, 2, 1, 1, 0),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        );

        register(context, RuVegetationPlacements.BLACKWOOD_VEGETATION, BLACKWOOD_VEGETATION, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.DECIDUOUS_VEGETATION, DECIDUOUS_VEGETATION, NoiseThresholdCountPlacement.of(-0.8D, 5, 24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.FEN_VEGETATION, FEN_VEGETATION, NoiseThresholdCountPlacement.of(-0.8D, 5, 24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.SHRUBLAND_VEGETATION, SHRUBLAND_VEGETATION, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.MOUNTAIN_VEGETATION, MOUNTAIN_VEGETATION, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.OUTBACK_VEGETATION, OUTBACK_VEGETATION, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.JOSHUA_VEGETATION, JOSHUA_VEGETATION, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.STEPPE_VEGETATION, STEPPE_VEGETATION, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.SOCOTRA_VEGETATION, SOCOTRA_VEGETATION, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.SANDY_GRASS_VEGETATION, SANDY_GRASS_VEGETATION, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.BAYOU_VEGETATION, BAYOU_VEGETATION, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 14), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.DIRT_VEGETATION, DIRT_VEGETATION, NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onDirtPredicate), BiomeFilter.biome());
        register(context, RuVegetationPlacements.GRASS_VEGETATION, GRASS_VEGETATION, NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onGrassBlockPredicate), BiomeFilter.biome());
        register(context, RuVegetationPlacements.REDSTONE_BUD, REDSTONE_BUD, List.of(CountPlacement.of(255), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.PRISMOSS_SPROUT, PRISMOSS_SPROUT, List.of(CountOnEveryLayerPlacement.of(25), BiomeFilter.biome()));
        register(context, RuVegetationPlacements.BLADED_GRASS, BLADED_GRASS, CountOnEveryLayerPlacement.of(155), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome());
        //FLOWERS
        register(context, RuVegetationPlacements.ASTER, ASTER, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.TULIPS, TULIPS, List.of(RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.CAVE_HYSSOP, CAVE_HYSSOP, List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
        register(context, RuVegetationPlacements.SMALL_FLOWERS, SMALL_FLOWERS, NoiseThresholdCountPlacement.of(-0.8D, 5, 6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.TALL_FLOWERS, TALL_FLOWERS, RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.ALPHA_DANDELION, ALPHA_DANDELION, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        PlacementModifier airCheck = BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(BlockTags.AIR));
        register(context, RUPlacedFeatures.BONEMEAL_ALPHA_GRASS, featureGetter.getOrThrow(RUConfiguredFeatures.BONEMEAL_ALPHA_GRASS), RarityFilter.onAverageOnceEvery(25), airCheck);
        register(context, RuVegetationPlacements.ALPHA_ROSE, PATCH_ALPHA_ROSE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.WILTING_TRILLIUM, WILTING_TRILLIUM, List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.WHITE_TRILLIUM, WHITE_TRILLIUM, List.of(RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.AZURE_DAISY, AZURE_DAISY, List.of(RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.DAISY, DAISY, List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.WARATAH, WARATAH, List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.DAISIES, DAISIES, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 9), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.PRAIRIE_FLOWERS, PRAIRIE_FLOWERS, List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.SHRUBLAND_FLOWERS, SHRUBLAND_FLOWERS, List.of(RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.WILLOW_FLOWERS, WILLOW_FLOWERS, List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.POPPIES, POPPIES, NoiseThresholdCountPlacement.of(-0.8D, 5, 14), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.TASSEL_SPARSE, TASSEL, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.TASSEL_DENSE, TASSEL, CountPlacement.of(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.SNOWBELLE, SNOWBELLE, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.CORPSE_FLOWER, CORPSE_FLOWER, CountOnEveryLayerPlacement.of(10), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DUSKTRAP, DUSKTRAP, CountOnEveryLayerPlacement.of(4), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DAY_LILY, DAY_LILY, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.TSUBAKI, TSUBAKI, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.HIBISCUS, HIBISCUS, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.MALLOW, MALLOW, List.of(RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.HYSSOP, HYSSOP, List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.BARLEY_SPARSE, BARLEY, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, CountPlacement.of(ClampedInt.of(UniformInt.of(-3, 1), 0, 1)), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BARLEY_DENSE, BARLEY, NoiseBasedCountPlacement.of(155, 75.0D, 0.0D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onGrassBlockPredicate), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MEADOW_SAGE, MEADOW_SAGE, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, RuVegetationPlacements.REDSTONE_BULB, REDSTONE_BULB, List.of(CountPlacement.of(64), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()));

        register(context, RuVegetationPlacements.ORANGE_CONEFLOWER, ORANGE_CONEFLOWER, NoiseThresholdCountPlacement.of(-0.8D, 5, 10), RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.SPARSE_ORANGE_CONEFLOWER, ORANGE_CONEFLOWER, NoiseThresholdCountPlacement.of(-0.8D, 5, 10), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.PURPLE_CONEFLOWER, PURPLE_CONEFLOWER, NoiseThresholdCountPlacement.of(-0.8D, 5, 10), RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.MAGNOLIA_FLOWERS, MAGNOLIA_FLOWERS, NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.PATCH_CLOVERS_DENSE, CLOVER,
            count(3),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome()
        );
        register(context, RuVegetationPlacements.CLOVER_SPARSE, CLOVER, List.of(RarityFilter.onAverageOnceEvery(2),  NoiseThresholdCountPlacement.of(-0.8D, 5, 12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        //MULTIFACE FLOWERS
        register(context, RuVegetationPlacements.PINK_MAGNOLIA_FLOWERS, PINK_MAGNOLIA_FLOWERS, CountPlacement.of(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
        register(context, RuVegetationPlacements.WHITE_MAGNOLIA_FLOWERS, WHITE_MAGNOLIA_FLOWERS, CountPlacement.of(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
        //FOOD_PLANTS
        register(context, RuVegetationPlacements.RARE_SALMONBERRY_BUSH, SALMONBERRY_BUSH, RarityFilter.onAverageOnceEvery(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, RuVegetationPlacements.COMMON_SALMONBERRY_BUSH, SALMONBERRY_BUSH, RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, RuVegetationPlacements.DUSKMELON, DUSKMELON, CountOnEveryLayerPlacement.of(10), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome());
        //BIOSHROOM
        register(context, RuVegetationPlacements.BLUE_BIOSHROOM, BLUE_BIOSHROOM, List.of(CountOnEveryLayerPlacement.of(5), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome()));
        register(context, RuVegetationPlacements.GREEN_BIOSHROOM, GREEN_BIOSHROOM, List.of(CountOnEveryLayerPlacement.of(5), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome()));
        register(context, RuVegetationPlacements.PINK_BIOSHROOM, PINK_BIOSHROOM, List.of(CountOnEveryLayerPlacement.of(2), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome()));
        register(context, RuVegetationPlacements.PINK_BIOSHROOM_DENSE, PINK_BIOSHROOM, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        //OTHER
        register(context, RuVegetationPlacements.CACTUS_DENSE, CACTUS, RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RuVegetationPlacements.BARREL_CACTUS, BARREL_CACTUS, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BAMBOO, BAMBOO, NoiseBasedCountPlacement.of(30, -0.8D, 2.0D), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, RuVegetationPlacements.FLOWERING_LILY, FLOWERING_LILY, List.of(CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.GIANT_LILY, GIANT_LILY, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, RuVegetationPlacements.ELEPHANT_EAR_SPARSE, ELEPHANT_EAR, CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome());
        register(context, RuVegetationPlacements.ELEPHANT_EAR_DENSE, ELEPHANT_EAR, CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DROPLEAF, DROPLEAF, List.of(
            CountPlacement.of(100),
            InSquarePlacement.spread(),
            PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
            EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.matchesTag(BlockTags.AIR), 12),
            RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
            BiomeFilter.biome()
        ));
        register(context, RuVegetationPlacements.DUCKWEED, DUCKWEED, List.of(CountPlacement.of(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        //SHRUBS
        register(context, RuVegetationPlacements.ASHEN_SHRUB, ASHEN_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.ACACIA_SHRUB, ACACIA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BAOBAB_SHRUB, BAOBAB_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BIRCH_SHRUB, BIRCH_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BLACKWOOD_SHRUB, BLACKWOOD_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.CHERRY_SHRUB, CHERRY_SHRUB, RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MAGNOLIA_SHRUB, MAGNOLIA_SHRUB, RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PINK_MAGNOLIA_SHRUB, PINK_MAGNOLIA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.WHITE_MAGNOLIA_SHRUB, WHITE_MAGNOLIA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.CYPRESS_SHRUB, CYPRESS_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DARK_OAK_SHRUB, DARK_OAK_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DEAD_SHRUB, DEAD_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DEAD_PINE_SHRUB, DEAD_PINE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.EUCALYPTUS_SHRUB, EUCALYPTUS_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.FLOWERING_SHRUB, FLOWERING_SHRUB, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.JOSHUA_SHRUB, JOSHUA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.JUNGLE_SHRUB, JUNGLE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.LARCH_SHRUB, LARCH_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.GOLDEN_LARCH_SHRUB, GOLDEN_LARCH_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MANGROVE_SHRUB, MANGROVE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MAPLE_SHRUB, MAPLE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.RED_MAPLE_SHRUB, RED_MAPLE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.ORANGE_MAPLE_SHRUB, ORANGE_MAPLE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MAUVE_SHRUB, MAUVE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.OAK_SHRUB, OAK_SHRUB, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PALM_SHRUB, PALM_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PINE_SHRUB, PINE_SHRUB, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.REDWOOD_SHRUB, REDWOOD_SHRUB,
            count(2),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING),
            BiomeFilter.biome()
        );
        register(context, RuVegetationPlacements.SILVER_BIRCH_SHRUB, SILVER_BIRCH_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.SOCOTRA_SHRUB, SOCOTRA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.SPRUCE_SHRUB, SPRUCE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.WILLOW_SHRUB, WILLOW_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        //mixes
        register(context, RuVegetationPlacements.BAOBAB_ACACIA_SHRUB_MIX, BAOBAB_ACACIA_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.AUTUMNAL_SHRUB_MIX, AUTUMNAL_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BIRCH_SHRUB_MIX, BIRCH_SHRUB_MIX, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BLACKWOOD_DARK_OAK_SHRUB_MIX, BLACKWOOD_DARK_OAK_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MAGNOLIA_SHRUB_MIX, MAGNOLIA_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DEAD_SHRUB_MIX, DEAD_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.LARCH_SHRUB_MIX, LARCH_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.GOLDEN_LARCH_SHRUB_MIX, GOLDEN_LARCH_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MAPLE_SHRUB_MIX, MAPLE_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MAUVE_ENCHANTED_SHRUB_MIX, MAUVE_ENCHANTED_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PALM_JUNGLE_SHRUB_MIX, PALM_JUNGLE_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PINE_SPRUCE_SHRUB_MIX, PINE_SPRUCE_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PINE_DEAD_SHRUB_MIX, PINE_DEAD_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.WILLOW_CYPRESS_SHRUB_MIX, WILLOW_CYPRESS_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.WILLOW_MAGNOLIA_SHRUB_MIX, WILLOW_MAGNOLIA_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());

        register(context, RuVegetationPlacements.PRAIRIE_TREES, PRAIRIE_MIX, NoiseBasedCountPlacement.of(60, 30.0D, -0.5D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onGrassBlockPredicate), BiomeFilter.biome());
        //BONE MEALS
        register(context, RuVegetationPlacements.BLADED_GRASS_BONEMEAL, BLADED_GRASS_BONEMEAL, PlacementUtils.isEmpty());
    }

    protected static PlacementModifier airAnd(BlockPredicate predicate) {
        return BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, predicate));
    }

    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, PlacementModifier... placement) {
        var featureGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, key, featureGetter.getOrThrow(RUConfiguredFeatures.fromPlaced(key)), List.of(placement));
    }

    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placement) {
        register(context, key, feature, List.of(placement));
    }

    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placement) {
        context.register(key, new PlacedFeature(feature, placement));
    }
}
