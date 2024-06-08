package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;

import java.util.Random;

public class WaterEdgeFeature extends Feature<NoneFeatureConfiguration> {
    public WaterEdgeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();


        if(level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP)){
            placeBlob(level, pos);
            return true;
        }

        return false;
    }
    public boolean placeBlob(LevelAccessor level, BlockPos pos) {
        Random random = new Random();

        if (pos.getY() <= level.getMinBuildHeight() + 3) {
            return false;
        } else {
            for(int l = 0; l < 3; ++l) {
                int i = random.nextInt(4)+2;
                int j = random.nextInt(4)+2;
                int k = random.nextInt(4)+2;
                float f = (float)(i + j + k) * 0.333F + 0.5F;

                for(BlockPos blockpos1 : BlockPos.betweenClosed(pos.offset(-i, -j, -k), pos.offset(i, j, k))) {
                    if (blockpos1.distSqr(pos) <= (double)(f * f)) {
                        if(level.getBlockState(blockpos1.below()).isFaceSturdy(level, pos.below(), Direction.DOWN)){
                            if(blockpos1.getY()==62){
                                if(random.nextInt(5)== 0){
                                    placeBlock(level,blockpos1);
                                }
                            }
                        }
                    }
                }

                pos = pos.offset(-1 + random.nextInt(2), -random.nextInt(2), -1 + random.nextInt(2));
            }

            return true;
        }
    }

    public boolean placeBlock(LevelAccessor level, BlockPos pos) {
        if (level.getBlockState(pos.below()).is(Blocks.DIRT)&&level.isWaterAt(pos)) {
            level.setBlock(pos, Blocks.GRASS_BLOCK.defaultBlockState(), 2);
            if (level.getBlockState(pos.above())== RuBlocks.CATTAIL.defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER)||level.getBlockState(pos.above()).is(RuBlocks.DUCKWEED)) {
                level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 2);
            }
        }
        return true;
    }
}