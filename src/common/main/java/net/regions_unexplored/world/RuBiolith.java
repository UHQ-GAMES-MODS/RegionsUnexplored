package net.regions_unexplored.world;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.sub.BiomeParameterTargets;
import com.terraformersmc.biolith.api.biome.sub.CriterionBuilder;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
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

        // Swamps
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

        nether(RuCommonConfig.TOGGLE_MYCOTOXIC_UNDERGROWTH, Biomes.NETHER_WASTES, RuBiomes.MYCOTOXIC_UNDERGROWTH, 0.4);
        nether(RuCommonConfig.TOGGLE_GLISTERING_MEADOW, Biomes.SOUL_SAND_VALLEY, RuBiomes.GLISTERING_MEADOW, 0.4);
        nether(RuCommonConfig.TOGGLE_BLACKSTONE_BASIN, Biomes.CRIMSON_FOREST, RuBiomes.BLACKSTONE_BASIN, 0.4);
        nether(RuCommonConfig.TOGGLE_INFERNAL_HOLT, Biomes.BASALT_DELTAS, RuBiomes.INFERNAL_HOLT, 0.4);
        nether(RuCommonConfig.TOGGLE_REDSTONE_ABYSS, Biomes.WARPED_FOREST, RuBiomes.REDSTONE_ABYSS, 0.4);

        SurfaceGeneration.addOverworldSurfaceRules(RegionsUnexplored.id("rules/overworld"), RuSurfaceRuleData.overworld());
        SurfaceGeneration.addNetherSurfaceRules(RegionsUnexplored.id("rules/nether"), RuSurfaceRuleData.nether());
    }

    private static void nether(ModConfigSpec.ConfigValue<Boolean> config, ResourceKey<Biome> replacedBiome, ResourceKey<Biome> biome, double replacedAmount) {
        if (config.get()) {
            BiomePlacement.replaceNether(replacedBiome, biome, replacedAmount);
        }
    }
}
