package net.regions_unexplored.datagen.provider.registry.placed_feature;

import dev.worldgen.lithostitched.worldgen.blockpredicate.RandomChancePredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.datagen.provider.registry.RUPlacedFeatureBootstrap;
import net.regions_unexplored.registry.data.RUConfiguredFeatures;

import java.util.List;

public class RuTreePlacements {
    //-----------------------KEYS-----------------------//
    public static final ResourceKey<PlacedFeature> GIANT_BLUE_BIOSHROOM = key("giant_blue_bioshroom");
    public static final ResourceKey<PlacedFeature> GIANT_GREEN_BIOSHROOM = key("giant_green_bioshroom");
    public static final ResourceKey<PlacedFeature> GIANT_PINK_BIOSHROOM = key("giant_pink_bioshroom");
    public static final ResourceKey<PlacedFeature> GIANT_YELLOW_BIOSHROOM = key("giant_yellow_bioshroom");
    public static final ResourceKey<PlacedFeature> GIANT_RED_MUSHROOM = key("giant_red_mushroom");
    public static final ResourceKey<PlacedFeature> GIANT_BROWN_MUSHROOM = key("giant_brown_mushroom");

    public static final ResourceKey<PlacedFeature> ALPHA = key("alpha");

    public static final ResourceKey<PlacedFeature> ACACIA = key("acacia");
    public static final ResourceKey<PlacedFeature> ACACIA_SHRUB = key("acacia_shrub");

    public static final ResourceKey<PlacedFeature> APPLE_OAK = key("apple_oak");
    public static final ResourceKey<PlacedFeature> BIG_APPLE_OAK = key("big_apple_oak");

    public static final ResourceKey<PlacedFeature> ASHEN = key("ashen");
    public static final ResourceKey<PlacedFeature> ASHEN_PINE = key("ashen_pine");

    public static final ResourceKey<PlacedFeature> BAMBOO = key("bamboo");

    public static final ResourceKey<PlacedFeature> MEGA_BAOBAB = key("mega_baobab");
    public static final ResourceKey<PlacedFeature> ULTRA_BAOBAB = key("ultra_baobab");

    public static final ResourceKey<PlacedFeature> BRIM_WILLOW = key("brim_willow");
    public static final ResourceKey<PlacedFeature> TALL_BRIM_WILLOW = key("tall_brim_willow");

    public static final ResourceKey<PlacedFeature> BLACKWOOD = key("blackwood");
    public static final ResourceKey<PlacedFeature> TALL_BLACKWOOD = key("tall_blackwood");

    public static final ResourceKey<PlacedFeature> CYPRESS = key("cypress");
    public static final ResourceKey<PlacedFeature> TREE_GROUP_OLD_GROWTH_BAYOU = group("old_growth_bayou");
    public static final ResourceKey<PlacedFeature> GIANT_CYPRESS = key("giant_cypress");
    public static final ResourceKey<PlacedFeature> GIANT_CYPRESS_DEEP = key("giant_cypress_deep");

    public static final ResourceKey<PlacedFeature> COBALT = key("cobalt");

    public static final ResourceKey<PlacedFeature> CHERRY = key("cherry");

    public static final ResourceKey<PlacedFeature> DEAD_BOG_RARE = key("dead_bog_rare");
    public static final ResourceKey<PlacedFeature> DEAD_BOG = key("dead_bog");

    public static final ResourceKey<PlacedFeature> DEAD_SCOTTS_PINE = key("dead_scotts_pine");
    public static final ResourceKey<PlacedFeature> DEAD_SCOTTS_PINE_MOUNTAIN = key("dead_scotts_pine_mountain");
    public static final ResourceKey<PlacedFeature> DEAD_SCOTTS_PINE_MOUNTAIN_ON_SNOW = key("dead_scotts_pine_mountain_on_snow");

    public static final ResourceKey<PlacedFeature> BIRCH_ASPEN = key("birch_aspen");

    public static final ResourceKey<PlacedFeature> TALL_DARK_OAK = key("tall_dark_oak");

    public static final ResourceKey<PlacedFeature> SMALL_EUCALYPTUS = key("small_eucalyptus");
    public static final ResourceKey<PlacedFeature> EUCALYPTUS = key("eucalyptus");

    public static final ResourceKey<PlacedFeature> LARGE_JOSHUA = key("large_joshua");
    public static final ResourceKey<PlacedFeature> MEDIUM_JOSHUA = key("medium_joshua");
    public static final ResourceKey<PlacedFeature> JOSHUA_SHRUB = key("joshua_shrub");

    public static final ResourceKey<PlacedFeature> JUNGLE_SPARSE = key("jungle_sparse");
    public static final ResourceKey<PlacedFeature> BIG_JUNGLE_SPARSE = key("big_jungle_sparse");
    public static final ResourceKey<PlacedFeature> JUNGLE_DENSE = key("jungle_dense");
    public static final ResourceKey<PlacedFeature> BIG_JUNGLE_DENSE = key("big_jungle_dense");

    public static final ResourceKey<PlacedFeature> KAPOK_SPARSE = key("kapok_sparse");
    public static final ResourceKey<PlacedFeature> KAPOK_DENSE = key("kapok_dense");

    public static final ResourceKey<PlacedFeature> LARCH_SPARSE = key("larch_sparse");
    public static final ResourceKey<PlacedFeature> LARCH_DENSE = key("larch_dense");
    public static final ResourceKey<PlacedFeature> GOLDEN_LARCH_SPARSE = key("golden_larch_sparse");
    public static final ResourceKey<PlacedFeature> GOLDEN_LARCH_DENSE = key("golden_larch_dense");

    public static final ResourceKey<PlacedFeature> TREE_GROUP_AUTUMNAL_MAPLE_FOREST = group("autumnal_maple_forest");
    public static final ResourceKey<PlacedFeature> TREE_GROUP_PUMPKIN_FIELDS = group("pumpkin_fields");
    public static final ResourceKey<PlacedFeature> MAPLE_DENSE = key("maple_dense");
    public static final ResourceKey<PlacedFeature> MAPLE_SPARSE = key("maple_sparse");
    public static final ResourceKey<PlacedFeature> RED_MAPLE_SPARSE = key("red_maple_sparse");
    public static final ResourceKey<PlacedFeature> BIG_MAPLE_SPARSE = key("big_maple_sparse");
    public static final ResourceKey<PlacedFeature> BIG_RED_MAPLE_SPARSE = key("big_red_maple_sparse");

    public static final ResourceKey<PlacedFeature> MAUVE_MEADOW = key("mauve_meadow");
    public static final ResourceKey<PlacedFeature> MAUVE_SPARSE = key("mauve_sparse");
    public static final ResourceKey<PlacedFeature> MAUVE_DENSE = key("mauve_dense");
    public static final ResourceKey<PlacedFeature> BIG_MAUVE = key("big_mauve");

    public static final ResourceKey<PlacedFeature> BIG_OAK_DENSE = key("big_oak_dense");
    public static final ResourceKey<PlacedFeature> BIG_OAK_SPARSE = key("big_oak_sparse");
    public static final ResourceKey<PlacedFeature> OAK_WITH_BRANCH = key("oak_with_branch");
    public static final ResourceKey<PlacedFeature> OAK_TALL = key("oak_tall");
    public static final ResourceKey<PlacedFeature> SMALL_OAK = key("small_oak");
    public static final ResourceKey<PlacedFeature> OAK_ON_DIRT= key("oak_on_dirt");
    public static final ResourceKey<PlacedFeature> OAK_SHRUB_ON_STONE= key("oak_shrub_on_stone");
    public static final ResourceKey<PlacedFeature> OAK_SHRUB_SPARSE = key("oak_shrub_sparse");
    public static final ResourceKey<PlacedFeature> OAK_SHRUB_DENSE = key("oak_shrub_dense");
    public static final ResourceKey<PlacedFeature> OAK_BUSH_SINGLE = key("oak_bush_single");
    public static final ResourceKey<PlacedFeature> OAK_BUSH_SPARSE = key("oak_bush_sparse");
    public static final ResourceKey<PlacedFeature> OAK_BUSH_DENSE = key("oak_bush_dense");
    public static final ResourceKey<PlacedFeature> OAK_BUSH_WITH_FLOWERS_SPARSE = key("oak_bush_with_flowers_sparse");
    public static final ResourceKey<PlacedFeature> OAK_BUSH_WITH_FLOWERS_DENSE = key("oak_bush_with_flowers_dense");

    public static final ResourceKey<PlacedFeature> PALM_ON_SAND = key("palm_on_sand");
    public static final ResourceKey<PlacedFeature> PALM_SPARSE = key("palm_sparse");
    public static final ResourceKey<PlacedFeature> PALM_DENSE = key("palm_dense");
    public static final ResourceKey<PlacedFeature> PALM_DENSE_TALL = key("palm_dense_tall");
    public static final ResourceKey<PlacedFeature> PALM_SHRUB = key("palm_shrub");

    public static final ResourceKey<PlacedFeature> PINE = key("pine");
    public static final ResourceKey<PlacedFeature> PINE_ON_DIRT = key("pine_on_dirt");
    public static final ResourceKey<PlacedFeature> PINE_TALL_ON_DIRT = key("pine_tall_on_dirt");
    public static final ResourceKey<PlacedFeature> PINE_SHRUB_ON_GRASS = key("pine_shrub_on_grass");
    public static final ResourceKey<PlacedFeature> SCOTTS_PINE_MOUNTAIN = key("scotts_pine_mountain");
    public static final ResourceKey<PlacedFeature> SCOTTS_PINE_ON_SNOW = key("scotts_pine_on_snow");
    public static final ResourceKey<PlacedFeature> SCOTTS_PINE_ON_DIRT = key("scotts_pine_on_dirt");
    public static final ResourceKey<PlacedFeature> SCOTTS_PINE_TALL_ON_SNOW = key("scotts_pine_tall_on_snow");
    public static final ResourceKey<PlacedFeature> SCOTTS_PINE_MOUNTAIN_ON_SNOW = key("scotts_pine_mountain_on_snow");
    public static final ResourceKey<PlacedFeature> PINE_SHRUB_ON_SNOW = key("pine_shrub_on_snow");
    public static final ResourceKey<PlacedFeature> PINE_SHRUB_ON_SNOW_SPARSE = key("pine_shrub_on_snow_sparse");

    public static final ResourceKey<PlacedFeature> LUSH_PINE = key("lush_pine");

    public static final ResourceKey<PlacedFeature> ULTRA_REDWOOD = key("ultra_redwood");
    public static final ResourceKey<PlacedFeature> GIANT_REDWOOD_DENSE = key("giant_redwood_dense");
    public static final ResourceKey<PlacedFeature> GIANT_REDWOOD_SPARSE = key("giant_redwood_sparse");
    public static final ResourceKey<PlacedFeature> REDWOOD = key("redwood");

    public static final ResourceKey<PlacedFeature> MAGNOLIA = key("magnolia");
    public static final ResourceKey<PlacedFeature> BLUE_MAGNOLIA = key("blue_magnolia");
    public static final ResourceKey<PlacedFeature> PINK_MAGNOLIA = key("pink_magnolia");
    public static final ResourceKey<PlacedFeature> WHITE_MAGNOLIA = key("white_magnolia");
    public static final ResourceKey<PlacedFeature> BIG_MAGNOLIA = key("big_magnolia");
    public static final ResourceKey<PlacedFeature> BIG_PINK_MAGNOLIA = key("big_pink_magnolia");
    public static final ResourceKey<PlacedFeature> BIG_WHITE_MAGNOLIA = key("big_white_magnolia");

    public static final ResourceKey<PlacedFeature> SAGUARO_CACTUS = key("saguaro_cactus");

    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_DENSE = key("silver_birch_dense");
    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_SPARSE = key("silver_birch_sparse");
    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_ON_DIRT = key("silver_birch_on_dirt");
    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_ON_GRASS = key("silver_birch_on_grass");
    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_TALL = key("silver_birch_tall");

    public static final ResourceKey<PlacedFeature> LARGE_SOCOTRA = key("large_socotra");
    public static final ResourceKey<PlacedFeature> SMALL_SOCOTRA = key("small_socotra");

    public static final ResourceKey<PlacedFeature> ENCHANTED_BIRCH = key("enchanted_birch");
    public static final ResourceKey<PlacedFeature> ENCHANTED_BIRCH_TALL = key("enchanted_birch_tall");

    public static final ResourceKey<PlacedFeature> SPRUCE_TALL_SPARSE = key("spruce_tall_sparse");
    public static final ResourceKey<PlacedFeature> SPRUCE_TALL_DENSE = key("spruce_tall_dense");
    public static final ResourceKey<PlacedFeature> SPRUCE_TALL_ON_SNOW = key("spruce_tall_on_snow");
    public static final ResourceKey<PlacedFeature> SPRUCE_SHRUB_DENSE = key("spruce_shrub_dense");

    public static final ResourceKey<PlacedFeature> ICE_SPIRE = key("ice_spire");

    public static final ResourceKey<PlacedFeature> WILLOW = key("willow");
    public static final ResourceKey<PlacedFeature> BIG_WILLOW = key("big_willow");
    public static final ResourceKey<PlacedFeature> WILLOW_VINES = key("willow_vines");

    private static ResourceKey<PlacedFeature> group(String name) {
        return key("group/" + name);
    }

    private static ResourceKey<PlacedFeature> key(String name) {
        return RegionsUnexplored.key(Registries.PLACED_FEATURE, "tree/" + name);
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> getter = context.lookup(Registries.CONFIGURED_FEATURE);

        //---------------------FEATURES---------------------//
        final Holder<ConfiguredFeature<?, ?>> GIANT_BLUE_BIOSHROOM = getter.getOrThrow(RUConfiguredFeatures.TREE_GIANT_BLUE_BIOSHROOM);
        final Holder<ConfiguredFeature<?, ?>> GIANT_GREEN_BIOSHROOM = getter.getOrThrow(RUConfiguredFeatures.TREE_GIANT_GREEN_BIOSHROOM);
        final Holder<ConfiguredFeature<?, ?>> GIANT_PINK_BIOSHROOM = getter.getOrThrow(RUConfiguredFeatures.TREE_GIANT_PINK_BIOSHROOM);
        final Holder<ConfiguredFeature<?, ?>> GIANT_YELLOW_BIOSHROOM = getter.getOrThrow(RUConfiguredFeatures.TREE_GIANT_YELLOW_BIOSHROOM);
        final Holder<ConfiguredFeature<?, ?>> GIANT_RED_MUSHROOM = getter.getOrThrow(RUConfiguredFeatures.TREE_GIANT_RED_MUSHROOM);
        final Holder<ConfiguredFeature<?, ?>> GIANT_BROWN_MUSHROOM = getter.getOrThrow(RUConfiguredFeatures.TREE_GIANT_BROWN_MUSHROOM);

        final Holder<ConfiguredFeature<?, ?>> ALPHA = getter.getOrThrow(RUConfiguredFeatures.TREE_ALPHA_OAK);

        final Holder<ConfiguredFeature<?, ?>> ACACIA = getter.getOrThrow(RUConfiguredFeatures.TREE_ACACIA);
        final Holder<ConfiguredFeature<?, ?>> ACACIA_SHRUB = getter.getOrThrow(RUConfiguredFeatures.TREE_ACACIA_SHRUB);

        final Holder<ConfiguredFeature<?, ?>> APPLE_OAK = getter.getOrThrow(RUConfiguredFeatures.TREE_APPLE_OAK);
        final Holder<ConfiguredFeature<?, ?>> BIG_APPLE_OAK = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_APPLE_OAK);

        final Holder<ConfiguredFeature<?, ?>> ASHEN = getter.getOrThrow(RUConfiguredFeatures.TREE_ASHEN);
        final Holder<ConfiguredFeature<?, ?>> ASHEN_PINE = getter.getOrThrow(RUConfiguredFeatures.TREE_ASHEN_PINE);

        final Holder<ConfiguredFeature<?, ?>> TALL_BLACKWOOD = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_BLACKWOOD);
        final Holder<ConfiguredFeature<?, ?>> BLACKWOOD = getter.getOrThrow(RUConfiguredFeatures.TREE_BLACKWOOD);

        final Holder<ConfiguredFeature<?, ?>> BAMBOO = getter.getOrThrow(RUConfiguredFeatures.TREE_BAMBOO);

        final Holder<ConfiguredFeature<?, ?>> MEGA_BAOBAB = getter.getOrThrow(RUConfiguredFeatures.TREE_MEGA_BAOBAB);
        final Holder<ConfiguredFeature<?, ?>> ULTRA_BAOBAB = getter.getOrThrow(RUConfiguredFeatures.TREE_ULTRA_BAOBAB);

        final Holder<ConfiguredFeature<?, ?>> BRIM_WILLOW = getter.getOrThrow(RUConfiguredFeatures.TREE_BRIM_WILLOW);
        final Holder<ConfiguredFeature<?, ?>> TALL_BRIM_WILLOW = getter.getOrThrow(RUConfiguredFeatures.TREE_TALL_BRIM_WILLOW);

        final Holder<ConfiguredFeature<?, ?>> BIRCH_ASPEN = getter.getOrThrow(RUConfiguredFeatures.TREE_BIRCH_ASPEN);

        final Holder<ConfiguredFeature<?, ?>> CYPRESS = getter.getOrThrow(RUConfiguredFeatures.TREE_CYPRESS);
        final Holder<ConfiguredFeature<?, ?>> GIANT_CYPRESS = getter.getOrThrow(RUConfiguredFeatures.TREE_GIANT_CYPRESS);

        final Holder<ConfiguredFeature<?, ?>> COBALT = getter.getOrThrow(RUConfiguredFeatures.TREE_COBALT);

        final Holder<ConfiguredFeature<?, ?>> CHERRY = getter.getOrThrow(RUConfiguredFeatures.TREE_CHERRY);

        final Holder<ConfiguredFeature<?, ?>> DEAD_BOG = getter.getOrThrow(RUConfiguredFeatures.TREE_DEAD_BOG);

        final Holder<ConfiguredFeature<?, ?>> DEAD_SCOTTS_PINE = getter.getOrThrow(RUConfiguredFeatures.TREE_DEAD_STRIPPED_PINE);
        final Holder<ConfiguredFeature<?, ?>> DEAD_SCOTTS_PINE_MOUNTAIN = getter.getOrThrow(RUConfiguredFeatures.TREE_DEAD_STRIPPED_PINE_MOUNTAIN);

        final Holder<ConfiguredFeature<?, ?>> TALL_DARK_OAK = getter.getOrThrow(RUConfiguredFeatures.TREE_TALL_DARK_OAK);

        final Holder<ConfiguredFeature<?, ?>> SMALL_EUCALYPTUS = getter.getOrThrow(RUConfiguredFeatures.TREE_SMALL_EUCALYPTUS);
        final Holder<ConfiguredFeature<?, ?>> EUCALYPTUS = getter.getOrThrow(RUConfiguredFeatures.TREE_EUCALYPTUS);

        final Holder<ConfiguredFeature<?, ?>> LARGE_JOSHUA = getter.getOrThrow(RUConfiguredFeatures.TREE_LARGE_JOSHUA);
        final Holder<ConfiguredFeature<?, ?>> MEDIUM_JOSHUA = getter.getOrThrow(RUConfiguredFeatures.TREE_MEDIUM_JOSHUA);
        final Holder<ConfiguredFeature<?, ?>> JOSHUA_SHRUB = getter.getOrThrow(RUConfiguredFeatures.TREE_JOSHUA_SHRUB);

        final Holder<ConfiguredFeature<?, ?>> JUNGLE = getter.getOrThrow(RUConfiguredFeatures.TREE_JUNGLE);
        final Holder<ConfiguredFeature<?, ?>> BIG_JUNGLE = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_JUNGLE);

        final Holder<ConfiguredFeature<?, ?>> KAPOK = getter.getOrThrow(RUConfiguredFeatures.TREE_KAPOK);

        final Holder<ConfiguredFeature<?, ?>> LARCH = getter.getOrThrow(RUConfiguredFeatures.TREE_LARCH);
        final Holder<ConfiguredFeature<?, ?>> GOLDEN_LARCH = getter.getOrThrow(RUConfiguredFeatures.TREE_GOLDEN_LARCH);

        final Holder<ConfiguredFeature<?, ?>> MAPLE = getter.getOrThrow(RUConfiguredFeatures.TREE_MAPLE);
        final Holder<ConfiguredFeature<?, ?>> BIG_MAPLE = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_MAPLE);
        final Holder<ConfiguredFeature<?, ?>> RED_MAPLE = getter.getOrThrow(RUConfiguredFeatures.TREE_RED_MAPLE);
        final Holder<ConfiguredFeature<?, ?>> BIG_RED_MAPLE = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_RED_MAPLE);
        final Holder<ConfiguredFeature<?, ?>> ORANGE_MAPLE = getter.getOrThrow(RUConfiguredFeatures.TREE_ORANGE_MAPLE);
        final Holder<ConfiguredFeature<?, ?>> BIG_ORANGE_MAPLE = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_ORANGE_MAPLE);

        final Holder<ConfiguredFeature<?, ?>> MAUVE = getter.getOrThrow(RUConfiguredFeatures.TREE_MAUVE_OAK);
        final Holder<ConfiguredFeature<?, ?>> BIG_MAUVE = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_MAUVE_OAK);

        final Holder<ConfiguredFeature<?, ?>> BIG_OAK = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_OAK);
        final Holder<ConfiguredFeature<?, ?>> SMALL_OAK = getter.getOrThrow(RUConfiguredFeatures.TREE_SMALL_OAK);
        final Holder<ConfiguredFeature<?, ?>> OAK_WITH_BRANCH = getter.getOrThrow(RUConfiguredFeatures.TREE_OAK_WITH_BRANCH);
        final Holder<ConfiguredFeature<?, ?>> OAK = getter.getOrThrow(RUConfiguredFeatures.TREE_OAK);
        final Holder<ConfiguredFeature<?, ?>> OAK_TALL = getter.getOrThrow(RUConfiguredFeatures.TREE_OAK_TALL);
        final Holder<ConfiguredFeature<?, ?>> OAK_SHRUB = getter.getOrThrow(RUConfiguredFeatures.TREE_OAK_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> OAK_BUSH_WITH_FLOWERS = getter.getOrThrow(RUConfiguredFeatures.TREE_OAK_BUSH_WITH_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> OAK_BUSH = getter.getOrThrow(RUConfiguredFeatures.TREE_OAK_BUSH);

        final Holder<ConfiguredFeature<?, ?>> PALM = getter.getOrThrow(RUConfiguredFeatures.TREE_PALM);
        final Holder<ConfiguredFeature<?, ?>> PALM_TALL = getter.getOrThrow(RUConfiguredFeatures.TREE_TALL_PALM);
        final Holder<ConfiguredFeature<?, ?>> PALM_SHRUB = getter.getOrThrow(RUConfiguredFeatures.TREE_PALM_SHRUB);

        final Holder<ConfiguredFeature<?, ?>> PINE = getter.getOrThrow(RUConfiguredFeatures.TREE_PINE);
        final Holder<ConfiguredFeature<?, ?>> PINE_TALL = getter.getOrThrow(RUConfiguredFeatures.TREE_PINE_TALL);
        final Holder<ConfiguredFeature<?, ?>> SCOTTS_PINE = getter.getOrThrow(RUConfiguredFeatures.TREE_STRIPPED_PINE);
        final Holder<ConfiguredFeature<?, ?>> SCOTTS_PINE_TALL = getter.getOrThrow(RUConfiguredFeatures.TREE_STRIPPED_PINE_TALL);
        final Holder<ConfiguredFeature<?, ?>> SCOTTS_PINE_MOUNTAIN = getter.getOrThrow(RUConfiguredFeatures.TREE_STRIPPED_PINE_MOUNTAIN);
        final Holder<ConfiguredFeature<?, ?>> PINE_SHRUB = getter.getOrThrow(RUConfiguredFeatures.TREE_PINE_SHRUB);

        final Holder<ConfiguredFeature<?, ?>> LUSH_PINE = getter.getOrThrow(RUConfiguredFeatures.TREE_LUSH_PINE);

        final Holder<ConfiguredFeature<?, ?>> ULTRA_REDWOOD = getter.getOrThrow(RUConfiguredFeatures.TREE_ULTRA_REDWOOD);
        final Holder<ConfiguredFeature<?, ?>> GIANT_REDWOOD = getter.getOrThrow(RUConfiguredFeatures.TREE_GIANT_REDWOOD);
        final Holder<ConfiguredFeature<?, ?>> REDWOOD = getter.getOrThrow(RUConfiguredFeatures.TREE_REDWOOD);

        final Holder<ConfiguredFeature<?, ?>> MAGNOLIA = getter.getOrThrow(RUConfiguredFeatures.TREE_MAGNOLIA);
        final Holder<ConfiguredFeature<?, ?>> BLUE_MAGNOLIA = getter.getOrThrow(RUConfiguredFeatures.TREE_BLUE_MAGNOLIA);
        final Holder<ConfiguredFeature<?, ?>> PINK_MAGNOLIA = getter.getOrThrow(RUConfiguredFeatures.TREE_PINK_MAGNOLIA);
        final Holder<ConfiguredFeature<?, ?>> WHITE_MAGNOLIA = getter.getOrThrow(RUConfiguredFeatures.TREE_WHITE_MAGNOLIA);
        final Holder<ConfiguredFeature<?, ?>> BIG_MAGNOLIA = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_MAGNOLIA);
        final Holder<ConfiguredFeature<?, ?>> PINK_BIG_MAGNOLIA = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_PINK_MAGNOLIA);
        final Holder<ConfiguredFeature<?, ?>> WHITE_BIG_MAGNOLIA = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_WHITE_MAGNOLIA);

        final Holder<ConfiguredFeature<?, ?>> SAGUARO_CACTUS = getter.getOrThrow(RUConfiguredFeatures.TREE_SAGUARO_CACTUS);

        final Holder<ConfiguredFeature<?, ?>> SPRUCE_TALL = getter.getOrThrow(RUConfiguredFeatures.TREE_SPRUCE_TALL);
        final Holder<ConfiguredFeature<?, ?>> SPRUCE_SHRUB = getter.getOrThrow(RUConfiguredFeatures.TREE_SPRUCE_SHRUB);

        final Holder<ConfiguredFeature<?, ?>> LARGE_SOCOTRA = getter.getOrThrow(RUConfiguredFeatures.TREE_LARGE_SOCOTRA);
        final Holder<ConfiguredFeature<?, ?>> SMALL_SOCOTRA = getter.getOrThrow(RUConfiguredFeatures.TREE_SMALL_SOCOTRA);

        final Holder<ConfiguredFeature<?, ?>> ICE_SPIRE = getter.getOrThrow(RUConfiguredFeatures.TREE_ICE_SPIRE);

        final Holder<ConfiguredFeature<?, ?>> SILVER_BIRCH = getter.getOrThrow(RUConfiguredFeatures.TREE_SILVER_BIRCH);
        final Holder<ConfiguredFeature<?, ?>> SILVER_BIRCH_TALL = getter.getOrThrow(RUConfiguredFeatures.TREE_SILVER_BIRCH_TALL);

        final Holder<ConfiguredFeature<?, ?>> ENCHANTED_BIRCH = getter.getOrThrow(RUConfiguredFeatures.TREE_ENCHANTED_BIRCH);
        final Holder<ConfiguredFeature<?, ?>> ENCHANTED_BIRCH_TALL = getter.getOrThrow(RUConfiguredFeatures.TREE_ENCHANTED_BIRCH_TALL);

        final Holder<ConfiguredFeature<?, ?>> WILLOW = getter.getOrThrow(RUConfiguredFeatures.TREE_WILLOW);
        final Holder<ConfiguredFeature<?, ?>> BIG_WILLOW = getter.getOrThrow(RUConfiguredFeatures.TREE_BIG_WILLOW);
        final Holder<ConfiguredFeature<?, ?>> WILLOW_VINES = getter.getOrThrow(RUConfiguredFeatures.TREE_WILLOW_VINES);
        //--------------------PLACEMENTS--------------------//
        register(context, RuTreePlacements.GIANT_BLUE_BIOSHROOM, GIANT_BLUE_BIOSHROOM, List.of(CountOnEveryLayerPlacement.of(3), BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onViridescentNyliumPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.GIANT_GREEN_BIOSHROOM, GIANT_GREEN_BIOSHROOM, List.of(CountOnEveryLayerPlacement.of(3), BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onViridescentNyliumPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.GIANT_PINK_BIOSHROOM, GIANT_PINK_BIOSHROOM, List.of(PlacementUtils.countExtra(1, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.GIANT_YELLOW_BIOSHROOM, GIANT_YELLOW_BIOSHROOM, CountOnEveryLayerPlacement.of(3), PlacementUtils.filteredByBlockSurvival(Blocks.CRIMSON_ROOTS), BiomeFilter.biome());
        register(context, RuTreePlacements.GIANT_RED_MUSHROOM, GIANT_RED_MUSHROOM, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.GIANT_BROWN_MUSHROOM, GIANT_BROWN_MUSHROOM, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.ALPHA, ALPHA, List.of(CountPlacement.of(7), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.ACACIA, ACACIA, List.of(PlacementUtils.countExtra(1, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.ACACIA_SHRUB, ACACIA_SHRUB, List.of(CountPlacement.of(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.APPLE_OAK, APPLE_OAK, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_APPLE_OAK, BIG_APPLE_OAK, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.ASHEN, ASHEN, List.of(CountPlacement.of(8), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING),BiomeFilter.biome()));
        register(context, RuTreePlacements.ASHEN_PINE, ASHEN_PINE,   List.of(CountPlacement.of(10), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.BAMBOO, BAMBOO, List.of(CountPlacement.of(15), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.MEGA_BAOBAB, MEGA_BAOBAB, List.of(PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.ULTRA_BAOBAB, ULTRA_BAOBAB, List.of(PlacementUtils.countExtra(1, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.BRIM_WILLOW, BRIM_WILLOW, CountOnEveryLayerPlacement.of(2),  BiomeFilter.biome());
        register(context, RuTreePlacements.TALL_BRIM_WILLOW, TALL_BRIM_WILLOW, CountOnEveryLayerPlacement.of(2),  BiomeFilter.biome());

        register(context, RuTreePlacements.BIRCH_ASPEN, BIRCH_ASPEN, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.TALL_BLACKWOOD, TALL_BLACKWOOD, List.of(CountPlacement.of(6), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BLACKWOOD, BLACKWOOD, List.of(CountPlacement.of(8), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.CYPRESS, CYPRESS, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(1), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.TREE_GROUP_OLD_GROWTH_BAYOU, get(getter, RUConfiguredFeatures.TREE_GROUP_OLD_GROWTH_BAYOU), List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.GIANT_CYPRESS, GIANT_CYPRESS, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(1), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.GIANT_CYPRESS_DEEP, GIANT_CYPRESS,   List.of(CountPlacement.of(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.COBALT, COBALT, CountOnEveryLayerPlacement.of(1), PlacementUtils.filteredByBlockSurvival(RUBlocks.COBALT_EARLIGHT.get()),  BiomeFilter.biome());

        register(context, RuTreePlacements.CHERRY, CHERRY, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(3), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.DEAD_BOG_RARE, DEAD_BOG, List.of(PlacementUtils.countExtra(0, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.DEAD_BOG, DEAD_BOG, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.DEAD_SCOTTS_PINE, DEAD_SCOTTS_PINE, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.DEAD_SCOTTS_PINE_MOUNTAIN, DEAD_SCOTTS_PINE_MOUNTAIN, List.of(PlacementUtils.countExtra(0, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.DEAD_SCOTTS_PINE_MOUNTAIN_ON_SNOW, DEAD_SCOTTS_PINE_MOUNTAIN, List.of(PlacementUtils.countExtra(0, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));

        register(context, RuTreePlacements.TALL_DARK_OAK, TALL_DARK_OAK, List.of(CountPlacement.of(7), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.SMALL_EUCALYPTUS, SMALL_EUCALYPTUS, List.of(CountPlacement.of(9), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.EUCALYPTUS, EUCALYPTUS, List.of(CountPlacement.of(9), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.LARGE_JOSHUA, LARGE_JOSHUA, List.of(PlacementUtils.countExtra(0, 0.1F, 3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(RUBlocks.SMALL_DESERT_SHRUB.get()), BiomeFilter.biome()));
        register(context, RuTreePlacements.MEDIUM_JOSHUA, MEDIUM_JOSHUA, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(RUBlocks.SMALL_DESERT_SHRUB.get()), BiomeFilter.biome()));
        register(context, RuTreePlacements.JOSHUA_SHRUB, JOSHUA_SHRUB, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(RUBlocks.SMALL_DESERT_SHRUB.get()), BiomeFilter.biome()));

        register(context, RuTreePlacements.JUNGLE_SPARSE, JUNGLE, List.of(NoiseBasedCountPlacement.of(2, 55.0D, 0.0D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_JUNGLE_SPARSE, BIG_JUNGLE, List.of(NoiseBasedCountPlacement.of(2, 50.0D, 0.0D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.JUNGLE_DENSE, JUNGLE, List.of(CountPlacement.of(12), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_JUNGLE_DENSE, BIG_JUNGLE, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.KAPOK_SPARSE, KAPOK, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.KAPOK_DENSE, KAPOK, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.LARCH_DENSE, LARCH, List.of(CountPlacement.of(7), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.LARCH_SPARSE, LARCH, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.GOLDEN_LARCH_DENSE, GOLDEN_LARCH, List.of(CountPlacement.of(7), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.GOLDEN_LARCH_SPARSE, GOLDEN_LARCH, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.TREE_GROUP_AUTUMNAL_MAPLE_FOREST, get(getter, RUConfiguredFeatures.TREE_GROUP_AUTUMNAL_MAPLE_FOREST), List.of(
            NoiseThresholdCountPlacement.of(0, 5, 8),
            InSquarePlacement.spread(),
            SurfaceWaterDepthFilter.forMaxDepth(0),
            PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
            BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                saplingWouldSurvive(RUBlocks.MAPLE_NATURAL_SET),
                RUPlacedFeatureBootstrap.onGrassBlockPredicate
            )),
            BiomeFilter.biome()
        ));
        register(context, RuTreePlacements.TREE_GROUP_PUMPKIN_FIELDS, get(getter, RUConfiguredFeatures.TREE_GROUP_PUMPKIN_FIELDS), List.of(
            CountPlacement.of(6),
            InSquarePlacement.spread(),
            SurfaceWaterDepthFilter.forMaxDepth(0),
            PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
            BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                saplingWouldSurvive(RUBlocks.MAPLE_NATURAL_SET),
                BlockPredicate.anyOf(
                    RUPlacedFeatureBootstrap.onGrassBlockPredicate,
                    new RandomChancePredicate(0.02f)
                )
            )),
            BiomeFilter.biome()
        ));
        register(context, RuTreePlacements.MAPLE_DENSE, MAPLE, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.MAPLE_SPARSE, MAPLE, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.RED_MAPLE_SPARSE, RED_MAPLE, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_MAPLE_SPARSE, BIG_MAPLE, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_RED_MAPLE_SPARSE, BIG_RED_MAPLE, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.MAUVE_MEADOW, MAUVE, NoiseBasedCountPlacement.of(70, 25.0D, -0.7D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuTreePlacements.MAUVE_SPARSE, MAUVE,   List.of(PlacementUtils.countExtra(0, 0.1F, 2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.MAUVE_DENSE, MAUVE, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_MAUVE, BIG_MAUVE, List.of(CountPlacement.of(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.BIG_OAK_DENSE, BIG_OAK, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_OAK_SPARSE, BIG_OAK, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_TALL, OAK_TALL, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.SMALL_OAK, SMALL_OAK, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_WITH_BRANCH, OAK_WITH_BRANCH, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_ON_DIRT, OAK, List.of(CountPlacement.of(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onDirtPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_SHRUB_ON_STONE, OAK_SHRUB, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(RUBlocks.STONE_BUD.get()), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_SHRUB_SPARSE, OAK_SHRUB, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_SHRUB_DENSE, OAK_SHRUB, List.of(CountPlacement.of(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_BUSH_SINGLE, OAK_BUSH, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_BUSH_SPARSE, OAK_BUSH, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_BUSH_DENSE, OAK_BUSH, List.of(CountPlacement.of(8), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_BUSH_WITH_FLOWERS_SPARSE, OAK_BUSH_WITH_FLOWERS, List.of(CountPlacement.of(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.OAK_BUSH_WITH_FLOWERS_DENSE, OAK_BUSH_WITH_FLOWERS, List.of(CountPlacement.of(7), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.PALM_ON_SAND, PALM, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(RUBlocks.SANDY_GRASS.get()), BiomeFilter.biome()));
        register(context, RuTreePlacements.PALM_SPARSE, PALM, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.PALM_DENSE, PALM, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.PALM_DENSE_TALL, PALM_TALL, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.PALM_SHRUB, PALM_SHRUB, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.PINE, PINE, List.of(CountPlacement.of(6), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.PINE_ON_DIRT, PINE, List.of(CountPlacement.of(13), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onDirtPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.PINE_TALL_ON_DIRT, PINE_TALL, List.of(CountPlacement.of(5), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onDirtPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.SCOTTS_PINE_ON_DIRT, SCOTTS_PINE, List.of(CountPlacement.of(11), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onDirtPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.SCOTTS_PINE_MOUNTAIN, SCOTTS_PINE_MOUNTAIN, List.of(PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.PINE_SHRUB_ON_GRASS, PINE_SHRUB, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onGrassBlockPredicate), BiomeFilter.biome()));

        register(context, RuTreePlacements.SCOTTS_PINE_ON_SNOW, SCOTTS_PINE, List.of(CountPlacement.of(9), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.SCOTTS_PINE_TALL_ON_SNOW, SCOTTS_PINE_TALL, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.SCOTTS_PINE_MOUNTAIN_ON_SNOW, SCOTTS_PINE_MOUNTAIN, List.of(PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.PINE_SHRUB_ON_SNOW, PINE_SHRUB, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.PINE_SHRUB_ON_SNOW_SPARSE, PINE_SHRUB, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));

        register(context, RuTreePlacements.LUSH_PINE, LUSH_PINE, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.ULTRA_REDWOOD, ULTRA_REDWOOD, List.of(NoiseBasedCountPlacement.of(1, 80.0D, 0.3D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.GIANT_REDWOOD_DENSE, GIANT_REDWOOD, List.of(CountPlacement.of(6), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.GIANT_REDWOOD_SPARSE, GIANT_REDWOOD, List.of(NoiseBasedCountPlacement.of(1, 80.0D, 0.3D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.REDWOOD, REDWOOD, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.MAGNOLIA, MAGNOLIA, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BLUE_MAGNOLIA, BLUE_MAGNOLIA, List.of(PlacementUtils.countExtra(1, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.PINK_MAGNOLIA, PINK_MAGNOLIA, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.WHITE_MAGNOLIA, WHITE_MAGNOLIA, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_MAGNOLIA, BIG_MAGNOLIA, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_PINK_MAGNOLIA, PINK_BIG_MAGNOLIA, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_WHITE_MAGNOLIA, WHITE_BIG_MAGNOLIA, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.SAGUARO_CACTUS, SAGUARO_CACTUS, List.of(NoiseBasedCountPlacement.of(1, 75.0D, 0.0D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(RUBlocks.SANDY_GRASS.get()), BiomeFilter.biome()));

        register(context, RuTreePlacements.SPRUCE_TALL_SPARSE, SPRUCE_TALL, List.of(PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.SPRUCE_TALL_DENSE, SPRUCE_TALL, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.SPRUCE_TALL_ON_SNOW, SPRUCE_TALL, List.of(CountPlacement.of(4), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.SPRUCE_SHRUB_DENSE, SPRUCE_SHRUB, List.of(CountPlacement.of(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.ICE_SPIRE, ICE_SPIRE, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onSnowPredicate), BiomeFilter.biome()));

        register(context, RuTreePlacements.SILVER_BIRCH_DENSE, SILVER_BIRCH, List.of(CountPlacement.of(6), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.SILVER_BIRCH_SPARSE, SILVER_BIRCH, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.SILVER_BIRCH_ON_DIRT, SILVER_BIRCH, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onDirtPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.SILVER_BIRCH_ON_GRASS, SILVER_BIRCH, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(RUPlacedFeatureBootstrap.onGrassBlockPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.SILVER_BIRCH_TALL, SILVER_BIRCH_TALL, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.LARGE_SOCOTRA, LARGE_SOCOTRA, List.of(NoiseBasedCountPlacement.of(1, 70.0D, 0.0D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.SMALL_SOCOTRA, SMALL_SOCOTRA, List.of(PlacementUtils.countExtra(1, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.ENCHANTED_BIRCH, ENCHANTED_BIRCH, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.ENCHANTED_BIRCH_TALL, ENCHANTED_BIRCH_TALL, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.WILLOW, WILLOW, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.BIG_WILLOW, BIG_WILLOW, List.of(CountPlacement.of(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.WILLOW_VINES, WILLOW_VINES, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(3), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
    }

    private static BlockPredicate saplingWouldSurvive(NaturalSet set) {
        return BlockPredicate.wouldSurvive(set.getSapling().defaultBlockState(), Vec3i.ZERO);
    }

    private static Holder.Reference<ConfiguredFeature<?, ?>> get(HolderGetter<ConfiguredFeature<?, ?>> getter, ResourceKey<ConfiguredFeature<?, ?>> key) {
        return getter.getOrThrow(key);
    }

    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placement) {
        register(context, key, feature, List.of(placement));
    }

    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placement) {
        context.register(key, new PlacedFeature(feature, placement));
    }
}