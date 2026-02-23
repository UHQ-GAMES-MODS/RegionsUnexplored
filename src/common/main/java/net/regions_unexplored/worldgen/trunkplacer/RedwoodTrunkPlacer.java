package net.regions_unexplored.worldgen.trunkplacer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class RedwoodTrunkPlacer extends RUTrunkPlacer {
    public static final MapCodec<RedwoodTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(i -> RedwoodTrunkPlacer.heightField(i).and(
        IntProvider.NON_NEGATIVE_CODEC.listOf(4, 4).fieldOf("base_trunk_heights").forGetter(p -> p.baseTrunkHeights)
    ).apply(i, RedwoodTrunkPlacer::new));
    public static final TrunkPlacerType<RedwoodTrunkPlacer> TYPE = new TrunkPlacerType<>(CODEC);

    protected final List<IntProvider> baseTrunkHeights;

    public RedwoodTrunkPlacer(IntProvider height, List<IntProvider> baseTrunkHeights) {
        super(height);
        this.baseTrunkHeights = baseTrunkHeights;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return TYPE;
    }

    @Override
    public List<FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> trunkSetter, RandomSource random, int treeHeight, BlockPos origin, TreeConfiguration config) {
        List<FoliageAttachment> attachments = new ArrayList<>();
        // Base trunk
        placeLogColumn(level, trunkSetter, random, origin, treeHeight, config);
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            placeLogColumn(level, trunkSetter, random, origin.relative(direction, 1), getTrunkHeight(random, 0), config);
            placeLogColumn(level, trunkSetter, random, origin.relative(direction).relative(direction.getClockWise()), getTrunkHeight(random, 1), config);
            placeLogColumn(level, trunkSetter, random, origin.relative(direction, 2), getTrunkHeight(random, 2), config);
            placeLogColumn(level, trunkSetter, random, origin.relative(direction, 2).relative(direction.getClockWise()), getTrunkHeight(random, 3), config);
            placeLogColumn(level, trunkSetter, random, origin.relative(direction).relative(direction.getClockWise(), 2), getTrunkHeight(random, 3), config);
        }

        // Branches
        BlockPos.MutableBlockPos placePos = origin.mutable().move(Direction.UP, treeHeight);
        attachments.add(attachment(placePos.immutable()));

        for (int i = 0; i < 2; i++) {
            placePos.move(Direction.DOWN, 3);
            placeBranch(placePos, random, trunkSetter, attachments, config, 1);
        }

        for (int i = 0; i < (random.nextInt(6) == 0 ? 3 : 2); i++) {
            placePos.move(Direction.DOWN, 3);
            placeBranch(placePos, random, trunkSetter, attachments, config, 2);
        }

        for (int i = 0; i < (random.nextInt(6) == 0 ? 3 : 2); i++) {
            placePos.move(Direction.DOWN, 3);
            placeBlobsAround(attachments, placePos);
            placeBranch(placePos, random, trunkSetter, attachments, config, 3);
        }

        placePos.move(Direction.DOWN, 3);
        placeBlobsAround(attachments, placePos);
        placeBranch(placePos, random, trunkSetter, attachments, config, 4);

        return attachments;
    }

    private int getTrunkHeight(RandomSource random, int index) {
        return this.baseTrunkHeights.get(index).sample(random);
    }

    private void placeBlobsAround(List<FoliageAttachment> foliageSetter, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            foliageSetter.add(attachment(pos.relative(direction).relative(direction.getClockWise())));
        }
    }

    private void placeBranch(BlockPos pos, RandomSource random, BiConsumer<BlockPos, BlockState> trunkSetter, List<FoliageAttachment> foliageSetter, TreeConfiguration config, int length) {
        Direction.Axis axis = Direction.Plane.HORIZONTAL.getRandomAxis(random);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos.MutableBlockPos currentPos = pos.mutable();
            if (axis != direction.getAxis()) currentPos.move(Direction.DOWN);

            for (int i = 0; i < length; i++) {
                currentPos.move(direction);
                BlockState state = config.trunkProvider.getState(random, pos);
                if (state.hasProperty(RotatedPillarBlock.AXIS)) {
                    state = state.setValue(RotatedPillarBlock.AXIS, direction.getAxis());
                }
                trunkSetter.accept(currentPos.immutable(), state);
            }
            foliageSetter.add(attachment(currentPos.immutable()));
        }
    }

    private void placeLogColumn(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> trunkSetter, RandomSource random, BlockPos pos, int columnHeight, TreeConfiguration config) {
        if (columnHeight == 0) return;
        RUTrunkPlacer.placeDirtBelow(level, trunkSetter, pos);

        BlockPos.MutableBlockPos currentPos = pos.mutable();
        for (int y = 0; y < columnHeight; y++) {
            if (TreeFeature.validTreePos(level, currentPos) || level.isStateAtPosition(pos, state -> state.is(BlockTags.LOGS))) {
                trunkSetter.accept(currentPos.immutable(), config.trunkProvider.getState(random, currentPos));
                currentPos.move(Direction.UP);
                continue;
            }
            return;
        }
    }
}
