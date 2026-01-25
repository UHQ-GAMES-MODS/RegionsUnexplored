package net.regions_unexplored.registry.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.regions_unexplored.RegionsUnexplored;

public interface RUBiomes {
    ResourceKey<Biome> ALPHA_GROVE = key("alpha_grove");
    ResourceKey<Biome> ANCIENT_DELTA = key("ancient_delta");
    ResourceKey<Biome> ARID_MOUNTAINS = key("arid_mountains");
    ResourceKey<Biome> ASHEN_WOODLAND = key("ashen_woodland");
    ResourceKey<Biome> AUTUMNAL_MAPLE_FOREST = key("autumnal_maple_forest");
    ResourceKey<Biome> BAMBOO_FOREST = key("bamboo_forest");
    ResourceKey<Biome> BAOBAB_SAVANNA = key("baobab_savanna");
    ResourceKey<Biome> BARLEY_FIELDS = key("barley_fields");
    ResourceKey<Biome> BAYOU = key("bayou");
    ResourceKey<Biome> BIOSHROOM_CAVES = key("bioshroom_caves");
    ResourceKey<Biome> BLACKSTONE_BASIN = key("blackstone_basin");
    ResourceKey<Biome> BLACKWOOD_TAIGA = key("blackwood_taiga");
    ResourceKey<Biome> BOREAL_TAIGA = key("boreal_taiga");
    ResourceKey<Biome> CHALK_CLIFFS = key("chalk_cliffs");
    ResourceKey<Biome> CLOVER_PLAINS = key("clover_plains");
    ResourceKey<Biome> COLD_BOREAL_TAIGA = key("cold_boreal_taiga");
    ResourceKey<Biome> COLD_DECIDUOUS_FOREST = key("cold_deciduous_forest");
    ResourceKey<Biome> COLD_RIVER = key("cold_river");
    ResourceKey<Biome> DECIDUOUS_FOREST = key("deciduous_forest");
    ResourceKey<Biome> DRY_BUSHLAND = key("dry_bushland");
    ResourceKey<Biome> EUCALYPTUS_FOREST = key("eucalyptus_forest");
    ResourceKey<Biome> FEN = key("fen");
    ResourceKey<Biome> FLOWER_FIELDS = key("flower_fields");
    ResourceKey<Biome> FROZEN_PINE_TAIGA = key("frozen_pine_taiga");
    ResourceKey<Biome> FROZEN_TUNDRA = key("frozen_tundra");
    ResourceKey<Biome> FUNGAL_FEN = key("fungal_fen");
    ResourceKey<Biome> GLISTERING_MEADOW = key("glistering_meadow");
    ResourceKey<Biome> GOLDEN_BOREAL_TAIGA = key("golden_boreal_taiga");
    ResourceKey<Biome> GRASSLAND = key("grassland");
    ResourceKey<Biome> GRASSY_BEACH = key("grassy_beach");
    ResourceKey<Biome> GRAVEL_BEACH = key("gravel_beach");
    ResourceKey<Biome> HIGHLAND_FIELDS = key("highland_fields");
    ResourceKey<Biome> HYACINTH_DEEPS = key("hyacinth_deeps");
    ResourceKey<Biome> ICY_HEIGHTS = key("icy_heights");
    ResourceKey<Biome> INFERNAL_HOLT = key("infernal_holt");
    ResourceKey<Biome> JOSHUA_DESERT = key("joshua_desert");
    ResourceKey<Biome> MAGNOLIA_WOODLAND = key("magnolia_woodland");
    ResourceKey<Biome> MAPLE_FOREST = key("maple_forest");
    ResourceKey<Biome> MARSH = key("marsh");
    ResourceKey<Biome> MAUVE_HILLS = key("mauve_hills");
    ResourceKey<Biome> MOUNTAINS = key("mountains");
    ResourceKey<Biome> MUDDY_RIVER = key("muddy_river");
    ResourceKey<Biome> MYCOTOXIC_UNDERGROWTH = key("mycotoxic_undergrowth");
    ResourceKey<Biome> OLD_GROWTH_BAYOU = key("old_growth_bayou");
    ResourceKey<Biome> ORCHARD = key("orchard");
    ResourceKey<Biome> OUTBACK = key("outback");
    ResourceKey<Biome> PINE_SLOPES = key("pine_slopes");
    ResourceKey<Biome> PINE_TAIGA = key("pine_taiga");
    ResourceKey<Biome> POPPY_FIELDS = key("poppy_fields");
    ResourceKey<Biome> PRAIRIE = key("prairie");
    ResourceKey<Biome> PRISMACHASM = key("prismachasm");
    ResourceKey<Biome> PUMPKIN_FIELDS = key("pumpkin_fields");
    ResourceKey<Biome> RAINFOREST = key("rainforest");
    ResourceKey<Biome> REDSTONE_ABYSS = key("redstone_abyss");
    ResourceKey<Biome> REDSTONE_CAVES = key("redstone_caves");
    ResourceKey<Biome> REDWOODS = key("redwoods");
    ResourceKey<Biome> ROCKY_MEADOW = key("rocky_meadow");
    ResourceKey<Biome> ROCKY_REEF = key("rocky_reef");
    ResourceKey<Biome> SAGUARO_DESERT = key("saguaro_desert");
    ResourceKey<Biome> SCORCHING_CAVES = key("scorching_caves");
    ResourceKey<Biome> SHRUBLAND = key("shrubland");
    ResourceKey<Biome> SILVER_BIRCH_FOREST = key("silver_birch_forest");
    ResourceKey<Biome> SPARSE_RAINFOREST = key("sparse_rainforest");
    ResourceKey<Biome> SPARSE_REDWOODS = key("sparse_redwoods");
    ResourceKey<Biome> SPIRES = key("spires");
    ResourceKey<Biome> STEPPE = key("steppe");
    ResourceKey<Biome> TEMPERATE_GROVE = key("temperate_grove");
    ResourceKey<Biome> TOWERING_CLIFFS = key("towering_cliffs");
    ResourceKey<Biome> TROPICAL_RIVER = key("tropical_river");
    ResourceKey<Biome> TROPICS = key("tropics");
    ResourceKey<Biome> WILLOW_FOREST = key("willow_forest");

    ResourceKey<Biome> PLACEHOLDER_RIVER = key("placeholder_river");

    private static ResourceKey<Biome> key(String name) {
        return RegionsUnexplored.key(Registries.BIOME, name);
    }

    private static void putVillagerBiome(ResourceKey<Biome> key, VillagerType type) {
        VillagerType.BY_BIOME.put(key, type);
    }
    
    static void init() {
        //FOREST
        putVillagerBiome(AUTUMNAL_MAPLE_FOREST, VillagerType.PLAINS);
        putVillagerBiome(BAMBOO_FOREST, VillagerType.JUNGLE);
        putVillagerBiome(MAGNOLIA_WOODLAND, VillagerType.PLAINS);
        putVillagerBiome(DECIDUOUS_FOREST, VillagerType.PLAINS);
        putVillagerBiome(MAPLE_FOREST, VillagerType.TAIGA);
        putVillagerBiome(MAUVE_HILLS, VillagerType.PLAINS);
        putVillagerBiome(ORCHARD, VillagerType.PLAINS);
        putVillagerBiome(SILVER_BIRCH_FOREST, VillagerType.PLAINS);
        putVillagerBiome(TEMPERATE_GROVE, VillagerType.PLAINS);
        putVillagerBiome(WILLOW_FOREST, VillagerType.PLAINS);
        //TAIGA
        putVillagerBiome(BLACKWOOD_TAIGA, VillagerType.TAIGA);
        putVillagerBiome(BOREAL_TAIGA, VillagerType.TAIGA);
        putVillagerBiome(GOLDEN_BOREAL_TAIGA, VillagerType.TAIGA);
        putVillagerBiome(PINE_TAIGA, VillagerType.TAIGA);
        putVillagerBiome(REDWOODS, VillagerType.PLAINS);
        putVillagerBiome(SPARSE_REDWOODS, VillagerType.PLAINS);
        //PLAINS
        putVillagerBiome(BARLEY_FIELDS, VillagerType.PLAINS);
        putVillagerBiome(FLOWER_FIELDS, VillagerType.PLAINS);
        putVillagerBiome(GRASSLAND, VillagerType.PLAINS);
        putVillagerBiome(CLOVER_PLAINS, VillagerType.PLAINS);
        putVillagerBiome(ROCKY_MEADOW, VillagerType.PLAINS);
        putVillagerBiome(POPPY_FIELDS, VillagerType.PLAINS);
        putVillagerBiome(PRAIRIE, VillagerType.PLAINS);
        putVillagerBiome(PUMPKIN_FIELDS, VillagerType.PLAINS);
        putVillagerBiome(SHRUBLAND, VillagerType.TAIGA);
        //WET
        putVillagerBiome(BAYOU, VillagerType.SWAMP);
        putVillagerBiome(EUCALYPTUS_FOREST, VillagerType.JUNGLE);
        putVillagerBiome(FEN, VillagerType.SWAMP);
        putVillagerBiome(MARSH, VillagerType.SWAMP);
        putVillagerBiome(FUNGAL_FEN, VillagerType.SWAMP);
        putVillagerBiome(OLD_GROWTH_BAYOU, VillagerType.SWAMP);
        putVillagerBiome(SPARSE_RAINFOREST, VillagerType.JUNGLE);
        putVillagerBiome(RAINFOREST, VillagerType.JUNGLE);
        //ARID
        putVillagerBiome(BAOBAB_SAVANNA, VillagerType.SAVANNA);
        putVillagerBiome(DRY_BUSHLAND, VillagerType.SAVANNA);
        putVillagerBiome(JOSHUA_DESERT, VillagerType.DESERT);
        putVillagerBiome(OUTBACK, VillagerType.SAVANNA);
        putVillagerBiome(SAGUARO_DESERT, VillagerType.DESERT);
        putVillagerBiome(STEPPE, VillagerType.PLAINS);
        //MOUNTAIN
        putVillagerBiome(ARID_MOUNTAINS, VillagerType.SAVANNA);
        putVillagerBiome(HIGHLAND_FIELDS, VillagerType.PLAINS);
        putVillagerBiome(MOUNTAINS, VillagerType.TAIGA);
        putVillagerBiome(PINE_SLOPES, VillagerType.TAIGA);
        putVillagerBiome(TOWERING_CLIFFS, VillagerType.TAIGA);
        //COASTAL
        putVillagerBiome(CHALK_CLIFFS, VillagerType.PLAINS);
        putVillagerBiome(GRASSY_BEACH, VillagerType.PLAINS);
        putVillagerBiome(GRAVEL_BEACH, VillagerType.TAIGA);
        //AQUATIC
        putVillagerBiome(ALPHA_GROVE, VillagerType.PLAINS);
        putVillagerBiome(COLD_RIVER, VillagerType.PLAINS);
        putVillagerBiome(HYACINTH_DEEPS, VillagerType.PLAINS);
        putVillagerBiome(MUDDY_RIVER, VillagerType.PLAINS);
        putVillagerBiome(ROCKY_REEF, VillagerType.JUNGLE);
        putVillagerBiome(ASHEN_WOODLAND, VillagerType.TAIGA);
        putVillagerBiome(TROPICAL_RIVER, VillagerType.JUNGLE);
        putVillagerBiome(TROPICS, VillagerType.JUNGLE);
        //FROZEN
        putVillagerBiome(COLD_BOREAL_TAIGA, VillagerType.SNOW);
        putVillagerBiome(COLD_DECIDUOUS_FOREST, VillagerType.SNOW);
        putVillagerBiome(FROZEN_PINE_TAIGA, VillagerType.SNOW);
        putVillagerBiome(FROZEN_TUNDRA, VillagerType.SNOW);
        putVillagerBiome(ICY_HEIGHTS, VillagerType.SNOW);
        putVillagerBiome(SPIRES, VillagerType.SNOW);
        //CAVE
        putVillagerBiome(BIOSHROOM_CAVES, VillagerType.PLAINS);
        putVillagerBiome(ANCIENT_DELTA, VillagerType.PLAINS);
        putVillagerBiome(PRISMACHASM, VillagerType.PLAINS);
        putVillagerBiome(REDSTONE_CAVES, VillagerType.PLAINS);
        putVillagerBiome(SCORCHING_CAVES, VillagerType.PLAINS);
        //NETHER
        putVillagerBiome(BLACKSTONE_BASIN, VillagerType.PLAINS);
        putVillagerBiome(INFERNAL_HOLT, VillagerType.PLAINS);
        putVillagerBiome(GLISTERING_MEADOW, VillagerType.PLAINS);
        putVillagerBiome(MYCOTOXIC_UNDERGROWTH, VillagerType.PLAINS);
        putVillagerBiome(REDSTONE_ABYSS, VillagerType.PLAINS);
    }
}
