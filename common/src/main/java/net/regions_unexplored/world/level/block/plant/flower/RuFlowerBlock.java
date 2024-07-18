package net.regions_unexplored.world.level.block.plant.flower;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

public class RuFlowerBlock extends FlowerBlock {
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    protected static final VoxelShape SHAPE_TALL = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 14.0D, 11.0D);
    protected static final VoxelShape SHAPE_BUSH = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    protected static final VoxelShape SHAPE_DAISY = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D);

    public RuFlowerBlock(Holder<MobEffect> mobEffect, int i, Properties properties) {
        super(mobEffect, i, properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        if(state== RuBlocks.POPPY_BUSH.defaultBlockState()
                ||state== RuBlocks.SALMON_POPPY_BUSH.defaultBlockState()
                ||state== RuBlocks.BLUE_LUPINE.defaultBlockState()
                ||state== RuBlocks.PINK_LUPINE.defaultBlockState()
                ||state== RuBlocks.PURPLE_LUPINE.defaultBlockState()
                ||state== RuBlocks.YELLOW_LUPINE.defaultBlockState()
                ||state== RuBlocks.RED_LUPINE.defaultBlockState()
                ||state== RuBlocks.HYSSOP.defaultBlockState()
                ||state.is(RuTags.SNOWBELLE)){
            return SHAPE_BUSH.move(vec3.x, vec3.y, vec3.z);
        }
        if(state== RuBlocks.FIREWEED.defaultBlockState()
                ||state== RuBlocks.WILTING_TRILLIUM.defaultBlockState()
                ||state== RuBlocks.WHITE_TRILLIUM.defaultBlockState()
                ||state== RuBlocks.WARATAH.defaultBlockState()){
            return SHAPE_TALL.move(vec3.x, vec3.y, vec3.z);
        }
        if(state== RuBlocks.DAISY.defaultBlockState()
                ||state== RuBlocks.FELICIA_DAISY.defaultBlockState()){
            return SHAPE_DAISY.move(vec3.x, vec3.y, vec3.z);
        }
        else{
            return SHAPE.move(vec3.x, vec3.y, vec3.z);
        }
    }
}
