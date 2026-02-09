package net.regions_unexplored.world.level.block.cave;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.client.color.RuColors;
import net.regions_unexplored.config.RuClientConfig;
import net.regions_unexplored.registry.RUParticleTypes;

public class PrismariteBlock extends BushBlock {
    public static final MapCodec<? extends PrismariteBlock> CODEC = simpleCodec(PrismariteBlock::new);
    protected static final float AABB_OFFSET = 3.0F;
    protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);

    public PrismariteBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
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
        if (random.nextFloat() >= 0.05 * RuClientConfig.PRISMARITE_SPARKLE_RATE.get()) return;

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
