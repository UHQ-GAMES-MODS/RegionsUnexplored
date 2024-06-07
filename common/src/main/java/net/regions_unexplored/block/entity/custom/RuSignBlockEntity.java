package net.regions_unexplored.block.entity.custom;

import io.github.uhq_games.regions_unexplored.block.entity.RegionsUnexploredBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RuSignBlockEntity extends SignBlockEntity {
    public RuSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType(){
        return RegionsUnexploredBlockEntities.SIGN_BLOCK_ENTITIES;
    }
}
