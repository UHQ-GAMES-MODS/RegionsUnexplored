package net.regions_unexplored.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.entity.RuBlockEntities;

public class RuHangingSignBlockEntity extends SignBlockEntity {
    private static final int MAX_TEXT_LINE_WIDTH = 60;
    private static final int TEXT_LINE_HEIGHT = 9;

    public RuHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(RuBlockEntities.HANGING_SIGN_BLOCK_ENTITIES.get(), pos, state);
    }

    @Override
    public BlockEntityType<?> getType(){
        return RuBlockEntities.HANGING_SIGN_BLOCK_ENTITIES.get();
    }

    @Override
    public int getTextLineHeight() {
        return TEXT_LINE_HEIGHT;
    }

    @Override
    public int getMaxTextLineWidth() {
        return MAX_TEXT_LINE_WIDTH;
    }

    @Override
    public SoundEvent getSignInteractionFailedSoundEvent() {
        return SoundEvents.WAXED_HANGING_SIGN_INTERACT_FAIL;
    }
}
