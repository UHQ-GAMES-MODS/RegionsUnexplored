package net.regions_unexplored.world;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.sub.BiomeParameterTargets;
import com.terraformersmc.biolith.api.biome.sub.CriterionBuilder;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Climate.Parameter;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import net.regions_unexplored.data.worldgen.biome.surface.RuSurfaceRuleData;

public class RuBiolith {
    public static void init() {
        // Islands
        if (RuCommonConfig.TOGGLE_ALPHA_GROVE.get()) {
            BiomePlacement.addSubOverworld(Biomes.MUSHROOM_FIELDS, RuBiomes.ALPHA_GROVE, CriterionBuilder.allOf(
                CriterionBuilder.valueMax(BiomeParameterTargets.EROSION, 0),
                CriterionBuilder.valueMax(BiomeParameterTargets.TEMPERATURE, -0.1f)
            ));
        }
        if (RuCommonConfig.TOGGLE_ASHEN_WOODLAND.get()) {
            BiomePlacement.addSubOverworld(Biomes.MUSHROOM_FIELDS, RuBiomes.ASHEN_WOODLAND, CriterionBuilder.allOf(
                CriterionBuilder.valueMax(BiomeParameterTargets.EROSION, 0),
                CriterionBuilder.value(BiomeParameterTargets.TEMPERATURE, -0.1f, 0.2f)
            ));
        }
        if (RuCommonConfig.TOGGLE_TROPICS.get()) {
            BiomePlacement.addSubOverworld(Biomes.MUSHROOM_FIELDS, RuBiomes.TROPICS, CriterionBuilder.allOf(
                CriterionBuilder.valueMax(BiomeParameterTargets.EROSION, 0),
                CriterionBuilder.valueMin(BiomeParameterTargets.TEMPERATURE, 0.2f)
            ));
        }

        // Oceans
        if (RuCommonConfig.TOGGLE_HYACINTH_DEEPS.get()) {
            BiomePlacement.replaceOverworld(Biomes.DEEP_FROZEN_OCEAN, RuBiomes.HYACINTH_DEEPS, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_ROCKY_REEF.get()) {
            BiomePlacement.replaceOverworld(Biomes.WARM_OCEAN, RuBiomes.ROCKY_REEF, 0.3f);
        }

        // Beaches
        if (RuCommonConfig.TOGGLE_GRAVEL_BEACH.get()) {
            BiomePlacement.replaceOverworld(Biomes.BEACH, RuBiomes.GRAVEL_BEACH, 0.2f);
        }
        if (RuCommonConfig.TOGGLE_GRASSY_BEACH.get()) {
            BiomePlacement.replaceOverworld(Biomes.BEACH, RuBiomes.GRASSY_BEACH, 0.3f);
        }

        // Cliffs
        if (RuCommonConfig.TOGGLE_CHALK_CLIFFS.get()) {
            BiomePlacement.replaceOverworld(Biomes.STONY_SHORE, RuBiomes.CHALK_CLIFFS, 0.75f);
            BiomePlacement.addSubOverworld(RuBiomes.CHALK_CLIFFS, Biomes.STONY_SHORE, CriterionBuilder.anyOf(
                CriterionBuilder.valueMax(BiomeParameterTargets.TEMPERATURE, -0.1f),
                CriterionBuilder.valueMin(BiomeParameterTargets.EROSION, -0.5f)
            ));
        }

        // Rivers
        if (RuCommonConfig.TOGGLE_COLD_RIVER.get() || RuCommonConfig.TOGGLE_MUDDY_RIVER.get() || RuCommonConfig.TOGGLE_TROPICAL_RIVER.get()) {
            BiomePlacement.replaceOverworld(Biomes.RIVER, RuBiomes.PLACEHOLDER_RIVER, 0.5f);
            BiomePlacement.addSubOverworld(RuBiomes.PLACEHOLDER_RIVER, Biomes.RIVER, CriterionBuilder.value(BiomeParameterTargets.TEMPERATURE, -0.1f, 0.55f));
        }
        BiomePlacement.addSubOverworld(RuBiomes.PLACEHOLDER_RIVER, RuCommonConfig.TOGGLE_COLD_RIVER.get() ? RuBiomes.COLD_RIVER : Biomes.RIVER, CriterionBuilder.allOf(
            CriterionBuilder.valueMax(BiomeParameterTargets.TEMPERATURE, -0.1f),
            CriterionBuilder.valueMax(BiomeParameterTargets.HUMIDITY, 0.1f)
        ));
        BiomePlacement.addSubOverworld(RuBiomes.PLACEHOLDER_RIVER, RuCommonConfig.TOGGLE_MUDDY_RIVER.get() ? RuBiomes.MUDDY_RIVER : Biomes.RIVER, CriterionBuilder.allOf(
            CriterionBuilder.valueMax(BiomeParameterTargets.TEMPERATURE, -0.1f),
            CriterionBuilder.valueMin(BiomeParameterTargets.HUMIDITY, 0.1f)
        ));
        BiomePlacement.addSubOverworld(RuBiomes.PLACEHOLDER_RIVER, RuCommonConfig.TOGGLE_TROPICAL_RIVER.get() ? RuBiomes.TROPICAL_RIVER : Biomes.RIVER, CriterionBuilder.valueMin(BiomeParameterTargets.TEMPERATURE, 0.55f));


        // Caves
        if (RuCommonConfig.TOGGLE_ANCIENT_DELTA.get()) {
            // High humidity, high temperature, positive weirdness
            BiomePlacement.addSubOverworld(Biomes.DRIPSTONE_CAVES, RuBiomes.ANCIENT_DELTA, CriterionBuilder.allOf(
                CriterionBuilder.valueMax(BiomeParameterTargets.HUMIDITY, -0.3f)
            ));
        }
        if (RuCommonConfig.TOGGLE_BIOSHROOM_CAVES.get()) {
            // High humidity, high erosion, positive weirdness
            BiomePlacement.addSubOverworld(Biomes.LUSH_CAVES, RuBiomes.BIOSHROOM_CAVES, CriterionBuilder.allOf(
                CriterionBuilder.valueMin(BiomeParameterTargets.EROSION, 0.4f),
                CriterionBuilder.valueMin(BiomeParameterTargets.WEIRDNESS, 0f)
            ));
        }
        if (RuCommonConfig.TOGGLE_PRISMACHASM.get()) {
            // Low humidity, positive continents
            BiomePlacement.addOverworld(RuBiomes.PRISMACHASM, new Climate.ParameterPoint(
                Parameter.span(-1, 1),
                Parameter.span(-1, -0.8f),
                Parameter.span(-1.2f, 1),
                Parameter.span(0f, 1f),
                Parameter.span(0.2f, 0.9f),
                Parameter.span(-1, 1),
                0
            ));
        }
        if (RuCommonConfig.TOGGLE_REDSTONE_CAVES.get()) {
            // Low humidity, negative continents
            BiomePlacement.addOverworld(RuBiomes.REDSTONE_CAVES, new Climate.ParameterPoint(
                Parameter.span(-1, 1),
                Parameter.span(-1, -0.8f),
                Parameter.span(-1.2f, 1),
                Parameter.span(-1f, 0f),
                Parameter.span(0.2f, 0.9f),
                Parameter.span(-1, 1),
                0
            ));
        }
        if (RuCommonConfig.TOGGLE_SCORCHING_CAVES.get()) {
            // Low to medium humidity, below 1 depth
            BiomePlacement.addOverworld(RuBiomes.SCORCHING_CAVES, new Climate.ParameterPoint(
                Parameter.span(-1, 1f),
                Parameter.span(-1, 1),
                Parameter.span(-1.2f, 1),
                Parameter.span(-0.375f, 0.05f),
                Parameter.point(1.1f),
                Parameter.span(-1, 1),
                0
            ));
        }

        // Swamps
        if (RuCommonConfig.TOGGLE_SPIRES.get()) {
            BiomePlacement.addSubOverworld(Biomes.FROZEN_RIVER, RuBiomes.SPIRES, CriterionBuilder.valueMin(
                BiomeParameterTargets.EROSION, 0.6f
            ));
            BiomePlacement.addSubOverworld(Biomes.ICE_SPIKES, RuBiomes.SPIRES, CriterionBuilder.valueMin(
                BiomeParameterTargets.EROSION, 0.6f
            ));
            BiomePlacement.addSubOverworld(Biomes.SNOWY_PLAINS, RuBiomes.SPIRES, CriterionBuilder.valueMin(
                BiomeParameterTargets.EROSION, 0.6f
            ));
            BiomePlacement.addSubOverworld(Biomes.SNOWY_TAIGA, RuBiomes.SPIRES, CriterionBuilder.valueMin(
                BiomeParameterTargets.EROSION, 0.6f
            ));
            BiomePlacement.addSubOverworld(Biomes.TAIGA, RuBiomes.SPIRES, CriterionBuilder.allOf(
                CriterionBuilder.valueMax(BiomeParameterTargets.TEMPERATURE, -0.45f),
                CriterionBuilder.valueMin(BiomeParameterTargets.EROSION, 0.6f)
            ));
        }
        if (RuCommonConfig.TOGGLE_FEN.get()) {
            BiomePlacement.replaceOverworld(Biomes.SWAMP, RuBiomes.FEN, 0.25f);
        }
        if (RuCommonConfig.TOGGLE_FUNGAL_FEN.get()) {
            BiomePlacement.addSubOverworld(RuBiomes.FEN, RuBiomes.FUNGAL_FEN, CriterionBuilder.valueMin(
                BiomeParameterTargets.HUMIDITY, 0.2f
            ));
        }
        if (RuCommonConfig.TOGGLE_BAYOU.get()) {
            BiomePlacement.replaceOverworld(Biomes.SWAMP, RuBiomes.BAYOU, 0.5f);
        }
        if (RuCommonConfig.TOGGLE_OLD_GROWTH_BAYOU.get()) {
            BiomePlacement.addSubOverworld(RuBiomes.BAYOU, RuBiomes.OLD_GROWTH_BAYOU, CriterionBuilder.valueMin(
                BiomeParameterTargets.HUMIDITY, 0.2f
            ));
        }
        if (RuCommonConfig.TOGGLE_MARSH.get()) {
            BiomePlacement.replaceOverworld(Biomes.MANGROVE_SWAMP, RuBiomes.MARSH, 0.3f);
        }

        // Plains/Meadows
        if (RuCommonConfig.TOGGLE_FLOWER_FIELDS.get()) {
            BiomePlacement.replaceOverworld(Biomes.SUNFLOWER_PLAINS, RuBiomes.FLOWER_FIELDS, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_CLOVER_PLAINS.get()) {
            BiomePlacement.replaceOverworld(Biomes.SUNFLOWER_PLAINS, RuBiomes.CLOVER_PLAINS, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_SHRUBLAND.get()) {
            BiomePlacement.replaceOverworld(Biomes.PLAINS, RuBiomes.SHRUBLAND, 0.2f);
        }
        if (RuCommonConfig.TOGGLE_GRASSLAND.get()) {
            BiomePlacement.replaceOverworld(Biomes.PLAINS, RuBiomes.GRASSLAND, 0.2f);
        }
        if (RuCommonConfig.TOGGLE_POPPY_FIELDS.get()) {
            BiomePlacement.replaceOverworld(Biomes.PLAINS, RuBiomes.POPPY_FIELDS, 0.1f);
        }
        if (RuCommonConfig.TOGGLE_PUMPKIN_FIELDS.get()) {
            BiomePlacement.replaceOverworld(Biomes.PLAINS, RuBiomes.PUMPKIN_FIELDS, 0.1f);
        }
        if (RuCommonConfig.TOGGLE_HIGHLAND_FIELDS.get()) {
            BiomePlacement.replaceOverworld(Biomes.MEADOW, RuBiomes.HIGHLAND_FIELDS, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_MEADOW.get()) {
            BiomePlacement.replaceOverworld(Biomes.MEADOW, RuBiomes.ROCKY_MEADOW, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_FROZEN_TUNDRA.get()) {
            BiomePlacement.replaceOverworld(Biomes.SNOWY_PLAINS, RuBiomes.FROZEN_TUNDRA, 0.3f);
        }

        // Forests
        if (RuCommonConfig.TOGGLE_ORCHARD.get()) {
            BiomePlacement.replaceOverworld(Biomes.FLOWER_FOREST, RuBiomes.ORCHARD, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_MAUVE_HILLS.get()) {
            BiomePlacement.replaceOverworld(Biomes.FLOWER_FOREST, RuBiomes.MAUVE_HILLS, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_WILLOW_FOREST.get()) {
            BiomePlacement.replaceOverworld(Biomes.BIRCH_FOREST, RuBiomes.WILLOW_FOREST, 0.2f);
            BiomePlacement.addSubOverworld(Biomes.OLD_GROWTH_BIRCH_FOREST, RuBiomes.WILLOW_FOREST, CriterionBuilder.alternate(RuBiomes.WILLOW_FOREST, Biomes.BIRCH_FOREST));
        }
        if (RuCommonConfig.TOGGLE_AUTUMNAL_MAPLE_FOREST.get()) {
            BiomePlacement.replaceOverworld(Biomes.BIRCH_FOREST, RuBiomes.AUTUMNAL_MAPLE_FOREST, 0.2f);
        }
        if (RuCommonConfig.TOGGLE_SILVER_BIRCH_FOREST.get()) {
            BiomePlacement.addSubOverworld(Biomes.OLD_GROWTH_BIRCH_FOREST, RuBiomes.SILVER_BIRCH_FOREST, CriterionBuilder.alternate(RuBiomes.AUTUMNAL_MAPLE_FOREST, Biomes.BIRCH_FOREST));
        }
        if (RuCommonConfig.TOGGLE_BLACKWOOD_TAIGA.get()) {
            BiomePlacement.replaceOverworld(Biomes.DARK_FOREST, RuBiomes.BLACKWOOD_TAIGA, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_MAPLE_FOREST.get()) {
            BiomePlacement.replaceOverworld(Biomes.FOREST, RuBiomes.MAPLE_FOREST, 0.2f);
        }
        if (RuCommonConfig.TOGGLE_TEMPERATE_GROVE.get()) {
            BiomePlacement.replaceOverworld(Biomes.FOREST, RuBiomes.TEMPERATE_GROVE, 0.2f);
        }
        if (RuCommonConfig.TOGGLE_DECIDUOUS_FOREST.get()) {
            BiomePlacement.replaceOverworld(Biomes.FOREST, RuBiomes.DECIDUOUS_FOREST, 0.2f);
            BiomePlacement.addSubOverworld(RuBiomes.DECIDUOUS_FOREST, Biomes.FOREST, CriterionBuilder.valueMin(BiomeParameterTargets.TEMPERATURE, -0.1f));
        }
        if (RuCommonConfig.TOGGLE_COLD_DECIDUOUS_FOREST.get()) {
            var noiseCriterion = CriterionBuilder.allOf(
                CriterionBuilder.alternate(RuBiomes.DECIDUOUS_FOREST, Biomes.FOREST),
                CriterionBuilder.value(BiomeParameterTargets.HUMIDITY, -0.1f, 0.1f)
            );
            BiomePlacement.addSubOverworld(Biomes.SNOWY_TAIGA, RuBiomes.COLD_DECIDUOUS_FOREST, noiseCriterion);
            BiomePlacement.addSubOverworld(Biomes.SNOWY_PLAINS, RuBiomes.COLD_DECIDUOUS_FOREST, noiseCriterion);
        }
        if (RuCommonConfig.TOGGLE_MAGNOLIA_WOODLAND.get()) {
            BiomePlacement.replaceOverworld(Biomes.CHERRY_GROVE, RuBiomes.MAGNOLIA_WOODLAND, 0.35f);
        }

        // Taigas
        if (RuCommonConfig.TOGGLE_REDWOODS.get()) {
            BiomePlacement.replaceOverworld(Biomes.OLD_GROWTH_PINE_TAIGA, RuBiomes.REDWOODS, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_SPARSE_REDWOODS.get()) {
            BiomePlacement.addSubOverworld(Biomes.OLD_GROWTH_SPRUCE_TAIGA, RuBiomes.SPARSE_REDWOODS, CriterionBuilder.alternate(RuBiomes.REDWOODS, Biomes.OLD_GROWTH_PINE_TAIGA));
        }
        if (RuCommonConfig.TOGGLE_BOREAL_TAIGA.get()) {
            BiomePlacement.replaceOverworld(Biomes.TAIGA, RuBiomes.BOREAL_TAIGA, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_GOLDEN_BOREAL_TAIGA.get()) {
            BiomePlacement.addSubOverworld(RuBiomes.BOREAL_TAIGA, RuBiomes.GOLDEN_BOREAL_TAIGA, CriterionBuilder.valueMin(BiomeParameterTargets.WEIRDNESS, 0));
        }
        if (RuCommonConfig.TOGGLE_COLD_BOREAL_TAIGA.get()) {
            BiomePlacement.addSubOverworld(Biomes.SNOWY_TAIGA, RuBiomes.COLD_BOREAL_TAIGA, CriterionBuilder.alternate(RuBiomes.BOREAL_TAIGA, Biomes.TAIGA));
            BiomePlacement.addSubOverworld(RuBiomes.BOREAL_TAIGA, RuBiomes.COLD_BOREAL_TAIGA, CriterionBuilder.valueMax(BiomeParameterTargets.TEMPERATURE, -0.45f));
        }
        if (RuCommonConfig.TOGGLE_PINE_TAIGA.get()) {
            BiomePlacement.replaceOverworld(Biomes.TAIGA, RuBiomes.PINE_TAIGA, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_FROZEN_PINE_TAIGA.get()) {
            BiomePlacement.addSubOverworld(Biomes.SNOWY_TAIGA, RuBiomes.FROZEN_PINE_TAIGA, CriterionBuilder.alternate(RuBiomes.PINE_TAIGA, Biomes.TAIGA));
        }
        if (RuCommonConfig.TOGGLE_MOUNTAINS.get()) {
            BiomePlacement.replaceOverworld(Biomes.JAGGED_PEAKS, RuBiomes.MOUNTAINS, 0.3f);
            BiomePlacement.addSubOverworld(RuBiomes.MOUNTAINS, Biomes.JAGGED_PEAKS, CriterionBuilder.valueMin(BiomeParameterTargets.TEMPERATURE, -0.45f));
            BiomePlacement.addSubOverworld(Biomes.FROZEN_PEAKS, RuBiomes.MOUNTAINS, CriterionBuilder.allOf(
                CriterionBuilder.valueMin(BiomeParameterTargets.TEMPERATURE, -0.45f),
                CriterionBuilder.alternate(RuBiomes.MOUNTAINS, Biomes.JAGGED_PEAKS)
            ));
        }
        if (RuCommonConfig.TOGGLE_PINE_SLOPES.get()) {
            BiomePlacement.addSubOverworld(Biomes.SNOWY_SLOPES, RuBiomes.PINE_SLOPES, CriterionBuilder.allOf(
                    CriterionBuilder.valueMin(BiomeParameterTargets.TEMPERATURE, -0.45f),
                    CriterionBuilder.alternate(RuBiomes.MOUNTAINS, Biomes.JAGGED_PEAKS)
            ));
            BiomePlacement.addSubOverworld(Biomes.GROVE, RuBiomes.PINE_SLOPES, CriterionBuilder.allOf(
                CriterionBuilder.valueMin(BiomeParameterTargets.TEMPERATURE, -0.45f),
                CriterionBuilder.alternate(RuBiomes.MOUNTAINS, Biomes.JAGGED_PEAKS)
            ));
        }

        // Savannas
        if (RuCommonConfig.TOGGLE_PRAIRIE.get()) {
            BiomePlacement.replaceOverworld(Biomes.SAVANNA, RuBiomes.PRAIRIE, 0.2f);
            BiomePlacement.replaceOverworld(Biomes.SAVANNA_PLATEAU, RuBiomes.PRAIRIE, 0.2f);
        }
        if (RuCommonConfig.TOGGLE_BARLEY_FIELDS.get()) {
            BiomePlacement.replaceOverworld(Biomes.SAVANNA, RuBiomes.BARLEY_FIELDS, 0.2f);
            BiomePlacement.replaceOverworld(Biomes.SAVANNA_PLATEAU, RuBiomes.BARLEY_FIELDS, 0.2f);
        }
        if (RuCommonConfig.TOGGLE_DRY_BUSHLAND.get()) {
            BiomePlacement.replaceOverworld(Biomes.SAVANNA, RuBiomes.DRY_BUSHLAND, 0.3f);
            BiomePlacement.replaceOverworld(Biomes.SAVANNA_PLATEAU, RuBiomes.DRY_BUSHLAND, 0.3f);
        }

        // Jungles
        if (RuCommonConfig.TOGGLE_BAMBOO_FOREST.get()) {
            BiomePlacement.replaceOverworld(Biomes.BAMBOO_JUNGLE, RuBiomes.BAMBOO_FOREST, 0.3f);
        }
        if (RuCommonConfig.TOGGLE_RAINFOREST.get()) {
            BiomePlacement.replaceOverworld(Biomes.JUNGLE, RuBiomes.RAINFOREST, 0.35f);
        }
        if (RuCommonConfig.TOGGLE_SPARSE_RAINFOREST.get()) {
            BiomePlacement.replaceOverworld(Biomes.SPARSE_JUNGLE, RuBiomes.SPARSE_RAINFOREST, 0.35f);
        }

        // Deserts/Badlands
        if (RuCommonConfig.TOGGLE_OUTBACK.get()) {
            BiomePlacement.replaceOverworld(Biomes.BADLANDS, RuBiomes.OUTBACK, 0.5f);
            BiomePlacement.addSubOverworld(RuBiomes.OUTBACK, Biomes.BADLANDS, CriterionBuilder.not(CriterionBuilder.allOf(
                CriterionBuilder.value(BiomeParameterTargets.WEIRDNESS, -0.35f, 0.35f),
                CriterionBuilder.valueMin(BiomeParameterTargets.EROSION, -0.2225f)
            )));
        }
        if (RuCommonConfig.TOGGLE_BAOBAB_SAVANNA.get()) {
            BiomePlacement.replaceOverworld(Biomes.ERODED_BADLANDS, RuBiomes.BAOBAB_SAVANNA, 0.4f);
            BiomePlacement.addSubOverworld(RuBiomes.BAOBAB_SAVANNA, Biomes.ERODED_BADLANDS, CriterionBuilder.valueMax(BiomeParameterTargets.EROSION, -0.375f));
        }
        if (RuCommonConfig.TOGGLE_STEPPE.get()) {
            BiomePlacement.addSubOverworld(RuBiomes.BAOBAB_SAVANNA, RuBiomes.STEPPE, CriterionBuilder.not(CriterionBuilder.allOf(
                CriterionBuilder.value(BiomeParameterTargets.WEIRDNESS, -0.45f, 0.45f),
                CriterionBuilder.valueMin(BiomeParameterTargets.EROSION, -0.25f)
            )));
        }
        if (RuCommonConfig.TOGGLE_EUCALYPTUS_FOREST.get()) {
            BiomePlacement.replaceOverworld(Biomes.WOODED_BADLANDS, RuBiomes.EUCALYPTUS_FOREST, 0.4f);
        }
        if (RuCommonConfig.TOGGLE_JOSHUA_DESERT.get()) {
            BiomePlacement.replaceOverworld(Biomes.DESERT, RuBiomes.JOSHUA_DESERT, 0.2f);
        }
        if (RuCommonConfig.TOGGLE_SAGUARO_DESERT.get()) {
            BiomePlacement.replaceOverworld(Biomes.DESERT, RuBiomes.SAGUARO_DESERT, 0.2f);
        }
        if (RuCommonConfig.TOGGLE_ARID_MOUNTAINS.get()) {
            var noiseCriterion = CriterionBuilder.allOf(
                CriterionBuilder.anyOf(
                    CriterionBuilder.valueMax(BiomeParameterTargets.EROSION, -0.78f),
                    CriterionBuilder.allOf(
                            CriterionBuilder.valueMax(BiomeParameterTargets.EROSION, -0.375f),
                            CriterionBuilder.valueMin(BiomeParameterTargets.CONTINENTALNESS, 0.03f)
                    )
                ),
                CriterionBuilder.anyOf(
                    CriterionBuilder.value(BiomeParameterTargets.WEIRDNESS, -0.767f, -0.567f),
                    CriterionBuilder.value(BiomeParameterTargets.WEIRDNESS, 0.567f, 0.767f)
                )
            );
            BiomePlacement.addSubOverworld(Biomes.ERODED_BADLANDS, RuBiomes.ARID_MOUNTAINS, noiseCriterion);
            BiomePlacement.addSubOverworld(Biomes.BADLANDS, RuBiomes.ARID_MOUNTAINS, noiseCriterion);
            BiomePlacement.addSubOverworld(Biomes.WOODED_BADLANDS, RuBiomes.ARID_MOUNTAINS, noiseCriterion);
            BiomePlacement.addSubOverworld(RuBiomes.BAOBAB_SAVANNA, RuBiomes.ARID_MOUNTAINS, noiseCriterion);
            BiomePlacement.addSubOverworld(RuBiomes.EUCALYPTUS_FOREST, RuBiomes.ARID_MOUNTAINS, noiseCriterion);
        }

        // Misc.
        if (RuCommonConfig.TOGGLE_TOWERING_CLIFFS.get()) {
            BiomePlacement.replaceOverworld(Biomes.WINDSWEPT_SAVANNA, RuBiomes.TOWERING_CLIFFS, 0.4f);
        }
        if (RuCommonConfig.TOGGLE_ICY_HEIGHTS.get()) {
            var noiseCriterion = CriterionBuilder.allOf(
                CriterionBuilder.value(BiomeParameterTargets.EROSION, 0.45f, 0.55f),
                CriterionBuilder.valueMax(BiomeParameterTargets.CONTINENTALNESS, 0.03f),
                CriterionBuilder.valueMin(BiomeParameterTargets.WEIRDNESS, 0f)
            );
            BiomePlacement.addSubOverworld(Biomes.ICE_SPIKES, RuBiomes.ICY_HEIGHTS, noiseCriterion);
            BiomePlacement.addSubOverworld(Biomes.SNOWY_PLAINS, RuBiomes.ICY_HEIGHTS, noiseCriterion);
            BiomePlacement.addSubOverworld(Biomes.SNOWY_TAIGA, RuBiomes.ICY_HEIGHTS, noiseCriterion);
        }

        nether(RuCommonConfig.TOGGLE_MYCOTOXIC_UNDERGROWTH, Biomes.NETHER_WASTES, RuBiomes.MYCOTOXIC_UNDERGROWTH);
        nether(RuCommonConfig.TOGGLE_GLISTERING_MEADOW, Biomes.SOUL_SAND_VALLEY, RuBiomes.GLISTERING_MEADOW);
        nether(RuCommonConfig.TOGGLE_BLACKSTONE_BASIN, Biomes.CRIMSON_FOREST, RuBiomes.BLACKSTONE_BASIN);
        nether(RuCommonConfig.TOGGLE_INFERNAL_HOLT, Biomes.BASALT_DELTAS, RuBiomes.INFERNAL_HOLT);
        nether(RuCommonConfig.TOGGLE_REDSTONE_ABYSS, Biomes.WARPED_FOREST, RuBiomes.REDSTONE_ABYSS);

        SurfaceGeneration.addOverworldSurfaceRules(RegionsUnexplored.id("rules/overworld"), RuSurfaceRuleData.overworld());
        SurfaceGeneration.addNetherSurfaceRules(RegionsUnexplored.id("rules/nether"), RuSurfaceRuleData.nether());
    }

    private static void nether(ModConfigSpec.ConfigValue<Boolean> config, ResourceKey<Biome> replacedBiome, ResourceKey<Biome> biome) {
        if (config.get()) {
            BiomePlacement.replaceNether(replacedBiome, biome, 0.4);
        }
    }
}
