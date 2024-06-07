package net.regions_unexplored.world.level.block.sign;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.regions_unexplored.block.entity.custom.RuHangingSignBlockEntity;

public class RuWallHangingSignBlock extends WallHangingSignBlock {
    public RuWallHangingSignBlock(Properties properties, WoodType type) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RuHangingSignBlockEntity(pos, state);
    }
}
