package net.regions_unexplored.worldgen.foliageplacer;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.material.Fluids;

public class RUFoliagePlacerUtils {
    public record Context(LevelSimulatedReader level, FoliagePlacer.FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, BlockPos origin, int offset) {}

    public static void placeDiamond(Context context, int radius, int y, boolean doubleTrunk) {
        placeDiamond(context, radius, radius, y, doubleTrunk);
    }

    public static void placeDiamond(Context context, int radius, int maxDistance, int y, boolean doubleTrunk) {
        int offset = doubleTrunk ? 1 : 0;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int dx = -radius; dx <= radius + offset; ++dx) {
            for (int dz = -radius; dz <= radius + offset; ++dz) {
                if (Math.abs(dx) + Math.abs(dz) > maxDistance) continue;

                pos.setWithOffset(context.origin, dx, y, dz);
                placeSingle(context, pos);
            }
        }
    }

    public static void placeSquare(Context context, int radius, int y, boolean doubleTrunk) {
        placeSquare(context, radius, y, doubleTrunk, 1.0f);
    }

    public static void placeSquare(Context context, int radius, int y, boolean doubleTrunk, float chance) {
        int offset = doubleTrunk ? 1 : 0;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int dx = -radius; dx <= radius + offset; ++dx) {
            for (int dz = -radius; dz <= radius + offset; ++dz) {
                if (Math.abs(dx) == radius && Math.abs(dz) == radius && chance < context.random.nextFloat()) continue;
                pos.setWithOffset(context.origin, dx, y, dz);
                placeSingle(context, pos);
            }
        }
    }

    public static void placeSingle(Context context, BlockPos pos, float chance) {
        if (chance >= 1 || chance < context.random.nextFloat()) {
            placeSingle(context, pos);
        }
    }

    private static void placeSingle(Context context, BlockPos pos) {
        pos = pos.above(context.offset);
        boolean isPersistent = context.level.isStateAtPosition(pos, state -> state.getOptionalValue(BlockStateProperties.PERSISTENT).orElse(false));
        if (isPersistent || !TreeFeature.validTreePos(context.level, pos)) {
            return;
        }
        BlockState foliageState = context.config.foliageProvider.getState(context.random, pos);
        if (foliageState.hasProperty(BlockStateProperties.WATERLOGGED)) {
            foliageState = foliageState.setValue(BlockStateProperties.WATERLOGGED, context.level.isFluidAtPosition(pos, fluidState -> fluidState.isSourceOfType(Fluids.WATER)));
        }
        context.foliageSetter.set(pos, foliageState);
    }
}
