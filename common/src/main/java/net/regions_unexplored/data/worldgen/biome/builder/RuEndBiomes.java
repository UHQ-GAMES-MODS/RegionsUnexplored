package net.regions_unexplored.data.worldgen.biome.builder;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.EndPlacements;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class RuEndBiomes {
    public static Biome createEndBarrens() {
        BiomeGenerationSettings.PlainBuilder builder = (new BiomeGenerationSettings.PlainBuilder());
        return composeEndSpawnSettings(builder);
    }

    public static Biome createEndHighlands(HolderGetter<PlacedFeature> placedFeatures) {
        BiomeGenerationSettings.PlainBuilder builder = new BiomeGenerationSettings.PlainBuilder().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, placedFeatures.getOrThrow(EndPlacements.END_GATEWAY_RETURN));
        return composeEndSpawnSettings(builder);
    }

    private static Biome composeEndSpawnSettings(BiomeGenerationSettings.PlainBuilder builder) {
        MobSpawnSettings.Builder builder2 = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(builder2);
        return (new Biome.BiomeBuilder()).hasPrecipitation(false).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0).ambientMoodSound(
                AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(builder2.build()).generationSettings(builder.build()).build();
    }
}
