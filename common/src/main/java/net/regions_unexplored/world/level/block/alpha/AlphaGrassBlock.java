package net.regions_unexplored.world.level.block.alpha;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.data.worldgen.placement.RuVegetationPlacements;

import java.util.List;
import java.util.Optional;

public class AlphaGrassBlock extends SpreadingAlphaDirtBlock implements BonemealableBlock {
   public AlphaGrassBlock(Properties properties) {
      super(properties);
   }

   @Override
   public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
      return levelReader.getBlockState(blockPos.above()).isAir();
   }

   public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      return true;
   }

   public void performBonemeal(ServerLevel p_221270_, RandomSource p_221271_, BlockPos p_221272_, BlockState p_221273_) {
      BlockPos blockpos = p_221272_.above();
      BlockState blockstate = Blocks.SHORT_GRASS.defaultBlockState();
      Optional<Holder.Reference<PlacedFeature>> optional = p_221270_.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(RuVegetationPlacements.ALPHA_ROSE);

      label46:
      for(int i = 0; i < 16; ++i) {
         BlockPos blockpos1 = blockpos;

         for(int j = 0; j < i / 16; ++j) {
            blockpos1 = blockpos1.offset(p_221271_.nextInt(3) - 1, (p_221271_.nextInt(3) - 1) * p_221271_.nextInt(3) / 2, p_221271_.nextInt(3) - 1);
            if (!p_221270_.getBlockState(blockpos1.below()).is(this) || p_221270_.getBlockState(blockpos1).isCollisionShapeFullBlock(p_221270_, blockpos1)) {
               continue label46;
            }
         }

         BlockState blockstate1 = p_221270_.getBlockState(blockpos1);
         if (blockstate1.is(blockstate.getBlock()) && p_221271_.nextInt(10) == 0) {
            ((BonemealableBlock)blockstate.getBlock()).performBonemeal(p_221270_, p_221271_, blockpos1, blockstate1);
         }

         if (blockstate1.isAir()) {
            Holder<PlacedFeature> holder;
            if (p_221271_.nextInt(8) == 0) {
               List<ConfiguredFeature<?, ?>> list = p_221270_.getBiome(blockpos1).value().getGenerationSettings().getFlowerFeatures();
               if (list.isEmpty()) {
                  continue;
               }

               holder = ((RandomPatchConfiguration)list.get(0).config()).feature();
            } else {
               if (!optional.isPresent()) {
                  continue;
               }

               holder = optional.get();
            }

            holder.value().place(p_221270_, p_221270_.getChunkSource().getGenerator(), p_221271_, blockpos1);
         }
      }

   }

}
