package net.regions_unexplored.registry;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.regions_unexplored.platform.Services;
import net.regions_unexplored.world.level.feature.*;
import net.regions_unexplored.world.level.feature.bioshroom.*;
import net.regions_unexplored.world.level.feature.configuration.*;
import net.regions_unexplored.world.level.feature.tree.*;
import net.regions_unexplored.world.level.feature.tree.nether.*;

import java.util.function.Supplier;

public class FeatureRegistry {
    //BIOSHROOMS
    public static Supplier<Feature> GIANT_BLUE_BIOSHROOM;
    public static Supplier<Feature> GIANT_GREEN_BIOSHROOM;
    public static Supplier<Feature> GIANT_PINK_BIOSHROOM;
    public static Supplier<Feature> GIANT_YELLOW_BIOSHROOM;
    public static Supplier<Feature> SMALL_YELLOW_BIOSHROOM;
    //TREES
    public static Supplier<Feature> ASHEN_TREE;
    public static Supplier<Feature> ASPEN_TREE;
    public static Supplier<Feature> BAMBOO_TREE;
    public static Supplier<Feature> MEGA_BAOBAB_TREE;
    public static Supplier<Feature> ULTRA_BAOBAB_TREE;
    public static Supplier<Feature> BLACKWOOD_TREE;
    public static Supplier<Feature> COBALT_TREE;
    public static Supplier<Feature> CYPRESS_TREE;
    public static Supplier<Feature> DEAD_TREE;
    public static Supplier<Feature> SMALL_EUCALYPTUS_TREE;
    public static Supplier<Feature> EUCALYPTUS_TREE;
    public static Supplier<Feature> GIANT_CYPRESS_TREE;
    public static Supplier<Feature> LARCH_TREE;
    public static Supplier<Feature> LARGE_JOSHUA_TREE;
    public static Supplier<Feature> KAPOK_TREE;
    public static Supplier<Feature> MAPLE_TREE;
    public static Supplier<Feature> MEDIUM_JOSHUA_TREE;
    public static Supplier<Feature> PALM_TREE;
    public static Supplier<Feature> LUSH_PINE_TREE;
    public static Supplier<Feature> PINE_TREE;
    public static Supplier<Feature> SMALL_JOSHUA_TREE;
    public static Supplier<Feature> SMALL_OAK_TREE;
    public static Supplier<Feature> STRIPPED_PINE_TREE;
    public static Supplier<Feature> REDWOOD_TREE;
    public static Supplier<Feature> SAGUARO_CACTUS;
    public static Supplier<Feature> SAKURA_TREE;
    public static Supplier<Feature> LARGE_SOCOTRA_TREE;
    public static Supplier<Feature> SMALL_SOCOTRA_TREE;
    public static Supplier<Feature> SUPER_REDWOOD_TREE;
    public static Supplier<Feature> ULTRA_REDWOOD_TREE;
    //CAVE
    public static Supplier<Feature> POINTED_REDSTONE;
    public static Supplier<Feature> LARGE_POINTED_REDSTONE;
    public static Supplier<Feature> POINTED_REDSTONE_CLUSTER;
    public static Supplier<Feature> HANGING_PRISMARITE;
    public static Supplier<Feature> DROPLEAF;
    public static Supplier<Feature> BASALT_BLOB;
    public static Supplier<Feature> ASH_VENT;
    public static Supplier<Feature> LAVA_FALL;
    public static Supplier<Feature> OVERWORLD_LAVA_DELTA;
    //NETHER
    public static Supplier<Feature> BRIM_WILLOW;
    public static Supplier<Feature> TALL_BRIM_WILLOW;
    //VEGETATION
    public static Supplier<Feature> SHRUB;
    public static Supplier<Feature> TREE_SHRUB;
    public static Supplier<Feature> GIANT_LILY;
    //DECORATION
    public static Supplier<Feature> ICICLE_UP;
    public static Supplier<Feature> AIR_MULTIFACE_GROWTH;
    public static Supplier<Feature> FALLEN_BLOB_TREE;
    public static Supplier<Feature> FALLEN_SNOW_TREE;
    public static Supplier<Feature> SMOULDERING_DIRT;
    public static Supplier<Feature> MEADOW_ROCK;
    public static Supplier<Feature> ROCK;
    public static Supplier<Feature> SPIRE;
    //AQUATIC
    public static Supplier<Feature> MARSH;
    public static Supplier<Feature> WATER_EDGE;
    public static Supplier<Feature> FEN_CATTAIL;
    public static Supplier<Feature> WATER_CATTAIL;
    public static Supplier<Feature> ROCK_PILLAR;
    public static Supplier<Feature> TALL_HYACINTH_STOCK;
    public static Supplier<Feature> HYACINTH_PLANTS;
    public static Supplier<Feature> OCEAN_ROCK;
    //NETHER
    public static Supplier<Feature> NETHER_ROCK;
    public static Supplier<Feature> GLISTERING_IVY;
    public static Supplier<Feature> HANGING_EARLIGHT;
    public static Supplier<Feature> OBSIDIAN_SPIRE;

    public static void addFeatures() {
        //BIOSHROOMS
        GIANT_BLUE_BIOSHROOM = register("giant_blue_bioshroom", () -> new GiantBlueBioshroomFeature(GiantBioshroomConfiguration.CODEC));
        GIANT_GREEN_BIOSHROOM = register("giant_green_bioshroom", () -> new GiantGreenBioshroomFeature(GiantBioshroomConfiguration.CODEC));
        GIANT_PINK_BIOSHROOM = register("giant_pink_bioshroom", () -> new GiantPinkBioshroomFeature(GiantBioshroomConfiguration.CODEC));
        GIANT_YELLOW_BIOSHROOM = register("giant_yellow_bioshroom", () -> new GiantYellowBioshroomFeature(GiantBioshroomConfiguration.CODEC));
        SMALL_YELLOW_BIOSHROOM = register("small_yellow_bioshroom", () -> new YellowBioshroomShrubFeature(NoneFeatureConfiguration.CODEC));
        //TREES
        ASHEN_TREE = register("ashen_tree", () -> new AshenTreeFeature(RuTreeConfiguration.CODEC));
        ASPEN_TREE = register("aspen_tree", () -> new AspenTreeFeature(RuTreeConfiguration.CODEC));
        BAMBOO_TREE = register("bamboo_tree", () -> new BambooTreeFeature(RuTreeConfiguration.CODEC));
        BLACKWOOD_TREE = register("blackwood_tree", () -> new BlackwoodTreeFeature(RuTreeConfiguration.CODEC));
        COBALT_TREE = register("cobalt_tree", () -> new CobaltShrubFeature(NoneFeatureConfiguration.CODEC));
        CYPRESS_TREE = register("cypress_tree", () -> new CypressTreeFeature(RuTreeConfiguration.CODEC));
        DEAD_TREE = register("dead_tree", () -> new DeadTreeFeature(RuTreeConfiguration.CODEC));
        SMALL_EUCALYPTUS_TREE = register("small_eucalyptus_tree", () -> new SmallEucalyptusTreeFeature(RuTreeConfiguration.CODEC));
        EUCALYPTUS_TREE = register("eucalyptus_tree", () -> new EucalyptusTreeFeature(RuTreeConfiguration.CODEC));
        GIANT_CYPRESS_TREE = register("giant_cypress_tree", () -> new GiantCypressTreeFeature(RuTreeConfiguration.CODEC));
        LARCH_TREE = register("larch_tree", () -> new LarchTreeFeature(RuTreeConfiguration.CODEC));
        LARGE_JOSHUA_TREE = register("large_joshua_tree", () -> new LargeJoshuaTreeFeature(NoneFeatureConfiguration.CODEC));
        KAPOK_TREE = register("kapok_tree", () -> new KapokTreeFeature(RuTreeConfiguration.CODEC));
        MAPLE_TREE = register("maple_tree", () -> new MapleTreeFeature(RuTreeConfiguration.CODEC));
        MEDIUM_JOSHUA_TREE = register("medium_joshua_tree", () -> new MediumJoshuaTreeFeature(NoneFeatureConfiguration.CODEC));
        PALM_TREE = register("palm_tree", () -> new PalmTreeFeature(RuTreeConfiguration.CODEC));
        LUSH_PINE_TREE = register("lush_pine_tree", () -> new LushPineTreeFeature(RuTreeConfiguration.CODEC));
        PINE_TREE = register("pine_tree", () -> new PineTreeFeature(RuTreeConfiguration.CODEC));
        SMALL_JOSHUA_TREE = register("small_joshua_tree", () -> new SmallJoshuaTreeFeature(RuTreeConfiguration.CODEC));
        SMALL_OAK_TREE = register("small_oak_tree", () -> new SmallOakTreeFeature(RuTreeConfiguration.CODEC));
        STRIPPED_PINE_TREE = register("stripped_pine_tree", () -> new StrippedPineTreeFeature(RuTreeConfiguration.CODEC));
        REDWOOD_TREE = register("redwood_tree", () -> new RedwoodTreeFeature(RuTreeConfiguration.CODEC));
        SAGUARO_CACTUS = register("saguaro_cactus", () -> new SaguaroCactusFeature(RuTreeConfiguration.CODEC));
        SAKURA_TREE = register("sakura_tree", () -> new SakuraTreeFeature(RuTreeConfiguration.CODEC));
        LARGE_SOCOTRA_TREE = register("large_socotra_tree", () -> new LargeSocotraTreeFeature(RuTreeConfiguration.CODEC));
        SMALL_SOCOTRA_TREE = register("small_socotra_tree", () -> new SmallSocotraTreeFeature(NoneFeatureConfiguration.CODEC));
        SUPER_REDWOOD_TREE = register("super_redwood_tree", () -> new SuperRedwoodTreeFeature(RuTreeConfiguration.CODEC));
        ULTRA_REDWOOD_TREE = register("ultra_redwood_tree", () -> new UltraRedwoodTreeFeature(RuTreeConfiguration.CODEC));
        MEGA_BAOBAB_TREE = register("mega_baobab_tree", () -> new MegaBaobabTreeFeature(RuTreeConfiguration.CODEC));
        ULTRA_BAOBAB_TREE = register("ultra_baobab_tree", () -> new UltraBaobabTreeFeature(RuTreeConfiguration.CODEC));
        //CAVE
        POINTED_REDSTONE = register("pointed_redstone", () -> new PointedRedstoneFeature(PointedRedstoneConfiguration.CODEC));
        LARGE_POINTED_REDSTONE = register("large_pointed_redstone", () -> new LargePointedRedstoneFeature(LargePointedRedstoneConfiguration.CODEC));
        POINTED_REDSTONE_CLUSTER = register("pointed_redstone_cluster", () -> new PointedRedstoneClusterFeature(PointedRedstoneClusterConfiguration.CODEC));
        HANGING_PRISMARITE = register("hanging_prismarite", () -> new HangingPrismariteFeature(NoneFeatureConfiguration.CODEC));
        DROPLEAF = register("dropleaf", () -> new DropleafFeature(NoneFeatureConfiguration.CODEC));
        BASALT_BLOB = register("basalt_blob", () -> new BasaltBlobFeature(ColumnFeatureConfiguration.CODEC));
        ASH_VENT = register("scorch_vent", () -> new AshVentFeature(NoneFeatureConfiguration.CODEC));
        LAVA_FALL = register("lava_fall", () -> new LavaFallFeature(NoneFeatureConfiguration.CODEC));
        OVERWORLD_LAVA_DELTA = register("overworld_lava_delta", () -> new LavaDeltaFeature(VegetationPatchConfiguration.CODEC));
        //NETHER
        BRIM_WILLOW = register("brim_willow", () -> new BrimWillowFeature(NoneFeatureConfiguration.CODEC));
        TALL_BRIM_WILLOW = register("tall_brim_willow", () -> new TallBrimWillowFeature(NoneFeatureConfiguration.CODEC));
        //VEGETATION
        SHRUB = register("shrub", () -> new ShrubFeature(ShrubConfiguration.CODEC));
        TREE_SHRUB = register("tree_shrub", () -> new TreeShrubFeature(RuTreeConfiguration.CODEC));
        GIANT_LILY = register("giant_lily", () -> new GiantLilyPadFeature(NoneFeatureConfiguration.CODEC));
        //DECORATION
        ICICLE_UP = register("icicle_up", () -> new FloorIcicleFeature(NoneFeatureConfiguration.CODEC));
        AIR_MULTIFACE_GROWTH = register("air_multiface_growth", () -> new AirMultifaceGrowthFeature(MultifaceGrowthConfiguration.CODEC));
        FALLEN_BLOB_TREE = register("fallen_blob_tree", () -> new FallenBlobTreeFeature(FallenTreeConfiguration.CODEC));
        FALLEN_SNOW_TREE = register("fallen_snow_tree", () -> new FallenSnowTreeFeature(FallenTreeConfiguration.CODEC));
        SMOULDERING_DIRT = register("smouldering_dirt", () -> new SmoulderingDirtFeature(NoneFeatureConfiguration.CODEC));
        MEADOW_ROCK = register("meadow_rock", () -> new MeadowRockFeature(NoneFeatureConfiguration.CODEC));
        ROCK = register("rock", () -> new RockFeature(NoneFeatureConfiguration.CODEC));
        SPIRE = register("spire", () -> new IceSpireFeature(RuTreeConfiguration.CODEC));
        //AQUATIC
        MARSH = register("marsh", () -> new MarshFeature(NoneFeatureConfiguration.CODEC));
        WATER_EDGE = register("water_edge", () -> new WaterEdgeFeature(NoneFeatureConfiguration.CODEC));
        FEN_CATTAIL = register("fen_cattail", () -> new FenCattailFeature(NoneFeatureConfiguration.CODEC));
        WATER_CATTAIL = register("water_cattail", () -> new WaterCattailFeature(NoneFeatureConfiguration.CODEC));
        ROCK_PILLAR = register("rock_pillar", () -> new RockPillarFeature(NoneFeatureConfiguration.CODEC));
        TALL_HYACINTH_STOCK = register("tall_hyacinth_stock", () -> new HyacinthStockFeature(HyacinthStockConfiguration.CODEC));
        HYACINTH_PLANTS = register("hyacinth_plants", () -> new HyacinthPlantsFeature(ProbabilityFeatureConfiguration.CODEC));
        OCEAN_ROCK = register("ocean_rock", () -> new SeaRockFeature(SeaRockConfiguration.CODEC));
        //NETHER
        NETHER_ROCK = register("nether_rock", () -> new NetherRockFeature(NoneFeatureConfiguration.CODEC));
        GLISTERING_IVY = register("glistering_ivy", () -> new GlisteringIvyFeature(NoneFeatureConfiguration.CODEC));
        HANGING_EARLIGHT = register("hanging_earlight", () -> new HangingEarlightFeature(NoneFeatureConfiguration.CODEC));
        OBSIDIAN_SPIRE = register("obsidian_spire", () -> new ObsidianSpireFeature(NoneFeatureConfiguration.CODEC));
    }


    private static <FC extends FeatureConfiguration> Supplier<Feature> register(String path, Supplier<Feature> feature) {
       return Services.REGISTAR.registerFeature(path, feature);
    }
}
