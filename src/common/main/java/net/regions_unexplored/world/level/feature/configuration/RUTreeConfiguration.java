package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;

import java.util.List;
import java.util.Optional;

public record RUTreeConfiguration(BlockStateProvider trunkProvider, BlockStateProvider foliageProvider, BlockStateProvider branchProvider, List<TreeDecorator> decorators, int minimumSize, int sizeVariation) implements FeatureConfiguration {
    public static final Codec<RUTreeConfiguration> CODEC = RecordCodecBuilder.create(i -> i.group(
        BlockStateProvider.CODEC.fieldOf("trunk_provider").forGetter(config -> config.trunkProvider),
        BlockStateProvider.CODEC.fieldOf("foliage_provider").forGetter(config -> config.foliageProvider),
        BlockStateProvider.CODEC.fieldOf("branch_provider").forGetter(config -> config.branchProvider),
        TreeDecorator.CODEC.listOf().optionalFieldOf("decorators", List.of()).forGetter(config -> config.decorators),
        ExtraCodecs.POSITIVE_INT.fieldOf("minimum_size").forGetter(config -> config.minimumSize),
        ExtraCodecs.NON_NEGATIVE_INT.fieldOf("size_variation").forGetter(config -> config.sizeVariation)
    ).apply(i, RUTreeConfiguration::new));

    public RUTreeConfiguration(BlockStateProvider log, BlockStateProvider leaves, BlockStateProvider branch, int minSize, int sizeVar) {
        this(log, leaves, branch, List.of(), minSize, sizeVar);
    }
}

