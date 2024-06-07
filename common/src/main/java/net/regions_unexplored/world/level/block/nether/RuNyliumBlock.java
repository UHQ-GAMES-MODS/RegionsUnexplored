package net.regions_unexplored.world.level.block.nether;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class RuNyliumBlock extends NyliumBlock implements BonemealableBlock {
    protected final ResourceKey<ConfiguredFeature<?, ?>> bonemealfeature;

    public RuNyliumBlock(Properties properties, ResourceKey<ConfiguredFeature<?, ?>> bonemeal) {
        super(properties);
        this.bonemealfeature = bonemeal;
    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockState blockState = level.getBlockState(pos);
        BlockPos blockPos = pos.above();
        ChunkGenerator chunkgenerator = level.getChunkSource().getGenerator();
        Registry<ConfiguredFeature<?, ?>> registry = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
        this.place(registry, this.bonemealfeature, level, chunkgenerator, random, blockPos);

    }

    private void place(Registry<ConfiguredFeature<?, ?>> featureRegistry, ResourceKey<ConfiguredFeature<?, ?>> key, ServerLevel level, ChunkGenerator generator, RandomSource random, BlockPos pos) {
        featureRegistry.getHolder(key).ifPresent((holder) -> holder.value().place(level, generator, random, pos));
    }
}