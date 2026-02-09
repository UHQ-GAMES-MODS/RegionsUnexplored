package net.regions_unexplored.world.level.block.cave;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.client.color.RuColors;
import net.regions_unexplored.config.RuClientConfig;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.registry.RUParticleTypes;
import net.regions_unexplored.world.level.block.state.properties.HangingPrismariteShape;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

public class HangingPrismariteBlock extends Block {
    public static final EnumProperty<HangingPrismariteShape> SHAPE = RuBlockStateProperties.HANGING_PRISMARITE_SHAPE;
    protected static final VoxelShape BOX = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public HangingPrismariteBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(SHAPE, HangingPrismariteShape.TIP));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(SHAPE);
    }
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return BOX.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.above();
        return mayPlaceOn(level.getBlockState(blockpos), level, blockpos);
    }

    public boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.isFaceSturdy(getter, pos, Direction.DOWN) || state.is(RUBlocks.HANGING_PRISMARITE.get());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        HangingPrismariteShape shape = state.getValue(SHAPE);
        if(level.getBlockState(pos.below()) == RUBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(SHAPE, HangingPrismariteShape.TIP)) {
                shape = HangingPrismariteShape.FRUSTUM;
        }
        else if(level.getBlockState(pos.below()) == RUBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(SHAPE, HangingPrismariteShape.FRUSTUM)) {
            shape = HangingPrismariteShape.COLUMN;
        }
        else if(!level.getBlockState(pos.below()).is(RUBlocks.HANGING_PRISMARITE.get())) {
            shape = HangingPrismariteShape.TIP;
        }
        if(!this.canSurvive(state, level, pos)){
            return Blocks.AIR.defaultBlockState();
        }
        return state.setValue(SHAPE, shape);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        if(context.getLevel().getBlockState(context.getClickedPos().below())== RUBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(SHAPE, HangingPrismariteShape.FRUSTUM)
                ||context.getLevel().getBlockState(context.getClickedPos().below())== RUBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(SHAPE, HangingPrismariteShape.COLUMN)){
            return this.defaultBlockState().setValue(SHAPE, HangingPrismariteShape.COLUMN);
        }
        if(context.getLevel().getBlockState(context.getClickedPos().below())== RUBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(SHAPE, HangingPrismariteShape.TIP)){
            return this.defaultBlockState().setValue(SHAPE, HangingPrismariteShape.FRUSTUM);
        }
        else{
            return this.defaultBlockState().setValue(SHAPE, HangingPrismariteShape.TIP);
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() >= 0.15 * RuClientConfig.PRISMARITE_SPARKLE_RATE.get()) return;

        int plantX = pos.getX();
        int plantY = pos.getY();
        int plantZ = pos.getZ();

        BlockPos.MutableBlockPos ambientPos = new BlockPos.MutableBlockPos();
        for (int i = 0; i < 3; ++i) {
            ambientPos.set(plantX + Mth.nextInt(random, -2, 2), plantY + Mth.nextInt(random, -2, 2), plantZ + Mth.nextInt(random, -2, 2));
            BlockState particlePosState = level.getBlockState(ambientPos);
            if (particlePosState.isCollisionShapeFullBlock(level, ambientPos)) continue;

            level.addParticle(RUParticleTypes.PRISMARITE_SPARKLE.get(), (double)ambientPos.getX() + random.nextDouble(), (double)ambientPos.getY() + random.nextDouble(), (double)ambientPos.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
        }
    }
}

