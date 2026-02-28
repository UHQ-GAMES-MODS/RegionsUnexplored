package net.regions_unexplored.datagen.provider.registry;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;
import java.util.function.Supplier;

public class RUDatagenFeatureUtils {
    public static Holder<PlacedFeature> direct(Holder.Reference<ConfiguredFeature<?, ?>> feature) {
        return Holder.direct(new PlacedFeature(feature, List.of()));
    }

    public static PlacementModifier airAndBlocksBelow(Block... blocks) {
        return BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(Vec3i.ZERO.below(), blocks)));
    }

    public static PlacementModifier count(int count) {
        return CountPlacement.of(count);
    }

    public static BlockState state(Supplier<Block> block) {
        return block.get().defaultBlockState();
    }

    @SafeVarargs
    public static BlockStateProvider weightedStates(Pair<BlockState, Integer>... entries) {
        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();
        for (var pair : entries) {
            builder.add(pair.getFirst(), pair.getSecond());
        }
        return new WeightedStateProvider(builder);
    }

    @SafeVarargs
    public static WeightedListInt weightedInts(Pair<Integer, Integer>... entries) {
        SimpleWeightedRandomList.Builder<IntProvider> builder = SimpleWeightedRandomList.builder();
        for (var pair : entries) {
            builder.add(ConstantInt.of(pair.getFirst()), pair.getSecond());
        }
        return new WeightedListInt(builder.build());
    }

    public static Pair<BlockState, Integer> pair(Block block) {
        return pair(block.defaultBlockState(), 1);
    }

    public static Pair<BlockState, Integer> pair(Block block, int weight) {
        return pair(block.defaultBlockState(), weight);
    }

    public static <T> Pair<T, Integer> pair(T state) {
        return pair(state, 1);
    }

    public static <T> Pair<T, Integer> pair(T object, int weight) {
        return Pair.of(object, weight);
    }
}
