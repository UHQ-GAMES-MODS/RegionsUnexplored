package net.regions_unexplored.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.entity.RegionsUnexploredBlockEntities;

public class RuHangingSignBlockEntity extends HangingSignBlockEntity {
    public RuHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType(){
        return RegionsUnexploredBlockEntities.HANGING_SIGN_BLOCK_ENTITIES.get();
    }
}
