package net.regions_unexplored.worldgen.treedecorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.util.RUUtils;
import net.regions_unexplored.world.level.block.plant.branch.BranchBlock;

import java.util.Optional;

public class BranchDecorator extends TreeDecorator {
    public static final MapCodec<BranchDecorator> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
        Codec.floatRange(0, 1).fieldOf("probability").forGetter(d -> d.probability),
        BuiltInRegistries.BLOCK.byNameCodec().fieldOf("branch_block").forGetter(d -> d.branchBlock),
        BuiltInRegistries.BLOCK.byNameCodec().fieldOf("log_block").forGetter(d -> d.logBlock),
        Codec.intRange(0, 16).fieldOf("required_empty_blocks").forGetter(d -> d.requiredEmptyBlocks),
        BlockStateProvider.CODEC.optionalFieldOf("leaves_provider").forGetter(d -> d.leavesProvider)
    ).apply(i, BranchDecorator::new));

    public static final TreeDecoratorType<BranchDecorator> TYPE = new TreeDecoratorType<>(CODEC);

    private final float probability;
    private final Block branchBlock;
    private final Block logBlock;
    private final int requiredEmptyBlocks;
    private final Optional<BlockStateProvider> leavesProvider;

    private BranchDecorator(float probability, Block branchBlock, Block logBlock, int requiredEmptyBlocks, Optional<BlockStateProvider> leavesProvider) {
        this.probability = probability;
        this.branchBlock = branchBlock;
        this.logBlock = logBlock;
        this.requiredEmptyBlocks = requiredEmptyBlocks;
        this.leavesProvider = leavesProvider;
    }

    public static BranchDecorator createWithoutLeaves(float probability, NaturalSet naturalSet, WoodSet woodSet, int requiredEmptyBlocks) {
        return new BranchDecorator(probability, naturalSet.getBranch(), woodSet.getLog(), requiredEmptyBlocks, Optional.empty());
    }

    public static BranchDecorator create(float probability, NaturalSet naturalSet, WoodSet woodSet, int requiredEmptyBlocks) {
        return create(probability, naturalSet, woodSet, requiredEmptyBlocks, BlockStateProvider.simple(naturalSet.getLeaves()));
    }

    public static BranchDecorator create(float probability, NaturalSet naturalSet, WoodSet woodSet, int requiredEmptyBlocks, BlockStateProvider leavesProvider) {
        return new BranchDecorator(probability, naturalSet.getBranch(), woodSet.getLog(), requiredEmptyBlocks, Optional.of(leavesProvider));
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return TYPE;
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        int topLogY = Integer.MIN_VALUE;
        for (BlockPos pos : context.logs()) {
            if (pos.getY() > topLogY) {
                topLogY = pos.getY();
            }
        }
        for (BlockPos logsPos : RUUtils.shuffledCopy(context.logs(), random)) {
            if (!(logsPos.getY() + 2 < topLogY)) continue;
            Direction branchDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            BlockPos placementPos = logsPos.relative(branchDirection);
            if (!(random.nextFloat() <= this.probability) || !hasRequiredEmptyBlocks(context, placementPos)) continue;

            BlockState toPlace = (RuCommonConfig.USE_LOGS_FOR_BRANCHES.get() ? this.logBlock : this.branchBlock).defaultBlockState();
            if (toPlace.hasProperty(BlockStateProperties.AXIS)) {
                toPlace = toPlace.setValue(BlockStateProperties.AXIS, branchDirection.getAxis());
            } else if (toPlace.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                toPlace = toPlace.setValue(BlockStateProperties.HORIZONTAL_FACING, branchDirection);
            }
            context.setBlock(placementPos, toPlace);
            if (this.leavesProvider.isPresent()) {
                for (Direction direction : Direction.values()) {
                    if (direction == Direction.DOWN) continue;
                    placeLeaves(context, placementPos.relative(direction));
                }
            }
        }
    }

    private void placeLeaves(Context context, BlockPos pos) {
        if (context.isAir(pos)) {
            context.setBlock(pos, this.leavesProvider.get().getState(context.random(), pos));
        }
    }

    private boolean hasRequiredEmptyBlocks(TreeDecorator.Context context, BlockPos branchPos) {
        for (int i = 0; i <= this.requiredEmptyBlocks; ++i) {
            BlockPos offsetPos = branchPos.below(i);
            if (context.level().isStateAtPosition(offsetPos, state -> state.isAir() || state.is(BlockTags.LEAVES))) {
                continue;
            }
            return false;
        }
        return true;
    }
}
