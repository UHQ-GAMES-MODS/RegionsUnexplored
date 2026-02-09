package net.regions_unexplored.world.level.block.cave;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.regions_unexplored.config.RuClientConfig;
import net.regions_unexplored.registry.RUParticleTypes;

public class PrismariteDoubleBlock extends DoublePlantBlock {

    public PrismariteDoubleBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.isSolidRender(level, pos);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() >= 0.1 * RuClientConfig.PRISMARITE_SPARKLE_RATE.get()) return;

        int plantX = pos.getX();
        int plantY = pos.getY();
        int plantZ = pos.getZ();

        BlockPos.MutableBlockPos ambientPos = new BlockPos.MutableBlockPos();
        for (int i = 0; i < 2; ++i) {
            ambientPos.set(plantX + Mth.nextInt(random, -2, 2), plantY + random.nextInt(3), plantZ + Mth.nextInt(random, -2, 2));
            BlockState particlePosState = level.getBlockState(ambientPos);
            if (particlePosState.isCollisionShapeFullBlock(level, ambientPos)) continue;

            level.addParticle(RUParticleTypes.PRISMARITE_SPARKLE.get(), (double)ambientPos.getX() + random.nextDouble(), (double)ambientPos.getY() + random.nextDouble(), (double)ambientPos.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
        }
    }
}

