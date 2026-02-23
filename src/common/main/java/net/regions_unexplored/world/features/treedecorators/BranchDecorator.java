package net.regions_unexplored.world.features.treedecorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.util.RUUtils;
import net.regions_unexplored.world.level.block.plant.branch.BranchBlock;

import java.util.Optional;

public class BranchDecorator extends TreeDecorator {
    public static final MapCodec<BranchDecorator> CODEC = RecordCodecBuilder.<BranchDecorator>mapCodec(i -> i.group(
        Codec.floatRange(0, 1).fieldOf("probability").forGetter(d -> d.probability),
        BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(d -> d.block),
        Codec.intRange(0, 16).fieldOf("required_empty_blocks").forGetter(d -> d.requiredEmptyBlocks),
        BlockStateProvider.CODEC.optionalFieldOf("leaves_provider").forGetter(d -> d.leavesProvider)
    ).apply(i, BranchDecorator::new)).validate(BranchDecorator::validate);

    private static DataResult<BranchDecorator> validate(BranchDecorator decorator) {
        if (decorator.block instanceof BranchBlock) {
            return DataResult.success(decorator);
        }
        return DataResult.error(() -> "Block must be instance of BranchBlock, got " + decorator.block.getClass().getName());
    }

    public static final TreeDecoratorType<BranchDecorator> TYPE = new TreeDecoratorType<>(CODEC);

    private final float probability;
    private final Block block;
    private final int requiredEmptyBlocks;
    private final Optional<BlockStateProvider> leavesProvider;

    private BranchDecorator(float probability, Block block, int requiredEmptyBlocks, Optional<BlockStateProvider> leavesProvider) {
        this.probability = probability;
        this.block = block;
        this.requiredEmptyBlocks = requiredEmptyBlocks;
        this.leavesProvider = leavesProvider;
    }

    public static BranchDecorator createWithoutLeaves(float probability, NaturalSet set, int requiredEmptyBlocks) {
        return new BranchDecorator(probability, set.getBranch(), requiredEmptyBlocks, Optional.empty());
    }

    public static BranchDecorator create(float probability, NaturalSet set, int requiredEmptyBlocks) {
        return new BranchDecorator(probability, set.getBranch(), requiredEmptyBlocks, Optional.of(BlockStateProvider.simple(set.getLeaves())));
    }

    public static BranchDecorator create(float probability, NaturalSet set, int requiredEmptyBlocks, BlockStateProvider leavesProvider) {
        return new BranchDecorator(probability, set.getBranch(), requiredEmptyBlocks, Optional.of(leavesProvider));
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return TYPE;
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        for (BlockPos logsPos : RUUtils.shuffledCopy(context.logs(), random)) {
            Direction branchDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            BlockPos placementPos = logsPos.relative(branchDirection);
            if (!(random.nextFloat() <= this.probability) || !hasRequiredEmptyBlocks(context, placementPos)) continue;

            context.setBlock(placementPos, this.block.defaultBlockState().setValue(BranchBlock.FACING, branchDirection));
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
            if (context.isAir(offsetPos)) continue;
            return false;
        }
        return true;
    }
}
