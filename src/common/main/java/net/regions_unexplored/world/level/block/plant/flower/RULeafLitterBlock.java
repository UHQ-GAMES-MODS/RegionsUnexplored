package net.regions_unexplored.world.level.block.plant.flower;

import com.mojang.serialization.MapCodec;

import java.util.function.BiFunction;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RULeafLitterBlock extends BushBlock {
    public static final MapCodec<RULeafLitterBlock> CODEC = RULeafLitterBlock.simpleCodec(RULeafLitterBlock::new);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty AMOUNT = BlockStateProperties.FLOWER_AMOUNT;
    private static final BiFunction<Direction, Integer, VoxelShape> SHAPE_BY_PROPERTIES = Util.memoize((direction, amount) -> {
        VoxelShape[] shapes = new VoxelShape[]{
            Block.box(8.0F, 0.0F, 8.0F, 16.0F, 3.0F, 16.0F),
            Block.box(8.0F, 0.0F, 0.0F, 16.0F, 3.0F, 8.0F),
            Block.box(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 8.0F),
            Block.box(0.0F, 0.0F, 8.0F, 8.0F, 3.0F, 16.0F)
        };
        VoxelShape mergedShapes = Shapes.empty();

        for(int i = 0; i < amount; ++i) {
            int index = Math.floorMod(i - direction.get2DDataValue(), 4);
            mergedShapes = Shapes.or(mergedShapes, shapes[index]);
        }

        return mergedShapes.singleEncompassing();
    });

    public RULeafLitterBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(this.getSegmentAmountProperty(), 1));
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_PROPERTIES.apply(state.getValue(FACING), state.getValue(AMOUNT));
    }

    protected MapCodec<RULeafLitterBlock> codec() {
        return CODEC;
    }

    public IntegerProperty getSegmentAmountProperty() {
        return AMOUNT;
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext context, IntegerProperty segment) {
        return !context.isSecondaryUseActive() && context.getItemInHand().is(state.getBlock().asItem()) && state.getValue(segment) < 4;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context, Block block, IntegerProperty segment, EnumProperty<Direction> facing) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        if (state.is(block)) {
            return state.setValue(segment, Math.min(4, state.getValue(segment) + 1));
        }
        return block.defaultBlockState().setValue(facing, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        if (this.canBeReplaced(state, context, this.getSegmentAmountProperty())) {
            return true;
        }
        return super.canBeReplaced(state, context);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        return level.getBlockState(belowPos).isFaceSturdy(level, belowPos, Direction.UP);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.getStateForPlacement(context, this, this.getSegmentAmountProperty(), FACING);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, this.getSegmentAmountProperty());
    }
}

