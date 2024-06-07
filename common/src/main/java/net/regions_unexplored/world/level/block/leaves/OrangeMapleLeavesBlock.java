package net.regions_unexplored.world.level.block.leaves;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.client.particle.RuParticleTypes;

public class OrangeMapleLeavesBlock extends LeavesBlock {
   public OrangeMapleLeavesBlock(Properties p_273704_) {
      super(p_273704_);
   }

   public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
      super.animateTick(blockState, level, blockPos, randomSource);
      if (randomSource.nextInt(10) == 0) {
         BlockPos blockpos = blockPos.below();
         BlockState blockstate = level.getBlockState(blockpos);
         if (!isFaceFull(blockstate.getCollisionShape(level, blockpos), Direction.UP)) {
            if(RegionsUnexploredConfig.Client.TOGGLE_RED_MAPLE_LEAVES_PARTICLE) {
               spawnParticleBelow(level, blockPos, randomSource, RuParticleTypes.ORANGE_MAPLE_LEAVES);
            }
         }
      }
   }

   public static void spawnParticleBelow(Level level, BlockPos blockPos, RandomSource randomSource, ParticleOptions particleOptions) {
      double d0 = (double)blockPos.getX() + randomSource.nextDouble();
      double d1 = (double)blockPos.getY() - 0.05D;
      double d2 = (double)blockPos.getZ() + randomSource.nextDouble();
      level.addAlwaysVisibleParticle(particleOptions, d0, d1, d2, 0.0D, 0.0D, 0.0D);
   }
}