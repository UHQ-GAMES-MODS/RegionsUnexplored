package net.regions_unexplored.world.level.block.plant.dusktrap;

import io.github.uhq_games.regions_unexplored.entity.RuDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseDuskTrapBlock extends DoublePlantBlock {
    protected static final VoxelShape CLOSED_AABB = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    protected static final VoxelShape AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    protected static final AABB TOUCH_AABB = new AABB(0.3D, 0.0D, 0.3D, 0.7D, 16.0D, 0.7D);

    protected BaseDuskTrapBlock(Properties properties) {
        super(properties);
    }

    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return this.getSignalForState(state) > 0 ? CLOSED_AABB : AABB;
    }

    protected int getClosedTime() {
        return 5;
    }

    public boolean isPossibleToRespawnInThis(@NotNull BlockState blockState) {
        return true;
    }

    public void tick(@NotNull BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        int i = this.getSignalForState(blockState);
        if (i > 0) {
            this.checkClosed((Entity)null, serverLevel, blockPos, blockState, i);
        }

    }

    public void entityInside(@NotNull BlockState state, @NotNull Level level, BlockPos pos, Entity entity) {
        Vec3 entityPos = entity.position();
        Vec3 inPos = new Vec3(pos.getX()+0.002D, pos.getY(), pos.getZ()+0.002D);
        Vec3 outPos = new Vec3(pos.getX()+0.998D, pos.getY(), pos.getZ()+0.998D);
        boolean isInside = entityPos.x>inPos.x&&entityPos.z>inPos.z&&entityPos.x<outPos.x&&entityPos.z<outPos.z;
        boolean isItem = entity instanceof ItemEntity;
        if(!isItem){
            if(isInside)entity.makeStuckInBlock(state, new Vec3(0.4D, 0.1D, 0.4D));
        }
        if (!level.isClientSide && entity instanceof LivingEntity) {
            if(entity.isAlive()){
                if(isInside)entity.hurt(level.damageSources().source(RuDamageTypes.DUSK_TRAP), 3.0F);
            }
            entity.makeStuckInBlock(state, new Vec3(0.4D, 0.1D, 0.4D));
            int i = this.getSignalForState(state);
            if (i == 0) {
                this.checkClosed(entity, level, pos, state, i);
            }

        }
    }

    private void checkClosed(@Nullable Entity entity, Level level, BlockPos pos, BlockState state, int power) {
        int i = this.getSignalStrength(level, pos);
        boolean flag = power > 0;
        boolean flag1 = i > 0;
        if (power != i) {
            BlockState blockstate = this.setSignalForState(state, i);

            if(blockstate.getValue(HALF)==DoubleBlockHalf.LOWER){
                BlockPos blockpos = pos.above();
                level.setBlock(blockpos, blockstate.setValue(HALF, DoubleBlockHalf.UPPER), 2);
            }
            else if(blockstate.getValue(HALF)==DoubleBlockHalf.UPPER){
                BlockPos blockpos = pos.below();
                level.setBlock(blockpos, blockstate.setValue(HALF, DoubleBlockHalf.LOWER), 2);
            }
            level.setBlock(pos, blockstate, 2);
            this.updateNeighbours(level, pos);
            level.setBlocksDirty(pos, state, blockstate);
        }

        if (!flag1 && flag) {
            level.playSound((Player)null, pos, SoundType.TWISTING_VINES.getBreakSound(), SoundSource.BLOCKS);
            level.gameEvent(entity, GameEvent.BLOCK_DEACTIVATE, pos);
        } else if (flag1 && !flag) {
            level.playSound((Player)null, pos, SoundType.TWISTING_VINES.getPlaceSound(), SoundSource.BLOCKS);
            level.gameEvent(entity, GameEvent.BLOCK_ACTIVATE, pos);
        }

        if (flag1) {
            level.scheduleTick(new BlockPos(pos), this, this.getClosedTime());
        }

    }

    public void onRemove(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState blockState1, boolean bool) {
        if (!bool && !blockState.is(blockState1.getBlock())) {
            if (this.getSignalForState(blockState) > 0) {
                this.updateNeighbours(level, blockPos);
            }

            super.onRemove(blockState, level, blockPos, blockState1, bool);
        }
    }

    protected void updateNeighbours(Level level, BlockPos blockPos) {
        level.updateNeighborsAt(blockPos, this);
        level.updateNeighborsAt(blockPos.below(), this);
    }

    public int getSignal(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull Direction direction) {
        return this.getSignalForState(blockState);
    }

    public int getDirectSignal(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull Direction direction) {
        return direction == Direction.UP ? this.getSignalForState(blockState) : 0;
    }

    public boolean isSignalSource(@NotNull BlockState p_49351_) {
        return true;
    }

    protected static int getEntityCount(Level level, AABB aabb, Class<? extends Entity> entity) {
        return level.getEntitiesOfClass(entity, aabb, EntitySelector.NO_SPECTATORS.and((e) -> !e.isIgnoringBlockTriggers())).size();
    }

    protected abstract int getSignalStrength(Level level, BlockPos blockPos);

    protected abstract int getSignalForState(BlockState blockState);

    protected abstract BlockState setSignalForState(BlockState blockState, int signalStrength);
}
