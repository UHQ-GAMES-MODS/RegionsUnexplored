package net.regions_unexplored.world.level.block.leaves;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.client.particle.RuParticleTypes;
import net.regions_unexplored.config.RuCommonConfig;

public class MauveLeavesBlock extends LeavesBlock {
    public MauveLeavesBlock(Properties properties) {
        super(properties);
    }

    public void animateTick(BlockState state, Level level, BlockPos blockPos, RandomSource randomSource) {
        super.animateTick(state, level, blockPos, randomSource);
        if (randomSource.nextInt(10) == 0) {
            BlockPos blockpos = blockPos.below();
            BlockState blockstate = level.getBlockState(blockpos);
            if (!isFaceFull(blockstate.getCollisionShape(level, blockpos), Direction.UP)) {
                if(RuCommonConfig.TOGGLE_MAUVE_LEAVES_PARTICLE.get()) {
                    spawnParticleBelow(level, blockPos, randomSource, RuParticleTypes.MAUVE_LEAVES);
                }
            }
        }
    }

    public static void spawnParticleBelow(Level level, BlockPos blockPos, RandomSource source, ParticleOptions particleOptions) {
        double d0 = (double)blockPos.getX() + source.nextDouble();
        double d1 = (double)blockPos.getY() - 0.05D;
        double d2 = (double)blockPos.getZ() + source.nextDouble();
        level.addParticle(particleOptions, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}