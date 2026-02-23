package net.regions_unexplored.datagen.provider.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class RUFeatureUtils {
    public static Holder<PlacedFeature> direct(Holder.Reference<ConfiguredFeature<?, ?>> feature) {
        return Holder.direct(new PlacedFeature(feature, List.of()));
    }

    public static PlacementModifier airAndBlocksBelow(Block... blocks) {
        return BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(Vec3i.ZERO.below(), blocks)));
    }

    public static PlacementModifier count(int count) {
        return CountPlacement.of(count);
    }
}
