package net.regions_unexplored.world.level.block.forest_dirt;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.block.RuBlocks;

import java.util.List;
import java.util.Optional;

public class NoSpreadForestGrassBlock extends SpreadingForestDirtBlock implements BonemealableBlock {
   public NoSpreadForestGrassBlock(Properties properties) {
      super(properties);
   }

   public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state) {
      return levelReader.getBlockState(pos.above()).isAir();
   }

   public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
      return true;
   }

   public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
      BlockPos blockPos = pos.above();
      BlockState blockState = Blocks.SHORT_GRASS.defaultBlockState();
      Optional<Holder.Reference<PlacedFeature>> optional = level.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(VegetationPlacements.GRASS_BONEMEAL);

      label46:
      for(int i = 0; i < 128; ++i) {
         BlockPos blockPos1 = blockPos;

         for(int j = 0; j < i / 16; ++j) {
            blockPos1 = blockPos1.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
            if (!level.getBlockState(blockPos1.below()).is(this) || level.getBlockState(blockPos1).isCollisionShapeFullBlock(level, blockPos1)) {
               continue label46;
            }
         }

         BlockState blockState1 = level.getBlockState(blockPos1);
         if (blockState1.is(blockState.getBlock()) && random.nextInt(10) == 0) {
            ((BonemealableBlock)blockState.getBlock()).performBonemeal(level, random, blockPos1, blockState1);
         }

         if (blockState1.isAir()) {
            Holder<PlacedFeature> holder;
            if (random.nextInt(8) == 0) {
               List<ConfiguredFeature<?, ?>> list = level.getBiome(blockPos1).value().getGenerationSettings().getFlowerFeatures();
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

            holder.value().place(level, level.getChunkSource().getGenerator(), random, blockPos1);
         }
      }

   }

   @Override
   public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
      if (!canBeGrass(state, level, pos)) {
         level.setBlockAndUpdate(pos, RuBlocks.PEAT_DIRT.get().defaultBlockState());
      } else {
         if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
            BlockState blockstate = this.defaultBlockState();

            for(int i = 0; i < 4; ++i) {
               BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
               if (level.getBlockState(blockpos).is(RuBlocks.PEAT_DIRT.get()) && canPropagate(blockstate, level, blockpos)) {
                  level.setBlockAndUpdate(blockpos, RuBlocks.PEAT_GRASS_BLOCK.get().defaultBlockState().setValue(SNOWY, Boolean.valueOf(level.getBlockState(blockpos.above()).is(Blocks.SNOW))));
               }
            }
         }

      }
   }

   @Override
   public BlockState updateShape(BlockState p_56644_, Direction p_56645_, BlockState p_56646_, LevelAccessor p_56647_, BlockPos p_56648_, BlockPos p_56649_) {
      return RuBlocks.PEAT_GRASS_BLOCK.get().defaultBlockState();
   }

}
