package net.regions_unexplored.world.level.block.plant.other;

import com.mojang.serialization.MapCodec;
import io.github.uhq_games.regions_unexplored.block.RuBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpanishMossPlantBlock extends GrowingPlantBodyBlock {
    public static final MapCodec<? extends SpanishMossPlantBlock> CODEC = simpleCodec(SpanishMossPlantBlock::new);
    public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public SpanishMossPlantBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) RuBlocks.SPANISH_MOSS;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockPos = pos.relative(this.growthDirection.getOpposite());
        BlockState blockState = level.getBlockState(blockPos);
        if (!this.canAttachTo(blockState)) {
            return false;
        } else {
            return blockState.is(this.getHeadBlock()) || blockState.is(this.getBodyBlock()) || blockState.is(BlockTags.LOGS)|| blockState.is(BlockTags.LEAVES);
        }
    }

    @Override
    protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }
}