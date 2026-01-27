package net.regions_unexplored.world.level.block.other_dirt;

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
import net.regions_unexplored.registry.data.RUPlacedFeatures;
import net.regions_unexplored.world.level.block.RUBlockActions;

import java.util.List;
import java.util.Optional;

public class DeepslateGrassBlock extends DeepslateDirtBlock implements BonemealableBlock {
   public DeepslateGrassBlock(Properties properties) {
      super(properties);
   }

   public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
      return level.getBlockState(pos.above()).isAir();
   }

   public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
      return true;
   }

   @Override
   public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
      RUBlockActions.performBonemeal(this, level, random, pos, RUPlacedFeatures.BONEMEAL_DEEPSLATE_GRASS);
   }
}
