package net.regions_unexplored.world.level.block.plant.nether;

import com.mojang.serialization.MapCodec;
import io.github.uhq_games.regions_unexplored.block.RuBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlisteringIvyPlantBlock extends GrowingPlantBodyBlock {
    public static final MapCodec<? extends GlisteringIvyPlantBlock> CODEC = simpleCodec(GlisteringIvyPlantBlock::new);
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public GlisteringIvyPlantBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) RuBlocks.GLISTERING_IVY;
    }

    @Override
    protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }
}