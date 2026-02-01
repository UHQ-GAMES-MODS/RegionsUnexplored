package net.regions_unexplored.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.regions_unexplored.registry.RUBlocks;

public class TrunkPlacerDirtUtil {
    public static boolean isForestGrass(LevelSimulatedReader levelSimulatedReader, BlockPos blockPos) {
        return levelSimulatedReader.isStateAtPosition(blockPos, (blockState) -> blockState.is(RUBlocks.PEAT_GRASS_BLOCK.get())||blockState.is(RUBlocks.PEAT_DIRT.get()));
    }
    public static boolean isPlainsGrass(LevelSimulatedReader levelSimulatedReader, BlockPos blockPos) {
        return levelSimulatedReader.isStateAtPosition(blockPos, (blockState) -> blockState.is(RUBlocks.SILT_GRASS_BLOCK.get())||blockState.is(RUBlocks.SILT_DIRT.get()));
    }
    public static boolean isAlphaGrass(LevelSimulatedReader levelSimulatedReader, BlockPos blockPos) {
        return levelSimulatedReader.isStateAtPosition(blockPos, (blockState) -> blockState.is(RUBlocks.ALPHA_GRASS_BLOCK.get())||blockState.is(Blocks.DIRT));
    }
}
