package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.RegionsUnexplored;

public interface RUConfiguredFeatures {
    // Trees
    ResourceKey<ConfiguredFeature<?,?>> TREE_GIANT_BLUE_BIOSHROOM = tree("giant_blue_bioshroom");
    ResourceKey<ConfiguredFeature<?,?>> TREE_GIANT_GREEN_BIOSHROOM = tree("giant_green_bioshroom");
    ResourceKey<ConfiguredFeature<?,?>> TREE_GIANT_PINK_BIOSHROOM = tree("giant_pink_bioshroom");
    ResourceKey<ConfiguredFeature<?,?>> TREE_GIANT_YELLOW_BIOSHROOM = tree("giant_yellow_bioshroom");
    ResourceKey<ConfiguredFeature<?,?>> TREE_GIANT_RED_MUSHROOM = tree("giant_red_mushroom");
    ResourceKey<ConfiguredFeature<?,?>> TREE_GIANT_BROWN_MUSHROOM = tree("giant_brown_mushroom");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BRIM_WILLOW = tree("brim_willow");
    ResourceKey<ConfiguredFeature<?,?>> TREE_TALL_BRIM_WILLOW = tree("tall_brim_willow");
    ResourceKey<ConfiguredFeature<?,?>> TREE_ACACIA = tree("acacia");
    ResourceKey<ConfiguredFeature<?,?>> TREE_ACACIA_SHRUB = tree("acacia_shrub");
    ResourceKey<ConfiguredFeature<?,?>> TREE_ALPHA_OAK = tree("alpha_oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_ASHEN = tree("ashen");
    ResourceKey<ConfiguredFeature<?,?>> TREE_ASHEN_PINE = tree("ashen_pine");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BAMBOO = tree("bamboo");
    ResourceKey<ConfiguredFeature<?,?>> TREE_MEGA_BAOBAB = tree("mega_baobab");
    ResourceKey<ConfiguredFeature<?,?>> TREE_ULTRA_BAOBAB = tree("ultra_baobab");
    ResourceKey<ConfiguredFeature<?,?>> TREE_FLOWERING_OAK = tree("flowering_oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_FLOWERING_OAK = tree("big_flowering_oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_APPLE_OAK = tree("apple_oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_APPLE_OAK = tree("big_apple_oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BLACKWOOD = tree("blackwood");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_BLACKWOOD = tree("big_blackwood");
    ResourceKey<ConfiguredFeature<?,?>> TREE_GIANT_BLACKWOOD = tree("giant_blackwood");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIRCH_ASPEN = tree("birch_aspen");
    ResourceKey<ConfiguredFeature<?,?>> TREE_COBALT = tree("cobalt");
    ResourceKey<ConfiguredFeature<?,?>> TREE_TALL_DARK_OAK = tree("tall_dark_oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_MAGNOLIA = tree("magnolia");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BLUE_MAGNOLIA = tree("blue_magnolia");
    ResourceKey<ConfiguredFeature<?,?>> TREE_PINK_MAGNOLIA = tree("pink_magnolia");
    ResourceKey<ConfiguredFeature<?,?>> TREE_WHITE_MAGNOLIA = tree("white_magnolia");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_MAGNOLIA = tree("big_magnolia");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_BLUE_MAGNOLIA = tree("big_blue_magnolia");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_PINK_MAGNOLIA = tree("big_pink_magnolia");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_WHITE_MAGNOLIA = tree("big_white_magnolia");
    ResourceKey<ConfiguredFeature<?,?>> TREE_CYPRESS = tree("cypress");
    ResourceKey<ConfiguredFeature<?,?>> TREE_GIANT_CYPRESS = tree("giant_cypress");
    ResourceKey<ConfiguredFeature<?,?>> TREE_CHERRY = tree("cherry");
    ResourceKey<ConfiguredFeature<?,?>> TREE_DEAD_BOG = tree("dead_bog");
    ResourceKey<ConfiguredFeature<?,?>> TREE_DEAD = tree("dead");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_DEAD = tree("big_dead");
    ResourceKey<ConfiguredFeature<?,?>> TREE_DEAD_PINE = tree("dead_pine");
    ResourceKey<ConfiguredFeature<?,?>> TREE_DEAD_PINE_TALL = tree("dead_pine_tall");
    ResourceKey<ConfiguredFeature<?,?>> TREE_DEAD_STRIPPED_PINE = tree("dead_stripped_pine");
    ResourceKey<ConfiguredFeature<?,?>> TREE_DEAD_STRIPPED_PINE_TALL = tree("dead_stripped_pine_tall");
    ResourceKey<ConfiguredFeature<?,?>> TREE_DEAD_STRIPPED_PINE_MOUNTAIN = tree("dead_stripped_pine_mountain");
    ResourceKey<ConfiguredFeature<?,?>> TREE_SMALL_EUCALYPTUS = tree("small_eucalyptus");
    ResourceKey<ConfiguredFeature<?,?>> TREE_EUCALYPTUS = tree("eucalyptus");
    ResourceKey<ConfiguredFeature<?,?>> TREE_LARGE_JOSHUA = tree("large_joshua");
    ResourceKey<ConfiguredFeature<?,?>> TREE_MEDIUM_JOSHUA = tree("medium_joshua");
    ResourceKey<ConfiguredFeature<?,?>> TREE_JOSHUA_SHRUB = tree("joshua_shrub");
    ResourceKey<ConfiguredFeature<?,?>> TREE_JUNGLE = tree("jungle");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_JUNGLE = tree("big_jungle");
    ResourceKey<ConfiguredFeature<?,?>> TREE_KAPOK = tree("kapok");
    ResourceKey<ConfiguredFeature<?,?>> TREE_LARCH = tree("larch");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_LARCH = tree("big_larch");
    ResourceKey<ConfiguredFeature<?,?>> TREE_GOLDEN_LARCH = tree("larch_golden");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_GOLDEN_LARCH = tree("big_golden_larch");
    ResourceKey<ConfiguredFeature<?,?>> TREE_MAPLE = tree("maple");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_MAPLE = tree("big_maple");
    ResourceKey<ConfiguredFeature<?,?>> TREE_RED_MAPLE = tree("red_maple");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_RED_MAPLE = tree("big_red_maple");
    ResourceKey<ConfiguredFeature<?,?>> TREE_ORANGE_MAPLE = tree("orange_maple");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_ORANGE_MAPLE = tree("big_orange_maple");
    ResourceKey<ConfiguredFeature<?,?>> TREE_MAUVE_OAK_BEE = tree("mauve_oak_bee");
    ResourceKey<ConfiguredFeature<?,?>> TREE_MAUVE_OAK = tree("mauve_oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_MAUVE_OAK = tree("big_mauve_oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_OAK_WITH_BRANCH = tree("oak_with_branch");
    ResourceKey<ConfiguredFeature<?,?>> TREE_OAK_WITH_FLOWERS = tree("oak_with_flowers");
    ResourceKey<ConfiguredFeature<?,?>> TREE_OAK = tree("oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_OAK_TALL = tree("oak_tall");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_OAK = tree("big_oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_OAK_SHRUB = tree("oak_shrub");
    ResourceKey<ConfiguredFeature<?,?>> TREE_OAK_BUSH = tree("oak_bush");
    ResourceKey<ConfiguredFeature<?,?>> TREE_OAK_BUSH_WITH_FLOWERS = tree("oak_bush_with_flowers");
    ResourceKey<ConfiguredFeature<?,?>> TREE_PALM = tree("palm");
    ResourceKey<ConfiguredFeature<?,?>> TREE_TALL_PALM = tree("tall_palm");
    ResourceKey<ConfiguredFeature<?,?>> TREE_PALM_SHRUB = tree("palm_shrub");
    ResourceKey<ConfiguredFeature<?,?>> TREE_PINE = tree("pine");
    ResourceKey<ConfiguredFeature<?,?>> TREE_PINE_TALL = tree("pine_tall");
    ResourceKey<ConfiguredFeature<?,?>> TREE_STRIPPED_PINE = tree("stripped_pine");
    ResourceKey<ConfiguredFeature<?,?>> TREE_STRIPPED_PINE_TALL = tree("stripped_pine_tall");
    ResourceKey<ConfiguredFeature<?,?>> TREE_STRIPPED_PINE_MOUNTAIN = tree("stripped_pine_mountain");
    ResourceKey<ConfiguredFeature<?,?>> TREE_PINE_SHRUB = tree("pine_shrub");
    ResourceKey<ConfiguredFeature<?,?>> TREE_LUSH_PINE = tree("lush_pine");
    ResourceKey<ConfiguredFeature<?,?>> TREE_SAGUARO_CACTUS = tree("saguaro_cactus");
    ResourceKey<ConfiguredFeature<?,?>> TREE_ICE_SPIRE = tree("ice_spire");
    ResourceKey<ConfiguredFeature<?,?>> TREE_SILVER_BIRCH = tree("silver_birch");
    ResourceKey<ConfiguredFeature<?,?>> TREE_SILVER_BIRCH_TALL = tree("silver_birch_tall");
    ResourceKey<ConfiguredFeature<?,?>> TREE_ENCHANTED_BIRCH = tree("enchanted_birch");
    ResourceKey<ConfiguredFeature<?,?>> TREE_ENCHANTED_BIRCH_TALL = tree("enchanted_birch_tall");
    ResourceKey<ConfiguredFeature<?,?>> TREE_SPRUCE_TALL = tree("spruce_tall");
    ResourceKey<ConfiguredFeature<?,?>> TREE_SPRUCE_SHRUB = tree("spruce_shrub");
    ResourceKey<ConfiguredFeature<?,?>> TREE_SMALL_OAK = tree("small_oak");
    ResourceKey<ConfiguredFeature<?,?>> TREE_LARGE_SOCOTRA = tree("large_socotra");
    ResourceKey<ConfiguredFeature<?,?>> TREE_SMALL_SOCOTRA = tree("small_socotra");
    ResourceKey<ConfiguredFeature<?,?>> TREE_REDWOOD_SMALL = tree("redwood_small");
    ResourceKey<ConfiguredFeature<?,?>> TREE_REDWOOD_MEDIUM = tree("redwood_medium");
    ResourceKey<ConfiguredFeature<?,?>> TREE_REDWOOD_LARGE = tree("redwood_large");
    ResourceKey<ConfiguredFeature<?,?>> TREE_REDWOOD_EMERGENT = tree("redwood_emergent");
    ResourceKey<ConfiguredFeature<?,?>> TREE_WILLOW = tree("willow");
    ResourceKey<ConfiguredFeature<?,?>> TREE_BIG_WILLOW = tree("big_willow");
    ResourceKey<ConfiguredFeature<?,?>> TREE_WILLOW_VINES = tree("willow_vines");
    // Bonemealables
    ResourceKey<ConfiguredFeature<?,?>> BONEMEAL_ALPHA_GRASS = key("bonemeal/grass/alpha");
    ResourceKey<ConfiguredFeature<?,?>> BONEMEAL_MYCOTOXIC_NYLIUM = key("bonemeal/nylium/mycotoxic");
    ResourceKey<ConfiguredFeature<?,?>> BONEMEAL_GLISTERING_NYLIUM = key("bonemeal/nylium/glistering");
    ResourceKey<ConfiguredFeature<?,?>> BONEMEAL_COBALT_NYLIUM = key("bonemeal/nylium/cobalt");
    ResourceKey<ConfiguredFeature<?,?>> BONEMEAL_BRIMSPROUT_NYLIUM = key("bonemeal/nylium/brimsprout");

    static ResourceKey<ConfiguredFeature<?,?>> treeGroup(String name) {
        return tree("group/" + name);
    }
    
    static ResourceKey<ConfiguredFeature<?,?>> tree(String name) {
        return key("tree/" + name);
    }
    
    static ResourceKey<ConfiguredFeature<?,?>> key(String name) {
        return RegionsUnexplored.key(Registries.CONFIGURED_FEATURE, name);
    }

    static ResourceKey<ConfiguredFeature<?,?>> fromPlaced(ResourceKey<PlacedFeature> key) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, key.identifier());
    }
}
