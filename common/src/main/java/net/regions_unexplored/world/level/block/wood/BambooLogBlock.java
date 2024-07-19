package net.regions_unexplored.world.level.block.wood;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

public class BambooLogBlock extends Block implements BonemealableBlock, SimpleWaterloggedBlock {
    public static final BooleanProperty LEAVES = RuBlockStateProperties.LEAVES;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BambooLogBlock() {
        super(Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASS).sound(SoundType.BAMBOO).strength(2f, 3f).noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false));
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y).setValue(LEAVES, false).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter getter, BlockPos pos) {
        return 0;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {

        return switch (state.getValue(AXIS)) {
            case X -> box(0, 4, 4, 16, 12, 12);
            case Y -> box(4, 0, 4, 12, 16, 12);
            case Z -> box(4, 4, 0, 12, 12, 16);
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS, LEAVES, WATERLOGGED);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return state;
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return !state.getValue(LEAVES);
    }

    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.setBlock(pos, state.setValue(LEAVES, true), 2);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis()).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
            if (state.getValue(AXIS) == Direction.Axis.X) {
                return state.setValue(AXIS, Direction.Axis.Z);
            } else if (state.getValue(AXIS) == Direction.Axis.Z) {
                return state.setValue(AXIS, Direction.Axis.X);
            }
        }
        return state;
    }

    public static boolean isLeaves(UseOnContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        return state.getValue(LEAVES);
    }
    public static boolean setLeaves(UseOnContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        Direction.Axis axis = state.getValue(AXIS);
        boolean water = state.getValue(WATERLOGGED);

        popResourceFromFace(context.getLevel(), context.getClickedPos(), context.getClickedFace(), new ItemStack(RuBlocks.BAMBOO_SAPLING.get().asItem(), 1));
        context.getLevel().setBlock(context.getClickedPos(), RuBlocks.BAMBOO_LOG.get().defaultBlockState().setValue(AXIS, axis).setValue(LEAVES,false).setValue(WATERLOGGED, water), 2);
        return state.getValue(LEAVES);
    }
}


