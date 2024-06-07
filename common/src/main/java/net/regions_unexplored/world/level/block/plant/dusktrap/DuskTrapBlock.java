package net.regions_unexplored.world.level.block.plant.dusktrap;

import io.github.uhq_games.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class DuskTrapBlock extends BaseDuskTrapBlock {
    public static final BooleanProperty POWERED = RuBlockStateProperties.CLOSED;
    private final Sensitivity sensitivity;

    public DuskTrapBlock(Sensitivity sensitivity, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, Boolean.valueOf(false)).setValue(HALF, DoubleBlockHalf.LOWER));
        this.sensitivity = sensitivity;
    }

    protected int getSignalForState(BlockState blockState) {
        return blockState.getValue(POWERED) ? 15 : 0;
    }

    protected BlockState setSignalForState(BlockState blockState, int signalStrength) {
        return blockState.setValue(POWERED, Boolean.valueOf(signalStrength > 0));
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.isSolidRender(level, pos);
    }

    protected int getSignalStrength(Level level, BlockPos blockPos) {
        Class<? extends Entity> oclass1;
        switch (this.sensitivity) {
            case EVERYTHING:
                oclass1 = Entity.class;
                break;
            case MOBS:
                oclass1 = LivingEntity.class;
                break;
            default:
                throw new IncompatibleClassChangeError();
        }

        Class oclass = oclass1;
        return getEntityCount(level, TOUCH_AABB.move(blockPos), oclass) > 0 ? 15 : 0;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(POWERED).add(HALF);
    }

    public static enum Sensitivity {
        EVERYTHING,
        MOBS;
    }
}
