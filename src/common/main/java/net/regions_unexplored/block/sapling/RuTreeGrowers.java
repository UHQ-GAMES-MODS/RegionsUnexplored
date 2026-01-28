package net.regions_unexplored.block.sapling;

import net.minecraft.world.level.block.grower.TreeGrower;

import static java.util.Optional.empty;
import static java.util.Optional.of;

import static net.regions_unexplored.registry.data.RUConfiguredFeatures.*;

public interface RuTreeGrowers {
    TreeGrower ASHEN = new TreeGrower("ashen", empty(), of(TREE_ASHEN), empty());
    TreeGrower ALPHA_OAK = new TreeGrower("alpha_oak", empty(), of(TREE_ALPHA_OAK), empty());
    TreeGrower APPLE_OAK = new TreeGrower("apple_oak", 0.2F, empty(), empty(), of(TREE_APPLE_OAK), of(TREE_BIG_APPLE_OAK), empty(), empty());

    TreeGrower BLUE_BIOSHROOM = new TreeGrower("blue_bioshroom", empty(), of(TREE_GIANT_BLUE_BIOSHROOM), empty());
    TreeGrower GREEN_BIOSHROOM = new TreeGrower("green_bioshroom", empty(), of(TREE_GIANT_GREEN_BIOSHROOM), empty());
    TreeGrower PINK_BIOSHROOM = new TreeGrower("pink_bioshroom", empty(), of(TREE_GIANT_PINK_BIOSHROOM), empty());
    TreeGrower YELLOW_BIOSHROOM = new TreeGrower("yellow_bioshroom", empty(), of(TREE_GIANT_YELLOW_BIOSHROOM), empty());
    TreeGrower BAMBOO = new TreeGrower("bamboo", empty(), of(TREE_BAMBOO), empty());
    RuUltraFromMegaTreeGrower BAOBAB = new RuUltraFromMegaTreeGrower("baobab", of(TREE_ULTRA_BAOBAB), of(TREE_MEGA_BAOBAB), empty(), empty());
    TreeGrower BLACKWOOD = new TreeGrower("blackwood", 0.1F, of(TREE_GIANT_BLACKWOOD), empty(), of(TREE_BIG_BLACKWOOD), of(TREE_BLACKWOOD), empty(), empty());
    TreeGrower SAGUARO_CACTUS = new TreeGrower("saguaro_cactus", empty(), of(TREE_SAGUARO_CACTUS), empty());
    TreeGrower CYPRESS = new TreeGrower("cypress", 0.25F, empty(), empty(), of(TREE_CYPRESS), of(TREE_GIANT_CYPRESS), empty(), empty());
    TreeGrower DEAD_PINE = new TreeGrower("dead_pine", 0.1F, empty(), empty(), of(TREE_DEAD_PINE), of(TREE_DEAD_STRIPPED_PINE), of(TREE_DEAD_PINE_TALL), of(TREE_DEAD_STRIPPED_PINE_MOUNTAIN));
    TreeGrower DEAD = new TreeGrower("dead", 0.1F, empty(), empty(), of(TREE_DEAD), of(TREE_BIG_DEAD), of(TREE_DEAD_BOG), empty());
    TreeGrower EUCALYPTUS = new TreeGrower("eucalyptus", 0.33F, empty(), empty(), of(TREE_EUCALYPTUS), of(TREE_SMALL_EUCALYPTUS), empty(), empty());
    TreeGrower FLOWERING_OAK = new TreeGrower("flowering_oak", 0.2F, empty(), empty(), of(TREE_FLOWERING_OAK), of(TREE_BIG_FLOWERING_OAK), empty(), empty());
    TreeGrower GOLDEN_LARCH = new TreeGrower("golden_larch", 0.25F, empty(), empty(), of(TREE_GOLDEN_LARCH), of(TREE_BIG_GOLDEN_LARCH), empty(), empty());
    TreeGrower LARCH = new TreeGrower("larch", 0.25F, empty(), empty(), of(TREE_LARCH), of(TREE_BIG_LARCH), empty(), empty());
    TreeGrower JOSHUA = new TreeGrower("joshua", 0.33F, empty(), empty(), of(TREE_MEDIUM_JOSHUA), of(TREE_LARGE_JOSHUA), empty(), empty());
    TreeGrower MAPLE = new TreeGrower("maple", 0.1F, empty(), empty(), of(TREE_MAPLE), of(TREE_BIG_MAPLE), empty(), empty());
    TreeGrower RED_MAPLE = new TreeGrower("red_maple", 0.1F, empty(), empty(), of(TREE_RED_MAPLE), of(TREE_BIG_RED_MAPLE), empty(), empty());
    TreeGrower ORANGE_MAPLE = new TreeGrower("orange_maple", 0.1F, empty(), empty(), of(TREE_ORANGE_MAPLE), of(TREE_BIG_ORANGE_MAPLE), empty(), empty());
    TreeGrower MAUVE = new TreeGrower("mauve", 0.1F, empty(), empty(), of(TREE_MAUVE_OAK), of(TREE_BIG_MAUVE_OAK), of(TREE_MAUVE_OAK_BEE), empty());
    TreeGrower BRIMWOOD = new TreeGrower("brimwood", 0.25F, empty(), empty(), of(TREE_BRIM_WILLOW), of(TREE_TALL_BRIM_WILLOW), empty(), empty());
    TreeGrower COBALT = new TreeGrower("cobalt", empty(), of(TREE_COBALT), empty());
    TreeGrower SILVER_BIRCH = new TreeGrower("silver_birch", 0.25F, empty(), empty(), of(TREE_SILVER_BIRCH), of(TREE_SILVER_BIRCH_TALL), empty(), empty());
    TreeGrower ENCHANTED_BIRCH = new TreeGrower("enchanted_birch", 0.25F, empty(), empty(), of(TREE_ENCHANTED_BIRCH), of(TREE_ENCHANTED_BIRCH_TALL), empty(), empty());
    TreeGrower SMALL_OAK = new TreeGrower("small_oak", empty(), of(TREE_SMALL_OAK), empty());
    TreeGrower SOCOTRA = new TreeGrower("socotra", 0.1F, empty(), empty(), of(TREE_LARGE_SOCOTRA), of(TREE_SMALL_SOCOTRA), empty(), empty());
    TreeGrower WILLOW = new TreeGrower("willow", 0.1F, empty(), empty(), of(TREE_WILLOW), of(TREE_BIG_WILLOW), empty(), empty());
    TreeGrower MAGNOLIA = new TreeGrower("magnolia", 0.1F, empty(), empty(), of(TREE_MAGNOLIA), of(TREE_BIG_MAGNOLIA), empty(), empty());
    TreeGrower WHITE_MAGNOLIA = new TreeGrower("white_magnolia", 0.1F, empty(), empty(), of(TREE_WHITE_MAGNOLIA), of(TREE_BIG_WHITE_MAGNOLIA), empty(), empty());
    TreeGrower PINK_MAGNOLIA = new TreeGrower("pink_magnolia", 0.1F, empty(), empty(), of(TREE_PINK_MAGNOLIA), of(TREE_BIG_PINK_MAGNOLIA), empty(), empty());
    TreeGrower BLUE_MAGNOLIA = new TreeGrower("blue_magnolia", 0.1F, empty(), empty(), of(TREE_BLUE_MAGNOLIA), of(TREE_BIG_BLUE_MAGNOLIA), empty(), empty());
    RuUltraFromSuperTreeGrower KAPOK = new RuUltraFromSuperTreeGrower("kapok", empty(), of(TREE_KAPOK), empty(), empty());
    RuUltraFromSuperTreeGrower REDWOOD = new RuUltraFromSuperTreeGrower("redwood", of(TREE_ULTRA_REDWOOD), of(TREE_GIANT_REDWOOD), of(TREE_REDWOOD), empty());
    TreeGrower PALM = new TreeGrower("palm", 0.1F, empty(), empty(), of(TREE_PALM), of(TREE_TALL_PALM), empty(), empty());
    TreeGrower PINE = new TreeGrower("pine", 0.1F, empty(), empty(), of(TREE_PINE), of(TREE_STRIPPED_PINE), of(TREE_PINE_TALL), of(TREE_STRIPPED_PINE_MOUNTAIN));
}
