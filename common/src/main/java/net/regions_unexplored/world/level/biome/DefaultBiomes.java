package net.regions_unexplored.world.level.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;

public class DefaultBiomes {
    //PRIMARY
    public static ResourceKey<Biome>[][] PRIMARY_MIDDLE_BIOMES = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.FROZEN_TUNDRA,    RuBiomes.FROZEN_TUNDRA,         RuBiomes.FROZEN_PINE_TAIGA, RuBiomes.COLD_BOREAL_TAIGA, RuBiomes.COLD_BOREAL_TAIGA},
            /*COOL*/    {RuBiomes.PUMPKIN_FIELDS,   RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.MAPLE_FOREST,      RuBiomes.BOREAL_TAIGA,      RuBiomes.BOREAL_TAIGA},
            /*NEUTRAL*/ {RuBiomes.ORCHARD,          RuBiomes.SHRUBLAND,             RuBiomes.TEMPERATE_GROVE,   RuBiomes.PINE_TAIGA,        RuBiomes.BLACKWOOD_TAIGA},
            /*WARM*/    {RuBiomes.BARLEY_FIELDS,    RuBiomes.PRAIRIE,               RuBiomes.GRASSLAND,         RuBiomes.REDWOODS,          RuBiomes.REDWOODS},
            /*HOT*/     {RuBiomes.BAOBAB_SAVANNA,   RuBiomes.BAOBAB_SAVANNA,        RuBiomes.SAGUARO_DESERT,    RuBiomes.OUTBACK,           RuBiomes.EUCALYPTUS_FOREST}};

    public static ResourceKey<Biome>[][] PRIMARY_MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.FROZEN_PINE_TAIGA,     RuBiomes.FROZEN_TUNDRA,         RuBiomes.FROZEN_TUNDRA,    RuBiomes.COLD_BOREAL_TAIGA, RuBiomes.SPIRES},
            /*COOL*/    {RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.MAPLE_FOREST,     RuBiomes.BOREAL_TAIGA,      RuBiomes.GOLDEN_BOREAL_TAIGA},
            /*NEUTRAL*/ {RuBiomes.ORCHARD,               RuBiomes.SHRUBLAND,             RuBiomes.TEMPERATE_GROVE,  RuBiomes.PINE_TAIGA,        RuBiomes.BLACKWOOD_TAIGA},
            /*WARM*/    {RuBiomes.PRAIRIE,               RuBiomes.DECIDUOUS_FOREST,      RuBiomes.GRASSLAND,        RuBiomes.REDWOODS,          RuBiomes.SPARSE_REDWOODS},
            /*HOT*/     {RuBiomes.BAOBAB_SAVANNA,        RuBiomes.BAOBAB_SAVANNA,        RuBiomes.SAGUARO_DESERT,   RuBiomes.OUTBACK,           RuBiomes.EUCALYPTUS_FOREST}};

    public static ResourceKey<Biome>[][] PRIMARY_PLATEAU_BIOMES = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.ICY_HEIGHTS,           RuBiomes.ICY_HEIGHTS,           RuBiomes.ICY_HEIGHTS,      RuBiomes.ICY_HEIGHTS,       RuBiomes.COLD_BOREAL_TAIGA},
            /*COOL*/    {RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.MAPLE_FOREST,     RuBiomes.BOREAL_TAIGA,      RuBiomes.BOREAL_TAIGA},
            /*NEUTRAL*/ {RuBiomes.HIGHLAND_FIELDS,       RuBiomes.HIGHLAND_FIELDS,       RuBiomes.HIGHLAND_FIELDS,  RuBiomes.HIGHLAND_FIELDS,   RuBiomes.BLACKWOOD_TAIGA},
            /*WARM*/    {RuBiomes.BARLEY_FIELDS,         RuBiomes.DECIDUOUS_FOREST,      RuBiomes.DECIDUOUS_FOREST, RuBiomes.REDWOODS,          RuBiomes.REDWOODS},
            /*HOT*/     {RuBiomes.STEPPE,                RuBiomes.STEPPE,                RuBiomes.SAGUARO_DESERT,   RuBiomes.EUCALYPTUS_FOREST, RuBiomes.EUCALYPTUS_FOREST}};

    public static ResourceKey<Biome>[][] PRIMARY_PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.ICY_HEIGHTS,           RuBiomes.ICY_HEIGHTS,           RuBiomes.ICY_HEIGHTS,      RuBiomes.ICY_HEIGHTS,       RuBiomes.SPIRES},
            /*COOL*/    {RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.MAPLE_FOREST,     RuBiomes.BOREAL_TAIGA,      RuBiomes.GOLDEN_BOREAL_TAIGA},
            /*NEUTRAL*/ {RuBiomes.ORCHARD,               RuBiomes.HIGHLAND_FIELDS,       RuBiomes.TEMPERATE_GROVE,  RuBiomes.PINE_TAIGA,        RuBiomes.BLACKWOOD_TAIGA},
            /*WARM*/    {RuBiomes.DECIDUOUS_FOREST,      RuBiomes.DECIDUOUS_FOREST,      RuBiomes.DECIDUOUS_FOREST, RuBiomes.REDWOODS,          RuBiomes.SPARSE_REDWOODS},
            /*HOT*/     {RuBiomes.STEPPE,                RuBiomes.STEPPE,                RuBiomes.SAGUARO_DESERT,   RuBiomes.EUCALYPTUS_FOREST, RuBiomes.EUCALYPTUS_FOREST}};

    public static ResourceKey<Biome>[][] PRIMARY_SHATTERED_BIOMES = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.ICY_HEIGHTS,      RuBiomes.ICY_HEIGHTS,      RuBiomes.ICY_HEIGHTS,      RuBiomes.ICY_HEIGHTS,       RuBiomes.ICY_HEIGHTS},
            /*COOL*/    {RuBiomes.TOWERING_CLIFFS,  RuBiomes.TOWERING_CLIFFS,  RuBiomes.TOWERING_CLIFFS,  RuBiomes.TOWERING_CLIFFS,   RuBiomes.TOWERING_CLIFFS},
            /*NEUTRAL*/ {RuBiomes.TOWERING_CLIFFS,  RuBiomes.TOWERING_CLIFFS,  RuBiomes.TOWERING_CLIFFS,  RuBiomes.TOWERING_CLIFFS,   RuBiomes.TOWERING_CLIFFS},
            /*WARM*/    {RuBiomes.BARLEY_FIELDS,    RuBiomes.DECIDUOUS_FOREST, RuBiomes.DECIDUOUS_FOREST, RuBiomes.SPARSE_REDWOODS,   RuBiomes.SPARSE_REDWOODS},
            /*HOT*/     {RuBiomes.STEPPE,           RuBiomes.STEPPE,           RuBiomes.SAGUARO_DESERT,   RuBiomes.EUCALYPTUS_FOREST, RuBiomes.EUCALYPTUS_FOREST}};

    public static ResourceKey<Biome>[][] PRIMARY_RIVER_BIOMES = new ResourceKey[][]{
            //-----------ARID,                DRY,                 NEUTRAL,                 WET,                     HUMID
            /*ICY*/     {Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER,     Biomes.FROZEN_RIVER,     RuBiomes.COLD_RIVER},
            /*COOL*/    {RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER, RuBiomes.MUDDY_RIVER,    RuBiomes.MUDDY_RIVER,    RuBiomes.MUDDY_RIVER},
            /*NEUTRAL*/ {Biomes.RIVER,        Biomes.RIVER,        Biomes.RIVER,            Biomes.RIVER,            RuBiomes.BLACKWOOD_TAIGA},
            /*WARM*/    {Biomes.RIVER,        Biomes.RIVER,        Biomes.RIVER,            Biomes.RIVER,            Biomes.RIVER},
            /*HOT*/     {Biomes.RIVER,        Biomes.RIVER,        RuBiomes.TROPICAL_RIVER, RuBiomes.TROPICAL_RIVER, RuBiomes.TROPICAL_RIVER}};

    public static ResourceKey<Biome>[][] PRIMARY_RIVER_BIOMES_VARIANT = new ResourceKey[][]{
            //-----------ARID,                DRY,                 NEUTRAL,                 WET,                     HUMID
            /*ICY*/     {Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER,     Biomes.FROZEN_RIVER,     RuBiomes.COLD_RIVER},
            /*COOL*/    {RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER, RuBiomes.MUDDY_RIVER,    RuBiomes.MUDDY_RIVER,    RuBiomes.MUDDY_RIVER},
            /*NEUTRAL*/ {Biomes.RIVER,        Biomes.RIVER,        Biomes.RIVER,            Biomes.RIVER,            RuBiomes.BLACKWOOD_TAIGA},
            /*WARM*/    {Biomes.RIVER,        Biomes.RIVER,        Biomes.RIVER,            Biomes.RIVER,            Biomes.RIVER},
            /*HOT*/     {Biomes.RIVER,        Biomes.RIVER,        RuBiomes.TROPICAL_RIVER, RuBiomes.TROPICAL_RIVER, RuBiomes.TROPICAL_RIVER}};

    public static ResourceKey<Biome>[][] PRIMARY_SWAMP_BIOMES = new ResourceKey[][]{
            //-----------ARID,                      DRY,                 NEUTRAL,             WET,                 HUMID
            /*ICY*/     {RuBiomes.SPIRES,           RuBiomes.SPIRES,     RuBiomes.SPIRES,     RuBiomes.SPIRES,     RuBiomes.SPIRES},
            /*COOL*/    {RuBiomes.FEN,              RuBiomes.FEN,        RuBiomes.FEN,        RuBiomes.FEN,        RuBiomes.FEN},
            /*NEUTRAL*/ {RuBiomes.OLD_GROWTH_BAYOU, RuBiomes.BAYOU,      RuBiomes.BAYOU,      RuBiomes.BAYOU,      RuBiomes.OLD_GROWTH_BAYOU},
            /*WARM*/    {RuBiomes.MARSH,            RuBiomes.MARSH,      RuBiomes.MARSH,      RuBiomes.MARSH,      RuBiomes.MARSH},
            /*HOT*/     {RuBiomes.FUNGAL_FEN,       RuBiomes.FUNGAL_FEN, RuBiomes.FUNGAL_FEN, RuBiomes.FUNGAL_FEN, RuBiomes.FUNGAL_FEN}};


    public static ResourceKey<Biome>[][] PRIMARY_OCEAN_BIOMES = new ResourceKey[][]{
            //----------- ARID,                    DRY,                    NEUTRAL,           WET,                        HUMID
            /*DEEP*/     {RuBiomes.HYACINTH_DEEPS, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN},
            /*NORM*/     {Biomes.FROZEN_OCEAN,     Biomes.COLD_OCEAN,      Biomes.OCEAN,      Biomes.LUKEWARM_OCEAN,      RuBiomes.ROCKY_REEF}};

    public static ResourceKey<Biome>[] PRIMARY_ISLAND_BIOMES = new ResourceKey[]       {RuBiomes.ALPHA_GROVE, RuBiomes.ALPHA_GROVE, RuBiomes.ASHEN_WOODLAND, RuBiomes.TROPICS, RuBiomes.TROPICS};

    public static ResourceKey<Biome>[] PRIMARY_BEACH_BIOMES = new ResourceKey[]        {Biomes.SNOWY_BEACH, RuBiomes.GRAVEL_BEACH, RuBiomes.GRASSY_BEACH, RuBiomes.GRASSY_BEACH, Biomes.BEACH};

    public static ResourceKey<Biome>[] PRIMARY_STONE_SHORE_BIOMES = new ResourceKey[]  {Biomes.STONY_SHORE, RuBiomes.CHALK_CLIFFS};

    public static ResourceKey<Biome> PRIMARY_SHATTERED_CLIFF_BIOME =                    RuBiomes.TOWERING_CLIFFS;

    public static ResourceKey<Biome>[] PRIMARY_CAVE_BIOMES = new ResourceKey[]         {Biomes.LUSH_CAVES, Biomes.DRIPSTONE_CAVES, Biomes.DEEP_DARK, RuBiomes.BIOSHROOM_CAVES, RuBiomes.ANCIENT_DELTA, RuBiomes.PRISMACHASM, RuBiomes.REDSTONE_CAVES, RuBiomes.SCORCHING_CAVES};

    public static ResourceKey<Biome>[] PRIMARY_PEAK_BIOMES = new ResourceKey[]         {Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS, RuBiomes.MOUNTAINS, Biomes.STONY_PEAKS, RuBiomes.ARID_MOUNTAINS};

    public static ResourceKey<Biome>[] PRIMARY_PEAK_BIOMES_VARIANT = new ResourceKey[] {Biomes.JAGGED_PEAKS, RuBiomes.MOUNTAINS, RuBiomes.MOUNTAINS, Biomes.STONY_PEAKS, RuBiomes.ARID_MOUNTAINS};

    public static ResourceKey<Biome>[] PRIMARY_SLOPE_BIOMES = new ResourceKey[]        {Biomes.SNOWY_SLOPES, Biomes.GROVE, RuBiomes.PINE_SLOPES, RuBiomes.DECIDUOUS_FOREST, RuBiomes.EUCALYPTUS_FOREST};

    public static ResourceKey<Biome>[] PRIMARY_SLOPE_BIOMES_VARIANT = new ResourceKey[]{RuBiomes.COLD_DECIDUOUS_FOREST, RuBiomes.PINE_SLOPES, RuBiomes.PINE_SLOPES, RuBiomes.DECIDUOUS_FOREST, RuBiomes.EUCALYPTUS_FOREST};




    //SECONDARY
    public static ResourceKey<Biome>[][] SECONDARY_MIDDLE_BIOMES = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.FROZEN_TUNDRA, RuBiomes.FROZEN_TUNDRA,       RuBiomes.FROZEN_PINE_TAIGA, RuBiomes.COLD_BOREAL_TAIGA, RuBiomes.COLD_BOREAL_TAIGA},
            /*COOL*/    {RuBiomes.POPPY_FIELDS,  RuBiomes.SILVER_BIRCH_FOREST, RuBiomes.MAPLE_FOREST,      RuBiomes.BOREAL_TAIGA,      RuBiomes.BOREAL_TAIGA},
            /*NEUTRAL*/ {RuBiomes.FLOWER_FIELDS, RuBiomes.ROCKY_MEADOW,        RuBiomes.WILLOW_FOREST,     RuBiomes.CLOVER_PLAINS,     RuBiomes.BLACKWOOD_TAIGA},
            /*WARM*/    {RuBiomes.MAUVE_HILLS,   RuBiomes.ROCKY_MEADOW,        RuBiomes.BAMBOO_FOREST,     RuBiomes.REDWOODS,          RuBiomes.REDWOODS},
            /*HOT*/     {RuBiomes.DRY_BUSHLAND,  RuBiomes.DRY_BUSHLAND,        RuBiomes.JOSHUA_DESERT,     RuBiomes.RAINFOREST,        RuBiomes.RAINFOREST}};

    public static ResourceKey<Biome>[][] SECONDARY_MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.FROZEN_PINE_TAIGA, RuBiomes.FROZEN_TUNDRA,       RuBiomes.FROZEN_TUNDRA,     RuBiomes.COLD_BOREAL_TAIGA, RuBiomes.SPIRES},
            /*COOL*/    {RuBiomes.POPPY_FIELDS,      RuBiomes.SILVER_BIRCH_FOREST, RuBiomes.MAPLE_FOREST,      RuBiomes.BOREAL_TAIGA,      RuBiomes.GOLDEN_BOREAL_TAIGA},
            /*NEUTRAL*/ {RuBiomes.FLOWER_FIELDS,     RuBiomes.ROCKY_MEADOW,        RuBiomes.MAGNOLIA_WOODLAND, RuBiomes.CLOVER_PLAINS,     RuBiomes.BLACKWOOD_TAIGA},
            /*WARM*/    {RuBiomes.MAUVE_HILLS,       RuBiomes.ROCKY_MEADOW,        RuBiomes.BAMBOO_FOREST,     RuBiomes.REDWOODS,          RuBiomes.SPARSE_REDWOODS},
            /*HOT*/     {RuBiomes.DRY_BUSHLAND,      RuBiomes.DRY_BUSHLAND,        RuBiomes.JOSHUA_DESERT,     RuBiomes.RAINFOREST,        RuBiomes.SPARSE_RAINFOREST}};

    public static ResourceKey<Biome>[][] SECONDARY_PLATEAU_BIOMES = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.ICY_HEIGHTS,     RuBiomes.ICY_HEIGHTS,         RuBiomes.ICY_HEIGHTS,       RuBiomes.ICY_HEIGHTS,       RuBiomes.COLD_BOREAL_TAIGA},
            /*COOL*/    {RuBiomes.POPPY_FIELDS,    RuBiomes.SILVER_BIRCH_FOREST, RuBiomes.MAPLE_FOREST,      RuBiomes.BOREAL_TAIGA,      RuBiomes.BOREAL_TAIGA},
            /*NEUTRAL*/ {RuBiomes.HIGHLAND_FIELDS, RuBiomes.HIGHLAND_FIELDS,     RuBiomes.HIGHLAND_FIELDS,   RuBiomes.HIGHLAND_FIELDS,   RuBiomes.BLACKWOOD_TAIGA},
            /*WARM*/    {RuBiomes.MAUVE_HILLS,     RuBiomes.MAGNOLIA_WOODLAND,   RuBiomes.MAGNOLIA_WOODLAND, RuBiomes.MAGNOLIA_WOODLAND, RuBiomes.REDWOODS},
            /*HOT*/     {RuBiomes.STEPPE,          RuBiomes.STEPPE,              RuBiomes.JOSHUA_DESERT,     RuBiomes.RAINFOREST,        RuBiomes.RAINFOREST}};

    public static ResourceKey<Biome>[][] SECONDARY_PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {RuBiomes.ICY_HEIGHTS,     RuBiomes.ICY_HEIGHTS,         RuBiomes.ICY_HEIGHTS,       RuBiomes.ICY_HEIGHTS,       RuBiomes.SPIRES},
            /*COOL*/    {RuBiomes.POPPY_FIELDS,    RuBiomes.SILVER_BIRCH_FOREST, RuBiomes.MAPLE_FOREST,      RuBiomes.BOREAL_TAIGA,      RuBiomes.GOLDEN_BOREAL_TAIGA},
            /*NEUTRAL*/ {RuBiomes.HIGHLAND_FIELDS, RuBiomes.HIGHLAND_FIELDS,     RuBiomes.MAGNOLIA_WOODLAND, RuBiomes.CLOVER_PLAINS,     RuBiomes.BLACKWOOD_TAIGA},
            /*WARM*/    {RuBiomes.MAUVE_HILLS,     RuBiomes.MAGNOLIA_WOODLAND,   RuBiomes.MAGNOLIA_WOODLAND, RuBiomes.MAGNOLIA_WOODLAND, RuBiomes.SPARSE_REDWOODS},
            /*HOT*/     {RuBiomes.STEPPE,          RuBiomes.STEPPE,              RuBiomes.JOSHUA_DESERT,     RuBiomes.RAINFOREST,        RuBiomes.SPARSE_RAINFOREST}};

    public static ResourceKey<Biome>[][] SECONDARY_SHATTERED_BIOMES = new ResourceKey[][]{
            //-----------ARID,                        DRY,                         NEUTRAL,                     WET,                        HUMID
            /*ICY*/     {RuBiomes.ICY_HEIGHTS,        RuBiomes.ICY_HEIGHTS,        RuBiomes.ICY_HEIGHTS,        RuBiomes.ICY_HEIGHTS,        RuBiomes.ICY_HEIGHTS},
            /*COOL*/    {RuBiomes.TOWERING_CLIFFS,    RuBiomes.TOWERING_CLIFFS,    RuBiomes.TOWERING_CLIFFS,    RuBiomes.TOWERING_CLIFFS,    RuBiomes.TOWERING_CLIFFS},
            /*NEUTRAL*/ {RuBiomes.TOWERING_CLIFFS,    RuBiomes.TOWERING_CLIFFS,    RuBiomes.TOWERING_CLIFFS,    RuBiomes.TOWERING_CLIFFS,    RuBiomes.TOWERING_CLIFFS},
            /*WARM*/    {RuBiomes.MAGNOLIA_WOODLAND,  RuBiomes.MAGNOLIA_WOODLAND,  RuBiomes.MAGNOLIA_WOODLAND,  RuBiomes.MAGNOLIA_WOODLAND,  RuBiomes.SPARSE_REDWOODS},
            /*HOT*/     {RuBiomes.STEPPE,             RuBiomes.STEPPE,             RuBiomes.JOSHUA_DESERT,      RuBiomes.SPARSE_RAINFOREST,  RuBiomes.SPARSE_RAINFOREST}};

    public static ResourceKey<Biome>[][] SECONDARY_RIVER_BIOMES = new ResourceKey[][]{
            //-----------ARID,                DRY,                 NEUTRAL,                 WET,                     HUMID
            /*ICY*/     {Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER,     Biomes.FROZEN_RIVER,     Biomes.FROZEN_RIVER},
            /*COOL*/    {RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER,     RuBiomes.MUDDY_RIVER,    RuBiomes.MUDDY_RIVER},
            /*NEUTRAL*/ {Biomes.RIVER,        Biomes.RIVER,        Biomes.RIVER,            Biomes.RIVER,            Biomes.RIVER},
            /*WARM*/    {Biomes.RIVER,        Biomes.RIVER,        Biomes.RIVER,            Biomes.RIVER,            Biomes.RIVER},
            /*HOT*/     {Biomes.RIVER,        Biomes.RIVER,        RuBiomes.TROPICAL_RIVER, RuBiomes.TROPICAL_RIVER, RuBiomes.TROPICAL_RIVER}};

    public static ResourceKey<Biome>[][] SECONDARY_RIVER_BIOMES_VARIANT = new ResourceKey[][]{
            //-----------ARID,                DRY,                 NEUTRAL,                 WET,                     HUMID
            /*ICY*/     {Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER,     Biomes.FROZEN_RIVER,     Biomes.FROZEN_RIVER},
            /*COOL*/    {RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER, RuBiomes.COLD_RIVER,     RuBiomes.MUDDY_RIVER,    RuBiomes.MUDDY_RIVER},
            /*NEUTRAL*/ {Biomes.RIVER,        Biomes.RIVER,        Biomes.RIVER,            Biomes.RIVER,            Biomes.RIVER},
            /*WARM*/    {Biomes.RIVER,        Biomes.RIVER,        Biomes.RIVER,            Biomes.RIVER,            Biomes.RIVER},
            /*HOT*/     {Biomes.RIVER,        Biomes.RIVER,        RuBiomes.TROPICAL_RIVER, RuBiomes.TROPICAL_RIVER, RuBiomes.TROPICAL_RIVER}};

    public static ResourceKey<Biome>[][] SECONDARY_SWAMP_BIOMES = new ResourceKey[][]{
            //-----------ARID,                      DRY,                 NEUTRAL,             WET,                 HUMID
            /*ICY*/     {RuBiomes.SPIRES,           RuBiomes.SPIRES,     RuBiomes.SPIRES,     RuBiomes.SPIRES,     RuBiomes.SPIRES},
            /*COOL*/    {RuBiomes.FEN,              RuBiomes.FEN,        RuBiomes.FEN,        RuBiomes.FEN,        RuBiomes.FEN},
            /*NEUTRAL*/ {RuBiomes.OLD_GROWTH_BAYOU, RuBiomes.BAYOU,      RuBiomes.BAYOU,      RuBiomes.BAYOU,      RuBiomes.OLD_GROWTH_BAYOU},
            /*WARM*/    {RuBiomes.MARSH,            RuBiomes.MARSH,      RuBiomes.MARSH,      RuBiomes.MARSH,      RuBiomes.MARSH},
            /*HOT*/     {RuBiomes.FUNGAL_FEN,       RuBiomes.FUNGAL_FEN, RuBiomes.FUNGAL_FEN, RuBiomes.FUNGAL_FEN, RuBiomes.FUNGAL_FEN}};


    public static ResourceKey<Biome>[][] SECONDARY_OCEAN_BIOMES = new ResourceKey[][]{
            //-----------ARID,                     DRY,                    NEUTRAL,           WET,                        HUMID
            /*DEEP*/     {RuBiomes.HYACINTH_DEEPS, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN},
            /*NORM*/     {Biomes.FROZEN_OCEAN,     Biomes.COLD_OCEAN,      Biomes.OCEAN,      Biomes.LUKEWARM_OCEAN,      RuBiomes.ROCKY_REEF}};

    public static ResourceKey<Biome>[] SECONDARY_ISLAND_BIOMES = new ResourceKey[]       {RuBiomes.ALPHA_GROVE, RuBiomes.ALPHA_GROVE, RuBiomes.ASHEN_WOODLAND, RuBiomes.TROPICS, RuBiomes.TROPICS};

    public static ResourceKey<Biome>[] SECONDARY_BEACH_BIOMES = new ResourceKey[]        {Biomes.SNOWY_BEACH, RuBiomes.GRAVEL_BEACH, RuBiomes.GRASSY_BEACH, RuBiomes.GRASSY_BEACH, Biomes.BEACH};

    public static ResourceKey<Biome>[] SECONDARY_STONE_SHORE_BIOMES = new ResourceKey[]  {Biomes.STONY_SHORE, RuBiomes.CHALK_CLIFFS};

    public static ResourceKey<Biome>   SECONDARY_SHATTERED_CLIFF_BIOME =                    RuBiomes.TOWERING_CLIFFS;

    public static ResourceKey<Biome>[] SECONDARY_CAVE_BIOMES = new ResourceKey[]         {Biomes.LUSH_CAVES, Biomes.DRIPSTONE_CAVES, Biomes.DEEP_DARK, RuBiomes.BIOSHROOM_CAVES, RuBiomes.ANCIENT_DELTA, RuBiomes.PRISMACHASM, RuBiomes.REDSTONE_CAVES, RuBiomes.SCORCHING_CAVES};

    public static ResourceKey<Biome>[] SECONDARY_PEAK_BIOMES = new ResourceKey[]         {Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS, RuBiomes.MOUNTAINS, Biomes.STONY_PEAKS, RuBiomes.ARID_MOUNTAINS};

    public static ResourceKey<Biome>[] SECONDARY_PEAK_BIOMES_VARIANT = new ResourceKey[] {Biomes.JAGGED_PEAKS, RuBiomes.MOUNTAINS, RuBiomes.MOUNTAINS, Biomes.STONY_PEAKS, RuBiomes.ARID_MOUNTAINS};

    public static ResourceKey<Biome>[] SECONDARY_SLOPE_BIOMES = new ResourceKey[]        {Biomes.SNOWY_SLOPES, Biomes.GROVE, RuBiomes.PINE_SLOPES, RuBiomes.MAGNOLIA_WOODLAND, RuBiomes.RAINFOREST};

    public static ResourceKey<Biome>[] SECONDARY_SLOPE_BIOMES_VARIANT = new ResourceKey[]{RuBiomes.COLD_DECIDUOUS_FOREST, RuBiomes.PINE_SLOPES, RuBiomes.PINE_SLOPES, RuBiomes.MAGNOLIA_WOODLAND, RuBiomes.RAINFOREST};

    public static ResourceKey<Biome>[][] getPrimaryMiddleBiome(){
        ResourceKey<Biome>[][] PRIMARY_MIDDLE_BIOMES_CUSTOM = new ResourceKey[][]{
            //-----------ARID,DRY,NEUTRAL,WET,HUMID
            /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.IcyBiomes.HUMID)},
            /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.CoolBiomes.HUMID)},
            /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.NeutralBiomes.HUMID)},
            /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.WarmBiomes.HUMID)},
            /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomes.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return PRIMARY_MIDDLE_BIOMES_CUSTOM;
        }
        else{
            return PRIMARY_MIDDLE_BIOMES;
        }
    }
    public static ResourceKey<Biome>[][] getPrimaryMiddleBiomeVariant(){
        ResourceKey<Biome>[][] PRIMARY_MIDDLE_BIOMES_VARIANT_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.MiddleBiomeVariants.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return PRIMARY_MIDDLE_BIOMES_VARIANT_CUSTOM;
        }
        else{
            return PRIMARY_MIDDLE_BIOMES_VARIANT;
        }
    }
    public static ResourceKey<Biome>[][] getPrimaryPlateauBiome(){
        ResourceKey<Biome>[][] PRIMARY_PLATEAU_BIOMES_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomes.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return PRIMARY_PLATEAU_BIOMES_CUSTOM;
        }
        else{
            return PRIMARY_PLATEAU_BIOMES;
        }
    }
    public static ResourceKey<Biome>[][] getPrimaryPlateauBiomeVariant(){
        ResourceKey<Biome>[][] PRIMARY_PLATEAU_BIOMES_VARIANT_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PlateauBiomeVariants.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return PRIMARY_PLATEAU_BIOMES_VARIANT_CUSTOM;
        }
        else{
            return PRIMARY_PLATEAU_BIOMES_VARIANT;
        }
    }
    public static ResourceKey<Biome>[][] getPrimaryShatteredBiome(){
        ResourceKey<Biome>[][] PRIMARY_SHATTERED_BIOMES_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShatteredBiomes.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return PRIMARY_SHATTERED_BIOMES_CUSTOM;
        }
        else{
            return PRIMARY_SHATTERED_BIOMES;
        }
    }
    public static ResourceKey<Biome>[][] getPrimaryRiverBiome(){
        ResourceKey<Biome>[][] PRIMARY_RIVER_BIOMES_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomes.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return PRIMARY_RIVER_BIOMES_CUSTOM;
        }
        else{
            return PRIMARY_RIVER_BIOMES;
        }
    }
    public static ResourceKey<Biome>[][] getPrimaryRiverBiomeVariant(){
        ResourceKey<Biome>[][] PRIMARY_RIVER_BIOMES_VARIANT_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.RiverBiomesVariants.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return PRIMARY_RIVER_BIOMES_VARIANT_CUSTOM;
        }
        else{
            return PRIMARY_RIVER_BIOMES_VARIANT;
        }
    }
    public static ResourceKey<Biome>[][] getPrimarySwampBiome(){
        ResourceKey<Biome>[][] PRIMARY_SWAMP_BIOMES_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SwampBiomes.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return PRIMARY_SWAMP_BIOMES_CUSTOM;
        }
        else{
            return PRIMARY_SWAMP_BIOMES;
        }
    }
    public static ResourceKey<Biome>[][] getPrimaryOceanBiome(){
        ResourceKey<Biome>[][] PRIMARY_OCEAN_BIOMES_CUSTOM = new ResourceKey[][]{
                /*DEEP*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OceanBiomes.DeepOceans.ICY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OceanBiomes.DeepOceans.COLD), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OceanBiomes.DeepOceans.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OceanBiomes.DeepOceans.WARM), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OceanBiomes.DeepOceans.HOT)},
                /*NORM*/    {getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OceanBiomes.Oceans.ICY), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OceanBiomes.Oceans.COLD), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OceanBiomes.Oceans.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OceanBiomes.Oceans.WARM), getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OceanBiomes.Oceans.HOT)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return PRIMARY_OCEAN_BIOMES_CUSTOM;
        }
        else{
            return PRIMARY_OCEAN_BIOMES;
        }
    }
    public static ResourceKey<Biome> getPrimaryIslandBiome(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.IslandBiomes.ICY);
            }
            else{
                return PRIMARY_ISLAND_BIOMES[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.IslandBiomes.COLD);
            }
            else{
                return PRIMARY_ISLAND_BIOMES[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.IslandBiomes.NEUTRAL);
            }
            else{
                return PRIMARY_ISLAND_BIOMES[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.IslandBiomes.WARM);
            }
            else{
                return PRIMARY_ISLAND_BIOMES[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.IslandBiomes.HOT);
            }
            else{
                return PRIMARY_ISLAND_BIOMES[4];
            }
        }
    }
    public static ResourceKey<Biome> getPrimaryBeachBiome(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShoreBiomes.BeachBiomes.ICY);
            }
            else{
                return PRIMARY_BEACH_BIOMES[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShoreBiomes.BeachBiomes.COLD);
            }
            else{
                return PRIMARY_BEACH_BIOMES[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShoreBiomes.BeachBiomes.NEUTRAL);
            }
            else{
                return PRIMARY_BEACH_BIOMES[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShoreBiomes.BeachBiomes.WARM);
            }
            else{
                return PRIMARY_BEACH_BIOMES[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShoreBiomes.BeachBiomes.HOT);
            }
            else{
                return PRIMARY_BEACH_BIOMES[4];
            }
        }
    }
    public static ResourceKey<Biome> getPrimaryStoneShoreBiome(boolean isCold){
        if(isCold){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShoreBiomes.StoneBeachBiomes.COLD);
            }
            else{
                return PRIMARY_STONE_SHORE_BIOMES[0];
            }
        }
        else{
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.ShoreBiomes.StoneBeachBiomes.HOT);
            }
            else{
                return PRIMARY_STONE_SHORE_BIOMES[1];
            }
        }
    }
    public static ResourceKey<Biome> getPrimaryShatteredCliffBiome(){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.OtherBiomes.SHA_CLI);
            }
            else{
                return PRIMARY_SHATTERED_CLIFF_BIOME;
            }
    }
    public static ResourceKey<Biome> getPrimaryCaveBiome(int type){
        if(type==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.UndergroundBiomes.CAVE_1);
            }
            else{
                return PRIMARY_CAVE_BIOMES[0];
            }
        }
        else if(type==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.UndergroundBiomes.CAVE_2);
            }
            else{
                return PRIMARY_CAVE_BIOMES[1];
            }
        }
        else if(type==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.UndergroundBiomes.CAVE_3);
            }
            else{
                return PRIMARY_CAVE_BIOMES[2];
            }
        }
        else if(type==4){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.UndergroundBiomes.CAVE_4);
            }
            else{
                return PRIMARY_CAVE_BIOMES[3];
            }
        }
        else if(type==5){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.UndergroundBiomes.CAVE_5);
            }
            else{
                return PRIMARY_CAVE_BIOMES[4];
            }
        }
        else if(type==6){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.UndergroundBiomes.CAVE_6);
            }
            else{
                return PRIMARY_CAVE_BIOMES[5];
            }
        }
        else if(type==7){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.UndergroundBiomes.CAVE_7);
            }
            else{
                return PRIMARY_CAVE_BIOMES[6];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.UndergroundBiomes.CAVE_8);
            }
            else{
                return PRIMARY_CAVE_BIOMES[7];
            }
        }
    }
    public static ResourceKey<Biome> getPrimaryPeakBiome(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PeakBiomes.PeakBiomesGroup.ICY);
            }
            else{
                return PRIMARY_PEAK_BIOMES[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PeakBiomes.PeakBiomesGroup.COLD);
            }
            else{
                return PRIMARY_PEAK_BIOMES[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PeakBiomes.PeakBiomesGroup.NEUTRAL);
            }
            else{
                return PRIMARY_PEAK_BIOMES[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PeakBiomes.PeakBiomesGroup.WARM);
            }
            else{
                return PRIMARY_PEAK_BIOMES[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PeakBiomes.PeakBiomesGroup.HOT);
            }
            else{
                return PRIMARY_PEAK_BIOMES[4];
            }
        }
    }
    public static ResourceKey<Biome> getPrimaryPeakBiomeVariant(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PeakBiomes.PeakBiomesVariants.ICY);
            }
            else{
                return PRIMARY_PEAK_BIOMES_VARIANT[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PeakBiomes.PeakBiomesVariants.COLD);
            }
            else{
                return PRIMARY_PEAK_BIOMES_VARIANT[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PeakBiomes.PeakBiomesVariants.NEUTRAL);
            }
            else{
                return PRIMARY_PEAK_BIOMES_VARIANT[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PeakBiomes.PeakBiomesVariants.WARM);
            }
            else{
                return PRIMARY_PEAK_BIOMES_VARIANT[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.PeakBiomes.PeakBiomesVariants.HOT);
            }
            else{
                return PRIMARY_PEAK_BIOMES_VARIANT[4];
            }
        }
    }
    public static ResourceKey<Biome> getPrimarySlopeBiome(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SlopeBiomes.SlopeBiomesGroup.ICY);
            }
            else{
                return PRIMARY_SLOPE_BIOMES[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SlopeBiomes.SlopeBiomesGroup.COLD);
            }
            else{
                return PRIMARY_SLOPE_BIOMES[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SlopeBiomes.SlopeBiomesGroup.NEUTRAL);
            }
            else{
                return PRIMARY_SLOPE_BIOMES[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SlopeBiomes.SlopeBiomesGroup.WARM);
            }
            else{
                return PRIMARY_SLOPE_BIOMES[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SlopeBiomes.SlopeBiomesGroup.HOT);
            }
            else{
                return PRIMARY_SLOPE_BIOMES[4];
            }
        }
    }
    public static ResourceKey<Biome> getPrimarySlopeBiomeVariant(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SlopeBiomes.SlopeBiomesVariants.ICY);
            }
            else{
                return PRIMARY_SLOPE_BIOMES_VARIANT[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SlopeBiomes.SlopeBiomesVariants.COLD);
            }
            else{
                return PRIMARY_SLOPE_BIOMES_VARIANT[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SlopeBiomes.SlopeBiomesVariants.NEUTRAL);
            }
            else{
                return PRIMARY_SLOPE_BIOMES_VARIANT[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SlopeBiomes.SlopeBiomesVariants.WARM);
            }
            else{
                return PRIMARY_SLOPE_BIOMES_VARIANT[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.PrimaryRegions.SlopeBiomes.SlopeBiomesVariants.HOT);
            }
            else{
                return PRIMARY_SLOPE_BIOMES_VARIANT[4];
            }
        }
    }
    //SECONDARY_REGION
    public static ResourceKey<Biome>[][] getSecondaryMiddleBiome(){
        ResourceKey<Biome>[][] SECONDARY_MIDDLE_BIOMES_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomes.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return SECONDARY_MIDDLE_BIOMES_CUSTOM;
        }
        else{
            return SECONDARY_MIDDLE_BIOMES;
        }
    }
    public static ResourceKey<Biome>[][] getSecondaryMiddleBiomeVariant(){
        ResourceKey<Biome>[][] SECONDARY_MIDDLE_BIOMES_VARIANT_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.MiddleBiomeVariants.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return SECONDARY_MIDDLE_BIOMES_VARIANT_CUSTOM;
        }
        else{
            return SECONDARY_MIDDLE_BIOMES_VARIANT;
        }
    }
    public static ResourceKey<Biome>[][] getSecondaryPlateauBiome(){
        ResourceKey<Biome>[][] SECONDARY_PLATEAU_BIOMES_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomes.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return SECONDARY_PLATEAU_BIOMES_CUSTOM;
        }
        else{
            return SECONDARY_PLATEAU_BIOMES;
        }
    }
    public static ResourceKey<Biome>[][] getSecondaryPlateauBiomeVariant(){
        ResourceKey<Biome>[][] SECONDARY_PLATEAU_BIOMES_VARIANT_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PlateauBiomeVariants.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return SECONDARY_PLATEAU_BIOMES_VARIANT_CUSTOM;
        }
        else{
            return SECONDARY_PLATEAU_BIOMES_VARIANT;
        }
    }
    public static ResourceKey<Biome>[][] getSecondaryShatteredBiome(){
        ResourceKey<Biome>[][] SECONDARY_SHATTERED_BIOMES_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShatteredBiomes.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return SECONDARY_SHATTERED_BIOMES_CUSTOM;
        }
        else{
            return SECONDARY_SHATTERED_BIOMES;
        }
    }
    public static ResourceKey<Biome>[][] getSecondaryRiverBiome(){
        ResourceKey<Biome>[][] SECONDARY_RIVER_BIOMES_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomes.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return SECONDARY_RIVER_BIOMES_CUSTOM;
        }
        else{
            return SECONDARY_RIVER_BIOMES;
        }
    }
    public static ResourceKey<Biome>[][] getSecondaryRiverBiomeVariant(){
        ResourceKey<Biome>[][] SECONDARY_RIVER_BIOMES_VARIANT_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.RiverBiomesVariants.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return SECONDARY_RIVER_BIOMES_VARIANT_CUSTOM;
        }
        else{
            return SECONDARY_RIVER_BIOMES_VARIANT;
        }
    }
    public static ResourceKey<Biome>[][] getSecondarySwampBiome(){
        ResourceKey<Biome>[][] SECONDARY_SWAMP_BIOMES_CUSTOM = new ResourceKey[][]{
                //-----------ARID,DRY,NEUTRAL,WET,HUMID
                /*ICY*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.IcyBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.IcyBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.IcyBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.IcyBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.IcyBiomes.HUMID)},
                /*COOL*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.CoolBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.CoolBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.CoolBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.CoolBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.CoolBiomes.HUMID)},
                /*NEUTRAL*/ {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.NeutralBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.NeutralBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.NeutralBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.NeutralBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.NeutralBiomes.HUMID)},
                /*WARM*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.WarmBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.WarmBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.WarmBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.WarmBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.WarmBiomes.HUMID)},
                /*HOT*/     {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.HotBiomes.ARID), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.HotBiomes.DRY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.HotBiomes.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.HotBiomes.WET), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SwampBiomes.HotBiomes.HUMID)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return SECONDARY_SWAMP_BIOMES_CUSTOM;
        }
        else{
            return SECONDARY_SWAMP_BIOMES;
        }
    }
    public static ResourceKey<Biome>[][] getSecondaryOceanBiome(){
        ResourceKey<Biome>[][] SECONDARY_OCEAN_BIOMES_CUSTOM = new ResourceKey[][]{
                /*DEEP*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OceanBiomes.DeepOceans.ICY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OceanBiomes.DeepOceans.COLD), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OceanBiomes.DeepOceans.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OceanBiomes.DeepOceans.WARM), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OceanBiomes.DeepOceans.HOT)},
                /*NORM*/    {getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OceanBiomes.Oceans.ICY), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OceanBiomes.Oceans.COLD), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OceanBiomes.Oceans.NEUTRAL), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OceanBiomes.Oceans.WARM), getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OceanBiomes.Oceans.HOT)}};

        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return SECONDARY_OCEAN_BIOMES_CUSTOM;
        }
        else{
            return SECONDARY_OCEAN_BIOMES;
        }
    }
    public static ResourceKey<Biome> getSecondaryIslandBiome(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.IslandBiomes.ICY);
            }
            else{
                return SECONDARY_ISLAND_BIOMES[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.IslandBiomes.COLD);
            }
            else{
                return SECONDARY_ISLAND_BIOMES[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.IslandBiomes.NEUTRAL);
            }
            else{
                return SECONDARY_ISLAND_BIOMES[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.IslandBiomes.WARM);
            }
            else{
                return SECONDARY_ISLAND_BIOMES[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.IslandBiomes.HOT);
            }
            else{
                return SECONDARY_ISLAND_BIOMES[4];
            }
        }
    }
    public static ResourceKey<Biome> getSecondaryBeachBiome(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShoreBiomes.BeachBiomes.ICY);
            }
            else{
                return SECONDARY_BEACH_BIOMES[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShoreBiomes.BeachBiomes.COLD);
            }
            else{
                return SECONDARY_BEACH_BIOMES[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShoreBiomes.BeachBiomes.NEUTRAL);
            }
            else{
                return SECONDARY_BEACH_BIOMES[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShoreBiomes.BeachBiomes.WARM);
            }
            else{
                return SECONDARY_BEACH_BIOMES[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShoreBiomes.BeachBiomes.HOT);
            }
            else{
                return SECONDARY_BEACH_BIOMES[4];
            }
        }
    }
    public static ResourceKey<Biome> getSecondaryStoneShoreBiome(boolean isCold){
        if(isCold){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShoreBiomes.StoneBeachBiomes.COLD);
            }
            else{
                return SECONDARY_STONE_SHORE_BIOMES[0];
            }
        }
        else{
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.ShoreBiomes.StoneBeachBiomes.HOT);
            }
            else{
                return SECONDARY_STONE_SHORE_BIOMES[1];
            }
        }
    }
    public static ResourceKey<Biome> getSecondaryShatteredCliffBiome(){
        if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
            return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.OtherBiomes.SHA_CLI);
        }
        else{
            return SECONDARY_SHATTERED_CLIFF_BIOME;
        }
    }
    public static ResourceKey<Biome> getSecondaryCaveBiome(int type){
        if(type==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.UndergroundBiomes.CAVE_1);
            }
            else{
                return SECONDARY_CAVE_BIOMES[0];
            }
        }
        else if(type==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.UndergroundBiomes.CAVE_2);
            }
            else{
                return SECONDARY_CAVE_BIOMES[1];
            }
        }
        else if(type==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.UndergroundBiomes.CAVE_3);
            }
            else{
                return SECONDARY_CAVE_BIOMES[2];
            }
        }
        else if(type==4){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.UndergroundBiomes.CAVE_4);
            }
            else{
                return SECONDARY_CAVE_BIOMES[3];
            }
        }
        else if(type==5){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.UndergroundBiomes.CAVE_5);
            }
            else{
                return SECONDARY_CAVE_BIOMES[4];
            }
        }
        else if(type==6){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.UndergroundBiomes.CAVE_6);
            }
            else{
                return SECONDARY_CAVE_BIOMES[5];
            }
        }
        else if(type==7){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.UndergroundBiomes.CAVE_7);
            }
            else{
                return SECONDARY_CAVE_BIOMES[6];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.UndergroundBiomes.CAVE_8);
            }
            else{
                return SECONDARY_CAVE_BIOMES[7];
            }
        }
    }
    public static ResourceKey<Biome> getSecondaryPeakBiome(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PeakBiomes.PeakBiomesGroup.ICY);
            }
            else{
                return SECONDARY_PEAK_BIOMES[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PeakBiomes.PeakBiomesGroup.COLD);
            }
            else{
                return SECONDARY_PEAK_BIOMES[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PeakBiomes.PeakBiomesGroup.NEUTRAL);
            }
            else{
                return SECONDARY_PEAK_BIOMES[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PeakBiomes.PeakBiomesGroup.WARM);
            }
            else{
                return SECONDARY_PEAK_BIOMES[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PeakBiomes.PeakBiomesGroup.HOT);
            }
            else{
                return SECONDARY_PEAK_BIOMES[4];
            }
        }
    }
    public static ResourceKey<Biome> getSecondaryPeakBiomeVariant(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PeakBiomes.PeakBiomesVariants.ICY);
            }
            else{
                return SECONDARY_PEAK_BIOMES_VARIANT[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PeakBiomes.PeakBiomesVariants.COLD);
            }
            else{
                return SECONDARY_PEAK_BIOMES_VARIANT[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PeakBiomes.PeakBiomesVariants.NEUTRAL);
            }
            else{
                return SECONDARY_PEAK_BIOMES_VARIANT[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PeakBiomes.PeakBiomesVariants.WARM);
            }
            else{
                return SECONDARY_PEAK_BIOMES_VARIANT[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.PeakBiomes.PeakBiomesVariants.HOT);
            }
            else{
                return SECONDARY_PEAK_BIOMES_VARIANT[4];
            }
        }
    }
    public static ResourceKey<Biome> getSecondarySlopeBiome(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SlopeBiomes.SlopeBiomesGroup.ICY);
            }
            else{
                return SECONDARY_SLOPE_BIOMES[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SlopeBiomes.SlopeBiomesGroup.COLD);
            }
            else{
                return SECONDARY_SLOPE_BIOMES[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SlopeBiomes.SlopeBiomesGroup.NEUTRAL);
            }
            else{
                return SECONDARY_SLOPE_BIOMES[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SlopeBiomes.SlopeBiomesGroup.WARM);
            }
            else{
                return SECONDARY_SLOPE_BIOMES[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SlopeBiomes.SlopeBiomesGroup.HOT);
            }
            else{
                return SECONDARY_SLOPE_BIOMES[4];
            }
        }
    }
    public static ResourceKey<Biome> getSecondarySlopeBiomeVariant(int temperature){
        if(temperature==0){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SlopeBiomes.SlopeBiomesVariants.ICY);
            }
            else{
                return SECONDARY_SLOPE_BIOMES_VARIANT[0];
            }
        }
        else if(temperature==1){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SlopeBiomes.SlopeBiomesVariants.COLD);
            }
            else{
                return SECONDARY_SLOPE_BIOMES_VARIANT[1];
            }
        }
        else if(temperature==2){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SlopeBiomes.SlopeBiomesVariants.NEUTRAL);
            }
            else{
                return SECONDARY_SLOPE_BIOMES_VARIANT[2];
            }
        }
        else if(temperature==3){
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SlopeBiomes.SlopeBiomesVariants.WARM);
            }
            else{
                return SECONDARY_SLOPE_BIOMES_VARIANT[3];
            }
        }
        else {
            if(RegionsUnexploredConfig.TOGGLE_CUSTOM_REGIONS){
                return getBiome(RegionsUnexploredConfig.Regions.SecondaryRegions.SlopeBiomes.SlopeBiomesVariants.HOT);
            }
            else{
                return SECONDARY_SLOPE_BIOMES_VARIANT[4];
            }
        }
    }

    public static boolean isBiomeEnabled(ResourceKey<Biome> biome){
        if(biome== RuBiomes.ALPHA_GROVE){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_ALPHA_GROVE;
        }
        if(biome== RuBiomes.ARID_MOUNTAINS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_ARID_MOUNTAINS;
        }
        if(biome== RuBiomes.AUTUMNAL_MAPLE_FOREST){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_AUTUMNAL_MAPLE_FOREST;
        }
        if(biome== RuBiomes.BAMBOO_FOREST){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_BAMBOO_FOREST;
        }
        if(biome== RuBiomes.BAOBAB_SAVANNA){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_BAOBAB_SAVANNA;
        }
        if(biome== RuBiomes.BARLEY_FIELDS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_BARLEY_FIELDS;
        }
        if(biome== RuBiomes.BAYOU){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_BAYOU;
        }
        if(biome== RuBiomes.BLACKSTONE_BASIN){
            return RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_BLACKSTONE_BASIN;
        }
        if(biome== RuBiomes.BLACKWOOD_TAIGA){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_BLACKWOOD_TAIGA;
        }
        if(biome== RuBiomes.BOREAL_TAIGA){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_BOREAL_TAIGA;
        }
        if(biome== RuBiomes.CHALK_CLIFFS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_CHALK_CLIFFS;
        }
        if(biome== RuBiomes.COLD_BOREAL_TAIGA){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_COLD_BOREAL_TAIGA;
        }
        if(biome== RuBiomes.COLD_DECIDUOUS_FOREST){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_COLD_DECIDUOUS_FOREST;
        }
        if(biome== RuBiomes.COLD_RIVER){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_COLD_RIVER;
        }
        if(biome== RuBiomes.DECIDUOUS_FOREST){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_DECIDUOUS_FOREST;
        }
        if(biome== RuBiomes.DRY_BUSHLAND){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_DRY_BUSHLAND;
        }
        if(biome== RuBiomes.EUCALYPTUS_FOREST){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_EUCALYPTUS_FOREST;
        }
        if(biome== RuBiomes.FEN){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_FEN;
        }
        if(biome== RuBiomes.MARSH){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_MARSH;
        }
        if(biome== RuBiomes.FLOWER_FIELDS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_FLOWER_FIELDS;
        }
        if(biome== RuBiomes.FROZEN_PINE_TAIGA){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_FROZEN_PINE_TAIGA;
        }
        if(biome== RuBiomes.FROZEN_TUNDRA){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_FROZEN_TUNDRA;
        }
        if(biome== RuBiomes.FUNGAL_FEN){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_FUNGAL_FEN;
        }
        if(biome== RuBiomes.OLD_GROWTH_BAYOU){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_OLD_GROWTH_BAYOU;
        }
        if(biome== RuBiomes.GOLDEN_BOREAL_TAIGA){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_GOLDEN_BOREAL_TAIGA;
        }
        if(biome== RuBiomes.GRASSLAND){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_GRASSLAND;
        }
        if(biome== RuBiomes.GRASSY_BEACH){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_GRASSY_BEACH;
        }
        if(biome== RuBiomes.GRAVEL_BEACH){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_GRAVEL_BEACH;
        }
        if(biome== RuBiomes.HIGHLAND_FIELDS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_HIGHLAND_FIELDS;
        }
        if(biome== RuBiomes.HYACINTH_DEEPS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_HYACINTH_DEEPS;
        }
        if(biome== RuBiomes.ICY_HEIGHTS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_ICY_HEIGHTS;
        }
        if(biome== RuBiomes.JOSHUA_DESERT){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_JOSHUA_DESERT;
        }
        if(biome== RuBiomes.CLOVER_PLAINS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_CLOVER_PLAINS;
        }
        if(biome== RuBiomes.MAPLE_FOREST){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_MAPLE_FOREST;
        }
        if(biome== RuBiomes.MAUVE_HILLS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_MAUVE_HILLS;
        }
        if(biome== RuBiomes.ROCKY_MEADOW){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_MEADOW;
        }
        if(biome== RuBiomes.MOUNTAINS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_MOUNTAINS;
        }
        if(biome== RuBiomes.MUDDY_RIVER){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_MUDDY_RIVER;
        }
        if(biome== RuBiomes.SPARSE_RAINFOREST){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_SPARSE_RAINFOREST;
        }
        if(biome== RuBiomes.ORCHARD){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_ORCHARD;
        }
        if(biome== RuBiomes.OUTBACK){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_OUTBACK;
        }
        if(biome== RuBiomes.PINE_TAIGA){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_PINE_TAIGA;
        }
        if(biome== RuBiomes.PINE_SLOPES){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_PINE_SLOPES;
        }
        if(biome== RuBiomes.POPPY_FIELDS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_POPPY_FIELDS;
        }
        if(biome== RuBiomes.PRAIRIE){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_PRAIRIE;
        }
        if(biome== RuBiomes.PUMPKIN_FIELDS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_PUMPKIN_FIELDS;
        }
        if(biome== RuBiomes.RAINFOREST){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_RAINFOREST;
        }
        if(biome== RuBiomes.REDWOODS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_REDWOODS;
        }
        if(biome== RuBiomes.ROCKY_REEF){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_ROCKY_REEF;
        }
        if(biome== RuBiomes.SAGUARO_DESERT){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_SAGUARO_DESERT;
        }
        if(biome== RuBiomes.SHRUBLAND){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_SHRUBLAND;
        }
        if(biome== RuBiomes.SILVER_BIRCH_FOREST){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_SILVER_BIRCH_FOREST;
        }
        if(biome== RuBiomes.ASHEN_WOODLAND){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_ASHEN_WOODLAND;
        }
        if(biome== RuBiomes.SPARSE_REDWOODS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_SPARSE_REDWOODS;
        }
        if(biome== RuBiomes.SPIRES){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_SPIRES;
        }
        if(biome== RuBiomes.STEPPE){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_STEPPE;
        }
        if(biome== RuBiomes.TEMPERATE_GROVE){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_TEMPERATE_GROVE;
        }
        if(biome== RuBiomes.TOWERING_CLIFFS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_TOWERING_CLIFFS;
        }
        if(biome== RuBiomes.TROPICS){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_TROPICS;
        }
        if(biome== RuBiomes.TROPICAL_RIVER){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_TROPICAL_RIVER;
        }
        if(biome== RuBiomes.WILLOW_FOREST){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_WILLOW_FOREST;
        }
        if(biome== RuBiomes.MAGNOLIA_WOODLAND){
            return RegionsUnexploredConfig.BiomeToggles.OverworldBiomes.TOGGLE_MAGNOLIA_WOODLAND;
        }

        // Nether
        if (biome==RuBiomes.BLACKSTONE_BASIN) {
            return RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_BLACKSTONE_BASIN;
        }
        if (biome==RuBiomes.INFERNAL_HOLT) {
            return RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_INFERNAL_HOLT;
        }
        if (biome==RuBiomes.GLISTERING_MEADOW) {
            return RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_GLISTERING_MEADOW;
        }
        if (biome==RuBiomes.MYCOTOXIC_UNDERGROWTH) {
            return RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_MYCOTOXIC_UNDERGROWTH;
        }
        if (biome==RuBiomes.REDSTONE_ABYSS) {
            return RegionsUnexploredConfig.BiomeToggles.NetherBiomes.TOGGLE_REDSTONE_ABYSS;
        }

        // Caves
        if(biome== RuBiomes.ANCIENT_DELTA){
            return RegionsUnexploredConfig.BiomeToggles.CaveBiomes.TOGGLE_ANCIENT_DELTA;
        }
        if(biome== RuBiomes.BIOSHROOM_CAVES){
            return RegionsUnexploredConfig.BiomeToggles.CaveBiomes.TOGGLE_BIOSHROOM_CAVES;
        }
        if(biome== RuBiomes.PRISMACHASM){
            return RegionsUnexploredConfig.BiomeToggles.CaveBiomes.TOGGLE_PRISMACHASM;
        }
        if(biome== RuBiomes.REDSTONE_CAVES){
            return RegionsUnexploredConfig.BiomeToggles.CaveBiomes.TOGGLE_REDSTONE_CAVES;
        }
        if(biome== RuBiomes.SCORCHING_CAVES){
            return RegionsUnexploredConfig.BiomeToggles.CaveBiomes.TOGGLE_SCORCHING_CAVES;
        }

        return true;
    }

    public static ResourceKey<Biome> getBiome(String id){
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(id));
    }
}
