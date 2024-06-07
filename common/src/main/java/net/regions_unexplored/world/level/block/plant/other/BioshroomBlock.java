package net.regions_unexplored.world.level.block.plant.other;

import io.github.uhq_games.regions_unexplored.data.tags.RuTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BioshroomBlock extends SaplingBlock {
    protected static final float AABB_OFFSET = 3.0F;
    protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
    private final MobEffect suspiciousStewEffect;
    private final int effectDuration;

    public BioshroomBlock(TreeGrower tree, MobEffect mobEffect, int duration, Properties properties) {
        super(tree, properties);
        this.suspiciousStewEffect = mobEffect;
        if (mobEffect.isInstantenous()) {
            this.effectDuration = duration;
        } else {
            this.effectDuration = duration * 20;
        }
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }

    public MobEffect getSuspiciousStewEffect() {
        return this.suspiciousStewEffect;
    }

    public int getEffectDuration() {
        return this.effectDuration;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        if(level.getBlockState(pos.below()).is(RuTags.BIOSHROOM_GROW_BLOCK)) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.isSolidRender(level, pos);
    }
}
