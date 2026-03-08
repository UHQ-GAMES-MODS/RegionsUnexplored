package net.regions_unexplored.worldgen.trunkplacer;

import com.mojang.datafixers.Products;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;

import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.registry.tag.RUBlockTags;

import java.util.function.BiConsumer;

public abstract class RUTrunkPlacer extends TrunkPlacer {
    protected final IntProvider height;
    public RUTrunkPlacer(IntProvider height) {
        super(0, 0, 0);
        this.height = height;
    }

    protected static <P extends RUTrunkPlacer> Products.P1<RecordCodecBuilder.Mu<P>, IntProvider> heightField(RecordCodecBuilder.Instance<P> instance) {
        return instance.group(IntProvider.POSITIVE_CODEC.fieldOf("height").forGetter(placer -> placer.height));
    }

    public int getTreeHeight(RandomSource random) {
        return this.height.sample(random);
    }

    public static void placeDirtBelow(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> trunkSetter, BlockPos pos) {
        BlockPos below = pos.below();
        if (level.isStateAtPosition(below, state -> state.is(RUBlockTags.REPLACEABLE_BY_PEAT_DIRT))) {
            trunkSetter.accept(below, RUBlocks.PEAT_DIRT.get().defaultBlockState());
        } else if (level.isStateAtPosition(below, state -> state.is(RUBlockTags.REPLACEABLE_BY_SILT_DIRT))) {
            trunkSetter.accept(below, RUBlocks.SILT_DIRT.get().defaultBlockState());
        } else {
            trunkSetter.accept(below, Blocks.DIRT.defaultBlockState());
        }
    }

    public static FoliageAttachment attachment(BlockPos pos) {
        return new FoliageAttachment(pos, 0, false);
    }
}
