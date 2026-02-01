package net.regions_unexplored.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Optional;

public class RUBlockActions {
    public static void performBonemeal(Block $this, ServerLevel level, RandomSource random, BlockPos pos, ResourceKey<PlacedFeature> feature) {
        BlockPos above = pos.above();
        BlockState grass = Blocks.SHORT_GRASS.defaultBlockState();
        Optional<Holder.Reference<PlacedFeature>> grassFeature = level.registryAccess().lookupOrThrow(Registries.PLACED_FEATURE).get(feature);
        label:
        for (int j = 0; j < 128; ++j) {
            Holder<PlacedFeature> placementFeature;
            BlockPos testPos = above;
            for (int i = 0; i < j / 16; ++i) {
                if (!level.getBlockState((testPos = testPos.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1)).below()).is($this) || level.getBlockState(testPos).isCollisionShapeFullBlock(level, testPos)) continue label;
            }
            BlockState testState = level.getBlockState(testPos);
            if (testState.is(grass.getBlock()) && random.nextInt(10) == 0 && grass.getBlock() instanceof BonemealableBlock bonemealable && bonemealable.isValidBonemealTarget(level, testPos, testState)) {
                bonemealable.performBonemeal(level, random, testPos, testState);
            }
            if (!testState.isAir()) continue;
            if (random.nextInt(8) == 0) {
                List<ConfiguredFeature<?, ?>> features = level.getBiome(testPos).value().getGenerationSettings().getFlowerFeatures();
                if (features.isEmpty()) continue;
                int randomFlowerFeature = random.nextInt(features.size());
                placementFeature = ((RandomPatchConfiguration)features.get(randomFlowerFeature).config()).feature();
            } else {
                if (grassFeature.isEmpty()) continue;
                placementFeature = grassFeature.get();
            }
            placementFeature.value().place(level, level.getChunkSource().getGenerator(), random, testPos);
        }
    }
}
