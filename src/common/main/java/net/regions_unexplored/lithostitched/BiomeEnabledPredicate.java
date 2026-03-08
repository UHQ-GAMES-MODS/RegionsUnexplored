package net.regions_unexplored.lithostitched;

import com.mojang.serialization.MapCodec;
import dev.worldgen.lithostitched.api.predicate.LoadPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.regions_unexplored.config.RuCommonConfig;

public record BiomeEnabledPredicate(ResourceKey<Biome> biome) implements LoadPredicate {
    public static final MapCodec<BiomeEnabledPredicate> CODEC = ResourceKey.codec(Registries.BIOME).fieldOf("biome").xmap(BiomeEnabledPredicate::new, BiomeEnabledPredicate::biome);

    @Override
    public boolean test() {
        return RuCommonConfig.BIOME_CONFIGS.get(biome).get();
    }

    @Override
    public MapCodec<? extends LoadPredicate> codec() {
        return CODEC;
    }
}
