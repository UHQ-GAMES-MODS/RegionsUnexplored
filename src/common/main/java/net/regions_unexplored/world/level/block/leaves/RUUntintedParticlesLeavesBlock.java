package net.regions_unexplored.world.level.block.leaves;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.BlockFactory;
import net.regions_unexplored.config.RuClientConfig;

import java.util.function.Supplier;

public class RUUntintedParticlesLeavesBlock extends LeavesBlock {
    public static final float PARTICLE_CHANCE = 0.025f;

    private final Supplier<SimpleParticleType> particle;

    public RUUntintedParticlesLeavesBlock(Properties properties, Supplier<SimpleParticleType> particle) {
        super(properties);
        this.particle = particle;
    }

    public static BlockFactory of(Supplier<SimpleParticleType> type) {
        return p -> new RUUntintedParticlesLeavesBlock(p, type);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        BlockPos below = pos.below();
        BlockState belowState = level.getBlockState(below);

        if (!(level instanceof ClientLevel clientLevel)) return;
        if (random.nextFloat() >= PARTICLE_CHANCE) return;
        if (isFaceFull(belowState.getCollisionShape(level, below), Direction.UP)) return;
        if (!RuClientConfig.LEAVES_PARTICLES.get()) return;

        spawnLeavesParticle(clientLevel, pos, random);
    }

    protected void spawnLeavesParticle(ClientLevel level, BlockPos pos, RandomSource random) {
        ParticleUtils.spawnParticleBelow(level, pos, random, this.particle.get());
    }
}
