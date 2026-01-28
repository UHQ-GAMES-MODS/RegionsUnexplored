package net.regions_unexplored.block.sapling;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public interface RuTreeGrowers {
    TreeGrower ASHEN = new TreeGrower("ashen", empty(), of(RuTreeFeatures.ASHEN), empty());
    TreeGrower ALPHA_OAK = new TreeGrower("alpha_oak", empty(), of(RuTreeFeatures.ALPHA_OAK), empty());
    TreeGrower APPLE_OAK = new TreeGrower("apple_oak", 0.2F, empty(), empty(), of(RuTreeFeatures.APPLE_OAK), of(RuTreeFeatures.BIG_APPLE_OAK), empty(), empty());

    TreeGrower BLUE_BIOSHROOM = new TreeGrower("blue_bioshroom", empty(), of(RuTreeFeatures.GIANT_BLUE_BIOSHROOM), empty());
    TreeGrower GREEN_BIOSHROOM = new TreeGrower("green_bioshroom", empty(), of(RuTreeFeatures.GIANT_GREEN_BIOSHROOM), empty());
    TreeGrower PINK_BIOSHROOM = new TreeGrower("pink_bioshroom", empty(), of(RuTreeFeatures.GIANT_PINK_BIOSHROOM), empty());
    TreeGrower YELLOW_BIOSHROOM = new TreeGrower("yellow_bioshroom", empty(), of(RuTreeFeatures.GIANT_YELLOW_BIOSHROOM), empty());
    TreeGrower BAMBOO = new TreeGrower("bamboo", empty(), of(RuTreeFeatures.BAMBOO), empty());
    RuUltraFromMegaTreeGrower BAOBAB = new RuUltraFromMegaTreeGrower("baobab", of(RuTreeFeatures.ULTRA_BAOBAB), of(RuTreeFeatures.MEGA_BAOBAB), empty(), empty());
    TreeGrower BLACKWOOD = new TreeGrower("blackwood", 0.1F, of(RuTreeFeatures.GIANT_BLACKWOOD), empty(), of(RuTreeFeatures.BIG_BLACKWOOD), of(RuTreeFeatures.BLACKWOOD), empty(), empty());
    TreeGrower SAGUARO_CACTUS = new TreeGrower("saguaro_cactus", empty(), of(RuTreeFeatures.SAGUARO_CACTUS), empty());
    TreeGrower CYPRESS = new TreeGrower("cypress", 0.25F, empty(), empty(), of(RuTreeFeatures.CYPRESS), of(RuTreeFeatures.GIANT_CYPRESS), empty(), empty());
    TreeGrower DEAD_PINE = new TreeGrower("dead_pine", 0.1F, empty(), empty(), of(RuTreeFeatures.DEAD_PINE), of(RuTreeFeatures.DEAD_STRIPPED_PINE), of(RuTreeFeatures.DEAD_PINE_TALL), of(RuTreeFeatures.DEAD_STRIPPED_PINE_MOUNTAIN));
    TreeGrower DEAD = new TreeGrower("dead", 0.1F, empty(), empty(), of(RuTreeFeatures.DEAD), of(RuTreeFeatures.BIG_DEAD), of(RuTreeFeatures.DEAD_BOG), empty());
    TreeGrower EUCALYPTUS = new TreeGrower("eucalyptus", 0.33F, empty(), empty(), of(RuTreeFeatures.EUCALYPTUS), of(RuTreeFeatures.SMALL_EUCALYPTUS), empty(), empty());
    TreeGrower FLOWERING_OAK = new TreeGrower("flowering_oak", 0.2F, empty(), empty(), of(RuTreeFeatures.FLOWERING_OAK), of(RuTreeFeatures.BIG_FLOWERING_OAK), empty(), empty());
    TreeGrower GOLDEN_LARCH = new TreeGrower("golden_larch", 0.25F, empty(), empty(), of(RuTreeFeatures.GOLDEN_LARCH), of(RuTreeFeatures.BIG_GOLDEN_LARCH), empty(), empty());
    TreeGrower LARCH = new TreeGrower("larch", 0.25F, empty(), empty(), of(RuTreeFeatures.LARCH), of(RuTreeFeatures.BIG_LARCH), empty(), empty());
    TreeGrower JOSHUA = new TreeGrower("joshua", 0.33F, empty(), empty(), of(RuTreeFeatures.MEDIUM_JOSHUA), of(RuTreeFeatures.LARGE_JOSHUA), empty(), empty());
    TreeGrower MAPLE = new TreeGrower("maple", 0.1F, empty(), empty(), of(RuTreeFeatures.MAPLE), of(RuTreeFeatures.BIG_MAPLE), empty(), empty());
    TreeGrower RED_MAPLE = new TreeGrower("red_maple", 0.1F, empty(), empty(), of(RuTreeFeatures.RED_MAPLE), of(RuTreeFeatures.BIG_RED_MAPLE), empty(), empty());
    TreeGrower ORANGE_MAPLE = new TreeGrower("orange_maple", 0.1F, empty(), empty(), of(RuTreeFeatures.ORANGE_MAPLE), of(RuTreeFeatures.BIG_ORANGE_MAPLE), empty(), empty());
    TreeGrower MAUVE = new TreeGrower("mauve", 0.1F, empty(), empty(), of(RuTreeFeatures.MAUVE_OAK), of(RuTreeFeatures.BIG_MAUVE_OAK), of(RuTreeFeatures.MAUVE_OAK_BEE), empty());
    TreeGrower BRIMWOOD = new TreeGrower("brimwood", 0.25F, empty(), empty(), of(RuTreeFeatures.BRIM_WILLOW), of(RuTreeFeatures.TALL_BRIM_WILLOW), empty(), empty());
    TreeGrower COBALT = new TreeGrower("cobalt", empty(), of(RuTreeFeatures.COBALT), empty());
    TreeGrower SILVER_BIRCH = new TreeGrower("silver_birch", 0.25F, empty(), empty(), of(RuTreeFeatures.SILVER_BIRCH), of(RuTreeFeatures.SILVER_BIRCH_TALL), empty(), empty());
    TreeGrower ENCHANTED_BIRCH = new TreeGrower("enchanted_birch", 0.25F, empty(), empty(), of(RuTreeFeatures.ENCHANTED_BIRCH), of(RuTreeFeatures.ENCHANTED_BIRCH_TALL), empty(), empty());
    TreeGrower SMALL_OAK = new TreeGrower("small_oak", empty(), of(RuTreeFeatures.SMALL_OAK), empty());
    TreeGrower SOCOTRA = new TreeGrower("socotra", 0.1F, empty(), empty(), of(RuTreeFeatures.LARGE_SOCOTRA), of(RuTreeFeatures.SMALL_SOCOTRA), empty(), empty());
    TreeGrower WILLOW = new TreeGrower("willow", 0.1F, empty(), empty(), of(RuTreeFeatures.WILLOW), of(RuTreeFeatures.BIG_WILLOW), empty(), empty());
    TreeGrower MAGNOLIA = new TreeGrower("magnolia", 0.1F, empty(), empty(), of(RuTreeFeatures.MAGNOLIA), of(RuTreeFeatures.BIG_MAGNOLIA), empty(), empty());
    TreeGrower WHITE_MAGNOLIA = new TreeGrower("white_magnolia", 0.1F, empty(), empty(), of(RuTreeFeatures.WHITE_MAGNOLIA), of(RuTreeFeatures.BIG_WHITE_MAGNOLIA), empty(), empty());
    TreeGrower PINK_MAGNOLIA = new TreeGrower("pink_magnolia", 0.1F, empty(), empty(), of(RuTreeFeatures.PINK_MAGNOLIA), of(RuTreeFeatures.BIG_PINK_MAGNOLIA), empty(), empty());
    TreeGrower BLUE_MAGNOLIA = new TreeGrower("blue_magnolia", 0.1F, empty(), empty(), of(RuTreeFeatures.BLUE_MAGNOLIA), of(RuTreeFeatures.BIG_BLUE_MAGNOLIA), empty(), empty());
    RuUltraFromSuperTreeGrower KAPOK = new RuUltraFromSuperTreeGrower("kapok", empty(), of(RuTreeFeatures.KAPOK), empty(), empty());
    RuUltraFromSuperTreeGrower REDWOOD = new RuUltraFromSuperTreeGrower("redwood", of(RuTreeFeatures.ULTRA_REDWOOD), of(RuTreeFeatures.GIANT_REDWOOD), of(RuTreeFeatures.REDWOOD), empty());
    TreeGrower PALM = new TreeGrower("palm", 0.1F, empty(), empty(), of(RuTreeFeatures.PALM), of(RuTreeFeatures.TALL_PALM), empty(), empty());
    TreeGrower PINE = new TreeGrower("pine", 0.1F, empty(), empty(), of(RuTreeFeatures.PINE), of(RuTreeFeatures.STRIPPED_PINE), of(RuTreeFeatures.PINE_TALL), of(RuTreeFeatures.STRIPPED_PINE_MOUNTAIN));
}
