package net.regions_unexplored.world.level.block.alpha;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
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
import net.regions_unexplored.registry.data.RUPlacedFeatures;
import net.regions_unexplored.world.level.block.RUBlockActions;

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

   @Override
   public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
      RUBlockActions.performBonemeal(this, level, random, pos, RUPlacedFeatures.BONEMEAL_ALPHA_GRASS);
   }
}
