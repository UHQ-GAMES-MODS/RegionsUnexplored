package net.regions_unexplored.world.level.block.other_dirt;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

public class AshenDirtBlock extends Block {

    public static final BooleanProperty SMOULDERING = RuBlockStateProperties.SMOULDERING;

    public AshenDirtBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(SMOULDERING, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(SMOULDERING);
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getBlockState(pos.above()).is(Blocks.FIRE)) {
            level.setBlockAndUpdate(pos, RuBlocks.ASHEN_DIRT.defaultBlockState().setValue(SMOULDERING, true));
        }
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(state== RuBlocks.ASHEN_DIRT.defaultBlockState().setValue(SMOULDERING, true)){
            super.animateTick(state, level, pos, random);
            if (random.nextInt(20) == 0) {
                level.addParticle(ParticleTypes.FLAME, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + 1.1D, (double)pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
                level.addParticle(ParticleTypes.SMOKE, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + 1.1D, (double)pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
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