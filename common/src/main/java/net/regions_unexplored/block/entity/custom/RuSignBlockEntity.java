package net.regions_unexplored.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.entity.RuBlockEntities;

public class RuSignBlockEntity extends SignBlockEntity {
    public RuSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType(){
        return RuBlockEntities.SIGN_BLOCK_ENTITIES.get();
    }
}
