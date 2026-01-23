package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;

import java.util.List;

public class RuTreeConfiguration implements FeatureConfiguration {
    public static final Codec<RuTreeConfiguration> CODEC = RecordCodecBuilder.create(i -> i.group(
        BlockStateProvider.CODEC.fieldOf("trunk_provider").forGetter(config -> config.trunkProvider),
        BlockStateProvider.CODEC.fieldOf("foliage_provider").forGetter(config -> config.foliageProvider),
        BlockStateProvider.CODEC.fieldOf("branch_provider").forGetter(config -> config.branchProvider),
        TreeDecorator.CODEC.listOf().optionalFieldOf("decorators", List.of()).forGetter(config -> config.decorators),
        Codec.INT.fieldOf("minimum_size").forGetter(config -> config.minimumSize),
        Codec.INT.fieldOf("size_variation").forGetter(config -> config.sizeVariation)
    ).apply(i, RuTreeConfiguration::new));

    public final BlockStateProvider trunkProvider;
    public final BlockStateProvider foliageProvider;
    public final BlockStateProvider branchProvider;
    public final List<TreeDecorator> decorators;
    public final int minimumSize;
    public final int sizeVariation;

    public RuTreeConfiguration(BlockStateProvider log, BlockStateProvider leaves, BlockStateProvider branch, int minSize, int sizeVar) {
        this(log, leaves, branch, List.of(), minSize, sizeVar);
    }

    public RuTreeConfiguration(BlockStateProvider log, BlockStateProvider leaves, BlockStateProvider branch, List<TreeDecorator> decorators, int minSize, int sizeVar) {
        this.trunkProvider = log;
        this.foliageProvider = leaves;
        this.branchProvider = branch;
        this.decorators = decorators;
        this.minimumSize = minSize;
        this.sizeVariation = sizeVar;
    }
}

