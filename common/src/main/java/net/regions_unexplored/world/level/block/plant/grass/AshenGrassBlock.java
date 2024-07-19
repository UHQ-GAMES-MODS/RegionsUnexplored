package net.regions_unexplored.world.level.block.plant.grass;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

public class AshenGrassBlock extends BushBlock {
    public static final MapCodec<? extends AshenGrassBlock> CODEC = simpleCodec(AshenGrassBlock::new);
    public static final BooleanProperty SMOULDERING = RuBlockStateProperties.SMOULDERING;
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 10.0D, 14.0D);

    public AshenGrassBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(SMOULDERING, false));
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
            return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(SMOULDERING);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(state==RuBlocks.ASHEN_GRASS.get().defaultBlockState().setValue(SMOULDERING, true)){
            super.animateTick(state, level, pos, random);
            if (random.nextInt(20) == 0) {
                level.addParticle(ParticleTypes.FLAME, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + 0.25D, (double)pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
                level.addParticle(ParticleTypes.SMOKE, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + 0.25D, (double)pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public static boolean isSmouldering(BlockState state) {
        return state.getValue(SMOULDERING);
    }


    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (this.defaultBlockState().setValue(SMOULDERING, false));
    }
}
