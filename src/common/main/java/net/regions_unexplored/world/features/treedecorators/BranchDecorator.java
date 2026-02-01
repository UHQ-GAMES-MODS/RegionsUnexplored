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
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.regions_unexplored.util.RUUtils;
import net.regions_unexplored.world.level.block.plant.branch.BranchBlock;

import java.util.List;

public class BranchDecorator extends TreeDecorator {
    private static final List<Direction> HORIZONTAL_DIRECTIONS = List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    public static final MapCodec<BranchDecorator> CODEC = RecordCodecBuilder.<BranchDecorator>mapCodec(i -> i.group(
        Codec.floatRange(0, 1).fieldOf("probability").forGetter(d -> d.probability),
        BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(d -> d.block),
        Codec.intRange(0, 16).fieldOf("required_empty_blocks").forGetter(d -> d.requiredEmptyBlocks)
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

    public BranchDecorator(float probability, Block block, int requiredEmptyBlocks) {
        this.probability = probability;
        this.block = block;
        this.requiredEmptyBlocks = requiredEmptyBlocks;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return TYPE;
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        for (BlockPos logsPos : RUUtils.shuffledCopy(context.logs(), random)) {
            Direction direction = RUUtils.getRandom(HORIZONTAL_DIRECTIONS, random);
            BlockPos placementPos = logsPos.relative(direction);
            if (!(random.nextFloat() <= this.probability) || !hasRequiredEmptyBlocks(context, placementPos)) continue;
            context.setBlock(placementPos, this.block.defaultBlockState().setValue(BranchBlock.FACING, direction));
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
