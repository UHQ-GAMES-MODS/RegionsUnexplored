package net.regions_unexplored.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.regions_unexplored.Constants;
import net.regions_unexplored.platform.Services;
import net.regions_unexplored.world.level.feature.*;
import net.regions_unexplored.world.level.feature.bioshroom.*;
import net.regions_unexplored.world.level.feature.configuration.*;
import net.regions_unexplored.world.level.feature.tree.*;
import net.regions_unexplored.world.level.feature.tree.nether.*;

import java.util.function.Supplier;

public class FeatureRegistry {
    //BIOSHROOMS
    public static Feature<GiantBioshroomConfiguration> GIANT_BLUE_BIOSHROOM = new GiantBlueBioshroomFeature(GiantBioshroomConfiguration.CODEC);
    public static Feature<GiantBioshroomConfiguration> GIANT_GREEN_BIOSHROOM = new GiantGreenBioshroomFeature(GiantBioshroomConfiguration.CODEC);
    public static Feature<GiantBioshroomConfiguration> GIANT_PINK_BIOSHROOM = new GiantPinkBioshroomFeature(GiantBioshroomConfiguration.CODEC);
    public static Feature<GiantBioshroomConfiguration> GIANT_YELLOW_BIOSHROOM = new GiantYellowBioshroomFeature(GiantBioshroomConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> SMALL_YELLOW_BIOSHROOM = new YellowBioshroomShrubFeature(NoneFeatureConfiguration.CODEC);
    //TREES
    public static Feature<RuTreeConfiguration> ASHEN_TREE = new AshenTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> ASPEN_TREE = new AspenTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> BAMBOO_TREE = new BambooTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> BLACKWOOD_TREE = new BlackwoodTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> COBALT_TREE = new CobaltShrubFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> CYPRESS_TREE = new CypressTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> DEAD_TREE = new DeadTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> EUCALYPTUS_TREE = new EucalyptusTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> GIANT_CYPRESS_TREE = new GiantCypressTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> KAPOK_TREE = new KapokTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> LARCH_TREE = new LarchTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> LARGE_JOSHUA_TREE = new LargeJoshuaTreeFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> LARGE_SOCOTRA_TREE = new LargeSocotraTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> LUSH_PINE_TREE = new LushPineTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> MAPLE_TREE = new MapleTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> MEDIUM_JOSHUA_TREE = new MediumJoshuaTreeFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> MEGA_BAOBAB_TREE = new MegaBaobabTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> PALM_TREE = new PalmTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> PINE_TREE = new PineTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> REDWOOD_TREE = new RedwoodTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> SAGUARO_CACTUS = new SaguaroCactusFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> SAKURA_TREE = new SakuraTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> SMALL_EUCALYPTUS_TREE = new SmallEucalyptusTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> SMALL_JOSHUA_TREE = new SmallJoshuaTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> SMALL_OAK_TREE = new SmallOakTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> SMALL_SOCOTRA_TREE = new SmallSocotraTreeFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> STRIPPED_PINE_TREE = new StrippedPineTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> SUPER_REDWOOD_TREE = new SuperRedwoodTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> ULTRA_BAOBAB_TREE = new UltraBaobabTreeFeature(RuTreeConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> ULTRA_REDWOOD_TREE = new UltraRedwoodTreeFeature(RuTreeConfiguration.CODEC);
    //CAVE
    public static Feature<NoneFeatureConfiguration> ASH_VENT = new AshVentFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<ColumnFeatureConfiguration> BASALT_BLOB = new BasaltBlobFeature(ColumnFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> DROPLEAF = new DropleafFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> HANGING_PRISMARITE = new HangingPrismariteFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<LargePointedRedstoneConfiguration> LARGE_POINTED_REDSTONE = new LargePointedRedstoneFeature(LargePointedRedstoneConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> LAVA_FALL = new LavaFallFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<VegetationPatchConfiguration> OVERWORLD_LAVA_DELTA = new LavaDeltaFeature(VegetationPatchConfiguration.CODEC);
    public static Feature<PointedRedstoneConfiguration> POINTED_REDSTONE = new PointedRedstoneFeature(PointedRedstoneConfiguration.CODEC);
    public static Feature<PointedRedstoneClusterConfiguration> POINTED_REDSTONE_CLUSTER = new PointedRedstoneClusterFeature(PointedRedstoneClusterConfiguration.CODEC);
    //NETHER//NETHER
    public static Feature<NoneFeatureConfiguration> BRIM_WILLOW = new BrimWillowFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> TALL_BRIM_WILLOW = new TallBrimWillowFeature(NoneFeatureConfiguration.CODEC);
    //VEGETATION
    public static Feature<NoneFeatureConfiguration> GIANT_LILY = new GiantLilyPadFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<ShrubConfiguration> SHRUB = new ShrubFeature(ShrubConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> TREE_SHRUB = new TreeShrubFeature(RuTreeConfiguration.CODEC);
    //DECORATION
    public static Feature<MultifaceGrowthConfiguration> AIR_MULTIFACE_GROWTH = new AirMultifaceGrowthFeature(MultifaceGrowthConfiguration.CODEC);
    public static Feature<FallenTreeConfiguration> FALLEN_BLOB_TREE = new FallenBlobTreeFeature(FallenTreeConfiguration.CODEC);
    public static Feature<FallenTreeConfiguration> FALLEN_SNOW_TREE = new FallenSnowTreeFeature(FallenTreeConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> ICICLE_UP = new FloorIcicleFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> MEADOW_ROCK = new MeadowRockFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> ROCK = new RockFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> SMOULDERING_DIRT = new SmoulderingDirtFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<RuTreeConfiguration> SPIRE = new IceSpireFeature(RuTreeConfiguration.CODEC);
    //AQUATIC
    public static Feature<NoneFeatureConfiguration> FEN_CATTAIL = new FenCattailFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<ProbabilityFeatureConfiguration> HYACINTH_PLANTS = new HyacinthPlantsFeature(ProbabilityFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> MARSH = new MarshFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<SeaRockConfiguration> OCEAN_ROCK = new SeaRockFeature(SeaRockConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> ROCK_PILLAR = new RockPillarFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<HyacinthStockConfiguration> TALL_HYACINTH_STOCK = new HyacinthStockFeature(HyacinthStockConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> WATER_CATTAIL = new WaterCattailFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> WATER_EDGE = new WaterEdgeFeature(NoneFeatureConfiguration.CODEC);
    //NETHER
    public static Feature<NoneFeatureConfiguration> GLISTERING_IVY = new GlisteringIvyFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> HANGING_EARLIGHT = new HangingEarlightFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> NETHER_ROCK = new NetherRockFeature(NoneFeatureConfiguration.CODEC);
    public static Feature<NoneFeatureConfiguration> OBSIDIAN_SPIRE = new ObsidianSpireFeature(NoneFeatureConfiguration.CODEC);

    public static void addFeatures() {
        //BIOSHROOMS
        register("giant_blue_bioshroom", () -> GIANT_BLUE_BIOSHROOM);
        register("giant_green_bioshroom", () -> GIANT_GREEN_BIOSHROOM);
        register("giant_pink_bioshroom", () -> GIANT_PINK_BIOSHROOM);
        register("giant_yellow_bioshroom", () -> GIANT_YELLOW_BIOSHROOM);
        register("small_yellow_bioshroom", () -> SMALL_YELLOW_BIOSHROOM);
        //TREES
        register("ashen_tree", () ->ASHEN_TREE);
        register("aspen_tree", () ->ASPEN_TREE);
        register("bamboo_tree", () ->BAMBOO_TREE);
        register("blackwood_tree", () ->BLACKWOOD_TREE);
        register("cobalt_tree", () ->COBALT_TREE);
        register("cypress_tree", () ->CYPRESS_TREE);
        register("dead_tree", () ->DEAD_TREE);
        register("eucalyptus_tree", () ->EUCALYPTUS_TREE);
        register("giant_cypress_tree", () ->GIANT_CYPRESS_TREE);
        register("kapok_tree", () ->KAPOK_TREE);
        register("larch_tree", () ->LARCH_TREE);
        register("large_joshua_tree", () ->LARGE_JOSHUA_TREE);
        register("large_socotra_tree", () ->LARGE_SOCOTRA_TREE);
        register("lush_pine_tree", () ->LUSH_PINE_TREE);
        register("maple_tree", () ->MAPLE_TREE);
        register("medium_joshua_tree", () ->MEDIUM_JOSHUA_TREE);
        register("mega_baobab_tree", () ->MEGA_BAOBAB_TREE);
        register("palm_tree", () ->PALM_TREE);
        register("pine_tree", () ->PINE_TREE);
        register("redwood_tree", () ->REDWOOD_TREE);
        register("saguaro_cactus", () ->SAGUARO_CACTUS);
        register("sakura_tree", () ->SAKURA_TREE);
        register("small_eucalyptus_tree", () ->SMALL_EUCALYPTUS_TREE);
        register("small_joshua_tree", () ->SMALL_JOSHUA_TREE);
        register("small_oak_tree", () ->SMALL_OAK_TREE);
        register("small_socotra_tree", () ->SMALL_SOCOTRA_TREE);
        register("stripped_pine_tree", () ->STRIPPED_PINE_TREE);
        register("super_redwood_tree", () ->SUPER_REDWOOD_TREE);
        register("ultra_baobab_tree", () ->ULTRA_BAOBAB_TREE);
        register("ultra_redwood_tree", () ->ULTRA_REDWOOD_TREE);
        //CAVE
        register("scorch_vent", () -> ASH_VENT);
        register("basalt_blob", () -> BASALT_BLOB);
        register("dropleaf", () -> DROPLEAF);
        register("hanging_prismarite", () -> HANGING_PRISMARITE);
        register("large_pointed_redstone", () -> LARGE_POINTED_REDSTONE);
        register("lava_fall", () -> LAVA_FALL);
        register("overworld_lava_delta", () -> OVERWORLD_LAVA_DELTA);
        register("pointed_redstone", () -> POINTED_REDSTONE);
        register("pointed_redstone_cluster", () -> POINTED_REDSTONE_CLUSTER);
        //NETHER
        register("brim_willow", () -> BRIM_WILLOW);
        register("tall_brim_willow", () -> TALL_BRIM_WILLOW);
        //VEGETATION
        register("giant_lily", () -> GIANT_LILY);
        register("shrub", () -> SHRUB);
        register("tree_shrub", () -> TREE_SHRUB);
        //DECORATION
        register("air_multiface_growth", () -> AIR_MULTIFACE_GROWTH);
        register("fallen_blob_tree", () -> FALLEN_BLOB_TREE);
        register("fallen_snow_tree", () -> FALLEN_SNOW_TREE);
        register("icicle_up", () -> ICICLE_UP);
        register("meadow_rock", () -> MEADOW_ROCK);
        register("rock", () -> ROCK);
        register("smouldering_dirt", () -> SMOULDERING_DIRT);
        register("spire", () -> SPIRE);
        //AQUATIC
        register("fen_cattail", () -> FEN_CATTAIL);
        register("hyacinth_plants", () -> HYACINTH_PLANTS);
        register("marsh", () -> MARSH);
        register("ocean_rock", () -> OCEAN_ROCK);
        register("rock_pillar", () -> ROCK_PILLAR);
        register("tall_hyacinth_stock", () -> TALL_HYACINTH_STOCK);
        register("water_cattail", () -> WATER_CATTAIL);
        register("water_edge", () -> WATER_EDGE);
        //NETHER
        register("glistering_ivy", () -> GLISTERING_IVY);
        register("hanging_earlight", () -> HANGING_EARLIGHT);
        register("nether_rock", () -> NETHER_ROCK);
        register("obsidian_spire", () -> OBSIDIAN_SPIRE);
    }

    private static void register(String path, Supplier<Feature<?>> feature) {
        Services.REGISTAR.register(BuiltInRegistries.FEATURE, path, feature);
    }
}
