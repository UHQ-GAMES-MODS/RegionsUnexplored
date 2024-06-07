package net.regions_unexplored.world.level.feature.bioshroom;

import com.mojang.serialization.Codec;
import io.github.uhq_games.regions_unexplored.block.RuBlocks;
import io.github.uhq_games.regions_unexplored.data.tags.RuTags;
import io.github.uhq_games.regions_unexplored.world.level.feature.configuration.GiantBioshroomConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Random;

public class GiantYellowBioshroomFeature extends Feature<GiantBioshroomConfiguration> {

    public GiantYellowBioshroomFeature(Codec<GiantBioshroomConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<GiantBioshroomConfiguration> context) {
        GiantBioshroomConfiguration bioshroomConfiguration = context.config();
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();

        int limbDirection = context.random().nextInt(12);
        int height_main = context.random().nextInt(bioshroomConfiguration.sizeVariation) + bioshroomConfiguration.minimumSize;

        if(!level.getBlockState(pos).canBeReplaced()){
            return false;
        }

        int placeCheck = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height_main) {
            if(placeCheck == 0){
                placeBase(level, placePos, randomSource, bioshroomConfiguration);
                placeGlowingCaps(level, placePos, randomSource, bioshroomConfiguration, height_main);
            }
            if(placeCheck == height_main){
                placeCap(level, placePos, randomSource, bioshroomConfiguration);
            }
            if(placeCheck != height_main){
                placeStemBlock(level, placePos, randomSource, bioshroomConfiguration);
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public void placeBase(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        Random random = new Random();
        int n = random.nextInt(5);
        int s = random.nextInt(5);
        int e = random.nextInt(5);
        int w = random.nextInt(5);
        if(n==0){
            placeRoot(level,pos.north(),randomSource,bioshroomConfiguration);
        }
        if(s==0){
            placeRoot(level,pos.south(),randomSource,bioshroomConfiguration);
        }
        if(e==0){
            placeRoot(level,pos.east(),randomSource,bioshroomConfiguration);
        }
        if(w==0){
            placeRoot(level,pos.west(),randomSource,bioshroomConfiguration);
        }
    }

    public void placeStemBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {

        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        if(level.getBlockState(pos).is(RuBlocks.PEAT_GRASS_BLOCK)){
            level.setBlock(pos, RuBlocks.PEAT_DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.SILT_GRASS_BLOCK)){
            level.setBlock(pos, RuBlocks.SILT_DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.ALPHA_GRASS_BLOCK)||level.getBlockState(pos).is(Blocks.GRASS_BLOCK)||level.getBlockState(pos).is(Blocks.MYCELIUM)){
            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.MYCOTOXIC_NYLIUM)||level.getBlockState(pos).is(RuBlocks.GLISTERING_NYLIUM)|| level.getBlockState(pos).is(Blocks.CRIMSON_NYLIUM)|| level.getBlockState(pos).is(Blocks.WARPED_NYLIUM)){
            level.setBlock(pos, Blocks.NETHERRACK.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.COBALT_NYLIUM)){
            level.setBlock(pos, Blocks.BLACKSTONE.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.PRISMOSS)|| level.getBlockState(pos).is(RuBlocks.VIRIDESCENT_NYLIUM)|| level.getBlockState(pos).is(RuBlocks.STONE_GRASS_BLOCK)){
            level.setBlock(pos, Blocks.STONE.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.DEEPSLATE_PRISMOSS)||level.getBlockState(pos).is(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM)||level.getBlockState(pos).is(RuBlocks.DEEPSLATE_GRASS_BLOCK)){
            level.setBlock(pos, Blocks.DEEPSLATE.defaultBlockState(), 2);
        }
        else if(isReplaceable(level, pos)||level.getBlockState(pos).is(bioshroomConfiguration.capProvider.getState(randomSource,pos).getBlock())||level.getBlockState(pos).is(bioshroomConfiguration.glowBlockProvider.getState(randomSource,pos).getBlock())) {
            level.setBlock(pos, bioshroomConfiguration.stemProvider.getState(randomSource, pos), 2);
        }
        else{
            return;
        }

        if(level.getBlockState(pos.below()).is(RuBlocks.PEAT_GRASS_BLOCK)){
            level.setBlock(pos.below(), RuBlocks.PEAT_DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.SILT_GRASS_BLOCK)){
            level.setBlock(pos.below(), RuBlocks.SILT_DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.ALPHA_GRASS_BLOCK)||level.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK)||level.getBlockState(pos.below()).is(Blocks.MYCELIUM)){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.MYCOTOXIC_NYLIUM)||level.getBlockState(pos.below()).is(RuBlocks.GLISTERING_NYLIUM)|| level.getBlockState(pos.below()).is(Blocks.CRIMSON_NYLIUM)|| level.getBlockState(pos.below()).is(Blocks.WARPED_NYLIUM)){
            level.setBlock(pos.below(), Blocks.NETHERRACK.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.COBALT_NYLIUM)){
            level.setBlock(pos.below(), Blocks.BLACKSTONE.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.PRISMOSS)|| level.getBlockState(pos.below()).is(RuBlocks.VIRIDESCENT_NYLIUM)|| level.getBlockState(pos.below()).is(RuBlocks.STONE_GRASS_BLOCK)){
            level.setBlock(pos.below(), Blocks.STONE.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.DEEPSLATE_PRISMOSS)||level.getBlockState(pos.below()).is(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM)||level.getBlockState(pos.below()).is(RuBlocks.DEEPSLATE_GRASS_BLOCK)){
            level.setBlock(pos.below(), Blocks.DEEPSLATE.defaultBlockState(), 2);
        }
    }

    public void placeRoot(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        int rd = 2;
        int i = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            if(i>0){
                if(!level.getBlockState(placePos.above()).is(bioshroomConfiguration.stemProvider.getState(randomSource, placePos.above()).getBlock())&&level.getBlockState(placePos).canBeReplaced()) {
                    return;
                }
            }
            placeStemBlock(level, placePos, randomSource, bioshroomConfiguration);
            placePos.move(Direction.DOWN);
            i++;
        }
    }

    public void placeCap(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        Random random = new Random();

        placeCapBlock(level,pos,randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.north(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.west(),randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.north().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north().west(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south().west(),randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.north(2),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north(2).east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north(2).west(),randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.south(2),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south(2).east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south(2).west(),randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.east(2),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.east(2).north(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.east(2).south(),randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.west(2),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.west(2).north(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.west(2).south(),randomSource,bioshroomConfiguration);

        if(randomSource.nextInt(2)==0){
            placeCapBlock(level,pos.north(2).east(2),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.north(2).west(2),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.south(2).east(2),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.south(2).west(2),randomSource,bioshroomConfiguration);

            placeCapBlock(level,pos.north(3),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.north(3).east(),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.north(3).west(),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.north(3).east(2),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.north(3).west(2),randomSource,bioshroomConfiguration);

            placeCapBlock(level,pos.south(3),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.south(3).east(),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.south(3).west(),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.south(3).east(2),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.south(3).west(2),randomSource,bioshroomConfiguration);

            placeCapBlock(level,pos.east(3),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.east(3).north(),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.east(3).south(),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.east(3).north(2),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.east(3).south(2),randomSource,bioshroomConfiguration);

            placeCapBlock(level,pos.west(3),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.west(3).north(),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.west(3).south(),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.west(3).north(2),randomSource,bioshroomConfiguration);
            placeCapBlock(level,pos.west(3).south(2),randomSource,bioshroomConfiguration);
        }
    }

    public void placeGlowingCaps(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration, int i) {
        int chance = randomSource.nextInt(3);
        int cap1 = randomSource.nextInt(i-4)+3;
        BlockPos pos1 = new BlockPos(pos.getX(), pos.getY()+cap1, pos.getZ());
        int cap2 = randomSource.nextInt(i-4)+3;
        BlockPos pos2 = new BlockPos(pos.getX(), pos.getY()+cap2, pos.getZ());
        int direction = randomSource.nextInt(2);

        if(direction==0){
            if(chance==1) {
                placeGlowingBlock(level, pos1.north(), randomSource, bioshroomConfiguration);
                placeGlowingBlock(level, pos1.east(), randomSource, bioshroomConfiguration);
                placeGlowingBlock(level, pos1.north().east(), randomSource, bioshroomConfiguration);
            }
            else if(chance==2) {
                placeGlowingBlock(level, pos2.south(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level, pos2.west(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level, pos2.south().west(),randomSource,bioshroomConfiguration);
            }
            else{
                placeGlowingBlock(level, pos1.north(), randomSource, bioshroomConfiguration);
                placeGlowingBlock(level, pos1.east(), randomSource, bioshroomConfiguration);
                placeGlowingBlock(level, pos1.north().east(), randomSource, bioshroomConfiguration);
                placeGlowingBlock(level, pos2.south(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level, pos2.west(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level, pos2.south().west(),randomSource,bioshroomConfiguration);
            }
        }
        else if(direction==1){
            if(chance==1) {
                placeGlowingBlock(level,pos1.north(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level,pos1.west(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level,pos1.north().west(),randomSource,bioshroomConfiguration);
            }
            else if(chance==2) {
                placeGlowingBlock(level,pos2.south(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level,pos2.east(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level,pos2.south().east(),randomSource,bioshroomConfiguration);
            }
            else{
                placeGlowingBlock(level,pos1.north(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level,pos1.west(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level,pos1.north().west(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level,pos2.south(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level,pos2.east(),randomSource,bioshroomConfiguration);
                placeGlowingBlock(level,pos2.south().east(),randomSource,bioshroomConfiguration);
            }
        }
    }

    public void placeCapBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        else if(isReplaceable(level, pos)) {
            level.setBlock(pos, bioshroomConfiguration.capProvider.getState(randomSource, pos), 2);
        }
    }
    public void placeGlowingBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        else if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(pos, bioshroomConfiguration.glowBlockProvider.getState(randomSource, pos), 2);
        }
    }

    
    public static boolean isReplaceableDirtBlock(BlockState state) {
        return state.is(RuTags.TREE_GRASS_REPLACEABLES);
    }

    public static boolean isReplaceableDirt(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, GiantYellowBioshroomFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, GiantYellowBioshroomFeature::isReplaceableBlock);
    }
}