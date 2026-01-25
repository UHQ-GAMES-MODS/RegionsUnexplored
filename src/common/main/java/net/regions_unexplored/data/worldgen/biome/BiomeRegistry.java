package net.regions_unexplored.data.worldgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.registry.data.RUBiomes;
import net.regions_unexplored.data.worldgen.biome.builder.*;

public class BiomeRegistry {
    public static void bootstrap(BootstrapContext<Biome> context) {
        HolderGetter<ConfiguredWorldCarver<?>> carversGetter = context.lookup(Registries.CONFIGURED_CARVER);
        HolderGetter<PlacedFeature> featuresGetter = context.lookup(Registries.PLACED_FEATURE);

        //FOREST
        register(context, RUBiomes.AUTUMNAL_MAPLE_FOREST, ForestBiomes.autumnalMapleForest(featuresGetter, carversGetter));
        register(context, RUBiomes.BAMBOO_FOREST, ForestBiomes.bambooForest(featuresGetter, carversGetter));
        register(context, RUBiomes.MAGNOLIA_WOODLAND, ForestBiomes.magnoliaHighlands(featuresGetter, carversGetter));
        register(context, RUBiomes.DECIDUOUS_FOREST, ForestBiomes.deciduousForest(featuresGetter, carversGetter));
        register(context, RUBiomes.MAPLE_FOREST, ForestBiomes.mapleForest(featuresGetter, carversGetter));
        register(context, RUBiomes.MAUVE_HILLS, ForestBiomes.mauveHills(featuresGetter, carversGetter));
        register(context, RUBiomes.ORCHARD, ForestBiomes.orchard(featuresGetter, carversGetter));
        register(context, RUBiomes.SILVER_BIRCH_FOREST, ForestBiomes.silverBirchForest(featuresGetter, carversGetter));
        register(context, RUBiomes.TEMPERATE_GROVE, ForestBiomes.temperateGrove(featuresGetter, carversGetter));
        register(context, RUBiomes.WILLOW_FOREST, ForestBiomes.willowForest(featuresGetter, carversGetter));
        //TAIGA
        register(context, RUBiomes.BLACKWOOD_TAIGA, TaigaBiomes.blackwoodTaiga(featuresGetter, carversGetter));
        register(context, RUBiomes.BOREAL_TAIGA, TaigaBiomes.borealTaiga(featuresGetter, carversGetter));
        register(context, RUBiomes.GOLDEN_BOREAL_TAIGA, TaigaBiomes.goldenBorealTaiga(featuresGetter, carversGetter));
        register(context, RUBiomes.PINE_TAIGA, TaigaBiomes.pineTaiga(featuresGetter, carversGetter));
        register(context, RUBiomes.REDWOODS, TaigaBiomes.redwoods(featuresGetter, carversGetter));
        register(context, RUBiomes.SPARSE_REDWOODS, TaigaBiomes.sparseRedwoods(featuresGetter, carversGetter));
        //PLAINS
        register(context, RUBiomes.BARLEY_FIELDS, PlainsBiomes.barleyFields(featuresGetter, carversGetter));
        register(context, RUBiomes.FLOWER_FIELDS, PlainsBiomes.flowerFields(featuresGetter, carversGetter));
        register(context, RUBiomes.GRASSLAND, PlainsBiomes.grassland(featuresGetter, carversGetter));
        register(context, RUBiomes.CLOVER_PLAINS, PlainsBiomes.cloverPlains(featuresGetter, carversGetter));
        register(context, RUBiomes.ROCKY_MEADOW, PlainsBiomes.rockyMeadow(featuresGetter, carversGetter));
        register(context, RUBiomes.POPPY_FIELDS, PlainsBiomes.poppyFields(featuresGetter, carversGetter));
        register(context, RUBiomes.PRAIRIE, PlainsBiomes.prairie(featuresGetter, carversGetter));
        register(context, RUBiomes.PUMPKIN_FIELDS, PlainsBiomes.pumpkinFields(featuresGetter, carversGetter));
        register(context, RUBiomes.SHRUBLAND, PlainsBiomes.shrubland(featuresGetter, carversGetter));
        //WET
        register(context, RUBiomes.BAYOU, WetBiomes.bayou(featuresGetter, carversGetter));
        register(context, RUBiomes.EUCALYPTUS_FOREST, WetBiomes.eucalyptusForest(featuresGetter, carversGetter));
        register(context, RUBiomes.FEN, WetBiomes.fen(featuresGetter, carversGetter));
        register(context, RUBiomes.MARSH, WetBiomes.marsh(featuresGetter, carversGetter));
        register(context, RUBiomes.FUNGAL_FEN, WetBiomes.fungalFen(featuresGetter, carversGetter));
        register(context, RUBiomes.OLD_GROWTH_BAYOU, WetBiomes.oldGrowthBayou(featuresGetter, carversGetter));
        register(context, RUBiomes.SPARSE_RAINFOREST, WetBiomes.rainforest(featuresGetter, carversGetter, false));
        register(context, RUBiomes.RAINFOREST, WetBiomes.rainforest(featuresGetter, carversGetter, true));
        //ARID
        register(context, RUBiomes.BAOBAB_SAVANNA, AridBiomes.baobabSavanna(featuresGetter, carversGetter));
        register(context, RUBiomes.DRY_BUSHLAND, AridBiomes.dryBushland(featuresGetter, carversGetter));
        register(context, RUBiomes.JOSHUA_DESERT, AridBiomes.joshuaDesert(featuresGetter, carversGetter));
        register(context, RUBiomes.OUTBACK, AridBiomes.outback(featuresGetter, carversGetter));
        register(context, RUBiomes.SAGUARO_DESERT, AridBiomes.saguaroDesert(featuresGetter, carversGetter));
        register(context, RUBiomes.STEPPE, AridBiomes.steppe(featuresGetter, carversGetter));
        //MOUNTAIN
        register(context, RUBiomes.ARID_MOUNTAINS, MountainBiomes.aridMountains(featuresGetter, carversGetter));
        register(context, RUBiomes.HIGHLAND_FIELDS, MountainBiomes.highlandFields(featuresGetter, carversGetter));
        register(context, RUBiomes.MOUNTAINS, MountainBiomes.mountainsAndSlopes(featuresGetter, carversGetter, false));
        register(context, RUBiomes.PINE_SLOPES, MountainBiomes.mountainsAndSlopes(featuresGetter, carversGetter, true));
        register(context, RUBiomes.TOWERING_CLIFFS, MountainBiomes.toweringCliffs(featuresGetter, carversGetter));
        //COASTAL
        register(context, RUBiomes.CHALK_CLIFFS, CoastalBiomes.chalkCliffs(featuresGetter, carversGetter));
        register(context, RUBiomes.GRASSY_BEACH, CoastalBiomes.grassyBeach(featuresGetter, carversGetter));
        register(context, RUBiomes.GRAVEL_BEACH, CoastalBiomes.gravelBeach(featuresGetter, carversGetter));
        //AQUATIC
        register(context, RUBiomes.ALPHA_GROVE, AquaticBiomes.alphaGrove(featuresGetter, carversGetter));
        register(context, RUBiomes.COLD_RIVER, AquaticBiomes.coldRiver(featuresGetter, carversGetter));
        register(context, RUBiomes.HYACINTH_DEEPS, AquaticBiomes.hyacinthDeeps(featuresGetter, carversGetter));
        register(context, RUBiomes.MUDDY_RIVER, AquaticBiomes.muddyRiver(featuresGetter, carversGetter));
        register(context, RUBiomes.ROCKY_REEF, AquaticBiomes.rockyReef(featuresGetter, carversGetter));
        register(context, RUBiomes.ASHEN_WOODLAND, AquaticBiomes.ashenWoodland(featuresGetter, carversGetter));
        register(context, RUBiomes.TROPICAL_RIVER, AquaticBiomes.tropicalRiver(featuresGetter, carversGetter));
        register(context, RUBiomes.TROPICS, AquaticBiomes.tropics(featuresGetter, carversGetter));
        //FROZEN
        register(context, RUBiomes.COLD_BOREAL_TAIGA, FrozenBiomes.coldBorealTaiga(featuresGetter, carversGetter));
        register(context, RUBiomes.COLD_DECIDUOUS_FOREST, FrozenBiomes.coldDeciduousForest(featuresGetter, carversGetter));
        register(context, RUBiomes.FROZEN_PINE_TAIGA, FrozenBiomes.frozenPineTaiga(featuresGetter, carversGetter));
        register(context, RUBiomes.FROZEN_TUNDRA, FrozenBiomes.frozenTundra(featuresGetter, carversGetter));
        register(context, RUBiomes.ICY_HEIGHTS, FrozenBiomes.icyHeights(featuresGetter, carversGetter));
        register(context, RUBiomes.SPIRES, FrozenBiomes.spires(featuresGetter, carversGetter));
        //CAVE
        register(context, RUBiomes.ANCIENT_DELTA, CaveBiomes.ancientDelta(featuresGetter, carversGetter));
        register(context, RUBiomes.BIOSHROOM_CAVES, CaveBiomes.bioshroomCaves(featuresGetter, carversGetter));
        register(context, RUBiomes.PRISMACHASM, CaveBiomes.prismachasm(featuresGetter, carversGetter));
        register(context, RUBiomes.REDSTONE_CAVES, CaveBiomes.redstoneCaves(featuresGetter, carversGetter));
        register(context, RUBiomes.SCORCHING_CAVES, CaveBiomes.scorchingCaves(featuresGetter, carversGetter));
        //NETHER
        register(context, RUBiomes.BLACKSTONE_BASIN, NetherBiomes.blackstoneBasin(featuresGetter, carversGetter));
        register(context, RUBiomes.INFERNAL_HOLT, NetherBiomes.infernalHolt(featuresGetter, carversGetter));
        register(context, RUBiomes.GLISTERING_MEADOW, NetherBiomes.glisteringMeadow(featuresGetter, carversGetter));
        register(context, RUBiomes.MYCOTOXIC_UNDERGROWTH, NetherBiomes.mycotoxicUndergrowth(featuresGetter, carversGetter));
        register(context, RUBiomes.REDSTONE_ABYSS, NetherBiomes.redstoneAbyss(featuresGetter, carversGetter));

    }

    private static void register(BootstrapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }
}