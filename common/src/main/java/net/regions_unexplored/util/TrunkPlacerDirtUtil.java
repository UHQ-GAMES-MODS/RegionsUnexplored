package net.regions_unexplored.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.block.RuBlocks;

public class TrunkPlacerDirtUtil {
    public static boolean isForestGrass(LevelSimulatedReader levelSimulatedReader, BlockPos blockPos) {
        return levelSimulatedReader.isStateAtPosition(blockPos, (blockState) -> blockState.is(RuBlocks.PEAT_GRASS_BLOCK.get())||blockState.is(RuBlocks.PEAT_DIRT.get()));
    }
    public static boolean isPlainsGrass(LevelSimulatedReader levelSimulatedReader, BlockPos blockPos) {
        return levelSimulatedReader.isStateAtPosition(blockPos, (blockState) -> blockState.is(RuBlocks.SILT_GRASS_BLOCK.get())||blockState.is(RuBlocks.SILT_DIRT.get()));
    }
    public static boolean isAlphaGrass(LevelSimulatedReader levelSimulatedReader, BlockPos blockPos) {
        return levelSimulatedReader.isStateAtPosition(blockPos, (blockState) -> blockState.is(RuBlocks.ALPHA_GRASS_BLOCK.get())||blockState.is(Blocks.DIRT));
    }
}
