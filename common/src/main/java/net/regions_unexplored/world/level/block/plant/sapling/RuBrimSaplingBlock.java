package net.regions_unexplored.world.level.block.plant.sapling;

import io.github.uhq_games.regions_unexplored.data.tags.RuTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
public class RuBrimSaplingBlock extends SaplingBlock implements BonemealableBlock {

    public RuBrimSaplingBlock(TreeGrower treeGrower, Properties properties) {
        super(treeGrower, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos p_51030_) {
        BlockPos blockpos = p_51030_.below();
        return mayPlaceOn(level.getBlockState(blockpos), level, blockpos);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(RuTags.BRIM_PLANT_CAN_SURVIVE_ON);
    }
}

