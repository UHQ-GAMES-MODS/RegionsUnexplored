package net.regions_unexplored.world.level.block.other;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.registry.RUParticleTypes;

public class GlowingBioshroomBlock extends Block {
    private final float particleChance;
    private final int color;

    public GlowingBioshroomBlock(int color, float particleChance, Properties properties) {
        super(properties);
        this.particleChance = particleChance;
        this.color = color;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        int plantX = pos.getX();
        int plantY = pos.getY();
        int plantZ = pos.getZ();
        double xFalling = (double)plantX + random.nextDouble();
        double yFalling = (double)plantY + 0.7;
        double zFalling = (double)plantZ + random.nextDouble();

        if (random.nextFloat() >= this.particleChance) return;
        ColorParticleOption particle = ColorParticleOption.create(RUParticleTypes.FALLING_SPORE.get(), this.color);
        level.addParticle(particle, xFalling, yFalling, zFalling, 0.0, 0.0, 0.0);
    }
}
