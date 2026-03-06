package net.regions_unexplored.worldgen.treedecorator;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.ArrayList;
import java.util.List;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.regions_unexplored.world.level.block.plant.flower.RULeafLitterBlock;

public class PlaceOnGroundDecorator extends TreeDecorator {
    public static final MapCodec<PlaceOnGroundDecorator> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
        ExtraCodecs.POSITIVE_INT.fieldOf("tries").orElse(128).forGetter(p -> p.tries),
        ExtraCodecs.NON_NEGATIVE_INT.fieldOf("radius").orElse(2).forGetter(p -> p.radius),
        ExtraCodecs.NON_NEGATIVE_INT.fieldOf("height").orElse(1).forGetter(p -> p.height),
        BlockStateProvider.CODEC.fieldOf("block_state_provider").forGetter(p -> p.blockStateProvider)
    ).apply(i, PlaceOnGroundDecorator::new));
    public static final TreeDecoratorType<PlaceOnGroundDecorator> TYPE = new TreeDecoratorType<>(CODEC);

    private final int tries;
    private final int radius;
    private final int height;
    private final BlockStateProvider blockStateProvider;

    public PlaceOnGroundDecorator(int tries, int radius, int height, BlockStateProvider blockStateProvider) {
        this.tries = tries;
        this.radius = radius;
        this.height = height;
        this.blockStateProvider = blockStateProvider;
    }

    public static PlaceOnGroundDecorator leafLitter(Block block, int tries) {
        if (block instanceof RULeafLitterBlock) {
            BlockState state = block.defaultBlockState();
            SimpleWeightedRandomList.Builder<BlockState> stateList = SimpleWeightedRandomList.builder();
            for (int i = 1; i <= 4; i++) {
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    stateList.add(state.setValue(RULeafLitterBlock.FACING, direction).setValue(RULeafLitterBlock.AMOUNT, i));
                }
            }
            return new PlaceOnGroundDecorator(tries, 4, 2, new WeightedStateProvider(stateList.build()));
        }
        throw new IllegalStateException("Block must be instance of RULeafLitterBlock, got " + block.getClass().getName());
    }

    @Override
    protected TreeDecoratorType<PlaceOnGroundDecorator> type() {
        return TYPE;
    }

    @Override
    public void place(TreeDecorator.Context context) {
        List<BlockPos> blockPositions = getLowestTrunkOrRootOfTree(context);
        if (blockPositions.isEmpty()) {
            return;
        }
        BlockPos origin = blockPositions.getFirst();
        int minY = origin.getY();
        int minX = origin.getX();
        int maxX = origin.getX();
        int minZ = origin.getZ();
        int maxZ = origin.getZ();
        for (BlockPos position : blockPositions) {
            if (position.getY() != minY) continue;
            minX = Math.min(minX, position.getX());
            maxX = Math.max(maxX, position.getX());
            minZ = Math.min(minZ, position.getZ());
            maxZ = Math.max(maxZ, position.getZ());
        }
        RandomSource random = context.random();
        BoundingBox bb = new BoundingBox(minX, minY, minZ, maxX, minY, maxZ).inflatedBy(this.radius, this.height, this.radius);
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int i = 0; i < this.tries; ++i) {
            pos.set(random.nextIntBetweenInclusive(bb.minX(), bb.maxX()), random.nextIntBetweenInclusive(bb.minY(), bb.maxY()), random.nextIntBetweenInclusive(bb.minZ(), bb.maxZ()));
            this.attemptToPlaceBlockAbove(context, pos);
        }
    }

    private void attemptToPlaceBlockAbove(TreeDecorator.Context context, BlockPos pos) {
        BlockPos abovePos = pos.above();
        if (context.level().isStateAtPosition(abovePos, state -> state.isAir() || state.is(Blocks.VINE)) && context.level().isStateAtPosition(pos, state -> state.is(BlockTags.DIRT)) && context.level().getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pos).getY() <= abovePos.getY()) {
            context.setBlock(abovePos, this.blockStateProvider.getState(context.random(), abovePos));
        }
    }

    private static List<BlockPos> getLowestTrunkOrRootOfTree(TreeDecorator.Context context) {
        ArrayList<BlockPos> blockPositions = Lists.newArrayList();
        ObjectArrayList<BlockPos> roots = context.roots();
        ObjectArrayList<BlockPos> logs = context.logs();
        if (roots.isEmpty()) {
            blockPositions.addAll(logs);
        } else if (!logs.isEmpty() && roots.getFirst().getY() == logs.getFirst().getY()) {
            blockPositions.addAll(logs);
            blockPositions.addAll(roots);
        } else {
            blockPositions.addAll(roots);
        }
        return blockPositions;
    }
}

