package net.regions_unexplored.registry;

import java.util.function.Supplier;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.regions_unexplored.platform.Registrar;
import net.regions_unexplored.world.level.feature.*;
import net.regions_unexplored.world.level.feature.bioshroom.*;
import net.regions_unexplored.world.level.feature.configuration.*;
import net.regions_unexplored.world.level.feature.tree.*;
import net.regions_unexplored.world.level.feature.tree.nether.*;
import net.regions_unexplored.worldgen.feature.NewRockFeature;
import net.regions_unexplored.worldgen.feature.config.RockFeatureConfig;

public interface RUFeatureTypes {
    Supplier<Feature<GiantBioshroomConfiguration>> GIANT_BLUE_BIOSHROOM = register("giant_blue_bioshroom", new GiantBlueBioshroomFeature(GiantBioshroomConfiguration.CODEC));
    Supplier<Feature<GiantBioshroomConfiguration>> GIANT_GREEN_BIOSHROOM = register("giant_green_bioshroom", new GiantGreenBioshroomFeature(GiantBioshroomConfiguration.CODEC));
    Supplier<Feature<GiantBioshroomConfiguration>> GIANT_PINK_BIOSHROOM = register("giant_pink_bioshroom", new GiantPinkBioshroomFeature(GiantBioshroomConfiguration.CODEC));
    Supplier<Feature<GiantBioshroomConfiguration>> GIANT_YELLOW_BIOSHROOM = register("giant_yellow_bioshroom", new GiantYellowBioshroomFeature(GiantBioshroomConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> SMALL_YELLOW_BIOSHROOM = register("small_yellow_bioshroom", new YellowBioshroomShrubFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> ASHEN_TREE = register("ashen_tree", new AshenTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> ASPEN_TREE = register("aspen_tree", new AspenTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> BAMBOO_TREE = register("bamboo_tree", new BambooTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> MEGA_BAOBAB_TREE = register("mega_baobab_tree", new MegaBaobabTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> ULTRA_BAOBAB_TREE = register("ultra_baobab_tree", new UltraBaobabTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> BLACKWOOD_TREE = register("blackwood_tree", new BlackwoodTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> COBALT_TREE = register("cobalt_tree", new CobaltShrubFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> CYPRESS_TREE = register("cypress_tree", new CypressTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> DEAD_TREE = register("dead_tree", new DeadTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> SMALL_EUCALYPTUS_TREE = register("small_eucalyptus_tree", new SmallEucalyptusTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> EUCALYPTUS_TREE = register("eucalyptus_tree", new EucalyptusTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> GIANT_CYPRESS_TREE = register("giant_cypress_tree", new GiantCypressTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> LARCH_TREE = register("larch_tree", new LarchTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> LARGE_JOSHUA_TREE = register("large_joshua_tree", new LargeJoshuaTreeFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> KAPOK_TREE = register("kapok_tree", new KapokTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> MAPLE_TREE = register("maple_tree", new MapleTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> MEDIUM_JOSHUA_TREE = register("medium_joshua_tree", new MediumJoshuaTreeFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> PALM_TREE = register("palm_tree", new PalmTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> LUSH_PINE_TREE = register("lush_pine_tree", new LushPineTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> PINE_TREE = register("pine_tree", new PineTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> SMALL_JOSHUA_TREE = register("small_joshua_tree", new SmallJoshuaTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> SMALL_OAK_TREE = register("small_oak_tree", new SmallOakTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> STRIPPED_PINE_TREE = register("stripped_pine_tree", new StrippedPineTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> SAGUARO_CACTUS = register("saguaro_cactus", new SaguaroCactusFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> SAKURA_TREE = register("sakura_tree", new SakuraTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> LARGE_SOCOTRA_TREE = register("large_socotra_tree", new LargeSocotraTreeFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> SMALL_SOCOTRA_TREE = register("small_socotra_tree", new SmallSocotraTreeFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<PointedRedstoneConfiguration>> POINTED_REDSTONE = register("pointed_redstone", new PointedRedstoneFeature(PointedRedstoneConfiguration.CODEC));
    Supplier<Feature<LargePointedRedstoneConfiguration>> LARGE_POINTED_REDSTONE = register("large_pointed_redstone", new LargePointedRedstoneFeature(LargePointedRedstoneConfiguration.CODEC));
    Supplier<Feature<PointedRedstoneClusterConfiguration>> POINTED_REDSTONE_CLUSTER = register("pointed_redstone_cluster", new PointedRedstoneClusterFeature(PointedRedstoneClusterConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> HANGING_PRISMARITE = register("hanging_prismarite", new HangingPrismariteFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<ColumnFeatureConfiguration>> BASALT_BLOB = register("basalt_blob", new BasaltBlobFeature(ColumnFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> ASH_VENT = register("scorch_vent", new AshVentFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> LAVA_FALL = register("lava_fall", new LavaFallFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<VegetationPatchConfiguration>> OVERWORLD_LAVA_DELTA = register("overworld_lava_delta", new LavaDeltaFeature(VegetationPatchConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> BRIM_WILLOW = register("brim_willow", new BrimWillowFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> TALL_BRIM_WILLOW = register("tall_brim_willow", new TallBrimWillowFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<ShrubConfiguration>> SHRUB = register("shrub", new ShrubFeature(ShrubConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> TREE_SHRUB = register("tree_shrub", new TreeShrubFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> GIANT_LILY = register("giant_lily", new GiantLilyPadFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> ICICLE_UP = register("icicle_up", new FloorIcicleFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<MultifaceGrowthConfiguration>> AIR_MULTIFACE_GROWTH = register("air_multiface_growth", new AirMultifaceGrowthFeature(MultifaceGrowthConfiguration.CODEC));
    Supplier<Feature<FallenTreeConfiguration>> FALLEN_BLOB_TREE = register("fallen_blob_tree", new FallenBlobTreeFeature(FallenTreeConfiguration.CODEC));
    Supplier<Feature<FallenTreeConfiguration>> FALLEN_SNOW_TREE = register("fallen_snow_tree", new FallenSnowTreeFeature(FallenTreeConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> MEADOW_ROCK = register("meadow_rock", new MeadowRockFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> ROCK = register("rock", new RockFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<RUTreeConfiguration>> SPIRE = register("spire", new IceSpireFeature(RUTreeConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> MARSH = register("marsh", new MarshFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> WATER_EDGE = register("water_edge", new WaterEdgeFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> FEN_CATTAIL = register("fen_cattail", new FenCattailFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> WATER_CATTAIL = register("water_cattail", new WaterCattailFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> ROCK_PILLAR = register("rock_pillar", new RockPillarFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<HyacinthStockConfiguration>> TALL_HYACINTH_STOCK = register("tall_hyacinth_stock", new HyacinthStockFeature(HyacinthStockConfiguration.CODEC));
    Supplier<Feature<ProbabilityFeatureConfiguration>> HYACINTH_PLANTS = register("hyacinth_plants", new HyacinthPlantsFeature(ProbabilityFeatureConfiguration.CODEC));
    Supplier<Feature<SeaRockConfiguration>> OCEAN_ROCK = register("ocean_rock", new SeaRockFeature(SeaRockConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> NETHER_ROCK = register("nether_rock", new NetherRockFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> GLISTERING_IVY = register("glistering_ivy", new GlisteringIvyFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> HANGING_EARLIGHT = register("hanging_earlight", new HangingEarlightFeature(NoneFeatureConfiguration.CODEC));
    Supplier<Feature<NoneFeatureConfiguration>> OBSIDIAN_SPIRE = register("obsidian_spire", new ObsidianSpireFeature(NoneFeatureConfiguration.CODEC));

    Supplier<Feature<RockFeatureConfig>> NEW_ROCK = register("new_rock", new NewRockFeature());

    private static <FC extends FeatureConfiguration> Supplier<Feature<FC>> register(String name, Feature<FC> feature) {
        Registrar.register(BuiltInRegistries.FEATURE, name, () -> feature);
        return () -> feature;
    }

    static void init() {
    }
}
