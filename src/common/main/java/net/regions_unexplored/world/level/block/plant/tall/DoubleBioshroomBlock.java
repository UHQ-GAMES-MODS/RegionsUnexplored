package net.regions_unexplored.world.level.block.plant.tall;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.regions_unexplored.registry.RUParticleTypes;

public class DoubleBioshroomBlock extends DoublePlantBlock {
    private final int color;

    public DoubleBioshroomBlock(int color, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
        this.color = color;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.isSolidRender(level, pos);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() >= 0.2) return;

        int plantX = pos.getX();
        int plantY = pos.getY();
        int plantZ = pos.getZ();

        BlockPos.MutableBlockPos ambientPos = new BlockPos.MutableBlockPos();
        for (int i = 0; i < 2; ++i) {
            ambientPos.set(plantX + Mth.nextInt(random, -3, 3), plantY + random.nextInt(4), plantZ + Mth.nextInt(random, -3, 3));
            BlockState particlePosState = level.getBlockState(ambientPos);
            if (particlePosState.isCollisionShapeFullBlock(level, ambientPos)) continue;

            ColorParticleOption particle = ColorParticleOption.create(RUParticleTypes.FLOATING_SPORE.get(), this.color);
            level.addParticle(particle, (double)ambientPos.getX() + random.nextDouble(), (double)ambientPos.getY() + random.nextDouble(), (double)ambientPos.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
        }
    }
}
