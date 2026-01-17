package net.regions_unexplored.world.level.block.wood;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;

import javax.annotation.Nullable;

public class SmallOakLogBlock extends Block implements SimpleWaterloggedBlock{
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public SmallOakLogBlock() {
        super(Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false));
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y).setValue(WATERLOGGED, Boolean.valueOf(false)));
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
        builder.add(AXIS, WATERLOGGED);
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

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult hitResult) {
        if (playerHasShieldUseIntent(player, interactionHand)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        else if (stack.getItem() instanceof AxeItem) {
            BlockState newBlockState = evaluateStrippedState(level, pos, player, state);
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, stack);
            }

            level.setBlock(pos, newBlockState, 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newBlockState));
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(interactionHand));
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }
        else{
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
    }

    private BlockState evaluateStrippedState(Level level, BlockPos pos, @Nullable Player player, BlockState state) {
        boolean isWaterlogged = state.getValue(WATERLOGGED);
        Direction.Axis direction = state.getValue(AXIS);
        BlockState strippedState = RuBlocks.STRIPPED_SMALL_OAK_LOG.get().defaultBlockState().setValue(AXIS, direction).setValue(WATERLOGGED, Boolean.valueOf(isWaterlogged));
        level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
        return strippedState;
    }

    private static boolean playerHasShieldUseIntent(Player player, InteractionHand interactionHand) {
        return interactionHand.equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
    }
}


